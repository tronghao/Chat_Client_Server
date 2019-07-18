/**
 * @(#)ReadServer.java
 *
 *
 * @author 
 * @version 1.00 2019/7/12
 */


import chatroomserver.ClientManager;
import java.net.InetAddress;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Scanner;

public class ReadServer extends Thread{
	
    private Socket socket;
    private GiaoDienServer form;
	
    public ReadServer(Socket server, GiaoDienServer form) 
    {
    	this.socket = server;
        this.form = form;
    }
    
  
    public void run()
    {
    	DataInputStream dis = null;
    	try
    	{
            dis = new DataInputStream(socket.getInputStream());
            while(true)
            {
                String sms = dis.readUTF();
                String manyName = "";
                int thayDoi = 0;
                if(sms.contains("NameToServer: "))
                {
                    String name = sms.substring(14);
                    String namePhu = name;
                    for(ClientManager item : Server.listSK)
                    {
                        if(name.equals(item.getName()))
                        {
                            for(int i=1; i<100; i++)
                            {
                                namePhu = name;
                                namePhu += String.valueOf(i);
                                for(ClientManager item2 : Server.listSK)
                                {
                                    thayDoi = 0; 
                                    if(namePhu.equals(item2.getName()))
                                    {
                                        thayDoi = 1;
                                        break;
                                    }
                                }
                                if(thayDoi != 1)
                                {
                                    name = namePhu;
                                    thayDoi = 1;
                                    break;
                                }      
                            }
                        }
                    }
                    form.setTextAreaTrangThai("Đã Kết Nối Với: " + name);
                    for(ClientManager item : Server.listSK)
                    {
                        if(item.getSocket() == socket)
                        {
                            item.setName(name);
                        }
                    }
                    
                    //Cập nhật lại số lượng và tên các client
                    form.setNumberClient(String.valueOf(Server.listSK.size()));
                    for(ClientManager item : Server.listSK)
                    {
                        manyName += item.getName() + "\n";
                    }
                    form.setTextAreaClientName(manyName);
                    
                    //Gửi cập nhật số client cho các client
                    if(thayDoi == 0)
                    {
                        for(ClientManager item : Server.listSK)
                        {     
                            DataOutputStream dos = new DataOutputStream(item.getSocket().getOutputStream());
                            dos.writeUTF("Server send to client data user: " + manyName);     				
                        }
                    }else
                    {
                        for(ClientManager item : Server.listSK)
                        {     
                            if(item.getSocket() == socket)
                            {
                                DataOutputStream dos = new DataOutputStream(item.getSocket().getOutputStream());
                                dos.writeUTF("Server send to client data user: " + manyName); 
                                dos.writeUTF("change Name!" + name);
                            }
                            else
                            {
                                DataOutputStream dos = new DataOutputStream(item.getSocket().getOutputStream());
                                dos.writeUTF("Server send to client data user: " + manyName); 
                            }
                        }
                    }
                    continue;
                }
                if(sms.contains("exit"))
                {
                    for(ClientManager item : Server.listSK)
                    {
                        if(item.getSocket() == socket)
                        {
                            form.setTextAreaTrangThai("Đã Ngắt Kết Nối Với " + item.getName());
                            Server.listSK.remove(item);      
                            socket.close();
                            break;
                        }  
                    } 
                    
                    //Cập nhật lại số lượng và tên các client
                    form.setNumberClient(String.valueOf(Server.listSK.size()));
                    for(ClientManager item : Server.listSK)
                    {
                        manyName += item.getName() + "\n";
                    }
                    form.setTextAreaClientName(manyName);
                    
                    //Gửi cập nhật số client cho các client
                    for(ClientManager item : Server.listSK)
                    {                   
                        DataOutputStream dos = new DataOutputStream(item.getSocket().getOutputStream());
                        dos.writeUTF("Server send to client data user: " + manyName);     				
                    }
                    continue;
                }
                
                if(sms.contains("connectToClient:"))
                {
                    String name1 = sms.substring(17);
                    String name2 = "";
                    for(ClientManager item : Server.listSK)
                    {
                        if(item.getSocket() == socket)
                        {
                            name2 = item.getName();
                            break;
                        }
                    }
                    
                    ChatRiengClient item = new ChatRiengClient();
                    item.setName1(name1);
                    item.setName2(name2);
                    
                    Server.listConnect.add(item);
                    
                    for(ClientManager item2 : Server.listSK)
                    {
                        if(item2.getName().equals(name1))
                        {
                            DataOutputStream dos;
                            try
                            {
                                dos = new DataOutputStream(item2.getSocket().getOutputStream());
                                dos.writeUTF("AcceptConnectToClient: " + name2);
                            }
                            catch(IOException e)
                            {
                                System.out.println("Loi");
                            }
                        }
                    }   
                    continue;
                }
                
                if(sms.equals("AcceptConnect"))
                {
                    System.out.println("Da vao AcceptConnect");
                    String name1 = "";
                    String name2 = "";
                    for(ClientManager item : Server.listSK)
                    {
                        if(item.getSocket() == socket)
                        {
                            name1 = item.getName();
                            break;
                        }
                    }
                    
                    for(ChatRiengClient item : Server.listConnect)
                    {
                        if(item.getName1().equals(name1))
                        {
                            name2 = item.getName2();
                            break;
                        }
                    }
                    System.out.println("Name1:"+name1 +" Name2:" + name2);
                    for(ClientManager item : Server.listSK)
                    {
                        System.out.println("Da vao vong lap");
                        if(item.getName().equals(name2))
                        {
                           DataOutputStream dos;
                            try
                            {
                                dos = new DataOutputStream(item.getSocket().getOutputStream());
                                dos.writeUTF("ClientAccepted: " + name1);
                                System.out.println("Da gui client AcceptConnect");
                            }
                            catch(IOException e)
                            {

                            }
                            break;
                        }
                    }
                    continue;
                }
                
                if(sms.equals("NotAcceptConnect"))
                { 
                    String name1 = "";
                    String name2 = "";
                    for(ClientManager item : Server.listSK)
                    {
                        if(item.getSocket() == socket)
                        {
                            name1 = item.getName();
                            break;
                        }
                    }
                    
                    for(ChatRiengClient item : Server.listConnect)
                    {
                        if(item.getName1().equals(name1))
                        {
                            name2 = item.getName2();
                            break;
                        }
                    }
                    System.out.println("Name1:"+name1 +" Name2:" + name2);
                    for(ClientManager item : Server.listSK)
                    {
                        System.out.println("Da vao vong lap");
                        if(item.getName().equals(name2))
                        {
                           DataOutputStream dos;
                            try
                            {
                                dos = new DataOutputStream(item.getSocket().getOutputStream());
                                dos.writeUTF("ClientNotAccepted: " + name1);
                                System.out.println("Da gui client AcceptConnect");
                            }
                            catch(IOException e)
                            {

                            }
                            break;
                        }
                    }
                    
                    for(ChatRiengClient item : Server.listConnect)
                    {
                        if(item.getName2().equals(name2) && item.getName1().equals(name1))
                        {
                            Server.listConnect.remove(item);
                            break;
                        }
                    }
                    
                    continue;
                }
                
                if(sms.contains("PrivateClinet!%"))
                {
                    String[] data = sms.split("!%");
                    for(ClientManager item : Server.listSK)
                    {
                        if(item.getName().equals(data[1]))
                        {
                                DataOutputStream dos = new DataOutputStream(item.getSocket().getOutputStream());
                                dos.writeUTF("PrivateClinet!%" + data[2]);
                                break;
                        }   				
                    }
                    form.setTextArea(data[0] + " " + data[1] + ": " + data[2]);
                    continue;
                }
                
                for(ClientManager item : Server.listSK)
                {
                    if(item.getSocket().getPort() != socket.getPort())
                    {
                            DataOutputStream dos = new DataOutputStream(item.getSocket().getOutputStream());
                            dos.writeUTF(sms);
                    }   				
                }
                form.setTextArea(sms);
            }
    	}
    	catch(IOException e)
    	{
            try
            {
                    //dis.close();
                    socket.close();
            }
            catch(IOException ex)
            {

            }
    	}
    }
}