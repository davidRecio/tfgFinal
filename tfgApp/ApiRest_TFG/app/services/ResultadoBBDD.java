package services;

import Beans.Resultado;
import Beans.Usuario;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ResultadoBBDD extends ConexionBBDD{

    private static ResultadoBBDD instance;
    public static ResultadoBBDD getInstance() {
        if (instance == null) {
            instance = new ResultadoBBDD();
        }
        return instance;
    }

    public Resultado addResultado(Resultado resultado, int idUsuarios) throws SQLException, ClassNotFoundException {
        int identificador= -1;

        if (conector() == true) {



            String tipo= resultado.getTipo();


            createStatement.executeUpdate("INSERT INTO tfg.resultado (idUsuario, tipo) VALUES ('" + idUsuarios + "','"+ tipo + "');" , Statement.RETURN_GENERATED_KEYS);
            ResultSet prueba = createStatement.getGeneratedKeys();
            prueba.next();
            identificador=prueba.getInt(1);
            System.out.println("la fila es " + identificador );
            String patron = "/usuarios/"+ idUsuarios+"/resultados/";
            String url = patron+identificador;
            createStatement.executeUpdate("UPDATE  tfg.resultado set url ='" + url + "' where id = "+ identificador + ";");


            con.close();

        }
        return resultado;
    }

    public Resultado getResultado(int idUsuarios,int id) {
        Resultado resultado = new Resultado();

        try {
            if(conector()==true){
                System.out.println("Antes de guardar la query");
                String queryBBDD = "select resultado.id, resultado.url,resultado.idUsuario, resultado.tipo from tfg.resultado where resultado.id=" + id + " and resultado.idUsuario="+idUsuarios+";";
                System.out.println("Después de la query");

                try {
                    rS = createStatement.executeQuery(queryBBDD);
                } catch (SQLException ex) {
                    Logger.getLogger(UsuarioBBDD.class.getName()).log(Level.SEVERE, null, ex);
                }
                if (rS == null){
                    resultado= null;

                }
                else{

                    try {
                        while (rS.next()) {
                            System.out.println("En la query");

                            System.out.println("En el else");

                            resultado.setId(rS.getInt("resultado.id"));

                            resultado.setUrl(rS.getString("resultado.url"));

                            resultado.setIdUsuario(rS.getString("resultado.idUsuario"));

                            resultado.setTipo(rS.getString("resultado.tipo"));



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
                resultado=null;

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(ResultadoBBDD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
            Logger.getLogger(ResultadoBBDD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return resultado;
    }
    public ArrayList<Resultado> getResultado(int idUsuarios) {
        ArrayList<Resultado> resultadosLista = new ArrayList();
        try {
            if(conector()==true){
                String queryBBDD = "select * from tfg.resultado where idUsuario="+idUsuarios+";";
                int i=0;
                try {
                    rS = createStatement.executeQuery(queryBBDD);

                    while (rS.next()) {
                        Resultado resultado = new Resultado();
                        resultado.setId(Integer.parseInt(rS.getString("id")));
                        resultado.setUrl(rS.getString("url"));
                        resultado.setIdUsuario(rS.getString("idUsuario"));
                        resultado.setTipo(rS.getString("tipo"));
                        resultadosLista.add(resultado);

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
                return resultadosLista;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ResultadoBBDD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ResultadoBBDD.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("El tamaño de la lista es" + resultadosLista.size());
        return resultadosLista;

    }
    public ArrayList<Resultado> getResultado() {
        ArrayList<Resultado> resultadosLista = new ArrayList();
        try {
            if(conector()==true){
                String queryBBDD = "select * from tfg.resultado;";
                int i=0;
                try {
                    rS = createStatement.executeQuery(queryBBDD);

                    while (rS.next()) {
                        Resultado resultado = new Resultado();
                        resultado.setId(Integer.parseInt(rS.getString("id")));
                        resultado.setUrl(rS.getString("url"));
                        resultado.setIdUsuario(rS.getString("idUsuario"));
                        resultado.setTipo(rS.getString("tipo"));
                        resultadosLista.add(resultado);

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
                return resultadosLista;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ResultadoBBDD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ResultadoBBDD.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("El tamaño de la lista es" + resultadosLista.size());
        return resultadosLista;

    }
    public Resultado updateTipoResultadoByUsuario(Resultado resultado, int idUsuarios,int id ) throws SQLException, ClassNotFoundException {
        try {
            if (conector() == true) {
                //int id = usu.getId();
                //String url = usu.getUrl();

                String tipo= resultado.getTipo();

                String queryBBDD = "update tfg.resultado set tipo='"+tipo+"' where idUsuario='"+idUsuarios+"'and id="+id+";";

                try {
                    createStatement.executeUpdate(queryBBDD);
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
        return getResultado(idUsuarios,id);
    }
    public boolean deleteResultado(int idUsuario) throws SQLException, ClassNotFoundException {
        boolean valor= false;
        try {
            if (conector() == true) {

                String queryBBDD = "delete from tfg.resultado where idUsuario='"+idUsuario+"';";

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
    public boolean deleteResultado(int idUsuario,int id) throws SQLException, ClassNotFoundException {
        boolean valor= false;
        try {
            if (conector() == true) {

                String queryBBDD = "delete from tfg.resultado where idUsuario='"+idUsuario+"' and id="+id+";";

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
    public boolean deleteResultado() throws SQLException, ClassNotFoundException {
        boolean valor= false;
        try {
            if (conector() == true) {

                String queryBBDD = "truncate table tfg.resultado;";

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
