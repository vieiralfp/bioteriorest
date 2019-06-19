/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service.filter;

import exceptions.UnauthenticatedException;
import javax.annotation.Priority;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.*;
import javax.ws.rs.ext.Provider;
import java.io.IOException;
import java.security.Key;
import jwt.JWTSecurityContext;
import jwt.KeyGenerator;
import jwt.TokenJWTUtil;
import jwt.UserDetails;
import service.LoginRest;
 
@Provider
@Priority(Priorities.AUTHENTICATION)
public class JWTAuthenticationFilter implements ContainerRequestFilter {
 
    private KeyGenerator keyGenerator = new KeyGenerator();
 
    @Context
    private UriInfo uriInfo;
 
    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        String authorizationHeader = requestContext.getHeaderString(HttpHeaders.AUTHORIZATION);
 
        if(authorizationHeader != null && authorizationHeader.contains("Bearer ")) {
            String token = authorizationHeader.substring("Bearer".length()).trim();
 
            Key key = keyGenerator.generateKey();
 
            if (TokenJWTUtil.tokenValido(token, key)) {
                String login = TokenJWTUtil.recuperarLogin(token, key);
                String nome = (String) TokenJWTUtil.recuperarClaims(token, key, "nome", String.class);
                String role = (String) TokenJWTUtil.recuperarClaims(token, key, "roles", String.class);
                
                UserDetails userDetails = new UserDetails(login, nome, role);
 
                boolean secure = true ; /* permite acesso só em https requestContext.getSecurityContext().isSecure();*/
                requestContext.setSecurityContext(new JWTSecurityContext(userDetails, secure));
                return;
            }
            //permite acesso a pagina de login
        } else if (acessoParaLoginNaAPI(requestContext)) {
            return;
        } /* da acesso a qualquer usuário para pesquisar (GET)
        else if (acessoParaMetodosDeConsulta(requestContext)) {
            return;
        }*/
        throw new UnauthenticatedException("Token inválido/expirado ou usuário não autenticado!");
    }
 
    private boolean acessoParaLoginNaAPI(ContainerRequestContext requestContext) {
        return requestContext.getUriInfo().getAbsolutePath().toString()
                .equals(uriInfo.getBaseUriBuilder().path(LoginRest.class).build().toString());
    }
 
    /* da acesso a qualquer usuário para pesquisar (GET)
    private boolean acessoParaMetodosDeConsulta(ContainerRequestContext requestContext) {
        return "GET".equalsIgnoreCase(requestContext.getMethod());
    }
 */
}
