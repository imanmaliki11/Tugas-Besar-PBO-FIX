package presensi;

public class MenuAdmin extends javax.swing.JFrame {
    public MenuAdmin() {
        initComponents();
        this.setLocationRelativeTo(null);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelUtama = new java.awt.Panel();
        MenuAdmin = new java.awt.Panel();
        tombolKeluar = new javax.swing.JButton();
        tombolIsiDataPresensi = new javax.swing.JButton();
        tombolIsiDataPresensi1 = new javax.swing.JButton();
        tombolIsiDataPresensi2 = new javax.swing.JButton();
        tombolIsiDataPresensi3 = new javax.swing.JButton();
        tombolIsiDataPresensi4 = new javax.swing.JButton();
        tombolIsiDataPresensi5 = new javax.swing.JButton();
        tombolIsiDataPresensi6 = new javax.swing.JButton();
        LabeljudMenuADMIN = new javax.swing.JLabel();
        MenuSelamatDatang = new java.awt.Panel();
        textSelamatDatang = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        PanelUtama.setBackground(new java.awt.Color(0, 255, 153));
        PanelUtama.setLayout(null);

        MenuAdmin.setBackground(new java.awt.Color(0, 204, 204));

        tombolKeluar.setText("Keluar");
        tombolKeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tombolKeluarActionPerformed(evt);
            }
        });

        tombolIsiDataPresensi.setFont(new java.awt.Font("Times New Roman", 1, 10)); // NOI18N
        tombolIsiDataPresensi.setText("Isi Data Presensi");

        tombolIsiDataPresensi1.setFont(new java.awt.Font("Times New Roman", 1, 10)); // NOI18N
        tombolIsiDataPresensi1.setText("Isi Data Presensi");

        tombolIsiDataPresensi2.setFont(new java.awt.Font("Times New Roman", 1, 10)); // NOI18N
        tombolIsiDataPresensi2.setText("Isi Data Presensi");

        tombolIsiDataPresensi3.setFont(new java.awt.Font("Times New Roman", 1, 10)); // NOI18N
        tombolIsiDataPresensi3.setText("Isi Data Presensi");

        tombolIsiDataPresensi4.setFont(new java.awt.Font("Times New Roman", 1, 10)); // NOI18N
        tombolIsiDataPresensi4.setText("Isi Data Presensi");

        tombolIsiDataPresensi5.setFont(new java.awt.Font("Times New Roman", 1, 10)); // NOI18N
        tombolIsiDataPresensi5.setText("Isi Data Presensi");

        tombolIsiDataPresensi6.setFont(new java.awt.Font("Times New Roman", 1, 10)); // NOI18N
        tombolIsiDataPresensi6.setText("Isi Data Presensi");

        LabeljudMenuADMIN.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        LabeljudMenuADMIN.setText("MENU ADMIN");

        javax.swing.GroupLayout MenuAdminLayout = new javax.swing.GroupLayout(MenuAdmin);
        MenuAdmin.setLayout(MenuAdminLayout);
        MenuAdminLayout.setHorizontalGroup(
            MenuAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuAdminLayout.createSequentialGroup()
                .addGroup(MenuAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(MenuAdminLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(MenuAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tombolIsiDataPresensi, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
                            .addComponent(tombolIsiDataPresensi1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tombolIsiDataPresensi2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tombolIsiDataPresensi3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tombolIsiDataPresensi4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tombolIsiDataPresensi5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tombolIsiDataPresensi6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(MenuAdminLayout.createSequentialGroup()
                        .addGap(33, 33, 33)
                        .addComponent(tombolKeluar, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(MenuAdminLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(LabeljudMenuADMIN)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        MenuAdminLayout.setVerticalGroup(
            MenuAdminLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MenuAdminLayout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addComponent(LabeljudMenuADMIN)
                .addGap(88, 88, 88)
                .addComponent(tombolIsiDataPresensi)
                .addGap(18, 18, 18)
                .addComponent(tombolIsiDataPresensi1)
                .addGap(18, 18, 18)
                .addComponent(tombolIsiDataPresensi2)
                .addGap(18, 18, 18)
                .addComponent(tombolIsiDataPresensi3)
                .addGap(18, 18, 18)
                .addComponent(tombolIsiDataPresensi4)
                .addGap(18, 18, 18)
                .addComponent(tombolIsiDataPresensi5)
                .addGap(18, 18, 18)
                .addComponent(tombolIsiDataPresensi6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 68, Short.MAX_VALUE)
                .addComponent(tombolKeluar)
                .addGap(25, 25, 25))
        );

        PanelUtama.add(MenuAdmin);
        MenuAdmin.setBounds(0, 0, 140, 520);

        MenuSelamatDatang.setBackground(new java.awt.Color(0, 204, 51));
        MenuSelamatDatang.setLayout(null);

        textSelamatDatang.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        textSelamatDatang.setText("Selamat Datang di Menu Admin");
        MenuSelamatDatang.add(textSelamatDatang);
        textSelamatDatang.setBounds(110, 240, 350, 28);

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\asus\\Downloads\\basel-switzerland-world-hd-wallpaper-1920x1080-3674.jpg")); // NOI18N
        MenuSelamatDatang.add(jLabel1);
        jLabel1.setBounds(0, 0, 530, 520);

        PanelUtama.add(MenuSelamatDatang);
        MenuSelamatDatang.setBounds(150, 0, 540, 520);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(PanelUtama, javax.swing.GroupLayout.PREFERRED_SIZE, 683, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(PanelUtama, javax.swing.GroupLayout.PREFERRED_SIZE, 521, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tombolKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombolKeluarActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_tombolKeluarActionPerformed

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
            java.util.logging.Logger.getLogger(MenuAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuAdmin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuAdmin().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel LabeljudMenuADMIN;
    private java.awt.Panel MenuAdmin;
    private java.awt.Panel MenuSelamatDatang;
    private java.awt.Panel PanelUtama;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel textSelamatDatang;
    private javax.swing.JButton tombolIsiDataPresensi;
    private javax.swing.JButton tombolIsiDataPresensi1;
    private javax.swing.JButton tombolIsiDataPresensi2;
    private javax.swing.JButton tombolIsiDataPresensi3;
    private javax.swing.JButton tombolIsiDataPresensi4;
    private javax.swing.JButton tombolIsiDataPresensi5;
    private javax.swing.JButton tombolIsiDataPresensi6;
    private javax.swing.JButton tombolKeluar;
    // End of variables declaration//GEN-END:variables
}
