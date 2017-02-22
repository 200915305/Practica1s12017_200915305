package practica1s12017_200915305;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.File;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import static practica1s12017_200915305.ListaCircular.contarc;




/**
 *
 * @author ubuntu
 */
public class Tablero extends javax.swing.JFrame {
    
    Hilo hilo = new Hilo();
    Matriz matriz = new Matriz();
    ListaDiccionario diccionario =new ListaDiccionario();
    ListaCircular listaCircular = new ListaCircular();
    Lista lista = new Lista();
    public int contador=0;  
            
   
    int contador_ID = 1;
    public static int dimension;
    public static ArrayList<String> listaDoblex = new ArrayList<String>();
    public static ArrayList<String> listaDobley = new ArrayList<String>();
    public static ArrayList<String> listaTriplex = new ArrayList<String>();
    public static ArrayList<String> listaTripley = new ArrayList<String>();
    int longitud = 0;
    int longitud1 = 7;
    int contador_filas = dimension;
    int contador_columnas = dimension;
    int donde = 0;
    int conta_celdas;
    int conta_columnas;
    String objeto_seleccionado = "";
    javax.swing.JCheckBox[] chec = new javax.swing.JCheckBox[7];
    public int Contador2=0;
    public Tablero() {
        initComponents();
        System.out.println("DIMENSION......" + dimension);
        llenar_matriz(contador_columnas, contador_filas, "null");
        AgregarDoblesyTriples();
        crear_pane_principal(contador_filas, contador_columnas);
        CrearObjetos(); 
        hilo.start();

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

    public void AgregarDoblesyTriples() {
        int x = 0;
        int y = 0;
        int posicion = 0;

        for (int i = 0; i < listaDoblex.size(); i++) {
            x = Integer.parseInt(listaDoblex.get(i));
            y = Integer.parseInt(listaDobley.get(i));
            posicion = 1 + (y - 1) * (dimension) + (x - 1);

            matriz.modificar(posicion, "DOBLE");

        }

        for (int i = 0; i < listaTriplex.size(); i++) {
            x = Integer.parseInt(listaTriplex.get(i));
            y = Integer.parseInt(listaTripley.get(i));
            posicion = 1 + (y - 1) * (dimension) + (x - 1);

            matriz.modificar(posicion, "TRIPLE");

        }

        matriz.GraficarMatriz();
    }

    public void crear_pane_principal(int fila, int columna) {

        int tamaño_fila;
        int tamaño_columna;

        NodoMatriz temp1 = this.matriz.raiz;

        longitud = columna;

        int largo = 50 * columna;
        int ancho = 50 * fila;

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
                    Icon icono = new ImageIcon(img.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
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
                                    Icon icono = new ImageIcon(img.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
                                    label[donde].removeAll();
                                    label[donde].setIcon(icono);
                                    label[donde].repaint();
                                    label[donde].setIcon(icono);
                                   
                                    matriz.modificar(conta_celdas+1, objeto_seleccionado);
                                    System.out.println("Se selecciono laaaaaaaa"+donde+","+objeto_seleccionado);
                                    matriz.GraficarMatriz();
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
                            Icon icono1 = new ImageIcon(img1.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
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
                                            Icon icono = new ImageIcon(img.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
                                            label[donde].removeAll();
                                            label[donde].setIcon(icono);
                                            label[donde].repaint();
                                            label[donde].setIcon(icono);
                                            matriz.modificar(conta_celdas+1, objeto_seleccionado);
                                            System.out.println("Se selecciono laaaaaaaa"+conta_celdas+","+objeto_seleccionado);
                                            matriz.GraficarMatriz();
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

    public void CrearObjetos(){
            
            NodoCircular temporal=practica1s12017_200915305.ListaCircular.primeroc;
            NodoLista temp;
            NodoLista actual;
            String Usuario=practica1s12017_200915305.ListaCircular.UsuarioActual.get(contador);
           for(int i=0; i<contarc;i++){
            temp=temporal.primerol;
                if(temporal.usuario.equals(Usuario)){
                   listaCircular.ImprimirUsuario(Usuario);
            int tamaño_fila;
            int tamaño_columna;

            int largo = 50 * longitud1;
            int ancho = 200;

            this.jPanel1.removeAll();
            this.jPanel1.setBorder(BorderFactory.createLineBorder(Color.BLUE));
            this.jPanel2.removeAll();
            this.jPanel2.setBorder(BorderFactory.createLineBorder(Color.GRAY));
            

            int No_filas = 3;//Integer.parseInt(this.jTextField1.getText());
            int No_columnas = longitud1;//Integer.parseInt(this.jTextField2.getText());

            int altura_pane_Matriz = ancho;//this.Pane_objetos.getSize().height;
            int ancho_pane_Matriz = largo;//this.Pane_objetos.getSize().width;

            if (longitud1 == 0) {
                tamaño_fila = 1 / 1;
                tamaño_columna = altura_pane_Matriz / No_filas;
            } else {
                tamaño_fila = ancho_pane_Matriz / No_columnas;
                tamaño_columna = altura_pane_Matriz / No_filas;
            }
            int contador_Lista = (No_filas * No_columnas);
            javax.swing.JLabel[] label = new javax.swing.JLabel[contador_Lista];
            
            int columnas;
            int multiplicador_filas = 0;
             
                   
                   
            temp=temporal.primerol;
            for (int Contador_celdas = 0; Contador_celdas < contador_Lista; Contador_celdas++) {
                if (temp != null) {
                    label[Contador_celdas] = new javax.swing.JLabel();
                    label[Contador_celdas].setBounds((tamaño_fila * 0), (tamaño_columna * multiplicador_filas), tamaño_fila, tamaño_columna);
                    label[Contador_celdas].setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                    label[Contador_celdas].setBorder(BorderFactory.createLineBorder(Color.BLUE));
                    ImageIcon img = new ImageIcon(cual_objeto(temp.Letra));
                    Icon icono = new ImageIcon(img.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
                    label[Contador_celdas].removeAll();
                    label[Contador_celdas].setIcon(icono);
                    label[Contador_celdas].repaint();
                    label[Contador_celdas].setIcon(icono);
                    label[Contador_celdas].setText("" + (Contador_celdas + 1));
                    label[Contador_celdas].addMouseMotionListener(new MouseMotionListener() {
                    
                    
                    
                   
                        
                        @Override
                        public void mouseDragged(MouseEvent me) {
                        }

                        @Override
                        public void mouseMoved(MouseEvent me) {
                            //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                        }
                    });

                    label[Contador_celdas].addMouseListener(new MouseListener() {

                        @Override
                        public void mouseClicked(MouseEvent me) {
                             
                             practica1s12017_200915305.ListaCircular.Eliminar();
                             objeto_seleccionado = practica1s12017_200915305.ListaCircular.temp2.Letra;                      
                             listaCircular.GraficarListaCircular();

                             System.out.println("............>>>"+practica1s12017_200915305.ListaCircular.temp2.Letra+"\n");
                             CrearObjetos();
                            //Crear_Juego CJ = new Crear_Juego();
                            //cerrar();
                            //CJ.setVisible(true);
                            //actualizar();
                            //JOptionPane.showMessageDialog(null, objeto_seleccionado);
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

                    this.jPanel1.add(label[Contador_celdas], null);
                    
                    int columna_temp = 1;
                    temp = temp.sig;

                    for (columnas = Contador_celdas + 1; columnas < Contador_celdas + No_columnas; columnas++) {
                        if (temp != null) {
                            label[columnas] = new javax.swing.JLabel();
                            label[columnas].setBounds(tamaño_fila * columna_temp, (tamaño_columna * multiplicador_filas), tamaño_fila, tamaño_columna);
                            label[columnas].setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                            label[columnas].setBorder(BorderFactory.createLineBorder(Color.BLUE));
                            ImageIcon img1 = new ImageIcon(cual_objeto(temp.Letra));
                            Icon icono1 = new ImageIcon(img1.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT));
                            label[columnas].removeAll();
                            label[columnas].setIcon(icono1);
                            label[columnas].repaint();
                            label[columnas].setIcon(icono1);
                            label[columnas].setText("" + (columnas + 1));

                            this.jPanel1.add(label[columnas], null);

                            columna_temp++;
                            temp = temp.sig;
                        }
                    }
                }
            }
                }
                temporal=temporal.sig;
           }// Final del Primer for ...for(int i=0; i<contarc;i++)
           
            contador++;
      if (contador>=contarc) {
          contador=0;
      }
           
        }

    

    public String cual_objeto(String ob) {
        File Triple = new File("Imagenes\\Triple.png");
        File Doble = new File("Imagenes\\Doble.png");
        File A = new File("Imagenes\\A.png");
        File B = new File("Imagenes\\B.jpg");
        File C = new File("Imagenes\\C.jpg");
        File D = new File("Imagenes\\D.png");
        File E = new File("Imagenes\\E.jpg");
        File F = new File("Imagenes\\F.png");
        File G = new File("Imagenes\\G.png");
        File H = new File("Imagenes\\H.png");
        File I = new File("Imagenes\\I.png");
        File J = new File("Imagenes\\J.png");
        File L = new File("Imagenes\\L.png");
        File M = new File("Imagenes\\M.png");
        File N = new File("Imagenes\\N.png");
        File Ñ = new File("Imagenes\\Ñ.png");
        File O = new File("Imagenes\\O.png");
        File P = new File("Imagenes\\P.png");
        File Q = new File("Imagenes\\Q.png");
        File R = new File("Imagenes\\R.png");
        File S = new File("Imagenes\\S.png");
        File T = new File("Imagenes\\T.png");
        File U = new File("Imagenes\\U.png");
        File V = new File("Imagenes\\V.png");
        File X = new File("Imagenes\\X.png");
        File Y = new File("Imagenes\\Y.png");
        File Z = new File("Imagenes\\Z.png");

        if (ob.equals("A")) {
            return A.toString();
        } else if (ob.equals("B")) {
            return B.toString();
        } else if (ob.equals("C")) {
            return C.toString();
        } else if (ob.equals("D")) {
            return D.toString();
        } else if (ob.equals("E")) {
            return E.toString();
        } else if (ob.equals("F")) {
            return F.toString();
        } else if (ob.equals("G")) {
            return G.toString();
        } else if (ob.equals("H")) {
            return H.toString();
        } else if (ob.equals("I")) {
            return I.toString();
        } else if (ob.equals("J")) {
            return J.toString();
        } else if (ob.equals("L")) {
            return L.toString();
        } else if (ob.equals("M")) {
            return M.toString();
        } else if (ob.equals("N")) {
            return N.toString();
        } else if (ob.equals("Ñ")) {
            return Ñ.toString();
        } else if (ob.equals("O")) {
            return O.toString();
        } else if (ob.equals("P")) {
            return P.toString();
        } else if (ob.equals("Q")) {
            return Q.toString();
        } else if (ob.equals("R")) {
            return R.toString();
        } else if (ob.equals("S")) {
            return S.toString();
        } else if (ob.equals("T")) {
            return T.toString();
        } else if (ob.equals("U")) {
            return U.toString();
        } else if (ob.equals("V")) {
            return V.toString();
        } else if (ob.equals("X")) {
            return X.toString();
        } else if (ob.equals("Y")) {
            return Y.toString();
        } else if (ob.equals("Z")) {
            return Z.toString();
        } else if (ob.equals("DOBLE")) {
            return Doble.toString();
        } else if (ob.equals("TRIPLE")) {
            return Triple.toString();
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel6 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jTextField1 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jScrollPane1.setPreferredSize(new java.awt.Dimension(2000, 2000));
        jScrollPane1.setViewportView(jLabel1);

        jTabbedPane1.addTab("Matriz", jScrollPane1);

        jScrollPane4.setPreferredSize(new java.awt.Dimension(2000, 2000));
        jScrollPane4.setViewportView(jLabel2);

        jTabbedPane1.addTab("Cola de Fichas", jScrollPane4);

        jScrollPane5.setPreferredSize(new java.awt.Dimension(2000, 2000));
        jScrollPane5.setViewportView(jLabel3);

        jTabbedPane1.addTab("Lista Fichas Activas", jScrollPane5);

        jScrollPane6.setPreferredSize(new java.awt.Dimension(2000, 2000));
        jScrollPane6.setViewportView(jLabel4);

        jTabbedPane1.addTab("Lista Diccionario", jScrollPane6);

        jScrollPane3.setPreferredSize(new java.awt.Dimension(2000, 2000));
        jScrollPane3.setViewportView(jLabel5);

        jTabbedPane1.addTab("Lista Usuarios", jScrollPane3);

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

        jButton1.setText("Agregar Palabra");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jPanel1.setPreferredSize(new java.awt.Dimension(350, 50));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 350, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 50, Short.MAX_VALUE)
        );

        jButton2.setText("Agregar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 379, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 55, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 732, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 382, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 6, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(27, 27, 27))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(47, 47, 47)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(65, 65, 65))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(52, 52, 52)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 480, Short.MAX_VALUE)
                    .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       //Agregar una Palabra al Diccionario
       String Palabra = jTextField1.getText();
       practica1s12017_200915305.ListaDiccionario.AgregarDiccionario(Palabra);
       diccionario.GraficarListaDiccionario();
   
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // Agregar 
         
        
    }//GEN-LAST:event_jButton2ActionPerformed

    public static void Reportes() {
        
        File Matriz = new File("Matriz.jpg");
        ImageIcon img = new ImageIcon(Matriz.toString());
        Icon icono = new ImageIcon(img.getImage().getScaledInstance(img.getIconWidth(), img.getIconHeight(), Image.SCALE_DEFAULT));
        jLabel1.removeAll();
        jLabel1.setIcon(icono);
        jLabel1.repaint();
        jLabel1.setIcon(icono);
        File Cola = new File("Cola.jpg");
        ImageIcon img2 = new ImageIcon(Cola.toString());
        Icon icono2 = new ImageIcon(img2.getImage().getScaledInstance(img2.getIconWidth(), img2.getIconHeight(),Image.SCALE_DEFAULT ));
        jLabel2.removeAll();
        jLabel2.setIcon(icono2);
        jLabel2.repaint();
        jLabel2.setIcon(icono2);
        File Usuario = new File("Usuario.jpg");
        ImageIcon img3 = new ImageIcon(Usuario.toString());
        Icon icono3 = new ImageIcon(img3.getImage().getScaledInstance(img3.getIconWidth(), img3.getIconHeight(), Image.SCALE_DEFAULT));
        jLabel3.removeAll();
        jLabel3.setIcon(icono3);
        jLabel3.repaint();
        jLabel3.setIcon(icono3);
        File Diccionario = new File("Diccionario.jpg");
        ImageIcon img4 = new ImageIcon(Diccionario.toString());
        Icon icono4 = new ImageIcon(img4.getImage().getScaledInstance(img4.getIconWidth(), img4.getIconHeight(), Image.SCALE_DEFAULT));
        jLabel4.removeAll();
        jLabel4.setIcon(icono4);
        jLabel4.repaint();
        jLabel4.setIcon(icono4);
        File Circular = new File("Circular.jpg");
        ImageIcon img5 = new ImageIcon(Circular.toString());
        Icon icono5 = new ImageIcon(img5.getImage().getScaledInstance(img5.getIconWidth(), img5.getIconHeight(), Image.SCALE_DEFAULT));
        jLabel5.removeAll();
        jLabel5.setIcon(icono5);
        jLabel5.repaint();
        jLabel5.setIcon(icono5);

    }

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
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    public static javax.swing.JLabel jLabel1;
    public static javax.swing.JLabel jLabel2;
    public static javax.swing.JLabel jLabel3;
    public static javax.swing.JLabel jLabel4;
    public static javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables

    private class Hilo extends Thread{
   
        public void run(){
              System.out.println("------------------HILOOOOOOO");
        
                 while (true) {                     
                      File Matriz = new File("Matriz.jpg");
        ImageIcon img = new ImageIcon(Matriz.toString());
        Icon icono = new ImageIcon(img.getImage().getScaledInstance(img.getIconWidth(), img.getIconHeight(), Image.SCALE_DEFAULT));
        jLabel1.removeAll();
        jLabel1.setIcon(icono);
        jLabel1.repaint();
        jLabel1.setIcon(icono);
        File Cola = new File("Cola.jpg");
        ImageIcon img2 = new ImageIcon(Cola.toString());
        Icon icono2 = new ImageIcon(img2.getImage().getScaledInstance(img2.getIconWidth(), img2.getIconHeight(),Image.SCALE_DEFAULT ));
        jLabel2.removeAll();
        jLabel2.setIcon(icono2);
        jLabel2.repaint();
        jLabel2.setIcon(icono2);
        File Usuario = new File("Usuario.jpg");
        ImageIcon img3 = new ImageIcon(Usuario.toString());
        Icon icono3 = new ImageIcon(img3.getImage().getScaledInstance(img3.getIconWidth(), img3.getIconHeight(), Image.SCALE_DEFAULT));
        jLabel3.removeAll();
        jLabel3.setIcon(icono3);
        jLabel3.repaint();
        jLabel3.setIcon(icono3);
        File Diccionario = new File("Diccionario.jpg");
        ImageIcon img4 = new ImageIcon(Diccionario.toString());
        Icon icono4 = new ImageIcon(img4.getImage().getScaledInstance(img4.getIconWidth(), img4.getIconHeight(), Image.SCALE_DEFAULT));
        jLabel4.removeAll();
        jLabel4.setIcon(icono4);
        jLabel4.repaint();
        jLabel4.setIcon(icono4);
        File Circular = new File("Circular.jpg");
        ImageIcon img5 = new ImageIcon(Circular.toString());
        Icon icono5 = new ImageIcon(img5.getImage().getScaledInstance(img5.getIconWidth(), img5.getIconHeight(), Image.SCALE_DEFAULT));
        jLabel5.removeAll();
        jLabel5.setIcon(icono5);
        jLabel5.repaint();
        jLabel5.setIcon(icono5);
                     
                 }
               
             
        }
    
    }


}
