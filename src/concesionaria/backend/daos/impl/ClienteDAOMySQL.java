package concesionaria.backend.daos.impl;

import com.mysql.cj.jdbc.exceptions.CommunicationsException;
import concesionaria.backend.daos.ClienteDAO;
import concesionaria.backend.dtos.ClienteDTO;
import concesionaria.modelo.modelobbdd.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Collection;
import java.util.LinkedList;

public class ClienteDAOMySQL implements ClienteDAO {

    @Override
    public Collection<ClienteDTO> obtenerClientes() {
        Collection<ClienteDTO> clientes = new LinkedList<>();
        try {
            Connection con = ConexionBD.getConexion();
            PreparedStatement ps = con.prepareStatement("SELECT * FROM cliente");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                clientes.add(new ClienteDTO(rs.getInt(1), rs.getString(2),
                        rs.getString(3), rs.getString(4),
                        rs.getString(5), rs.getString(6)));
            }

        } catch (CommunicationsException ce) {
            throw new RuntimeException("SE INTERRUMPIÓ LA COMUNICACIÓN CON LA LA BASE DE DATOS");
        } catch (java.sql.SQLException ex) {
            throw new RuntimeException("OCURRIÓ ALGUN ERROR EN LA BASE DE DATOS");
        } catch (Exception ex) {
            throw new RuntimeException("OCURRIÓ ALGUN ERROR" + ex);
        }
        return clientes;

    }

    @Override
    public void agregarCliente(String[] d) {
        String query = "INSERT INTO cliente VALUES (null,?,?,?,?,?)";
        try {

            int numDNI = Integer.parseInt(d[1]);
            validadorDNI(numDNI);
            Connection con = ConexionBD.getConexion();
            PreparedStatement ps = con.prepareStatement(query);
            ps.setString(1, d[1]);
            ps.setString(2, d[2]);
            ps.setString(3, d[3]);
            ps.setString(4, d[4]);
            ps.setString(5, d[5]);

            ps.executeUpdate();
        } catch (NumberFormatException numberFormatException) {
            throw new RuntimeException("VERIFIQUE CAMPO DNI" + '\n' + "SOLO INGRESE CIFRAS VÁLIDAS DE DNI" );
        } catch (java.sql.SQLException ex) {
            throw new RuntimeException("OCURRIÓ ALGUN ERROR EN LA BASE DE DATOS");
        } catch (IllegalArgumentException iae) {
            throw new RuntimeException("NUMERO DNI INVALIDO ");
        } catch (Exception ex) {
            throw new RuntimeException("OCURRIÓ ALGUN ERROR " + ex);
        }

    }

    @Override
    public void modificarCliente(String[] d) {
        try {
            int id = Integer.parseInt(d[0]);
            String num = d[1];
            int numDNI = Integer.parseInt(d[1]);
            String nom = d[2];
            String ape = d[3];
            String mail = d[4];
            String tel = d[5];
            validadorDNI(numDNI);

            String query = "update cliente set DNI='" + num + "',nombre='" + nom + "',apellido='" + ape + "',mail='" + mail + "',tel='" + tel + "'where idcliente=" + id;

            Connection con = ConexionBD.getConexion();
            PreparedStatement ps = con.prepareStatement(query);
            ps.executeUpdate();
        } catch (NumberFormatException numberFormatException) {
            throw new RuntimeException("VERIFIQUE CAMPO DNI" + '\n' + "SOLO INGRESE CIFRAS VÁLIDAS DE DNI");
        } catch (java.sql.SQLException ex) {
            throw new RuntimeException("OCURRIÓ ALGUN ERROR EN LA BASE DE DATOS");
        } catch (IllegalArgumentException iae) {
            throw new RuntimeException("NUMERO DNI INVALIDO ");
        } catch (Exception ex) {
            throw new RuntimeException("OCURRIÓ ALGUN ERROR " + ex);
        }

    }

    @Override
    public void eliminarCliente(String d) {
        int id = Integer.parseInt(d);
        String sql = "delete from cliente where idcliente=" + id;
        try {
            Connection con = ConexionBD.getConexion();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (java.sql.SQLIntegrityConstraintViolationException e) {
            throw new RuntimeException("IMPOSIBLE PRIMERO DEBE ELIMINAR LOS AUTOS DEL CLIENTE consulte el manual");
        } catch (java.sql.SQLInvalidAuthorizationSpecException ex) {
            throw new RuntimeException("CONSULTE SU AUTORIZACIÓN PARA ESTA OPERACIÓN");
        } catch (java.sql.SQLException ex) {
            throw new RuntimeException("OCURRIÓ ALGUN ERROR EN LA BASE DE DATOS");
        } catch (Exception ex) {
            throw new RuntimeException("OCURRIÓ ALGUN ERROR  " + ex);
        }

    }

    private void validadorDNI(int num) {
        if (num > 99999999) {
            throw new IllegalArgumentException();
        }

    }

}
