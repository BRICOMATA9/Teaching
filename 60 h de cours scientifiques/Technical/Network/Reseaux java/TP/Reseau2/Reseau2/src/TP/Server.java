import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Set;

public class Server{

	private ServerSocketChannel incomeSocket;
	private Selector selector;
	private ByteBuffer buff = ByteBuffer.allocate(1024);

	public Server(int port) throws IOException {
	
		InetSocketAddress addr = new InetSocketAddress(port);
		selector = Selector.open();
		
		incomeSocket = ServerSocketChannel.open();
		incomeSocket.configureBlocking(false);
		incomeSocket.socket().bind(addr);
		incomeSocket.register(selector,SelectionKey.OP_ACCEPT);
	}

	public void run() throws IOException{
		while(true){
			selector.select();
			Set<SelectionKey> selectedKeys = selector.selectedKeys();
			for(SelectionKey k : selectedKeys){
				if(k.isAcceptable()){
					accept();
				}else{
					repeat(k);
				}
			}
			selectedKeys.clear();
		}
	}

	void accept(){
		try{
			SocketChannel ns = incomeSocket.accept();
			System.out.println("New␣client"+ns);
			ns.configureBlocking(false);
			ns.register(selector,SelectionKey.OP_READ);
		}catch(IOException e){
			System.out.println("Fail␣to␣accept␣new␣client:␣"+e);
		}
	}

	void repeat(SelectionKey k){
		SocketChannel s = (SocketChannel)k.channel();
		try{
			buff.clear();
			int n = s.read(buff);
			if(n == -1)
			throw new IOException("Client␣Close␣Connection");
			buff.flip();
			for(SelectionKey c : selector.keys()){
				if(((c.interestOps() & SelectionKey.OP_READ)!=0) && c!=k){
					SocketChannel sc = (SocketChannel)c.channel();
					buff.rewind();
					while(buff.hasRemaining()){
						sc.write(buff);
					}
				}
			}
		} catch (IOException e){
			System.out.println("Client␣left") ;
			try {
				s.close ();
			}catch(IOException e2) {}
			k.cancel ();
		}
	}

	public static void main(String[] args){
		try{
			//System.out.println("Build␣server");
			Server s = new Server(9090);
			//System.out.println("Start␣server");
			s.run();
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}

