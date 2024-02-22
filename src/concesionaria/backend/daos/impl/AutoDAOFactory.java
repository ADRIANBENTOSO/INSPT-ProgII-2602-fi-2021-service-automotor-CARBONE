package concesionaria.backend.daos.impl;

import concesionaria.backend.daos.AutoDAO;

public class AutoDAOFactory {

    private static AutoDAOFactory f = null;

    private AutoDAOFactory() {
    }

    public static AutoDAOFactory getInstance() {
        if (f == null) {
            f = new AutoDAOFactory();
        }
        return f;
    }

    public AutoDAO crearAutoDAO(String tipo) {
        try {
            return (AutoDAO) Class.forName(f.getClass().getPackage()
                    .getName() + "." + tipo).getDeclaredConstructor().newInstance();
        } catch (Exception ex) {
            throw new RuntimeException(ex);
        }
    }

}
