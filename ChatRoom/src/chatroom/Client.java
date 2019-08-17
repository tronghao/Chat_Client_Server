/**
 * @(#)Client.java
 *
 *
 * @author 
 * @version 1.00 2019/7/12
 */


import java.net.InetAddress;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.*;
import javax.swing.JOptionPane;

public class Client {
    
    public String name;
    public String host;
    private int port = 9598;
    public GiaoDienClient form;
    public GiaoDienClient2 form2;
    
    public Client() 
    {
    	form = new GiaoDienClient(this);
        form.setVisible(true);
    }

    public void ThucThi()
    {
    	try
    	{
    		Socket client = new Socket(host, port);
                DataOutputStream dos = new DataOutputStream(client.getOutputStream());
                dos.writeUTF("NameToServer: " + form.getTFName());
                form2 = new GiaoDienClient2(this, client);
                form2.setVisible(true);
                form.setVisible(false);
        
    	}
    	catch(IOException e)
    	{
            JOptionPane.showMessageDialog(null, "Máy Chủ Không Khả Dụng!");

    	}  	
    } 
    
    public static void main(String[] args)
    {
        Client client = new Client();
        
    }
}