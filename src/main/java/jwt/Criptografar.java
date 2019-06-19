/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jwt;

import java.io.UnsupportedEncodingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.spec.AlgorithmParameterSpec;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import javax.xml.bind.DatatypeConverter;




/**
 *
 * @author idaf
 */
public class Criptografar {
    
    public static String cripto (String senha) throws NoSuchAlgorithmException, UnsupportedEncodingException{
        MessageDigest algorithm = MessageDigest.getInstance("SHA-256");
        byte messageDigest[] = algorithm.digest(senha.getBytes("UTF-8"));

        StringBuilder hexString = new StringBuilder();
        for (byte b : messageDigest) {
          hexString.append(String.format("%02X", 0xFF & b));
        }
        String senhaSaida = hexString.toString();
        return senhaSaida;
    }
    
    public static String cifrar(String value, byte[] chave) {
        String retorno = null;
        try {
            SecretKeySpec spec = new SecretKeySpec(chave, "AES");
            AlgorithmParameterSpec paramSpec = new IvParameterSpec(new byte[16]);
            Cipher cifra = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cifra.init(Cipher.ENCRYPT_MODE, spec,paramSpec);
            byte[] cifrado = cifra.doFinal(value.getBytes());
            retorno = DatatypeConverter.printBase64Binary(cifrado);
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | InvalidAlgorithmParameterException | IllegalBlockSizeException | BadPaddingException ex) {
        }
        return retorno;
    }
    public static String decifrar(String cifra, byte[] chave) {
        String retorno = null;
        try {
            SecretKeySpec skeySpec = new SecretKeySpec(chave, "AES");
            AlgorithmParameterSpec paramSpec = new IvParameterSpec(new byte[16]);
            byte[] decoded = DatatypeConverter.parseBase64Binary(cifra);
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            cipher.init(Cipher.DECRYPT_MODE, skeySpec,paramSpec);
            retorno = new String(cipher.doFinal(decoded));
        } catch (NoSuchAlgorithmException | NoSuchPaddingException | InvalidKeyException | InvalidAlgorithmParameterException | IllegalBlockSizeException | BadPaddingException ex) {
        }
        return retorno;
    }
    
    
    
}
