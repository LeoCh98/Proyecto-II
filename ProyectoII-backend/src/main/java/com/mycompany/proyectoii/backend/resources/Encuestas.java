package com.mycompany.proyectoii.backend.resources;

import com.mycompany.proyectoii.backend.logic.*;
import jakarta.annotation.security.PermitAll;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import java.util.*;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.DefaultValue;
import jakarta.ws.rs.NotFoundException;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.QueryParam;

/*
 * -----------------------------------------------------------------
 *
 * (c) 2023
 * 
 * @author Jean Paul Castillo Vives
 * @author Jorge Andrés Durán Campos
 * @author Leonardo Jesús Chaves Hernández
 * 
 * @version 1.0.0 2023-11-15
 * 
 * -----------------------------------------------------------------
 */

@Path("/encuestas")
@PermitAll
public class Encuestas {
    
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public ArrayList<Encuesta> find() throws Exception {
        return Service.instance().selectAllEncuestas();
    }
    
    @GET
    @Path("/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public ArrayList<Encuesta> findById(@PathParam("id") Integer id) throws Exception {
        try {
            return Service.instance().selectEncuestas(id);
        } catch (Exception ex) {
            throw new NotFoundException();
        }
    }
}