package controllers;

import Beans.Nota;
import Beans.Resultado;
import Beans.Usuario;
import com.fasterxml.jackson.databind.JsonNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Result;
import services.ResultadoBBDD;
import services.UsuarioBBDD;
import utils.ApplicationUtil;

import java.io.StringWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;
import java.util.TreeMap;

public class ResultadoController extends Controller {
    private static final Logger logger = LoggerFactory.getLogger("controller");
    public Result create(Http.Request request,int idUsuarios) throws SQLException, ClassNotFoundException {
        System.out.println("Información");
        System.out.println(request.body());
        JsonNode json = request.body().asJson();
        if (json == null) {
            return badRequest(ApplicationUtil.createResponse("Expecting JSON data", false));
        }
        logger.debug("In ResultadoController.create(), input is: {}", json.toString());
        Resultado resultado = ResultadoBBDD.getInstance().addResultado(Json.fromJson(json, Resultado.class),idUsuarios);
        JsonNode jsonObject = Json.toJson(resultado);
        return created(ApplicationUtil.createResponse(jsonObject, true));
    }
    public Result retrieve(Http.Request request,int idUsuarios, int id) {
        logger.debug("In ResultadoController.retrieve(), retrieve usuario with id: {}", idUsuarios);
        Resultado result = ResultadoBBDD.getInstance().getResultado(idUsuarios,id);
        if (result == null) {

            return notFound(ApplicationUtil.createResponse("Resultado with id:" + idUsuarios + " not found", false));

        }



        else {
            JsonNode jsonObjects = Json.toJson(result);
            logger.debug("In ResultadoController.retrieve(), result is: {}", jsonObjects.toString());
            return ok(ApplicationUtil.createResponse(jsonObjects, true));

        }

    }
    public Result listResultadosByUsuario(Http.Request request,int idUsuarios) {
        ArrayList<Resultado> result = ResultadoBBDD.getInstance().getResultado(idUsuarios);
        logger.debug("In ResultadoController.listResultadosByUsuario(), result is: {}", result.toString());
        if (result.isEmpty()) {

            return notFound(ApplicationUtil.createResponse("Resultado is empty", false));

        } else {

            JsonNode jsonData = Json.toJson(result);

            return ok(ApplicationUtil.createResponse(jsonData, true));

        }
    }
    public Result getAllResultados(Http.Request request) {
        ArrayList<Resultado> result = ResultadoBBDD.getInstance().getResultado();
        logger.debug("In ResultadoController.getAllResultados(), result is: {}", result.toString());
        if (result.isEmpty()) {

            return notFound(ApplicationUtil.createResponse("Resultado is empty", false));

        } else {

            JsonNode jsonData = Json.toJson(result);

            return ok(ApplicationUtil.createResponse(jsonData, true));

        }
    }
    public Result updateTipo(Http.Request request,int idUsuarios, int id) throws SQLException, ClassNotFoundException {
        logger.debug("In UsuarioController.update()");
        JsonNode json = request.body().asJson();

        if (json == null) {
            return badRequest(ApplicationUtil.createResponse("Expecting Json data", false));
        }
        Resultado resultado = ResultadoBBDD.getInstance().updateTipoResultadoByUsuario(Json.fromJson(json, Resultado.class),idUsuarios, id);
        logger.debug("In UsuarioController.update(), Resultado is: {}", resultado);
        if (resultado == null) {
            return notFound(ApplicationUtil.createResponse("Resultado not found", false));
        }

        JsonNode jsonObject = Json.toJson(resultado);
        return ok(ApplicationUtil.createResponse(jsonObject, true));
    }

    public Result delete(Http.Request request,int idUsuarios) throws SQLException, ClassNotFoundException {
        logger.debug("In ResultadoController.retrieve(), delete Resultados");
        if (!ResultadoBBDD.getInstance().deleteResultado(idUsuarios)) {
            return notFound(ApplicationUtil.createResponse("Resultados for userId= "+idUsuarios+" are empty", false));
        }
        return ok(ApplicationUtil.createResponse("All Resultado are deleted", true));
    }
    public Result deleteAll(Http.Request request) throws SQLException, ClassNotFoundException {
        logger.debug("In ResultadoController.retrieve(), delete Resultados");
        if (!ResultadoBBDD.getInstance().deleteResultado()) {
            return notFound(ApplicationUtil.createResponse("Resultados  are empty", false));
        }
        return ok(ApplicationUtil.createResponse("All Resultado are deleted", true));
    }
    public Result deleteById(Http.Request request,int idUsuarios,int id) throws SQLException, ClassNotFoundException {
        logger.debug("In ResultadoController.retrieve(), delete Resultado with id: {}", idUsuarios,id);
        if (!ResultadoBBDD.getInstance().deleteResultado(idUsuarios,id)) {
            return notFound(ApplicationUtil.createResponse("Resultado with id:" + id + " not found", false));
        }
        return ok(ApplicationUtil.createResponse("Resultado with id:" + id + " deleted", true));
    }

}
