package com.upec.secu.clients;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;
import com.upec.secu.clients.SymmetricKeyManager;

public class ConnectionChat extends Connection{
	/*
	 * That class take in constructor the session key to use and the socket on which dialog.
	 */
	byte[] key; // Our session key
	
	public ConnectionChat(String ip, Integer port, Socket s, byte[] key) {
		super(ip,port);
		this.s = s;
		this.key = key;
	}
	
	public void bind() { //Method that will be called instead of connect. It basically do the same but not connect on the socket.
		try {
			this.out = new DataOutputStream(this.s.getOutputStream());
			this.in = new DataInputStream(new DataInputStream(this.s.getInputStream()));
		} catch (IOException e) {
			this.finishedOK = false;
		}
	}
	
	
	public void run() {
		InputThread th = new InputThread(this.out); //Instantiate our private class InputThread. (take in args the outpustream on which write)
		th.start(); // Start the thread
		
		byte[] received;
		String inputmessage;
		try {
			for(;;) { // Infinite loop
				
				if(th.ended) //Check if the user want to quit (having typed quit) and then break
					break;
				
				received = this.read(); // Read on the socket
				inputmessage = new String(SymmetricKeyManager.decipher(key, received)); // Decipher the message
				if (inputmessage.equals("bye")) { // If the message is bye we write it back and close.
					this.out.write(SymmetricKeyManager.cipher(key, "bye".getBytes()));
					if (!(th.ended))
						System.out.println("Client said bye\n Please Press a Key..");
					break;
				}
					System.out.println(inputmessage);
			}
			this.finishedOK = true; 
			th.dieNow = true; //Tell the thread to die if it's not already the case
		}
		catch(IOException e) { // Catch the various exceptions that can occur.
			if (th.ended)
				this.finishedOK = true;
			else {
				this.errormessage =  "Connnection closed";
				this.finishedOK = false;
			}
		}
		catch(Exception e ) {
			this.errormessage = "Error while trying to decrypt";
			this.finishedOK = false;
		}
		finally{
			th.dieNow = true;
			try {
				if(!(th.ended)) //Join the tread nicely
					th.join();
			} catch (InterruptedException e) {e.printStackTrace();}
		}
	}

	
	private class InputThread extends Thread implements Runnable {
		/*
		 * Private class that loop on the keyboard input and cipher the message in order to send it to the socket.
		 */
		String outputmessage;
		OutputStream out;
		boolean ended = false;
		boolean dieNow = false;
		
		public InputThread(OutputStream o) {
			this.out = o;
		}
		
		public void run()  {
			try {
				Scanner sc = new Scanner(System.in);
				for(;;) {
					if(dieNow)
						break;
					outputmessage = sc.nextLine(); // Read the line
					if(outputmessage.equals("quit")) { //If what was typed is quit then we write bye. And the thread will finished by itself
						this.out.write(SymmetricKeyManager.cipher(key,"bye".getBytes()));
						break;
					}
					else
						this.out.write(SymmetricKeyManager.cipher(key,outputmessage.getBytes())); // Otherwise we just cipher and send
				}
			}
			catch(IOException e) {
				//Do nothing the thread will gently die
			}
			catch(Exception e) {
				e.printStackTrace();
				System.out.println("Error while trying to cipher");
			}
			finally {
				ended= true;
			}
		}
	}	
}
