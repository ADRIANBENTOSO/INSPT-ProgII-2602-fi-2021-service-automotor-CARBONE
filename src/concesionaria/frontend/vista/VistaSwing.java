
package concesionaria.frontend.vista;
import java.awt.Component;
import java.awt.Image;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public abstract class VistaSwing extends JFrame {
    

  public VistaSwing() {

    }

    
    public void mostrarError(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje, "Error...", JOptionPane.ERROR_MESSAGE);
      
      }
    
    public void mostrarExito(String mensaje) {
        JOptionPane.showMessageDialog(this, mensaje);
      
      }
    
    
    public void mostrar(Component parent) {
        setLocationRelativeTo(parent);
        setVisible(true);
    }
    
    public void mostrar() {
        mostrar(null);
    }
    
     public void setearIcono(Image miIcono) {
         setIconImage(miIcono); 
    }
    
    
    
    
}
