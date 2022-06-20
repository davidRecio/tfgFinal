package services;


import java.sql.*;


public class ConexionBBDD {

    protected static Connection con;
    protected static final String driver="com.mysql.jdbc.Driver";
    protected static final String user="root";
    protected static final String pass="root";
    protected static final String url="jdbc:mysql://localhost:3306";


    protected Statement createStatement;

    protected ResultSet rS;
    protected ResultSet rS1;

    protected boolean conector() throws SQLException, ClassNotFoundException {
        // Reseteamos a null la conexion a la bd
        con=null;
        boolean valor=false;
        try{

            int i=0;
            //  String valor= "fallo";
            Class.forName(driver);
            // Nos conectamos a la bd
            con=  DriverManager.getConnection(url, user, pass);
            // Si la conexion fue exitosa mostramos un mensaje de conexion exitosa
            if (con!=null){

                createStatement = con.createStatement();
                String creacion = "create database if not exists tfg;";
                String uso = "use tfg;";
                String creacionUsuario = "create table if not exists usuario(\n" +
                        "id int (100) auto_increment not null,\n" +
                        "url varchar (40),\n" +
                        "nombre varchar (40) not null,\n" +
                        "pass varchar (20) not null,\n" +
                        "primary key(id)\n" +
                        " );";
                String creacionResultado = "create table if not exists resultado(\n" +
                        "id int (100) auto_increment not null,\n" +
                        "url varchar (40),\n" +
                        "idUsuario varchar (40) not null,\n" +
                        "tipo varchar (100) not null,\n" +
                        "primary key(id)\n" +
                        " );";

                String creacionNota = "create table if not exists nota(\n" +
                        "id int (100) auto_increment not null,\n" +
                        "url varchar (40),\n" +
                        "idResultado varchar (40) not null,\n" +
                        "asignatura varchar (150) not null,\n" +
                        "puntuacion varchar (10) not null,\n" +
                        "tiempoEstudio varchar (10) not null,\n" +
                        "primary key(id)\n" +
                        " );";
                String creacionRecomendacion = "create table if not exists recomendacion(\n" +
                        "id int (100) auto_increment not null,\n" +
                        "url varchar (200),\n" +
                        "idResultado varchar (40) not null,\n" +
                        "primary key(id)\n" +
                        " );";
                String creacionSugerencia = "create table if not exists sugerencia(\n" +
                        "id int (100) auto_increment not null,\n" +
                        "url varchar (200),\n" +
                        "idRecomendacion varchar (40) not null,\n" +
                        "idNota varchar (40) not null,\n" +
                        "riesgo varchar (10) not null,\n" +
                        "tiempoSugerido varchar (10) not null,\n" +
                        "primary key(id)\n" +
                        " );";


                createStatement.executeUpdate(creacion);

                createStatement.executeUpdate(uso);

                createStatement.executeUpdate(creacionUsuario);
                createStatement.executeUpdate(creacionResultado);
                createStatement.executeUpdate(creacionNota);
                createStatement.executeUpdate(creacionRecomendacion);
                createStatement.executeUpdate(creacionSugerencia);


                valor= true;
            }
        }
        //Si la conexion NO fue exitosa mostramos un mensaje de error
        catch (ClassNotFoundException | SQLException e){
            System.out.println( e);
        }
        return  valor;
    }
}
