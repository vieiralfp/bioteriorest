/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package idaf.bioterio.banco.dao;

import idaf.bioterio.banco.model.Principal;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import util.Util;

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
    
    public Principal getPrincipalNumeroRegistro(int nregistro, int ano){
        
        
        TypedQuery<Principal> tq = em.createQuery("Select p From Principal p Where p.namostra = :namostra And (p.dataentrada BETWEEN :inicio And :fim)", Principal.class);
        tq.setParameter("namostra", nregistro);
        tq.setParameter("inicio", Util.inicio(ano));
        tq.setParameter("fim", Util.fim(ano));
        
        try{
            return tq.getSingleResult();
        }catch(Exception ex){
            Logger.getLogger(PrincipalDao.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
    }
    
}
