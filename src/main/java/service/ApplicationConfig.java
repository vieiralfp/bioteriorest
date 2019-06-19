/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.util.Set;
import javax.ws.rs.core.Application;
import org.glassfish.jersey.jackson.JacksonFeature;
import service.filter.JWTAuthenticationFilter;
import service.filter.JWTAuthorizationFilter;

/**
 *
 * @author Idaf
 */
@javax.ws.rs.ApplicationPath("rest")
public class ApplicationConfig extends Application {

    @Override
    public Set<Class<?>> getClasses() {
        Set<Class<?>> resources = new java.util.HashSet<>();
        addRestResourceClasses(resources);
        resources.add(JacksonFeature.class);
        resources.add(CORSFilter.class);
        resources.add(JWTAuthorizationFilter.class);
        resources.add(JWTAuthenticationFilter.class);
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(exceptions.UnauthenticatedExceptionMapper.class);
        resources.add(exceptions.UnauthorizedExceptionMapper.class);
        resources.add(service.EspecieMorcegoRest.class);
        resources.add(service.EspecieRest.class);
        resources.add(service.InoculacaoRest.class);
        resources.add(service.LoginRest.class);
        resources.add(service.MunicipioRest.class);
        resources.add(service.ObservacaoCamundongoRest.class);
        resources.add(service.PrincipalRest.class);
        resources.add(service.RacasRest.class);
        resources.add(service.RemetenteRest.class);
        resources.add(service.filter.JWTAuthenticationFilter.class);
        resources.add(service.filter.JWTAuthorizationFilter.class);
    }
    
    
    
}
