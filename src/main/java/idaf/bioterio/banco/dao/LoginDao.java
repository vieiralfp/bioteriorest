/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package idaf.bioterio.banco.dao;

import javax.ejb.Stateless;
import idaf.bioterio.banco.model.Login;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;


/**
 *
 * @author Idaf
 */
@Stateless
public class LoginDao extends AbstractDAO<Login>{

 @PersistenceContext(unitName = "Bioterio_PU")
    private EntityManager em;

    public LoginDao() {
        super(Login.class);
    }
    
    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public List<Login> getLoginVeterinarios() {
        TypedQuery<Login> tq = em.createQuery("Select l From Login l Where l.tipousuario='Veterinário' AND l.ativo = TRUE ", Login.class);
        try{
            return tq.getResultList();
        }catch(Exception ex){
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
            return new ArrayList<>();
        }
    }
    
}
