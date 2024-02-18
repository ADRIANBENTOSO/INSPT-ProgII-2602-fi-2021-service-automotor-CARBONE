
package concesionaria.backend.daos;

import concesionaria.backend.dtos.ClienteDTO;
import java.util.Collection;


public interface ClienteDAO {
    Collection<ClienteDTO> obtenerClientes();
     public void agregarCliente(String [] d) ;
      public void modificarCliente(String [] d);
      public void eliminarCliente(String  d);
}
