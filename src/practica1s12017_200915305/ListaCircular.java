
package practica1s12017_200915305;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import practica1s12017_200915305.Cola;




public  class ListaCircular {
     Graphviz A = new Graphviz();
   public  NodoCircular primeroc;
   public  NodoCircular ultimoc;
   public  NodoCircular temporal=primeroc;

  public  Cola cola =new Cola();
 
    int contarc;
    int dato=0;
    int repetido=0;
    int NoRepetido=0;
  
    
 public  void AgregarListaCircular(String usuario){
      NodoCircular nuevoc=new NodoCircular(usuario);
      NodoCircular temp=primeroc;
      
    
      
      if(primeroc==null){
          
          
          System.out.println("ENTRO");
          nuevoc.sig=primeroc;
          primeroc=nuevoc;
          ultimoc=nuevoc;
          
                       char a = cola.SacarCola();
                       NodoLista nuevol=new NodoLista(a);
                       ultimoc.primerol=nuevol;
                       ultimoc.ultimol=nuevol;
                       
                       for(int i=0;i<6;i++){
                           
                           char b = cola.SacarCola();
                           NodoLista nuevol2=new NodoLista(b);
         
                          
                           
                       primeroc.ultimol.sig=nuevol2;
                       primeroc.ultimol=nuevol2;
                       primeroc.ultimol.sig=null;
                       
                       }
                       
              
                     
                       
                       
           
                       
            contarc++;    
         
      }else{
           
          for (int i = 0; i <contarc; i++) {
              if (usuario.equals(temp.usuario)) {
                  repetido=1;
                  System.out.println("Repetido"+usuario+","+temp.usuario);
              }else{
                  System.out.println("No Repetido"+usuario+","+temp.usuario);
               
              }
             temp=temp.sig;
          }
          
          if (repetido==0) {
              ultimoc.sig=nuevoc;
          ultimoc=nuevoc;
                       char c = cola.SacarCola();
                         NodoLista nuevol3=new NodoLista(c);   
                         ultimoc.primerol=nuevol3;
                         ultimoc.ultimol=nuevol3;
                         
                      for(int i=0;i<6;i++){
                         char d = cola.SacarCola();
                         NodoLista nuevol4=new NodoLista(d); 
                       
                           
                       ultimoc.ultimol.sig=nuevol4;
                       ultimoc.ultimol=nuevol4;
                       ultimoc.ultimol.sig=null;
                       
                       }
                   
          contarc++;
          }else{
            JOptionPane.showMessageDialog(null, "Este Usuario ya se encuentra Registrado");
          }
          
          
          
      }
      
     repetido=0;
     
    }
 
  public void ImprimirListaCircular(){
        NodoCircular temporal;
        temporal = primeroc;
        
        NodoLista temp;
        
        int i;
        System.out.println("----Lista Circular--------------");
        for(i=0;i<contarc;i++){
            System.out.println(temporal.usuario+"\n");
            temp=temporal.primerol;
                while(temp!=null){
                    System.out.println("=> "+temp.Letra);
                    temp=temp.sig;
                
                }
                temporal=temporal.sig;
        }
        
        System.out.println("------------------");
        GraficarListaCircular();
        
    }
  
