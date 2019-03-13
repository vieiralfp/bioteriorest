/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package idaf.bioterio.banco.model.service;

import idaf.bioterio.banco.dao.PrincipalDao;
import idaf.bioterio.banco.model.Principal;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

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
    public Principal getPrincipalNumeroRegistro(@PathParam("namostra") Integer namostra, @PathParam("ano") Integer ano){
        return daoPrincipal.getPrincipalNumeroRegistro(namostra, ano);
    }
}
