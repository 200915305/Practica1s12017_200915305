
package practica1s12017_200915305;


public class ListaDiccionario {
    NodoDiccionario primeroD;
    NodoDiccionario ultimoD;
    int contarc;
    
    public void AgregarDiccionario(String palabra){
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
        
    
    }
    
    public void MostrarDiccionario(){
        NodoDiccionario temporal;
        temporal=primeroD;
        
        for (int i = 0; i < contarc; i++) {
            System.out.println("Diccionario.."+temporal.palabra);
            temporal=temporal.siguienteD;
        }
    
    }
    
    
}
