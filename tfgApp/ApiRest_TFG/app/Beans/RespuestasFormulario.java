package Beans;

public class RespuestasFormulario {
    private String idPregunta;
    private String Valor;

    public RespuestasFormulario(String idPregunta, String Valor) {
        this.idPregunta = idPregunta;
        this.Valor = Valor;
    }

    public RespuestasFormulario() {
    }

    public String getIdPregunta() {
        return idPregunta;
    }

    public void setIdPregunta(String idPregunta) {
        this.idPregunta = idPregunta;
    }

    public String getValor() {
        return Valor;
    }

    public void setValor(String valor) {
        this.Valor = valor;
    }
}
