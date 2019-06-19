/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import dao.LoginDao;
import exceptions.UnauthenticatedException;
import model.Login;
import java.util.List;
import javax.annotation.security.PermitAll;
import javax.ejb.EJB;
import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import jwt.JWTSecurityContext;
import jwt.TokenJWTUtil;
import jwt.UserDetails;

/**
 *
 * @author Idaf
 */
@Path("login")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
@PermitAll
public class LoginRest extends AbstractRest<Login, LoginDao> {
    
    @EJB
    private LoginDao loginDao;

    @Override
    public LoginDao getDao() {
        return loginDao;
    }
    
    @GET
    @Path("loginveterinarios")
    public Response getLoginVeterinarios(){
        return Response.ok().entity(loginDao.getLoginVeterinarios()).build();
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @PermitAll
    public Response autenticarUsuario(@FormParam("login") String login,
                                      @FormParam("password") String password) {
        Login usuario = validarCredenciais(login, password);
        String token = TokenJWTUtil.gerarToken(usuario.getLogin(), usuario.getNome(), usuario.getTipousuario());
 
        return Response.ok().header("Authorization", "Bearer " + token).build();
    }
    
    private Login validarCredenciais(String login, String password) {
        
        Login usuario = getDao().recuperarUsuarioPorLoginSenha(login, password);
 
        if (usuario == null)
            throw new UnauthenticatedException("Usuário não autenticado: nome do usuário ou senha inválidos!");
 
        return usuario;
    }
    
    @POST
    @Path("refresh")
    @PermitAll
    public Response atualizarToken(@Context ContainerRequestContext requestContext) {
        JWTSecurityContext JWTSecurityContext = (JWTSecurityContext) requestContext.getSecurityContext();
        UserDetails userDetails = (UserDetails) JWTSecurityContext.getUserPrincipal();
        String token = TokenJWTUtil.gerarToken(userDetails.getName(), userDetails.getNomeUsuario(), userDetails.getRole());
 
        return Response.ok().header("Authorization", "Bearer " + token).build();
    }
    
}
