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
    public Formulario addRespuestas(Formulario formulario,int idUsuario, String tipo) throws SQLException, ClassNotFoundException {
        Formulario formulario1 = new Formulario();
        int identificador= -1;
        ArrayList<RespuestasFormulario> listaidRespuestas;
        listaidRespuestas=formulario.getRespuestasFormularioArray();
        try{

        if (conector() == true) {


            int idFormulario= getformularioId(idUsuario,tipo);

            //comprueba que esixte
            if(idFormulario!=-1) {


                //comprobar si estan todas las respuestas
                //CHASIDE
                if (tipo.equals("C") && listaidRespuestas.size() == 97) {

                    for (RespuestasFormulario respuesta : listaidRespuestas) {

                        createStatement.executeUpdate("INSERT INTO tfg.respuesta (idPregunta, idFormulario, valor) VALUES (" + respuesta.getIdPregunta() + ", " + idFormulario + ", '" + respuesta.getValor() + "');");


                    }
                } //TOULOUSE
                else if (tipo.equals("T") && listaidRespuestas.size() < 6) {
                    for (RespuestasFormulario respuesta : listaidRespuestas) {

                        createStatement.executeUpdate("INSERT INTO tfg.respuesta (idPregunta,valor) VALUES ('" + respuesta.getIdPregunta() + "', '" + respuesta.getValor() + "');");


                    }
                }else {
                    formulario1=null;
                }

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

    public Formulario getformulario(int idUsuarios, String tipo) {
        Formulario formulario = new Formulario();
        ArrayList<PreguntasFormulario> preguntasFormulariosArray = new ArrayList<>();
        preguntasFormulariosArray= obtenerPeguntas(tipo);
        formulario.setTipo(tipo);
        if(preguntasFormulariosArray.isEmpty()==false){
            formulario.setPreguntasFormularioArray(preguntasFormulariosArray);

            try{
                formulario.setRespuestasFormularioArray(obtenerRespuestas(getformularioId(idUsuarios,tipo)));
            } catch (Exception e) {

            }
        }else {
            //ya que siempre tiene preguntas
            formulario=null;
        }



        return formulario;
    }



    public boolean deleteRespuestaByUsuarioAndtipo(int idUsuario, String tipo) throws SQLException, ClassNotFoundException {
        boolean valor= false;
        ArrayList<String>idArrayFormularios=new ArrayList<>();

        try {
            if (conector() == true) {

                String queryBBDD = "select idFormulario from tfg.formulario where tipo='"+tipo+"' and (idUsuario= "+idUsuario+" or idUsuario is null);";


                try {
                   ResultSet rS = createStatement.executeQuery(queryBBDD);



                    while (rS.next()) {
                        idArrayFormularios.add(rS.getString("formulario.idFormulario"));

                    }

                    for (String idFormulario:idArrayFormularios) {

                        createStatement.executeUpdate("delete from tfg.respuesta where idFormulario= "+idFormulario+";");
                        createStatement.executeUpdate("delete from tfg.formulario where id= "+idFormulario+";");
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
    


    private ArrayList<PreguntasFormulario> obtenerPeguntas(String tipo){
        ArrayList<PreguntasFormulario> preguntasFormulariosArray = new ArrayList<>();
        String queryBBDD;


        queryBBDD = "select pregunta.contenido, pregunta.imagen from tfg.pregunta where pregunta.tipo='"+tipo+"';";

        try {
            if(conector()==true){


                try {
                    rS = createStatement.executeQuery(queryBBDD);
                } catch (SQLException ex) {
                    Logger.getLogger(FormularioBBDD.class.getName()).log(Level.SEVERE, null, ex);
                }



                    try {

                        while (rS.next()) {
                            PreguntasFormulario preguntasFormulario = new PreguntasFormulario();



                            if(tipo.equals("T")){
                                preguntasFormulario.setContenido(rS.getString("pregunta.contenido")+". Escriba separado por ';' la cantidad de esta figura en cada fila");
                            }else{
                                preguntasFormulario.setContenido(rS.getString("pregunta.contenido"));
                            }
                            if(tipo.equals("T")){
                                preguntasFormulario.setImagen(rS.getString("pregunta.imagen"));
                            }else{
                                preguntasFormulario.setImagen("no posee imagen");
                            }
                            preguntasFormulario.setTipo(tipo);

                            preguntasFormulariosArray.add(preguntasFormulario);


                        }




                    } catch (SQLException ex) {
                        ex.printStackTrace();
                        Logger.getLogger(FormularioBBDD.class.getName()).log(Level.SEVERE, null, ex);
                    }




                }


        } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(FormularioBBDD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
            Logger.getLogger(FormularioBBDD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return preguntasFormulariosArray;
    }
    private ArrayList<RespuestasFormulario> obtenerRespuestas(int idFormulario){
        ArrayList<RespuestasFormulario> respuestasFormularioArrayList = new ArrayList<>();
        String queryBBDD;


        queryBBDD = "select respuesta.idPregunta, respuesta.idFormulario, respuesta.valor from tfg.respuesta where respuesta.idFormulario="+idFormulario+";";

        try {
            if(conector()==true){


                try {
                    rS = createStatement.executeQuery(queryBBDD);
                } catch (SQLException ex) {
                    Logger.getLogger(FormularioBBDD.class.getName()).log(Level.SEVERE, null, ex);
                }



                try {
                    int numPregunta=1; //para mostrar el numero de la pregunta
                    while (rS.next()) {
                        RespuestasFormulario respuestasFormulario = new RespuestasFormulario();

                        respuestasFormulario.setIdPregunta(Integer.parseInt(rS.getString("respuesta.idPregunta")));
                        respuestasFormulario.setIdFormulario(Integer.parseInt(rS.getString("respuesta.idFormulario")));
                        respuestasFormulario.setNumeroPregunta(numPregunta);
                        respuestasFormulario.setValor(rS.getString("respuesta.valor"));


                        respuestasFormularioArrayList.add(respuestasFormulario);
                        numPregunta++;

                    }




                } catch (SQLException ex) {
                    ex.printStackTrace();
                    Logger.getLogger(FormularioBBDD.class.getName()).log(Level.SEVERE, null, ex);
                }




            }


        } catch (SQLException ex) {
            ex.printStackTrace();
            Logger.getLogger(FormularioBBDD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
            Logger.getLogger(FormularioBBDD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return respuestasFormularioArrayList;
    }
    private int getformularioId(int idUsuarios, String tipo) {
        int idFormulario = -1;

        try {
            if (conector() == true) {
                String queryBBDD;

                queryBBDD = "select formulario.idFormulario from tfg.formulario where formulario.idUsuario=" + idUsuarios + " and formulario.tipo='"+tipo+"';";
                try {
                    rS = createStatement.executeQuery(queryBBDD);

                    while (rS.next()) {


                        idFormulario= Integer.parseInt(rS.getString("idFormulario"));



                    }
                } catch (SQLException ex) {
                    Logger.getLogger(FormularioBBDD.class.getName()).log(Level.SEVERE, null, ex);
                }
            }


        } catch (SQLException e) {

        } catch (ClassNotFoundException e) {

        }
        return idFormulario;
    }

}
