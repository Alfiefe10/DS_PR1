package edu.uoc.ds.samples.module9.dns;

/**
 * Clase que contiene la informaci�n que define el nombre de un host (ej: "www"). 
 * @author David F�guls
 * @author Jordi Alvarez (adaptaci�n para la versi�n 2.0.0 de la librer�a)
 *          Estructura de la Informaci�n,
 *          Universitat Oberta de Catalunya (UOC)
 * @version 2.0.0
 */
public class Host implements Comparable{
  private final String host;
  
  /**
   * Constructor de un host a partir de una cadena (ej "www").
   * @param s cadena que contiene el nombre del hueste (ej "ww").
   */
  public Host(String s) {
    host=s;
  }

  /**
   * M�todo que permite comparar dos hosts. Necesario para poder a�adir hosts al contenedor de hosts.
   * @param o otro host.
   */
  public int compareTo(Object o) {
    Host h=(Host)o;
    return host.compareTo(h.host);
  }
  
  /**
   * M�todo que retorna una cadena con el nombre del host.
   * @return String cadena con el nombre del host (ej "www").
   */
  public String toString() {
    return host;
  }
}