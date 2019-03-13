/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package idaf.bioterio.banco.dao;

import idaf.bioterio.banco.model.Inoculacao;
import idaf.bioterio.banco.model.ObservacaoCamundongo;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

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
    
    public List<ObservacaoCamundongo> getListObservacaoCamundongoPorInoculacao(Long inoculacaoID){
        TypedQuery<ObservacaoCamundongo> tq = em.createQuery("Select o From ObservacaoCamundongo o Where o.inoculacao.id = :inoculacaoID Order By O.dataObservacao", ObservacaoCamundongo.class);
        tq.setParameter("inoculacaoID", inoculacaoID);
        try{
            return tq.getResultList();
        }
        catch(Exception ex){
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
            return new ArrayList<>();
        }
    }
    
}
