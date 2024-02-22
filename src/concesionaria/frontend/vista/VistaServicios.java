package concesionaria.frontend.vista;

import concesionaria.backend.dtos.ServicioDTO;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.sql.Date;
import java.util.Collection;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import java.util.Calendar;
import java.awt.Image;
import java.awt.Toolkit;

/**
 *
 * @gracias a domi
 */
public class VistaServicios extends VistaSwing {

    private Toolkit miPantalla = Toolkit.getDefaultToolkit();
    private Image miIcono = miPantalla.getImage(getRutaImg());

    public VistaServicios() {
        setearIcono(miIcono);
        initComponents();

    }

    public void limpiarTabla() {
        DefaultTableModel dtm = (DefaultTableModel) this.jTableServicios.getModel();
        for (int i = 0; i < this.jTableServicios.getRowCount();) {
            dtm.removeRow(i);

        }
    }

    public void agregarServicios(Collection<ServicioDTO> clientes) {
        for (ServicioDTO cliente : clientes) {
            agregarFila(cliente);
        }
    }

    private void agregarFila(ServicioDTO d) {

        Object[] datos = {d.getId(), d.getFechaString(), d.getCosto(), d.getKm(), d.getIdAuto()};
        DefaultTableModel dtm = (DefaultTableModel) this.jTableServicios.getModel();
        dtm.addRow(datos);
    }

    public void addSeleccionarServicio(MouseListener ml) {
        this.jTableServicios.addMouseListener(ml);
    }

    public void setCamposServicioSeleccionado() {
        int nroFila = this.jTableServicios.getSelectedRow();
        int id = (int) this.jTableServicios.getValueAt(nroFila, 0);
        //Date fecha =(Date)this.jTableServicios.getValueAt(nroFila, 1);
        String fecha = (String) this.jTableServicios.getValueAt(nroFila, 1);
        double costo = (double) this.jTableServicios.getValueAt(nroFila, 2);
        int km = (int) this.jTableServicios.getValueAt(nroFila, 3);
        int idAuto = (int) this.jTableServicios.getValueAt(nroFila, 4);

        this.jTextFieldiD.setText("" + id);
        this.jTextFieldFecha.setText(fecha);
        this.jTextFieldCosto.setText("" + costo);
        this.jTextFieldKM.setText("" + km);
        this.jTextFieldIDAUTO.setText("" + idAuto);

    }

    public boolean getSiFilaSeleccionada() {
        return (this.jTableServicios.getSelectedRow() != -1);
    }

    public void addAgregarServicio(ActionListener al) {
        this.jButtonAGREGAR.addActionListener(al);

    }

    public String[] dameDatos() {
        String fecha;
        fecha = ((JTextField) this.jDateChooserFecha.getDateEditor().getUiComponent()).getText();
        String[] datos = {this.jTextFieldiD.getText(), fecha, this.jTextFieldCosto.getText(), this.jTextFieldKM.getText(),
            this.jTextFieldIDAUTO.getText()};
        return datos;
    }

    public void addModicarServicio(ActionListener al) {
        this.jButtonMODIFICAR.addActionListener(al);

    }

    public void addEliminar(ActionListener al) {
        this.jButtonELIMINAR.addActionListener(al);

    }

    public String getCodServicioSeleccionado() {
        int nroFila = this.jTableServicios.getSelectedRow();
        //return (int) this.jTableClientes.getValueAt(nroFila, 0);
        return this.jTableServicios.getValueAt(nroFila, 0).toString();
    }

    public void addLimpiarServicios(ActionListener al) {
        this.jButtonLIMPIAR.addActionListener(al);

    }

    public void setear() {
        this.jTextFieldFecha.setText("");
        this.jTextFieldCosto.setText("");
        this.jTextFieldKM.setText("");
        this.jTextFieldIDAUTO.setText("");

        Date fechaHoy = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        System.out.println("---" + fechaHoy);
        this.jDateChooserFecha.setDate(null);
    }

    public String opcionServicio() {
        String s = (String) this.jComboBoxOpcion.getSelectedItem();
        return s;
    }

    public void addOpcionServicio(ActionListener al) {
        this.jComboBoxOpcion.addActionListener(al);

    }

