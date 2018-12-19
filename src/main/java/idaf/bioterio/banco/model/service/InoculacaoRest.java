/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package idaf.bioterio.banco.model.service;

import idaf.bioterio.banco.dao.InoculacaoDao;
import idaf.bioterio.banco.model.Inoculacao;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Idaf
 */
@Path("inoculacao")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public class InoculacaoRest extends AbstractRest<Inoculacao, InoculacaoDao>{

    @EJB
    InoculacaoDao dao;
    
    @Override
    public InoculacaoDao getDao() {
        return dao;
    }
    
}