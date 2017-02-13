
package practica1s12017_200915305;

import java.util.ArrayList;

/**
 *
 * @author ubuntu
 */
public class Letras {
    
    public static Cola cola = new Cola();

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
   // System.out.print((k+1)+".- "+arreglo[k]+"\n");
    
    int a = arreglo[k];
    String b = lista.get(a);
    char c[]=b.toCharArray();
    
    cola.AgregarCola(c[0]);
    
}
        
        
    }
    
    
    
}
