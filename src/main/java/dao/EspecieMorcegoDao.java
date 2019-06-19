/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import model.Especie;
import model.Especiemorcego;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Idaf
 */
@Stateless
public class EspecieMorcegoDao extends AbstractDAO<Especiemorcego>{
    
    @PersistenceContext(unitName = "Bioterio_PU")
    private EntityManager em;

    public EspecieMorcegoDao() {
        super(Especiemorcego.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
