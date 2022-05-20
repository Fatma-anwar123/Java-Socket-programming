package task22;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.InetAddress;
import java.net.SocketException;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Arrays;
import java.io.*;
import java.util.Random;
public class server {
	
	public static void main(String[] args) {
		try {
			
			ServerSocket server=new ServerSocket(5179);
			 
			while(true) {
				
				Socket clientSocket=server.accept();
				DataInputStream input = new DataInputStream(clientSocket.getInputStream());
				DataOutputStream output = new DataOutputStream(clientSocket.getOutputStream());
			
			System.out.println("Please enter the server name and port number.");
			
			Scanner scanner=new Scanner(System.in);
			String request =scanner.nextLine();
			int i=Integer.parseInt(request);  
			
			Scanner scanner2=new Scanner(System.in);
			String requestname =scanner2.nextLine();
			
			
			
			
			
			
			String path = "C:\\Users\\HP\\Desktop\\New folder\\task22\\";    
		      path = path+requestname;
		      File filee = new File(path+"\\credentials");
		      
		      File file = new File("dataserver.txt");
		      BufferedReader br;
			
				br = new BufferedReader(new FileReader(file));
				int flag=0;
				  String st;
				  while ((st = br.readLine()) != null)
				  {
				    if(st.contains(requestname))
				    {
				    	flag=1;
				    	
				    	
				    					    
				    }
				    
				  }
				  
				  if(flag==0)
				  {
					  FileWriter myWriter = new FileWriter("dataserver.txt",true);
				      myWriter.write(requestname+"  "+i+"\n");
				      myWriter.close();
			       
			      File f1 = new File(path);  
			      boolean bool = f1.mkdir();  
			      if(bool){  
			    	 
			          filee.createNewFile();
			          
			          
			         
			          
			         System.out.println("Folder is created successfully");  
			      }else{  
			         System.out.println("Error Found!");  
			      }
			      
			      
				
				  }
				  
		
		          
			//specificserver window=new specificserver(i);
				  session clientSession=new session(server,clientSocket,input,output);
					clientSession.start();
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
