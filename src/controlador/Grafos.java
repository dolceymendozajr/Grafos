package controlador;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
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
    static Nodo ptr;
    static ArrayList<Nodo> nodos = new ArrayList<Nodo>();

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

    /*Método que crea la matriz de adyacencia*/
    public static void CrearMatriz(int v) {
        MA = new int[v][v];
        vertices = v;
        boolean sw;
        int a = -1;
        int p = -1;
        String in = null;
        for (int i = 0; i < v; i++) {
            do {
                try {
                    in = JOptionPane.showInputDialog(null, "Digite a que vertices esta conectado el vertice " + i + "\nDebe separarlos por comas");
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
                    if (in == null) {
                        sw = false;
                    } else {
                        sw = true;
                        JOptionPane.showMessageDialog(null, "Debe llenar los campos con números enteros", "Error de ingreso", JOptionPane.ERROR_MESSAGE);
                    }
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

    /*Método que guarda la matriz de adyacencia en un archivo*/
//TOFIX
    public static void CargarMatriz() throws IOException {
        File m = new File("C:/apps/matriz.txt");
        if (m.exists()) {
            BufferedReader br;
            br = new BufferedReader(new FileReader(m));
            int l = getVerticesMatriz(); //Toma el numero de lineas del archivo
            MA = new int[l][l];
            String c = null;
            while ((c = br.readLine()) != null) {
                String n[] = c.split(",");
                for (int i = 0; i < l; i++) {
                    for (int j = 0; j < l; j++) {
                        MA[i][j] = Integer.parseInt(n[j]);
                    }
                }
            }
            br.close();
            JOptionPane.showMessageDialog(null, "Matriz cargada de C:/apps/matriz.txt");
        }
    }

    public static int getVerticesMatriz() throws FileNotFoundException, IOException {
        File m = new File("C:/apps/matriz.txt");
        BufferedReader br;
        br = new BufferedReader(new FileReader(m));
        String c;
        int l = 0;
        while ((c = br.readLine()) != null) {
            l++;
        }
        br.close();
        return l;
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

    /*Método que crea la lista*/
    public static void CrearLista() {
        //Agrega todos los vertices 
        ptr = new Nodo(0);
        nodos.add(ptr);
        for (int i = 1; i < MA.length; i++) {
            nodos.add(new Nodo(i));
        }
        //Agrega vertice adyacente
        Nodo p = ptr;
        for (int i = 0; i < MA.length; i++) {
            for (int j = 0; j < MA.length; j++) {
                if (MA[i][j] != 0) {
                    p.addHijo(j);
                    p = p.getHijos().get(i);
                    p.setPeso(MA[i][j]);
                }
            }
        }
    }
}
