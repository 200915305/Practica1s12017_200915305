
package practica1s12017_200915305;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 *
 * @author ubuntu
 */
public class Tablero extends javax.swing.JFrame {
    Matriz matriz = new Matriz();
    int contador_ID =1;
    public static String dimension ="";
    public static  ArrayList<String> listaDoblex =new ArrayList<String>();
    public static  ArrayList<String> listaDobley =new ArrayList<String>();
    public static  ArrayList<String> listaTriplex =new ArrayList<String>();
    public static  ArrayList<String> listaTripley =new ArrayList<String>();
     int longitud = 0;
    int longitud1 = 0;
    int contador_filas = 5;
    int contador_columnas = 5;
    int donde = 0;
    int conta_celdas;
    int conta_columnas;
    String objeto_seleccionado = "";
    
    
    
    public Tablero() {
        initComponents();
        System.out.println("DIMENSION......"+dimension);
        llenar_matriz(contador_columnas, contador_filas, "null");
        crear_pane_principal(contador_filas,contador_columnas);
       
       
    }
    
  public void llenar_matriz(int largo, int ancho, String contenido) {
        matriz.sampar_matriz(contenido, contador_ID, 0);
        contador_ID++;
        for (int i = 0; i < largo - 1; i++) {
            matriz.sampar_matriz(contenido, contador_ID, 1);
            contador_ID++;
        }
        for (int i = 0; i < ancho - 1; i++) {
            matriz.sampar_matriz(contenido, contador_ID, 2);
            contador_ID++;
            for (int j = 0; j < largo - 1; j++) {
                matriz.sampar_matriz(contenido, contador_ID, 3);
                contador_ID++;
            }
        }
        System.out.println("Imprimiendo Matriz desde llenar la matriz\n");
        matriz.GraficarMatriz();
    }
    
