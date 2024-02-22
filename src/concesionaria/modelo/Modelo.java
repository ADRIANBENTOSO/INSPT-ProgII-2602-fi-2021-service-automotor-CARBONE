package concesionaria.modelo;

import concesionaria.backend.dtos.AutoDTO;
import concesionaria.backend.dtos.ClienteDTO;
import concesionaria.backend.dtos.ServicioDTO;
import java.util.Collection;

public interface Modelo {

    public Collection<ClienteDTO> obtenerClientes();

    public void agregar(String[] datos);

    public void modificar(String[] datos);

    public void eliminar(String datos);

    public void agregarAuto(String[] datos);

    public void modificarAuto(String[] datos);

    public void eliminarAuto(String str);

    public void agregarServicio(String[] d);

    public void modificarServicio(String[] datos);

    public void eliminarServicio(String str);

    public Collection<ServicioDTO> obtenerServicios(String opcion);

    public Collection<AutoDTO> obtenerAutos(String opcion);

}
