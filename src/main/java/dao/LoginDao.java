/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import javax.ejb.Stateless;
import model.Login;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import jwt.Criptografar;


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
    
    public Login recuperarUsuarioPorLoginSenha(String login, String senha){
        String senhaCripto = "";
     try {
         senhaCripto = Criptografar.cripto(senha);
     } catch (NoSuchAlgorithmException | UnsupportedEncodingException ex) {
         Logger.getLogger(LoginDao.class.getName()).log(Level.SEVERE, null, ex);
     }
        try{
            TypedQuery<Login> tq = em.createQuery("Select l From Login l Where l.login = :login AND l.senha = :senha", Login.class);
            tq.setParameter("login", login);
            tq.setParameter("senha", senhaCripto);
        
            return tq.getSingleResult();
        }catch(Exception ex){
            Logger.getLogger(getClass().getName()).log(Level.SEVERE, null, ex);
            return null;
        }
    }
    
}