    private String getRutaImg() {
        return "src\\concesionaria\\img\\servicio.jpg";
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton3 = new javax.swing.JButton();
        jSplitPane1 = new javax.swing.JSplitPane();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableServicios = new javax.swing.JTable();
        jButtonAGREGAR = new javax.swing.JButton();
        jButtonMODIFICAR = new javax.swing.JButton();
        jButtonELIMINAR = new javax.swing.JButton();
        jButtonLIMPIAR = new javax.swing.JButton();
        jTextFieldiD = new javax.swing.JTextField();
        jTextFieldFecha = new javax.swing.JTextField();
        jTextFieldCosto = new javax.swing.JTextField();
        jTextFieldKM = new javax.swing.JTextField();
        jTextFieldIDAUTO = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jDateChooserFecha = new com.toedter.calendar.JDateChooser();
        jComboBoxOpcion = new javax.swing.JComboBox<>();
        jLabelFONDO = new javax.swing.JLabel();

        jButton3.setText("jButton3");

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("SERVICIOS");
        setResizable(false);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(51, 255, 0));
        jLabel1.setText("SERVICIOS");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, -1, -1));

        jTableServicios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "ID", "FECHA", "COSTO", "KM", "COD-AUTO"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTableServicios);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 211, 640, 330));

        jButtonAGREGAR.setText("AGREGAR");
        jButtonAGREGAR.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(jButtonAGREGAR, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 170, -1, -1));

        jButtonMODIFICAR.setText("MODIFICAR");
        jButtonMODIFICAR.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(jButtonMODIFICAR, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 170, -1, -1));

        jButtonELIMINAR.setText("ELIMINAR");
        jButtonELIMINAR.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonELIMINAR.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonELIMINARActionPerformed(evt);
            }
        });
        getContentPane().add(jButtonELIMINAR, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 170, 100, -1));

        jButtonLIMPIAR.setText("LIMPIAR");
        jButtonLIMPIAR.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        getContentPane().add(jButtonLIMPIAR, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 170, 84, -1));

        jTextFieldiD.setEditable(false);
        getContentPane().add(jTextFieldiD, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 90, -1));

        jTextFieldFecha.setEditable(false);
        getContentPane().add(jTextFieldFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 60, 153, -1));
        getContentPane().add(jTextFieldCosto, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 110, 90, -1));
        getContentPane().add(jTextFieldKM, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 110, 107, -1));
        getContentPane().add(jTextFieldIDAUTO, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 110, 86, -1));

        jLabel2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("IdServicio");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, -1, -1));

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Fecha");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 80, 83, -1));

        jLabel4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Costo");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, -1, 20));

        jLabel5.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("KM");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(160, 130, -1, -1));

        jLabel6.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("COD-AUTO");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 130, -1, -1));

        jLabel8.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Fecha (Ingreso)");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 70, 130, 40));

        jDateChooserFecha.setDateFormatString("yyyy-MM-dd");
        getContentPane().add(jDateChooserFecha, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 60, 152, -1));

        jComboBoxOpcion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "COMPLETO", "SELECCION", "ORDENFECHA", "ORDENCOD_AUTO", " " }));
        getContentPane().add(jComboBoxOpcion, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 10, 100, -1));

        jLabelFONDO.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        jLabelFONDO.setForeground(new java.awt.Color(255, 255, 255));
        jLabelFONDO.setIcon(new javax.swing.ImageIcon(getClass().getResource("/concesionaria/img/menu.jpg"))); // NOI18N
        jLabelFONDO.setText("Fecha (Ingreso)");
        getContentPane().add(jLabelFONDO, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 640, 210));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonELIMINARActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonELIMINARActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonELIMINARActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButtonAGREGAR;
    private javax.swing.JButton jButtonELIMINAR;
    private javax.swing.JButton jButtonLIMPIAR;
    private javax.swing.JButton jButtonMODIFICAR;
    private javax.swing.JComboBox<String> jComboBoxOpcion;
    private com.toedter.calendar.JDateChooser jDateChooserFecha;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabelFONDO;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSplitPane jSplitPane1;
    private javax.swing.JTable jTableServicios;
    private javax.swing.JTextField jTextFieldCosto;
    private javax.swing.JTextField jTextFieldFecha;
    private javax.swing.JTextField jTextFieldIDAUTO;
    private javax.swing.JTextField jTextFieldKM;
    private javax.swing.JTextField jTextFieldiD;
    // End of variables declaration//GEN-END:variables
}
