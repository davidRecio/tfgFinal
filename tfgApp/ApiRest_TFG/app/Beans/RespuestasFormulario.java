package Beans;

public class RespuestasFormulario {
    private String idPregunta;
    private String idFormulario;
    private String Valor;

    public RespuestasFormulario(String idPregunta, String idFormulario, String valor) {
        this.idPregunta = idPregunta;
        this.idFormulario = idFormulario;
        Valor = valor;
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

    public String getIdFormulario() {
        return idFormulario;
    }

    public void setIdFormulario(String idFormulario) {
        this.idFormulario = idFormulario;
    }
}
