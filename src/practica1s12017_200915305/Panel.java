
package practica1s12017_200915305;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;


/**
 *
 * @author ubuntu
 */
public class Panel extends javax.swing.JFrame {

    public static ListaCircular listac = new ListaCircular();
    public static ListaDiccionario listaDiccionario =new ListaDiccionario();
    public static Cola cola =new Cola();
    public static Letras letras =new Letras();
    public static boolean boton =false;
    
    
    public Panel() {
        initComponents();
        
    
      
       
    }

  
     
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jTextField1 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jButton1.setText("Agregar Usuario");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Mostrar Lista Circular ");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Agregar Cola");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jButton4.setText("Mostrar Cola");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setText("Quitar Cola");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setText("Cargar Archivo");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setText("Jugar");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setText("Graficar Diccionario");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        jButton9.setText("Graficar Usuario");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton6)
                        .addGap(18, 18, 18)
                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(32, 32, 32))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton5)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(91, Short.MAX_VALUE)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton9)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton8)
                    .addComponent(jButton1)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(71, 71, 71)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton8)
                    .addComponent(jButton9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton5)
                    .addComponent(jButton4)
                    .addComponent(jButton3))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // Agregar Usuario...
        
        String nombre = jTextField1.getText();
        listac.AgregarListaCircular(nombre);
     
        
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // Mostrar Lista Circuar...

           listac.ImprimirListaCircular();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // Agregar A Cola
         String nombre = jTextField1.getText();
         
         practica1s12017_200915305.Cola.AgregarCola(nombre);
        // Letras();
     
       
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // Mostrar Cola 
        cola.MostrarCola();
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        cola.SacarCola();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // Cargar Archivo... 
       // boton(true);
        Xml xml = new Xml();
        JFileChooser filechooserabrir = new JFileChooser();
        filechooserabrir.setFileSelectionMode( JFileChooser.FILES_ONLY );
        FileNameExtensionFilter filtro = new FileNameExtensionFilter("Archivos de Texto (*.xml)", "xml");
        filechooserabrir.setFileFilter(filtro);
        
        int seleccion = filechooserabrir.showOpenDialog(this);
        if(seleccion == JFileChooser.APPROVE_OPTION )
        {       
            try {
                BufferedReader bufferreader;                 
                File file = filechooserabrir.getSelectedFile();
                bufferreader = new BufferedReader(new FileReader(file.getAbsolutePath()));  
                System.out.println("NOmbre...."+file.getAbsolutePath().toString());
                xml.cargarXml(file.getAbsolutePath().toString());
                      
                bufferreader.close();
            } 
            catch (IOException ex) 
            {System.out.println("El Archivo no se pudo Cargar....");}
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        // TODO add your handling code here:
        Practica1s12017_200915305 inicio = new  Practica1s12017_200915305();
        Panel panel =  new Panel();
        Usuarios usuario = new Usuarios();
        if (boton==true) {
            usuario.setVisible(true);
            this.setVisible(false);
        } else {
            usuario.setVisible(false);
            JOptionPane.showMessageDialog(null, "No se a cargado ningun <<Archivo.xml>>");
        }
        
        
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        // Graficar Diccionario
      listaDiccionario.GraficarListaDiccionario();
      
        
        
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        // Grafiar un Usuario en Especifico......
        String Usuario=jTextField1.getText();
        listac.ImprimirUsuario(Usuario);
    }//GEN-LAST:event_jButton9ActionPerformed

    
    
    public void Letras() {
        
        ArrayList<String> lista =new ArrayList<String>();
        lista.add("A");
        lista.add("A");
        lista.add("A");
        lista.add("A");
        lista.add("A");
        lista.add("A");
        lista.add("A");
        lista.add("A");
        lista.add("A");
        lista.add("A");
        lista.add("A");
        lista.add("A");    
        lista.add("B");
        lista.add("B");
        lista.add("C");
        lista.add("C");
        lista.add("C");
        lista.add("C");
        lista.add("D");
        lista.add("D");
        lista.add("D");
        lista.add("D");
        lista.add("D");
        lista.add("E");
        lista.add("E");
        lista.add("E");
        lista.add("E");
        lista.add("E");
        lista.add("E");
        lista.add("E");
        lista.add("E");
        lista.add("E");
        lista.add("E");
        lista.add("E");
        lista.add("E");
        lista.add("F");
        lista.add("G");
        lista.add("G");
        lista.add("H");
        lista.add("H");
        lista.add("I");
        lista.add("I");
        lista.add("I");
        lista.add("I");
        lista.add("I");
        lista.add("I");
        lista.add("J");
        lista.add("L");
        lista.add("L");
        lista.add("L");
        lista.add("L");
        lista.add("M");
        lista.add("M");
        lista.add("N");
        lista.add("N");
        lista.add("N");
        lista.add("N");
        lista.add("N");
        lista.add("Ñ");
        lista.add("O");
        lista.add("O");
        lista.add("O");
        lista.add("O");
        lista.add("O");
        lista.add("O");
        lista.add("O");
        lista.add("O");
        lista.add("O");
        lista.add("P");
        lista.add("P");
        lista.add("Q");
        lista.add("R");
        lista.add("R");
        lista.add("R");
        lista.add("R");
        lista.add("R");
        lista.add("S");
        lista.add("S");
        lista.add("S");
        lista.add("S");
        lista.add("S");
        lista.add("S");
        lista.add("T");
        lista.add("T");
        lista.add("T");
        lista.add("T");
        lista.add("U");
        lista.add("U");
        lista.add("U");
        lista.add("U");
        lista.add("U");
        lista.add("V");
        lista.add("X");
        lista.add("Y");
        lista.add("Z");
        
       
        int i=0, cantidad=95, rango=95;
int arreglo[] = new int[cantidad];

arreglo[i]=(int)(Math.random()*rango);
for(i=1; i<cantidad; i++){
    arreglo[i]=(int)(Math.random()*rango);
    for(int j=0; j<i; j++){
        if(arreglo[i]==arreglo[j]){
            i--;
        }
    }
}

for(int k=0; k<cantidad; k++){
    System.out.print((k+1)+".- "+arreglo[k]+"\n");
    
    int a = arreglo[k];
    String b = lista.get(a);
    
    
    cola.AgregarCola(b);
    
}
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
            java.util.logging.Logger.getLogger(Panel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Panel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Panel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Panel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Panel().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    public javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JTextField jTextField1;
    // End of variables declaration//GEN-END:variables
}
