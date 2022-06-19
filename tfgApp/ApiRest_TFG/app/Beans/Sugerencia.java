package Beans;

public class Sugerencia {

    private Nota nota;
    private String riesgo;
    private String tiempoSugerido;

    public Sugerencia(Nota nota, String riesgo, String tiempoSugerido) {
        this.nota = nota;
        this.riesgo = riesgo;
        this.tiempoSugerido = tiempoSugerido;
    }

    public Nota getNota() {
        return nota;
    }

    public void setNota(Nota nota) {
        this.nota = nota;
    }

    public String getRiesgo() {
        return riesgo;
    }

    public void setRiesgo(String riesgo) {
        this.riesgo = riesgo;
    }

    public String getTiempoSugerido() {
        return tiempoSugerido;
    }

    public void setTiempoSugerido(String tiempoSugerido) {
        this.tiempoSugerido = tiempoSugerido;
    }
}
