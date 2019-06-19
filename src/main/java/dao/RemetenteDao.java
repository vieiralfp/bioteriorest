/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import javax.ejb.Stateless;
import model.Remetente;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


/**
 *
 * @author Idaf
 */
@Stateless
public class RemetenteDao extends AbstractDAO<Remetente>{

 @PersistenceContext(unitName = "Bioterio_PU")
    private EntityManager em;

    public RemetenteDao() {
        super(Remetente.class);
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
