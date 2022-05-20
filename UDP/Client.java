

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {

	public static void main(String[] args) {
		try {
			DatagramSocket clientSocket= new DatagramSocket();
		     Scanner scanner= new Scanner (System.in);
		     
		while(true) {
			
			System.out.println("Please enter the list of numbers to be arranged or 'close' to close.");
			String request = scanner.nextLine();
			if(request.equalsIgnoreCase("close")) {
				clientSocket.close();
				System.out.println("Client is terminated");
				break;
				
			}
			else {
				byte[] requestBytes= request.getBytes();
				int requestLength= requestBytes.length;
				InetAddress serverIp= InetAddress.getByName("localhost");
				int serverPort= 4000;
				
				DatagramPacket requestPacket= new DatagramPacket(requestBytes, requestLength, serverIp, serverPort);
				clientSocket.send(requestPacket);
				
				System.out.println("Please choose:\r\n"+ "1. Ascending order.\r\n"+ "2. Descending order.");
				String request2 = scanner.nextLine();
				byte[] requestBytes2= request2.getBytes();
				int requestLength2= requestBytes2.length;
				InetAddress serverIp2= InetAddress.getByName("localhost");
				int serverPort2= 4000;

				DatagramPacket requestPacket2= new DatagramPacket(requestBytes2, requestLength2, serverIp2, serverPort2);
				clientSocket.send(requestPacket2);
				
				
				byte[] replytBuffer= new byte[5000];
		    	DatagramPacket  replyPacket= new DatagramPacket(replytBuffer, replytBuffer.length);
		    	clientSocket.receive(replyPacket);
		    	String reply= new String(replyPacket.getData());
		    	System.out.println("server:"+reply.trim());
	
		}
		
		
		}
		} catch (SocketException | UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
