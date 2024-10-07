package edu.uoc.ds.samples.module9.dns;

/**
 * Clase que agrupa la informaci�n necesaria que debemos guardar de cada host.<br>
 * Incluye el dominio, la direcci�n ip y el n�mero de visitas.
 * @author David F�guls
 * @author Jordi Alvarez (adaptaci�n para la versi�n 2.0.0 de la librer�a)
 *          Estructura de la Informaci�n,
 *          Universitat Oberta de Catalunya (UOC)
 * @version 2.0.0
 */
class HostData {
  Domain dominio;
  IP ip;
  int numVisitas;

  /**
   * Constructor a partir de un dominio y una ip. El contador de visitas se pone a 0.
   * @param d Dominio.
   * @param e IP.
   */
  public HostData(Domain d, IP i) {
    dominio=d;
    ip=i;
    numVisitas=0;
  }

  /**
   * M�todo que incrementa el contador de visitas del host.
   */
  public void visita() {numVisitas++;}

  /**
   * M�todo que retorna el Dominio del host.
   * @return Dominio el dominio del host.
   */
  public Domain getDomain() {return dominio;}
  
  /**
   * M�todo que retorna la direcci�n IP del host.
   * @return IP la direcci�n ip del host.
   */
  public IP getIP() {return ip;}

  /**
   * M�todo que asigna la direcci�n IP del host.
   * @return IP la direcci�n ip del host.
   */
  public void setIP(IP i) {ip=i;}

  /**
   * M�todo que retorna el n�mero de visitas del host.
   * @return int n�mero de visitas del host.
   */
  public int getVisits() {return numVisitas;}
  
  
  public String toString() {
	  return "[InfoHost: "+dominio+","+ip+","+numVisitas+"]";
  }
}