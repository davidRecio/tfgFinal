package services;

import Beans.Nota;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class NotaBBDD extends ConexionBBDD{

    private static NotaBBDD instance;
    public static NotaBBDD getInstance() {
        if (instance == null) {
            instance = new NotaBBDD();
        }
        return instance;
    }

    public Nota addNota(Nota nota, int idUsuarios) throws SQLException, ClassNotFoundException {
        int identificador= -1;

        if (conector() == true) {



            String asignatura= nota.getAsignatura();
            String puntuacion= nota.getPuntuacion();
            String tiempoEstudio= nota.getTiempoEstudio();
            String tipo= nota.getTipo();


            createStatement.executeUpdate("INSERT INTO tfg.nota (idUsuario, asignatura, tiempoEstudio, puntuacion, tipo ) VALUES (" + idUsuarios + ",'"+ asignatura +"',"+ tiempoEstudio +","+ puntuacion + ",'"+ tipo +"');" , Statement.RETURN_GENERATED_KEYS);
            ResultSet prueba = createStatement.getGeneratedKeys();
            prueba.next();
            identificador=prueba.getInt(1);
            System.out.println("la fila es " + identificador );
            String patron = "/usuarios/"+ idUsuarios+"/notas/";
            String url = patron+identificador;
            createStatement.executeUpdate("UPDATE  tfg.nota set url ='" + url + "' where idNota = "+ identificador + ";");

            nota.setId(identificador);
            nota.setUrl(patron);

            con.close();

        }
        return nota;
    }

    public Nota getNota(int idUsuarios, int id) {
        Nota nota = new Nota();

        try {
            if(conector()==true){
                System.out.println("Antes de guardar la query");
                String queryBBDD = "select nota.idNota, nota.url,nota.idUsuario, nota.asignatura,nota.tiempoEstudio ,nota.tiempoRecomendado, nota.puntuacion, nota.riesgo, nota.tipo from tfg.nota where nota.idNota=" + id + " and nota.idUsuario="+idUsuarios+";";
                System.out.println("Después de la query");

                try {
                    rS = createStatement.executeQuery(queryBBDD);
                } catch (SQLException ex) {
                    Logger.getLogger(UsuarioBBDD.class.getName()).log(Level.SEVERE, null, ex);
                }
                if (rS == null){
                    nota= null;

                }
                else{

                    try {
                        while (rS.next()) {
                            System.out.println("En la query");

                            System.out.println("En el else");


                            nota.setId(Integer.parseInt(rS.getString("idNota")));
                            nota.setUrl(rS.getString("url"));
                            nota.setIdUsuario(Integer.parseInt(rS.getString("idUsuario")));
                            nota.setAsignatura(rS.getString("asignatura"));
                            nota.setTiempoEstudio(rS.getString("tiempoEstudio"));
                            nota.setTiempoRecomendado(rS.getString("tiempoRecomendado"));
                            nota.setPuntuacion(rS.getString("puntuacion"));
                            nota.setRiesgo(rS.getString("riesgo"));
                            nota.setTipo(rS.getString("tipo"));




                            System.out.println("Al final del primer statement");
                        }


                    } catch (SQLException ex) {
                        ex.printStackTrace();
                        Logger.getLogger(NotaBBDD.class.getName()).log(Level.SEVERE, null, ex);
                    }


                    con.close();

                }

            }
            else{
                nota=null;

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(NotaBBDD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
            Logger.getLogger(NotaBBDD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nota;
    }

    public ArrayList<Nota> getNota(int idUsuario) {
        ArrayList<Nota> notasLista = new ArrayList();
        try {
            if(conector()==true){
                String queryBBDD = "select * from tfg.nota where idUsuario="+idUsuario+";";
                int i=0;
                try {
                    rS = createStatement.executeQuery(queryBBDD);

                    while (rS.next()) {
                        Nota nota = new Nota();

                        nota.setId(Integer.parseInt(rS.getString("idNota")));
                        nota.setUrl(rS.getString("url"));
                        nota.setIdUsuario(Integer.parseInt(rS.getString("idUsuario")));
                        nota.setAsignatura(rS.getString("asignatura"));
                        nota.setTiempoEstudio(rS.getString("tiempoEstudio"));
                        nota.setTiempoRecomendado(rS.getString("tiempoRecomendado"));
                        nota.setPuntuacion(rS.getString("puntuacion"));
                        nota.setRiesgo(rS.getString("riesgo"));
                        nota.setTipo(rS.getString("tipo"));
                        notasLista.add(nota);


                    }
                } catch (SQLException ex) {
                    Logger.getLogger(NotaBBDD.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    i=0;
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(NotaBBDD.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            else{
                return notasLista;
            }
        } catch (SQLException ex) {
            Logger.getLogger(NotaBBDD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(NotaBBDD.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("El tamaño de la lista es" + notasLista.size());
        return notasLista;

    }
    public ArrayList<Nota> getNota() {
        ArrayList<Nota> notasLista = new ArrayList();
        try {
            if(conector()==true){
                String queryBBDD = "select * from tfg.nota;";
                int i=0;
                try {
                    rS = createStatement.executeQuery(queryBBDD);

                    while (rS.next()) {
                        Nota nota = new Nota();
                        nota.setId(Integer.parseInt(rS.getString("idNota")));
                        nota.setUrl(rS.getString("url"));
                        nota.setIdUsuario(Integer.parseInt(rS.getString("idUsuario")));
                        nota.setAsignatura(rS.getString("asignatura"));
                        nota.setTiempoEstudio(rS.getString("tiempoEstudio"));
                        nota.setTiempoRecomendado(rS.getString("tiempoRecomendado"));
                        nota.setPuntuacion(rS.getString("puntuacion"));
                        nota.setRiesgo(rS.getString("riesgo"));
                        nota.setTipo(rS.getString("tipo"));
                        notasLista.add(nota);

                    }
                } catch (SQLException ex) {
                    Logger.getLogger(NotaBBDD.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    i=0;
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(NotaBBDD.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            else{
                return notasLista;
            }
        } catch (SQLException ex) {
            Logger.getLogger(NotaBBDD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(NotaBBDD.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("El tamaño de la lista es" + notasLista.size());
        return notasLista;

    }

    public Nota updateNota(Nota nota,int idUsuario, int id ) throws SQLException, ClassNotFoundException {
        Nota nota1 = new Nota();
        try {
            if (conector() == true) {

                String asignatura = nota.getAsignatura();
                String puntuacion = nota.getPuntuacion();
                String tiempoEstudio = nota.getTiempoEstudio();
                String tipo = nota.getTipo();

                String tiempoRecomendado = nota.getTiempoRecomendado();
                String riesgo = nota.getRiesgo();

                String queryBBDD = "";
                if (riesgo==null && tiempoRecomendado==null) {
                    //para el usuario
                    queryBBDD = "update tfg.nota set asignatura='" + asignatura + "', puntuacion=" + puntuacion + ", tipo='" + tipo + "', tiempoEstudio=" + tiempoEstudio + " where idNota=" + id + " and idUsuario='" + idUsuario + "' ;";

                } else {
                    //para el sistema
                    queryBBDD = "update tfg.nota set asignatura='" + asignatura + "', puntuacion=" + puntuacion + ", tipo='" + tipo + "', tiempoEstudio=" + tiempoEstudio + ", tiempoRecomendado=" + tiempoRecomendado + ", tipo='" + tipo + "' where idNota=" + id + " and idUsuario='" + idUsuario + "' ;";

                }


                try {
                    createStatement.executeUpdate(queryBBDD);
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UsuarioBBDD.class.getName()).log(Level.SEVERE, null, ex);
                }


                nota1= getNota(idUsuario, id);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
        return nota1;
    }

    public boolean deleteNota(int idUsuario) throws SQLException, ClassNotFoundException {
        boolean valor= false;
        try {
            if (conector() == true) {

                String queryBBDD = "delete from tfg.nota where idUsuario='"+idUsuario+"';";

                try {
                    createStatement.executeUpdate(queryBBDD);
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
    public boolean deleteNota(int idUsuario, int id) throws SQLException, ClassNotFoundException {
        boolean valor= false;
        try {
            if (conector() == true) {

                String queryBBDD = "delete from tfg.nota where idUsuario='"+idUsuario+"' and idNota="+id+";";

                try {
                    createStatement.executeUpdate(queryBBDD);
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
    public boolean deleteNota() throws SQLException, ClassNotFoundException {
        boolean valor= false;
        try {
            if (conector() == true) {

                String queryBBDD = "truncate table tfg.nota ;";

                try {
                    createStatement.executeUpdate(queryBBDD);
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
