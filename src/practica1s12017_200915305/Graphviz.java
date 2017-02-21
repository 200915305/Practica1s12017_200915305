package practica1s12017_200915305;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Graphviz {
   
    public  boolean Guardar_Codigo_GRafo(File F , String Cod_Graf) throws IOException {
       try {
           FileWriter Archivo = new FileWriter((F),true);
           if (!F.exists()) {F.createNewFile();}
           
           Archivo.write( Cod_Graf   );
           Archivo.flush();
           Archivo.close();
           return true;
       }
       catch (IOException e){
           return false; 
       }
   
    }
    
    public void Generar_Imagen_automata(String Ruta_Graphviz,String Nombre_Archivo_Grafo,String Nombre_Imagen_grafo)
    {
       try {
      

      
      String Parametro1 = "-Tjpg";
      String Parametro2 = "-o";
        
      String[] cmd = new String[5];
      cmd[0] = Ruta_Graphviz;
      cmd[1] = Parametro1;
      cmd[2] = Nombre_Archivo_Grafo;
      cmd[3] = Parametro2;
      cmd[4] = Nombre_Imagen_grafo;
                  
      Runtime rt = Runtime.getRuntime();
      
      rt.exec( cmd );
      
    } catch (Exception ex) {
    } finally {
    }
 
    }
    
    
    
}