/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatroomserver;

import java.net.Socket;

/**
 *
 * @author TrongHao
 */
public class ClientManager {
    private Socket socket;
    private String name;
    
    public void setSocket(Socket socket)
    {
        this.socket = socket;
    }
    
    public Socket getSocket()
    {
        return socket;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    public String getName()
    {
        return name;
    }
}
