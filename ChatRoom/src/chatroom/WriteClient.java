/**
 * @(#)WriteClient.java
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
import java.util.Scanner;
import java.util.*;

public class WriteClient extends Thread{
	
	private Socket socket;
	private String name;
        public String sms; 
    public WriteClient(Socket client, String name) 
    {
    	this.socket = client;
    	this.name = name;
    }
    
    
    public void run()
    {
    	
    	DataOutputStream dos;
		try
		{
			dos = new DataOutputStream(socket.getOutputStream());
	    	while(true)
	    	{
		    	dos.writeUTF(this.name + ": " + sms);
		    	dos.flush();
	    	}	
		}
		catch(IOException e)
		{
			try
    		{
    			//dos.close();
    			socket.close();
    		}
    		catch(IOException ex)
    		{
    			System.out.println("Ngat ket noi den Server");
    		}
		}
    	
    }
    
}