package concesionaria.backend.daos.impl;

import com.mysql.cj.jdbc.exceptions.CommunicationsException;
import concesionaria.backend.daos.ServicioDAO;
import concesionaria.backend.dtos.ServicioDTO;
import concesionaria.modelo.modelobbdd.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Collection;
import java.util.LinkedList;
import java.util.ResourceBundle;

public class ServicioDAOMySQL implements ServicioDAO {

    @Override
    public Collection<ServicioDTO> obtenerServicios(String op) {
        String query = devolverSentenciaSeleccionada(op);
        Collection<ServicioDTO> servicios = new LinkedList<>();
        try {
            Connection con = ConexionBD.getConexion();
            PreparedStatement ps = con.prepareStatement(query);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                servicios.add(new ServicioDTO(rs.getInt(1), rs.getDate(2),
                        rs.getDouble(3), rs.getInt(4),
                        rs.getInt(5)));
            }

        }  catch (CommunicationsException ce) {
            throw new RuntimeException("SE INTERRUMPIÓ LA COMUNICACIÓN CON LA LA BASE DE DATOS");
        } catch (java.sql.SQLException ex) {
            throw new RuntimeException("OCURRIÓ ALGUN ERROR EN LA BASE DE DATOS");
        } catch (Exception ex) {
            throw new RuntimeException("OCURRIÓ ALGUN ERROR" + ex);
        }
        return servicios;

    }

    @Override
    public void agregarServicio(String[] d) {
        String query = "INSERT INTO servicio VALUES (null,?,?,?,?)";
        try {
            Connection con = ConexionBD.getConexion();
            PreparedStatement ps = con.prepareStatement(query);
            //  ps.setInt(1, cod);
            ps.setString(1, d[1]);
            ps.setDouble(2, Double.parseDouble(d[2]));
            ps.setInt(3, Integer.parseInt(d[3]));
            ps.setInt(4, Integer.parseInt(d[4]));

            ps.executeUpdate();
        } catch (NumberFormatException numberFormatException) {
            throw new RuntimeException("VERIFIQUE CAMPO COSTO/KM/COD-CLIENTE"+'\n'+"SOLO INGRESE NUMEROS");
        } catch (java.sql.SQLIntegrityConstraintViolationException e) {
            throw new RuntimeException("VERIFIQUE EXISTENCIA DE CÓDIGO DE AUTO");
        } catch (java.sql.SQLSyntaxErrorException ex) {
            throw new RuntimeException("OCURRIÓ ALGUN ERROR EN LA BASE DE DATOS");
        } catch (Exception ex) {
            throw new RuntimeException("OCURRIÓ ALGÚN ERROR");
        }

    }

    @Override
    public void modificarServicio(String[] d) {
        try {
            int id = Integer.parseInt(d[0]);
            String fecha = d[1];
            double costo;
            costo = Double.parseDouble(d[2]);
            int km = Integer.parseInt(d[3]);
            int codAuto = Integer.parseInt(d[4]);

            String query = "update servicio set fecha='" + fecha + "',costo='" + costo + "',kms='" + km + "',auto_idauto='" + codAuto + "'where idservicio=" + id;

            Connection con = ConexionBD.getConexion();
            PreparedStatement ps = con.prepareStatement(query);

            ps.executeUpdate();
        } catch (NumberFormatException numberFormatException) {
            throw new RuntimeException("VERIFIQUE CAMPO COSTO/KM/COD-CLIENTE"+'\n'+"SOLO INGRESE NUMEROS");
        } catch (java.sql.SQLIntegrityConstraintViolationException e) {
            throw new RuntimeException("VERIFIQUE EXISTENCIA DE CÓDIGO DE AUTO");
        } catch (java.sql.SQLSyntaxErrorException ex) {
            throw new RuntimeException("OCURRIÓ ALGUN ERROR EN LA BASE DE DATOS");
        } catch (Exception ex) {
            throw new RuntimeException("OCURRIÓ ALGÚN ERROR");
        }

    }

    @Override
    public void eliminarServicio(String d) {
        int id = Integer.parseInt(d);
        String sql = "delete from servicio where idservicio=" + id;
        try {
            Connection con = ConexionBD.getConexion();
            PreparedStatement ps = con.prepareStatement(sql);

            ps.executeUpdate();
        } catch (java.sql.SQLIntegrityConstraintViolationException e) {

            throw new RuntimeException(e);

        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }

    }

    private String devolverSentenciaSeleccionada(String op) {
        ResourceBundle rb = ResourceBundle.getBundle(this.getClass().getPackage().getName() + ".sentencia" + ".servicio");
        String query = rb.getString(op);
        return query;
    }

}//fin clase

