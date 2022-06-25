package Beans;


import java.util.ArrayList;

public class Usuario extends RecursoWeb{

    private String nombre;
    private String pass;
    private String aptitudes;
    private String intereses;
    private String nivelConcentracion;



    public Usuario(){
        super();
    }

    public Usuario(String nombre, String pass, String aptitudes, String intereses, String nivelConcentracion) {
        this.nombre = nombre;
        this.pass = pass;
        this.aptitudes = aptitudes;
        this.intereses = intereses;
        this.nivelConcentracion = nivelConcentracion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getAptitudes() {
        return aptitudes;
    }

    public void setAptitudes(String aptitudes) {
        this.aptitudes = aptitudes;
    }

    public String getIntereses() {
        return intereses;
    }

    public void setIntereses(String intereses) {
        this.intereses = intereses;
    }

    public String getNivelConcentracion() {
        return nivelConcentracion;
    }

    public void setNivelConcentracion(String nivelConcentracion) {
        this.nivelConcentracion = nivelConcentracion;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "id del usuario=" + id +
                ", nombre='" + nombre  +
                " , pass='" + pass +
                " , aptitudes='" + aptitudes +
                " , intereses='" + intereses +
                " , nivelConcentracion='" + nivelConcentracion +
                '}';
    }



}

