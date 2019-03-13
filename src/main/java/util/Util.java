/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.util.Calendar;
import java.util.Date;

/**
 *
 * @author luiz
 */
public class Util {
    
    /**
     * Retorna o primeiro dia do ano
     * @param ano
     * @return 
     */
    public static Date inicio (int ano){
        
        Calendar inicio = Calendar.getInstance();
        inicio.set(Calendar.YEAR, ano);
        inicio.set(Calendar.MONTH, 0);
        inicio.set(Calendar.DAY_OF_MONTH, 1);
        
        return inicio.getTime();
    }
    
    /**
     * Retorna o último dia do ano
     * @param ano
     * @return 
     */
    public static Date fim (int ano){
        Calendar fim = Calendar.getInstance();
        fim.set(Calendar.YEAR, ano);
        fim.set(Calendar.MONTH, 11);
        fim.set(Calendar.DAY_OF_MONTH, 31);
        
        return fim.getTime();
    }
    
}
