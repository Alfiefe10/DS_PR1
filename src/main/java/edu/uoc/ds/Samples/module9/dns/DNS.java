package edu.uoc.ds.samples.module9.dns;


import edu.uoc.ds.traversal.Iterator;



/**
 * @author David Fíguls
 * @author Jordi Alvarez (adaptaci�n para la versi�n 2.0.0 de la librer�a)
 * Universitat Oberta de Catalunya (UOC)
 * @version 2.0.0
 */
public interface DNS {
	
    /**
     * Method that registers a domain by relating it to an IP.
     *
     * @param d Domain object containing the domain. ex: "www.uoc.edu".
     * @param ip string containing the ip address of the domain. ex: "129.34.2.3".
     */
    void addDomain(Domain d, IP ip);

     /**
      * Method that cancels a domain.
      *
      * @param d Domain object containing the domain. ex: "www.uoc.edu".
      */
     void deleteDomain(Domain d);

     /**
      * @param d Domain object containing the domain. ex: "www.uoc.edu".
      * @return ip returns a string containing the ip address of the domain. ex: "129.34.2.3".
      */
     IP get(Domain d);

     /**
      * Method that queries one of the most visited domains.
      *
      * @param n position within the ranking (0..9).
      * @return domain returns a Domain object containing the domain number.
      */
     Domain mostVisited(int n);

     /**
      * Method that initializes a tld for traversal.
      *
      * @param t tld which we want to traverse.
      */
     Iterator<Entity> entities(TLD t);

}
 