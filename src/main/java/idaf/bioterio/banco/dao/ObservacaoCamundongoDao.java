/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package idaf.bioterio.banco.dao;

import idaf.bioterio.banco.model.ObservacaoCamundongo;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Idaf
 */
@Stateless
public class ObservacaoCamundongoDao extends AbstractDAO<ObservacaoCamundongo>{
    
    @PersistenceContext(unitName = "Bioterio_PU")
    private EntityManager em;

    public ObservacaoCamundongoDao() {
        super(ObservacaoCamundongo.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
