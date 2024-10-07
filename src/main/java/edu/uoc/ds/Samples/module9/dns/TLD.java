package edu.uoc.ds.samples.module9.dns;

/**
 * Clase que contiene la informaci�n que define un Top Level Domain o TLD(ej: "edu"). 
 * @author David F�guls
 *          Estructura de la Informaci�n,
 *          Universitat Oberta de Catalunya (UOC)
 * @version 1.0.0
 */
public class TLD implements Comparable{
  private final String tld;

  /**
   * Constructor de un TLD a partir de una cadena (ej "edu").
   * @param s cadena que contiene el n�mero del TLD (ej "edu").
   */
  public TLD(String s) {
    tld=s;
  }
  

  /**
  * M�todo que permite comparar dos TLDs. 
  * @param u otro TLD.
  */
  public int compareTo(Object o) {
    TLD t=(TLD)o;
    return tld.compareTo(t.tld);
  }
  
  
  /** Calcula el hashcode del TLD. Delega en el m�todo
   * hashcode de String.
   */
  public int hashCode() {
	  return tld.hashCode();
  }
  

  /**
   * M�todo que retorna una cadena con el n�mero del TLD.
   * @return String cadena con el n�mero del tld (ej "edu").
   */
  public String toString() {
    return tld;
  }
}