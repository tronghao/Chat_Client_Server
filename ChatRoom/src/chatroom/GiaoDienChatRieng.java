/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.DataOutputStream;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.JRootPane;
import javax.swing.SwingUtilities;


/**
 *
 * @author TrongHao
 */
public class GiaoDienChatRieng extends javax.swing.JFrame {
    private String nameConnect;
    private GiaoDienClient2 form;
    private boolean trangThaiButtonCbx;
    private int idCuaForm;

    /**
     * Creates new form GiaoDienChatRieng
     * @param form
     */
    public GiaoDienChatRieng(GiaoDienClient2 form, int id) {
        initComponents();
        this.form = form;
        this.idCuaForm = id;
        
        setLocationRelativeTo(this.form);
        setVisible(true);
        trangThaiButtonCbx = true;
        
        
        cbxName.removeAllItems();
        String textTA = form.getTextAreaUser();
        String[] name = textTA.split("\\n");
        cbxName.addItem("Server");
        for (String line : name)
        {
            if(!line.equals(form.getClient().name))
                cbxName.addItem(line);
        }
        

        btnGui.setEnabled(false);
        
        this.addWindowListener(new WindowAdapter() {
            public void windowClosed(WindowEvent e) {
                
            }
            public void windowClosing(WindowEvent e) {
                if(trangThaiButtonCbx == false)
                {
                    DataOutputStream dos;
                    try {
                        dos = new DataOutputStream(form.getSocket().getOutputStream());
                        dos.writeUTF("closeKetNoi: !%" + nameConnect + "!%" + form.getJLName());
                        dos.flush();
                    } catch (IOException ex) {

                    }
                }
            }
        });
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cbxName = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        taHienThi = new javax.swing.JTextArea();
        tfTinNhan = new javax.swing.JTextField();
        btnGui = new javax.swing.JButton();
        btnKetNoi = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jlConnectNameClient = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Chat Riêng");

        cbxName.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        cbxName.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        taHienThi.setEditable(false);
        taHienThi.setColumns(20);
        taHienThi.setFont(new java.awt.Font("Segoe UI", 0, 18)); // NOI18N
        taHienThi.setLineWrap(true);
        taHienThi.setRows(5);
        taHienThi.setWrapStyleWord(true);
        jScrollPane1.setViewportView(taHienThi);

        tfTinNhan.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N

        btnGui.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnGui.setText("Gửi");
        btnGui.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuiActionPerformed(evt);
            }
        });

        btnKetNoi.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnKetNoi.setText("Kết Nối");
        btnKetNoi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKetNoiActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("Trạng Thái:");

        jlConnectNameClient.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jlConnectNameClient.setText("Không kết nối");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(cbxName, 0, 313, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnKetNoi))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 398, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(tfTinNhan)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnGui)
                        .addGap(3, 3, 3))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jlConnectNameClient)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbxName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnKetNoi))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jlConnectNameClient))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 248, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfTinNhan, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnGui))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void setNameConnect(String name)
    {
        nameConnect = name;
    }
    
    private void btnGuiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuiActionPerformed
        // TODO add your handling code here:
        if(tfTinNhan.getText().equals(""))
        {
            JOptionPane jO = new JOptionPane();
            jO.showMessageDialog(rootPane, "Vui lòng nhập nội dung tin nhắn!");
        }
        else
        {
            DataOutputStream dos;
            String sms = tfTinNhan.getText();
            
            if(nameConnect.equals("Server"))
            {
                try {
                    dos = new DataOutputStream(form.getSocket().getOutputStream());
                    dos.writeUTF("PrivateServer!%" + form.getJLName() + ": " + sms);
                    // ma !% là 15
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(rootPane, "Kết Nối Đến Server Bị Lỗi");
                }
            }
            else
            {
                try {
                    dos = new DataOutputStream(form.getSocket().getOutputStream());
                    dos.writeUTF("PrivateClinet!%" + nameConnect  + "!%" + form.getJLName() + "!%" + form.getJLName() + ": " + sms);
                    // ma !% là 15
                } catch (IOException ex) {
                    JOptionPane.showMessageDialog(rootPane, "Kết Nối Đến Server Bị Lỗi");
                }
            }
 
            taHienThi.setText(taHienThi.getText() + "\nTôi: " + sms);
            tfTinNhan.setText("");

            cbxName.removeAllItems();

            String textTA = form.getTextAreaUser();
            String[] name = textTA.split("\\n");
            cbxName.addItem("Server");
            for (String line : name)
            {
                if(!line.equals(form.getClient().name))
                    cbxName.addItem(line);
            } 
        }
    }//GEN-LAST:event_btnGuiActionPerformed
    
    public void openConnectServer()
    {
        btnGui.setEnabled(true);
        btnKetNoi.setEnabled(false);
        cbxName.setEnabled(false);
        trangThaiButtonCbx = false;
        jlConnectNameClient.setText("Đang kết nối đến Server");
        
        JRootPane rootPane = SwingUtilities.getRootPane(btnGui); 
        rootPane.setDefaultButton(btnGui);
    }
    
    public void openAccept(String name)
    {
        for(FormChatRieng item : form.chatRiengList)
        {
            if(item.getId() == idCuaForm)
            {
                item.setName(name);
                break;
            }
        }
        JOptionPane mess = new JOptionPane();
        mess.showMessageDialog(rootPane, "Bạn đã có thể chat riêng tư với " + name + "!"); 
        btnGui.setEnabled(true);
        btnKetNoi.setEnabled(false);
        cbxName.setEnabled(false);
        trangThaiButtonCbx = false;
        jlConnectNameClient.setText("Đang kết nối đến " + name);
        this.nameConnect = name;
        
        JRootPane rootPane = SwingUtilities.getRootPane(btnGui); 
        rootPane.setDefaultButton(btnGui);
    }
    
    public void tuChoiKetNoi(String nameClientXacNhan)
    {
        JOptionPane mess = new JOptionPane();
        mess.showMessageDialog(rootPane, nameClientXacNhan + " đã từ chối chat riêng tư với bạn!");  
        btnKetNoi.setEnabled(true);
        cbxName.setEnabled(true);
        trangThaiButtonCbx = true;
        //cập nhật lại các client
        cbxName.removeAllItems();

        String textTA = form.getTextAreaUser();
        String[] name = textTA.split("\\n");
        cbxName.addItem("Server");
        for (String line : name)
        {
            if(!line.equals(form.getClient().name))
                cbxName.addItem(line);
        }
    }
    public void setTextHienThi(String sms)
    {
        taHienThi.setText(taHienThi.getText() + "\n" + sms);
    }
    
    public void closeForm()
    {
        JOptionPane jO = new JOptionPane();
        jO.showMessageDialog(rootPane, nameConnect + " đã ngắt kết nối chat riêng với bạn!");
        this.dispose();
    }
    
    private void btnKetNoiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKetNoiActionPerformed
        // TODO add your handling code here:
        if(cbxName.getSelectedItem().toString().equals("Server"))
        {
            this.dispose();
            form.moChatRiengServer();
        }
        else
        {
            DataOutputStream dos;
            try
            {
                dos = new DataOutputStream(form.getSocket().getOutputStream());
                dos.writeUTF("connectToClient: !%" + idCuaForm + "!%" + cbxName.getSelectedItem().toString());
                dos.flush();
                JOptionPane jp = new JOptionPane();
                jp.showMessageDialog(rootPane, "Xin Chờ Xác Nhận!");
                btnKetNoi.setEnabled(false);
                cbxName.setEnabled(false);
                trangThaiButtonCbx = false;
            }
            catch(IOException e)
            {
               JOptionPane.showMessageDialog(rootPane, "Kết Nối Đến Server Bị Lỗi");
            }
        }
    }//GEN-LAST:event_btnKetNoiActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(GiaoDienChatRieng.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GiaoDienChatRieng.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GiaoDienChatRieng.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GiaoDienChatRieng.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new GiaoDienChatRieng().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGui;
    private javax.swing.JButton btnKetNoi;
    private javax.swing.JComboBox cbxName;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel jlConnectNameClient;
    private javax.swing.JTextArea taHienThi;
    private javax.swing.JTextField tfTinNhan;
    // End of variables declaration//GEN-END:variables
}
