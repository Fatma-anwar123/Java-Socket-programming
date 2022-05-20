package task22;

import java.net.InetAddress;
import java.io.IOException;

import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Scanner;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;
public class client {
	
	public static void main(String[] args) {
		try {

			InetAddress serverIp=InetAddress.getByName("localhost");
			
			int min = 5100;  
			int max = 5900; 
			int a = (int)Math.random()*(max-min+1)+min;
			
			  
			int serverport=a;
			Socket clientSocket2=new Socket(serverIp,5179);
			while(true)
			{
				
				DataInputStream input = new DataInputStream(clientSocket2.getInputStream());
				DataOutputStream output = new DataOutputStream(clientSocket2.getOutputStream());
			    
				System.out.println("Please enter server port number.");
				
				Scanner scanner=new Scanner(System.in);
				String request =scanner.nextLine();
				output.writeUTF(request);
				int i=Integer.parseInt(request);  
				
				
				File file = new File("dataserver.txt");
				  
				  BufferedReader br = new BufferedReader(new FileReader(file));
				  int flag=0;
				  String st;
				  while ((st = br.readLine()) != null)
				  {
				    if(st.contains(request))
				    {
				    	st= st.substring(0, st.indexOf(" ")); 
				        
				    	System.out.println(st);
				    	flag=1;
				    	 serverport=i;
				    	 System.out.println(serverport);
				    	 
				    	 output.writeUTF(request);
				    	 InetAddress serverIp2=InetAddress.getByName("localhost");
				    	
					    	Socket clientSocket=new Socket(serverIp2,serverport);
					    	DataInputStream input2 = new DataInputStream(clientSocket.getInputStream());
							DataOutputStream output2 = new DataOutputStream(clientSocket.getOutputStream());
							System.out.println("connected with server port number.");
							
							
							
							String conn2=input2.readUTF();
						    System.out.println(conn2);
						    
							String choice =scanner.nextLine();
							 output2.writeUTF(choice);
							 System.out.println(choice);
							
							 String conn3=input2.readUTF();
							    System.out.println(conn3);//enter email and password
							    
							    String email =scanner.nextLine();
								 output2.writeUTF(email);
								 
								 String pasword =scanner.nextLine();
								 output2.writeUTF(pasword);
								 
								
								 if(choice.equalsIgnoreCase("REGISTER")) 
						            {
									 String reply=input2.readUTF();
									 System.out.println(reply); 
									 
									 String reply2=input2.readUTF();
									 System.out.println(reply2);
									 
									 String Choice2=scanner.nextLine();
									 output2.writeUTF( Choice2);
									 
									 if(Choice2.toLowerCase().equals("quit")){
										 String reply3=input2.readUTF();
										 System.out.println(reply3);
					                    break;
					                }
									 else if(Choice2.toLowerCase().equals("send")){
										 String reply3=input2.readUTF();
										 System.out.println(reply3);
										 
										 String emailsend=scanner.nextLine();
										 output2.writeUTF( emailsend);
										 
										 String reply4=input2.readUTF();
										 System.out.println(reply4);
										 
										 String reply5=input2.readUTF();
										 System.out.println(reply5);
										 
										 String emailsendTo=scanner.nextLine();
										 output2.writeUTF( emailsendTo);
										 
										 String reply6=input2.readUTF();
										 System.out.println(reply6);
										 
										 String reply7=input2.readUTF();
										 System.out.println(reply7);
										 
										 
										 
										 String str =" ";
										 String Sentence;
						                    while(true){
						                        Sentence=scanner.nextLine();
						                        
						                        if(Sentence.toLowerCase().equals("&&&") || Sentence.contains("&&&")){
						                        	System.out.println("Server: 250 Message accepted for delivery");
						                            break;
						                        }
						                        else{
						                        	String old=Sentence;
						                        	str +=" "+old;
						                        }
						                    }
						                   
						                    output2.writeUTF(str);
										 
									 }
									 else if(Choice2.toLowerCase().equals("sendtomany")){
										 String reply30=input2.readUTF();
										 System.out.println(reply30);
										 
										 String many=scanner.nextLine();
										 output2.writeUTF( many);
										 int manyy=Integer.parseInt(many);
										 
										 String reply3=input2.readUTF();
										 System.out.println(reply3);
										 
										 String emailsend=scanner.nextLine();
										 output2.writeUTF( emailsend);
										 
										 String reply4=input2.readUTF();
										 System.out.println(reply4);
										 
										 String reply7=input2.readUTF();
										 System.out.println(reply7);
										 String str =" ";
										 String Sentence;
						                    while(true){
						                        Sentence=scanner.nextLine();
						                        
						                        if(Sentence.toLowerCase().equals("&&&") || Sentence.contains("&&&")){
						                        	System.out.println("Server: 250 Message accepted for delivery");
						                            break;
						                        }
						                        else{
						                        	String old=Sentence;
						                        	str +=" "+old;
						                        }
						                    }
						                   
						                    output2.writeUTF(str);
										 while(manyy!=0)
										 {
											 String reply5=input2.readUTF();
											 System.out.println(reply5);
											 
											 String emailsendTo=scanner.nextLine();
											 output2.writeUTF( emailsendTo);
											 
											 String reply6=input2.readUTF();
											 System.out.println(reply6);
											 
											 
											 
											 
											 
											 
											 manyy--;
										 }
										 
									 }
						            }
								 else if(choice.equalsIgnoreCase("LOGIN"))
								 {
									 String reply=input2.readUTF();
									 System.out.println(reply); 
									 
									 
									 String reply2=input2.readUTF();
									 System.out.println(reply2);
									 
									 String Choice2=scanner.nextLine();
									 output2.writeUTF( Choice2);
									 
									 if(Choice2.toLowerCase().equals("quit")){
										 String reply3=input2.readUTF();
										 System.out.println(reply3);
					                    break;
					                }
									 else if(Choice2.toLowerCase().equals("send")){
										 String reply3=input2.readUTF();
										 System.out.println(reply3);
										 
										 String emailsend=scanner.nextLine();
										 output2.writeUTF( emailsend);
										 
										 String reply4=input2.readUTF();
										 System.out.println(reply4);
										 
										 String reply5=input2.readUTF();
										 System.out.println(reply5);
										 
										 String emailsendTo=scanner.nextLine();
										 output2.writeUTF( emailsendTo);
										 
										 String reply6=input2.readUTF();
										 System.out.println(reply6);
										 
										 String reply7=input2.readUTF();
										 System.out.println(reply7);
										 
										 
										 
										 String str =" ";
										 String Sentence;
						                    while(true){
						                        Sentence=scanner.nextLine();
						                        
						                        if(Sentence.toLowerCase().equals("&&&") || Sentence.contains("&&&")){
						                        	System.out.println("Server: 250 Message accepted for delivery");
						                            break;
						                        }
						                        else{
						                        	String old=Sentence;
						                        	str +=" "+old;
						                        }
						                    }
						                   
						                    output2.writeUTF(str);
										 
									 }
									  if(Choice2.toLowerCase().equals("showinbox")){
										 String reply3=input2.readUTF();
										 System.out.println(reply3);
										
									 }
									 else if(Choice2.toLowerCase().equals("sendtomany")){
										 String reply30=input2.readUTF();
										 System.out.println(reply30);
										 
										 String many=scanner.nextLine();
										 output2.writeUTF( many);
										 int manyy=Integer.parseInt(many);
										 
										 String reply3=input2.readUTF();
										 System.out.println(reply3);
										 
										 String emailsend=scanner.nextLine();
										 output2.writeUTF( emailsend);
										 
										 String reply4=input2.readUTF();
										 System.out.println(reply4);
										 
										 String reply7=input2.readUTF();
										 System.out.println(reply7);
										 String str =" ";
										 String Sentence;
						                    while(true){
						                        Sentence=scanner.nextLine();
						                        
						                        if(Sentence.toLowerCase().equals("&&&") || Sentence.contains("&&&")){
						                        	System.out.println("Server: 250 Message accepted for delivery");
						                            break;
						                        }
						                        else{
						                        	String old=Sentence;
						                        	str +=" "+old;
						                        }
						                    }
						                   
						                    output2.writeUTF(str);
										 while(manyy!=0)
										 {
											 String reply5=input2.readUTF();
											 System.out.println(reply5);
											 
											 String emailsendTo=scanner.nextLine();
											 output2.writeUTF( emailsendTo);
											 
											 String reply6=input2.readUTF();
											 System.out.println(reply6);
											 
											 
											 manyy--;
										 }
										 
									 }
								 }
								 else if(choice.equalsIgnoreCase("QUIT"))
							       {
									 String reply=input2.readUTF();
									 System.out.println(reply);
									 clientSocket.close();
							       }
							       else
							       {
							    	   String reply=input2.readUTF();
										 System.out.println(reply); 
							       }
				    	         
					    
				    }
				    
				  }
				  if(flag==0)
					  System.out.println("Error in port number");
					  
				  
				  
				
			    
			    
			    
		}
		} catch (SocketException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}