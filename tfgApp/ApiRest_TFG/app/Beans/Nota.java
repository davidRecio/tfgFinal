package Beans;

public class Nota extends RecursoWeb {
    private String idResultado;
    private String asignatura;
    private String puntuacion;

    private String tiempoEstudio;

    public Nota() {
        super();
    }

    public Nota(String idResultado, String asignatura, String puntuacion, String tiempoEstudio) {
        this.idResultado = idResultado;
        this.asignatura = asignatura;
        this.puntuacion = puntuacion;
        this.tiempoEstudio = tiempoEstudio;
    }

    public String getIdResultado() {
        return idResultado;
    }

    public void setIdResultado(String idResultado) {
        this.idResultado = idResultado;
    }

    public String getAsignatura() {
        return asignatura;
    }

    public void setAsignatura(String asignatura) {
        this.asignatura = asignatura;
    }

    public String getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(String puntuacion) {
        this.puntuacion = puntuacion;
    }

    public String getTiempoEstudio() {
        return tiempoEstudio;
    }

    public void setTiempoEstudio(String tiempoEstudio) {
        this.tiempoEstudio = tiempoEstudio;
    }
}
