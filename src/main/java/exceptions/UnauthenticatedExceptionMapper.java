/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exceptions;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;
 
@Provider
public class UnauthenticatedExceptionMapper implements ExceptionMapper<UnauthenticatedException> {
 
    @Override
    public Response toResponse(UnauthenticatedException exception) {
        return Response.status(Response.Status.UNAUTHORIZED)
                .entity(ErrorMessage.builder()
                        .addErro(exception.getMessage())
                        .addStatusCode(Response.Status.UNAUTHORIZED.getStatusCode())
                        .addStatusMessage(Response.Status.UNAUTHORIZED.toString())
                        .build())
                .type(MediaType.APPLICATION_JSON)
                .build();
    }
 
}