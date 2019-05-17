package presensi;

import java.util.TreeMap;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class MenuAdmin extends javax.swing.JFrame {
    
    public HashMap<String, data> Odata = new HashMap<>();
    public HashMap<String, Mahasiswa> Omhs = new HashMap<>();
    public HashMap<String, Dosen> ODosen = new HashMap<>();
    public HashMap<String, kelas> Okelas = new HashMap<>();
    public DefaultTableModel tab;
    
    private void isiOdata() {
        try {
            Connection DB = koneksi.getConection();
            Statement st = DB.createStatement();
            ResultSet rst = st.executeQuery("select * from data_kehadiran;");
            while(rst.next()) {
                data mhs  = new data(rst.getString(2), rst.getString(3), rst.getInt(4), rst.getInt(5));
                Odata.put(rst.getString(1), mhs);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }  catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void isiOmhs() {
        try {
            Connection DB = koneksi.getConection();
            Statement st = DB.createStatement();
            ResultSet rst = st.executeQuery("select * from mahasiswa;");
            while(rst.next()) {
                Mahasiswa mhs  = new Mahasiswa(rst.getString(1), rst.getString(2), rst.getString(3));
                Omhs.put(rst.getString(2), mhs);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }  catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void isiODosen() {
        try {
            Connection DB = koneksi.getConection();
            Statement st = DB.createStatement();
            ResultSet rst = st.executeQuery("select * from dosen;");
            while(rst.next()) {
                Dosen dsn  = new Dosen(rst.getString(2), rst.getString(1), rst.getString(3));
                ODosen.put(rst.getString("NIP_Dosen"), dsn);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }  catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void isiOkelas(){
        try {
            Connection DB = koneksi.getConection();
            Statement st = DB.createStatement();
            ResultSet rst = st.executeQuery("select * from kelas;");
            while(rst.next()) {
                kelas x = new kelas(rst.getString(3), rst.getString(2));
                Okelas.put(rst.getString(1), x);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }  catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    public MenuAdmin() {
        initComponents();
        isiOdata();
        isiOmhs();
        isiOkelas();
        isiODosen();
        this.setLocationRelativeTo(null);
        MenuSelamatDatang.setVisible(true);
        PanelTambahlKelas.setVisible(false);
        PanelTampilKelas.setVisible(false);
        PanelEditlKelas.setVisible(false);
        PanelTampilDosen.setVisible(false);
        PanelTampilMahasiswa.setVisible(false);
        PanelEditlDosen.setVisible(false);
    }
    
    private void isiTabelOdata() {
        DefaultTableModel mhsTabel = new DefaultTableModel();
        mhsTabel.addColumn("Kode MK");
        mhsTabel.addColumn("NIM");
        mhsTabel.addColumn("S/I");
        mhsTabel.addColumn("A");
        mhsTabel.addColumn("Keterangan");
        
        if(Odata.size()==0) {
            tab = mhsTabel;
            return;
        }
        
        try {
            for(data P : Odata.values()) {
                if(getKodeMkcTambahData.getText().equals(P.Kode)) {
                    mhsTabel.addRow(new Object[]{P.Kode, P.NIM, P.SI, P.A, P.Keterangan});
                }
            }
            tab = mhsTabel;
        } catch (Exception ex) {
            tab = mhsTabel;
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private void isiTabelMhs() {
        DefaultTableModel mhsTabel = new DefaultTableModel();
        mhsTabel.addColumn("NIM");
        mhsTabel.addColumn("Nama");
        mhsTabel.addColumn("Angkatan");
        try {
            for(Mahasiswa P : Omhs.values()) {
                mhsTabel.addRow(new Object[]{P.Kode, P.Nama, P.Angkatan});
            }
            tab = mhsTabel;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }  
    }
    
    private void isiTabelDosen() {
        DefaultTableModel mhsTabel = new DefaultTableModel();
        mhsTabel.addColumn("NIP");
        mhsTabel.addColumn("Nama");
        mhsTabel.addColumn("Password");
        try {
            for(Dosen P : ODosen.values()) {
                mhsTabel.addRow(new Object[]{P.Kode, P.Nama, P.Password});
            }
            tab = mhsTabel;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }  
    }
    
    private void isiTabelKelas(){
        DefaultTableModel mhsTabel = new DefaultTableModel();
        mhsTabel.addColumn("Kode");
        mhsTabel.addColumn("Nama");
        mhsTabel.addColumn("Dosen");
        try {
            int i = 0;
            for(Map.Entry P : Okelas.entrySet()) {
                kelas K = (kelas) P.getValue();
                mhsTabel.addRow(new Object[]{P.getKey(), K.Nama, K.id_dosen});
            }
            tab = mhsTabel;
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }  
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        PanelUtama = new java.awt.Panel();
        MenuAdmin = new java.awt.Panel();
        tombolKeluar = new javax.swing.JButton();
        TombolTampilKelas = new javax.swing.JButton();
        LabeljudMenuADMIN = new javax.swing.JLabel();
        TombolTambahKelas = new javax.swing.JButton();
        tombolTambahMhs = new javax.swing.JButton();
        TombolEditKelas = new javax.swing.JButton();
        tombolTampilDosen = new javax.swing.JButton();
        tombolTambahlDosen = new javax.swing.JButton();
        tombolEditlDosen = new javax.swing.JButton();
        TombolisiData = new javax.swing.JButton();
        tombolTampilMhs = new javax.swing.JButton();
        tombolEditData = new javax.swing.JButton();
        tombolTampilHadir = new javax.swing.JButton();
        tombolEditMhs = new javax.swing.JButton();
        MenuSelamatDatang = new java.awt.Panel();
        textSelamatDatang = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        PanelTampilKelas = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        TabelTampilKelas = new javax.swing.JTable();
        LabelMenuTampilKelas = new javax.swing.JLabel();
        LabelBGTampilKelas = new javax.swing.JLabel();
        PanelTambahlKelas = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        TabelTambahKelas = new javax.swing.JTable();
        LabelMenuTambahlKelas = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        getNamaMKTambahKelas = new javax.swing.JTextField();
        getNIPTambahKelas = new javax.swing.JTextField();
        getKodeTambahKelas = new javax.swing.JTextField();
        TomboladdTambahKelas = new javax.swing.JButton();
        LabelBGTambahlKelas = new javax.swing.JLabel();
        PanelEditlKelas = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        TabelTambahKelas1 = new javax.swing.JTable();
        LabelMenuTambahlKelas1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        getNamaMKTambahKelas1 = new javax.swing.JTextField();
        getNIPTambahKelas1 = new javax.swing.JTextField();
        getKodeTambahKelas1 = new javax.swing.JTextField();
        TombolUpdateEditKelas = new javax.swing.JButton();
        TombolGoEditKelas = new javax.swing.JButton();
        TombolDeleteEditKelas = new javax.swing.JButton();
        LabelBGTambahlKelas1 = new javax.swing.JLabel();
        PanelTampilDosen = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        TabelTampilDosen = new javax.swing.JTable();
        LabelMenuTampilDosen = new javax.swing.JLabel();
        LabelBGTampilKelas1 = new javax.swing.JLabel();
        PanelTambahlDosen = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        TabelTambahDosen = new javax.swing.JTable();
        LabelMenuTambahlKelas2 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        getNamaTambahDosen = new javax.swing.JTextField();
        getPassTambahDosen = new javax.swing.JTextField();
        getNIPTambahDosen = new javax.swing.JTextField();
        TomboladdTambahDosen = new javax.swing.JButton();
        LabelBGTambahlKelas2 = new javax.swing.JLabel();
        PanelEditlDosen = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        TabelEditDosen = new javax.swing.JTable();
        LabelMenuTambahlKelas3 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        getNamaEditDosen = new javax.swing.JTextField();
        getPassEDosen = new javax.swing.JTextField();
        getNIPEditDosen = new javax.swing.JTextField();
        TombolUpdateEditDosen = new javax.swing.JButton();
        TombolGoEditKelas1 = new javax.swing.JButton();
        TombolDeleteEditDosen = new javax.swing.JButton();
        LabelBGTambahlKelas3 = new javax.swing.JLabel();
        PanelTampilMahasiswa = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        TabelTampilMhs = new javax.swing.JTable();
        LabelMenuTampilmhs = new javax.swing.JLabel();
        LabelBGTampilKelas2 = new javax.swing.JLabel();
        PanelEditMhs = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jScrollPane8 = new javax.swing.JScrollPane();
        TabelEditMhs = new javax.swing.JTable();
        LabelMenuTambahlKelas4 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        getNamaEditMhs = new javax.swing.JTextField();
        getAngkatanEditMhs = new javax.swing.JTextField();
        getNimEditMhs = new javax.swing.JTextField();
        TombolUpdateEditMhs = new javax.swing.JButton();
        TombolGoEditMhs = new javax.swing.JButton();
        TombolDeleteEditMhs = new javax.swing.JButton();
        LabelBGTambahlKelas4 = new javax.swing.JLabel();
        PanelTambahMhs = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jScrollPane9 = new javax.swing.JScrollPane();
        TabelTambahMhs = new javax.swing.JTable();
        LabelMenuTambahlKelas5 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        NIM = new javax.swing.JLabel();
        getNamaTambahMhs = new javax.swing.JTextField();
        getAngkatanTambahMhs = new javax.swing.JTextField();
        getNIMTambahMhs = new javax.swing.JTextField();
        TomboladdTambahMhs = new javax.swing.JButton();
        LabelBGTambahlKelas5 = new javax.swing.JLabel();
        PanelIsiKehadiran = new javax.swing.JPanel();
        jLabel19 = new javax.swing.JLabel();
        jScrollPane10 = new javax.swing.JScrollPane();
        TabelTambahData = new javax.swing.JTable();
        LabelMenuTambahlKelas6 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        getSakitcTambahData = new javax.swing.JTextField();
        getAbsencTambahData = new javax.swing.JTextField();
        getNIMcTambahData = new javax.swing.JTextField();
        getKodeMkcTambahData = new javax.swing.JTextField();
        TomboladdTambahDosen1 = new javax.swing.JButton();
        tombolGOtambahData = new javax.swing.JButton();
        jLabel22 = new javax.swing.JLabel();
        LabelBGTambahlKelas6 = new javax.swing.JLabel();
        PanelEditKehadiran = new javax.swing.JPanel();
        jLabel23 = new javax.swing.JLabel();
        jScrollPane11 = new javax.swing.JScrollPane();
        TabelTambahData1 = new javax.swing.JTable();
        LabelMenuTambahlKelas7 = new javax.swing.JLabel();
        jLabel24 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        getSakitcTambahData1 = new javax.swing.JTextField();
        getAbsencTambahData1 = new javax.swing.JTextField();
        getNIMcTambahData1 = new javax.swing.JTextField();
        getKodeMkcTambahData1 = new javax.swing.JTextField();
        TomboladdTambahDosen2 = new javax.swing.JButton();
        tombolGOtambahData1 = new javax.swing.JButton();
        jLabel26 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        LabelBGTambahlKelas7 = new javax.swing.JLabel();
        PanelTampilKehadiran = new javax.swing.JPanel();
        jScrollPane12 = new javax.swing.JScrollPane();
        TabelTambahData2 = new javax.swing.JTable();
        LabelMenuTambahlKelas8 = new javax.swing.JLabel();
        getKodeMkcTamnahDataKeKelas = new javax.swing.JTextField();
        tombolGOtambahData2 = new javax.swing.JButton();
        jLabel30 = new javax.swing.JLabel();
        LabelBGTambahlKelas8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);
        setResizable(false);

        PanelUtama.setBackground(new java.awt.Color(0, 255, 153));
        PanelUtama.setLayout(null);

        MenuAdmin.setBackground(new java.awt.Color(0, 204, 204));
        MenuAdmin.setLayout(null);

        tombolKeluar.setText("Keluar");
        tombolKeluar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tombolKeluarActionPerformed(evt);
            }
        });
        MenuAdmin.add(tombolKeluar);
        tombolKeluar.setBounds(20, 440, 103, 23);

        TombolTampilKelas.setFont(new java.awt.Font("Times New Roman", 1, 10)); // NOI18N
        TombolTampilKelas.setText("Tampil Kelas");
        TombolTampilKelas.setActionCommand("");
        TombolTampilKelas.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        TombolTampilKelas.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        TombolTampilKelas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TombolTampilKelasActionPerformed(evt);
            }
        });
        MenuAdmin.add(TombolTampilKelas);
        TombolTampilKelas.setBounds(20, 70, 100, 20);

        LabeljudMenuADMIN.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        LabeljudMenuADMIN.setText("MENU ADMIN");
        MenuAdmin.add(LabeljudMenuADMIN);
        LabeljudMenuADMIN.setBounds(30, 14, 80, 20);

        TombolTambahKelas.setFont(new java.awt.Font("Times New Roman", 1, 10)); // NOI18N
        TombolTambahKelas.setText("Tambah Kelas");
        TombolTambahKelas.setActionCommand("");
        TombolTambahKelas.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        TombolTambahKelas.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        TombolTambahKelas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TombolTambahKelasActionPerformed(evt);
            }
        });
        MenuAdmin.add(TombolTambahKelas);
        TombolTambahKelas.setBounds(20, 100, 100, 20);

        tombolTambahMhs.setFont(new java.awt.Font("Times New Roman", 1, 10)); // NOI18N
        tombolTambahMhs.setText("Tambah Mahasiswa");
        tombolTambahMhs.setActionCommand("");
        tombolTambahMhs.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tombolTambahMhs.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tombolTambahMhs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tombolTambahMhsActionPerformed(evt);
            }
        });
        MenuAdmin.add(tombolTambahMhs);
        tombolTambahMhs.setBounds(10, 280, 120, 20);

        TombolEditKelas.setFont(new java.awt.Font("Times New Roman", 1, 10)); // NOI18N
        TombolEditKelas.setText("Edit Kelas");
        TombolEditKelas.setActionCommand("");
        TombolEditKelas.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        TombolEditKelas.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        TombolEditKelas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TombolEditKelasActionPerformed(evt);
            }
        });
        MenuAdmin.add(TombolEditKelas);
        TombolEditKelas.setBounds(20, 130, 100, 20);

        tombolTampilDosen.setFont(new java.awt.Font("Times New Roman", 1, 10)); // NOI18N
        tombolTampilDosen.setText("Tampil Dosen");
        tombolTampilDosen.setActionCommand("");
        tombolTampilDosen.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tombolTampilDosen.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tombolTampilDosen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tombolTampilDosenActionPerformed(evt);
            }
        });
        MenuAdmin.add(tombolTampilDosen);
        tombolTampilDosen.setBounds(20, 160, 100, 20);

        tombolTambahlDosen.setFont(new java.awt.Font("Times New Roman", 1, 10)); // NOI18N
        tombolTambahlDosen.setText("Tambah Dosen");
        tombolTambahlDosen.setActionCommand("");
        tombolTambahlDosen.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tombolTambahlDosen.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tombolTambahlDosen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tombolTambahlDosenActionPerformed(evt);
            }
        });
        MenuAdmin.add(tombolTambahlDosen);
        tombolTambahlDosen.setBounds(20, 190, 100, 20);

        tombolEditlDosen.setFont(new java.awt.Font("Times New Roman", 1, 10)); // NOI18N
        tombolEditlDosen.setText("Edit Dosen");
        tombolEditlDosen.setActionCommand("");
        tombolEditlDosen.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tombolEditlDosen.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tombolEditlDosen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tombolEditlDosenActionPerformed(evt);
            }
        });
        MenuAdmin.add(tombolEditlDosen);
        tombolEditlDosen.setBounds(20, 220, 100, 20);

        TombolisiData.setFont(new java.awt.Font("Times New Roman", 1, 10)); // NOI18N
        TombolisiData.setText("ISI DATA");
        TombolisiData.setActionCommand("");
        TombolisiData.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        TombolisiData.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        TombolisiData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TombolisiDataActionPerformed(evt);
            }
        });
        MenuAdmin.add(TombolisiData);
        TombolisiData.setBounds(10, 340, 120, 20);

        tombolTampilMhs.setFont(new java.awt.Font("Times New Roman", 1, 10)); // NOI18N
        tombolTampilMhs.setText("Tampil Mahasiswa");
        tombolTampilMhs.setActionCommand("");
        tombolTampilMhs.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tombolTampilMhs.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tombolTampilMhs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tombolTampilMhsActionPerformed(evt);
            }
        });
        MenuAdmin.add(tombolTampilMhs);
        tombolTampilMhs.setBounds(10, 250, 120, 20);

        tombolEditData.setFont(new java.awt.Font("Times New Roman", 1, 10)); // NOI18N
        tombolEditData.setText("Edit Kehadiran");
        tombolEditData.setActionCommand("");
        tombolEditData.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tombolEditData.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tombolEditData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tombolEditDataActionPerformed(evt);
            }
        });
        MenuAdmin.add(tombolEditData);
        tombolEditData.setBounds(10, 370, 120, 20);

        tombolTampilHadir.setFont(new java.awt.Font("Times New Roman", 1, 10)); // NOI18N
        tombolTampilHadir.setText("Tampil Kehadiran");
        tombolTampilHadir.setActionCommand("");
        tombolTampilHadir.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tombolTampilHadir.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tombolTampilHadir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tombolTampilHadirActionPerformed(evt);
            }
        });
        MenuAdmin.add(tombolTampilHadir);
        tombolTampilHadir.setBounds(10, 400, 120, 20);

        tombolEditMhs.setFont(new java.awt.Font("Times New Roman", 1, 10)); // NOI18N
        tombolEditMhs.setText("Edit Mahasiswa");
        tombolEditMhs.setActionCommand("");
        tombolEditMhs.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        tombolEditMhs.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        tombolEditMhs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tombolEditMhsActionPerformed(evt);
            }
        });
        MenuAdmin.add(tombolEditMhs);
        tombolEditMhs.setBounds(10, 310, 120, 20);

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

        PanelTampilKelas.setLayout(null);

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
        jScrollPane1.setBounds(50, 90, 452, 360);

        LabelMenuTampilKelas.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        LabelMenuTampilKelas.setText("Tampil Kelas");
        PanelTampilKelas.add(LabelMenuTampilKelas);
        LabelMenuTampilKelas.setBounds(230, 40, 80, 20);

        LabelBGTampilKelas.setIcon(new javax.swing.ImageIcon("C:\\Users\\asus\\Downloads\\basel-switzerland-world-hd-wallpaper-1920x1080-3674.jpg")); // NOI18N
        PanelTampilKelas.add(LabelBGTampilKelas);
        LabelBGTampilKelas.setBounds(0, 0, 530, 520);

        PanelUtama.add(PanelTampilKelas);
        PanelTampilKelas.setBounds(150, 0, 530, 520);

        PanelTambahlKelas.setLayout(null);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 10)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("Nama Mata Kuliah");
        PanelTambahlKelas.add(jLabel2);
        jLabel2.setBounds(200, 100, 130, 20);

        TabelTambahKelas.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane2.setViewportView(TabelTambahKelas);

        PanelTambahlKelas.add(jScrollPane2);
        jScrollPane2.setBounds(40, 220, 452, 220);

        LabelMenuTambahlKelas.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        LabelMenuTambahlKelas.setText("Tambah Kelas");
        PanelTambahlKelas.add(LabelMenuTambahlKelas);
        LabelMenuTambahlKelas.setBounds(220, 40, 90, 20);

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 10)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("NIP Dosen");
        PanelTambahlKelas.add(jLabel3);
        jLabel3.setBounds(350, 100, 130, 20);

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 10)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Kode");
        PanelTambahlKelas.add(jLabel4);
        jLabel4.setBounds(50, 100, 130, 20);
        PanelTambahlKelas.add(getNamaMKTambahKelas);
        getNamaMKTambahKelas.setBounds(200, 120, 130, 30);
        PanelTambahlKelas.add(getNIPTambahKelas);
        getNIPTambahKelas.setBounds(350, 120, 130, 30);
        PanelTambahlKelas.add(getKodeTambahKelas);
        getKodeTambahKelas.setBounds(50, 120, 130, 30);

        TomboladdTambahKelas.setText("Tambah");
        TomboladdTambahKelas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TomboladdTambahKelasActionPerformed(evt);
            }
        });
        PanelTambahlKelas.add(TomboladdTambahKelas);
        TomboladdTambahKelas.setBounds(390, 170, 90, 23);

        LabelBGTambahlKelas.setIcon(new javax.swing.ImageIcon("C:\\Users\\asus\\Downloads\\basel-switzerland-world-hd-wallpaper-1920x1080-3674.jpg")); // NOI18N
        PanelTambahlKelas.add(LabelBGTambahlKelas);
        LabelBGTambahlKelas.setBounds(0, 0, 530, 520);

        PanelUtama.add(PanelTambahlKelas);
        PanelTambahlKelas.setBounds(150, 0, 530, 520);

        PanelEditlKelas.setLayout(null);

        jLabel5.setFont(new java.awt.Font("Times New Roman", 1, 10)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("Nama Mata Kuliah");
        PanelEditlKelas.add(jLabel5);
        jLabel5.setBounds(40, 150, 130, 20);

        TabelTambahKelas1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane3.setViewportView(TabelTambahKelas1);

        PanelEditlKelas.add(jScrollPane3);
        jScrollPane3.setBounds(40, 220, 452, 220);

        LabelMenuTambahlKelas1.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        LabelMenuTambahlKelas1.setText("Edit Kelas");
        PanelEditlKelas.add(LabelMenuTambahlKelas1);
        LabelMenuTambahlKelas1.setBounds(230, 40, 70, 20);

        jLabel6.setFont(new java.awt.Font("Times New Roman", 1, 10)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("NIP Dosen");
        PanelEditlKelas.add(jLabel6);
        jLabel6.setBounds(180, 150, 130, 20);

        jLabel7.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("Kode");
        PanelEditlKelas.add(jLabel7);
        jLabel7.setBounds(110, 90, 130, 30);

        getNamaMKTambahKelas1.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        PanelEditlKelas.add(getNamaMKTambahKelas1);
        getNamaMKTambahKelas1.setBounds(40, 170, 130, 30);
        PanelEditlKelas.add(getNIPTambahKelas1);
        getNIPTambahKelas1.setBounds(180, 170, 130, 30);
        PanelEditlKelas.add(getKodeTambahKelas1);
        getKodeTambahKelas1.setBounds(250, 90, 130, 30);

        TombolUpdateEditKelas.setText("Update");
        TombolUpdateEditKelas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TombolUpdateEditKelasActionPerformed(evt);
            }
        });
        PanelEditlKelas.add(TombolUpdateEditKelas);
        TombolUpdateEditKelas.setBounds(320, 170, 70, 30);

        TombolGoEditKelas.setText("GO");
        TombolGoEditKelas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TombolGoEditKelasActionPerformed(evt);
            }
        });
        PanelEditlKelas.add(TombolGoEditKelas);
        TombolGoEditKelas.setBounds(390, 90, 90, 30);

        TombolDeleteEditKelas.setText("Delete");
        TombolDeleteEditKelas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TombolDeleteEditKelasActionPerformed(evt);
            }
        });
        PanelEditlKelas.add(TombolDeleteEditKelas);
        TombolDeleteEditKelas.setBounds(400, 170, 80, 30);

        LabelBGTambahlKelas1.setIcon(new javax.swing.ImageIcon("C:\\Users\\asus\\Downloads\\basel-switzerland-world-hd-wallpaper-1920x1080-3674.jpg")); // NOI18N
        PanelEditlKelas.add(LabelBGTambahlKelas1);
        LabelBGTambahlKelas1.setBounds(0, 0, 530, 520);

        PanelUtama.add(PanelEditlKelas);
        PanelEditlKelas.setBounds(150, 0, 530, 520);

        PanelTampilDosen.setLayout(null);

        TabelTampilDosen.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane4.setViewportView(TabelTampilDosen);

        PanelTampilDosen.add(jScrollPane4);
        jScrollPane4.setBounds(50, 90, 452, 360);

        LabelMenuTampilDosen.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        LabelMenuTampilDosen.setText("Tampil Dosen");
        PanelTampilDosen.add(LabelMenuTampilDosen);
        LabelMenuTampilDosen.setBounds(230, 40, 90, 20);

        LabelBGTampilKelas1.setIcon(new javax.swing.ImageIcon("C:\\Users\\asus\\Downloads\\basel-switzerland-world-hd-wallpaper-1920x1080-3674.jpg")); // NOI18N
        PanelTampilDosen.add(LabelBGTampilKelas1);
        LabelBGTampilKelas1.setBounds(0, 0, 530, 520);

        PanelUtama.add(PanelTampilDosen);
        PanelTampilDosen.setBounds(150, 0, 530, 520);

        PanelTambahlDosen.setLayout(null);

        jLabel8.setFont(new java.awt.Font("Times New Roman", 1, 10)); // NOI18N
        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("Nama Dosen");
        PanelTambahlDosen.add(jLabel8);
        jLabel8.setBounds(200, 100, 130, 20);

        TabelTambahDosen.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane6.setViewportView(TabelTambahDosen);

        PanelTambahlDosen.add(jScrollPane6);
        jScrollPane6.setBounds(40, 220, 452, 220);

        LabelMenuTambahlKelas2.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        LabelMenuTambahlKelas2.setText("Tambah Dosen");
        PanelTambahlDosen.add(LabelMenuTambahlKelas2);
        LabelMenuTambahlKelas2.setBounds(220, 40, 100, 20);

        jLabel9.setFont(new java.awt.Font("Times New Roman", 1, 10)); // NOI18N
        jLabel9.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel9.setText("Password");
        PanelTambahlDosen.add(jLabel9);
        jLabel9.setBounds(350, 100, 130, 20);

        jLabel10.setFont(new java.awt.Font("Times New Roman", 1, 10)); // NOI18N
        jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel10.setText("NIP");
        PanelTambahlDosen.add(jLabel10);
        jLabel10.setBounds(50, 100, 130, 20);
        PanelTambahlDosen.add(getNamaTambahDosen);
        getNamaTambahDosen.setBounds(200, 120, 130, 30);
        PanelTambahlDosen.add(getPassTambahDosen);
        getPassTambahDosen.setBounds(350, 120, 130, 30);
        PanelTambahlDosen.add(getNIPTambahDosen);
        getNIPTambahDosen.setBounds(50, 120, 130, 30);

        TomboladdTambahDosen.setText("Tambah");
        TomboladdTambahDosen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TomboladdTambahDosenActionPerformed(evt);
            }
        });
        PanelTambahlDosen.add(TomboladdTambahDosen);
        TomboladdTambahDosen.setBounds(390, 170, 90, 23);

        LabelBGTambahlKelas2.setIcon(new javax.swing.ImageIcon("C:\\Users\\asus\\Downloads\\basel-switzerland-world-hd-wallpaper-1920x1080-3674.jpg")); // NOI18N
        PanelTambahlDosen.add(LabelBGTambahlKelas2);
        LabelBGTambahlKelas2.setBounds(0, 0, 530, 520);

        PanelUtama.add(PanelTambahlDosen);
        PanelTambahlDosen.setBounds(150, 0, 530, 520);

        PanelEditlDosen.setLayout(null);

        jLabel11.setFont(new java.awt.Font("Times New Roman", 1, 10)); // NOI18N
        jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel11.setText("Nama Dosen");
        PanelEditlDosen.add(jLabel11);
        jLabel11.setBounds(40, 150, 130, 20);

        TabelEditDosen.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane5.setViewportView(TabelEditDosen);

        PanelEditlDosen.add(jScrollPane5);
        jScrollPane5.setBounds(40, 220, 452, 220);

        LabelMenuTambahlKelas3.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        LabelMenuTambahlKelas3.setText("Edit Dosen");
        PanelEditlDosen.add(LabelMenuTambahlKelas3);
        LabelMenuTambahlKelas3.setBounds(230, 40, 70, 20);

        jLabel12.setFont(new java.awt.Font("Times New Roman", 1, 10)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("Password");
        PanelEditlDosen.add(jLabel12);
        jLabel12.setBounds(180, 150, 130, 20);

        jLabel13.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("NIP");
        PanelEditlDosen.add(jLabel13);
        jLabel13.setBounds(110, 90, 130, 30);

        getNamaEditDosen.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        PanelEditlDosen.add(getNamaEditDosen);
        getNamaEditDosen.setBounds(40, 170, 130, 30);
        PanelEditlDosen.add(getPassEDosen);
        getPassEDosen.setBounds(180, 170, 130, 30);
        PanelEditlDosen.add(getNIPEditDosen);
        getNIPEditDosen.setBounds(250, 90, 130, 30);

        TombolUpdateEditDosen.setText("Update");
        TombolUpdateEditDosen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TombolUpdateEditDosenActionPerformed(evt);
            }
        });
        PanelEditlDosen.add(TombolUpdateEditDosen);
        TombolUpdateEditDosen.setBounds(320, 170, 70, 30);

        TombolGoEditKelas1.setText("GO");
        TombolGoEditKelas1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TombolGoEditKelas1ActionPerformed(evt);
            }
        });
        PanelEditlDosen.add(TombolGoEditKelas1);
        TombolGoEditKelas1.setBounds(390, 90, 90, 30);

        TombolDeleteEditDosen.setText("Delete");
        TombolDeleteEditDosen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TombolDeleteEditDosenActionPerformed(evt);
            }
        });
        PanelEditlDosen.add(TombolDeleteEditDosen);
        TombolDeleteEditDosen.setBounds(400, 170, 80, 30);

        LabelBGTambahlKelas3.setIcon(new javax.swing.ImageIcon("C:\\Users\\asus\\Downloads\\basel-switzerland-world-hd-wallpaper-1920x1080-3674.jpg")); // NOI18N
        PanelEditlDosen.add(LabelBGTambahlKelas3);
        LabelBGTambahlKelas3.setBounds(0, 0, 530, 520);

        PanelUtama.add(PanelEditlDosen);
        PanelEditlDosen.setBounds(150, 0, 530, 520);

        PanelTampilMahasiswa.setLayout(null);

        TabelTampilMhs.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane7.setViewportView(TabelTampilMhs);

        PanelTampilMahasiswa.add(jScrollPane7);
        jScrollPane7.setBounds(50, 90, 452, 360);

        LabelMenuTampilmhs.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        LabelMenuTampilmhs.setText("Tampil Mahasiswa");
        PanelTampilMahasiswa.add(LabelMenuTampilmhs);
        LabelMenuTampilmhs.setBounds(210, 40, 120, 20);

        LabelBGTampilKelas2.setIcon(new javax.swing.ImageIcon("C:\\Users\\asus\\Downloads\\basel-switzerland-world-hd-wallpaper-1920x1080-3674.jpg")); // NOI18N
        PanelTampilMahasiswa.add(LabelBGTampilKelas2);
        LabelBGTampilKelas2.setBounds(0, 0, 530, 520);

        PanelUtama.add(PanelTampilMahasiswa);
        PanelTampilMahasiswa.setBounds(150, 0, 530, 520);

        PanelEditMhs.setLayout(null);

        jLabel14.setFont(new java.awt.Font("Times New Roman", 1, 10)); // NOI18N
        jLabel14.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel14.setText("Nama");
        PanelEditMhs.add(jLabel14);
        jLabel14.setBounds(40, 150, 130, 20);

        TabelEditMhs.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane8.setViewportView(TabelEditMhs);

        PanelEditMhs.add(jScrollPane8);
        jScrollPane8.setBounds(40, 220, 452, 220);

        LabelMenuTambahlKelas4.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        LabelMenuTambahlKelas4.setText("Edit Mahasiswa");
        PanelEditMhs.add(LabelMenuTambahlKelas4);
        LabelMenuTambahlKelas4.setBounds(230, 40, 100, 20);

        jLabel15.setFont(new java.awt.Font("Times New Roman", 1, 10)); // NOI18N
        jLabel15.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel15.setText("Angkatan");
        PanelEditMhs.add(jLabel15);
        jLabel15.setBounds(180, 150, 130, 20);

        jLabel16.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("NIM");
        PanelEditMhs.add(jLabel16);
        jLabel16.setBounds(110, 90, 130, 30);

        getNamaEditMhs.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        PanelEditMhs.add(getNamaEditMhs);
        getNamaEditMhs.setBounds(40, 170, 130, 30);
        PanelEditMhs.add(getAngkatanEditMhs);
        getAngkatanEditMhs.setBounds(180, 170, 130, 30);
        PanelEditMhs.add(getNimEditMhs);
        getNimEditMhs.setBounds(250, 90, 130, 30);

        TombolUpdateEditMhs.setText("Update");
        TombolUpdateEditMhs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TombolUpdateEditMhsActionPerformed(evt);
            }
        });
        PanelEditMhs.add(TombolUpdateEditMhs);
        TombolUpdateEditMhs.setBounds(320, 170, 70, 30);

        TombolGoEditMhs.setText("GO");
        TombolGoEditMhs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TombolGoEditMhsActionPerformed(evt);
            }
        });
        PanelEditMhs.add(TombolGoEditMhs);
        TombolGoEditMhs.setBounds(390, 90, 90, 30);

        TombolDeleteEditMhs.setText("Delete");
        TombolDeleteEditMhs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TombolDeleteEditMhsActionPerformed(evt);
            }
        });
        PanelEditMhs.add(TombolDeleteEditMhs);
        TombolDeleteEditMhs.setBounds(400, 170, 80, 30);

        LabelBGTambahlKelas4.setIcon(new javax.swing.ImageIcon("C:\\Users\\asus\\Downloads\\basel-switzerland-world-hd-wallpaper-1920x1080-3674.jpg")); // NOI18N
        PanelEditMhs.add(LabelBGTambahlKelas4);
        LabelBGTambahlKelas4.setBounds(0, 0, 530, 520);

        PanelUtama.add(PanelEditMhs);
        PanelEditMhs.setBounds(150, 0, 530, 520);

        PanelTambahMhs.setLayout(null);

        jLabel17.setFont(new java.awt.Font("Times New Roman", 1, 10)); // NOI18N
        jLabel17.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel17.setText("Nama");
        PanelTambahMhs.add(jLabel17);
        jLabel17.setBounds(200, 100, 130, 20);

        TabelTambahMhs.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane9.setViewportView(TabelTambahMhs);

        PanelTambahMhs.add(jScrollPane9);
        jScrollPane9.setBounds(40, 220, 452, 220);

        LabelMenuTambahlKelas5.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        LabelMenuTambahlKelas5.setText("Tambah Mahasiswa");
        PanelTambahMhs.add(LabelMenuTambahlKelas5);
        LabelMenuTambahlKelas5.setBounds(210, 40, 120, 20);

        jLabel18.setFont(new java.awt.Font("Times New Roman", 1, 10)); // NOI18N
        jLabel18.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel18.setText("Angkatan");
        PanelTambahMhs.add(jLabel18);
        jLabel18.setBounds(350, 100, 130, 20);

        NIM.setFont(new java.awt.Font("Times New Roman", 1, 10)); // NOI18N
        NIM.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        NIM.setText("NIM");
        PanelTambahMhs.add(NIM);
        NIM.setBounds(50, 100, 130, 20);
        PanelTambahMhs.add(getNamaTambahMhs);
        getNamaTambahMhs.setBounds(200, 120, 130, 30);
        PanelTambahMhs.add(getAngkatanTambahMhs);
        getAngkatanTambahMhs.setBounds(350, 120, 130, 30);
        PanelTambahMhs.add(getNIMTambahMhs);
        getNIMTambahMhs.setBounds(50, 120, 130, 30);

        TomboladdTambahMhs.setText("Tambah");
        TomboladdTambahMhs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TomboladdTambahMhsActionPerformed(evt);
            }
        });
        PanelTambahMhs.add(TomboladdTambahMhs);
        TomboladdTambahMhs.setBounds(390, 170, 90, 23);

        LabelBGTambahlKelas5.setIcon(new javax.swing.ImageIcon("C:\\Users\\asus\\Downloads\\basel-switzerland-world-hd-wallpaper-1920x1080-3674.jpg")); // NOI18N
        PanelTambahMhs.add(LabelBGTambahlKelas5);
        LabelBGTambahlKelas5.setBounds(0, 0, 530, 520);

        PanelUtama.add(PanelTambahMhs);
        PanelTambahMhs.setBounds(150, 0, 530, 520);

        PanelIsiKehadiran.setLayout(null);

        jLabel19.setFont(new java.awt.Font("Times New Roman", 1, 10)); // NOI18N
        jLabel19.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel19.setText("Sakit");
        PanelIsiKehadiran.add(jLabel19);
        jLabel19.setBounds(210, 160, 130, 20);

        TabelTambahData.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane10.setViewportView(TabelTambahData);

        PanelIsiKehadiran.add(jScrollPane10);
        jScrollPane10.setBounds(12, 250, 510, 250);

        LabelMenuTambahlKelas6.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        LabelMenuTambahlKelas6.setText("Tambahkan Data Ke Kelas");
        PanelIsiKehadiran.add(LabelMenuTambahlKelas6);
        LabelMenuTambahlKelas6.setBounds(180, 40, 180, 20);

        jLabel20.setFont(new java.awt.Font("Times New Roman", 1, 10)); // NOI18N
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("Absen");
        PanelIsiKehadiran.add(jLabel20);
        jLabel20.setBounds(360, 160, 130, 20);

        jLabel21.setFont(new java.awt.Font("Times New Roman", 1, 10)); // NOI18N
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("NIM");
        PanelIsiKehadiran.add(jLabel21);
        jLabel21.setBounds(60, 160, 130, 20);
        PanelIsiKehadiran.add(getSakitcTambahData);
        getSakitcTambahData.setBounds(210, 180, 130, 30);
        PanelIsiKehadiran.add(getAbsencTambahData);
        getAbsencTambahData.setBounds(360, 180, 130, 30);
        PanelIsiKehadiran.add(getNIMcTambahData);
        getNIMcTambahData.setBounds(60, 180, 130, 30);
        PanelIsiKehadiran.add(getKodeMkcTambahData);
        getKodeMkcTambahData.setBounds(210, 100, 190, 30);

        TomboladdTambahDosen1.setText("Tambah");
        TomboladdTambahDosen1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TomboladdTambahDosen1ActionPerformed(evt);
            }
        });
        PanelIsiKehadiran.add(TomboladdTambahDosen1);
        TomboladdTambahDosen1.setBounds(400, 220, 90, 23);

        tombolGOtambahData.setText("GO");
        tombolGOtambahData.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tombolGOtambahDataActionPerformed(evt);
            }
        });
        PanelIsiKehadiran.add(tombolGOtambahData);
        tombolGOtambahData.setBounds(430, 93, 60, 40);

        jLabel22.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel22.setText("Kode  MK");
        PanelIsiKehadiran.add(jLabel22);
        jLabel22.setBounds(130, 100, 60, 30);

        LabelBGTambahlKelas6.setIcon(new javax.swing.ImageIcon("C:\\Users\\asus\\Downloads\\basel-switzerland-world-hd-wallpaper-1920x1080-3674.jpg")); // NOI18N
        PanelIsiKehadiran.add(LabelBGTambahlKelas6);
        LabelBGTambahlKelas6.setBounds(0, 0, 530, 520);

        PanelUtama.add(PanelIsiKehadiran);
        PanelIsiKehadiran.setBounds(150, 0, 530, 520);

        PanelEditKehadiran.setLayout(null);

        jLabel23.setFont(new java.awt.Font("Times New Roman", 1, 10)); // NOI18N
        jLabel23.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel23.setText("Sakit");
        PanelEditKehadiran.add(jLabel23);
        jLabel23.setBounds(210, 160, 130, 20);

        TabelTambahData1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane11.setViewportView(TabelTambahData1);

        PanelEditKehadiran.add(jScrollPane11);
        jScrollPane11.setBounds(12, 250, 510, 250);

        LabelMenuTambahlKelas7.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        LabelMenuTambahlKelas7.setText("Edit Data Kelas");
        PanelEditKehadiran.add(LabelMenuTambahlKelas7);
        LabelMenuTambahlKelas7.setBounds(230, 40, 100, 20);

        jLabel24.setFont(new java.awt.Font("Times New Roman", 1, 10)); // NOI18N
        jLabel24.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel24.setText("Absen");
        PanelEditKehadiran.add(jLabel24);
        jLabel24.setBounds(360, 160, 130, 20);

        jLabel25.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel25.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel25.setText("NIM");
        PanelEditKehadiran.add(jLabel25);
        jLabel25.setBounds(240, 100, 40, 30);
        PanelEditKehadiran.add(getSakitcTambahData1);
        getSakitcTambahData1.setBounds(210, 180, 130, 30);
        PanelEditKehadiran.add(getAbsencTambahData1);
        getAbsencTambahData1.setBounds(360, 180, 130, 30);
        PanelEditKehadiran.add(getNIMcTambahData1);
        getNIMcTambahData1.setBounds(290, 100, 130, 30);
        PanelEditKehadiran.add(getKodeMkcTambahData1);
        getKodeMkcTambahData1.setBounds(90, 100, 110, 30);

        TomboladdTambahDosen2.setText("EDIT");
        TomboladdTambahDosen2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                TomboladdTambahDosen2ActionPerformed(evt);
            }
        });
        PanelEditKehadiran.add(TomboladdTambahDosen2);
        TomboladdTambahDosen2.setBounds(400, 220, 90, 23);

        tombolGOtambahData1.setText("GO");
        tombolGOtambahData1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tombolGOtambahData1ActionPerformed(evt);
            }
        });
        PanelEditKehadiran.add(tombolGOtambahData1);
        tombolGOtambahData1.setBounds(430, 93, 60, 40);

        jLabel26.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel26.setText("Kode  MK");
        PanelEditKehadiran.add(jLabel26);
        jLabel26.setBounds(30, 100, 60, 30);

        jButton1.setText("Hapus");
        jButton1.setActionCommand("delete");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        PanelEditKehadiran.add(jButton1);
        jButton1.setBounds(260, 220, 80, 23);

        LabelBGTambahlKelas7.setIcon(new javax.swing.ImageIcon("C:\\Users\\asus\\Downloads\\basel-switzerland-world-hd-wallpaper-1920x1080-3674.jpg")); // NOI18N
        PanelEditKehadiran.add(LabelBGTambahlKelas7);
        LabelBGTambahlKelas7.setBounds(0, 0, 530, 520);

        PanelUtama.add(PanelEditKehadiran);
        PanelEditKehadiran.setBounds(150, 0, 530, 520);

        PanelTampilKehadiran.setLayout(null);

        TabelTambahData2.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane12.setViewportView(TabelTambahData2);

        PanelTampilKehadiran.add(jScrollPane12);
        jScrollPane12.setBounds(12, 150, 510, 350);

        LabelMenuTambahlKelas8.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        LabelMenuTambahlKelas8.setText("Tampil Data Kelas");
        PanelTampilKehadiran.add(LabelMenuTambahlKelas8);
        LabelMenuTambahlKelas8.setBounds(220, 40, 120, 20);
        PanelTampilKehadiran.add(getKodeMkcTamnahDataKeKelas);
        getKodeMkcTamnahDataKeKelas.setBounds(210, 100, 190, 30);

        tombolGOtambahData2.setText("GO");
        tombolGOtambahData2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tombolGOtambahData2ActionPerformed(evt);
            }
        });
        PanelTampilKehadiran.add(tombolGOtambahData2);
        tombolGOtambahData2.setBounds(430, 93, 60, 40);

        jLabel30.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        jLabel30.setText("Kode  MK");
        PanelTampilKehadiran.add(jLabel30);
        jLabel30.setBounds(130, 100, 60, 30);

        LabelBGTambahlKelas8.setIcon(new javax.swing.ImageIcon("C:\\Users\\asus\\Downloads\\basel-switzerland-world-hd-wallpaper-1920x1080-3674.jpg")); // NOI18N
        PanelTampilKehadiran.add(LabelBGTambahlKelas8);
        LabelBGTambahlKelas8.setBounds(0, 0, 530, 520);

        PanelUtama.add(PanelTampilKehadiran);
        PanelTampilKehadiran.setBounds(150, 0, 530, 520);

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
    }// </editor-fold>                        

    private void tombolKeluarActionPerformed(java.awt.event.ActionEvent evt) {                                             
        // TODO add your handling code here:
        System.exit(0);
    }                                            

    private void tombolEditlDosenActionPerformed(java.awt.event.ActionEvent evt) {                                                 
        // TODO add your handling code here:
        isiTabelDosen();
        TabelEditDosen.setModel(tab);
        
        MenuSelamatDatang.setVisible(false);
        PanelTambahlKelas.setVisible(false);    //Mahasiswa
        PanelTampilKelas.setVisible(false);
        PanelEditlKelas.setVisible(false);
        PanelTampilDosen.setVisible(false);     //dosen
        PanelTambahlDosen.setVisible(false);
        PanelEditlDosen.setVisible(true);
        PanelTampilMahasiswa.setVisible(false); //Mahasiswa
        PanelEditMhs.setVisible(false);
        PanelTambahMhs.setVisible(false);
        PanelEditKehadiran.setVisible(false);   //kehadiran
        PanelIsiKehadiran.setVisible(false);    
        PanelTampilKehadiran.setVisible(false);
    }                                                

    private void TombolTampilKelasActionPerformed(java.awt.event.ActionEvent evt) {                                                  
        // TODO add your handling code here:
        isiTabelKelas();
        TabelTampilKelas.setModel(tab);
        
        MenuSelamatDatang.setVisible(false);
        PanelTambahlKelas.setVisible(false);    //Mahasiswa
        PanelTampilKelas.setVisible(true);
        PanelEditlKelas.setVisible(false);
        PanelTampilDosen.setVisible(false);     //dosen
        PanelTambahlDosen.setVisible(false);
        PanelEditlDosen.setVisible(false);
        PanelTampilMahasiswa.setVisible(false); //Mahasiswa
        PanelEditMhs.setVisible(false);
        PanelTambahMhs.setVisible(false);
        PanelEditKehadiran.setVisible(false);   //kehadiran
        PanelIsiKehadiran.setVisible(false);    
        PanelTampilKehadiran.setVisible(false);
    }                                                 

    private void TombolTambahKelasActionPerformed(java.awt.event.ActionEvent evt) {                                                  
        // TODO add your handling code here:
        isiTabelKelas();
        TabelTambahKelas.setModel(tab);
        
        MenuSelamatDatang.setVisible(false);
        PanelTambahlKelas.setVisible(true);    //Mahasiswa
        PanelTampilKelas.setVisible(false);
        PanelEditlKelas.setVisible(false);
        PanelTampilDosen.setVisible(false);     //dosen
        PanelTambahlDosen.setVisible(false);
        PanelEditlDosen.setVisible(false);
        PanelTampilMahasiswa.setVisible(false); //Mahasiswa
        PanelEditMhs.setVisible(false);
        PanelTambahMhs.setVisible(false);
        PanelEditKehadiran.setVisible(false);   //kehadiran
        PanelIsiKehadiran.setVisible(false);    
        PanelTampilKehadiran.setVisible(false);
    }                                                 

    private void TomboladdTambahKelasActionPerformed(java.awt.event.ActionEvent evt) {                                                     
        // TODO add your handling code here:
        String Kode = getKodeTambahKelas.getText();
        String Nama = getNamaMKTambahKelas.getText();
        String NIP = getNIPTambahKelas.getText();
        
        try {
            Connection BD = koneksi.getConection();
            Statement stm = BD.createStatement();
            stm.executeUpdate("INSERT INTO `kelas` (`Kode_Kelas`, "
                    + "`NIPDosen_Kelas`, `Nama_Kelas`) VALUES "
                    + "('"+Kode+"', '"+NIP+"', '"+Nama+"');");
            kelas x = new kelas(Nama, NIP);
            Okelas.put(Kode, x);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        isiTabelKelas();
        TabelTambahKelas.setModel(tab);
    }                                                    

    private void TombolUpdateEditKelasActionPerformed(java.awt.event.ActionEvent evt) {                                                      
        // TODO add your handling code here:
        String Kode = getKodeTambahKelas1.getText();
        String Nama = getNamaMKTambahKelas1.getText();
        String NIP = getNIPTambahKelas1.getText();
        
        
        
        try {
            Connection BD = koneksi.getConection();
            Statement stm = BD.createStatement();
            stm.executeUpdate("UPDATE `kelas` SET `Nama_Kelas` = "
                    + "'"+Nama+"', NIPDosen_Kelas = '"+NIP+"' WHERE "
                    + "`kelas`.`Kode_Kelas` = '"+Kode+"';");
            kelas v = new kelas(Nama, NIP);
            Okelas.replace(Kode, v);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        isiTabelKelas();
        TabelTambahKelas1.setModel(tab);
    }                                                     

    private void TombolEditKelasActionPerformed(java.awt.event.ActionEvent evt) {                                                
        // TODO add your handling code here:
        isiTabelKelas();
        TabelTambahKelas1.setModel(tab);
        
        MenuSelamatDatang.setVisible(false);
        PanelTambahlKelas.setVisible(false);    //Mahasiswa
        PanelTampilKelas.setVisible(false);
        PanelEditlKelas.setVisible(true);
        PanelTampilDosen.setVisible(false);     //dosen
        PanelTambahlDosen.setVisible(false);
        PanelEditlDosen.setVisible(false);
        PanelTampilMahasiswa.setVisible(false); //Mahasiswa
        PanelEditMhs.setVisible(false);
        PanelTambahMhs.setVisible(false);
        PanelEditKehadiran.setVisible(false);   //kehadiran
        PanelIsiKehadiran.setVisible(false);    
        PanelTampilKehadiran.setVisible(false);
    }                                               

    private void TombolGoEditKelasActionPerformed(java.awt.event.ActionEvent evt) {                                                  
        // TODO add your handling code here:
        try {
            kelas x = Okelas.get(getKodeTambahKelas1.getText());
            getNIPTambahKelas1.setText(x.id_dosen);
            getNamaMKTambahKelas1.setText(x.Nama);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Data Tidak Valid", "Error", JOptionPane.ERROR_MESSAGE);
        }
        
        
    }                                                 

    private void TombolDeleteEditKelasActionPerformed(java.awt.event.ActionEvent evt) {                                                      
        // TODO add your handling code here:
        String Kode = getKodeTambahKelas1.getText();
        String Nama = getNamaMKTambahKelas1.getText();
        String NIP = getNIPTambahKelas1.getText();
        
        try {
            Connection BD = koneksi.getConection();
            Statement stm = BD.createStatement();
            stm.executeUpdate("DELETE FROM `kelas` WHERE `kelas`.`Kode_Kelas` = '"+Kode+"';");
            kelas x = new kelas(Nama, NIP);
            Okelas.remove(Kode);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        isiTabelKelas();
        TabelTambahKelas1.setModel(tab);
    }                                                     

    private void tombolTampilDosenActionPerformed(java.awt.event.ActionEvent evt) {                                                  
        // TODO add your handling code here:
        isiTabelDosen();
        TabelTampilDosen.setModel(tab);
        
        MenuSelamatDatang.setVisible(false);
        PanelTambahlKelas.setVisible(false);    //Mahasiswa
        PanelTampilKelas.setVisible(false);
        PanelEditlKelas.setVisible(false);
        PanelTampilDosen.setVisible(true);     //dosen
        PanelTambahlDosen.setVisible(false);
        PanelEditlDosen.setVisible(false);
        PanelTampilMahasiswa.setVisible(false); //Mahasiswa
        PanelEditMhs.setVisible(false);
        PanelTambahMhs.setVisible(false);
        PanelEditKehadiran.setVisible(false);   //kehadiran
        PanelIsiKehadiran.setVisible(false);    
        PanelTampilKehadiran.setVisible(false);
    }                                                 

    private void TomboladdTambahDosenActionPerformed(java.awt.event.ActionEvent evt) {                                                     
        // TODO add your handling code here:
        String Kode = getPassTambahDosen.getText();
        String Nama = getNamaTambahDosen.getText();
        String NIP = getNIPTambahDosen.getText();
        
        try {
            Connection BD = koneksi.getConection();
            Statement stm = BD.createStatement();
            stm.executeUpdate("INSERT INTO `dosen` (`NIP_Dosen`, "
                    + "`Nama_Dosen`, `Password`) VALUES "
                    + "('"+NIP+"', '"+Nama+"', '"+Kode+"');");
            Dosen x = new Dosen(Nama, NIP, Kode);
            ODosen.put(NIP, x);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        isiTabelDosen();
        TabelTambahDosen.setModel(tab);
    }                                                    

    private void tombolTambahlDosenActionPerformed(java.awt.event.ActionEvent evt) {                                                   
        // TODO add your handling code here:
        isiTabelDosen();
        TabelTambahDosen.setModel(tab);
        
        MenuSelamatDatang.setVisible(false);
        PanelTambahlKelas.setVisible(false);    //Mahasiswa
        PanelTampilKelas.setVisible(false);
        PanelEditlKelas.setVisible(false);
        PanelTampilDosen.setVisible(false);     //dosen
        PanelTambahlDosen.setVisible(true);
        PanelEditlDosen.setVisible(false);
        PanelTampilMahasiswa.setVisible(false); //Mahasiswa
        PanelEditMhs.setVisible(false);
        PanelTambahMhs.setVisible(false);
        PanelEditKehadiran.setVisible(false);   //kehadiran
        PanelIsiKehadiran.setVisible(false);    
        PanelTampilKehadiran.setVisible(false);
    }                                                  

    private void TombolUpdateEditDosenActionPerformed(java.awt.event.ActionEvent evt) {                                                      
        // TODO add your handling code here:
        String Kode = getPassEDosen.getText();
        String Nama = getNamaEditDosen.getText();
        String NIP = getNIPEditDosen.getText();
        
        try {
            Connection BD = koneksi.getConection();
            Statement stm = BD.createStatement();
            stm.executeUpdate("UPDATE `dosen` SET `Nama_Dosen` = "
                    + "'"+Nama+"', Password = '"+Kode+"' WHERE "
                    + "`dosen`.`NIP_Dosen` = '"+NIP+"';");
            Dosen v = new Dosen(Nama, NIP, Kode);
            ODosen.replace(NIP, v);
            isiTabelDosen();
            TabelEditDosen.setModel(tab);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        
    }                                                     

    private void TombolGoEditKelas1ActionPerformed(java.awt.event.ActionEvent evt) {                                                   
        // TODO add your handling code here:
        try {
            Dosen x = ODosen.get(getNIPEditDosen.getText());
            getPassEDosen.setText(x.Password);
            getNamaEditDosen.setText(x.Nama);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Data Tidak Valid", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }                                                  

    private void TombolDeleteEditDosenActionPerformed(java.awt.event.ActionEvent evt) {                                                      
        // TODO add your handling code here:
        String Kode = getPassEDosen.getText();
        String Nama = getNamaEditDosen.getText();
        String NIP = getNIPEditDosen.getText();
        
        try {
            Connection BD = koneksi.getConection();
            Statement stm = BD.createStatement();
            stm.executeUpdate("DELETE FROM `dosen` WHERE `dosen`.`NIP_Dosen` = '"+NIP+"';");
            ODosen.remove(NIP);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        isiTabelDosen();
        TabelEditDosen.setModel(tab);
    }                                                     

    private void tombolTampilMhsActionPerformed(java.awt.event.ActionEvent evt) {                                                
        // TODO add your handling code here:
        isiTabelMhs();
        TabelTampilMhs.setModel(tab);
        
        MenuSelamatDatang.setVisible(false);
        PanelTambahlKelas.setVisible(false);    //Mahasiswa
        PanelTampilKelas.setVisible(false);
        PanelEditlKelas.setVisible(false);
        PanelTampilDosen.setVisible(false);     //dosen
        PanelTambahlDosen.setVisible(false);
        PanelEditlDosen.setVisible(false);
        PanelTampilMahasiswa.setVisible(true); //Mahasiswa
        PanelEditMhs.setVisible(false);
        PanelTambahMhs.setVisible(false);
        PanelEditKehadiran.setVisible(false);   //kehadiran
        PanelIsiKehadiran.setVisible(false);    
        PanelTampilKehadiran.setVisible(false);
    }                                               

    private void TombolUpdateEditMhsActionPerformed(java.awt.event.ActionEvent evt) {                                                    
        // TODO add your handling code here:
        String NIM = getNimEditMhs.getText();
        String Nama = getNamaEditMhs.getText();
        String Angkatan = getAngkatanEditMhs.getText();
        
        try {
            Connection BD = koneksi.getConection();
            Statement stm = BD.createStatement();
            stm.executeUpdate("UPDATE `mahasiswa` SET `Nama_Mahasiwa` = "
                    + "'"+Nama+"', Angkatan = '"+Angkatan+"' WHERE "
                    + "`mahasiswa`.`NIM_Mahasiswa` = '"+NIM+"';");
            Mahasiswa v = new Mahasiswa(Nama, NIM, Angkatan);
            Omhs.replace(NIM, v);
            isiTabelMhs();
            TabelEditMhs.setModel(tab);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        
    }                                                   

    private void TombolGoEditMhsActionPerformed(java.awt.event.ActionEvent evt) {                                                
        // TODO add your handling code here:
        try {
            Mahasiswa x = Omhs.get(getNimEditMhs.getText());
            getAngkatanEditMhs.setText(x.Angkatan);
            getNamaEditMhs.setText(x.Nama);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Data Tidak Valid", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }                                               

    private void TombolDeleteEditMhsActionPerformed(java.awt.event.ActionEvent evt) {                                                    
        // TODO add your handling code here:
        String NIM = getNimEditMhs.getText();
        String Nama = getNamaEditMhs.getText();
        String Angkatan = getAngkatanEditMhs.getText();
        
        try {
            Connection BD = koneksi.getConection();
            Statement stm = BD.createStatement();
            stm.executeUpdate("Delete from `mahasiswa` where NIM_Mahasiswa = '"+NIM+"';");
            Mahasiswa v = new Mahasiswa(Nama, NIM, Angkatan);
            Omhs.remove(NIM);
            isiTabelMhs();
            TabelEditMhs.setModel(tab);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }                                                   

    private void TombolisiDataActionPerformed(java.awt.event.ActionEvent evt) {                                              
        // TODO add your handling code here:
        getKodeMkcTambahData.setText(null);
        isiTabelOdata();
        TabelTambahData.setModel(tab);
        
        MenuSelamatDatang.setVisible(false);
        PanelTambahlKelas.setVisible(false);    //Mahasiswa
        PanelTampilKelas.setVisible(false);
        PanelEditlKelas.setVisible(false);
        PanelTampilDosen.setVisible(false);     //dosen
        PanelTambahlDosen.setVisible(false);
        PanelEditlDosen.setVisible(false);
        PanelTampilMahasiswa.setVisible(false); //Mahasiswa
        PanelEditMhs.setVisible(false);
        PanelTambahMhs.setVisible(false);
        PanelEditKehadiran.setVisible(false);   //kehadiran
        PanelIsiKehadiran.setVisible(true);    
        PanelTampilKehadiran.setVisible(false);
    }                                             

    private void TomboladdTambahMhsActionPerformed(java.awt.event.ActionEvent evt) {                                                   
        // TODO add your handling code here:
        String NIM = getNIMTambahMhs.getText();
        String Nama = getNamaTambahMhs.getText();
        String Angkat = getAngkatanTambahMhs.getText();
        
        try {
            if(getNIMTambahMhs.getText().equals(null) || getNamaTambahMhs.getText().equals(null) || getAngkatanTambahMhs.getText().equals(null)) {
                JOptionPane.showMessageDialog(null, "Data Salah", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
            Connection BD = koneksi.getConection();
            Statement stm = BD.createStatement();
            stm.executeUpdate("INSERT INTO `mahasiswa` (`NIM_Mahasiswa`, "
                    + "`Nama_Mahasiwa`, `Angkatan`) VALUES "
                    + "('"+NIM+"', '"+Nama+"', '"+Angkat+"');");
            
            Mahasiswa x = new Mahasiswa(Nama, NIM, Angkat);
            Omhs.put(NIM, x);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        isiTabelMhs();
        TabelTambahMhs.setModel(tab);
    }                                                  

    private void tombolTambahMhsActionPerformed(java.awt.event.ActionEvent evt) {                                                
        // TODO add your handling code here:
        isiTabelMhs();
        TabelTambahMhs.setModel(tab);
        
        MenuSelamatDatang.setVisible(false);
        PanelTambahlKelas.setVisible(false);    //Mahasiswa
        PanelTampilKelas.setVisible(false);
        PanelEditlKelas.setVisible(false);
        PanelTampilDosen.setVisible(false);     //dosen
        PanelTambahlDosen.setVisible(false);
        PanelEditlDosen.setVisible(false);
        PanelTampilMahasiswa.setVisible(false); //Mahasiswa
        PanelEditMhs.setVisible(false);
        PanelTambahMhs.setVisible(true);
        PanelEditKehadiran.setVisible(false);   //kehadiran
        PanelIsiKehadiran.setVisible(false);    
        PanelTampilKehadiran.setVisible(false);
    }                                               

    private void tombolEditDataActionPerformed(java.awt.event.ActionEvent evt) {                                               
        // TODO add your handling code here:
        getKodeMkcTambahData.setText(null);
        isiTabelOdata();
        TabelTambahData1.setModel(tab);
        
        MenuSelamatDatang.setVisible(false);
        PanelTambahlKelas.setVisible(false);    //Mahasiswa
        PanelTampilKelas.setVisible(false);
        PanelEditlKelas.setVisible(false);
        PanelTampilDosen.setVisible(false);     //dosen
        PanelTambahlDosen.setVisible(false);
        PanelEditlDosen.setVisible(false);
        PanelTampilMahasiswa.setVisible(false); //Mahasiswa
        PanelEditMhs.setVisible(false);
        PanelTambahMhs.setVisible(false);
        PanelEditKehadiran.setVisible(true);   //kehadiran
        PanelIsiKehadiran.setVisible(false);    
        PanelTampilKehadiran.setVisible(false);
    }                                              

    private void tombolTampilHadirActionPerformed(java.awt.event.ActionEvent evt) {                                                  
        // TODO add your handling code here:
        getKodeMkcTambahData.setText(null);
        isiTabelOdata();
        TabelTambahData2.setModel(tab);
        
        MenuSelamatDatang.setVisible(false);
        PanelTambahlKelas.setVisible(false);    //Mahasiswa
        PanelTampilKelas.setVisible(false);
        PanelEditlKelas.setVisible(false);
        PanelTampilDosen.setVisible(false);     //dosen
        PanelTambahlDosen.setVisible(false);
        PanelEditlDosen.setVisible(false);
        PanelTampilMahasiswa.setVisible(false); //Mahasiswa
        PanelEditMhs.setVisible(false);
        PanelTambahMhs.setVisible(false);
        PanelEditKehadiran.setVisible(false);   //kehadiran
        PanelIsiKehadiran.setVisible(false);    
        PanelTampilKehadiran.setVisible(true);
        
    }                                                 

    private void tombolEditMhsActionPerformed(java.awt.event.ActionEvent evt) {                                              
        // TODO add your handling code here:
        isiTabelMhs();
        TabelEditMhs.setModel(tab);
        MenuSelamatDatang.setVisible(false);
        PanelTambahlKelas.setVisible(false);    //Mahasiswa
        PanelTampilKelas.setVisible(false);
        PanelEditlKelas.setVisible(false);
        PanelTampilDosen.setVisible(false);     //dosen
        PanelTambahlDosen.setVisible(false);
        PanelEditlDosen.setVisible(false);
        PanelTampilMahasiswa.setVisible(false); //Mahasiswa
        PanelEditMhs.setVisible(true);
        PanelTambahMhs.setVisible(false);
        PanelEditKehadiran.setVisible(false);   //kehadiran
        PanelIsiKehadiran.setVisible(false);    
        PanelTampilKehadiran.setVisible(false);
    }                                             

    private void TomboladdTambahDosen1ActionPerformed(java.awt.event.ActionEvent evt) {                                                      
        // TODO add your handling code here:
        
        try {
            String NIM = getNIMcTambahData.getText();
            String KodeMK = getKodeMkcTambahData.getText();
            int A = Integer.parseInt(getAbsencTambahData.getText());
            int SI = Integer.parseInt(getSakitcTambahData.getText());
            data x = new data(KodeMK,NIM,SI,A);
            Connection BD = koneksi.getConection();
            Statement stm = BD.createStatement();
            stm.executeUpdate("INSERT INTO `data_kehadiran` (`Kode`, "
                    + "`KodeMK`, `KodeNIM`, `SI`, `A`, `Keterangan`) VALUES "
                    + "('"+(KodeMK+NIM)+"', '"+KodeMK+"', '"+NIM+"', "+SI+","+A+", '" +x.Keterangan+"');");
            
            Odata.put(KodeMK+NIM, x);
            isiTabelOdata();
            TabelTambahData.setModel(tab);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }                                                     

    private void tombolGOtambahDataActionPerformed(java.awt.event.ActionEvent evt) {                                                   
        // TODO add your handling code here:
        try {
            isiTabelOdata();
            TabelTambahData.setModel(tab);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Data Tidak Valid", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }                                                  

    private void tombolGOtambahData1ActionPerformed(java.awt.event.ActionEvent evt) {                                                    
        // TODO add your handling code here:
        try {
            if(getKodeMkcTambahData1.getText().equals(null) || getNIMcTambahData1.getText().equals(null)) {
                JOptionPane.showMessageDialog(null, "Data Tidak Valid", "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                data x = Odata.get(getKodeMkcTambahData1.getText()+getNIMcTambahData1.getText());
                getKodeMkcTambahData.setText(getKodeMkcTambahData1.getText());
                getAbsencTambahData1.setText(x.getA());
                getSakitcTambahData1.setText(x.getSI());
                isiTabelOdata();
                TabelTambahData1.setModel(tab);
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(null, "Data Tidak Valid", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }                                                   

    private void TomboladdTambahDosen2ActionPerformed(java.awt.event.ActionEvent evt) {                                                      
        // TODO add your handling code here:
        try {
            if(getAbsencTambahData1.getText().equals(null) || getSakitcTambahData1.getText().equals(null)) {
               JOptionPane.showMessageDialog(null, "error", "Error", JOptionPane.ERROR_MESSAGE); 
            } else {
                String NIM = getNIMcTambahData1.getText();
                String KodeMK = getKodeMkcTambahData1.getText();
                int A = Integer.parseInt(getAbsencTambahData1.getText());
                int SI = Integer.parseInt(getSakitcTambahData1.getText());
            data x = new data(KodeMK,NIM,SI,A);
            Connection BD = koneksi.getConection();
            Statement stm = BD.createStatement();
            stm.executeUpdate("UPDATE `data_kehadiran` SET `A` = "
                + getAbsencTambahData1.getText()+", SI = "+ getSakitcTambahData1.getText() +", keterangan = '="+x.Keterangan+"' WHERE "
                + "`data_kehadiran`.`Kode` = '"+KodeMK+NIM+"';");
            Odata.replace(KodeMK+NIM, x);
            isiTabelOdata();
            TabelTambahData1.setModel(tab);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }

    }                                                     

    private void tombolGOtambahData2ActionPerformed(java.awt.event.ActionEvent evt) {                                                    
        // TODO add your handling code here:
        getKodeMkcTambahData.setText(getKodeMkcTamnahDataKeKelas.getText());
        isiTabelOdata();
        TabelTambahData2.setModel(tab);
    }                                                   

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {                                         
        // TODO add your handling code here:
        String Kode = getKodeMkcTambahData1.getText();
        String NIM = getNIMcTambahData1.getText();
        
        try {
            Connection BD = koneksi.getConection();
            Statement stm = BD.createStatement();
            stm.executeUpdate("DELETE FROM `data_kehadiran` WHERE `data_kehadiran`.`Kode` = '"+Kode+NIM+"';");
            Odata.remove(Kode+NIM);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
        isiTabelOdata();
        TabelTambahData1.setModel(tab);
    }                                        

    
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

    // Variables declaration - do not modify                     
    private javax.swing.JLabel LabelBGTambahlKelas;
    private javax.swing.JLabel LabelBGTambahlKelas1;
    private javax.swing.JLabel LabelBGTambahlKelas2;
    private javax.swing.JLabel LabelBGTambahlKelas3;
    private javax.swing.JLabel LabelBGTambahlKelas4;
    private javax.swing.JLabel LabelBGTambahlKelas5;
    private javax.swing.JLabel LabelBGTambahlKelas6;
    private javax.swing.JLabel LabelBGTambahlKelas7;
    private javax.swing.JLabel LabelBGTambahlKelas8;
    private javax.swing.JLabel LabelBGTampilKelas;
    private javax.swing.JLabel LabelBGTampilKelas1;
    private javax.swing.JLabel LabelBGTampilKelas2;
    private javax.swing.JLabel LabelMenuTambahlKelas;
    private javax.swing.JLabel LabelMenuTambahlKelas1;
    private javax.swing.JLabel LabelMenuTambahlKelas2;
    private javax.swing.JLabel LabelMenuTambahlKelas3;
    private javax.swing.JLabel LabelMenuTambahlKelas4;
    private javax.swing.JLabel LabelMenuTambahlKelas5;
    private javax.swing.JLabel LabelMenuTambahlKelas6;
    private javax.swing.JLabel LabelMenuTambahlKelas7;
    private javax.swing.JLabel LabelMenuTambahlKelas8;
    private javax.swing.JLabel LabelMenuTampilDosen;
    private javax.swing.JLabel LabelMenuTampilKelas;
    private javax.swing.JLabel LabelMenuTampilmhs;
    private javax.swing.JLabel LabeljudMenuADMIN;
    private java.awt.Panel MenuAdmin;
    private java.awt.Panel MenuSelamatDatang;
    private javax.swing.JLabel NIM;
    private javax.swing.JPanel PanelEditKehadiran;
    private javax.swing.JPanel PanelEditMhs;
    private javax.swing.JPanel PanelEditlDosen;
    private javax.swing.JPanel PanelEditlKelas;
    private javax.swing.JPanel PanelIsiKehadiran;
    private javax.swing.JPanel PanelTambahMhs;
    private javax.swing.JPanel PanelTambahlDosen;
    private javax.swing.JPanel PanelTambahlKelas;
    private javax.swing.JPanel PanelTampilDosen;
    private javax.swing.JPanel PanelTampilKehadiran;
    private javax.swing.JPanel PanelTampilKelas;
    private javax.swing.JPanel PanelTampilMahasiswa;
    private java.awt.Panel PanelUtama;
    private javax.swing.JTable TabelEditDosen;
    private javax.swing.JTable TabelEditMhs;
    private javax.swing.JTable TabelTambahData;
    private javax.swing.JTable TabelTambahData1;
    private javax.swing.JTable TabelTambahData2;
    private javax.swing.JTable TabelTambahDosen;
    private javax.swing.JTable TabelTambahKelas;
    private javax.swing.JTable TabelTambahKelas1;
    private javax.swing.JTable TabelTambahMhs;
    private javax.swing.JTable TabelTampilDosen;
    private javax.swing.JTable TabelTampilKelas;
    private javax.swing.JTable TabelTampilMhs;
    private javax.swing.JButton TombolDeleteEditDosen;
    private javax.swing.JButton TombolDeleteEditKelas;
    private javax.swing.JButton TombolDeleteEditMhs;
    private javax.swing.JButton TombolEditKelas;
    private javax.swing.JButton TombolGoEditKelas;
    private javax.swing.JButton TombolGoEditKelas1;
    private javax.swing.JButton TombolGoEditMhs;
    private javax.swing.JButton TombolTambahKelas;
    private javax.swing.JButton TombolTampilKelas;
    private javax.swing.JButton TombolUpdateEditDosen;
    private javax.swing.JButton TombolUpdateEditKelas;
    private javax.swing.JButton TombolUpdateEditMhs;
    private javax.swing.JButton TomboladdTambahDosen;
    private javax.swing.JButton TomboladdTambahDosen1;
    private javax.swing.JButton TomboladdTambahDosen2;
    private javax.swing.JButton TomboladdTambahKelas;
    private javax.swing.JButton TomboladdTambahMhs;
    private javax.swing.JButton TombolisiData;
    private javax.swing.JTextField getAbsencTambahData;
    private javax.swing.JTextField getAbsencTambahData1;
    private javax.swing.JTextField getAngkatanEditMhs;
    private javax.swing.JTextField getAngkatanTambahMhs;
    private javax.swing.JTextField getKodeMkcTambahData;
    private javax.swing.JTextField getKodeMkcTambahData1;
    private javax.swing.JTextField getKodeMkcTamnahDataKeKelas;
    private javax.swing.JTextField getKodeTambahKelas;
    private javax.swing.JTextField getKodeTambahKelas1;
    private javax.swing.JTextField getNIMTambahMhs;
    private javax.swing.JTextField getNIMcTambahData;
    private javax.swing.JTextField getNIMcTambahData1;
    private javax.swing.JTextField getNIPEditDosen;
    private javax.swing.JTextField getNIPTambahDosen;
    private javax.swing.JTextField getNIPTambahKelas;
    private javax.swing.JTextField getNIPTambahKelas1;
    private javax.swing.JTextField getNamaEditDosen;
    private javax.swing.JTextField getNamaEditMhs;
    private javax.swing.JTextField getNamaMKTambahKelas;
    private javax.swing.JTextField getNamaMKTambahKelas1;
    private javax.swing.JTextField getNamaTambahDosen;
    private javax.swing.JTextField getNamaTambahMhs;
    private javax.swing.JTextField getNimEditMhs;
    private javax.swing.JTextField getPassEDosen;
    private javax.swing.JTextField getPassTambahDosen;
    private javax.swing.JTextField getSakitcTambahData;
    private javax.swing.JTextField getSakitcTambahData1;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JLabel textSelamatDatang;
    private javax.swing.JButton tombolEditData;
    private javax.swing.JButton tombolEditMhs;
    private javax.swing.JButton tombolEditlDosen;
    private javax.swing.JButton tombolGOtambahData;
    private javax.swing.JButton tombolGOtambahData1;
    private javax.swing.JButton tombolGOtambahData2;
    private javax.swing.JButton tombolKeluar;
    private javax.swing.JButton tombolTambahMhs;
    private javax.swing.JButton tombolTambahlDosen;
    private javax.swing.JButton tombolTampilDosen;
    private javax.swing.JButton tombolTampilHadir;
    private javax.swing.JButton tombolTampilMhs;
    // End of variables declaration                   
}
