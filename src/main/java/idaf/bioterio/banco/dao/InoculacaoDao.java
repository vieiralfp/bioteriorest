/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package idaf.bioterio.banco.dao;

import idaf.bioterio.banco.model.Inoculacao;
import java.util.ArrayList;
import java.util.List;
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
public class InoculacaoDao extends AbstractDAO<Inoculacao> {

    @PersistenceContext(unitName = "Bioterio_PU")
    private EntityManager em;

    public InoculacaoDao() {
        super(Inoculacao.class);
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }
    
    public List<Inoculacao> listaInoculcaoPorNumeroAnoAmostra(int namostra, int ano){
        
        TypedQuery<Inoculacao> tq = em.createQuery("Select i From Inoculacao i Inner Join i.principal As p Where p.namostra = :namostra And (p.dataentrada BETWEEN :inicio And :fim)", Inoculacao.class);
        tq.setParameter("namostra", namostra);
        tq.setParameter("inicio", Util.inicio(ano));
        tq.setParameter("fim", Util.fim(ano));
        
        try{
            return tq.getResultList();
        }catch(Exception ex){
            Logger.getLogger(PrincipalDao.class.getName()).log(Level.SEVERE, null, ex);
            return new ArrayList<>();
        }
    }
    
}
