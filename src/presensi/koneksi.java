package presensi;

import java.sql.*;
import javax.swing.JOptionPane;

public class koneksi {

    private static Connection konek;
    
    public static Connection getConection() {
        //Connection BD;
        try {
                Connection BD = DriverManager.getConnection(
                        "jdbc:mysql://localhost/Presensi", 
                        "root",
                        "");
                konek = BD;
                
        } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "GAGAL", JOptionPane.ERROR_MESSAGE);
        }
        return konek;
    }
    
    public static void main(String[] args) {
        Connection x = getConection();
    }
}
