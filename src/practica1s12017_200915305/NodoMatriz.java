

package practica1s12017_200915305;


public class NodoMatriz {
    String objeto;
    int ID;
    NodoMatriz derecha;
    NodoMatriz izquierda;
    NodoMatriz arriba;
    NodoMatriz abajo;
    public NodoMatriz (String objeto, int ID){
        this.objeto = objeto;
        this.ID = ID;
        derecha = null;
        izquierda  = null;
        arriba = null;
        abajo  = null;
    }
    
}
