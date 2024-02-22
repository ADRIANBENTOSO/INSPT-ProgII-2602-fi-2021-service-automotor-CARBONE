package concesionaria.backend.dtos;

import java.sql.Date;
import java.text.SimpleDateFormat;

public class ServicioDTO {

    private int id;
    private Date fecha;
    private double costo;
    private int km;
    private int idAuto;

    public static SimpleDateFormat sdf = new SimpleDateFormat("dd-MMMMM-yyyy");

    public ServicioDTO(int id, Date fecha, double costo, int km, int idAuto) {
        this.id = id;
        this.fecha = fecha;
        this.costo = costo;
        this.km = km;
        this.idAuto = idAuto;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }

    public int getKm() {
        return km;
    }

    public void setKm(int km) {
        this.km = km;
    }

    public int getIdAuto() {
        return idAuto;
    }

    public void setIdAuto(int idAuto) {
        this.idAuto = idAuto;
    }

    public String getFechaString() {
        String fechaCadena = sdf.format(this.fecha);
        return fechaCadena;
    }

}
