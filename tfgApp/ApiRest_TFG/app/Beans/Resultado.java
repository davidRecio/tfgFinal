package Beans;

import java.util.ArrayList;

public class Resultado extends RecursoWeb{


    private String idUsuario;
    private String tipo;
    private ArrayList<Nota> listaNota = new ArrayList<>();


    public Resultado() {
        super();
    }

    public Resultado(int id, String url, String idUsuario) {
        super(id, url);
        this.idUsuario = idUsuario;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public ArrayList<Nota> getListaNota() {
        return listaNota;
    }

    public void setListaNota(ArrayList<Nota> listaNota) {
        this.listaNota = listaNota;
    }

    public void annadirNotas(Nota nota){
        getListaNota().add(nota);
    }
}
