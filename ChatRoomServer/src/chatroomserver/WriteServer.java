/**
 * @(#)WriteServer.java
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

public class WriteServer extends Thread{
	
	private String name;
	private GiaoDienServer form;
	WriteServer(String name, GiaoDienServer form)
	{
            this.name = name;	
            this.form = form;
	}
 
        @Override
    public void run()
    {
    	String sms = form.getTinNhan(); 
    	DataOutputStream dos;
        try
        {
            for(ClientManager item : Server.listSK)
            {
                dos = new DataOutputStream(item.getSocket().getOutputStream());
                dos.writeUTF(this.name + ": " + sms);	
            }
            form.setTextArea(this.name + ": " + sms);
            form.setTinNhan("");
        }
        catch(IOException e)
        {		
            
        }
    	
    }
}