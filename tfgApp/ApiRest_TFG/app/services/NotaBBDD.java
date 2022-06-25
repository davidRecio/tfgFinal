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
/*
    public Nota addNota(Nota nota, int idUsuarios,int idResultado) throws SQLException, ClassNotFoundException {
        int identificador= -1;

        if (conector() == true) {



            String asignatura= nota.getAsignatura();
            String puntuacion= nota.getPuntuacion();
            String tiempoEstudio= nota.getTiempoEstudio();


            createStatement.executeUpdate("INSERT INTO tfg.nota (idResultado, asignatura, puntuacion, tiempoEstudio) VALUES ('" + idResultado + "','"+ asignatura +"','"+ puntuacion +"','"+ tiempoEstudio + "');" , Statement.RETURN_GENERATED_KEYS);
            ResultSet prueba = createStatement.getGeneratedKeys();
            prueba.next();
            identificador=prueba.getInt(1);
            System.out.println("la fila es " + identificador );
            String patron = "/usuarios/"+ idUsuarios+"/resultados/"+idResultado+"/notas/";
            String url = patron+identificador;
            createStatement.executeUpdate("UPDATE  tfg.nota set url ='" + url + "' where id = "+ identificador + ";");


            con.close();

        }
        return nota;
    }
    public Nota getNota(int idResultado, int id) {
        Nota nota = new Nota();

        try {
            if(conector()==true){
                System.out.println("Antes de guardar la query");
                String queryBBDD = "select nota.id, nota.url,nota.idResultado, nota.asignatura,nota.puntuacion, nota.tiempoEstudio from tfg.nota where nota.id=" + id + " and nota.idResultado="+idResultado+";";
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


                            nota.setId(Integer.parseInt(rS.getString("id")));
                            nota.setUrl(rS.getString("url"));
                            nota.setIdResultado(rS.getString("idResultado"));
                            nota.setAsignatura(rS.getString("asignatura"));
                            nota.setPuntuacion(rS.getString("puntuacion"));
                            nota.setTiempoEstudio(rS.getString("tiempoEstudio"));




                            System.out.println("Al final del primer statement");
                        }


                    } catch (SQLException ex) {
                        ex.printStackTrace();
                        Logger.getLogger(ResultadoBBDD.class.getName()).log(Level.SEVERE, null, ex);
                    }


                    con.close();

                }

            }
            else{
                nota=null;

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(ResultadoBBDD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
            Logger.getLogger(ResultadoBBDD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return nota;
    }
    public ArrayList<Nota> getNota(int idResultado) {
        ArrayList<Nota> notasLista = new ArrayList();
        try {
            if(conector()==true){
                String queryBBDD = "select * from tfg.nota where idResultado="+idResultado+";";
                int i=0;
                try {
                    rS = createStatement.executeQuery(queryBBDD);

                    while (rS.next()) {
                        Nota nota = new Nota();
                        nota.setId(Integer.parseInt(rS.getString("id")));
                        nota.setUrl(rS.getString("url"));
                        nota.setIdResultado(rS.getString("idResultado"));
                        nota.setAsignatura(rS.getString("asignatura"));
                        nota.setPuntuacion(rS.getString("puntuacion"));
                        nota.setTiempoEstudio(rS.getString("tiempoEstudio"));
                        notasLista.add(nota);


                    }
                } catch (SQLException ex) {
                    Logger.getLogger(ResultadoBBDD.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    i=0;
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ResultadoBBDD.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            else{
                return notasLista;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ResultadoBBDD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ResultadoBBDD.class.getName()).log(Level.SEVERE, null, ex);
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
                        nota.setId(Integer.parseInt(rS.getString("id")));
                        nota.setUrl(rS.getString("url"));
                        nota.setIdResultado(rS.getString("idResultado"));
                        nota.setAsignatura(rS.getString("asignatura"));
                        nota.setPuntuacion(rS.getString("puntuacion"));
                        nota.setTiempoEstudio(rS.getString("tiempoEstudio"));
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
    public Nota updateNota(Nota nota,int idResultado, int id ) throws SQLException, ClassNotFoundException {
        try {
            if (conector() == true) {

                String asignatura = nota.getAsignatura();
                String puntuacion= nota.getPuntuacion();
                String tiempoEstudio = nota.getTiempoEstudio();



                String queryBBDD = "update tfg.nota set asignatura='"+asignatura+"', puntuacion='"+puntuacion+"', tiempoEstudio='"+tiempoEstudio+"' where id="+id+" and idResultado='"+idResultado+"' ;";

                try {
                    createStatement.executeUpdate(queryBBDD);
                } catch (SQLException ex) {
                    Logger.getLogger(UsuarioBBDD.class.getName()).log(Level.SEVERE, null, ex);
                }

                try {

                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UsuarioBBDD.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else{

            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioBBDD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsuarioBBDD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return getNota(idResultado,id);
    }
    public boolean deleteNota(int idResultado) throws SQLException, ClassNotFoundException {
        boolean valor= false;
        try {
            if (conector() == true) {

                String queryBBDD = "delete from tfg.nota where idResultado='"+idResultado+"';";

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
    public boolean deleteNota(int idResultado, int id) throws SQLException, ClassNotFoundException {
        boolean valor= false;
        try {
            if (conector() == true) {

                String queryBBDD = "delete from tfg.nota where idResultado='"+idResultado+"' and id="+id+";";

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

 */
}
