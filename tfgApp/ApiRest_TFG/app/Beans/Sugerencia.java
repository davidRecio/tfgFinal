package Beans;

public class Sugerencia {

    private String idNota;
    private String riesgo;
    private String tiempoSugerido;
    private  String asignatura;


    public Sugerencia(String idNota, String riesgo, String tiempoSugerido, String asignatura) {
        this.idNota = idNota;
        this.riesgo = riesgo;
        this.tiempoSugerido = tiempoSugerido;
        this.asignatura = asignatura;
    }

    public String getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(String asignatura) {
        this.asignatura = asignatura;
    }

    public Sugerencia() {
    }

    public String getIdNota() {
        return idNota;
    }

    public void setIdNota(String idNota) {
        this.idNota = idNota;
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
