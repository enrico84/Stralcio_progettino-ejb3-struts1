/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utility;

import java.io.Serializable;

/**
 *
 * @author Enrico
 */
public class Data implements Serializable{ //Serializable necessario per usare gli EJB

	private int anno;
	private int mese;
	private int giorno;

	public Data(){}  //Requisito necessario per usare i JavaBean(tag jsp:useBean )

	/**
	 * 
	 * @param anno
	 * @param mese
	 * @param giorno
	 */
	public Data(int anno, int mese, int giorno){
            this.anno=anno;
            this.mese=mese;
            this.giorno=giorno;
        }

	public int getAnno(){
		return anno;
	}

	public int getMese(){
		return mese;
	}

	public int getGiorno(){
		return giorno;
	}
        
        
        @Override
        public String toString()
        {
            String data;
            data=this.getGiorno()+"/"+this.getMese()+"/"+this.getAnno();
            return data;
        }
    
}
