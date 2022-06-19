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
            createStatement.executeUpdate("UPDATE  tfg.resultado set url ='" + url + "' where id = "+ identificador + ";");


            con.close();

        }
        return nota;
    }


}
