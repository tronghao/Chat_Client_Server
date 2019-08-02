
import java.net.Socket;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author TrongHao
 */
public class ChatRiengClient {
    private String name1;
    private String name2;
    private int idForm1;
    private int idForm2;
    
    public void setIdForm1(int id)
    {
        idForm1 = id;
    }
    
    public int getIdForm1()
    {
        return idForm1;
    }
    
    public void setIdForm2(int id)
    {
        idForm2 = id;
    }
    
    public int getIdForm2()
    {
        return idForm2;
    }
    
    public void setName1(String name)
    {
        name1 = name;
    }
    
    public String getName1()
    {
        return name1;
    }
    
    public void setName2(String name)
    {
        name2 = name;
    }
    
    public String getName2()
    {
        return name2;
    }
}
