


import chatroomserver.ClientManager;
import java.io.DataOutputStream;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.JRootPane;
import javax.swing.SwingUtilities;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


/**
 *
 * @author TrongHao
 */
public class GiaoDienServer extends javax.swing.JFrame {
    private Server server;
    private GiaoDienChucNangKichClient form2;
    private GiaoDienServerNhanTinRieng formNTR;
    /**
     * Creates new form GiaoDienServer
     */
    public GiaoDienServer(Server server) {
        initComponents();
        setLocationRelativeTo(null);
        setVisible(true);
        this.server = server;
        JRootPane rootPane = SwingUtilities.getRootPane(btnGui); 
        rootPane.setDefaultButton(btnGui);
        
        formNTR = new GiaoDienServerNhanTinRieng(this);
        formNTR.setVisible(false);
    }
    
       
    public String getTinNhan()
    {
        return tfTinNhan.getText();
    }
    
    public void setTinNhan(String sms)
    {
        tfTinNhan.setText(sms);
    }
    
    public String getTextArea()
    {
        return taHienThi1.getText();
    }
    
    public void setTextArea(String sms)
    {
        taHienThi1.setText(taHienThi1.getText() + "\n" + sms);
    }
        
    public void setTextAreaTrangThai(String sms)
    {
        taTrangThai.setText(taTrangThai.getText() + "\n" + sms);
    }
    
    public void setNumberClient(String sms)
    {
        jlNumClient.setText(sms);
    }
    
    public void setTextAreaClientName(String sms)
    {
        taClient.setText(sms);
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        taTrangThai = new javax.swing.JTextArea();
        tfTinNhan = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        btnGui = new javax.swing.JButton();
        btnThoat = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jlNumClient = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        taClient = new javax.swing.JTextArea();
        btnNhanTinRieng = new javax.swing.JButton();
        btnKichClient = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        taHienThi1 = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ChatRoom - Server");
        setResizable(false);

        taTrangThai.setEditable(false);
        taTrangThai.setColumns(20);
        taTrangThai.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        taTrangThai.setLineWrap(true);
        taTrangThai.setRows(5);
        taTrangThai.setWrapStyleWord(true);
        jScrollPane1.setViewportView(taTrangThai);

        tfTinNhan.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        tfTinNhan.setMinimumSize(new java.awt.Dimension(8, 22));

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel1.setText("Tin Nhắn:");

        btnGui.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnGui.setText("Gửi");
        btnGui.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuiActionPerformed(evt);
            }
        });

        btnThoat.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnThoat.setText("Thoát");
        btnThoat.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnThoatActionPerformed(evt);
            }
        });

        jPanel1.setBackground(javax.swing.UIManager.getDefaults().getColor("CheckBox.light"));
        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel2.setText("Số Client đang kết nối:");

        jlNumClient.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        jlNumClient.setForeground(new java.awt.Color(0, 0, 204));
        jlNumClient.setText("0");

        taClient.setEditable(false);
        taClient.setColumns(20);
        taClient.setFont(new java.awt.Font("Segoe UI", 1, 17)); // NOI18N
        taClient.setLineWrap(true);
        taClient.setRows(5);
        taClient.setWrapStyleWord(true);
        jScrollPane2.setViewportView(taClient);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jlNumClient))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jlNumClient))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane2)
                .addContainerGap())
        );

        btnNhanTinRieng.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnNhanTinRieng.setForeground(new java.awt.Color(149, 62, 151));
        btnNhanTinRieng.setText("Nhắn Tin Riêng");
        btnNhanTinRieng.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnNhanTinRieng.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnNhanTinRiengActionPerformed(evt);
            }
        });

        btnKichClient.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btnKichClient.setText("Kick Client");
        btnKichClient.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnKichClient.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnKichClientActionPerformed(evt);
            }
        });

        taHienThi1.setEditable(false);
        taHienThi1.setColumns(20);
        taHienThi1.setFont(new java.awt.Font("Segoe UI", 0, 15)); // NOI18N
        taHienThi1.setLineWrap(true);
        taHienThi1.setRows(5);
        taHienThi1.setWrapStyleWord(true);
        jScrollPane3.setViewportView(taHienThi1);

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setText("Nội dung chat:");

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setText("Trạng Thái Kết Nối:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfTinNhan, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnGui, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnNhanTinRieng)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnThoat, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(btnKichClient))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnKichClient)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 269, Short.MAX_VALUE))
                .addGap(14, 14, 14)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(tfTinNhan, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1)
                        .addComponent(btnThoat)
                        .addComponent(btnGui)
                        .addComponent(btnNhanTinRieng)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnGuiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuiActionPerformed
        // TODO add your handling code here:

        if(tfTinNhan.getText().equals(""))
        {
            JOptionPane jO = new JOptionPane();
            jO.showMessageDialog(rootPane, "Vui lòng nhập nội dung tin nhắn!");
        }
        else
        {
            String sms = tfTinNhan.getText(); 
            DataOutputStream dos;
            try
            {
                for(ClientManager item : Server.listSK)
                {
                    dos = new DataOutputStream(item.getSocket().getOutputStream());
                    dos.writeUTF(server.name + ": " + sms);	
                }
                this.setTextArea(server.name + ": " + sms);
                this.setTinNhan("");
            }
            catch(IOException e)
            {		

            }
        }
    }//GEN-LAST:event_btnGuiActionPerformed

    private void btnThoatActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnThoatActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_btnThoatActionPerformed

    private void btnKichClientActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnKichClientActionPerformed
        // TODO add your handling code here:
        form2 = new GiaoDienChucNangKichClient(this);
        form2.setVisible(true);
    }//GEN-LAST:event_btnKichClientActionPerformed

    private void btnNhanTinRiengActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnNhanTinRiengActionPerformed
        // TODO add your handling code here:
        formNTR.setVisible(true);
        formNTR.capNhatCbx();
    }//GEN-LAST:event_btnNhanTinRiengActionPerformed
    
    public void capNhatCbxCuaGiaoDienServerNhanTinRieng()
    {
        formNTR.capNhatCbx();
    }
    
    public void setTextHienThiGiaoDienNhanTinRieng(String sms)
    {
        formNTR.setLocationRelativeTo(this);
        formNTR.setVisible(true);
        formNTR.setTextHienThi(sms);
    }
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
            java.util.logging.Logger.getLogger(GiaoDienServer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GiaoDienServer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GiaoDienServer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GiaoDienServer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                //new GiaoDienServer().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnGui;
    private javax.swing.JButton btnKichClient;
    private javax.swing.JButton btnNhanTinRieng;
    private javax.swing.JButton btnThoat;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel jlNumClient;
    private javax.swing.JTextArea taClient;
    private javax.swing.JTextArea taHienThi1;
    private javax.swing.JTextArea taTrangThai;
    private javax.swing.JTextField tfTinNhan;
    // End of variables declaration//GEN-END:variables
}
