package edu.uoc.ds.samples.module9.dns;

import edu.uoc.ds.traversal.Iterator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class DNSTest {
    private DNS dns;
    private Domain domain1;
    private Domain domain2;
    private Domain domain3;
    private Domain domain4;
    private Domain domain5;

    private IP ip101;
    private IP ip102;
    private IP ip103;
    private IP ip104;
    private IP ip105;


    @Before
    public void creaDNS() {
        dns = new DNSimpl();
        domain1 = new Domain("host1.ds.uoc.edu");
        domain2 = new Domain("host2.ds.uoc.edu");
        domain3 = new Domain("host3.ds.uoc.edu");
        domain4 = new Domain("host4.ds.uoc.edu");
        domain5 = new Domain("host5.ds.uoc.edu");

        ip101 = new IP("10.0.0.101");
        ip102 = new IP("10.0.0.102");
        ip103 = new IP("10.0.0.103");
        ip104 = new IP("10.0.0.104");
        ip105 = new IP("10.0.0.105");


    }


    @Test
    public void addDomainTest() {
        dns.addDomain(domain1,  ip101);
        dns.addDomain(domain2,  ip102);
        dns.addDomain(domain3,  ip103);
        dns.addDomain(domain4,  ip104);
        dns.addDomain(domain5,  ip105);
        IP ip1Aux = dns.get(domain1);
        IP ip2Aux = dns.get(domain2);
        IP ip3Aux = dns.get(domain3);
        IP ip4Aux = dns.get(domain4);
        IP ip5Aux = dns.get(domain5);

        Assert.assertEquals(this.ip101, ip1Aux);
        Assert.assertEquals(this.ip102, ip2Aux);
        Assert.assertEquals(this.ip103, ip3Aux);
        Assert.assertEquals(this.ip104, ip4Aux);
        Assert.assertEquals(this.ip105, ip5Aux);
    }

    @Test
    public void deleteDomainTest() {
        addDomainTest();
        dns.deleteDomain(domain3);
        IP ip3Aux = dns.get(domain3);
        Assert.assertNull(ip3Aux);

    }



    @Test
    public void mostVisited() {
        addDomainTest();
        IP ip1Aux = dns.get(domain1);
        ip1Aux = dns.get(domain1);
        ip1Aux = dns.get(domain1);
        ip1Aux = dns.get(domain1);
        ip1Aux = dns.get(domain1);

        Domain d = dns.mostVisited(0);
        Assert.assertEquals(ip101, ip1Aux);
    }
}
