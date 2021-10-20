/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herramienta.scraper;

import com.sun.xml.bind.v2.runtime.unmarshaller.XsiNilLoader;
import herramientas.HerramientasTrasformaciones;
import java.io.IOException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.jsoup.Connection.Response;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
/**
 *
 * @author david
 */
public class Scraper {
    
    /**
 * Con esta método compruebo el Status code de la respuesta que recibo al hacer la petición
 * EJM:
 * 		200 OK			300 Multiple Choices
 * 		301 Moved Permanently	305 Use Proxy
 * 		400 Bad Request		403 Forbidden
 * 		404 Not Found		500 Internal Server Error
 * 		502 Bad Gateway		503 Service Unavailable
 * @param url
 * @return Status Code
 */
    //ve como esta la conexion a la que se puede acceder
    public static int getStatusConnectionCode(String url) {
		
    Response response = null;
	
    try {
	response = Jsoup.connect(url).userAgent("Mozilla/5.0").timeout(100000).ignoreHttpErrors(true).execute();
    } catch (IOException ex) {
	System.out.println("Excepción al obtener el Status Code: " + ex.getMessage());
    }
    return response.statusCode();
}
    
    /**
 * Con este método devuelvo un objeto de la clase Document con el contenido del
 * HTML de la web que me permitirá parsearlo con los métodos de la librelia JSoup
 * @param url
 * @return Documento con el HTML
 */
public static Document getHtmlDocument(String url) {

    Document doc = null;
	try {
	    doc = Jsoup.connect(url).userAgent("Mozilla/5.0").timeout(100000).get();
	    } catch (IOException ex) {
		System.out.println("Excepción al obtener el HTML de la página" + ex.getMessage());
	    }
    return doc;
}
       public ArrayList<ArrayList <String>> obtenerTitulo(String http,ArrayList<String> etiquetasElementos,ArrayList<String> tiposElementos, ArrayList<String>separadores){
        ArrayList <ArrayList <String>> elementos = new ArrayList();
        String elementoData = "nada";
      HerramientasTrasformaciones hT = new HerramientasTrasformaciones();
     
        
        //automatizar los select
      
        if (getStatusConnectionCode(http) == 200) {
			
            // Obtengo el HTML de la web en un objeto Document
            Document document = getHtmlDocument(http);
			
            // Busco todas las entradas que estan dentro de: 
            //String selection="div.entry-content";
//             Elements entradas =   document.select(selection);
            String selection="div.navigation-branding";
            Elements entradas =   document.select(selection).select("div.sticky-navigation-logo").select("img.is-logo-image");
         String imageSRC = entradas.get(1).attr("src");
            System.out.println("src= "+imageSRC);
            System.out.println("Número de entradas en la página: "+entradas.size()+"\n");
            
            // Paseo cada una de las entradas
            
              for(  int i=0; i<etiquetasElementos.size(); i++){
              
               for (Element elem : entradas) {
                // Con el método "text()" obtengo el contenido que hay dentro de las etiquetas HTML
                // Con el método "toString()" obtengo todo el HTML con etiquetas incluidas
                 switch(tiposElementos.get(i).toString()){
                 
                     case "tag":{
                            System.out.println(etiquetasElementos.get(i));
                         elementoData =  elem.getElementsByTag(etiquetasElementos.get(i)).text();
                                  System.out.println(elementoData);
                     break;
                     }
                       case "class":{
                         System.out.println(etiquetasElementos.get(i));
                         elementoData =  elem.getElementsByClass(etiquetasElementos.get(i)).text();
                            System.out.println("aa"+elementoData);       
                     break;
                     }
                  
                 }
                 
                    }
                    
                    if(separadores.size()>0){
                      
//                   System.out.println(elementoData.split(separadores.get(i).toString())[1]);
                        ArrayList<String> aux = new ArrayList();
                        aux=hT.ArrayToArrayList(elementoData.split(separadores.get(i)));
                        
                    elementos.add(aux);
             
      
         
                      
                    }
                       
              }
        
        }else{
            System.out.println("El Status Code no es OK es: "+getStatusConnectionCode(http));
            ArrayList error = new ArrayList();
            error.add("El Status Code no es OK es: "+getStatusConnectionCode(http));
        return error;
    
         } 
         
        return elementos;
       }
}
		


        
    /*    
//         
//         try {
//       // Here we create a document object and use JSoup to fetch the website
//       Document doc = Jsoup.connect(http).get();
//
//       // With the document fetched, we use JSoup's title() method to fetch the title
//      return "Title: "+ doc.title();
//
//     // In case of any IO errors, we want the messages written to the console
//     } catch (IOException e) {
//      return e.toString();
//     }
      
           // Compruebo si me da un 200 al hacer la petición
        if (getStatusConnectionCode(http) == 200) {
			
            // Obtengo el HTML de la web en un objeto Document
            Document document = getHtmlDocument(http);
			
            // Busco todas las entradas que estan dentro de: 
            //Elements entradas = document.select("div.panel-panel col-md-9 col-xs-12 lastUnit col-content col-right").not("div.col-md-offset-2.panel-panel col-md-9 col-xs-12 lastUnit col-content col-right");
         Elements entradas =   document.select("div.entry-content");
         
            System.out.println("Número de entradas en la página inicial de Jarroba: "+entradas.size()+"\n");
		String titulo="nada";	
            // Paseo cada una de las entradas
            for (Element elem : entradas) {
                // titulo = elem.getElementsByClass("h3").text();
                 titulo =  elem.getElementsByTag("h3").text();
//                String titulo = elem.getElementsByClass("tituloPost").text();
//                String autor = elem.getElementsByClass("autor").toString();
//                String fecha = elem.getElementsByClass("fecha").text();
				
//                System.out.println(titulo+"\n"+autor+"\n"+fecha+"\n\n");
				
                // Con el método "text()" obtengo el contenido que hay dentro de las etiquetas HTML
                // Con el método "toString()" obtengo todo el HTML con etiquetas incluidas
            }
		//return "entradas:"+entradas.size();	
            return "entradas:"+titulo;
        }else
            System.out.println("El Status Code no es OK es: "+getStatusConnectionCode(http));
        return getStatusConnectionCode(http)+"";
    
         }   
 */
        
        
