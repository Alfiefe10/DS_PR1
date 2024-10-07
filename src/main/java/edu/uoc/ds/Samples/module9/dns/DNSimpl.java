package edu.uoc.ds.samples.module9.dns;


import edu.uoc.ds.traversal.Iterator;

/**
 * Implementation of the DNS interface using a container of TLDs (ContTLDs)
 * and a container for the most visited (TopTen).
 *
 * @author David Fíguls
 * @author Jordi Alvarez
 * Universitat Oberta de Catalunya (UOC)
 * @version 2.0.0
 */
public class DNSimpl implements DNS {

    private final TLDsDictionary tlds;
    private final TopTen topTen;

    /**
     * Method that initializes a new DNSimpl object.
     */
    public DNSimpl() {
        tlds = new TLDsDictionary(2001);
        topTen = new TopTen();
    }

    /**
     * Method that registers a domain by relating it to an IP.
	 * @param domain object Domain that contains the domain. ex: "www.uoc.edu".
	 * @param ip string containing the ip address of the domain. ex: "129.34.2.3".
     */
    public void addDomain(Domain domain, IP ip) {
        TLD tld = domain.getTLD();
        Entity entidad = domain.getEntity();
        Host host = domain.getHost();
        if (!tlds.containsKey(tld))
            tlds.put(tld, new EntityDictionary());
        EntityDictionary ets = tlds.get(tld);
        if (!ets.containsKey(entidad))
            ets.put(entidad, new HostsDictionary());
        HostsDictionary hosts = ets.get(entidad);
        if (hosts.containsKey(host)) {
            HostData h = hosts.get(host);
            h.setIP(ip);
        } else {
            hosts.put(host, new HostData(domain, ip));
        }
    }


    /**
	 * Method that unsubscribes a domain.
	 * @param domain Domain object containing the domain. ex: "www.uoc.edu".
     */
    public void deleteDomain(Domain domain) {
        TLD tld = domain.getTLD();
        Entity entity = domain.getEntity();
        Host host = domain.getHost();
        if (tlds.containsKey(tld)) {
            EntityDictionary ets = tlds.get(tld);
            if (ets.containsKey(entity)) {
                HostsDictionary hosts = ets.get(entity);
                if (hosts.containsKey(host))
                    hosts.delete(host);
            }
        }
    }


    /**
     * Method that queries the ip address of a domain.
	 * @param domain object Domain that contains the domain. ex: "www.uoc.edu".
	 * @return ip returns a string containing the ip address of the domain. ex: "129.34.2.3".
     */
    public IP get(Domain domain) {
        IP ip = null;
        TLD tld = domain.getTLD();
        Entity entity = domain.getEntity();
        Host host = domain.getHost();
        if (tlds.containsKey(tld)) {
            EntityDictionary ets = tlds.get(tld);
            if (ets.containsKey(entity)) {
                HostsDictionary hosts = ets.get(entity);
                if (hosts.containsKey(host)) {
                    HostData infoHost = hosts.get(host);
                    infoHost.visita();
                    topTen.update(infoHost);
                    ip = infoHost.getIP();
                }
            }
        }
        return ip;
    }


    /**
	 * Method that queries one of the most visited domains.
	 *
	 * @param n position within the ranking (0..9).
	 * @return domain returns a Domain object containing the domain number.
     */
    public Domain mostVisited(int n) {
        Domain result = null;
        HostData info = topTen.get(n);
        if (info != null)
            result = info.getDomain();
        return result;
    }


    /**
	 * Method that initializes a tld for traversal.
	 *
	 * @param tld whose tld we want to traverse.
     */
    public Iterator<Entity> entities(TLD tld) {
        Iterator<Entity> res = null;
        if (tlds.containsKey(tld))
            res = tlds.get(tld).keys();
        return res;
    }

}
 