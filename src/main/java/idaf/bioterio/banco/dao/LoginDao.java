/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package idaf.bioterio.banco.dao;

import javax.ejb.Stateless;
import idaf.bioterio.banco.model.Login;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


/**
 *
 * @author Idaf
 */
@Stateless
public class LoginDao extends AbstractDAO<Login>{

 @PersistenceContext(unitName = "Bioterio_PU")
    private EntityManager em;

    public LoginDao() {
        super(Login.class);
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
