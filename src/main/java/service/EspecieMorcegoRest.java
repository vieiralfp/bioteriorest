/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.EspecieDao;
import dao.EspecieMorcegoDao;
import model.Especiemorcego;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Idaf
 */
@Path("especiemorcego")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public class EspecieMorcegoRest extends AbstractRest<Especiemorcego, EspecieMorcegoDao> {
    
    @EJB
    private EspecieMorcegoDao especieMorcegoDao;

    @Override
    public EspecieMorcegoDao getDao() {
        return especieMorcegoDao;
    }
    
}
