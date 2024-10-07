package edu.uoc.ds.samples.module9.dns;


/**
 * Clase que contiene la informaci�n que define una direcci�n IP (ej: "100.23.98.255"). 
 * @author David F�guls
 * @author Jordi Alvarez (adaptaci�n para la versi�n 2.0.0 de la librer�a)
 *          Estructura de la Informaci�n,
 *          Universitat Oberta de Catalunya (UOC)
 * @version 2.0.0
 */
public class IP implements Comparable{
  private final String ip;
  
  /**
   * Constructor de una IP a partir de una cadena (ej "100.23.98.255").
   * @param s cadena que contiene la direcci�n IP(ej "100.23.98.255").
   */
  public IP(String s) {
    ip=s;
  }

  /**
   * M�todo que permite comparar dos IP's. 
   * @param u otra IP.
   */
  public int compareTo(Object o) {
    IP i=(IP)o;
    return ip.compareTo(i.ip);
  }

  /**
   * M�todo que retorna una cadena con la direcci�n ip.
   * @return String cadena con la direcci�n ip (ej "100.23.98.255").
   */
  public String toString() {
    return ip;
  }
}