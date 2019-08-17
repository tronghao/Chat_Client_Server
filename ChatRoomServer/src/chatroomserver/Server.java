/**
 * @(#)Server.java
 *
 *
 * @author 
 * @version 1.00 2019/7/12
 */

import chatroomserver.ClientManager;
import java.util.*;
import java.net.InetAddress;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.ServerSocket;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Scanner;

public class Server {
    
    public String name = "Server";
    private int port = 9598;
    public static ArrayList<ClientManager> listSK = new ArrayList<>();
    public static ArrayList<ChatRiengClient> listConnect = new ArrayList<>();
    private GiaoDienServer form;
    private ReadServer read;
    
    public Server()
    {
        
    }
    
    public void ThucThi() throws IOException
    {
        form = new GiaoDienServer(this);
        form.setVisible(true);
    	ServerSocket server = new ServerSocket(port);
    	
    	while(true)
    	{
    		Socket socket = server.accept();
                ClientManager clientM = new ClientManager();
                clientM.setSocket(socket);
    		listSK.add(clientM);
    		read = new ReadServer(socket, form);
    		read.start();
    	}  	
    }
    
    public static void main(String[] args) throws IOException
    {
    	Server server = new Server();
    	server.ThucThi();
    }
}