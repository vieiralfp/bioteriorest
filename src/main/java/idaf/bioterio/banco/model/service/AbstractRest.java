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
    public void create(T entity) {
        getDao().create(entity);
    }

    @PUT
    @Path("{id}")
    public void edit(@PathParam("id") Integer id, T entity) {
        getDao().edit(entity);
    }

    @DELETE
    @Path("{id}")
    public void remove(@PathParam("id") Integer id) {
        getDao().remove(getDao().find(id));
    }

    @GET
    @Path("{id}")
    public T find(@PathParam("id") Integer id) {
        return getDao().find(id);
    }

    @GET
    public List<T> findAll() {
        return getDao().findAll();
    }

    @GET
    @Path("{from}/{to}")
    public List<T> findRange(@PathParam("from") Integer from, @PathParam("to") Integer to) {
        return getDao().findRange(new int[]{from, to});
    }

    @GET
    @Path("count")
    public String countREST() {
        return String.valueOf(getDao().count());
    }

  

    
}
