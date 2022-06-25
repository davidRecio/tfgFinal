package Beans;

public class PreguntasFormulario {

    private String contenido;
    private String imagen;

    private String tipo;


    public PreguntasFormulario(String contenido, String imagen, String tipo) {
        this.contenido = contenido;
        this.imagen = imagen;
        this.tipo = tipo;
    }

    public PreguntasFormulario() {
    }



    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}
