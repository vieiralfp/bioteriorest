/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.MunicipioDao;
import model.Municipios;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Idaf
 */
@Path("municipio")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public class MunicipioRest extends AbstractRest<Municipios, MunicipioDao> {
    
    @EJB
    private MunicipioDao municipioDao;

    @Override
    public MunicipioDao getDao() {
        return municipioDao;
    }
    
}
