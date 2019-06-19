/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jwt;

import java.security.Principal;
 
public class UserDetails implements Principal {
 
    private final String login;
    private final String nome;
    private final String role;
 
    public UserDetails(String login, String nome, String role) {
        this.login = login;
        this.nome = nome;
        this.role = role;
    }

    public String getNomeUsuario() {
        return nome;
    }

    public String getRole() {
        return role;
    }

    @Override
    public String getName() {
        return login;
    }
 
   
 
}
