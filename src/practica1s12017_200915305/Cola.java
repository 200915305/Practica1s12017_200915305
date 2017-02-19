
package practica1s12017_200915305;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


/**
 *
 * @author ubuntu
 */
public  class Cola {
     Graphviz A = new Graphviz();
   public static NodoCola primerocola;
   public static NodoCola ultimocola;
   public static int contarc=0;
    
    
    
     public static String AgregarCola(String letra){ /// Cambiaste el metodo por una funcion 
        NodoCola nuevocola =new NodoCola(letra); /// para utilizar el satatic....
        
        if(primerocola==null){
            nuevocola.sigcola=primerocola;
            primerocola=nuevocola;
            ultimocola=nuevocola;
            contarc++;
        }else{
                nuevocola.sigcola=primerocola;  
                primerocola=nuevocola;  
            contarc++;
        }
        
    return letra;
    }
    
    
    public void MostrarCola(){
        NodoCola temporal=primerocola;
        System.out.println("Imprimir Cola... ");
        
        for(int i=0;i<contarc;i++){
            System.out.println("=>"+temporal.letra);
            temporal=temporal.sigcola;
        }
    
    GraficarCola();
    }
    
    public void GraficarCola(){
         String nodos ="";
        try {
            NodoCola temporal;
            NodoCola temporal2;

            temporal=primerocola;
            temporal2=primerocola;
            if(primerocola!=null){
            File Arch = new File("Cola.txt");
            Arch.delete();
            A.Guardar_Codigo_GRafo(Arch, "digraph G{ \nlabel = \"Cola\";\n");
          
            
            for (int i = 0; i < contarc; i++) {
                nodos=nodos+"\"Nodo"+i+"\""+";";
               A.Guardar_Codigo_GRafo(Arch, "\nNodo"
                 +i
                 + " [shape=box,color=\"blue\", label = \"Palabra: "
                 + temporal.letra + "\"];\n"); 
               // System.out.println("xxxxxxx."+temporal.letra);
                temporal=temporal.sigcola;
            }
            
            for (int i = 0; i < contarc; i++) {
                int a =i+1;
                A.Guardar_Codigo_GRafo(Arch, "\nNodo" +i 
                +" -> Nodo"+a+";\n");
                temporal2=temporal2.sigcola;
            }
            
            A.Guardar_Codigo_GRafo(Arch, "{ rank = same;"+nodos+"}");
            A.Guardar_Codigo_GRafo(Arch, "}\n");
            }
        } catch (IOException ex) {
            Logger.getLogger(ListaDiccionario.class.getName()).log(Level.SEVERE, null, ex);
        }
         A.Generar_Imagen_automata("C:\\Program Files (x86)\\Graphviz2.38\\bin\\dot.exe", "Cola.txt", "Cola.jpg");
        
    
    
    }
    
    public  String SacarCola(){
        NodoCola temporal=primerocola;
        NodoCola actual= temporal;
        NodoCola aux=primerocola;
        
       
      
        while (temporal.sigcola!=null) {            
            actual=temporal;
            temporal=temporal.sigcola;
            
        }
        System.out.println("Desencolar..."+actual.sigcola.letra);
        actual.sigcola=null;
        contarc--;
    
     
        return temporal.letra;
    
    }
    
      
}
