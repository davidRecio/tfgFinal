package controllers;

import Beans.Nota;
import com.fasterxml.jackson.databind.JsonNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Result;
import services.NotaBBDD;

import utils.ApplicationUtil;

import java.sql.SQLException;

public class NotaController extends Controller {
    private static final Logger logger = LoggerFactory.getLogger("controller");
    public Result create(Http.Request request, int idUsuarios, int idResultado) throws SQLException, ClassNotFoundException {
        System.out.println("Información");
        System.out.println(request.body());
        JsonNode json = request.body().asJson();
        if (json == null) {
            return badRequest(ApplicationUtil.createResponse("Expecting JSON data", false));
        }
        logger.debug("In ResultadoController.create(), input is: {}", json.toString());
        Nota nota = NotaBBDD.getInstance().addNota(Json.fromJson(json, Nota.class),idUsuarios,idResultado);
        JsonNode jsonObject = Json.toJson(nota);
        return created(ApplicationUtil.createResponse(jsonObject, true));
    }
}
