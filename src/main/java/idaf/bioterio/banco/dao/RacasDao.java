/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package idaf.bioterio.banco.dao;

import javax.ejb.Stateless;
import idaf.bioterio.banco.model.Racas;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


/**
 *
 * @author Idaf
 */
@Stateless
public class RacasDao extends AbstractDAO<Racas>{

 @PersistenceContext(unitName = "Bioterio_PU")
    private EntityManager em;

    public RacasDao() {
        super(Racas.class);
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