 public void crear_pane_principal(int fila, int columna) {

        int tamaño_fila;
        int tamaño_columna;
      
        
        NodoMatriz temp1 = this.matriz.raiz;
     
        longitud = columna;

        int largo =70 * columna;
        int ancho = 70 * fila;

        this.jPanel6.removeAll();
        this.jPanel6.setBorder(BorderFactory.createLineBorder(Color.BLUE));
        //this.jPanel6.setPreferredSize(new Dimension(largo, ancho));

        int No_filas = fila;//Integer.parseInt(this.jTextField1.getText());
        int No_columnas = longitud;//Integer.parseInt(this.jTextField2.getText());

        int altura_pane_Matriz = ancho;//this.Pane_objetos.getSize().height;
        int ancho_pane_Matriz = largo;//this.Pane_objetos.getSize().width;

        tamaño_fila = ancho_pane_Matriz / No_columnas;
        tamaño_columna = altura_pane_Matriz / No_filas;

        final int contador_Lista = (No_filas * No_columnas);
        final javax.swing.JLabel[] label = new javax.swing.JLabel[contador_Lista];

        int columnas;
        int multiplicador_filas = 0;

        for (int Contador_celdas = 0; Contador_celdas < contador_Lista; Contador_celdas++) {
            if (temp1 != null) {
                label[Contador_celdas] = new javax.swing.JLabel();
                label[Contador_celdas].setBounds((tamaño_fila * 0), (tamaño_columna * multiplicador_filas), tamaño_fila, tamaño_columna);
                label[Contador_celdas].setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                label[Contador_celdas].setBorder(BorderFactory.createLineBorder(Color.GRAY));
                if (temp1.objeto.equals("vacio")) {
                    label[Contador_celdas].removeAll();
                    label[Contador_celdas].repaint();
                } else {
                    ImageIcon img = new ImageIcon(cual_objeto(temp1.objeto));
                    Icon icono = new ImageIcon(img.getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT));
                    label[Contador_celdas].removeAll();
                    label[Contador_celdas].setIcon(icono);
                    label[Contador_celdas].repaint();
                    label[Contador_celdas].setIcon(icono);
                }
                //label[Contador_celdas].setText("" + (Contador_celdas + 1));
                label[Contador_celdas].addMouseListener(new MouseListener() {

                    @Override
                    public void mouseClicked(MouseEvent me) {
                        for (int i = 0; i < contador_Lista; i++) {
                            if (me.getSource().equals(label[i])) {
                                //JOptionPane.showMessageDialog(null, "DONDE: " + i);
                                if (objeto_seleccionado.equals("")) {
                                    JOptionPane.showMessageDialog(null, "\nNo ha seleccionado un objeto\nSeleccione uno porfavor", "Advertencia", JOptionPane.INFORMATION_MESSAGE);
                                } else {
                                    donde = i;
                                    conta_celdas = i;
                                    //JOptionPane.showMessageDialog(null, "Contador celdas: " + conta_celdas);
                                    ImageIcon img = new ImageIcon(cual_objeto(objeto_seleccionado));
                                    Icon icono = new ImageIcon(img.getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT));
                                    label[donde].removeAll();
                                    label[donde].setIcon(icono);
                                    label[donde].repaint();
                                    label[donde].setIcon(icono);
                                    matriz.modificar(conta_celdas, objeto_seleccionado);
                                    matriz.imprimir_matriz();
                                    objeto_seleccionado = "";
                                }
                            }
                        }
                        //actualizar();
                        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }

                    @Override
                    public void mousePressed(MouseEvent me
                    ) {
                        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }

                    @Override
                    public void mouseReleased(MouseEvent me
                    ) {
                        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }

                    @Override
                    public void mouseEntered(MouseEvent me
                    ) {
                        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }

                    @Override
                    public void mouseExited(MouseEvent me
                    ) {
                        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }
                });

                this.jPanel6.add(label[Contador_celdas], null);

                int columna_temp = 1;
                //temp1 = temp1.abajo;
                NodoMatriz tempo = temp1.izquierda;
                for (columnas = Contador_celdas + 1; columnas < Contador_celdas + No_columnas; columnas++) {
                    if (tempo != null) {
                        label[columnas] = new javax.swing.JLabel();
                        label[columnas].setBounds(tamaño_fila * columna_temp, (tamaño_columna * multiplicador_filas), tamaño_fila, tamaño_columna);
                        label[columnas].setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                        label[columnas].setBorder(BorderFactory.createLineBorder(Color.GRAY));
                        if (tempo.objeto.equals("vacio")) {
                            label[columnas].removeAll();
                            label[columnas].repaint();
                        } else {
                            ImageIcon img1 = new ImageIcon(cual_objeto(tempo.objeto));
                            Icon icono1 = new ImageIcon(img1.getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT));
                            label[columnas].removeAll();
                            label[columnas].setIcon(icono1);
                            label[columnas].repaint();
                            label[columnas].setIcon(icono1);
                        }
                        //label[columnas].setText("" + (columnas + 1));
                        this.conta_columnas = columnas;
                        label[columnas].addMouseListener(new MouseListener() {

                            @Override
                            public void mouseClicked(MouseEvent me) {
                                for (int i = 0; i < contador_Lista; i++) {
                                    if (me.getSource().equals(label[i])) {
                                        //JOptionPane.showMessageDialog(null, "DONDE: " + i);
                                        if (objeto_seleccionado.equals("")) {
                                            JOptionPane.showMessageDialog(null, "\nNo ha seleccionado un objeto\nSeleccione uno porfavor", "Advertencia", JOptionPane.INFORMATION_MESSAGE);
                                        } else {
                                            donde = i;
                                            conta_celdas = i;
                                            //JOptionPane.showMessageDialog(null, "Contador celdas: " + conta_celdas + " Contador columnas: " + conta_columnas);
                                            ImageIcon img = new ImageIcon(cual_objeto(objeto_seleccionado));
                                            Icon icono = new ImageIcon(img.getImage().getScaledInstance(70, 70, Image.SCALE_DEFAULT));
                                            label[donde].removeAll();
                                            label[donde].setIcon(icono);
                                            label[donde].repaint();
                                            label[donde].setIcon(icono);
                                            matriz.modificar(conta_celdas, objeto_seleccionado);
                                            matriz.imprimir_matriz();
                                            objeto_seleccionado = "";
                                        }
                                    }
                                }
                                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                            }

                            @Override
                            public void mousePressed(MouseEvent me) {
                                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                            }

                            @Override
                            public void mouseReleased(MouseEvent me) {
                                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                            }

                            @Override
                            public void mouseEntered(MouseEvent me) {
                                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                            }

                            @Override
                            public void mouseExited(MouseEvent me) {
                                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                            }
                        });
                        this.jPanel6.add(label[columnas], null);

                        columna_temp++;
                    }
                    tempo = tempo.izquierda;
                }
                temp1 = temp1.abajo;
            }

            multiplicador_filas++;
            Contador_celdas = Contador_celdas + No_columnas - 1;
        }
    }
    
        public String cual_objeto(String ob) {
        if (ob.equals("Pared")) {
            return "C:\\Users\\Administrador\\Desktop\\Practica1s22015_200915305\\src\\practica1s22015_200915305\\Imagenes\\Pared.png";
        } else if (ob.equals("Suelo")) {
            return "C:\\Users\\Administrador\\Desktop\\Practica1s22015_200915305\\src\\practica1s22015_200915305\\Imagenes\\Suelo.png";
        } else if (ob.equals("Goomba")) {
            return "C:\\Users\\Administrador\\Desktop\\Practica1s22015_200915305\\src\\practica1s22015_200915305\\Imagenes\\Goomba.png";
        } else if (ob.equals("Mario")) {
            return "C:\\Users\\Administrador\\Desktop\\Practica1s22015_200915305\\src\\practica1s22015_200915305\\Imagenes\\Mario.png";
        } else if (ob.equals("Koopa")) {
            return "C:\\Users\\Administrador\\Desktop\\Practica1s22015_200915305\\src\\practica1s22015_200915305\\Imagenes\\Koopa.png";
        } else if (ob.equals("Ficha")) {
            return "C:\\Users\\Administrador\\Desktop\\Practica1s22015_200915305\\src\\practica1s22015_200915305\\Imagenes\\Ficha.png";
        } else if (ob.equals("Vida")) {
            return "C:\\Users\\Administrador\\Desktop\\Practica1s22015_200915305\\src\\practica1s22015_200915305\\Imagenes\\Vida.png";
        } else if (ob.equals("Castillo")) {
            return "C:\\Users\\Administrador\\Desktop\\Practica1s22015_200915305\\src\\practica1s22015_200915305\\Imagenes\\Castillo.png";
        } else {
            return null;
        }
    
    
        }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel3 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel6 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 410, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 391, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Lista Diccionario", jPanel1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 410, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 391, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Lista Fichas Activas", jPanel2);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 410, Short.MAX_VALUE)
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 391, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Cola de Fichas ", jPanel3);

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 410, Short.MAX_VALUE)
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 391, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Lista de Jugadores", jPanel4);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 410, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 391, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("Matriz", jPanel5);

        jPanel6.setPreferredSize(new java.awt.Dimension(2000, 2000));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2000, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2000, Short.MAX_VALUE)
        );

        jScrollPane2.setViewportView(jPanel6);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(31, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 481, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(129, 129, 129)
                        .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(82, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(Tablero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tablero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tablero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tablero.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Tablero().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTabbedPane jTabbedPane1;
    // End of variables declaration//GEN-END:variables
}
