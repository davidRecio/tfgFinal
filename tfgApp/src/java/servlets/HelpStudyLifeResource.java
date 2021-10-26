/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import herramienta.scraper.Scraper;
import java.util.ArrayList;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;

/**
 * REST Web Service
 *
 * @author david
 */
@Path("HelpStudyLife")
public class HelpStudyLifeResource {

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of HelpStudyLifeResource
     */
    public HelpStudyLifeResource() {
    }

    /**
     * Retrieves representation of an instance of servlets.HelpStudyLifeResource
     * @return an instance of java.lang.String
     */
    
    
    
     @GET
    @Path("usuario/noticias")
    public String getNoticias() {
         String http ;
       Scraper scrp= new Scraper();

//       http= "https://www.comunidad.madrid/servicios/educacion/localizacion-universidades-madrilenas";
       http="https://www.descubremadrid.com/listado-completo-de-todas-las-universidades-publicas-y-privadas-en-madrid/#Universidades_Publicas_en_Madrid";
       
      ArrayList etiquetasElementos = new ArrayList();
        ArrayList tiposElementos = new ArrayList();
                ArrayList separadores= new ArrayList();
                ArrayList<ArrayList<String>> resultado= new ArrayList();
                 ArrayList<ArrayList<String>> profundidad= new ArrayList();
                 ArrayList<String> profundidadElemento1 = new ArrayList();
                 
//       etiquetasElementos.add("h3");
//       tiposElementos.add("tag");
//       separadores.add("Universidad");
//       
//        etiquetasElementos.add("li");
//       tiposElementos.add("tag");
//       separadores.add("Titulaciones");
//       
         etiquetasElementos.add("scr");
       tiposElementos.add("attr");
       separadores.add("<#>");
       //"div.navigation-branding"->
       profundidadElemento1.add("div.navigation-branding");
       profundidadElemento1.add("div.sticky-navigation-logo");
       profundidadElemento1.add("img.is-logo-image");
       
       profundidad.add(profundidadElemento1);
      resultado= scrp.obtenerTitulo(http,etiquetasElementos,tiposElementos,separadores,profundidad);
 
      return resultado.get(0).get(0);

    }
    @GET
    @Produces("application/xml")
    public String getXml() {
        //TODO return proper representation object
        throw new UnsupportedOperationException();
    }

    /**
     * PUT method for updating or creating an instance of HelpStudyLifeResource
     * @param content representation for the resource
     * @return an HTTP response with content of the updated or created resource.
     */
    @PUT
    @Consumes("application/xml")
    public void putXml(String content) {
    }
}
