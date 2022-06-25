package controllers;

import Beans.Usuario;
import com.fasterxml.jackson.databind.JsonNode;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import play.libs.Json;
import play.mvc.Controller;
import play.mvc.Http;
import play.mvc.Result;
import services.UsuarioBBDD;
import utils.ApplicationUtil;


import java.sql.SQLException;
import java.util.ArrayList;



public class UsuarioController extends Controller  {
    private static final Logger logger = LoggerFactory.getLogger("controller");
    public Result create(Http.Request request) throws SQLException, ClassNotFoundException {

        JsonNode json = request.body().asJson();
        if (json == null) {
            return badRequest(ApplicationUtil.createResponse("Expecting JSON data", false));
        }
        logger.debug("In UsuarioController.create(), input is: {}", json.toString());
        Usuario usu = UsuarioBBDD.getInstance().addUsuario(Json.fromJson(json, Usuario.class));
        JsonNode jsonObject = Json.toJson(usu);
        return created(ApplicationUtil.createResponse(jsonObject, true));
    }


    public Result retrieve(Http.Request request, int id) {
        logger.debug("In UsuarioController.retrieve(), retrieve usuario with id: {}", id);
        Usuario result = UsuarioBBDD.getInstance().getUsuario(id);
        if (result == null) {

                return notFound(ApplicationUtil.createResponse("Usuario with id:" + id + " not found", false));

        }



         else {
            JsonNode jsonObjects = Json.toJson(result);
            logger.debug("In UsuarioController.retrieve(), result is: {}", jsonObjects.toString());
            return ok(ApplicationUtil.createResponse(jsonObjects, true));

        }

    }

    public Result listUsuarios(Http.Request request) {
        ArrayList<Usuario> result = UsuarioBBDD.getInstance().getAllUsuarios();
        logger.debug("In UsuarioController.listUsuarios(), result is: {}", result.toString());
        if (result.isEmpty()) {

            return notFound(ApplicationUtil.createResponse("Usuario is empty", false));

        } else {

            JsonNode jsonData = Json.toJson(result);

            return ok(ApplicationUtil.createResponse(jsonData, true));

        }
    }
/*
    public Result update(Http.Request request, int id) throws SQLException, ClassNotFoundException {
        logger.debug("In UsuarioController.update()");
        System.out.println("Información");
        System.out.println(request.body().asJson());
        JsonNode json = request.body().asJson();
        Usuario usu;
        if (json == null) {
            return badRequest(ApplicationUtil.createResponse("Expecting Json data", false));
        }
         usu = UsuarioBBDD.getInstance().updateUsuario(Json.fromJson(json, Usuario.class), id);
        logger.debug("In UsuarioController.update(), usuario is: {}", usu);
        if (usu == null) {
            return notFound(ApplicationUtil.createResponse("Usuario not found", false));
        }

        JsonNode jsonObject = Json.toJson(usu);
        return ok(ApplicationUtil.createResponse(jsonObject, true));
    }

 */
    public Result updatePass(Http.Request request, int id) throws SQLException, ClassNotFoundException {
        logger.debug("In UsuarioController.update()");
        JsonNode json = request.body().asJson();

        if (json == null) {
            return badRequest(ApplicationUtil.createResponse("Expecting Json data", false));
        }
        Usuario usu = UsuarioBBDD.getInstance().updatePassUsuario(Json.fromJson(json, Usuario.class), id);
        logger.debug("In UsuarioController.update(), usuario is: {}", usu);
        if (usu == null) {
            return notFound(ApplicationUtil.createResponse("Usuario not found", false));
        }

        JsonNode jsonObject = Json.toJson(usu);
        return ok(ApplicationUtil.createResponse(jsonObject, true));
    }



    public Result delete(Http.Request request,int id) throws SQLException, ClassNotFoundException {
        logger.debug("In UsuarioController.retrieve(), delete usuario with id: {}",id);
        if (!UsuarioBBDD.getInstance().deleteUsuario(id)) {
            return notFound(ApplicationUtil.createResponse("Usuario with id:" + id + " not found", false));
        }
        return ok(ApplicationUtil.createResponse("Usuario with id:" + id + " deleted", true));
    }
}
