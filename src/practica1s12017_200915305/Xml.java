
package practica1s12017_200915305;

import java.io.File;
import java.io.IOException;
import java.util.List;
import org.jdom.Document;			
import org.jdom.Element;			
import org.jdom.JDOMException;		
import org.jdom.input.SAXBuilder;

public class Xml {
    
    ListaDiccionario diccionario =new ListaDiccionario();
   public static Panel panel = new Panel();
   public Xml(){
   
   }
   
   public void cargarXml(String path)
	{ 
		//Se crea un SAXBuilder para poder parsear el archivo
		SAXBuilder builder = new SAXBuilder();
		File xmlFile = new File( path);
		try
		{
			//Se crea el documento a traves del archivo
			Document document = (Document) builder.build( xmlFile );

			//Se obtiene la raiz 'tables'
			Element rootNode = document.getRootElement();
                        
                        String dimension = rootNode.getChildTextTrim("dimension");  
			System.out.println( "Dimension=> "+dimension);	 
                        practica1s12017_200915305.Tablero.dimension = dimension;//Dimension de Tablero
                        
                        List lista_dobles = rootNode.getChildren("dobles");
                        System.out.println("Dobles.............");
                        for(int i=0;i<lista_dobles.size();i++){
                            Element tabla =(Element)lista_dobles.get(i);
                            List casilla = tabla.getChildren();
                             
                             
                             for(int j=0;j<casilla.size();j++){
                                 Element d = (Element)casilla.get(j);
                             String x = d.getChildTextTrim("x");
                             String Y = d.getChildTextTrim("y");
                             practica1s12017_200915305.Tablero.listaDoblex.add(x);
                             practica1s12017_200915305.Tablero.listaDobley.add(Y);
                             System.out.println("X=>"+x+"Y=>"+Y);
                             }
                       
                             
                        }
                        
                        List lista_triples = rootNode.getChildren("triples");
                        System.out.println("-------------------------------"+lista_triples.size());
                        System.out.println("Triples.............");
                        for (int i = 0; i < lista_triples.size(); i++) {
                            Element tabla = (Element)lista_triples.get(i);
                            List casilla = tabla.getChildren();
                             
                             
                             for(int j=0;j<casilla.size();j++){
                                 Element d = (Element)casilla.get(j);
                             String x = d.getChildTextTrim("x");
                             String Y = d.getChildTextTrim("y");
                             practica1s12017_200915305.Tablero.listaTriplex.add(x);
                             practica1s12017_200915305.Tablero.listaTripley.add(Y);
                             System.out.println("X=>"+x+"Y=>"+Y);
                             }
                    }
                     
                        
                     List listar = rootNode.getChildren("diccionario");
                     for (int i = 0; i < listar.size(); i++) {
                        Element node = (Element)listar.get(i);
                        List l = node.getChildren("palabra");
                            for (int j = 0; j < l.size(); j++) {
                                Element n =(Element)l.get(j);
                                String x = n.getText();
                              //  practica1s12017_200915305.Tablero.listaDiccionario.add(x);
                                diccionario.AgregarDiccionario(x);
                          
                              //  System.out.println("Palabra=>  "+ n.getText());
                         }
                  
                    }
                   diccionario.MostrarDiccionario();
                   practica1s12017_200915305.Panel.boton=true;
                   
                   
		}catch ( IOException io ) {
			System.out.println( io.getMessage() );
		}catch ( JDOMException jdomex ) {
			System.out.println( jdomex.getMessage() );
		}
	}
    
}
