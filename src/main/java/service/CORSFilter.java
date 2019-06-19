/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.core.MultivaluedMap;

/**
 *
 * @author Idaf
 */
public class CORSFilter implements ContainerResponseFilter {

   

    @Override
    public void filter(ContainerRequestContext crc, ContainerResponseContext responseContext) throws IOException {
        final MultivaluedMap<String, Object> headers = responseContext
                .getHeaders();

        headers.add("Access-Control-Allow-Origin", "*");
        headers.add("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT");
        headers.add("Access-Control-Allow-Credentials", "true");
        headers.add("Access-Control-Allow-Headers",
                "X-Requested-With, Content-Type, X-Codingpedia, Authorization");
        headers.add("access-control-expose-headers", "Authorization");
        
        if ("OPTIONS".equalsIgnoreCase(crc.getMethod())) {
            responseContext.setStatus(HttpServletResponse.SC_OK);
        } 
    }

    
}