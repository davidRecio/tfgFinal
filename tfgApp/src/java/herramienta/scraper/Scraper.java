/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package herramienta.scraper;

import java.io.IOException;
import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
/**
 *
 * @author david
 */
public class Scraper {
    
    
       public String obtenerTitulo(String http){
         
         try {
       // Here we create a document object and use JSoup to fetch the website
       Document doc = Jsoup.connect(http).get();

       // With the document fetched, we use JSoup's title() method to fetch the title
      return "Title: "+ doc.title();

     // In case of any IO errors, we want the messages written to the console
     } catch (IOException e) {
      return e.toString();
     }
      
         
         }   
    
}
