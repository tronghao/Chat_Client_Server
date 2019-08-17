/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author TrongHao
 */
public class FormChatRieng {
    
    private GiaoDienChatRieng form2;
    private String name;
    private GiaoDienClient2 form;
    private int id;
    
    FormChatRieng(GiaoDienClient2 form, int id)
    {
        this.form = form;
        form2 = new GiaoDienChatRieng(this.form, id);
        this.id = id;
    }
    
    public int getId()
    {
        return id;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    public String getName()
    {
        return name;
    }
    
    public void openAccept(String name)
    {
        form2.openAccept(name);
    }
    
    public void tuChoiKetNoi(String name)
    {
        form2.tuChoiKetNoi(name);
    }
    
    public void setTextHienThiCuaGiaoDienChatRieng(String sms)
    {
        form2.setTextHienThi(sms);
    }
    
    public void  closeForm()
    {
         form2.closeForm();
    }
}
