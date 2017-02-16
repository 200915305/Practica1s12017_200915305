
package practica1s12017_200915305;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ListaDiccionario {
    Graphviz A = new Graphviz();
   public static NodoDiccionario primeroD;
   public static NodoDiccionario ultimoD;
   public static int contarc;
    
    public static String AgregarDiccionario(String palabra){
        NodoDiccionario nuevoD = new NodoDiccionario(palabra);
        
        if (primeroD==null) {
            nuevoD.siguienteD=primeroD;
            primeroD=nuevoD;
            ultimoD=nuevoD;
            contarc++;
        }else{
            ultimoD.siguienteD=nuevoD;
            ultimoD=nuevoD;
            contarc++;
        }
        
    return palabra;
    }
    
    public void MostrarDiccionario(){
        NodoDiccionario temporal;
        temporal=primeroD;
        
        for (int i = 0; i < contarc; i++) {
            System.out.println("Diccionario=>"+temporal.palabra);
            temporal=temporal.siguienteD;
        }
    
    }
    
   
     public void GraficarListaDiccionario(){
         String nodos ="";
        try {
            NodoDiccionario temporal;
            NodoDiccionario temporal2;

            temporal=primeroD;
            temporal2=primeroD;
            if(primeroD!=null){
            File Arch = new File("Diccionario.txt");
            Arch.delete();
            A.Guardar_Codigo_GRafo(Arch, "digraph G{ \nlabel = \"Diccionario\";\n");
          
            
            for (int i = 0; i < contarc; i++) {
                nodos=nodos+"\"Nodo"+i+"\""+";";
               A.Guardar_Codigo_GRafo(Arch, "\nNodo"
                 +i
                 + " [shape=box,color=\"blue\", label = \"Palabra: "
                 + temporal.palabra + "\"];\n"); 
                System.out.println("xxxxxxx."+temporal.palabra);
                temporal=temporal.siguienteD;
            }
            
            for (int i = 0; i < contarc; i++) {
                int a =i+1;
                A.Guardar_Codigo_GRafo(Arch, "\nNodo" +i 
                +" -> Nodo"+a+";\n");
                temporal2=temporal2.siguienteD;
            }
            
            A.Guardar_Codigo_GRafo(Arch, "{ rank = same;"+nodos+"}");
            A.Guardar_Codigo_GRafo(Arch, "}\n");
            }
        } catch (IOException ex) {
            Logger.getLogger(ListaDiccionario.class.getName()).log(Level.SEVERE, null, ex);
        }
         A.Generar_Imagen_automata("C:\\Program Files (x86)\\Graphviz2.38\\bin\\dot.exe", "Diccionario.txt", "Diccionario.jpg");
    
        
    }
    
    
    
}
