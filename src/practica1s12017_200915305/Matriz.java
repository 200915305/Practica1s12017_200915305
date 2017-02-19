
package practica1s12017_200915305;

import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Matriz {
    Graphviz A = new Graphviz();
    NodoMatriz primero_fila;
    NodoMatriz ultimo_fila;
    NodoMatriz primero_columna;
    NodoMatriz ultimo_columna;
    NodoMatriz temp1;
    NodoMatriz temp2;
    NodoMatriz raiz;

    public void sampar_matriz(String objeto, int ID, int opcion) {
        NodoMatriz nuevo = new NodoMatriz(objeto, ID);
        if (primero_fila == null && opcion == 0) {//opcion cero insertar el primer nodo
            nuevo.izquierda = null;
            nuevo.derecha = null;
            nuevo.abajo = null;
            nuevo.arriba = null;
            primero_fila = nuevo;
            ultimo_fila = nuevo;
            primero_columna = nuevo;
            ultimo_columna = nuevo;
            raiz = nuevo;
        } else if (opcion == 1) {//opcion uno insertar un nuevo nodo en la primera fila
            nuevo.derecha = ultimo_fila;
            nuevo.izquierda = null;
            nuevo.abajo = null;
            nuevo.arriba = null;
            ultimo_fila.izquierda = nuevo;
            ultimo_fila = nuevo;
        } else if (opcion == 2) {//opcion dos insertar un nuevo nodo en la columna
            nuevo.arriba = ultimo_columna;
            nuevo.izquierda = null;
            nuevo.derecha = null;
            nuevo.abajo = null;
            ultimo_columna.abajo = nuevo;
            primero_fila = nuevo;
            ultimo_fila = nuevo;
            ultimo_columna = nuevo;
            primero_columna = nuevo.arriba;
        } else if (opcion == 3) {//opcion tres insertar un nuevo nodo en las siguientes filas
            nuevo.derecha = ultimo_fila;
            nuevo.izquierda = null;
            nuevo.abajo = null;
            nuevo.arriba = primero_columna.izquierda;
            primero_columna.izquierda.abajo = nuevo;
            ultimo_fila.izquierda = nuevo;
            primero_columna = nuevo.arriba;
            ultimo_fila = nuevo;
        } else if (opcion == 4) {//opcion cuatro insertar un nuevo nodo en la ultima fila para crear una nueva columna
            temp1 = ultimo_fila;
            temp1.izquierda = nuevo;
            nuevo.derecha = temp1;
            nuevo.izquierda = null;
            nuevo.abajo = null;
            nuevo.arriba = null;
            ultimo_fila = nuevo;
            temp2 = ultimo_fila;
        } else if (opcion == 5) {// opcion cinco insertar un nuevo nodo en la nueva columna
            temp1 = temp1.arriba;
            temp1.izquierda = nuevo;
            temp2.arriba = nuevo;
            nuevo.derecha = temp1;
            nuevo.izquierda = null;
            nuevo.abajo = temp2;
            nuevo.arriba = null;
            temp2 = nuevo;
        }
    }

    public void reacomodar_indices() {
        int nuevo_indice = 0;
        NodoMatriz actual_columna = raiz;
        for (int j = 0; j < 1000; j++) {
            if (actual_columna != null) {
                NodoMatriz actual_fila = actual_columna;
                for (int i = 0; i < 1000; i++) {
                    if (actual_fila != null) {
                        actual_fila.ID = nuevo_indice;
                        nuevo_indice++;
                    } else {
                        break;
                    }
                    actual_fila = actual_fila.izquierda;
                }
            } else {
                break;
            }
            actual_columna = actual_columna.abajo;
        }
    }


    
    public void GraficarMatriz(){
  
        NodoMatriz actual_fila = raiz;
        NodoMatriz actual_columna;

        int contador1 = 1;

        File Arch = new File("Matriz.txt");
        Arch.delete();
        try {
            A.Guardar_Codigo_GRafo(Arch, "digraph G{ \nlabel = \"Matriz de Juego\";\n");
            int contador = 1;
            while (actual_fila != null) {
                A.Guardar_Codigo_GRafo(Arch, contador + " [shape=box,color=\"white\", label = \"\"];\n");
                contador++;
                A.Guardar_Codigo_GRafo(Arch, contador + " [shape=box,color=\"white\", label = \"\"];\n");
                contador++;
                actual_fila = actual_fila.izquierda;
            }
            actual_fila = raiz;
            while (actual_fila != null) {
                A.Guardar_Codigo_GRafo(Arch, contador + " [shape=box,color=\"white\", label = \"\"];\n");
                contador++;
                A.Guardar_Codigo_GRafo(Arch, contador + " [shape=box,color=\"white\", label = \"\"];\n");
                contador++;
                actual_fila = actual_fila.abajo;
            }

            actual_fila = raiz;
            actual_columna = null;

            while (actual_fila != null) {
                A.Guardar_Codigo_GRafo(Arch, "\nNodo"
                        + actual_fila.ID
                        + " [shape=box,color=\"blue\", label = \""
                        + actual_fila.objeto + "\n"
                        + actual_fila.ID + "\"];");
                actual_columna = actual_fila.izquierda;
                while (actual_columna != null) {
                    A.Guardar_Codigo_GRafo(Arch, "\nNodo"
                            + actual_columna.ID
                            + " [shape=box,color=\"blue\", label = \""
                            + actual_columna.objeto + "\n"
                            + actual_columna.ID + "\"];");

                    actual_columna = actual_columna.izquierda;
                }
                actual_fila = actual_fila.abajo;
            }

            A.Guardar_Codigo_GRafo(Arch, "\n\n{rank = same;");
            actual_fila = raiz;

            while (actual_fila != null) {
                A.Guardar_Codigo_GRafo(Arch, "\"" + contador1 + "\";");
                contador1++;
                actual_fila = actual_fila.izquierda;
            }
            A.Guardar_Codigo_GRafo(Arch, "}");

            actual_fila = raiz;
            while (actual_fila != null) {
                A.Guardar_Codigo_GRafo(Arch, "\n{rank = same;\"" + contador1 + "\";");
                contador1++;
                A.Guardar_Codigo_GRafo(Arch, "\"Nodo" + actual_fila.ID + "\";");
                actual_columna = actual_fila.izquierda;
                while (actual_columna != null) {
                    A.Guardar_Codigo_GRafo(Arch, "\"Nodo" + actual_columna.ID + "\";");
                    actual_columna = actual_columna.izquierda;
                }
                A.Guardar_Codigo_GRafo(Arch, "\"" + contador1 + "\";}");
                contador1++;
                actual_fila = actual_fila.abajo;
            }

            A.Guardar_Codigo_GRafo(Arch, "\n{rank = same;");
            actual_fila = raiz;

            while (actual_fila != null) {
                A.Guardar_Codigo_GRafo(Arch, "\"" + contador1 + "\";");
                contador1++;
                actual_fila = actual_fila.izquierda;
            }
            A.Guardar_Codigo_GRafo(Arch, "}\n\n");

            actual_fila = raiz;
            actual_columna = null;
            while (actual_fila != null) {
                if (actual_fila.abajo != null) {
                    A.Guardar_Codigo_GRafo(Arch, "Nodo" + actual_fila.ID + "-> Nodo" + actual_fila.izquierda.ID + ";\n");
                    A.Guardar_Codigo_GRafo(Arch, "Nodo" + actual_fila.izquierda.ID + "-> Nodo" + actual_fila.ID + ";\n");
                    A.Guardar_Codigo_GRafo(Arch, "Nodo" + actual_fila.ID + "-> Nodo" + actual_fila.abajo.ID + ";\n");
                    A.Guardar_Codigo_GRafo(Arch, "Nodo" + actual_fila.abajo.ID + "-> Nodo" + actual_fila.ID + ";\n\n");
                } else {
                    A.Guardar_Codigo_GRafo(Arch, "Nodo" + actual_fila.ID + "-> Nodo" + actual_fila.izquierda.ID + ";\n");
                    A.Guardar_Codigo_GRafo(Arch, "Nodo" + actual_fila.izquierda.ID + "-> Nodo" + actual_fila.ID + ";\n\n");
                }
                actual_columna = actual_fila.izquierda;
                while (actual_columna != null) {
                    if (actual_columna.izquierda != null && actual_columna.abajo != null) {
                        A.Guardar_Codigo_GRafo(Arch, "Nodo" + actual_columna.ID + "-> Nodo" + actual_columna.izquierda.ID + ";\n");
                        A.Guardar_Codigo_GRafo(Arch, "Nodo" + actual_columna.izquierda.ID + "-> Nodo" + actual_columna.ID + ";\n");
                        A.Guardar_Codigo_GRafo(Arch, "Nodo" + actual_columna.ID + "-> Nodo" + actual_columna.abajo.ID + ";\n");
                        A.Guardar_Codigo_GRafo(Arch, "Nodo" + actual_columna.abajo.ID + "-> Nodo" + actual_columna.ID + ";\n\n");
                    } else if (actual_columna.izquierda == null && actual_columna.abajo != null) {
                        A.Guardar_Codigo_GRafo(Arch, "Nodo" + actual_columna.ID + "-> Nodo" + actual_columna.abajo.ID + ";\n");
                        A.Guardar_Codigo_GRafo(Arch, "Nodo" + actual_columna.abajo.ID + "-> Nodo" + actual_columna.ID + ";\n\n");
                    } else if (actual_columna.izquierda != null && actual_columna.abajo == null) {
                        A.Guardar_Codigo_GRafo(Arch, "Nodo" + actual_columna.ID + "-> Nodo" + actual_columna.izquierda.ID + ";\n");
                        A.Guardar_Codigo_GRafo(Arch, "Nodo" + actual_columna.izquierda.ID + "-> Nodo" + actual_columna.ID + ";\n");
                    }
                    actual_columna = actual_columna.izquierda;
                }
                actual_fila = actual_fila.abajo;
            }

            actual_fila = raiz;
            actual_columna = null;
            int contador2 = 1;
            while (actual_fila != null) {
                if (actual_fila.izquierda != null) {
                    A.Guardar_Codigo_GRafo(Arch, contador2 + "->Nodo" + actual_fila.ID + "[color = red];\n");
                    A.Guardar_Codigo_GRafo(Arch, "Nodo" + actual_fila.ID + "->" + contador2 + ";\n");
                    contador2++;
                    actual_fila = actual_fila.izquierda;
                } else {
                    A.Guardar_Codigo_GRafo(Arch, contador2 + "->Nodo" + actual_fila.ID + "[color = red];\n");
                    A.Guardar_Codigo_GRafo(Arch, "Nodo" + actual_fila.ID + "->" + contador2 + ";\n");
                    contador2++;
                    int contador3 = contador2 + 1;
                    while (actual_fila != null) {
                        A.Guardar_Codigo_GRafo(Arch, contador3 + "->Nodo" + actual_fila.ID + "[color = red];\n");
                        A.Guardar_Codigo_GRafo(Arch, "Nodo" + actual_fila.ID + "->" + contador3 + ";\n");
                        actual_fila = actual_fila.abajo;
                        if (actual_fila != null) {
                            A.Guardar_Codigo_GRafo(Arch, contador3 + "->");
                            contador3 = contador3 + 2;
                            A.Guardar_Codigo_GRafo(Arch, contador3 + "[color = red];\n");
                        }
                    }
                }
            }

            A.Guardar_Codigo_GRafo(Arch, "1->" + contador2 + "[color = red];\n");

            actual_fila = raiz;
            while (actual_fila != null) {
                A.Guardar_Codigo_GRafo(Arch, contador2 + "->Nodo" + actual_fila.ID + "[color = red];\n");
                A.Guardar_Codigo_GRafo(Arch, "Nodo" + actual_fila.ID + "->" + contador2 + ";\n");
                actual_columna = actual_fila;
                actual_fila = actual_fila.abajo;
                if (actual_fila != null) {
                    A.Guardar_Codigo_GRafo(Arch, contador2 + "->");
                    contador2 = contador2 + 2;
                    A.Guardar_Codigo_GRafo(Arch, contador2 + "[color = red];\n");
                } else {
                    contador2 = contador2 + 2;
                    while (actual_columna != null) {
                        A.Guardar_Codigo_GRafo(Arch, contador2 + "->Nodo" + actual_columna.ID + "[color = red];\n");
                        A.Guardar_Codigo_GRafo(Arch, "Nodo" + actual_columna.ID + "->" + contador2 + ";\n");
                        contador2++;
                        actual_columna = actual_columna.izquierda;
                    }
                }
            }

            A.Guardar_Codigo_GRafo(Arch, "\n}");
        } catch (IOException ex) {
        }
        A.Generar_Imagen_automata(
                "C:\\Program Files (x86)\\Graphviz2.38\\bin\\dot.exe", "Matriz.txt", "Matriz.jpg");
    
    }

    public void modificar(int donde, String contenido) {
        NodoMatriz actual_columna = raiz;
        for (int j = 1; j < 1000 + 1; j++) {
            NodoMatriz actual_fila = actual_columna;
            for (int i = 1; i < 1000 + 1; i++) {
                if (actual_fila.ID == donde) {
                    System.out.println("\nEncontrado: " + actual_fila.objeto);
                    actual_fila.objeto = contenido;
                }
                actual_fila = actual_fila.izquierda;
                if (actual_fila == null) {
                    break;
                }
            }
            actual_columna = actual_columna.abajo;
            if (actual_columna == null) {
                break;
            }
        }
    }

    public void eliminar_matriz() {
        raiz = null;
        primero_fila = null;
        ultimo_fila = null;
        primero_columna = null;
        ultimo_columna = null;
        System.gc();
    }




}


