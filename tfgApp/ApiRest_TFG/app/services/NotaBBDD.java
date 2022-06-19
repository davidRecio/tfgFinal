package services;

import Beans.Nota;
import Beans.Usuario;

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
                    Logger.getLogger(ResultadoBBDD.class.getName()).log(Level.SEVERE, null, ex);
                }

                try {

                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ResultadoBBDD.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else{

            }
        } catch (SQLException ex) {
            Logger.getLogger(ResultadoBBDD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ResultadoBBDD.class.getName()).log(Level.SEVERE, null, ex);
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
                    Logger.getLogger(ResultadoBBDD.class.getName()).log(Level.SEVERE, null, ex);
                }

                try {

                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ResultadoBBDD.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else{

            }
        } catch (SQLException ex) {
            Logger.getLogger(ResultadoBBDD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ResultadoBBDD.class.getName()).log(Level.SEVERE, null, ex);
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
                    Logger.getLogger(ResultadoBBDD.class.getName()).log(Level.SEVERE, null, ex);
                }

                try {

                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(ResultadoBBDD.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else{

            }
        } catch (SQLException ex) {
            Logger.getLogger(ResultadoBBDD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ResultadoBBDD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return valor;
    }
}
