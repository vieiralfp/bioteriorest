/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package idaf.bioterio.banco.model.service;

import idaf.bioterio.banco.dao.ObservacaoCamundongoDao;
import idaf.bioterio.banco.model.ObservacaoCamundongo;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Idaf
 */
@Path("observacao")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public class ObservacaoCamundongoRest extends AbstractRest<ObservacaoCamundongo, ObservacaoCamundongoDao>{
    
    @EJB
    ObservacaoCamundongoDao dao;

    @Override
    public ObservacaoCamundongoDao getDao() {
        return dao;
    }
    
}
