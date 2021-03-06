/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.RacasDao;
import model.Racas;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Idaf
 */
@Path("raca")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public class RacasRest extends AbstractRest<Racas, RacasDao> {
    
    @EJB
    private RacasDao loginDao;

    @Override
    public RacasDao getDao() {
        return loginDao;
    }
    
}
