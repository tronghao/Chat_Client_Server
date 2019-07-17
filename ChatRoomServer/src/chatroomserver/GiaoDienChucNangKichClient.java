
import chatroomserver.ClientManager;
import java.io.DataOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author TrongHao
 */
public class GiaoDienChucNangKichClient extends javax.swing.JFrame {
    private GiaoDienServer form;

    public GiaoDienChucNangKichClient(GiaoDienServer form) {
        initComponents();
        this.form = form;
        setLocationRelativeTo(null);
        cbxName.removeAllItems();
        
        for(ClientManager item : Server.listSK)
        {
            cbxName.addItem(item.getName());
        }
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
        btnKick = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Kick Client");
        setResizable(false);

        cbxName.setBackground(java.awt.SystemColor.controlHighlight);
        cbxName.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnKick.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnKick.setText("Kick");
        btnKick.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKickActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(cbxName, 0, 291, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(btnKick)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(cbxName, javax.swing.GroupLayout.PREFERRED_SIZE, 31, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnKick)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnKickActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKickActionPerformed
        // TODO add your handling code here:
        String name = cbxName.getSelectedItem().toString();
        System.out.println(name);
        String manyName = "";
        for(ClientManager item : Server.listSK)
        {
            if(name.equals(item.getName()))
            {
                //gửi đến client bị kick và thông báo cho client sau đó thoát
                DataOutputStream dos;
                try {
                    dos = new DataOutputStream(item.getSocket().getOutputStream());
                    dos.writeUTF("Server Kick!");  
                } catch (IOException ex) {

                }
                
                form.setTextAreaTrangThai("Đã Ngắt Kết Nối Với " + item.getName());
                try {
                    item.getSocket().close();
                } catch (IOException ex) {
                    
                }
                Server.listSK.remove(item);    
                break;
            }
        }
        //Cập nhật lại số lượng và tên các client
        form.setNumberClient(String.valueOf(Server.listSK.size()));
        for(ClientManager item : Server.listSK)
        {
            manyName += item.getName() + "\n";
            System.out.println(item.getName());
        }
        form.setTextAreaClientName(manyName);

        //Gửi cập nhật số client cho các client
        for(ClientManager item : Server.listSK)
        {                   
            DataOutputStream dos;
            try {
                dos = new DataOutputStream(item.getSocket().getOutputStream());
                dos.writeUTF("Server send to client data user: " + manyName);  
            } catch (IOException ex) {
               
            }
               				
        }
        
        //load lại combobox
        cbxName.removeAllItems();
        
        for(ClientManager item : Server.listSK)
        {
            cbxName.addItem(item.getName());
        }
    }//GEN-LAST:event_btnKickActionPerformed

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
            java.util.logging.Logger.getLogger(GiaoDienChucNangKichClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GiaoDienChucNangKichClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GiaoDienChucNangKichClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GiaoDienChucNangKichClient.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new GiaoDienChucNangKichClient().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnKick;
    private javax.swing.JComboBox cbxName;
    // End of variables declaration//GEN-END:variables
}
