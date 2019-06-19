/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.InoculacaoDao;
import model.Inoculacao;
import java.util.Date;
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
@Path("inoculacao")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
@PermitAll
public class InoculacaoRest extends AbstractRest<Inoculacao, InoculacaoDao>{

    @EJB
    InoculacaoDao dao;
    
    @Override
    public InoculacaoDao getDao() {
        return dao;
    }
    
    @GET
    @Path("namostra/{namostra}/{ano}")
    public Response listaInoculcaoPorNumeroAnoAmostra(@PathParam("namostra") Integer namostra, @PathParam("ano") Integer ano){
        return Response.ok().status(Response.Status.OK).entity(dao.listaInoculcaoPorNumeroAnoAmostra(namostra, ano)).build();
    }
    
    @GET
    @Path("seisdias/{data}")
    public Response listaInoculcaoSeisDias(@PathParam("data") long data){
        Date d = new Date( data);        
        return Response.ok(dao.listaSeisDias(d)).build();
    }
    
    @GET
    @Path("finalizacao/{data}")
    public Response listaFinalizacao(@PathParam("data") long data){
        Date d = new Date( data);        
        return Response.ok(dao.listaFinalizacoes(d)).build();
    }
    
    @GET
    @Path("naofinalizada/{data}")
    public Response listaInoculacaoNaoFinalizada(@PathParam("data") long data){
        Date d = new Date( data);        
        List<Inoculacao> lista = dao.listaInoculacaoNaoFinalizada(d);
        return Response.ok(lista).build();
    }
    
    @GET
    @Path("next/{id}")
    public Response nextInoculacao(@PathParam("id") long id){
        try{
            return Response.ok(dao.nextInoculacao(id)).build();        
        }catch(Exception ex){
            return Response.status(Response.Status.NOT_FOUND).entity("Não encontrado").build();
        }
    }
    
    @GET
    @Path("previous/{id}")
    public Response previousInoculacao(@PathParam("id") long id){
        try{
            return Response.ok(dao.previousInoculacao(id)).build();        
        }catch(Exception ex){
            return Response.status(Response.Status.NOT_FOUND).entity("Não encontrado").build();
        }
    }
    
}
