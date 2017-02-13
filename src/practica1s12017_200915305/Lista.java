
package practica1s12017_200915305;

/**
 *
 * @author ubuntu
 */
public class Lista {
    NodoLista primerol;
    NodoLista ultimol;
    
    
    public void AgregarLista(char a, int b){
    
        
      NodoLista nuevol = new NodoLista(a, 0);
           
      if(primerol==null){
          nuevol.sig=primerol;
          primerol=nuevol;
          ultimol=nuevol;
          
                                      
                       
                     
               
                   
     
      }else{
          ultimol.sig=nuevol;
          ultimol=nuevol;
      
                      
      }
    
    }
    
}
