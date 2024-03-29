package concesionaria.frontend.vista;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.Image;
import java.awt.Toolkit;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class VistaMenu extends VistaSwing {

    private Toolkit miPantalla = Toolkit.getDefaultToolkit();
    private Image miIcono = miPantalla.getImage(getRutaImg());
    private SimpleDateFormat sdf = new SimpleDateFormat("dd-MMMMMMM-yyyy ");

    public VistaMenu() {
        initComponents();
        setearIcono(miIcono);
        Date fechaHoy = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        String fechaCadena = sdf.format(fechaHoy);
        this.jTextFieldFechaHoy.setText(fechaCadena);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jPanelbground = new javax.swing.JPanel();
        jButtonClientes = new javax.swing.JButton();
        jButtonAutos = new javax.swing.JButton();
        jButtonServicios = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabelImagen = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanelCRUZCIERRE = new javax.swing.JPanel();
        jLabelXCIERRE = new javax.swing.JLabel();
        jTextFieldFechaHoy = new javax.swing.JTextField();

        jLabel1.setText("jLabel1");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("CONCESIONARIA");
        setUndecorated(true);
        setResizable(false);

        jPanelbground.setBackground(new java.awt.Color(112, 219, 164));
        jPanelbground.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButtonClientes.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jButtonClientes.setForeground(new java.awt.Color(0, 108, 133));
        jButtonClientes.setText("CLIENTES");
        jButtonClientes.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonClientes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonClientesActionPerformed(evt);
            }
        });
        jPanelbground.add(jButtonClientes, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 80, 120, -1));

        jButtonAutos.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jButtonAutos.setForeground(new java.awt.Color(0, 108, 133));
        jButtonAutos.setText("AUTOS");
        jButtonAutos.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButtonAutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAutosActionPerformed(evt);
            }
        });
        jPanelbground.add(jButtonAutos, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 130, 120, -1));

        jButtonServicios.setFont(new java.awt.Font("Segoe UI", 3, 14)); // NOI18N
        jButtonServicios.setForeground(new java.awt.Color(0, 108, 133));
        jButtonServicios.setText("SERVICIOS");
        jButtonServicios.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jPanelbground.add(jButtonServicios, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 180, 120, -1));

        jLabel2.setFont(new java.awt.Font("Lato", 3, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(83, 94, 164));
        jLabel2.setText("CONCESIONARIA");
        jPanelbground.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 10, 170, -1));

        jLabelImagen.setForeground(new java.awt.Color(255, 102, 102));
        jLabelImagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/concesionaria/img/menu.jpg"))); // NOI18N
        jLabelImagen.setText("jLabel1");
        jPanelbground.add(jLabelImagen, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 520, 390));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 70, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        jPanelbground.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 70, 70, 30));

        jPanelCRUZCIERRE.setBackground(new java.awt.Color(112, 219, 164));

        jLabelXCIERRE.setFont(new java.awt.Font("Segoe UI", 1, 24)); // NOI18N
        jLabelXCIERRE.setText(" X");
        jLabelXCIERRE.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabelXCIERRE.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelXCIERREMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jLabelXCIERREMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                jLabelXCIERREMouseExited(evt);
            }
        });

        javax.swing.GroupLayout jPanelCRUZCIERRELayout = new javax.swing.GroupLayout(jPanelCRUZCIERRE);
        jPanelCRUZCIERRE.setLayout(jPanelCRUZCIERRELayout);
        jPanelCRUZCIERRELayout.setHorizontalGroup(
            jPanelCRUZCIERRELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelCRUZCIERRELayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabelXCIERRE, javax.swing.GroupLayout.DEFAULT_SIZE, 38, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanelCRUZCIERRELayout.setVerticalGroup(
            jPanelCRUZCIERRELayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabelXCIERRE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        jPanelbground.add(jPanelCRUZCIERRE, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 0, 50, 40));

        jTextFieldFechaHoy.setBackground(new java.awt.Color(112, 219, 164));
        jTextFieldFechaHoy.setFont(new java.awt.Font("Segoe UI", 3, 18)); // NOI18N
        jTextFieldFechaHoy.setForeground(new java.awt.Color(83, 94, 164));
        jTextFieldFechaHoy.setBorder(null);
        jPanelbground.add(jTextFieldFechaHoy, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 430, 180, 40));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelbground, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanelbground, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 474, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButtonClientesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonClientesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonClientesActionPerformed

    private void jButtonAutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAutosActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButtonAutosActionPerformed

    private void jLabelXCIERREMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelXCIERREMouseClicked
        System.exit(0);
    }//GEN-LAST:event_jLabelXCIERREMouseClicked

    private void jLabelXCIERREMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelXCIERREMouseEntered
        // TODO add your handling code here:
        jPanelCRUZCIERRE.setBackground(Color.red);
    }//GEN-LAST:event_jLabelXCIERREMouseEntered

    private void jLabelXCIERREMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelXCIERREMouseExited
        // TODO add your handling code here:
        jPanelCRUZCIERRE.setBackground(new Color(112, 219, 164));
    }//GEN-LAST:event_jLabelXCIERREMouseExited

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAutos;
    private javax.swing.JButton jButtonClientes;
    private javax.swing.JButton jButtonServicios;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelImagen;
    private javax.swing.JLabel jLabelXCIERRE;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanelCRUZCIERRE;
    private javax.swing.JPanel jPanelbground;
    private javax.swing.JTextField jTextFieldFechaHoy;
    // End of variables declaration//GEN-END:variables

    public void addMostrarClaseClientes(ActionListener al) {
        this.jButtonClientes.addActionListener(al);

    }

    public void addMostrarAutos(ActionListener al) {

        this.jButtonAutos.addActionListener(al);

    }

    public void addMostrarSevicios(ActionListener al) {
        this.jButtonServicios.addActionListener(al);

    }

    private String getRutaImg() {
        return "src\\concesionaria\\img\\menu.jpg";
    }

}
