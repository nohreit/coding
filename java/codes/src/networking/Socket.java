package networking;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;

public class Socket {
	
	private int myPortNumber;
	private InetAddress myIPAddress;
	private DatagramSocket socket;

	public int getMyPortNumber() {
		return myPortNumber;
	}

	public DatagramSocket getSocket() {
		return socket;
	}

	public InetAddress getMyIPAddress() {
		return myIPAddress;
	}

	public void setMyIPAddress(InetAddress myIPAddress) {
		this.myIPAddress = myIPAddress;
	}

	public void setMyPortNumber(int myPortNumber) {
		this.myPortNumber = myPortNumber;
	}

	public void setSocket(DatagramSocket socket) {
		this.socket = socket;
	}

	public Socket(int myPortNumber, boolean broadcast) {
		
		this.myPortNumber = myPortNumber;
		try {
			this.myIPAddress = InetAddress.getLocalHost(); // get the IP address of the local machine
		}
		catch(UnknownHostException e) {
			System.out.println(e.getMessage());
			System.exit(-1);
		}
		
		System.out.println("My IP address is " + this.myIPAddress.getHostAddress());

		try {
			
			if(broadcast) {
				/*
				 * Open the socket to accept any messages at myPortNumber
				 */
				this.socket = new DatagramSocket(myPortNumber);
			}else{
				/*
				 * Open the socket to accept a message at myPortNumber and MyIpAddress
				 */
				this.socket = new DatagramSocket(myPortNumber, myIPAddress );
			}
		}
		catch(SocketException e) {
			System.out.println(e.getMessage());
			System.exit(-1);
		}
	}
	
	
	public void send(String message, InetAddress destinationIpAddress, int destinationPortNumber) {
		
		byte [] outBuffer = message.getBytes();
		//int [] a = new int[10];
		//System.out.println(a.length);
		
		DatagramPacket outGoingPacket = null; 
		outGoingPacket = new DatagramPacket(outBuffer, outBuffer.length, destinationIpAddress, destinationPortNumber);
		
		
		try {
			socket.send(outGoingPacket);
		}
		catch(IOException e) {
			System.out.println(e.getMessage());
			System.exit(-1);
		}
	}
	
	
	public DatagramPacket receive() {
		
		byte [] incomingBuffer = new byte[1024];
	
		
		DatagramPacket inComingPacket = new DatagramPacket(incomingBuffer, incomingBuffer.length);
		
		try {
			socket.receive(inComingPacket);
		}catch(IOException e) {
			System.out.println(e.getMessage());
			System.exit(-1);
		}
		
		return inComingPacket;
	}

	public void close(){
		socket.close();
	}

//	public static void p(Object o) {
//		System.out.print(o);
//	}
//
//	public static void pln(Object o) {
//		System.out.println(o);
//	}

}
