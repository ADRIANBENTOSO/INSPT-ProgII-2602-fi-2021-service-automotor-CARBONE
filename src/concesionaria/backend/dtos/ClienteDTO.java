
package concesionaria.backend.dtos;

public class ClienteDTO {
    private int  ID;
    private String DNI;
    private String nombre;
    private String apellido;
    private String mail;
    private String tel;

    public ClienteDTO(int ID, String DNI, String nombre, String apellido, String mail, String tel) {
        this.ID = ID;
        this.DNI = DNI;
        this.nombre = nombre;
        this.apellido = apellido;
        this.mail = mail;
        this.tel = tel;
    }
    
    
    

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getDNI() {
        return DNI;
    }

    public void setDNI(String DNI) {
        this.DNI = DNI;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    
    
    
    
}
