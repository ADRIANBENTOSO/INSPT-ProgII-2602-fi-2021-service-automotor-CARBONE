
package concesionaria.backend.daos.impl;

import concesionaria.backend.daos.ClienteDAO;

public class ClienteDAOFactory {

    private static ClienteDAOFactory f = null;

    private ClienteDAOFactory() {
    }

    public static ClienteDAOFactory getInstance() {
        if (f == null) {
            f = new ClienteDAOFactory();
        }
        return f;
    }

    public ClienteDAO crearClienteDAO(String tipo) {
        try {
            System.out.println("**"+Class.forName(f.getClass().getPackage().getName() + "." + tipo));
            return (ClienteDAO) Class.forName(f.getClass().getPackage()
                    .getName() + "." + tipo).getDeclaredConstructor().newInstance();
        } 
        catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}
