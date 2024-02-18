package concesionaria.modelo;

import concesionaria.backend.daos.AutoDAO;
import concesionaria.backend.daos.ClienteDAO;
import concesionaria.backend.daos.ServicioDAO;
import concesionaria.backend.daos.impl.AutoDAOFactory;
import concesionaria.backend.daos.impl.ClienteDAOFactory;
import concesionaria.backend.daos.impl.ServicioDAOFactory;
import concesionaria.backend.dtos.AutoDTO;
import concesionaria.backend.dtos.ClienteDTO;
import concesionaria.backend.dtos.ServicioDTO;
import java.util.Collection;
import java.util.ResourceBundle;

public class ModeloLocal implements Modelo {
    private String tipo;
    private ClienteDAO clienteDAO;
    private AutoDAO autoDAO;
    private ServicioDAO servicioDAO;

    public ModeloLocal() {
        cargarModelo();
    }

    private void cargarModelo() {
        cargarTipo();
        this.clienteDAO = ClienteDAOFactory.getInstance().crearClienteDAO("ClienteDAO" + tipo);
        this.autoDAO = AutoDAOFactory.getInstance().crearAutoDAO("AutoDAO" + tipo);
        this.servicioDAO = ServicioDAOFactory.getInstance().crearServicioDAO("ServicioDAO" + tipo);
        System.out.println("Modelo cargado en modo " + tipo);
    }

    private void cargarTipo() {
        ResourceBundle rb = ResourceBundle.getBundle(this.getClass().getPackage().getName() + ".config");
        this.tipo = rb.getString("tipoModelo");
    }

    @Override
    public Collection<ClienteDTO> obtenerClientes() {
        return clienteDAO.obtenerClientes();
    }

    @Override
    public void agregar(String[] datos) {
        clienteDAO.agregarCliente(datos);

    }

    @Override
    public void modificar(String[] datos) {
        clienteDAO.modificarCliente(datos);

    }

    @Override
    public void eliminar(String str) {
       clienteDAO.eliminarCliente(str);

    }

  

    @Override
     public Collection<AutoDTO> obtenerAutos(String opcion) {
        return autoDAO.obtenerAutos(opcion);
    }
    
    @Override
    public void agregarAuto(String[] datos) {
        autoDAO.agregarAuto(datos);

    }

    @Override
    public void modificarAuto(String[] datos) {
        autoDAO.modificarAuto(datos);

    }

    @Override
    public void eliminarAuto(String str) {
        autoDAO.eliminarAuto(str);
    }


    @Override
     public Collection<ServicioDTO> obtenerServicios(String opcion) {
        return servicioDAO.obtenerServicios(opcion);
    }
    
    @Override
    public void agregarServicio(String[] datos) {

        servicioDAO.agregarServicio(datos);

    }
    
    @Override
     public void modificarServicio(String[] datos) {
        servicioDAO.modificarServicio(datos);

    }
    @Override
     public void eliminarServicio(String str) {
        servicioDAO.eliminarServicio(str);
    }
     
     

}
