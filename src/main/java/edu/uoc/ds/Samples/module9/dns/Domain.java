package edu.uoc.ds.samples.module9.dns;


import java.util.StringTokenizer;

/**
 * Clase que contiene la cadena que define un dominio (ej: "www.uoc.edu"). 
 * @author David F�guls
 * @author Jordi Alvarez (adaptaci�n para la versi�n 2.0.0 de la librer�a)
 *          Estructura de la Informaci�n,
 *          Universitat Oberta de Catalunya (UOC)
 * @version 2.0.0
 */
public class Domain {
  private final TLD tld;
  private final Entity entidad;
  private final Host host;
  
  /**
   * Constructor de un Dominio a partir de un TLD, una Entidad y un host.
   * @param t cadena que identifica el TLD (ej "edu").
   * @param e cadena que identifica la entidad (ej "uoc").
   * @param h cadena que identifica el host (ej "www").
   */
  public Domain(TLD t, Entity e, Host h) {
    tld=t; entidad=e; host=h;
  }

  /**
   * Constructor de un Dominio a partir de una cadena (ej "www.uoc.edu").
   * @param d cadena que contiene el n�mero del dominio (ej "www.uoc.edu").
   */
  public Domain(String d) {
  	StringTokenizer s=new StringTokenizer(d,".");
  	host=new Host(s.nextToken());
  	entidad=new Entity(s.nextToken());
  	tld=new TLD(s.nextToken());
  }
  
  /**
   * M�todo que retorna el tld del dominio.
   * @return TLD  el tld del dominio (ej de "www.uoc.edu" retorno "edu").
   */
  public TLD getTLD() {return tld;}

  /**
   * M�todo que retorna la entidad del dominio.
   * @return Entidad el entidad del dominio (ej de "www.uoc.edu" retorno "uoc").
   */
  public Entity getEntity() {return entidad;}

  /**
   * M�todo que retorna el host del dominio.
   * @return Hueste  el host del dominio (ej de "www.uoc.edu" retorno "www").
   */
  public Host getHost() {return host;}

  /**
   * M�todo que retorna una cadena con el nombre del dominio.
   * @return String cadena con el nombre del dominio (ej "www.uoc.edu").
   */
  public String toString() {
    return tld.toString()+"."+entidad.toString()+"."+host.toString();
  }
}