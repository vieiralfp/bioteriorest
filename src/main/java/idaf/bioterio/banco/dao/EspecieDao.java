/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package idaf.bioterio.banco.dao;

import idaf.bioterio.banco.model.Especie;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Idaf
 */
@Stateless
public class EspecieDao extends AbstractDAO<Especie>{
    
    @PersistenceContext(unitName = "Bioterio_PU")
    private EntityManager em;

    public EspecieDao() {
        super(Especie.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
