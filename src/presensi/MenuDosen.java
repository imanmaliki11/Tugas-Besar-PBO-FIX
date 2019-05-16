package presensi;
public class MenuDosen extends javax.swing.JFrame {
    
    Dosen ODosen = new Dosen();

    public void setDosen(Dosen dosen) {
        this.ODosen = dosen;
    }
    
    public MenuDosen(Dosen D) {
        ODosen = D;
        initComponents();
        this.setLocationRelativeTo(null);
        setNamaSelamatDatang.setText(ODosen.Nama);
        PanelSelamatDatang.setVisible(true);
        PanelTampilKelas.setVisible(false);
        PanelDataMahsiswa.setVisible(false);
        PanelCariMahasiswa.setVisible(false);
    }
    
    public MenuDosen() {
        initComponents();
        this.setLocationRelativeTo(null);
        setNamaSelamatDatang.setText(ODosen.Nama);
        PanelSelamatDatang.setVisible(true);
        PanelTampilKelas.setVisible(false);
        PanelDataMahsiswa.setVisible(false);
        PanelCariMahasiswa.setVisible(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PanelUtama = new javax.swing.JPanel();
        PanelMenuUtama = new javax.swing.JPanel();
        tombolKeluar = new javax.swing.JButton();
        textMenuDosen = new javax.swing.JLabel();
        tombolTampilKelas = new javax.swing.JButton();
        tombolDataMahasiswa = new javax.swing.JButton();
        tombolCariMahasiswa = new javax.swing.JButton();
        PanelSelamatDatang = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        setNamaSelamatDatang = new javax.swing.JLabel();
        BgSelamatDatang = new javax.swing.JLabel();
        PanelTampilKelas = new javax.swing.JPanel();
        LabeldaftarKelas = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TabelTampilKelas = new javax.swing.JTable();
        lbl = new javax.swing.JLabel();
        PanelDataMahsiswa = new javax.swing.JPanel();
        LabelJudulDataMahasiswa = new javax.swing.JLabel();
        TextNamaKelas = new javax.swing.JLabel();
        getKodeKelasDataMahasiswa = new javax.swing.JTextField();
        tombolKodeKelasinDataMahasiswa = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        TabelDataMahasiswa = new javax.swing.JTable();
        LabelDataMahasiswa = new javax.swing.JLabel();
        PanelCariMahasiswa = new javax.swing.JPanel();
        LabelCariMhstext = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        getNIMcariMahasiswa = new javax.swing.JTextField();
        TombolNiminCariMahasiswa = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        TabelCariMahasiswa = new javax.swing.JTable();
        LabelCariMahasiswa = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        PanelUtama.setBackground(new java.awt.Color(245, 230, 83));
        PanelUtama.setLayout(null);

        PanelMenuUtama.setBackground(new java.awt.Color(233, 212, 96));

        tombolKeluar.setBackground(new java.awt.Color(217, 30, 24));
        tombolKeluar.setText("Keluar");
        tombolKeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tombolKeluarActionPerformed(evt);
            }
        });

        textMenuDosen.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        textMenuDosen.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        textMenuDosen.setText("Menu Dosen");

        tombolTampilKelas.setBackground(new java.awt.Color(34, 167, 240));
        tombolTampilKelas.setFont(new java.awt.Font("Times New Roman", 1, 10)); // NOI18N
        tombolTampilKelas.setText("Tampil Kelas");
        tombolTampilKelas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tombolTampilKelasActionPerformed(evt);
            }
        });

        tombolDataMahasiswa.setBackground(new java.awt.Color(34, 167, 240));
        tombolDataMahasiswa.setFont(new java.awt.Font("Times New Roman", 1, 10)); // NOI18N
        tombolDataMahasiswa.setText("Data Mahasiswa");
        tombolDataMahasiswa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tombolDataMahasiswaActionPerformed(evt);
            }
        });

        tombolCariMahasiswa.setBackground(new java.awt.Color(34, 167, 240));
        tombolCariMahasiswa.setFont(new java.awt.Font("Times New Roman", 1, 10)); // NOI18N
        tombolCariMahasiswa.setText("Cari Mahasiswa");
        tombolCariMahasiswa.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tombolCariMahasiswaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PanelMenuUtamaLayout = new javax.swing.GroupLayout(PanelMenuUtama);
        PanelMenuUtama.setLayout(PanelMenuUtamaLayout);
        PanelMenuUtamaLayout.setHorizontalGroup(
            PanelMenuUtamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PanelMenuUtamaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(PanelMenuUtamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelMenuUtamaLayout.createSequentialGroup()
                        .addGap(0, 16, Short.MAX_VALUE)
                        .addComponent(textMenuDosen, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelMenuUtamaLayout.createSequentialGroup()
                        .addGroup(PanelMenuUtamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(tombolCariMahasiswa, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tombolDataMahasiswa, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(tombolTampilKelas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelMenuUtamaLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(tombolKeluar)
                .addGap(37, 37, 37))
        );
        PanelMenuUtamaLayout.setVerticalGroup(
            PanelMenuUtamaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PanelMenuUtamaLayout.createSequentialGroup()
                .addGap(103, 103, 103)
                .addComponent(textMenuDosen)
                .addGap(67, 67, 67)
                .addComponent(tombolTampilKelas)
                .addGap(18, 18, 18)
                .addComponent(tombolDataMahasiswa)
                .addGap(18, 18, 18)
                .addComponent(tombolCariMahasiswa)
                .addGap(56, 56, 56)
                .addComponent(tombolKeluar)
                .addContainerGap(135, Short.MAX_VALUE))
        );

        PanelUtama.add(PanelMenuUtama);
        PanelMenuUtama.setBounds(0, 0, 140, 500);

        PanelSelamatDatang.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Selamat Datang");
        PanelSelamatDatang.add(jLabel2);
        jLabel2.setBounds(170, 210, 250, 20);

        setNamaSelamatDatang.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        setNamaSelamatDatang.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        setNamaSelamatDatang.setText("nama");
        setNamaSelamatDatang.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        PanelSelamatDatang.add(setNamaSelamatDatang);
        setNamaSelamatDatang.setBounds(164, 234, 260, 20);

        BgSelamatDatang.setIcon(new javax.swing.ImageIcon("D:\\SO\\BGPctr.jpg")); // NOI18N
        PanelSelamatDatang.add(BgSelamatDatang);
        BgSelamatDatang.setBounds(0, 0, 700, 500);

        PanelUtama.add(PanelSelamatDatang);
        PanelSelamatDatang.setBounds(150, 0, 550, 500);

        PanelTampilKelas.setMinimumSize(new java.awt.Dimension(550, 500));
        PanelTampilKelas.setPreferredSize(new java.awt.Dimension(804, 500));
        PanelTampilKelas.setLayout(null);

        LabeldaftarKelas.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        LabeldaftarKelas.setText("Daftar Kelas");
        PanelTampilKelas.add(LabeldaftarKelas);
        LabeldaftarKelas.setBounds(240, 100, 80, 17);

        TabelTampilKelas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(TabelTampilKelas);

        PanelTampilKelas.add(jScrollPane1);
        jScrollPane1.setBounds(80, 150, 390, 250);

        lbl.setIcon(new javax.swing.ImageIcon("D:\\SO\\BGPctr.jpg")); // NOI18N
        PanelTampilKelas.add(lbl);
        lbl.setBounds(0, 0, 810, 500);

        PanelUtama.add(PanelTampilKelas);
        PanelTampilKelas.setBounds(150, 0, 804, 500);

        PanelDataMahsiswa.setLayout(null);

        LabelJudulDataMahasiswa.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        LabelJudulDataMahasiswa.setText("Data Mahasiwa");
        PanelDataMahsiswa.add(LabelJudulDataMahasiswa);
        LabelJudulDataMahasiswa.setBounds(240, 40, 100, 17);

        TextNamaKelas.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        TextNamaKelas.setText("Kode Kelas");
        PanelDataMahsiswa.add(TextNamaKelas);
        TextNamaKelas.setBounds(130, 80, 70, 20);
        PanelDataMahsiswa.add(getKodeKelasDataMahasiswa);
        getKodeKelasDataMahasiswa.setBounds(230, 80, 170, 20);

        tombolKodeKelasinDataMahasiswa.setText("GO");
        PanelDataMahsiswa.add(tombolKodeKelasinDataMahasiswa);
        tombolKodeKelasinDataMahasiswa.setBounds(420, 80, 50, 23);

        TabelDataMahasiswa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane2.setViewportView(TabelDataMahasiswa);

        PanelDataMahsiswa.add(jScrollPane2);
        jScrollPane2.setBounds(60, 120, 452, 350);

        LabelDataMahasiswa.setIcon(new javax.swing.ImageIcon("D:\\SO\\BGPctr.jpg")); // NOI18N
        PanelDataMahsiswa.add(LabelDataMahasiswa);
        LabelDataMahasiswa.setBounds(0, 0, 550, 500);

        PanelUtama.add(PanelDataMahsiswa);
        PanelDataMahsiswa.setBounds(150, 0, 550, 500);

        PanelCariMahasiswa.setLayout(null);

        LabelCariMhstext.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        LabelCariMhstext.setText("Cari Mahasiswa");
        PanelCariMahasiswa.add(LabelCariMhstext);
        LabelCariMhstext.setBounds(230, 50, 100, 20);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel1.setText("NIM");
        PanelCariMahasiswa.add(jLabel1);
        jLabel1.setBounds(130, 100, 24, 20);
        PanelCariMahasiswa.add(getNIMcariMahasiswa);
        getNIMcariMahasiswa.setBounds(180, 100, 190, 20);

        TombolNiminCariMahasiswa.setText("GO");
        PanelCariMahasiswa.add(TombolNiminCariMahasiswa);
        TombolNiminCariMahasiswa.setBounds(400, 100, 50, 23);

        TabelCariMahasiswa.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane3.setViewportView(TabelCariMahasiswa);

        PanelCariMahasiswa.add(jScrollPane3);
        jScrollPane3.setBounds(70, 170, 452, 200);

        LabelCariMahasiswa.setIcon(new javax.swing.ImageIcon("D:\\SO\\BGPctr.jpg")); // NOI18N
        PanelCariMahasiswa.add(LabelCariMahasiswa);
        LabelCariMahasiswa.setBounds(0, 0, 550, 500);

        PanelUtama.add(PanelCariMahasiswa);
        PanelCariMahasiswa.setBounds(150, 0, 550, 500);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelUtama, javax.swing.GroupLayout.DEFAULT_SIZE, 700, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(PanelUtama, javax.swing.GroupLayout.DEFAULT_SIZE, 500, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tombolKeluarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombolKeluarActionPerformed
        // TODO add your handling code here:
        System.exit(0);
    }//GEN-LAST:event_tombolKeluarActionPerformed

    private void tombolTampilKelasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombolTampilKelasActionPerformed
        // TODO add your handling code here:
        PanelSelamatDatang.setVisible(false);
        PanelTampilKelas.setVisible(true);
        PanelDataMahsiswa.setVisible(false);
        PanelCariMahasiswa.setVisible(false);
    }//GEN-LAST:event_tombolTampilKelasActionPerformed

    private void tombolDataMahasiswaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombolDataMahasiswaActionPerformed
        // TODO add your handling code here:
        PanelSelamatDatang.setVisible(false);
        PanelTampilKelas.setVisible(false);
        PanelDataMahsiswa.setVisible(true);
        PanelCariMahasiswa.setVisible(false);
    }//GEN-LAST:event_tombolDataMahasiswaActionPerformed

    private void tombolCariMahasiswaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombolCariMahasiswaActionPerformed
        // TODO add your handling code here:
        PanelSelamatDatang.setVisible(false);
        PanelTampilKelas.setVisible(false);
        PanelDataMahsiswa.setVisible(false);
        PanelCariMahasiswa.setVisible(true);
    }//GEN-LAST:event_tombolCariMahasiswaActionPerformed

    public static void main(String args[]) {
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
            java.util.logging.Logger.getLogger(MenuDosen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MenuDosen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MenuDosen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MenuDosen.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MenuDosen().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel BgSelamatDatang;
    private javax.swing.JLabel LabelCariMahasiswa;
    private javax.swing.JLabel LabelCariMhstext;
    private javax.swing.JLabel LabelDataMahasiswa;
    private javax.swing.JLabel LabelJudulDataMahasiswa;
    private javax.swing.JLabel LabeldaftarKelas;
    private javax.swing.JPanel PanelCariMahasiswa;
    private javax.swing.JPanel PanelDataMahsiswa;
    private javax.swing.JPanel PanelMenuUtama;
    private javax.swing.JPanel PanelSelamatDatang;
    private javax.swing.JPanel PanelTampilKelas;
    private javax.swing.JPanel PanelUtama;
    private javax.swing.JTable TabelCariMahasiswa;
    private javax.swing.JTable TabelDataMahasiswa;
    private javax.swing.JTable TabelTampilKelas;
    private javax.swing.JLabel TextNamaKelas;
    private javax.swing.JButton TombolNiminCariMahasiswa;
    private javax.swing.JTextField getKodeKelasDataMahasiswa;
    private javax.swing.JTextField getNIMcariMahasiswa;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel lbl;
    private javax.swing.JLabel setNamaSelamatDatang;
    private javax.swing.JLabel textMenuDosen;
    private javax.swing.JButton tombolCariMahasiswa;
    private javax.swing.JButton tombolDataMahasiswa;
    private javax.swing.JButton tombolKeluar;
    private javax.swing.JButton tombolKodeKelasinDataMahasiswa;
    private javax.swing.JButton tombolTampilKelas;
    // End of variables declaration//GEN-END:variables
}
