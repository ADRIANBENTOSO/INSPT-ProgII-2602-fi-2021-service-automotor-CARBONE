package concesionaria.backend.daos;

import concesionaria.backend.dtos.AutoDTO;
import java.util.Collection;

public interface AutoDAO {

    public Collection<AutoDTO> obtenerAutos(String op);

    public void agregarAuto(String[] d);

    public void modificarAuto(String[] d);

    public void eliminarAuto(String d);
}
