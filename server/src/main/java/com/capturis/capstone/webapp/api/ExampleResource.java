package com.capturis.capstone.webapp.api;

import com.capturis.capstone.webapp.bo.ExampleBO;
import com.capturis.capstone.webapp.models.Example;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Singleton
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
@Path("example")
public class ExampleResource {

    private final ExampleBO exampleBO;

    @Inject
    public ExampleResource(ExampleBO exampleBO) {
        this.exampleBO = exampleBO;
    }

    @POST
    @Path("/create")
    public Example createExample(Example example) {
        try {
            return exampleBO.createExampleModel(example);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @GET
    @Path("/{id}")
    public Example getById(@PathParam("id") int id) {
        try {
            return exampleBO.getById(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @PUT
    @Path("/update")
    public boolean updateExample(Example example) {
        try {
            return exampleBO.updateExample(example);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @DELETE
    @Path("/{id}")
    public boolean deleteExample(@PathParam("id") int id) {
        try {
            return exampleBO.deleteExample(id);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
