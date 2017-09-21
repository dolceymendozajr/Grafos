package controlador;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
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
    static int vertices;

    public static void main(String[] args) {
        //Crea el directorio raíz donde se guardaron los archivos txt para la lista y la matriz
        File d = new File("C:/apps/");
        if (!d.exists()) {
            d.mkdirs();
        }
        Vista v = new Vista();
        v.setLocationRelativeTo(null);
        v.setVisible(true);
    }

    /*Método que permite Crear la matriz de Adyacencia*/
    public static void CrearMatriz(int v) {
        MA = new int[v][v];
        vertices = v;
        boolean sw;
        int a = -1;
        int p = -1;
        for (int i = 0; i < v; i++) {
            System.out.println("Nodo " + i);
            do {
                try {
                    String in = JOptionPane.showInputDialog(null, "Digite a que vertices esta conectado el vertice " + i + "\nDebe separarlos por comas");
                    String ar[] = in.split(",");
                    for (int j = 0; j < ar.length; j++) {
                        a = Integer.parseInt(ar[j]);
                        String pe = JOptionPane.showInputDialog(null, "Digite el peso de la arista " + i + a);
                        p = Integer.parseInt(pe);
                        if (!(a == p && p == -1)) {
                            MA[i][a] = p;
                        }
                    }
                    sw = false;
                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, "Debe llenar los campos con números enteros", "Error de ingreso", JOptionPane.ERROR_MESSAGE);
                    sw = true;
                }
            } while (sw);
        }
        JOptionPane.showMessageDialog(null, "Matriz Creada");
    }

    /*Método que guarda la matriz de adyacencia en un archivo*/
    public static void GuardarMatriz() throws IOException {
        int v = vertices;
        File m = new File("C:/apps/matriz.txt");
        BufferedWriter bw;
        bw = new BufferedWriter(new FileWriter(m, false));
        String c;
        for (int i = 0; i < v; i++) {
            c = "";
            for (int j = 0; j < v; j++) {
                if (j == v - 1) {
                    c = c + MA[i][j];
                } else {
                    c = c + MA[i][j] + ",";
                }
            }
            bw.write(c);
            bw.newLine();
        }
        bw.close();
        JOptionPane.showMessageDialog(null, "Matriz guardada en C:/apps/matriz.txt");

    }

    /*Método que retorna la matriz de adyacencia*/
    public static int[][] getMatriz() {
        return MA;
    }

    /*Método que muestra la matriz de adyacencia*/
    public static void MostrarMatriz(int v) {
        for (int i = 0; i < v; i++) {
            for (int j = 0; j < v; j++) {
                if (j == v - 1) {
                    System.out.print(MA[i][j]);
                } else {
                    System.out.print(MA[i][j] + ",");
                }
            }
            System.out.println("");
        }
    }

}
