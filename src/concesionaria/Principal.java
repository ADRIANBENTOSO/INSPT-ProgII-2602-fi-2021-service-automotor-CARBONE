package concesionaria;

import concesionaria.controlador.Controlador;
import concesionaria.modelo.Modelo;
import concesionaria.modelo.ModeloLocal;
import concesionaria.frontend.vista.VistaAutos;
import concesionaria.frontend.vista.VistaMenu;
import concesionaria.frontend.vista.VistaClientes;
import concesionaria.frontend.vista.VistaServicios;

public class Principal {

    public static void main(String[] args) {
        Modelo m = new ModeloLocal();
        VistaMenu vC = new VistaMenu();
        VistaClientes vCl = new VistaClientes();
        VistaAutos vAu = new VistaAutos();
        VistaServicios vSv = new VistaServicios();
        Controlador c = new Controlador(m, vC, vCl, vAu, vSv);
        c.iniciar();
    }
}
