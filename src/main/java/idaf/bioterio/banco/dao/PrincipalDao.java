/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package idaf.bioterio.banco.dao;

import idaf.bioterio.banco.model.Principal;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Idaf
 */
@Stateless
public class PrincipalDao extends AbstractDAO<Principal>{

    @PersistenceContext(unitName = "Bioterio_PU")
    private EntityManager em;

    public PrincipalDao() {
        super(Principal.class);
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
