package presensi;

public class Mahasiswa extends Person{
    public String Angkatan;
    
    public Mahasiswa(String nama, String NIM, String angkatan){
        this.Angkatan = angkatan;
        super.Person(nama, NIM);
    }
    
    
            
}
