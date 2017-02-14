
package practica1s12017_200915305;

/**
 *
 * @author ubuntu
 */
public  class Cola {
   public static NodoCola primerocola;
   public static NodoCola ultimocola;
   public static int contarc=0;
    
    
    
     public static char AgregarCola(char letra){ /// Cambiaste el metodo por una funcion 
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
    
    
    }
    
    public char SacarCola(){
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
