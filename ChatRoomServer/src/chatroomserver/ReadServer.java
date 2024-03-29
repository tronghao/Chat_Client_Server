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
                    form.capNhatCbxCuaGiaoDienServerNhanTinRieng();
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
                    String data[] = sms.split("!%");
                    int idFormGui = Integer.parseInt(data[1]);
                    String nameCanKetNoi = data[2];
                    String nameGuiKetNoi = "";
                    for(ClientManager item : Server.listSK)
                    {
                        if(item.getSocket() == socket)
                        {
                            nameGuiKetNoi = item.getName();
                            break;
                        }
                    }
                    
                    ChatRiengClient item = new ChatRiengClient();
                    item.setName1(nameCanKetNoi);
                    item.setName2(nameGuiKetNoi);
                    
                    Server.listConnect.add(item);
                    
                    for(ClientManager item2 : Server.listSK)
                    {
                        if(item2.getName().equals(nameCanKetNoi))
                        {
                            DataOutputStream dos;
                            try
                            {
                                dos = new DataOutputStream(item2.getSocket().getOutputStream());
                                dos.writeUTF("AcceptConnectToClient: !%" + idFormGui + "!%" + nameGuiKetNoi);
                            }
                            catch(IOException e)
                            {
                                System.out.println("Loi");
                            }
                        }
                    }   
                    continue;
                }
                
                if(sms.contains("AcceptConnect: "))
                {
                    System.out.println("Da vao AcceptConnect");
                    String data[] = sms.split("!%");
                    int idFormGui = Integer.parseInt(data[1]);
                    int idFormNhan = Integer.parseInt(data[2]);
                    String nameClientXacNhanKetNoi = "";
                    String nameCLientGuiYeuCauKetNoi = data[3];
                    for(ClientManager item : Server.listSK)
                    {
                        if(item.getSocket() == socket)
                        {
                            nameClientXacNhanKetNoi = item.getName();
                            break;
                        }
                    }
                    
                    for(ChatRiengClient item : Server.listConnect)
                    {
                        if((item.getName1().equals(nameCLientGuiYeuCauKetNoi) && item.getName2().equals(nameClientXacNhanKetNoi)))
                        {
                            item.setIdForm1(idFormGui);
                            item.setIdForm2(idFormNhan);
                            break;
                        }
                        if((item.getName1().equals(nameClientXacNhanKetNoi) && item.getName2().equals(nameCLientGuiYeuCauKetNoi)))
                        {
                            item.setIdForm1(idFormNhan);
                            item.setIdForm2(idFormGui);
                            break;
                        }
                        
                    }
                    
                    System.out.println("Name1:"+nameClientXacNhanKetNoi +" Name2:" + nameCLientGuiYeuCauKetNoi);
                    for(ClientManager item : Server.listSK)
                    {
                        System.out.println("Da vao vong lap");
                        if(item.getName().equals(nameCLientGuiYeuCauKetNoi))
                        {
                           DataOutputStream dos;
                            try
                            {
                                dos = new DataOutputStream(item.getSocket().getOutputStream());
                                dos.writeUTF("ClientAccepted: !%" + idFormGui + "!%" + nameClientXacNhanKetNoi);
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
                
                if(sms.contains("AcceptNotConnect: "))
                { 
                    String data[] = sms.split("!%");
                    int idFormGui = Integer.parseInt(data[1]);
                    String nameClientXacNhanKetNoi = "";
                    String nameCLientGuiYeuCauKetNoi = data[2];
                    for(ClientManager item : Server.listSK)
                    {
                        if(item.getSocket() == socket)
                        {
                            nameClientXacNhanKetNoi = item.getName();
                            break;
                        }
                    }
                    
                    System.out.println("Name1:"+nameClientXacNhanKetNoi +" Name2:" + nameCLientGuiYeuCauKetNoi);
                    for(ClientManager item : Server.listSK)
                    {
                        System.out.println("Da vao vong lap");
                        if(item.getName().equals(nameCLientGuiYeuCauKetNoi))
                        {
                           DataOutputStream dos;
                            try
                            {
                                dos = new DataOutputStream(item.getSocket().getOutputStream());
                                dos.writeUTF("ClientNotAccepted: !%" + idFormGui + "!%" + nameClientXacNhanKetNoi);
                                System.out.println("Da gui client Not AcceptConnect");
                            }
                            catch(IOException e)
                            {

                            }
                            break;
                        }
                    }
                    
                    for(ChatRiengClient item : Server.listConnect)
                    {
                        if(item.getName2().equals(nameCLientGuiYeuCauKetNoi) && item.getName1().equals(nameClientXacNhanKetNoi))
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
                    String nameClientNhan = data[1];
                    String nameClientGui = data[2];
                    int idFormNhan=-1;
                    for(ChatRiengClient item : Server.listConnect)
                    {
                        if(item.getName1().equals(nameClientNhan) && item.getName2().equals(nameClientGui))
                        {
                            idFormNhan = item.getIdForm1();
                            break;
                        }
                        if(item.getName1().equals(nameClientGui) && item.getName2().equals(nameClientNhan))
                        {
                            idFormNhan = item.getIdForm2();
                            break;
                        }
                    }
                    for(ClientManager item : Server.listSK)
                    {
                        if(item.getName().equals(nameClientNhan))
                        {
                                DataOutputStream dos = new DataOutputStream(item.getSocket().getOutputStream());
                                dos.writeUTF("PrivateClinet!%" + idFormNhan + "!%" + data[3]);
                                break;
                        }   				
                    }
                    form.setTextArea(data[0] + " " + data[1] + "<<-- " + data[3]);
                    continue;
                }
                
                if(sms.contains("PrivateServer!%"))
                {
                    String[] data = sms.split("!%");
                    String tinNhan = data[1];
                    form.setTextHienThiGiaoDienNhanTinRieng(tinNhan);
                    continue;
                }
                
                if(sms.contains("closeKetNoi: "))
                {
                    String data[] = sms.split("!%");
                    String nameClientGui = data[2];
                    String nameClientNhan = data[1];
                    int idFormNhan = -1;
                    for(ChatRiengClient item : Server.listConnect)
                    {
                        if(item.getName1().equals(nameClientNhan) && item.getName2().equals(nameClientGui))
                        {
                            idFormNhan = item.getIdForm1();
                            break;
                        }
                        if(item.getName1().equals(nameClientGui) && item.getName2().equals(nameClientNhan))
                        {
                            idFormNhan = item.getIdForm2();
                            break;
                        }
                    }
                    for(ClientManager item : Server.listSK)
                    {
                        if(item.getName().equals(nameClientNhan))
                        {
                                DataOutputStream dos = new DataOutputStream(item.getSocket().getOutputStream());
                                dos.writeUTF("closeKetNoi!%" + idFormNhan);
                                break;
                        }   				
                    }
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