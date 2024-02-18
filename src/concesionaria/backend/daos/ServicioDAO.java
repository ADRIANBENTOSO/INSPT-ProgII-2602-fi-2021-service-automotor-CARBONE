package concesionaria.backend.daos;

import concesionaria.backend.dtos.ServicioDTO;
import java.util.Collection;

public interface ServicioDAO {

    public Collection<ServicioDTO> obtenerServicios(String op);

    public void agregarServicio(String[] d);

    public void modificarServicio(String[] datos);

    public void eliminarServicio(String str);

}
