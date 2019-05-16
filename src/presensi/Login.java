package presensi;

import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
public class Login extends javax.swing.JFrame {
    
    public static Dosen ODosen;
    public static String a;
    
    public Login() {
        initComponents();
        this.setLocationRelativeTo(null);
    }
    
    public void set() {
        this.a = this.getUsername.getText();
    }
    
    public static String getData() {
        return a;
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PabelLogin = new javax.swing.JPanel();
        Password = new javax.swing.JLabel();
        getUsername = new javax.swing.JTextField();
        getPassword = new javax.swing.JPasswordField();
        Username = new javax.swing.JLabel();
        tombolLogin = new java.awt.Button();
        BGGunung = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);
        setSize(new java.awt.Dimension(408, 478));

        PabelLogin.setMinimumSize(new java.awt.Dimension(408, 478));
        PabelLogin.setLayout(null);

        Password.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        Password.setText("Password");
        PabelLogin.add(Password);
        Password.setBounds(40, 200, 70, 30);

        getUsername.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                getUsernameActionPerformed(evt);
            }
        });
        PabelLogin.add(getUsername);
        getUsername.setBounds(150, 150, 200, 30);
        PabelLogin.add(getPassword);
        getPassword.setBounds(150, 200, 200, 30);

        Username.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        Username.setText("Username");
        PabelLogin.add(Username);
        Username.setBounds(40, 150, 80, 30);

        tombolLogin.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        tombolLogin.setLabel("Login");
        tombolLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tombolLoginActionPerformed(evt);
            }
        });
        PabelLogin.add(tombolLogin);
        tombolLogin.setBounds(150, 290, 120, 30);
        tombolLogin.getAccessibleContext().setAccessibleName("button1");

        BGGunung.setIcon(new javax.swing.ImageIcon("C:\\Users\\asus\\Downloads\\BGLogin.jpg")); // NOI18N
        PabelLogin.add(BGGunung);
        BGGunung.setBounds(0, 40, 410, 440);

        jPanel1.setBackground(new java.awt.Color(102, 153, 255));
        jPanel1.setForeground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 410, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 40, Short.MAX_VALUE)
        );

        PabelLogin.add(jPanel1);
        jPanel1.setBounds(0, 0, 410, 40);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PabelLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PabelLogin, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void getUsernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_getUsernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_getUsernameActionPerformed

    private void tombolLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombolLoginActionPerformed
        if(getUsername.getText().equals("admin")){
            if(getPassword.getText().equals("admin123")) {
               JOptionPane.showMessageDialog(null, "Anda Berhasil Login", "Sukses", JOptionPane.NO_OPTION);
                MenuAdmin adm = new MenuAdmin();
                adm.setVisible(true);
                adm.pack();
                adm.setLocationRelativeTo(null);
                adm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Password Anda Salah", "Gagal",JOptionPane.ERROR_MESSAGE);
            }
        }else {
            String user = getUsername.getText();
            ResultSet rset;
            try {
                Connection DB = koneksi.getConection();
                Statement stm = DB.createStatement();
                
                rset = stm.executeQuery("select * from dosen where nip_dosen = '" + 
                        user + "';");
                
                if(rset.next()) {
                    Dosen dosen = new Dosen(rset.getString("Nama_Dosen"), rset.getString("NIP_Dosen"),
                    rset.getString("Password"));
                    if(getPassword.getText().equals(dosen.Password)){
                        JOptionPane.showMessageDialog(null, "Anda Berhasil Login", "Sukses", JOptionPane.NO_OPTION);
                        new MenuDosen(dosen).setVisible(true);
                        //menudosen.setVisible(true);
                        //menudosen.pack();
                        //menudosen.setLocationRelativeTo(null);
                        //menudosen.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                        this.dispose();
                    } else {
                        JOptionPane.showMessageDialog(null, "Password Anda Salah", "Gagal",JOptionPane.ERROR_MESSAGE);
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Username Salah", "Gagal",JOptionPane.ERROR_MESSAGE);
                }
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
            //JOptionPane.showMessageDialog(null, "Anda Gagal Login", "Gagal", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_tombolLoginActionPerformed

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
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Login.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Login().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BGGunung;
    private javax.swing.JPanel PabelLogin;
    private javax.swing.JLabel Password;
    private javax.swing.JLabel Username;
    private javax.swing.JPasswordField getPassword;
    private javax.swing.JTextField getUsername;
    private javax.swing.JPanel jPanel1;
    private java.awt.Button tombolLogin;
    // End of variables declaration//GEN-END:variables
}
