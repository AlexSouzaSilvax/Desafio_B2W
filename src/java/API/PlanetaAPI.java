/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package API;

import Planeta.PlanetaBean;
import Planeta.PlanetaService;
import com.google.gson.Gson;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.core.MediaType;

/**
 * REST Web Service
 *
 * @author homer
 */
@Path("/planeta")
public class PlanetaAPI {

    @Context
    private UriInfo context;

    PlanetaService planetaService = new PlanetaService();

    /**
     * Creates a new instance of API
     */
    public PlanetaAPI() {
    }

    /**
     * Retrieves representation of an instance of Planeta.PlanetaAPI
     *
     * @return an instance of java.lang.String
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getJson() {
        Gson gson = new Gson();
        return gson.toJson(planetaService.listar());
    }
    
    

    /**
     * PUT method for updating or creating an instance of PlanetaAPI
     *
     * @param content representation for the resource
     */
    @PUT
    @Consumes(MediaType.APPLICATION_JSON)
    public void putJson(String content) {
    }
}
