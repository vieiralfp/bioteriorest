/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jwt;

import javax.crypto.spec.SecretKeySpec;
import java.security.Key;
 
public class KeyGenerator {
 
    public Key generateKey() {
        String keyString = "B10t3r1o4p1"; 
        Key key = new SecretKeySpec(keyString.getBytes(), 0, keyString.getBytes().length, "HmacSHA256");
        return key;
    }
 
}
