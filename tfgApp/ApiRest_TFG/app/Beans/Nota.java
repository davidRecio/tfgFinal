package Beans;

public class Nota extends RecursoWeb {
    private int idUsuario;
    private String asignatura;
    private String tiempoEstudio;
    private String tiempoRecomendado;
    private String puntuacion;
    private String riesgo;
    private String tipo;

    public Nota() {
        super();
    }

    public Nota(int idUsuario, String asignatura, String tiempoEstudio, String tiempoRecomendado, String puntuacion, String riesgo, String tipo) {
        this.idUsuario = idUsuario;
        this.asignatura = asignatura;
        this.tiempoEstudio = tiempoEstudio;
        this.tiempoRecomendado = tiempoRecomendado;
        this.puntuacion = puntuacion;
        this.riesgo = riesgo;
        this.tipo = tipo;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(String asignatura) {
        this.asignatura = asignatura;
    }

    public String getTiempoEstudio() {
        return tiempoEstudio;
    }

    public void setTiempoEstudio(String tiempoEstudio) {
        this.tiempoEstudio = tiempoEstudio;
    }

    public String getTiempoRecomendado() {
        return tiempoRecomendado;
    }

    public void setTiempoRecomendado(String tiempoRecomendado) {
        this.tiempoRecomendado = tiempoRecomendado;
    }

    public String getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(String puntuacion) {
        this.puntuacion = puntuacion;
    }

    public String getRiesgo() {
        return riesgo;
    }

    public void setRiesgo(String riesgo) {
        this.riesgo = riesgo;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}