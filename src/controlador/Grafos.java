package controlador;

import javax.swing.JOptionPane;
import modelo.Nodo;
import vista.Vista;

/**
 *
 * @author dolceya
 */
public class Grafos {

    /*Creacion de la matriz de adyacencia que luego generara el grafo */
    static int MA[][];

    public static void main(String[] args) {
        Vista v = new Vista();
        v.setLocationRelativeTo(null);
        v.setVisible(true);
    }

    /*Método que permite Crear la matriz de Adyacencia*/
    public static void CrearMatriz(int v) {
        MA = new int[v][v];
        boolean sw;
        int a=-1;
        int p=-1;
        for (int i = 0; i < v; i++) {
            System.out.println("Nodo" + i);
            do {
                try {
                    String ar = JOptionPane.showInputDialog(null, "Digite a que vertice esta conectado el vertice " + i);
                    a = Integer.parseInt(ar);
                    String pe = JOptionPane.showInputDialog(null, "Digite el peso de aristas la arista " + i + a);
                    p = Integer.parseInt(pe);
                    sw = false;
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Debe llenar los campos con números enteros", "Error de ingreso", JOptionPane.ERROR_MESSAGE);
                    sw = true;
                }
            } while (sw);
            if (!(a==p&&p==-1)) {
                MA[i][a] = p;
            }
        }
    }

//        char idr = JOptionPane.showInputDialog("Digite la letra del vertice").charAt(0);
//        root = new Nodo(idr);
//        v--;
//        for (int i = 0; i < v; i++) {
//            boolean sw;
//            System.out.println("1");
//            do {
//                try {
//                    String ar = JOptionPane.showInputDialog(null, "Digite el número de aristas para el vertice A");
//                    int a = Integer.parseInt(ar);
//                    sw = false;
//                } catch (Exception e) {
//                    JOptionPane.showMessageDialog(null, "Debe llenar los campos con números enteros", "Error de ingreso", JOptionPane.ERROR_MESSAGE);
//                    sw = true;
//                    System.out.println(e);
//                }
//            } while (sw);
//            char id = JOptionPane.showInputDialog("Digite la letra del vertice").charAt(0);
//            root.addHijo(id);
//        }
    
    /*Método que guardará la matriz de adyacencia en un archivo*/
    public static void MostrarMatriz(int v) {
        for (int i = 0; i < v; i++) {
            for (int j = 0; j < v; j++) {
                if(j==v-1){
                    System.out.print(MA[i][j]);
                }else{
                    System.out.print(MA[i][j]+",");
                }
            }
            System.out.println("");
        }
    }

}
