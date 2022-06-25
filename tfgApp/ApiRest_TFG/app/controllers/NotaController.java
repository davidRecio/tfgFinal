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
import java.util.ArrayList;

public class NotaController extends Controller {

    private static final Logger logger = LoggerFactory.getLogger("controller");
    public Result create(Http.Request request, int idUsuarios) throws SQLException, ClassNotFoundException {
        System.out.println("Información");
        System.out.println(request.body());
        JsonNode json = request.body().asJson();
        if (json == null) {
            return badRequest(ApplicationUtil.createResponse("Expecting JSON data", false));
        }
        logger.debug("In NotaController.create(), input is: {}", json.toString());
        Nota nota = NotaBBDD.getInstance().addNota(Json.fromJson(json, Nota.class),idUsuarios);
        JsonNode jsonObject = Json.toJson(nota);
        return created(ApplicationUtil.createResponse(jsonObject, true));
    }

    public Result retrieve(Http.Request request,int idUsuarios, int id) {
        logger.debug("In NotaController.retrieve(), retrieve usuario with id: {}", idUsuarios);
        Nota result = NotaBBDD.getInstance().getNota(idUsuarios,id);
        if (result == null) {

            return notFound(ApplicationUtil.createResponse("Notas with userId:" + idUsuarios + " not found", false));

        }



        else {
            JsonNode jsonObjects = Json.toJson(result);
            logger.debug("In NotaController.retrieve(), result is: {}", jsonObjects.toString());
            return ok(ApplicationUtil.createResponse(jsonObjects, true));

        }

    }

    public Result listNotasByResultado(Http.Request request,int idUsuarios) {
        ArrayList<Nota> result = NotaBBDD.getInstance().getNota(idUsuarios);
        logger.debug("In NotaController.listNotasByResultado(), result is: {}", result.toString());
        if (result.isEmpty()) {

            return notFound(ApplicationUtil.createResponse("Notas is empty", false));

        } else {

            JsonNode jsonData = Json.toJson(result);

            return ok(ApplicationUtil.createResponse(jsonData, true));

        }
    }
    public Result getAllNotas(Http.Request request) {
        ArrayList<Nota> result = NotaBBDD.getInstance().getNota();
        logger.debug("In NotaController.getAllNotas(), notas is: {}", result.toString());
        if (result.isEmpty()) {

            return notFound(ApplicationUtil.createResponse("Notas is empty", false));

        } else {

            JsonNode jsonData = Json.toJson(result);

            return ok(ApplicationUtil.createResponse(jsonData, true));

        }
    }

    public Result update(Http.Request request, int idUsuarios, int id) throws SQLException, ClassNotFoundException {

        JsonNode json = request.body().asJson();
        Nota nota;
        if (json == null) {
            return badRequest(ApplicationUtil.createResponse("Expecting Json data", false));
        }
        nota = NotaBBDD.getInstance().updateNota(Json.fromJson(json, Nota.class),idUsuarios, id);
        logger.debug("In NotaController.update(), usuario is: {}", nota);
        if (nota == null) {
            return notFound(ApplicationUtil.createResponse("Nota not found", false));
        }

        JsonNode jsonObject = Json.toJson(nota);
        return ok(ApplicationUtil.createResponse(jsonObject, true));
    }

    public Result delete(Http.Request request,int idUsuario) throws SQLException, ClassNotFoundException {
        logger.debug("In NotaController.retrieve(), delete Nota");
        if (!NotaBBDD.getInstance().deleteNota(idUsuario)) {
            return notFound(ApplicationUtil.createResponse("Notas for usuarioId= "+idUsuario+" are empty", false));
        }
        return ok(ApplicationUtil.createResponse("All Notas are deleted", true));
    }
    public Result deleteAll(Http.Request request) throws SQLException, ClassNotFoundException {
        logger.debug("In NotaController.retrieve(), delete Nota");
        if (!NotaBBDD.getInstance().deleteNota()) {
            return notFound(ApplicationUtil.createResponse("Notas  are empty", false));
        }
        return ok(ApplicationUtil.createResponse("All Notas are deleted", true));
    }
    public Result deleteById(Http.Request request,int idUsuario,int id) throws SQLException, ClassNotFoundException {
        logger.debug("In ResultadoController.retrieve(), delete Nota with id: {}", idUsuario,id);
        if (!NotaBBDD.getInstance().deleteNota(idUsuario,id)) {
            return notFound(ApplicationUtil.createResponse("Usuario with id:"+idUsuario+"  and Nota with id:" + id + " not found", false));
        }
        return ok(ApplicationUtil.createResponse("Usuario with id:"+idUsuario+" and Nota with id:" + id +" deleted", true));
    }



}
