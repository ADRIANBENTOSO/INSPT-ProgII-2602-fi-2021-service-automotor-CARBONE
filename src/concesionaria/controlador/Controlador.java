package concesionaria.controlador;

import concesionaria.modelo.Modelo;
import concesionaria.frontend.vista.VistaAutos;
import concesionaria.frontend.vista.VistaMenu;
import concesionaria.frontend.vista.VistaClientes;
import concesionaria.frontend.vista.VistaServicios;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Controlador {

    private Modelo m;
    private VistaMenu vMenu;
    private VistaClientes vClientes;
    private VistaAutos vAutos;
    private VistaServicios vServicios;
    private static final String CAMPOS_VACIOS = "INGRESE DATOS ";

    public Controlador(Modelo m, VistaMenu vMenu, VistaClientes vClientes, VistaAutos vAutos, VistaServicios vServicios) {
        this.m = m;
        this.vMenu = vMenu;
        this.vClientes = vClientes;
        this.vAutos = vAutos;
        this.vServicios = vServicios;

    }

    public void iniciar() {
        vMenu.addMostrarClaseClientes(new ConsultarClientes());
        vClientes.addMostrarAgregar(new AgregarClientes());
        vClientes.addSeleccionarClientes(new SeleccionarCliente());
        vClientes.addModicar(new ClaseModificar());//antes de modificar debe seleccionar Cliente
        vClientes.addEliminar(new EliminarCliente());
        vClientes.addLimpiar(new LimpiarCampos());
        vMenu.addMostrarAutos(new ConsultarAutos());
        vAutos.addAgregarAuto(new AgregarAuto());
        vAutos.addSeleccionarAuto(new SeleccionarAuto());
        vAutos.addModicarAuto(new ClaseModificarAuto());
        vAutos.addEliminar(new EliminarAuto());
        vAutos.addLimpiarAutos(new LimpiarCamposAutos());
        vMenu.addMostrarSevicios(new ConsultarServicios());
        vServicios.addSeleccionarServicio(new SeleccionarServicio());
        vServicios.addAgregarServicio(new AgregarServicio());
        vServicios.addModicarServicio(new ClaseModificarServicio());
        vServicios.addEliminar(new EliminarServicio());
        vServicios.addLimpiarServicios(new LimpiarCamposServicios());
        vServicios.addOpcionServicio(new ConsultarServicios());
        vAutos.addOpcionAuto(new ConsultarAutos());

        try {
            m.obtenerClientes();
            vMenu.mostrar();
        } catch (Exception e) {
            mostrarError(e.getMessage());
            System.exit(0);
        }
    }

    private class ConsultarClientes implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            vClientes.limpiarTabla();
            try {
                vClientes.agregarClientes(m.obtenerClientes());
                vClientes.mostrar(vMenu);
            } catch (Exception e) {
                vClientes.mostrarError(e.getMessage());
            }

        }

    }

    private class AgregarClientes implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {

            String[] datos = vClientes.dameDatos();
            if (camposVacios(datos)) {
                vClientes.mostrarError(CAMPOS_VACIOS);
            } else {
                try {
                    m.agregar(datos);
                    vClientes.mostrarExito("CLIENTE AGREGADO");
                } catch (Exception ex) {
                    vClientes.mostrarError(ex.getMessage());
                }

                vClientes.limpiarTabla();
                vClientes.agregarClientes(m.obtenerClientes());
                vClientes.mostrar(vMenu);
            }
        }

    }

    private class SeleccionarCliente implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {

            vClientes.setCamposClienteSeleccionado();
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }

    }

    private class ClaseModificar implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            boolean b = vClientes.getSiFilaSeleccionada();
            if (!b) {
                vClientes.mostrarError("PARA MODIFICACION DEBE SELECCIONAR UNA FILA");
            } else {
                String[] datos = vClientes.dameDatos();
                if (camposVacios(datos)) {
                    vClientes.mostrarError(CAMPOS_VACIOS);
                } else {
                    try {
                        m.modificar(datos);
                        vClientes.mostrarExito("MODIFICACIÓN EXITOSA");

                    } catch (Exception ex) {
                        vClientes.mostrarError(ex.getMessage());
                    }

                    vClientes.limpiarTabla();
                    vClientes.agregarClientes(m.obtenerClientes());
                    vClientes.mostrar(vMenu);
                }

            }
        }

    }//fin clase

    private class EliminarCliente implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            boolean b = vClientes.getSiFilaSeleccionada();//fila no seleccionada false
            if (!b) {
                vClientes.mostrarError("PARA ELIMINACIÓN DEBE SELECCIONAR UNA FILA");
            } else {

                String d = vClientes.getCodClienteSeleccionado();

                try {
                    m.eliminar(d);
                    vClientes.mostrarExito("CLIENTE ELIMINADO");
                } catch (Exception exc) {
                    vClientes.mostrarError(exc.getMessage());
                }

                vClientes.limpiarTabla();
                vClientes.agregarClientes(m.obtenerClientes());
                vClientes.mostrar(vMenu);

            }

        }

    }

    private class LimpiarCampos implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            vClientes.setear();
        }
    }

    private class ConsultarAutos implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String opcion = vAutos.opcionAuto();
            vAutos.limpiarTabla();
            try {
                vAutos.agregarAutos(m.obtenerAutos(opcion));
                vAutos.mostrar();
            } catch (Exception ex) {
                vAutos.mostrarError(ex.getMessage());
            }

        }

    }

    private class SeleccionarAuto implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {

            vAutos.setCamposAutoSeleccionado();
        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }

    }

    private class AgregarAuto implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {

            String[] datos = vAutos.dameDatos();
            if (camposVacios(datos)) {
                vAutos.mostrarError(CAMPOS_VACIOS);
            } else {
                try {
                    m.agregarAuto(datos);
                    vAutos.mostrarExito("VEHICULO AGREGADO");
                } catch (Exception e) {
                    vAutos.mostrarError(e.getMessage());
                }
                vAutos.limpiarTabla();
                vAutos.agregarAutos(m.obtenerAutos("COMPLETO"));
                vAutos.mostrar();
            }

        }//fin metodo

    }//fin clase

    private class ClaseModificarAuto implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            boolean b = vAutos.getSiFilaSeleccionada();//fila no seleccionada false
            if (!b) {
                vAutos.mostrarError("PARA MODIFICACION DEBE SELECCIONAR UNA FILA");
            } else {
                String[] datos = vAutos.dameDatos();
                if (camposVacios(datos)) {
                    vAutos.mostrarError(CAMPOS_VACIOS);
                } else {

                    try {
                        m.modificarAuto(datos);
                        vAutos.mostrarExito("MODIFICACIÓN EXITOSA");
                    } catch (Exception exc) {
                        vAutos.mostrarError(exc.getMessage());
                    }

                    vAutos.limpiarTabla();
                    vAutos.agregarAutos(m.obtenerAutos("COMPLETO"));
                    vAutos.mostrar();

                }

            }//fin else 
        }

    }

    private class EliminarAuto implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            boolean b = vAutos.getSiFilaSeleccionada();//fila no seleccionada false
            if (!b) {
                vAutos.mostrarError("PARA ELIMINACIÓN DEBE SELECCIONAR UNA FILA");
            } else {

                String d = vAutos.getCodAutoSeleccionado();

                try {
                    m.eliminarAuto(d);
                    vAutos.mostrarExito("VEHICULO ELIMINADO");
                } catch (Exception exc) {
                    vAutos.mostrarError(exc.getMessage());

                }

                vAutos.limpiarTabla();
                vAutos.agregarAutos(m.obtenerAutos("COMPLETO"));
                vAutos.mostrar();

            }

        }

    }

    private class LimpiarCamposAutos implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            vAutos.setear();
        }
    }

    private class ConsultarServicios implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {

            String opcion = vServicios.opcionServicio();
            vServicios.limpiarTabla();
            try {
                vServicios.agregarServicios(m.obtenerServicios(opcion));
                vServicios.mostrar();
            } catch (Exception ex) {
                vServicios.mostrarError(ex.getMessage());
            }
        }

    }

    private class SeleccionarServicio implements MouseListener {

        @Override
        public void mouseClicked(MouseEvent e) {

            vServicios.setCamposServicioSeleccionado();

        }

        @Override
        public void mousePressed(MouseEvent e) {
        }

        @Override
        public void mouseReleased(MouseEvent e) {
        }

        @Override
        public void mouseEntered(MouseEvent e) {
        }

        @Override
        public void mouseExited(MouseEvent e) {
        }

    }

    private class AgregarServicio implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent ae) {
            String[] datos = vServicios.dameDatos();

            if (camposVacios(datos)) {
                vServicios.mostrarError(CAMPOS_VACIOS);
            } else {
                try {
                    m.agregarServicio(datos);
                    vServicios.mostrarExito("SERVICIO AGREGADO");
                } catch (Exception e) {
                    vServicios.mostrarError(e.getMessage());
                }
                vServicios.limpiarTabla();
                vServicios.agregarServicios(m.obtenerServicios("COMPLETO"));
                vServicios.mostrar();
            }

        }

    }

    private class ClaseModificarServicio implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            boolean b = vServicios.getSiFilaSeleccionada();//fila no seleccionada false
            if (!b) {
                vServicios.mostrarError("PARA MODIFICACION DEBE SELECCIONAR UNA FILA");
            } else {

                String[] datos = vServicios.dameDatos();
                if (camposVacios(datos)) {
                    vServicios.mostrarError(CAMPOS_VACIOS);
                } else {

                    try {
                        m.modificarServicio(datos);
                        vServicios.mostrarExito("MODIFICACIÓN EXITOSA");
                    } catch (Exception ex) {

                        vServicios.mostrarError(ex.getMessage());
                    }
                    vServicios.limpiarTabla();
                    vServicios.agregarServicios(m.obtenerServicios("COMPLETO"));
                    vServicios.mostrar();

                }

            }
        }

    }

    private class EliminarServicio implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            boolean b = vServicios.getSiFilaSeleccionada();//fila no seleccionada false
            if (!b) {
                vServicios.mostrarError("PARA ELIMINACIÓN DEBE SELECCIONAR UNA FILA");
            } else {

                String d = vServicios.getCodServicioSeleccionado();

                try {
                    m.eliminarServicio(d);
                    vServicios.mostrarExito("SERVICIO ELIMINADO");
                } catch (Exception exc) {
                    vServicios.mostrarError("error en borrado");

                }

                vServicios.limpiarTabla();
                vServicios.agregarServicios(m.obtenerServicios("COMPLETO"));
                vServicios.mostrar();

            }

        }

    }

    private class LimpiarCamposServicios implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            vServicios.setear();
        }
    }

    private void mostrarError(String msg) {
        vMenu.mostrarError(msg);
    }

    private boolean camposVacios(String[] d) {
        boolean vacio = false;
        for (int i = 1; i < d.length; i++) {
            if (d[i].equals("")) {
                vacio = true;
            }
        }

        return vacio;
    }

}
