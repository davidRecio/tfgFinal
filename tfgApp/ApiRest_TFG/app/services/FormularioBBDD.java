package services;

import Beans.*;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class FormularioBBDD extends ConexionBBDD{

    private static FormularioBBDD instance;
    public static FormularioBBDD getInstance() {
        if (instance == null) {
            instance = new FormularioBBDD();
        }
        return instance;
    }
    public Formulario addFormulario(Formulario formulario,int idUsuario) throws SQLException, ClassNotFoundException {
        int identificador= -1;
        ArrayList<RespuestasFormulario> listaidRespuestas;

        try{

        if (conector() == true) {
            

            String tipo= formulario.getTipo();
            listaidRespuestas=formulario.getRespuestasFormularioArray();
            
         
            deleteRespuestaByUsuarioAndtipo(idUsuario,tipo);
            
            createStatement.executeUpdate("INSERT INTO tfg.formulario (idUsuario,tipo) VALUES ('" + idUsuario + "', '" + tipo + "');" , Statement.RETURN_GENERATED_KEYS);
            ResultSet rs = createStatement.getGeneratedKeys();
            rs.next();
            identificador=rs.getInt(1);

            System.out.println("la fila es " + identificador );
            String patron = "/usuarios/formularios/";
            String url = patron+identificador;
            createStatement.executeUpdate("UPDATE  tfg.formulario set url ='" + url + "' where id = "+ identificador + ";");


            for (RespuestasFormulario respuesta:listaidRespuestas) {

                createStatement.executeUpdate("INSERT INTO tfg.respuesta (idPregunta,valor) VALUES ('" + respuesta.getIdPregunta() + "', '" + respuesta.getValor() + "');" , Statement.RETURN_GENERATED_KEYS);
                ResultSet rs2 = createStatement.getGeneratedKeys();
                rs2.next();
                createStatement.executeUpdate("INSERT INTO tfg.formulariorespuesta (idFormulario,idRespuesta) VALUES ('" + idUsuario + "', '" + rs2.getInt(1) + "');" );

            }


        }
        }
        catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(FormularioBBDD.class.getName()).log(Level.SEVERE, null, ex);
        }
        con.close();
        return formulario;
    }


    public Formulario getformulario(int id) {
        Formulario formulario = new Formulario();

        //id=1 es Chaside id!=1 es Toulouse
        String queryBBDD;
        if(id==1){
            //id=1 es Chaside
            queryBBDD = "select pregunta.contenido, pregunta.imagen from tfg.pregunta where imagen is null;";
        }else {
            //id!=1 es Toulouse
             queryBBDD = "select pregunta.contenido, pregunta.imagen from tfg.pregunta where imagen is not null;";
        }
        try {
            if(conector()==true){


                try {
                    rS = createStatement.executeQuery(queryBBDD);
                } catch (SQLException ex) {
                    Logger.getLogger(FormularioBBDD.class.getName()).log(Level.SEVERE, null, ex);
                }
                if (rS == null){
                    formulario= null;

                }
                else{

                    try {

                        while (rS.next()) {
                            PreguntasFormulario preguntasFormulario = new PreguntasFormulario();



                            if(id!=1){
                                preguntasFormulario.setPregunta(rS.getString("pregunta.contenido")+". Escriba separado por ';' la cantidad de esta figura en cada fila");
                            }else{
                                preguntasFormulario.setPregunta(rS.getString("pregunta.contenido"));
                            }
                            if(id!=1){
                                preguntasFormulario.setImagen(rS.getString("pregunta.imagen"));
                            }else{
                                preguntasFormulario.setImagen("no posee imagen");
                            }


                            formulario.annadirPreguntas(preguntasFormulario);


                        }


                    } catch (SQLException ex) {
                        ex.printStackTrace();
                        Logger.getLogger(FormularioBBDD.class.getName()).log(Level.SEVERE, null, ex);
                    }


                    con.close();

                }

            }
            else{
                formulario=null;

            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(FormularioBBDD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
            Logger.getLogger(FormularioBBDD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return formulario;
    }
    public boolean deleteRespuestaByUsuarioAndtipo(int idUsuario, String tipo) throws SQLException, ClassNotFoundException {
        boolean valor= false;
        ArrayList<String>idArrayFormularios=new ArrayList<>();
        ArrayList<String>idArrayRespuestas=new ArrayList<>();
        try {
            if (conector() == true) {

                String queryBBDD = "select id from tfg.formulario where tipo='"+tipo+"' and (idUsuario= '"+idUsuario+"' or idUsuario is null);";


                try {
                   ResultSet rS = createStatement.executeQuery(queryBBDD);



                    while (rS.next()) {
                        idArrayFormularios.add(rS.getString("formulario.id"));

                    }
                    for (String idFormulario:idArrayFormularios) {
                        String queryBBDD1 = "select idRespuesta from tfg.formulariorespuesta where idFormulario= '"+idFormulario+"';";
                        ResultSet  rS1 = createStatement.executeQuery(queryBBDD1);
                        while (rS1.next()) {
                            idArrayRespuestas.add(rS1.getString("formulariorespuesta.idRespuesta"));

                        }
                    }
                    for (String idFormulario:idArrayFormularios) {

                        createStatement.executeUpdate("delete from tfg.formulariorespuesta where idFormulario= '"+idFormulario+"';");
                        createStatement.executeUpdate("delete from tfg.formulario where id= '"+idFormulario+"';");
                    }

                    for (String idRespuesta:idArrayRespuestas) {

                        createStatement.executeUpdate("delete from tfg.respuesta where respuesta.id= "+idRespuesta+";");
                    }



                } catch (SQLException ex) {
                    Logger.getLogger(FormularioBBDD.class.getName()).log(Level.SEVERE, null, ex);
                }


            }

        } catch (SQLException ex) {
            Logger.getLogger(FormularioBBDD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FormularioBBDD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return valor;
    }
    public boolean deleteRespuestaByUser(int idUsuario)throws SQLException, ClassNotFoundException{
        boolean valor= false;
        try {
            deleteRespuestaByUsuarioAndtipo(idUsuario,"C");
            deleteRespuestaByUsuarioAndtipo(idUsuario,"T");
        }catch (Exception ex) {
            Logger.getLogger(FormularioBBDD.class.getName()).log(Level.SEVERE, null, ex);
        }
        con.close();
        return valor;
    }
    
    public boolean deleteRespuesta() throws SQLException, ClassNotFoundException {
        boolean valor= false;
        try {
            if (conector() == true) {

                String queryBBDD = "truncate table tfg.respuesta;";
                String queryBBDD1 = "truncate table tfg.formulariorespuesta;";

                try {
                    createStatement.executeUpdate(queryBBDD);
                    createStatement.executeUpdate(queryBBDD1);
                    valor = true;
                    return valor;
                } catch (SQLException ex) {
                    Logger.getLogger(FormularioBBDD.class.getName()).log(Level.SEVERE, null, ex);
                }

                try {

                    con.close();
                } catch (SQLException ex) {
                    Logger.getLogger(FormularioBBDD.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            else{

            }
        } catch (SQLException ex) {
            Logger.getLogger(FormularioBBDD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(FormularioBBDD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return valor;
    }
}
