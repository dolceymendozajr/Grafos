/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import controlador.Grafos;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author dolceya
 */
public class Vista extends javax.swing.JFrame {

    /**
     * Creates new form Vista
     */
    int v = 0;

    public Vista() {
        initComponents();
    }

    private void Crear() {
        String vx = txt_vertices.getText();
        if (!vx.isEmpty()) {
            try {
                v = Integer.parseInt(vx);
                Grafos.CrearMatriz(v);
                Grafos.CrearLista();
                MostrarMatriz(v);
                txt_lista.setText(Grafos.MostrarLista());
            } catch (Exception e) {
                JOptionPane.showMessageDialog(rootPane, "Debe llenar los campos con números enteros", "Error de ingreso", JOptionPane.ERROR_MESSAGE);
                txt_vertices.setText("");
                System.out.println(e);
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Debe llenar los campos requeridos", "Error de ingreso", JOptionPane.WARNING_MESSAGE);
        }
    }

    void MostrarMatriz(int v) {
        int[][] MA = Grafos.getMatriz();
        DefaultTableModel modelo = (DefaultTableModel) tbl_matriz.getModel();
        if (v != 0) {
            modelo.setColumnCount(v);
            modelo.setRowCount(v);
            for (int i = 0; i < v; i++) {
                for (int j = 0; j < v; j++) {
                    tbl_matriz.setValueAt(MA[i][j], i, j);
                }
            }
        } else {
            JOptionPane.showMessageDialog(rootPane, "Debe llenar los campos requeridos", "Error de ingreso", JOptionPane.WARNING_MESSAGE);
        }
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Fondo = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txt_vertices = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        Imagen = new javax.swing.JLabel();
        btn_crear = new javax.swing.JButton();
        btn_cargar = new javax.swing.JButton();
        btn_descargar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_matriz = new javax.swing.JTable();
        lbl_matriz = new javax.swing.JLabel();
        lbl_matriz1 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        txt_lista = new javax.swing.JTextArea();
        btn_dfs = new javax.swing.JButton();
        btn_bfs = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setResizable(false);

        Fondo.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Swis721 LtCn BT", 1, 18)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("Número de Vertices");

        txt_vertices.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                txt_verticesKeyPressed(evt);
            }
        });

        Imagen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/graph.png"))); // NOI18N

        btn_crear.setBackground(new java.awt.Color(161, 192, 87));
        btn_crear.setFont(new java.awt.Font("Swis721 LtCn BT", 1, 18)); // NOI18N
        btn_crear.setForeground(new java.awt.Color(255, 255, 255));
        btn_crear.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/create.png"))); // NOI18N
        btn_crear.setToolTipText("Crear");
        btn_crear.setBorderPainted(false);
        btn_crear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_crearActionPerformed(evt);
            }
        });

        btn_cargar.setBackground(new java.awt.Color(161, 192, 87));
        btn_cargar.setFont(new java.awt.Font("Swis721 LtCn BT", 1, 18)); // NOI18N
        btn_cargar.setForeground(new java.awt.Color(255, 255, 255));
        btn_cargar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/up.png"))); // NOI18N
        btn_cargar.setToolTipText("Cargar grafo");
        btn_cargar.setBorderPainted(false);
        btn_cargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_cargarActionPerformed(evt);
            }
        });

        btn_descargar.setBackground(new java.awt.Color(161, 192, 87));
        btn_descargar.setFont(new java.awt.Font("Swis721 LtCn BT", 1, 18)); // NOI18N
        btn_descargar.setForeground(new java.awt.Color(255, 255, 255));
        btn_descargar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/down.png"))); // NOI18N
        btn_descargar.setToolTipText("Descargar grafo");
        btn_descargar.setBorderPainted(false);
        btn_descargar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_descargarActionPerformed(evt);
            }
        });

        tbl_matriz.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tbl_matriz.setEnabled(false);
        jScrollPane1.setViewportView(tbl_matriz);

        lbl_matriz.setFont(new java.awt.Font("Swis721 LtCn BT", 1, 18)); // NOI18N
        lbl_matriz.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_matriz.setText("Lista");

        lbl_matriz1.setFont(new java.awt.Font("Swis721 LtCn BT", 1, 18)); // NOI18N
        lbl_matriz1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lbl_matriz1.setText("Matriz de Adyacencia");

        txt_lista.setColumns(20);
        txt_lista.setRows(5);
        txt_lista.setTabSize(2);
        jScrollPane2.setViewportView(txt_lista);

        btn_dfs.setBackground(new java.awt.Color(161, 192, 87));
        btn_dfs.setFont(new java.awt.Font("Swis721 LtCn BT", 1, 18)); // NOI18N
        btn_dfs.setForeground(new java.awt.Color(255, 255, 255));
        btn_dfs.setText("DFS");
        btn_dfs.setToolTipText("Recorrido en profunidad");
        btn_dfs.setBorderPainted(false);
        btn_dfs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_dfsActionPerformed(evt);
            }
        });

        btn_bfs.setBackground(new java.awt.Color(161, 192, 87));
        btn_bfs.setFont(new java.awt.Font("Swis721 LtCn BT", 1, 18)); // NOI18N
        btn_bfs.setForeground(new java.awt.Color(255, 255, 255));
        btn_bfs.setText("BFS");
        btn_bfs.setToolTipText("Recorrido en anchura");
        btn_bfs.setBorderPainted(false);
        btn_bfs.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_bfsActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout FondoLayout = new javax.swing.GroupLayout(Fondo);
        Fondo.setLayout(FondoLayout);
        FondoLayout.setHorizontalGroup(
            FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(FondoLayout.createSequentialGroup()
                .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, FondoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(FondoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lbl_matriz1, javax.swing.GroupLayout.PREFERRED_SIZE, 295, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lbl_matriz, javax.swing.GroupLayout.PREFERRED_SIZE, 181, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(FondoLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(FondoLayout.createSequentialGroup()
                        .addComponent(btn_cargar)
                        .addGap(62, 62, 62)
                        .addComponent(btn_descargar))
                    .addComponent(Imagen))
                .addGap(62, 62, 62)
                .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(FondoLayout.createSequentialGroup()
                            .addComponent(btn_bfs)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btn_dfs))
                        .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txt_vertices, javax.swing.GroupLayout.PREFERRED_SIZE, 175, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, FondoLayout.createSequentialGroup()
                        .addComponent(btn_crear)
                        .addGap(49, 49, 49)))
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(11, 11, 11))
        );
        FondoLayout.setVerticalGroup(
            FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FondoLayout.createSequentialGroup()
                .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(FondoLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Imagen)
                            .addGroup(FondoLayout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_vertices, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btn_crear)
                                .addGap(18, 18, 18)
                                .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(btn_bfs)
                                    .addComponent(btn_dfs))))
                        .addGap(18, 18, 18)
                        .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btn_cargar)
                            .addComponent(btn_descargar)))
                    .addGroup(FondoLayout.createSequentialGroup()
                        .addGap(76, 76, 76)
                        .addComponent(jLabel3)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 48, Short.MAX_VALUE)
                .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbl_matriz1)
                    .addComponent(lbl_matriz))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(FondoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE)
                    .addComponent(jScrollPane2))
                .addGap(32, 32, 32))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Fondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Fondo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn_crearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_crearActionPerformed
        Crear();
    }//GEN-LAST:event_btn_crearActionPerformed

    private void btn_cargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_cargarActionPerformed
        try {
            Grafos.CargarMatriz();
            MostrarMatriz(Grafos.getVerticesMatriz());
            Grafos.CrearLista();
            txt_lista.setText(Grafos.MostrarLista());
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Matriz no pudo ser cargada de C:/apps/matriz.txt", "Error al cargar la matriz", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btn_cargarActionPerformed

    private void btn_descargarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_descargarActionPerformed
        try {
            Grafos.GuardarMatriz();
            Grafos.GuardarLista(txt_lista.getText());
        } catch (IOException ex) {
            Logger.getLogger(Vista.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_btn_descargarActionPerformed

    private void txt_verticesKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_verticesKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            Crear();
        }
    }//GEN-LAST:event_txt_verticesKeyPressed

    private void btn_dfsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_dfsActionPerformed
        try {
            JOptionPane.showMessageDialog(this, "Recorrido en profundidad: " + Grafos.DFS(), "DFS", JOptionPane.INFORMATION_MESSAGE);
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(this, "No se puede hacer el recorrido sin haber creado un grafo", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btn_dfsActionPerformed

    private void btn_bfsActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_bfsActionPerformed
        try {
            JOptionPane.showMessageDialog(this, "Recorrido en anchura: " + Grafos.BFS(), "BFS", JOptionPane.INFORMATION_MESSAGE);
        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(this, "No se puede hacer el recorrido sin haber creado un grafo", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_btn_bfsActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Vista.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Vista().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Fondo;
    private javax.swing.JLabel Imagen;
    private javax.swing.JButton btn_bfs;
    private javax.swing.JButton btn_cargar;
    private javax.swing.JButton btn_crear;
    private javax.swing.JButton btn_descargar;
    private javax.swing.JButton btn_dfs;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lbl_matriz;
    private javax.swing.JLabel lbl_matriz1;
    private javax.swing.JTable tbl_matriz;
    private javax.swing.JTextArea txt_lista;
    private javax.swing.JTextField txt_vertices;
    // End of variables declaration//GEN-END:variables
}
