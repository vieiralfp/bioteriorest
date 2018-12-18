/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package idaf.bioterio.banco.model.service;

import idaf.bioterio.banco.dao.LoginDao;
import idaf.bioterio.banco.model.Login;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Idaf
 */
@Path("login")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public class LoginRest extends AbstractRest<Login, LoginDao> {
    
    @EJB
    private LoginDao loginDao;

    @Override
    public LoginDao getDao() {
        return loginDao;
    }
    
}
