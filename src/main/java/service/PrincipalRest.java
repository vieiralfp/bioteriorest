/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.PrincipalDao;
import model.Principal;
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
@Path("principal")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public class PrincipalRest extends AbstractRest<Principal, PrincipalDao> {
    
    @EJB
    private PrincipalDao daoPrincipal;

    @Override
    public PrincipalDao getDao() {
        return daoPrincipal;
    }
    
    @GET
    @Path("namostra/{namostra}/{ano}")
    public Response getPrincipalNumeroRegistro(@PathParam("namostra") Integer namostra, @PathParam("ano") Integer ano){
        return Response.ok(daoPrincipal.getPrincipalNumeroRegistro(namostra, ano)).build();
    }
}
