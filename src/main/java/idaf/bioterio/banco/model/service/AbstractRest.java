/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package idaf.bioterio.banco.model.service;

import idaf.bioterio.banco.dao.AbstractDAO;
import java.util.List;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

/**
 *
 * @author Idaf
 * @param <T>
 * @param <E>
 */

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
    public void remove(@PathParam("id") Long id) {
        getDao().remove(getDao().find(id));
    }

    @GET
    @Path("{id}")
    public T find(@PathParam("id") Long id) {
        return getDao().find(id);
    }

    @GET
    public List<T> findAll() {
        return getDao().findAll();
    }

    @GET
    @Path("{from}/{to}")
    public List<T> findRange(@PathParam("from") Long from, @PathParam("to") Long to) {
        return getDao().findRange(new int[]{from.intValue(), to.intValue()});
    }

    @GET
    @Path("count")
    public String countREST() {
        return String.valueOf(getDao().count());
    }

  

    
}
