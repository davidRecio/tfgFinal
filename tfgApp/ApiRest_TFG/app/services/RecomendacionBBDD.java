package services;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class RecomendacionBBDD extends ConexionBBDD{

    private static RecomendacionBBDD instance;
    public static RecomendacionBBDD getInstance() {
        if (instance == null) {
            instance = new RecomendacionBBDD();
        }
        return instance;
    }

        public ArrayList<Recomendacion> getRecomendacion(int idResultado) {
    ArrayList<Recomendacion> listaRecomendaciones= new ArrayList<>();
        try {
            if(conector()==true){

                System.out.println("Antes de guardar la query");
                String queryBBDD = "select recomendacion.id, recomendacion.url,recomendacion.idResultado from tfg.recomendacion where  recomendacion.idResultado='"+idResultado+"';";

                int i=0;
                try {
                    rS = createStatement.executeQuery(queryBBDD);

                if (rS == null){
                    // usu= null;

                }
                else {
                    ArrayList<String> idAux =new ArrayList<>();
                    while (rS.next()) {

                        idAux.add(rS.getString("id"));

                    }
                        try {
                            for (String id:idAux) {
                                Recomendacion recomendacion = new Recomendacion();

                            System.out.println("Antes del nuevo statement");
                            String queryBBDD1 = "select r.url ,n.asignatura, s.tiempoSugerido, s.riesgo, r.idResultado,r.id from tfg.recomendacion as r inner join tfg.sugerencia as s on r.id= s.idRecomendacion inner join tfg.nota as n on s.idNota=n.id where r.idResultado=" + idResultado + " and r.id=" + id + ";";
                            System.out.println("Después de la query");
                                System.out.println(id);
                            rS1 = createStatement.executeQuery(queryBBDD1);

                                recomendacion.setId(Integer.parseInt(id));

                            while (rS1.next()) {
                                System.out.println("Dentro del nuevo statement");
                                Sugerencia sugerencia = new Sugerencia();

                                sugerencia.setIdNota(rS1.getString("id"));
                                sugerencia.setRiesgo(rS1.getString("riesgo"));
                                sugerencia.setTiempoSugerido(rS1.getString("tiempoSugerido"));
                                sugerencia.setAsignatura(rS1.getString("asignatura"));

                                recomendacion.annadirSugerencias(sugerencia);

                                System.out.println("Al final del todo");





                                }
                                listaRecomendaciones.add(recomendacion);
                            }
                        } catch (SQLException ex) {
                            ex.printStackTrace();
                            Logger.getLogger(UsuarioBBDD.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        try {
                            i = 0;
                            con.close();
                        } catch (SQLException ex) {
                            ex.printStackTrace();
                            Logger.getLogger(UsuarioBBDD.class.getName()).log(Level.SEVERE, null, ex);
                        }

                }
                } catch (SQLException ex) {
                    Logger.getLogger(UsuarioBBDD.class.getName()).log(Level.SEVERE, null, ex);
                }
            }



        } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(UsuarioBBDD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
            Logger.getLogger(UsuarioBBDD.class.getName()).log(Level.SEVERE, null, ex);
        }
       return listaRecomendaciones;
    }
    public ArrayList<Recomendacion> getRecomendacion() {
        ArrayList<Recomendacion> listaRecomendaciones= new ArrayList<>();
        try {
            if(conector()==true){

                System.out.println("Antes de guardar la query");
                String queryBBDD = "select recomendacion.id, recomendacion.url,recomendacion.idResultado from tfg.recomendacion ;";

                int i=0;
                try {
                    rS = createStatement.executeQuery(queryBBDD);

                    if (rS == null){
                        // usu= null;

                    }
                    else {
                        ArrayList<String> idAux =new ArrayList<>();
                        while (rS.next()) {

                            idAux.add(rS.getString("id"));

                        }
                        try {
                            for (String id:idAux) {
                                Recomendacion recomendacion = new Recomendacion();

                                System.out.println("Antes del nuevo statement");
                                String queryBBDD1 = "select r.url ,n.asignatura, s.tiempoSugerido, s.riesgo, r.idResultado,r.id from tfg.recomendacion as r inner join tfg.sugerencia as s on r.id= s.idRecomendacion inner join tfg.nota as n on s.idNota=n.id where r.id=" + id + ";";
                                System.out.println("Después de la query");
                                System.out.println(id);
                                rS1 = createStatement.executeQuery(queryBBDD1);

                                recomendacion.setId(Integer.parseInt(id));

                                while (rS1.next()) {
                                    System.out.println("Dentro del nuevo statement");
                                    Sugerencia sugerencia = new Sugerencia();

                                    sugerencia.setIdNota(rS1.getString("id"));
                                    sugerencia.setRiesgo(rS1.getString("riesgo"));
                                    sugerencia.setTiempoSugerido(rS1.getString("tiempoSugerido"));
                                    sugerencia.setAsignatura(rS1.getString("asignatura"));

                                    recomendacion.annadirSugerencias(sugerencia);

                                    System.out.println("Al final del todo");





                                }
                                listaRecomendaciones.add(recomendacion);
                            }
                        } catch (SQLException ex) {
                            ex.printStackTrace();
                            Logger.getLogger(UsuarioBBDD.class.getName()).log(Level.SEVERE, null, ex);
                        }
                        try {
                            i = 0;
                            con.close();
                        } catch (SQLException ex) {
                            ex.printStackTrace();
                            Logger.getLogger(UsuarioBBDD.class.getName()).log(Level.SEVERE, null, ex);
                        }

                    }
                } catch (SQLException ex) {
                    Logger.getLogger(UsuarioBBDD.class.getName()).log(Level.SEVERE, null, ex);
                }
            }



        } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(UsuarioBBDD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
            Logger.getLogger(UsuarioBBDD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return listaRecomendaciones;
    }
    public boolean deleteRecomendacion() throws SQLException, ClassNotFoundException {
        boolean valor= false;
        try {
            if (conector() == true) {

                String queryBBDD = "truncate table tfg.recomendacion ;";
                String queryBBDD1 = "truncate table tfg.sugerencia";

                try {
                    createStatement.executeUpdate(queryBBDD);
                    createStatement.executeUpdate(queryBBDD1);
                    valor = true;
                    return valor;
                } catch (SQLException ex) {
                    Logger.getLogger(NotaBBDD.class.getName()).log(Level.SEVERE, null, ex);
                }

                try {

                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(NotaBBDD.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else{

            }
        } catch (SQLException ex) {
            Logger.getLogger(NotaBBDD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(NotaBBDD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return valor;
    }
}
