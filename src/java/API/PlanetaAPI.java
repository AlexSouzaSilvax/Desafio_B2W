/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package API;

import Planeta.PlanetaBean;
import Planeta.PlanetaService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author homer
 */
@Path("/planetas")
public class PlanetaAPI {

    @Context
    private UriInfo context;

    PlanetaService planetaService = new PlanetaService();
    PlanetaBean planetaBean = new PlanetaBean();

    @GET
    @Produces("application/json")
    @Path("/listar")
    public Response listar() {
        Gson gson = new GsonBuilder().setDateFormat("dd-MM-yyyy'T'HH:mm:ss").create();
        return Response.status(200).entity(gson.toJson(planetaService.listar())).header("result", "true").header("Access-Control-Allow-Origin", "*").build();
    }

    @GET
    @Produces("application/json")
    @Path("/buscarPorNome")
    public Response buscarPorNome(@HeaderParam("nome") String nome) {
        Gson gson = new GsonBuilder().setDateFormat("dd-MM-yyyy'T'HH:mm:ss").create();
        return Response.status(200).entity(gson.toJson(planetaService.buscarPorNome(nome))).header("result", "true").header("Access-Control-Allow-Origin", "*").build();
    }

    @GET
    @Produces("application/json")
    @Path("/buscarPorId")
    public Response buscarPorId(@HeaderParam("id") String id) {
        Gson gson = new GsonBuilder().setDateFormat("dd-MM-yyyy'T'HH:mm:ss").create();
        return Response.status(200).entity(gson.toJson(planetaService.buscarPorId(id))).header("result", "true").header("Access-Control-Allow-Origin", "*").build();
    }

    @POST
    @Produces("application/json")
    @Path("/novo")
    public Response inserir(String pJson) {
        Gson gson = new GsonBuilder().setDateFormat("dd-MM-yyyy'T'HH:mm:ss").create();
        planetaBean = (PlanetaBean) gson.fromJson(pJson, PlanetaBean.class);
        planetaService.inserir(planetaBean);
        return Response.status(200).header("result", "true").header("msg", "Planeta adicionado com sucesso").header("Access-Control-Allow-Origin", "*").build();
    }

    @GET
    @Produces("application/json")
    @Path("/remover")
    public Response remover(@HeaderParam("id") String id) {
        planetaService.remover(id);
        return Response.status(200).header("result", "true").header("msg", "Planeta removido com sucesso").header("Access-Control-Allow-Origin", "*").build();
    }

}
