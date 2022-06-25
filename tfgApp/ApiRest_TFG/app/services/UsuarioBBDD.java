package services;

import Beans.Usuario;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UsuarioBBDD extends ConexionBBDD{

    private static UsuarioBBDD instance;
    public static UsuarioBBDD getInstance() {
        if (instance == null) {
            instance = new UsuarioBBDD();
        }
        return instance;
    }

    public Usuario addUsuario(Usuario usuario) throws SQLException, ClassNotFoundException {
        int identificador= -1;
        if (conector() == true) {

            String nombre= usuario.getNombre();
            String pass= usuario.getPass();
            createStatement.executeUpdate("INSERT INTO tfg.usuario (nombre,pass) VALUES ('" + nombre + "', '" + pass + "');" , Statement.RETURN_GENERATED_KEYS);
            ResultSet rS = createStatement.getGeneratedKeys();
            rS.next();
            identificador=rS.getInt(1);
            String patron = "/usuarios/";
            String url = patron+identificador;
            createStatement.executeUpdate("UPDATE  tfg.usuario set url ='" + url + "' where idUsuario = "+ identificador + ";");
            usuario.setUrl(url);
            crearFormularios(identificador);
            con.close();

        }
        return usuario;
    }


    public Usuario getUsuario(int id) {
        Usuario usu = new Usuario();

        try {
            if(conector()==true){
                System.out.println("Antes de guardar la query");
                String queryBBDD = "select usuario.idUsuario, usuario.url,usuario.nombre, usuario.pass from tfg.usuario where usuario.idUsuario=" + id + ";";
                System.out.println("Después de la query");

                try {
                    rS = createStatement.executeQuery(queryBBDD);
                } catch (SQLException ex) {
                    Logger.getLogger(UsuarioBBDD.class.getName()).log(Level.SEVERE, null, ex);
                }
                if (rS == null){
                    usu= null;

                }
                else{

                    try {
                        while (rS.next()) {
                            System.out.println("En la query");

                                System.out.println("En el else");

                                 usu.setId(rS.getInt("usuario.idUsuario"));
                                 usu.setUrl(rS.getString("usuario.url"));
                                 usu.setNombre(rS.getString("usuario.nombre"));
                                 usu.setPass(rS.getString("usuario.pass"));
                                 usu.setAptitudes(rS.getString("aptitudes"));
                                 usu.setIntereses(rS.getString("intereses"));
                                 usu.setNivelConcentracion(rS.getString("nivelConcentracion"));


                                System.out.println("Al final del primer statement");
                            }


                    } catch (SQLException ex) {
                        ex.printStackTrace();
                        Logger.getLogger(UsuarioBBDD.class.getName()).log(Level.SEVERE, null, ex);
                    }


                        con.close();

                }

            }
            else{
                usu=null;

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(UsuarioBBDD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
            Logger.getLogger(UsuarioBBDD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usu;
    }
    public ArrayList<Usuario> getAllUsuarios() {
        ArrayList<Usuario> usuariosLista = new ArrayList();
        try {
            if(conector()==true){
                String queryBBDD = "select * from tfg.usuario;";
                int i=0;
                try {
                    rS = createStatement.executeQuery(queryBBDD);

                    while (rS.next()) {
                        Usuario usu = new Usuario();
                        usu.setId(Integer.parseInt(rS.getString("idUsuario")));
                        usu.setUrl(rS.getString("url"));
                        usu.setNombre(rS.getString("nombre"));
                        usu.setPass(rS.getString("pass"));
                        usu.setAptitudes(rS.getString("aptitudes"));
                        usu.setIntereses(rS.getString("intereses"));
                        usu.setNivelConcentracion(rS.getString("nivelConcentracion"));
                        usuariosLista.add(usu);

                    }
                } catch (SQLException ex) {
                    Logger.getLogger(UsuarioBBDD.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    i=0;
                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(UsuarioBBDD.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
            else{
                return usuariosLista;
            }
        } catch (SQLException ex) {
            Logger.getLogger(UsuarioBBDD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(UsuarioBBDD.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println("El tamaño de la lista es" + usuariosLista.size());
        return usuariosLista;

    }

    public Usuario updateUsuario(Usuario usu, int id ) throws SQLException, ClassNotFoundException {
        try {
            if (conector() == true) {

                String nombre = usu.getNombre();
                String pass= usu.getPass();
                String aptitudes= usu.getAptitudes();
                String intereses= usu.getIntereses();
                String nivelConcentracion= usu.getNivelConcentracion();

                String queryBBDD = "update tfg.usuario set nombre='"+nombre+"', pass='"+pass+"', aptitudes='"+aptitudes+"', intereses='"+intereses+"', nivelConcentracion='"+nivelConcentracion+"' where idUsuario="+id+";";

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
        return getUsuario(id);
    }
    public Usuario updatePassUsuario(Usuario usu, int id ) throws SQLException, ClassNotFoundException {
        try {
            if (conector() == true) {
                //int id = usu.getId();
                //String url = usu.getUrl();

                String pass= usu.getPass();

                String queryBBDD = "update tfg.usuario set pass='"+pass+"' where idUsuario="+id+";";

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
        return getUsuario(id);
    }

    public boolean deleteUsuario(int id) throws SQLException, ClassNotFoundException {
        boolean valor= false;
        try {
            if (conector() == true) {

                String queryBBDD = "delete from tfg.usuario where idUsuario="+id+";";

                try {
                    createStatement.executeUpdate(queryBBDD);
                    valor = true;
                    return valor;
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
        return valor;
    }

    private boolean crearFormularios(int idUsuario){
        boolean valor= true;
        //le crea los formularios
        try {
            //CHASIDE
            createStatement.executeUpdate("INSERT INTO tfg.formulario (idUsuario,tipo) VALUES ('" + idUsuario + "', 'C');" , Statement.RETURN_GENERATED_KEYS);

        ResultSet rs = createStatement.getGeneratedKeys();
        rs.next();
        idUsuario=rs.getInt(1);

        System.out.println("la fila es " + idUsuario );
        String patron = "/usuarios/formularios/";
        String url = patron+"C";
        createStatement.executeUpdate("UPDATE  tfg.formulario set url ='" + url + "' where idFormulario = "+ idUsuario + ";");

        //TOULOUSE
            createStatement.executeUpdate("INSERT INTO tfg.formulario (idUsuario,tipo) VALUES ('" + idUsuario + "', 'T');" , Statement.RETURN_GENERATED_KEYS);

             rs = createStatement.getGeneratedKeys();
            rs.next();
            idUsuario=rs.getInt(1);

            System.out.println("la fila es " + idUsuario );
             patron = "/usuarios/formularios/";
             url = patron+"T";
            createStatement.executeUpdate("UPDATE  tfg.formulario set url ='" + url + "' where idFormulario = "+ idUsuario + ";");
        } catch (SQLException e) {
            valor= false;


        }
        return valor;

    }

}
