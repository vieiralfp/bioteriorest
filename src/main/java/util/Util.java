/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import dao.InoculacaoDao;
import model.Inoculacao;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.ejb.EJB;


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
    /**
     * Adiciona ou subtrai dias a data. Para subtrair use o sinal (-) negativo
     * @param data
     * @param dias
     * @return 
     */
    public static Date adicionarOuSubtrairDiasData(Date data, int dias){
        System.out.println("util.Util.adicionarOuSubtrairDiasData()="+data);
        Calendar cal = Calendar.getInstance();
        cal.setTime(data);
        cal.add(Calendar.DATE, dias);
        return cal.getTime();
    }
    
    
}
