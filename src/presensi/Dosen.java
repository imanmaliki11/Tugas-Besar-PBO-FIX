package presensi;

public class Dosen extends Person{
    public String Password;
    
    public Dosen(String nama, String nip, String Pass){
        this.Password = Pass;
        super.Person(nama, nip);
    }
    
    public Dosen() {
        
    }
    
    public Dosen(String a){
        this.Password = a;
    }
}
