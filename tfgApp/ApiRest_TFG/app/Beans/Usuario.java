package Beans;


import java.util.ArrayList;

public class Usuario extends RecursoWeb{

    private String nombre;
    private String pass;
    private String url;

    @Override
    public String getUrl() {
        return url;
    }

    @Override
    public void setUrl(String url) {
        this.url = url;
    }

    public Usuario(){
        super();
    }
   public Usuario(int id, String url, String nombre, String pass){
        super(id,url);
        this.nombre=nombre;
        this.pass=pass;

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



    @Override
    public String toString() {
        return "Usuario{" +
                "id del usuario=" + id +
                ", nombre='" + nombre + '\'' +
                ", pass='" + pass +
                '}';
    }



}