  public void GraficarListaCircular(){
        String nodos ="";
        String nodes ="";
      try {
             NodoCircular temporal;
             temporal = primeroc;
             
             NodoCircular temporal2;
             temporal2 = primeroc;
             
             NodoCircular temporal3;
             temporal3 = primeroc;
             
             NodoLista temp;
             NodoLista temp2;
             NodoLista temp3;
             
             
             File Arch = new File("Circular.txt");
             Arch.delete();
             A.Guardar_Codigo_GRafo(Arch, "digraph G{ \nlabel = \"Lista Circular\";\n");
            
             int i;
             int x=0;
            
             System.out.println("----Lista Circular--------------");
             for(i=0;i<contarc;i++){
                 nodos=nodos+"\"Nodo"+i+"\""+";";
                 A.Guardar_Codigo_GRafo(Arch, "\nNodo"
                 +i
                 + " [shape=box,style=filled,color=\".7 .3 1.0\", label = \"Usuario: "
                 + temporal.usuario + "\"];\n"); 
                
                 temp=temporal.primerol;
                 while(temp!=null){
                     
                     nodes=nodes+"\"Node"+temporal.usuario+x+"\""+";";
                     A.Guardar_Codigo_GRafo(Arch, "\nNode"
                     +temporal.usuario
                     +x
                     + " [shape=box,color=\"blue\", label = \"Letra: "
                     + temp.Letra + "\"];\n"); 
                    
                     temp=temp.sig;
                     x++;
                 }
                 temporal=temporal.sig;
                 x=0;
             }
             
                 for(i=0;i<contarc;i++){
                   int a =i+1;
                     A.Guardar_Codigo_GRafo(Arch, "\nNodo" +i);
                     if (a!=contarc) {
                        A.Guardar_Codigo_GRafo(Arch, " -> Nodo"+a+";\n"); 
                     } else {
                          A.Guardar_Codigo_GRafo(Arch, " -> Nodo"+0+";\n");
                     }
             
                
                 temp2=temporal2.primerol;
                 while(temp2!=null){
                   int b =x+1;
                   A.Guardar_Codigo_GRafo(Arch, "\nNode" +temporal2.usuario+x 
                   +" -> Node"+temporal2.usuario+b+";\n");
                    
                     temp2=temp2.sig;
                     x++;
                 }
                 temporal2=temporal2.sig;
                 x=0;
             }
                 
                 for (int j = 0; j <contarc; j++) {
                    
                     A.Guardar_Codigo_GRafo(Arch, "\nNodo" +j); 
                     temp3=temporal3.primerol;
                     A.Guardar_Codigo_GRafo(Arch, " -> Node"+temporal3.usuario+0+";\n");
                     temporal3=temporal3.sig;
                }
             
                  A.Guardar_Codigo_GRafo(Arch, "{ rank = same;"+nodos+nodes+"}");
                  A.Guardar_Codigo_GRafo(Arch, "}\n");
             
             
             
             System.out.println("------------------");
         } catch (IOException ex) {
             Logger.getLogger(ListaCircular.class.getName()).log(Level.SEVERE, null, ex);
         }
        A.Generar_Imagen_automata("C:\\Program Files (x86)\\Graphviz2.38\\bin\\dot.exe", "Circular.txt", "Circular.jpg");
    
  }
   
  public void ImprimirUsuario(String Usuario){
      String nodos ="";
      String nodes ="";
      
         try {
             NodoCircular temporal;
             temporal = primeroc;  
             NodoCircular temporal2;
             temporal2 = primeroc;  
             NodoLista temp;
             NodoLista temp2;
             File Arch = new File("Usuario.txt");
             Arch.delete();
             A.Guardar_Codigo_GRafo(Arch, "digraph G{ \nlabel = \"Usuario\";\n");
             int i;
             System.out.println("----Lista Circular--------------"+Usuario);
             for(i=0;i<contarc;i++){
                 if(temporal.usuario.equals(Usuario)){                     
                     System.out.println("Si Existe");
                      
                 nodos=nodos+"\"Nodo"+i+"\""+";";
                 A.Guardar_Codigo_GRafo(Arch, "\nNodo"
                 +i
                 + " [shape=box,style=filled,color=\".7 .3 1.0\", label = \"Usuario: "
                 + temporal.usuario + "\"];\n"); 
                
                 temp=temporal.primerol;
                 int x=0;
                 while(temp!=null){
                     
                     nodes=nodes+"\"Node"+temporal.usuario+x+"\""+";";
                     A.Guardar_Codigo_GRafo(Arch, "\nNode"
                     +temporal.usuario
                     +x
                     + " [shape=box,color=\"blue\", label = \"Letra: "
                     + temp.Letra + "\"];\n");                   
                     temp=temp.sig;
                     x++;
               
                 }
                 temporal=temporal.sig;
                 x=0;   
                     
                 }else{
                     System.out.println("El Usuario no existe");
                     temporal=temporal.sig;
                 }
                
             }
             
             for(i=0;i<contarc;i++){
                 if(temporal2.usuario.equals(Usuario)){                     
                     System.out.println("Si Existe");
                      
                   A.Guardar_Codigo_GRafo(Arch, "\nNodo" +i 
                   +" -> Node"+temporal2.usuario+0+";\n");
                 int x=0;
                 temp2=temporal2.primerol;
                 while(temp2!=null){
                    int b=x+1;
                    A.Guardar_Codigo_GRafo(Arch, "\nNode" +temporal2.usuario+x
                   +" -> Node"+temporal2.usuario+b+";\n");
                  temp2=temp2.sig;
                  x++;
                 }
                 temporal2=temporal2.sig;
                 x=0;   
                     
                 }else{
                     System.out.println("El Usuario no existe");
                     temporal2=temporal2.sig;
                 }
                
             }
             
                  A.Guardar_Codigo_GRafo(Arch, "{ rank = same;"+nodos+nodes+"}");
                  A.Guardar_Codigo_GRafo(Arch, "}\n");
                  
             System.out.println("------------------");
             GraficarListaCircular();
         } catch (IOException ex) {
             Logger.getLogger(ListaCircular.class.getName()).log(Level.SEVERE, null, ex);
         }

         A.Generar_Imagen_automata("C:\\Program Files (x86)\\Graphviz2.38\\bin\\dot.exe", "Usuario.txt", "Usuario.jpg");
  }
   
}
