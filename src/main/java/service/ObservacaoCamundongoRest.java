/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.ObservacaoCamundongoDao;
import model.ObservacaoCamundongo;
import java.util.List;
import javax.annotation.security.PermitAll;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Idaf
 */
@Path("observacao")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
@PermitAll
public class ObservacaoCamundongoRest extends AbstractRest<ObservacaoCamundongo, ObservacaoCamundongoDao>{
    
    @EJB
    ObservacaoCamundongoDao dao;

    @Override
    public ObservacaoCamundongoDao getDao() {
        return dao;
    }
    
    @GET
    @Path("listaobservacaoporinoculacao/{id}")
    public Response getObsCamundongoPorInoculacao(@PathParam("id") Long id){
        return Response.ok(dao.getListObservacaoCamundongoPorInoculacao(id)).build();
    }
    
}
