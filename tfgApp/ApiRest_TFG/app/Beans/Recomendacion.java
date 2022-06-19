package Beans;

import java.util.ArrayList;

public class Recomendacion extends RecursoWeb{


    private ArrayList<Sugerencia> listaSugerencia = new ArrayList<>();

    public Recomendacion() {
        super();
    }

    public Recomendacion(int id, String url) {
        super(id, url);
    }


    public ArrayList<Sugerencia> getListaSugerencia() {
        return listaSugerencia;
    }

    public void setListaSugerencia(ArrayList<Sugerencia> listaSugerencia) {
        this.listaSugerencia = listaSugerencia;
    }

    public void annadirSugerencias(Sugerencia sugerencia){
        getListaSugerencia().add(sugerencia);
    }
}
