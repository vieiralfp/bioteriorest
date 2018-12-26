/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package idaf.bioterio.banco.model.service;

import java.util.Set;
import javax.ws.rs.core.Application;
import org.glassfish.jersey.jackson.JacksonFeature;

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
        return resources;
    }

    /**
     * Do not modify addRestResourceClasses() method.
     * It is automatically populated with
     * all resources defined in the project.
     * If required, comment out calling this method in getClasses().
     */
    private void addRestResourceClasses(Set<Class<?>> resources) {
        resources.add(idaf.bioterio.banco.model.service.EspecieMorcegoRest.class);
        resources.add(idaf.bioterio.banco.model.service.EspecieRest.class);
        resources.add(idaf.bioterio.banco.model.service.InoculacaoRest.class);
        resources.add(idaf.bioterio.banco.model.service.LoginRest.class);
        resources.add(idaf.bioterio.banco.model.service.MunicipioRest.class);
        resources.add(idaf.bioterio.banco.model.service.ObservacaoCamundongoRest.class);
        resources.add(idaf.bioterio.banco.model.service.PrincipalRest.class);
        resources.add(idaf.bioterio.banco.model.service.RacasRest.class);
        resources.add(idaf.bioterio.banco.model.service.RemetenteRest.class);
    }
    
    
    
}
