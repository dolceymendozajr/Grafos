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
    
    public void CrearGrafo(int v, int a){
        for (int i = 0; i < v; i++) {
            char id = JOptionPane.showInputDialog("Digite la letra del vertice").charAt(0);
            Nodo t = new Nodo(id);
        }
    }

}
