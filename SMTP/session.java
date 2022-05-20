package task22;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.util.Scanner;
import java.net.DatagramSocket;
import java.util.Arrays;
import java.net.ServerSocket;
import java.net.Socket;


public class session extends Thread {
	Socket clientSocket;
	ServerSocket server;
	private DataInputStream input;
	private DataOutputStream output;
	public session(ServerSocket server,Socket clientSocket,DataInputStream input,DataOutputStream output)
	{
		this.server=server;
		this.clientSocket=clientSocket;
		this.input=input;
		this.output=output;
	}
	
@Override
public void run()
{
	
	
	while(true){
		try {
		
			  String conn1=input.readUTF();
			 
			  
			  int k=Integer.parseInt(conn1);
			  File file = new File("dataserver.txt");
			  BufferedReader br;
				
			  br = new BufferedReader(new FileReader(file));
				int flag=0;
				  String st;
				  while ((st = br.readLine()) != null)
				  {
				    if(st.contains(conn1))
				    {
				    	st= st.substring(0, st.indexOf(" ")); 
				    	break;
				    	
				    	
				    					    
				    }
				    
				  }
			

  
  

			  String conn=input.readUTF();
		    System.out.println("now server is : "+conn);
		    ServerSocket server2=new ServerSocket(k);
			Socket clientSocket2=server2.accept();
			System.out.println("server with port number "+conn1+" is booted up *_*");
			String path = "C:\\Users\\HP\\Desktop\\New folder\\task22\\";    
			  path = path+st;
			  File filee = new File(path+"\\credentials");
			  
			DataInputStream input2 = new DataInputStream(clientSocket2.getInputStream());
			DataOutputStream output2 = new DataOutputStream(clientSocket2.getOutputStream());
			
			  
			  BufferedReader brr = new BufferedReader(new FileReader(filee));
			  
			  
			  
			  
			  
	          output2.writeUTF("Please choose ‘REGISTER or ‘LOGIN’ or ‘QUIT’.");
	          String choice=input2.readUTF();
	          output2.writeUTF("Please enter an email and a password."); 
	          String  Email=input2.readUTF(); 
	            String Name[]= Email.split("@");
	            
	            String  pass=input2.readUTF();
	            
	            
	            
	            
	            
	            if(choice.equalsIgnoreCase("REGISTER")) 
	            { 
	               String ST;
	                int index=0;
	                boolean usernameExist=false;
	               try {
	    
	                FileWriter wwrite = new FileWriter(filee,true); 
	                PrintWriter pw=new PrintWriter(wwrite);
	                
	                while ((ST = brr.readLine()) != null)
	                {
	                String segments[] = ST.split(":");
	                if(Name[0].equalsIgnoreCase(segments[1]))
	                {
	                    usernameExist=true;
	                }
	                }
	               if(usernameExist==true)
	               {
	            	   output2.writeUTF("Username already exist");
	               }
	               
	               else
	               {
	                StringBuffer sb = new StringBuffer();
	                for(int i2 = 0; i2 < Name.length; i2++) {
	                sb.append(Name[i2]);
	                }
	                String str = sb.toString();
	                pw.write("Username :"); 
	                pw.write(Name[0]); 
	                pw.write("\n"); 
	                pw.write("Password :"); 
	                pw.write(pass); 
	                pw.write("\n"); 
	                pw.close();
	                output2.writeUTF("Registeration is done successfully ");
	                File Dir=new File (path+"\\"+str);
	                Dir.mkdir();
	                String path2=Dir.getPath();
	                filee=new File(path2+"/inbox.txt");
	                 filee.createNewFile();
	                 filee=new File(path2+"/outbox.txt");
	              filee.createNewFile();
	                }
	               
	               
	               
	               
	               
	               
	               while(true) {
	    	           
	            	   output2.writeUTF("Please choose ‘Send’  or ‘sendtomany’or ‘QUIT’.");
	            	   String Choice2=input2.readUTF();
		               
		                if(Choice2.toLowerCase().equals("quit")){
		                	 output2.writeUTF("closing connection ");
		                    break;
		                }
		                else if(Choice2.toLowerCase().equals("send")){
		                	output2.writeUTF("Mail from : ");
		                	 String Emailsend=input2.readUTF();
		                	 output2.writeUTF("Server: 250 " +  Emailsend + " ...Sender ok");
		                	 
		                	 output2.writeUTF("RCP_TO : ");
		                	 String  Receiver=input2.readUTF();
		                   
		                    int index2=Receiver.indexOf('@');       
		                    String SereverRCPT=Receiver.substring(index2+1);
		                    int index3=Receiver.indexOf('.'); 
		                    String serverr=Receiver.substring(index2+1,index3);
		                    String SereverName=Receiver.substring(0,index2);
		                    
		                    int index22=Emailsend.indexOf('@');       
		                    String SereverRCPT2=Emailsend.substring(index22+1);
		                    int index32=Emailsend.indexOf('.'); 
		                    String serverr2=Emailsend.substring(index22+1,index32);
		                    String SereverName2=Emailsend.substring(0,index22);
		                    
		                    StringBuffer sb = new StringBuffer();
			                for(int i2 = 0; i2 < Name.length; i2++) {
			                sb.append(Name[i2]);
			                }
			                String str = sb.toString();
		                    
		                    
		                    
		                    output2.writeUTF( "Server: 250 "+Receiver+" ...Recipient ok");
		          
		                    
		                    output2.writeUTF("Server: Please enter the body of your email ended by ‘&&&‘");
		        
		                    String strr=input2.readUTF();
		                    
		                   FileWriter inbox = new FileWriter("C:\\Users\\HP\\Desktop\\New folder\\task22\\" +serverr+"\\"+  SereverName + "/inbox.txt",true);
		                  // PrintWriter FileWrite=new PrintWriter(inbox);
		                    BufferedWriter FileWrite = new BufferedWriter(inbox);
		                    FileWrite.write(Receiver+": "+strr+"\n");
		                    FileWrite.close();
		                    
		                    
		                    FileWriter outbox = new FileWriter("C:\\Users\\HP\\Desktop\\New folder\\task22\\" +serverr2+"\\"+  SereverName2 + "/outbox.txt",true);
		                    BufferedWriter FileWrite2 = new BufferedWriter(outbox);
		                    FileWrite2.write(Receiver+": "+strr+"\n");
		                    FileWrite2.close();
		                }
		                else if(Choice2.toLowerCase().equals("sendtomany")){
		                	output2.writeUTF("how many you need to send to : ");
		                	String manys=input2.readUTF();
		                	int many=Integer.parseInt(manys);
		                	
		                	
		                	output2.writeUTF("Mail from : ");
		                	 String Emailsend=input2.readUTF();
		                	 output2.writeUTF("Server: 250 " +  Emailsend + " ...Sender ok");
		                	 output2.writeUTF("Server: Please enter the body of your email ended by ‘&&&‘");
		         	        
			                    String strr=input2.readUTF();
		                	 
		           while(many!=0) {
		                	 
		                	 
		        	   
	                	 output2.writeUTF("RCP_TO : ");
	                	 String  Receiver=input2.readUTF();
	                   
	                    int index2=Receiver.indexOf('@');       
	                    String SereverRCPT=Receiver.substring(index2+1);
	                   
	                    int index3=Receiver.indexOf('.'); 
	                    String serverr=Receiver.substring(index2+1,index3);
	                   
	                    String SereverName=Receiver.substring(0,index2);

	                    int index22=Emailsend.indexOf('@');       
	                    String SereverRCPT2=Emailsend.substring(index22+1);
	                    int index32=Emailsend.indexOf('.'); 
	                    String serverr2=Emailsend.substring(index22+1,index32);
	                    String SereverName2=Emailsend.substring(0,index22);
	                    output2.writeUTF( "Server: 250 "+Receiver+" ...Recipient ok");
	                    
	                    
	                    StringBuffer sb = new StringBuffer();
		                for(int i2 = 0; i2 < Name.length; i2++) {
		                sb.append(Name[i2]);
		                }
		               
	          
	                    
	                    
	                   FileWriter inbox = new FileWriter("C:\\Users\\HP\\Desktop\\New folder\\task22\\" +serverr+"\\"+  SereverName + "/inbox.txt",true);
	                  // PrintWriter FileWrite=new PrintWriter(inbox);
	                    BufferedWriter FileWrite = new BufferedWriter(inbox);
	                    FileWrite.write(Emailsend+": "+strr+"\n");
	                    FileWrite.close();
	                    
	                    FileWriter outbox = new FileWriter("C:\\Users\\HP\\Desktop\\New folder\\task22\\" +serverr2+"\\"+  SereverName2 + "/outbox.txt",true);
	                    BufferedWriter FileWrite2 = new BufferedWriter(outbox);
	                    FileWrite2.write(Receiver+": "+strr+"\n");
	                    FileWrite2.close();
	                    many--;
		                	 }
		                	
		                }

		                
	               }
		                
	               
	               }
	               
	               
	               
	               catch (Exception e) { 
	                 e.printStackTrace(); 
	                 } 
	            } 

	else if(choice.equalsIgnoreCase("LOGIN"))
	            {
	               
	               
	                brr = new BufferedReader(new FileReader(filee));
	                String stt;
	                int index=0;
	                int CountName=0;
	                int CountPass=0;
	                boolean usernameExist=false;
	                boolean passwordExist=false; 
	                while ((stt = brr.readLine()) != null)
	                {
	                String segments[] = stt.split(":");
	                if(Name[0].equalsIgnoreCase(segments[1]))
	                {
	                    usernameExist=true;
	                    CountName=index;
	                }
	                if(pass.equalsIgnoreCase(segments[1]))
	                {
	                    passwordExist=true;
	                    CountPass=index;
	                }
	                index++;
	                }
	               if(usernameExist==true&&passwordExist==true&&CountPass==CountName+1)
	               {
	            	   output2.writeUTF("You logged in successfully");
	               }
	               else
	               {
	            	   output2.writeUTF("Error ");
	            	   break;
	               }
	               
	               

	               while(true) {
	    	           
	            	   output2.writeUTF("Please choose ‘Send’ or ‘ShowInbox’ or ‘SendToMany’or ‘QUIT’.");
	            	   String Choice2=input2.readUTF();
		               
		                if(Choice2.toLowerCase().equals("quit")){
		                	 output2.writeUTF("closing connection ");
		                    break;
		                }
		                else if(Choice2.toLowerCase().equals("send")){
		                	output2.writeUTF("Mail from : ");
		                	 String Emailsend=input2.readUTF();
		                	 output2.writeUTF("Server: 250 " +  Emailsend + " ...Sender ok");
		                	 
		                	 output2.writeUTF("RCP_TO : ");
		                	 String  Receiver=input2.readUTF();
		                   
		                    int index2=Receiver.indexOf('@');       
		                    String SereverRCPT=Receiver.substring(index2+1);
		                   
		                    int index3=Receiver.indexOf('.'); 
		                    String serverr=Receiver.substring(index2+1,index3);
		                   
		                    String SereverName=Receiver.substring(0,index2);

		                    int index22=Emailsend.indexOf('@');       
		                    String SereverRCPT2=Emailsend.substring(index22+1);
		                    int index32=Emailsend.indexOf('.'); 
		                    String serverr2=Emailsend.substring(index22+1,index32);
		                    String SereverName2=Emailsend.substring(0,index22);
		                    output2.writeUTF( "Server: 250 "+Receiver+" ...Recipient ok");
		                    
		                    
		                    StringBuffer sb = new StringBuffer();
			                for(int i2 = 0; i2 < Name.length; i2++) {
			                sb.append(Name[i2]);
			                }
			                String str = sb.toString();
		                   
		                    
		                    output2.writeUTF("Server: Please enter the body of your email ended by ‘&&&‘");
		        
		                    String strr=input2.readUTF();
		                   FileWriter inbox = new FileWriter("C:\\Users\\HP\\Desktop\\New folder\\task22\\" +serverr+"\\"+  SereverName + "/inbox.txt",true);
		                  // PrintWriter FileWrite=new PrintWriter(inbox);
		                    BufferedWriter FileWrite = new BufferedWriter(inbox);
		                    FileWrite.write(Emailsend+": "+strr+"\n");
		                    FileWrite.close();
		                    
		                    FileWriter outbox = new FileWriter("C:\\Users\\HP\\Desktop\\New folder\\task22\\" +serverr2+"\\"+  SereverName2 + "/outbox.txt",true);
		                    BufferedWriter FileWrite2 = new BufferedWriter(outbox);
		                    FileWrite2.write(Receiver+": "+strr+"\n");
		                    FileWrite2.close();
		                }
		                else if(Choice2.toLowerCase().equals("showinbox")){
		               	 StringBuffer sb = new StringBuffer();
		                    for(int i2 = 0; i2 < Name.length; i2++) {
		                    sb.append(Name[i2]);
		                    }
		                    String str = sb.toString();
		                    File inbox = new File("C:\\Users\\HP\\Desktop\\New folder\\task22\\" +st+"\\"+ str + "/inbox.txt");
		                    System.out.println(st+"   "+str);
		               	 BufferedReader br2 = new BufferedReader(new FileReader(inbox));
		               	  
		               	  String st2;
		               	  String BigMMsg=" ";
		               	  while ((st2 = br2.readLine()) != null)
		               	  {
		               		  BigMMsg+=st2;
		               	  }
		               	  output2.writeUTF(BigMMsg);
		               	System.out.println(BigMMsg);
		               	  }
		                
		                
		                else if(Choice2.toLowerCase().equals("sendtomany")){
		                	output2.writeUTF("how many you need to send to : ");
		                	String manys=input2.readUTF();
		                	int many=Integer.parseInt(manys);
		                	
		                	
		                	output2.writeUTF("Mail from : ");
		                	 String Emailsend=input2.readUTF();
		                	 output2.writeUTF("Server: 250 " +  Emailsend + " ...Sender ok");
		                	 output2.writeUTF("Server: Please enter the body of your email ended by ‘&&&‘");
		         	        
			                    String strr=input2.readUTF();
		                	 
		           while(many!=0) {
		                	 
		                	 
		        	   
	                	 output2.writeUTF("RCP_TO : ");
	                	 String  Receiver=input2.readUTF();
	                   
	                    int index2=Receiver.indexOf('@');       
	                    String SereverRCPT=Receiver.substring(index2+1);
	                   
	                    int index3=Receiver.indexOf('.'); 
	                    String serverr=Receiver.substring(index2+1,index3);
	                   
	                    String SereverName=Receiver.substring(0,index2);

	                    int index22=Emailsend.indexOf('@');       
	                    String SereverRCPT2=Emailsend.substring(index22+1);
	                    int index32=Emailsend.indexOf('.'); 
	                    String serverr2=Emailsend.substring(index22+1,index32);
	                    String SereverName2=Emailsend.substring(0,index22);
	                    output2.writeUTF( "Server: 250 "+Receiver+" ...Recipient ok");
	                    
	                    
	                    StringBuffer sb = new StringBuffer();
		                for(int i2 = 0; i2 < Name.length; i2++) {
		                sb.append(Name[i2]);
		                }
		                String str = sb.toString();
	                   
	          
	                    
	                    
	                   FileWriter inbox = new FileWriter("C:\\Users\\HP\\Desktop\\New folder\\task22\\" +serverr+"\\"+  SereverName + "/inbox.txt",true);
	                  // PrintWriter FileWrite=new PrintWriter(inbox);
	                    BufferedWriter FileWrite = new BufferedWriter(inbox);
	                    FileWrite.write(Emailsend+": "+strr+"\n");
	                    FileWrite.close();
	                    
	                    FileWriter outbox = new FileWriter("C:\\Users\\HP\\Desktop\\New folder\\task22\\" +serverr2+"\\"+  SereverName2 + "/outbox.txt",true);
	                    BufferedWriter FileWrite2 = new BufferedWriter(outbox);
	                    FileWrite2.write(Receiver+": "+strr+"\n");
	                    FileWrite2.close();
	                    many--;
		                	 }
		                	
		                }
		                
	               }
	               
	               
	            }
else if(choice.equalsIgnoreCase("QUIT"))
			       {
			    	   output2.writeUTF("CLOSED");
			    	   clientSocket2.close();
			       }
	
	  
	
	}	
	
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
	
}
}

private int parseInt(String manys) {
	// TODO Auto-generated method stub
	return 0;
}}