package Beans;

public class Nota {

    private String asignatura;
    private String puntuacion;

    private String tiempoEmpleado;

    public Nota(String asignatura, String puntuacion, String tiempoEmpleado) {
        this.asignatura = asignatura;
        this.puntuacion = puntuacion;
        this.tiempoEmpleado = tiempoEmpleado;
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

    public String getTiempoEmpleado() {
        return tiempoEmpleado;
    }

    public void setTiempoEmpleado(String tiempoEmpleado) {
        this.tiempoEmpleado = tiempoEmpleado;
    }
}
