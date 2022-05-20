import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Arrays;
import java.util.Scanner;

public class Session extends Thread {
	DatagramSocket serverSocket;
	public Session(DatagramSocket serverSocket) {
		this.serverSocket=serverSocket;
	}
	
	@Override
	public void run() {
	DatagramSocket serverSocket;
	try {
		serverSocket = new DatagramSocket(4000);

		
		Scanner scanner= new Scanner(System.in);
		
		 while(true) {
		    	
		    	
		    	byte[] requestBuffer= new byte[500];
		    	DatagramPacket  requestPacket= new DatagramPacket(requestBuffer, requestBuffer.length);
		    	serverSocket .receive(requestPacket);
		    	
		    	String request= new String(requestPacket.getData());
		    	System.out.println("Client:"+request.trim());
		    	 
		    		
		    	 
		    		 byte[] requestBuffer2= new byte[500];
		     	DatagramPacket  requestPacket2= new DatagramPacket(requestBuffer2, requestBuffer2.length);
		     	serverSocket.receive(requestPacket2);
		     	String request2= new String(requestPacket2.getData());
		     	System.out.println("Client:"+request2.trim());
		        ///Request 2
		    	  
		         if(request2.startsWith("1")){ 
		        	 String s= request.trim();
		        	 String [] x =  s.split(",");
		             int y=x.length;
		             int [] intArray = new int[y];
		             for(int i = 0; i < y; i++) {
		                     intArray[i] = Integer.parseInt(x[i]);
		                   }
		             Arrays.sort(intArray);
		        
		            String reply=  Arrays.toString(intArray);
		            byte[] replyBytes= reply.getBytes();
		            int replyLength= replyBytes.length;
		            InetAddress clientIp = requestPacket.getAddress();
		            int clientPort= requestPacket.getPort();
		            
		            DatagramPacket replyPacket= new DatagramPacket(replyBytes, replyLength, clientIp, clientPort);
					serverSocket.send(replyPacket);
		            
		        
		         }
		         
		         else if (request2.startsWith("2")){
		        	 String s= request.trim();
		        	 String [] x =  s.split(",");
		             int y=x.length;
		             int [] intArray = new int[y];
		             int [] revArray = new int[y];
		             for(int i = 0; i < y; i++) {
		                     intArray[i] = Integer.parseInt(x[i]);
		                   }
		             Arrays.sort(intArray);
		           int j = y;
		            for (int i = 0; i < y; i++) {
		                  revArray[j - 1] = intArray[i];
		                   j = j - 1;
		             }
		         
		          String reply=  Arrays.toString(revArray);
		          byte[] replyBytes= reply.getBytes();
		          int replyLength= replyBytes.length;
		          InetAddress clientIp = requestPacket.getAddress();
		          int clientPort= requestPacket.getPort();
		          
		          DatagramPacket replyPacket= new DatagramPacket(replyBytes, replyLength, clientIp, clientPort);
					serverSocket.send(replyPacket);
		          
		         }
		         
		        
		         else {
		        	 String reply= "wrong  choice";
		             byte[] replyBytes= reply.getBytes();
		             int replyLength= replyBytes.length;
		             InetAddress clientIp = requestPacket.getAddress();
		             int clientPort= requestPacket.getPort();
		             
		             DatagramPacket replyPacket= new DatagramPacket(replyBytes, replyLength, clientIp, clientPort);
		   			serverSocket.send(replyPacket);
		             
		         }
		    	
		    	
		    	
		    	 }
	} catch (SocketException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}    
	}
}
