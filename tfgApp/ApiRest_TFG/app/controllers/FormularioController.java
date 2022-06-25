package controllers;

import Beans.Formulario;
import Beans.Usuario;
import com.fasterxml.jackson.databind.JsonNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Result;
import services.FormularioBBDD;
import services.UsuarioBBDD;
import utils.ApplicationUtil;

import java.sql.SQLException;
import java.util.ArrayList;

public class FormularioController extends Controller {
    private static final Logger logger = LoggerFactory.getLogger("controller");
    public Result insertRespuestas(Http.Request request,int idUsuarios,String tipo) throws SQLException, ClassNotFoundException {

        JsonNode json = request.body().asJson();
        if (json == null) {
            return badRequest(ApplicationUtil.createResponse("Expecting JSON data", false));
        }
        logger.debug("In FormularioController.create(), input is: {}", json.toString());
        Formulario formulario = FormularioBBDD.getInstance().addRespuestas(Json.fromJson(json, Formulario.class),idUsuarios,tipo);
        JsonNode jsonObject = Json.toJson(formulario);
        return created(ApplicationUtil.createResponse(jsonObject, true));
    }

    public Result retrieve(Http.Request request,int idUsuarios,String tipo) {
        logger.debug("In FormularioController.retrieve(), retrieve Formulario with usuario with id: {}", idUsuarios);
        Formulario result = FormularioBBDD.getInstance().getformulario(idUsuarios,tipo);
        if (result == null) {

            return notFound(ApplicationUtil.createResponse("Formulario with usuario with Id:" + idUsuarios + " not found", false));

        }



        else {
            JsonNode jsonObjects = Json.toJson(result);
            logger.debug("In FormularioController.retrieve(), result is: {}", jsonObjects.toString());
            return ok(ApplicationUtil.createResponse(jsonObjects, true));

        }
    }





    public Result deleteRespuestasByUsuario(Http.Request request,int idUsuarios) throws SQLException, ClassNotFoundException {
        logger.debug("In FormularioController.retrieve(), delete Resultados");
        if (!FormularioBBDD.getInstance().deleteRespuestaByUser(idUsuarios)) {
            return notFound(ApplicationUtil.createResponse("Respuestas  are empty", false));
        }
        return ok(ApplicationUtil.createResponse("All Respuestas are deleted", true));
    }


}
