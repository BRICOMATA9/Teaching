import java.io.IOException;
import java.net.*;
import java.nio.*;
import java.nio.channels.*;
import java.util.*;

public class NIOTest extends Thread {

	private String hostname;
	private Vector<String> poolRequests;
	private Vector<String> poolPageDownload;

	private SocketChannel socketChannel;
	private Selector selector;

	private ByteBuffer readByteBuffer;
	private StringBuffer tmpPageDownload; // to save temporary download content

	public NIOTest(String hostname){
		this.hostname = hostname;
		poolRequests = new Vector();
		poolPageDownload = new Vector();
	}

	/**
	* @param hostname : dns name of server that we will send request to.
	* @param pagePath : path of page request on server.
	* @return return a standard HTTP GET Request to server.
	*/
	private String generateGetRequest(String hostname, String pagePath) {
		return "GET " + pagePath + " HTTP/1.1 \n"
		+ "Host: " + hostname + "\n"
		+ "Accept: text/* \n"
		+ "Connection: Keep-Alive \n"
		+ "Accept-Encoding: gzip,deflate\n"
		+ "Accept-Charset: ISO-8859-1,utf-8;q=0.7,*;q=0.7\n"
		+ "\n";
	}

	/*
	* Initialize all the SocketChannel, Selector and read buffer, write buffer
	* poolRequest.
	*/

	private void initialize() {
		//Open Selector:
		try {
			selector = Selector.open();
		} catch (IOException e) {
			e.printStackTrace();
		}

		readByteBuffer = ByteBuffer.allocate(500);
		tmpPageDownload = new StringBuffer();
		//Open SocketChannel, register channel to selector
		try{
			socketChannel = SocketChannel.open();
			socketChannel.configureBlocking(false);
			SocketAddress socketAddress = new InetSocketAddress(hostname,80);
			socketChannel.connect(socketAddress);
			socketChannel.register(selector, SelectionKey.OP_CONNECT);
			socketChannel.socket().setKeepAlive(true);
		}
		catch (IOException e) {
			e.printStackTrace();
		}
	}

	/*
	* ConnectionThread run! Open many connection, wait for write, read...
	*/
	public void run() {
		//Initialize
		initialize();
		// Finish Connection
		try{
			socketChannel.finishConnect();
		}
		catch (IOException e )
		{
			e.printStackTrace();//TODO
		}

		//Waiting for connect, write and read
		int countActiveChannel = 0;
		Set readyKeys;
		Iterator iterator;
		while (true) {
			try{
				countActiveChannel = selector.select();
			}catch(IOException e){
				e.printStackTrace();
			}

			if (countActiveChannel == 0) continue;
			System.out.println("Selector active " + countActiveChannel + " channel");
			readyKeys = selector.selectedKeys();
			iterator = readyKeys.iterator();

			while (iterator.hasNext()) {
				SelectionKey key = (SelectionKey) (iterator.next());
				// Remove key from set so we don't process it twice
				iterator.remove();
				if (!key.isValid()) {
					System.out.println("invalid key");
					continue;
				}
				// operate on the channel...
				//switch to wait to send request status (OP_WRITE)
				if(key.isConnectable()){
					try{
						if(((SocketChannel)key.channel()).finishConnect()){
							key.interestOps(SelectionKey.OP_WRITE);
							System.out.println("Connected, waiting for writing");
						}	else {
							System.out.println("Not connected yet!");
						}
					}catch(IOException e) {
						e.printStackTrace();
						continue;
					}
					continue;
				}
				//read data from server
				if (key.isReadable()) {
					System.out.println("Readable channel ");
					readData(key);
					continue;
				}

				//Write/send request to server
				if (key.isWritable()) {
					System.out.println("writable channel ");
					writeRequest(key);
				}
			}
		}
	}

	/**
	* Send HTTP GET request a page to server, according to SocketChannel that is active to write.
	* @param key : SelectionKey: to determine which channel, correspondent to
	* this key is active for writing request.
	* @return 0 if request is written, -1 if out of request, 1 if the key not correspondent with any socketchannel
	*/
	private int writeRequest(SelectionKey key) {
		//the channel is ready to write request to server
		if (poolRequests == null || poolRequests.size() == 0) {
			System.out.println("Request empty!");
			this.stop();
			return -1;
		}
		//Get page path from pool of requests.
		String pagePath = poolRequests.remove(0);
		//Generate request
		String request = generateGetRequest(hostname, pagePath);
		ByteBuffer buf = ByteBuffer.wrap(request.getBytes());
		try {
			while(buf.hasRemaining()){
				socketChannel.write(buf);
			}
			System.out.println("We have sent a request: ");
			System.out.println(request);
			//Change status of waiting: waiting for reading
			key.interestOps(SelectionKey.OP_READ);
			//The first line in pageDownload is pagePath
			tmpPageDownload.append(pagePath + "\n");
		} catch (IOException e) {
			e.printStackTrace();
			return -2;
		}
		return 0;
	}

	/**
	* Read data response from server, correspondent with SocketChannel of 'key' .
	* All data read in each time will be appended in an temporary buffer.
	* When reach to end of file, all data from temporary buffer will be put to
	* poolData, to transfer to DataProcessingThread.
	* @param key : SelectionKey, to determine which SocketChannel is active to read.
	*/
	private void readData(SelectionKey key) {
		int n= 0;
		if (((SocketChannel) key.channel()).socket().isClosed()) {
			System.out.println("Socket closed");
			this.stop();
		}
		//the channel i is ready to read data from server
		try {
			n = socketChannel.read(readByteBuffer);
			if (n > 0) {
				readByteBuffer.flip();
				String bufContent = new String(readByteBuffer.array(), 0, n);
				tmpPageDownload.append(bufContent);
				readByteBuffer.clear();
				System.out.println("Read a part ..." + n + " bytes");
			} else if (n == -1) { //end of data transfer 
				System.out.println("End of stream data");
				System.out.println("We have receive from server: ");
				System.out.println(tmpPageDownload);

				poolPageDownload.add(tmpPageDownload.toString());

				//clear tmpPageDownload to receive new page download.
				tmpPageDownload.delete(0, tmpPageDownload.length() + 1);

				//Change status of waiting: wait for write new request
				key.interestOps(SelectionKey.OP_WRITE);
			}
		} catch (IOException e) {
			e.printStackTrace();//TODO
		}
	}

	public void addRequest(String pagePath){
		poolRequests.add(pagePath);
	}

	public static void main(String[] args) {
		String hostname;
		if(args.length >0 ) hostname = args[0];
		else hostname = "yahoo.com";
		NIOTest nio = new NIOTest(hostname);
		//add some page paths to request pool
		//You can add more request here!
		nio.addRequest("/");
		nio.addRequest("/");
		nio.start();
	}
}
