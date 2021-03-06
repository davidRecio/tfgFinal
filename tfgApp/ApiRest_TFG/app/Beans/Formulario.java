package Beans;

import java.util.ArrayList;

public class Formulario extends RecursoWeb{

    private int idUsuario;
    private String tipo;
    private ArrayList<PreguntasFormulario> preguntasFormularioArray = new ArrayList<>();
    private ArrayList<RespuestasFormulario> respuestasFormularioArray = new ArrayList<>();

    public Formulario() {
        super();
    }

    public Formulario(int idUsuario) {
        this.idUsuario = idUsuario;


    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public ArrayList<PreguntasFormulario> getPreguntasFormularioArray() {
        return preguntasFormularioArray;
    }

    public void setPreguntasFormularioArray(ArrayList<PreguntasFormulario> preguntasFormularioArray) {
        this.preguntasFormularioArray = preguntasFormularioArray;
    }

    public ArrayList<RespuestasFormulario> getRespuestasFormularioArray() {
        return respuestasFormularioArray;
    }

    public void setRespuestasFormularioArray(ArrayList<RespuestasFormulario> respuestasFormularioArray) {
        this.respuestasFormularioArray = respuestasFormularioArray;
    }

    public void annadirPreguntas(PreguntasFormulario preguntasFormulario){
        getPreguntasFormularioArray().add(preguntasFormulario);
    }
    public void annadirRespuestas(RespuestasFormulario respuestasFormulario){
        getRespuestasFormularioArray().add(respuestasFormulario);
    }

}
