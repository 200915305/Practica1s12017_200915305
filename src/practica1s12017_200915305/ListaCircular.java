
package practica1s12017_200915305;

import java.util.Scanner;
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
  
    
 public  void AgregarListaCircular(String usuario){
      NodoCircular nuevoc=new NodoCircular(usuario);
      
     int num1 = 97;
     int num2 = 122;
      
    
      
      if(primeroc==null){
          
          
          System.out.println("ENTRO");
          nuevoc.sig=primeroc;
          primeroc=nuevoc;
          ultimoc=nuevoc;
          
                       int numAleatorio1 = (int)Math.floor(Math.random()*(num2 -num1)+num1);
                       char a=(char)numAleatorio1;
                       NodoLista nuevol=new NodoLista(a, 0);
                       ultimoc.primerol=nuevol;
                       ultimoc.ultimol=nuevol;
                       
                       for(int i=0;i<6;i++){
                           int numAleatorio2 = (int)Math.floor(Math.random()*(num2 -num1)+num1);
                           char b=(char)numAleatorio2;
                           NodoLista nuevol2=new NodoLista(b, dato);
                           practica1s12017_200915305.Cola.AgregarCola(b);////// Te quedaste Aqui....
                          
                           
                       primeroc.ultimol.sig=nuevol2;
                       primeroc.ultimol=nuevol2;
                       primeroc.ultimol.sig=null;
                       
                       }
                       
              
                     
                       
                       
           
                       
            contarc++;    
         
      }else{
          System.out.println("ENTRO");
          ultimoc.sig=nuevoc;
          ultimoc=nuevoc;
                         int numAleatorio3 = (int)Math.floor(Math.random()*(num2 -num1)+num1);
                         char c=(char)numAleatorio3;
                         NodoLista nuevol3=new NodoLista(c, dato);   
                         ultimoc.primerol=nuevol3;
                         ultimoc.ultimol=nuevol3;
                         
                      for(int i=0;i<6;i++){
                         int numAleatorio4 = (int)Math.floor(Math.random()*(num2 -num1)+num1);
                         char d=(char)numAleatorio4;
                         NodoLista nuevol4=new NodoLista(d, dato); 
                       
                           
                       ultimoc.ultimol.sig=nuevol4;
                       ultimoc.ultimol=nuevol4;
                       ultimoc.ultimol.sig=null;
                       
                       }
                   
          contarc++;
      }
      
     
     
    }


 public void ImprimirListaCircular(){
        NodoCircular temporal;
        temporal = primeroc;
        
        NodoLista temp;
        
        int i;
        System.out.println("------------------");
        for(i=0;i<contarc;i++){
            System.out.println(temporal.usuario+"\n");
            temp=temporal.primerol;
                while(temp!=null){
                    System.out.println("=> "+temp.Letra+","+temp.puntos);
                    temp=temp.sig;
                
                }
                temporal=temporal.sig;
        }
        
        System.out.println("------------------");
        
    }
   
   
}
