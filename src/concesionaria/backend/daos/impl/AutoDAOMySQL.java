package concesionaria.backend.daos.impl;

import com.mysql.cj.jdbc.exceptions.CommunicationsException;
import concesionaria.backend.daos.AutoDAO;
import concesionaria.backend.dtos.AutoDTO;
import concesionaria.modelo.modelobbdd.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Calendar;
import java.util.Collection;
import java.util.LinkedList;
import java.util.ResourceBundle;

public class AutoDAOMySQL implements AutoDAO {

    @Override
    public Collection<AutoDTO> obtenerAutos(String op) {
        String query = devolverSentenciaSeleccionada(op);
        Collection<AutoDTO> autos = new LinkedList<>();
        try {
            Connection con = ConexionBD.getConexion();
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                autos.add(new AutoDTO(rs.getInt(1), rs.getString(2),
                        rs.getString(3), rs.getString(4),
                        rs.getInt(5), rs.getInt(6), rs.getString(7)));
            }

        } catch (CommunicationsException ce) {
            throw new RuntimeException("SE INTERRUMPIÓ LA COMUNICACIÓN CON LA LA BASE DE DATOS");
        } catch (java.sql.SQLException ex) {
            throw new RuntimeException("OCURRIÓ ALGUN ERROR EN LA BASE DE DATOS");
        } catch (Exception ex) {
            throw new RuntimeException("OCURRIÓ ALGUN ERROR" + ex);
        }
        return autos;

    }

    @Override
    public void agregarAuto(String[] d) {
        try {
            int anio = Integer.parseInt(d[4]);
            int codcli = Integer.parseInt(d[5]);
            validadorAntig(anio);

            String query = "INSERT INTO auto VALUES (null,?,?,?,?,?)";

            Connection con = ConexionBD.getConexion();
            PreparedStatement ps = con.prepareStatement(query);

            //  ps.setInt(1, cod);
            ps.setString(1, d[1]);
            ps.setString(2, d[2]);
            ps.setString(3, d[3]);
            ps.setInt(4, Integer.parseInt(d[4]));
            ps.setInt(5, Integer.parseInt(d[5]));

            ps.executeUpdate();
        } catch (NumberFormatException numberFormatException) {
            throw new RuntimeException("VERIFIQUE CAMPO AÑO/COD-CLIENTE" + '\n' + "SOLO INGRESE NUMEROS");
        } catch (java.sql.SQLIntegrityConstraintViolationException e) {
            throw new RuntimeException("VERIFIQUE EXISTENCIA DE CÓDIGO DE CLIENTE");
        } catch (java.sql.SQLException ex) {
            throw new RuntimeException("OCURRIÓ ALGUN ERROR EN LA BASE DE DATOS");
        } catch (IllegalArgumentException iae) {
            throw new RuntimeException("NUMERO  INVALIDO DE AÑO");
        } catch (Exception ex) {
            throw new RuntimeException("OCURRIÓ ALGÚN ERROR" + ex);
        }

    }

    @Override
    public void modificarAuto(String[] d) {
        try {
            int id = Integer.parseInt(d[0]);
            String pat = d[1];
            String marca = d[2];
            String mod = d[3];
            int anio = Integer.parseInt(d[4]);
            int codcli = Integer.parseInt(d[5]);
            validadorAntig(anio);

            String query = "update auto set patente='" + pat + "',marca='" + marca + "',modelo='" + mod + "',anio='" + anio + "',cliente_idcliente='" + codcli + "'where idauto=" + id;

            Connection con = ConexionBD.getConexion();
            PreparedStatement ps = con.prepareStatement(query);

            ps.executeUpdate();
        } catch (NumberFormatException numberFormatException) {
            throw new RuntimeException("VERIFIQUE CAMPO AÑO/COD-CLIENTE" + '\n' + "SOLO INGRESE NUMEROS");
        } catch (java.sql.SQLIntegrityConstraintViolationException e) {
            throw new RuntimeException("VERIFIQUE EXISTENCIA DE CÓDIGO DE CLIENTE");
        } catch (java.sql.SQLException ex) {
            throw new RuntimeException("OCURRIÓ ALGUN ERROR EN LA BASE DE DATOS");
        } catch (IllegalArgumentException iae) {
            throw new RuntimeException("NUMERO  INVALIDO DE AÑO");
        } catch (Exception ex) {
            throw new RuntimeException("OCURRIÓ ALGÚN ERROR" + ex);
        }

    }

    @Override
    public void eliminarAuto(String d) {
        int id = Integer.parseInt(d);
        String sql = "delete from auto where idauto=" + id;
        try {
            Connection con = ConexionBD.getConexion();
            PreparedStatement ps = con.prepareStatement(sql);

            ps.executeUpdate();
        } catch (java.sql.SQLIntegrityConstraintViolationException e) {
            throw new RuntimeException("PRIMER DEBE ELIMINAR LOS SERVICIOS DEL AUTO");

        } catch (java.sql.SQLSyntaxErrorException ex) {
            throw new RuntimeException("OCURRIÓ ALGUN ERROR EN LA BASE DE DATOS");
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }

    }

    private String devolverSentenciaSeleccionada(String op) {
        ResourceBundle rb = ResourceBundle.getBundle(this.getClass().getPackage().getName() + ".sentencia" + ".auto");
        String query = rb.getString(op);
        return query;
    }

    private void validadorAntig(int num) {

        if (num < 1920 || num > anioActual()) {
            throw new IllegalArgumentException();
        }

    }

    private int anioActual() {
        Calendar cal = Calendar.getInstance();
        return (cal.get(Calendar.YEAR));
    }

}
