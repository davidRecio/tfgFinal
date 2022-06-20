package controllers;

import Beans.Nota;
import Beans.Recomendacion;
import com.fasterxml.jackson.databind.JsonNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Result;
import services.NotaBBDD;
import services.RecomendacionBBDD;
import utils.ApplicationUtil;

import java.util.ArrayList;

public class RecomendacionController extends Controller {
    private static final Logger logger = LoggerFactory.getLogger("controller");
    public Result retrieve(Http.Request request,int idUsuarios,int idResultado) {
        logger.debug("In RecomendacionController.retrieve(), retrieve usuario with id: {}", idUsuarios);
        ArrayList<Recomendacion> result = RecomendacionBBDD.getInstance().getRecomendacion(idResultado);
        if (result == null) {

            return notFound(ApplicationUtil.createResponse("Recomendacion with userId:" + idUsuarios + "and resultId:"+idResultado+" not found", false));

        }



        else {
            JsonNode jsonObjects = Json.toJson(result);
            logger.debug("In RecomendacionController.retrieve(), result is: {}", jsonObjects.toString());
            return ok(ApplicationUtil.createResponse(jsonObjects, true));

        }

    }
    public Result getAllRecomendaciones(Http.Request request) {
        logger.debug("In RecomendacionController.retrieve(), retrieve usuario with id: {}");
        ArrayList<Recomendacion> result = RecomendacionBBDD.getInstance().getRecomendacion();
        if (result == null) {

            return notFound(ApplicationUtil.createResponse("Recomendacion is empty", false));

        }



        else {
            JsonNode jsonObjects = Json.toJson(result);
            logger.debug("In RecomendacionController.retrieve(), result is: {}", jsonObjects.toString());
            return ok(ApplicationUtil.createResponse(jsonObjects, true));

        }

    }

}
