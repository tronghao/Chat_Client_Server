/**
 * @(#)ReadClient.java
 *
 *
 * @author 
 * @version 1.00 2019/7/12
 */
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ReadClient extends Thread{
    private Socket socket;
    private GiaoDienClient2 form2;
    public ReadClient(Socket client, GiaoDienClient2 form) 
    {
    	this.socket = client;
        this.form2 = form;
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
                        String manyName;
                        String changeNickName;
                        if(sms.contains("Server send to client data user: "))
                        {
                            manyName = sms.substring(33);
                            form2.setTextAreaUser(manyName);
                            continue;
                        }
                        
                        if(sms.equals("Server Kick!"))
                        {
                            form2.serverKick();
                            continue;
                        }
                        
                        if(sms.contains("change Name!"))
                        {
                            changeNickName = sms.substring(12);
                            form2.changeName(changeNickName);
                            continue;
                        }
                        
    			form2.setTextArea(sms);
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
    			System.out.println("Ngat ket noi den Server");
    		}
    	}
    }
}