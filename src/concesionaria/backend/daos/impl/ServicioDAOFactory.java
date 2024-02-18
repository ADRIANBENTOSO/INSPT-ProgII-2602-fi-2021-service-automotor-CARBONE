
package concesionaria.backend.daos.impl;

import concesionaria.backend.daos.ServicioDAO;

public class ServicioDAOFactory {

    private static ServicioDAOFactory f = null;

    private ServicioDAOFactory() {
    }

    public static ServicioDAOFactory getInstance() {
        if (f == null) {
            f = new ServicioDAOFactory();
        }
        return f;
    }

    public ServicioDAO crearServicioDAO(String tipo) {
        try {
            return (ServicioDAO) Class.forName(f.getClass().getPackage()
                    .getName() + "." + tipo).getDeclaredConstructor().newInstance();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }
}

