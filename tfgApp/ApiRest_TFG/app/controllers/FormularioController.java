package controllers;

import Beans.Formulario;
import com.fasterxml.jackson.databind.JsonNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Result;
import services.FormularioBBDD;
import utils.ApplicationUtil;

import java.sql.SQLException;

public class FormularioController extends Controller {
    private static final Logger logger = LoggerFactory.getLogger("controller");
    public Result create(Http.Request request,int idUsuarios) throws SQLException, ClassNotFoundException {

        JsonNode json = request.body().asJson();
        if (json == null) {
            return badRequest(ApplicationUtil.createResponse("Expecting JSON data", false));
        }
        logger.debug("In FormularioController.create(), input is: {}", json.toString());
        Formulario formulario = FormularioBBDD.getInstance().addFormulario(Json.fromJson(json, Formulario.class),idUsuarios);
        JsonNode jsonObject = Json.toJson(formulario);
        return created(ApplicationUtil.createResponse(jsonObject, true));
    }
    public Result retrieve(Http.Request request,int id) {
        logger.debug("In FormularioController.retrieve(), retrieve formulario with id: {}", id);
        Formulario result = FormularioBBDD.getInstance().getformulario(id);
        if (result == null) {

            return notFound(ApplicationUtil.createResponse("Formulario with Id:" + id + " not found", false));

        }



        else {
            JsonNode jsonObjects = Json.toJson(result);
            logger.debug("In FormularioController.retrieve(), result is: {}", jsonObjects.toString());
            return ok(ApplicationUtil.createResponse(jsonObjects, true));

        }

    }
    public Result deleteAllRespuestas(Http.Request request) throws SQLException, ClassNotFoundException {
        logger.debug("In FormularioController.retrieve(), delete Resultados");
        if (!FormularioBBDD.getInstance().deleteRespuesta()) {
            return notFound(ApplicationUtil.createResponse("Respuestas  are empty", false));
        }
        return ok(ApplicationUtil.createResponse("All Respuestas are deleted", true));
    }
    public Result deleteRespuestasByUsuario(Http.Request request,int idUsuarios) throws SQLException, ClassNotFoundException {
        logger.debug("In FormularioController.retrieve(), delete Resultados");
        if (!FormularioBBDD.getInstance().deleteRespuestaByUser(idUsuarios)) {
            return notFound(ApplicationUtil.createResponse("Respuestas  are empty", false));
        }
        return ok(ApplicationUtil.createResponse("All Respuestas are deleted", true));
    }
}
