package edu.uoc.ds.samples.module9.dns;

/**
 * Clase que contiene la informaci�n que define una entidad (ej: "uoc"). 
 * @author David F�guls
 * @author Jordi Alvarez (adaptaci�n para la versi�n 2.0.0 de la librer�a)
 *          Estructura de la Informaci�n,
 *          Universitat Oberta de Catalunya (UOC)
 * @version 2.0.0
 */
public class Entity implements Comparable {
  private final String entidad;

  /**
   * Constructor de una Entidad a partir de una cadena (ej "uoc").
   * @param s cadena que contiene el nombre del entidad (ej "uoc").
   */
  public Entity(String s) {
    entidad=s;
  }

  /**
   * M�todo que permite comparar dos entidades. Necesario para poder a�adir Entidades al ContEntidades (un arbol AVL).
   * @param o otra entidad.
   */
  public int compareTo(Object o) {
    Entity e=(Entity)o;
    return entidad.compareTo(e.entidad);
  }

  /**
   * M�todo que retorna una cadena con el nombre de la entidad.
   * @return String cadena con el nombre de la entidad (ej "uoc").
   */
  public String toString() {
    return entidad;
  }
}