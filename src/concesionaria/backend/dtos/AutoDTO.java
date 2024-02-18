
package concesionaria.backend.dtos;


public class AutoDTO {
    
    private int  ID;
    private String patente;
    private String marca;
    private String modelo;
    private int anio;
    private int idCliente;
    
    private String propietario;

    public AutoDTO() {
    }
//
//    public AutoDTO(int ID, String patente, String marca, String modelo, int anio, int idCliente) {
//        this.ID = ID;
//        this.patente = patente;
//        this.marca = marca;
//        this.modelo = modelo;
//        this.anio = anio;
//        this.idCliente = idCliente;
//    }

    public AutoDTO(int ID, String patente, String marca, String modelo, int anio, int idCliente, String propietario) {
        this.ID = ID;
        this.patente = patente;
        this.marca = marca;
        this.modelo = modelo;
        this.anio = anio;
        this.idCliente = idCliente;
        this.propietario = propietario;
    }



    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getPatente() {
        return patente;
    }

    public void setPatente(String patente) {
        this.patente = patente;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAnio() {
        return anio;
    }

    public void setAnio(int anio) {
        this.anio = anio;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getProietario() {
        return propietario;
    }

    public void setProietario(String proietario) {
        this.propietario = proietario;
    }


    
}
