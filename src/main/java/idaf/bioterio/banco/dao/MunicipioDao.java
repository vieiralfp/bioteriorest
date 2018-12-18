/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package idaf.bioterio.banco.dao;

import idaf.bioterio.banco.model.Municipios;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Idaf
 */
@Stateless
public class MunicipioDao extends AbstractDAO<Municipios>{
    
    @PersistenceContext(unitName = "Bioterio_PU")
    private EntityManager em;

    public MunicipioDao() {
        super(Municipios.class);
    }

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
}
