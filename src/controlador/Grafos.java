package controlador;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
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
    static ArrayList<Nodo> nodos = new ArrayList<>();
    static boolean[] visitados;

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
                    in = JOptionPane.showInputDialog(null, "Digite a que vertices esta conectado el vertice " + i + "\nSi no tiene conexiones digite '-1'" + "\nDebe separarlos por comas");
                    a = Integer.parseInt(in);
                    if (a != -1) {
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
                    } else {
                        for (int j = 0; j < MA.length; j++) {
                            MA[i][j] = 0;
                        }
                        sw = false;
                    }

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
        CrearLista();
        JOptionPane.showMessageDialog(null, "Matriz y lista creadas");
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
            JOptionPane.showMessageDialog(null, "Matriz y lista cargada de C:/apps/");
            CrearLista();
        }
    }
    
    /*Metodo que cuenta el numero de lineas del archivo, que será igual al número de vertices de la matriz*/
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
        for (int i = 0; i < MA.length; i++) {
            if (i != 0) {
                nodos.add(new Nodo(i));
            }
        }
        //Agrega vertice adyacente
        Nodo p = ptr;
        for (int i = 0; i < MA.length; i++) {
            for (int j = 0; j < MA.length; j++) {
                if (MA[i][j] != 0) {
                    p.addHijo(j);
                    Nodo q = p.getHijos().get(i);
                    q.setPeso(MA[i][j]);
                }
            }
        }
    }

    /*Metodo para mostrar la lista*/
    public static String MostrarLista() {
        String c = "";
        Nodo p;
        Nodo hijo;
        for (int i = 0; i < nodos.size(); i++) {
            p = nodos.get(i);
            c = c + String.valueOf(p.getId());
            for (int j = 0; j < p.getHijos().size(); j++) {
                hijo = p.getHijos().get(j);
                c = c + "->" + hijo.getId() + "(" + hijo.getPeso() + ")";
            }
            return c = c + "\n";
        }
        return c;
    }
    
    /*Metodo que guarda la lista en un archivo*/
    public static void GuardarLista(String text) throws IOException{
        File l = new File("C:/apps/lista.txt");
        BufferedWriter bw;
        bw = new BufferedWriter(new FileWriter(l, false));
        bw.write(text);
        bw.close();
        JOptionPane.showMessageDialog(null, "Lista guardada en C:/apps/lista.txt");
    }

    /*Metodo para hacer el recorrido en anchura*/
    public static String BFS() {
        if (MA.length != 0) {
            visitados = new boolean[MA.length];
            Queue<Integer> cola = new LinkedList<>();
            ArrayList<Integer> recorridos = new ArrayList<>();
            recorridos.add(ptr.getId());
            cola.add(ptr.getId());
            visitados[0] = true;
            while (!cola.isEmpty()) {
                int j = cola.remove();
                for (int i = 0; i < MA.length; i++) {
                    if (MA[i][j] != 0 && !visitados[i]) {
                        cola.add(i);
                        recorridos.add(i);
                        visitados[i] = true;
                    }
                }
            }
            String c = "";
            for (int i = 0; i < recorridos.size(); i++) {
                if (i == recorridos.size() - 1) {
                    c = c + recorridos.get(i);
                } else {
                    c = c + recorridos.get(i) + ",";
                }
            }
            return c;
        } else {
            return "No se ha creado el grafo";
        }
    }

    /*Metodo para hacer el recorrido en profundidad*/
    public static String DFS() {
        if (MA.length != 0) {
            visitados = new boolean[MA.length];
            Stack<Integer> pila = new Stack<>();
            ArrayList<Integer> recorridos = new ArrayList<>();
            recorridos.add(ptr.getId());
            pila.add(ptr.getId());
            visitados[0] = true;
            while (!pila.isEmpty()) {
                int j = pila.pop();
                for (int i = 0; i < MA.length; i++) {
                    if (MA[i][j] != 0 && !visitados[i]) {
                        pila.add(i);
                        recorridos.add(i);
                        visitados[i] = true;
                    }
                }
            }
            String c = "";
            for (int i = 0; i < recorridos.size(); i++) {
                if (i == recorridos.size() - 1) {
                    c = c + recorridos.get(i);
                } else {
                    c = c + recorridos.get(i) + ",";
                }
            }
            return c;
        } else {
            return "No se ha creado el grafo";
        }

    }
}
