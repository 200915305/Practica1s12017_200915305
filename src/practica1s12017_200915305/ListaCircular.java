
package practica1s12017_200915305;

import java.util.Scanner;
import javax.swing.JOptionPane;
import practica1s12017_200915305.Cola;



/**
 *
 * @author ubuntu
 */
public  class ListaCircular {
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
        
    }
   
   
}
