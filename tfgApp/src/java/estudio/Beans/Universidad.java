/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package estudio.Beans;

import java.util.ArrayList;

/**
 *
 * @author david
 */
public class Universidad {
    
    private String nombre;
    private ArrayList<String> oferta;
    private double precio;
    private String link;
    private String imagen;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public ArrayList<String> getOferta() {
        return oferta;
    }

    public void setOferta(ArrayList<String> oferta) {
        this.oferta = oferta;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
    
}
