package Beans;

public class RespuestasFormulario {
    private int idPregunta;
    private int idFormulario;
    private String Valor;
    private int numeroPregunta;

    public RespuestasFormulario(int idPregunta, int idFormulario, String valor) {
        this.idPregunta = idPregunta;
        this.idFormulario = idFormulario;
        Valor = valor;
    }

    public RespuestasFormulario() {
    }

    public int getNumeroPregunta() {
        return numeroPregunta;
    }


    public void setNumeroPregunta(int numeroPregunta) {
        this.numeroPregunta = numeroPregunta;
    }

    public int getIdPregunta() {
        return idPregunta;
    }

    public void setIdPregunta(int idPregunta) {
        this.idPregunta = idPregunta;
    }

    public String getValor() {
        return Valor;
    }

    public void setValor(String valor) {
        this.Valor = valor;
    }

    public int getIdFormulario() {
        return idFormulario;
    }

    public void setIdFormulario(int idFormulario) {
        this.idFormulario = idFormulario;
    }
}
