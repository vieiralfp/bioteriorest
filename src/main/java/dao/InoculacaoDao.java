/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import model.Inoculacao;
import model.ObservacaoCamundongo;
import java.util.ArrayList;
import java.util.Date;
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

    @Override
    public void remove(Long id) {
        Inoculacao entity = em.find(Inoculacao.class, id);
        TypedQuery<ObservacaoCamundongo> tq = em.createQuery("Delete From ObservacaoCamundongo o Where o.inoculacao = :entity", ObservacaoCamundongo.class);
        tq.setParameter("entity", entity);
        tq.executeUpdate();
        em.remove(em.merge(entity));

    }
    
    public List<Inoculacao> listaInoculacoesAbertas() {
        TypedQuery<Inoculacao> tq = em.createQuery("SELECT i From Inoculacao i Where i.dataFinalizacao IS NULL", Inoculacao.class);
        return tq.getResultList();
    }
    /**
     * Lista as caixas que devem fazer a eutanásia de um camundongo após 
     * seis dias de inoculação
     * @param data
     * @return 
     */
    public List<Object[]> listaSeisDias(Date data){
        
       // Pesquisa deve retornar todas as inoculações que não tenham sido finalizadas,
       // que tenham mais de seis dias da data da inoculação
       // e que não tenha nenhum registro de eutanásia a partir do dia 6
       TypedQuery<Object[]> tq = em.createQuery(
                "SELECT DISTINCT(i.id), i.principal.registro From Inoculacao i "
                + "Join i.observacaocamundongolist AS o "
                + "Where i.dataFinalizacao IS NULL AND  "
                + "o.dataObservacao Between (i.dataInoculacao + 6 ) And :dataPesquisada "
                + "Group By i.id, i.principal.registro "
                + "HAVING Sum (o.eutanasias) = 0 Order By i.dataInoculacao, i.principal "
                       ,
               Object[].class);
       tq.setParameter("dataPesquisada", data);
    
        return tq.getResultList();
        
    }
    
    /**
     * Lista as caixas que devem ser finalizadas na data pesquisada 
     * @param data
     * @return 
     */
    public List<Object[]> listaFinalizacoes(Date data){
        
       // Pesquisa deve retornar todas as inoculações que não tenham sido finalizadas,
       // que tenham 30 dias ou mais de inoculação
       TypedQuery<Object[]> tq = em.createQuery("SELECT DISTINCT(i.id), i.principal.registro "
               + "From Inoculacao i "
               + "Where i.dataFinalizacao IS NULL AND "
               + "(Cast(:dataPesquisada AS Date) - Cast(i.dataInoculacao As Date) >= 30) "
               + "Order By i.dataInoculacao, i.principal ", Object[].class);
       tq.setParameter("dataPesquisada", data);
    
        return tq.getResultList();
        
    }
    
     /**
     * Lista todas as caixas não finalizadas
     * @param data
     * @return 
     */
    public List<Object[]> listaInoculacaoNaoFinalizada(Date data){
        
       TypedQuery<Object[]> tq = em.createQuery("SELECT Distinct(i.id), i.principal.registro "
               + "From Inoculacao i "
               + "Where i.dataFinalizacao IS NULL " 
               + "Order By i.dataInoculacao, i.principal ", Object[].class);
    
        return tq.getResultList();
        
    }
    
    public Inoculacao nextInoculacao(Long id) {
        TypedQuery<Long> tq = em.createQuery("Select MIN(i.id) From Inoculacao i Where i.id > :id", Long.class);
        tq.setParameter("id", id);
        Long lo = tq.getSingleResult();
        
        
        return  find(lo);
    }
    
       public Inoculacao previousInoculacao(Long id) {
        TypedQuery<Long> tq = em.createQuery("Select MAX(i.id) From Inoculacao i Where i.id < :id", Long.class);
        tq.setParameter("id", id);
        Long lo = tq.getSingleResult();
        
        
        return  find(lo);
    }

    @Override
    public void create(Inoculacao entity) {
        List<ObservacaoCamundongo> novaLista = new ArrayList<>();
        for(ObservacaoCamundongo o : entity.getObservacaocamundongolist()) {
            o.setInoculacao(entity);
        }
        super.create(entity); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void edit(Inoculacao entity) {
        for(ObservacaoCamundongo o : entity.getObservacaocamundongolist()) {
            o.setInoculacao(entity);
        }
        super.edit(entity); //To change body of generated methods, choose Tools | Templates.
    }
    
    
       
       
}
