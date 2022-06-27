package Principal;

import Beans.Formulario;
import Beans.RespuestasFormulario;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Model {

   private final int[][] resultadoToulouse={
            {5,3,5,5,3,3,3,3},
            {5,3,4,3,6,4,1,4},
            {4,6,4,4,2,3,3,4},
            {2,6,3,3,5,4,4,3},
            {5,4,3,3,3,3,5,4},
            {3,2,4,3,8,3,4,3},
            {2,0,2,4,7,5,5,5},
            {4,2,5,2,4,4,4,5},
            {2,3,3,5,5,4,3,5},
            {2,2,5,3,6,4,2,6},
            {4,2,6,4,4,2,5,3},
            {5,2,3,5,4,4,5,2},
            {5,2,2,2,5,5,5,4},
            {3,6,4,4,1,1,6,5},
            {4,3,5,4,4,3,4,3},
            {3,2,4,5,6,4,3,3},
            {5,2,3,6,4,4,2,4},
            {4,3,4,2,4,5,4,4},
            {5,4,4,4,2,2,4,5},
            {2,3,5,4,6,4,4,2},
            {4,1,2,5,3,4,7,4},
            {3,4,4,2,5,2,4,6},
            {3,4,4,4,5,4,3,3},
            {4,4,4,4,4,4,3,3},
            {4,3,3,5,5,4,4,2},
            {5,2,4,5,4,4,3,3},
            {3,4,3,4,2,5,5,4},
            {5,3,4,3,3,4,3,5},
            {3,4,5,4,4,3,3,4},
            {5,2,4,5,3,4,4,3},
            {3,4,4,3,5,3,3,5},
            {5,4,4,4,3,3,4,3},
            {3,4,3,5,5,4,3,3},
            {4,3,3,3,3,6,4,4},
            {4,2,4,3,5,3,4,5},
            {3,3,3,4,4,4,5,4},
            {3,2,4,3,5,5,4,4},
            {4,3,4,4,4,3,4,4},
            {4,2,4,4,4,4,5,3},
            {4,1,3,3,6,4,5,4},
            {150,119,151,152,171,148,156,153}
            };

    public ArrayList<String> chasideResult(Formulario formulario){
        ArrayList<String> resultadoChaside= new ArrayList<>();

        int Administrativas_Contables_Int=0;
        int Humanisticas_Sociales_Int=0;
        int Artisticas_Int=0;
        int Medicina_CsSalud_Int=0;
        int Ingenieria_Computacion_Int=0;
        int DefensaSeguridad_Int=0;
        int CienciasExactas_Agrarias_Int=0;
        int Administrativas_Contables_Apt=0;
        int Humanisticas_Sociales_Apt=0;
        int Artisticas_Apt=0;
        int Medicina_CsSalud_Apt=0;
        int Ingenieria_Computacion_Apt=0;
        int DefensaSeguridad_Apt=0;
        int CienciasExactas_Agrarias_Apt=0;

        String resultadoInt="";
        String resultadoApt="";
        int numPregunta= 1;
        for (RespuestasFormulario rf: formulario.getRespuestasFormularioArray()) {


            if(rf.getValor().equals("S")){
                //intereses
                if(numPregunta==98 || numPregunta==12 || numPregunta==64 || numPregunta==53 || numPregunta==85 || numPregunta==1 || numPregunta==78 || numPregunta==20 || numPregunta==71 || numPregunta==91){
                    Administrativas_Contables_Int++;
                    if(Administrativas_Contables_Int>6){
                        resultadoInt="Administrativas_Contables,"+resultadoInt;
                    }
                }
                if(numPregunta==9 || numPregunta==34 || numPregunta==80 || numPregunta==25 || numPregunta==95 || numPregunta==67 || numPregunta==41 || numPregunta==74 || numPregunta==56 || numPregunta==89){
                    Humanisticas_Sociales_Int++;
                    if(Humanisticas_Sociales_Int>6){
                        resultadoInt="Humanisticas_Sociales,"+resultadoInt;
                    }
                }
                if(numPregunta==21 || numPregunta==45 || numPregunta==96 || numPregunta==57 || numPregunta==28 || numPregunta==11 || numPregunta==5 || numPregunta==3 || numPregunta==81 || numPregunta==36){
                    Artisticas_Int++;
                    if(Artisticas_Int>6){
                        resultadoInt="Artisticas,"+resultadoInt;
                    }
                }
                if(numPregunta==33 || numPregunta==92 || numPregunta==70 || numPregunta==8 || numPregunta==87 || numPregunta==62 || numPregunta==23 || numPregunta==44 || numPregunta==16 || numPregunta==52){
                    Medicina_CsSalud_Int++;
                    if(Medicina_CsSalud_Int>6){
                        resultadoInt="Medicina_CsSalud,"+resultadoInt;
                    }
                }
                if(numPregunta==75 || numPregunta==6 || numPregunta==19 || numPregunta==38 || numPregunta==60 || numPregunta==27 || numPregunta==83 || numPregunta==54 || numPregunta==47 || numPregunta==97){
                    Ingenieria_Computacion_Int++;
                    if(Ingenieria_Computacion_Int>6){
                        resultadoInt="Ingenieria_Computacion,"+resultadoInt;
                    }
                }
                if(numPregunta==84 || numPregunta==31 || numPregunta==48 || numPregunta==73 || numPregunta==5 || numPregunta==65 || numPregunta==14 || numPregunta==37 || numPregunta==58 || numPregunta==24){
                    DefensaSeguridad_Int++;
                    if(DefensaSeguridad_Int>6){
                        resultadoInt="DefensaSeguridad,"+resultadoInt;
                    }
                }
                if(numPregunta==77 || numPregunta==42 || numPregunta==88 || numPregunta==17 || numPregunta==93 || numPregunta==32 || numPregunta==68 || numPregunta==49 || numPregunta==35 || numPregunta==61){
                    CienciasExactas_Agrarias_Int++;
                    if(CienciasExactas_Agrarias_Int>6){
                        resultadoInt="CienciasExactas_Agrarias,"+resultadoInt;
                    }
                }

                //aptitudes

                if(numPregunta==15 || numPregunta==51 || numPregunta==2 || numPregunta==46 ){
                    Administrativas_Contables_Apt++;
                    if(Administrativas_Contables_Apt>2){
                        resultadoApt="Administrativas_Contables,"+resultadoApt;
                    }
                }
                if(numPregunta==63 || numPregunta==30 || numPregunta==72 || numPregunta==86 ){
                    Humanisticas_Sociales_Apt++;
                    if(Humanisticas_Sociales_Apt>2){
                        resultadoApt="Humanisticas_Sociales,"+resultadoApt;
                    }

                }
                if(numPregunta==22 || numPregunta==39 || numPregunta==76 || numPregunta==82 ){
                    Artisticas_Apt++;
                    if(Artisticas_Apt>2){
                        resultadoApt="Artisticas,"+resultadoApt;
                    }
                }
                if(numPregunta==69 || numPregunta==40 || numPregunta==29 || numPregunta==4 ){
                    Medicina_CsSalud_Apt++;
                    if(Medicina_CsSalud_Apt>2){
                        resultadoApt="Medicina_CsSalud,"+resultadoApt;
                    }
                }

                if(numPregunta==26 || numPregunta==59 || numPregunta==90 || numPregunta==10 ){
                    Ingenieria_Computacion_Apt++;
                    if(Ingenieria_Computacion_Apt>2){
                        resultadoApt="Ingenieria_Computacion,"+resultadoApt;
                    }
                }
                if(numPregunta==13 || numPregunta==66 || numPregunta==18 || numPregunta==43 ){
                  DefensaSeguridad_Apt++;
                    if(DefensaSeguridad_Apt>2){
                        resultadoApt="DefensaSeguridad,"+resultadoApt;
                    }
                }

                if(numPregunta==94 || numPregunta==7 || numPregunta==79 || numPregunta==55 ){
                    CienciasExactas_Agrarias_Apt++;
                    if(CienciasExactas_Agrarias_Apt>2){
                        resultadoApt="CienciasExactas_Agrarias,"+resultadoApt;
                    }
                }

            }
            numPregunta++;

        }

            //aptitudes
        try {
            resultadoChaside.add(resultadoApt.substring(0,resultadoApt.length()-1));
        }catch (Exception e){
            resultadoChaside.add(resultadoApt);
        }


        //intereses
        try {
            resultadoChaside.add(resultadoInt.substring(0,resultadoInt.length()-1));
        }catch (Exception e){
            resultadoChaside.add(resultadoInt);
        }



        return  resultadoChaside;
    }

    public String nivelConcentracion(Formulario formulario){
        String result ="";

        double CCTotal=0.0;
        double ICITotal=0.0;
        int IGAPTotal=0;
        int omisionTotal=0;
        int errorTotal=0;
        int aciertosTotales=0;
        String[] arrayFilas;
        //CC = A – E / A + O
        //IGAP= ACIERTOS – (ERRORES + OMISIONES)
        //ICI = ACIERTOS – ERRORES / RESPUESTAS X 100

        //Donde: A es acierto, E es error y O es omisión


        for (RespuestasFormulario rf: formulario.getRespuestasFormularioArray()) {


            arrayFilas= rf.getValor().split(";");


                    //Recorremos la primera columna de todas las filas -1 xq la ultima es el total
                    for(int i=0;i<resultadoToulouse.length-1;i++){

                       int respuestaUsuario =Integer.parseInt(arrayFilas[i]);
                        int respuestaCorrecta= resultadoToulouse[i][0];

                        if(respuestaUsuario<respuestaCorrecta){
                            omisionTotal=omisionTotal+(respuestaCorrecta-respuestaUsuario);
                        }

                        if(respuestaUsuario>respuestaCorrecta){
                            errorTotal=errorTotal+(respuestaUsuario-respuestaCorrecta);
                        }

                    }

            for(int i=0;i<resultadoToulouse[0].length;i++){
                aciertosTotales=aciertosTotales+ resultadoToulouse[resultadoToulouse.length-1][i];
            }


            CCTotal=(aciertosTotales-errorTotal)/(aciertosTotales-omisionTotal);
            IGAPTotal=aciertosTotales-(errorTotal-omisionTotal);
            ICITotal=((aciertosTotales-errorTotal)/39)*100;

            if (CCTotal>0.7){
                result="alto";
            } else if (CCTotal>0.49) {
                result="medio";
            }else {
                result="bajo";
            }


        }


        return result;

    }
}
