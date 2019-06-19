/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.AbstractDAO;
import java.util.List;
import javax.annotation.security.PermitAll;
import javax.annotation.security.RolesAllowed;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Idaf
 * @param <T>
 * @param <E>
 */
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
@PermitAll
public abstract class AbstractRest<T, E extends AbstractDAO<T>> {
    
      
    public abstract E getDao();

    @POST    
    public T create(T entity) {
        getDao().create(entity);
        return entity;
    }

    @PUT
    @Path("{id}")
    public void edit(@PathParam("id") Long id, T entity) {
        getDao().edit(entity);
    }

    @DELETE
    @Path("{id}")
    @RolesAllowed({"Administrador"})
    public void remove(@PathParam("id") Long id) {
        getDao().remove(id);
    }

    @GET
    @Path("{id}")
    public Response find(@PathParam("id") Long id) {
        return Response.ok(getDao().find(id)).build();
    }

    @GET
    public Response findAll() {
        return Response.ok(getDao().findAll()).build();
    }

    @GET
    @Path("{from}/{to}")
    public Response findRange(@PathParam("from") Long from, @PathParam("to") Long to) {
        return Response.ok(getDao().findRange(new int[]{from.intValue(), to.intValue()})).build();
    }

    @GET
    @Path("count")
    public String countREST() {
        return String.valueOf(getDao().count());
    }

  

    
}
