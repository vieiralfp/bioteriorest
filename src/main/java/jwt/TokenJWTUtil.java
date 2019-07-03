/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jwt;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
 
import java.security.Key;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
 
public class TokenJWTUtil {
 
    private static KeyGenerator keyGenerator = new KeyGenerator();
 
    public static String gerarToken(String login, String nome, String roles) {
        Key key = keyGenerator.generateKey();
 
        String jwtToken = Jwts.builder()
                .signWith(SignatureAlgorithm.HS256, key)
                .setHeaderParam("typ","JWT")
                .setIssuer(login)
                .setIssuedAt(new Date())
                .setExpiration(toDate(LocalDateTime.now().plusMinutes(60L)))
                .claim("roles", roles)
                .claim("nome", nome)
                .compact();
        return jwtToken;
    }
 
    private static Date toDate(LocalDateTime localDateTime) {
        return Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
    }
 
    public static boolean tokenValido(String token, Key key) {
        try {
            Jwts.parser().setSigningKey(key).parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
 
    public static String recuperarLogin(String token, Key key) {
        Jws<Claims> claimsJws = Jwts.parser().setSigningKey(key).parseClaimsJws(token);
        return claimsJws.getBody().getSubject();
    }
 
    public static Object recuperarClaims(String token, Key key, String claim, Class classe) {
        Jws<Claims> claimsJws = Jwts.parser().setSigningKey(key).parseClaimsJws(token);
        return claimsJws.getBody().get(claim, classe);
    }
}

