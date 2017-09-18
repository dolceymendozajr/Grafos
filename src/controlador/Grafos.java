package controlador;

import javax.swing.JOptionPane;
import modelo.Nodo;
import vista.Vista;

/**
 *
 * @author dolceya
 */
public class Grafos {

    public static void main(String[] args) {
        Vista v = new Vista();
        v.setLocationRelativeTo(null);
        v.setVisible(true);
    }

    public static void CrearGrafo(int v) {
        for (int i = 0; i < v; i++) {
            boolean sw;
            do {
                try {
                    String ar = JOptionPane.showInputDialog(null, "Digite el número de aristas para el vertice con valor");
                    int a = Integer.parseInt(ar);
                    sw = false;
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Debe llenar los campos con números enteros", "Error de ingreso", JOptionPane.ERROR_MESSAGE);
                    sw = true;
                }
            } while (sw);

//            do{
            char id = JOptionPane.showInputDialog("Digite la letra del vertice").charAt(0);
//            }while(id!=null);
            Nodo t = new Nodo(id);
        }
    }

}