import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Arrays;
import java.util.Scanner;

public class Server {

	public static void main(String[] args) {

    try {
		DatagramSocket serverSocket = new DatagramSocket() ;
		
		Scanner scanner= new Scanner(System.in);
		 System.out.println(" Server is booted up");
		 
		 Session clientsession=new Session(serverSocket);
		 clientsession.start();
		 
    

    
    } catch (SocketException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	}

}
