/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.EspecieDao;
import model.Especie;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Idaf
 */
@Path("especie")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public class EspecieRest extends AbstractRest<Especie, EspecieDao> {
    
    @EJB
    private EspecieDao especieDao;

    @Override
    public EspecieDao getDao() {
        return especieDao;
    }
    
}
