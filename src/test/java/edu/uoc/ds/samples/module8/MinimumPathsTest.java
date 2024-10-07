package edu.uoc.ds.samples.module8;


import edu.uoc.ds.adt.helpers.KeyValue;
import edu.uoc.ds.adt.nonlinear.graphs.DirectedGraph;
import edu.uoc.ds.adt.nonlinear.graphs.DirectedGraphImpl;
import edu.uoc.ds.adt.nonlinear.graphs.Edge;
import edu.uoc.ds.adt.nonlinear.graphs.Vertex;
import edu.uoc.ds.algorithms.MinimumPaths;
import org.junit.Assert;
import org.junit.Test;

public class MinimumPathsTest {

    @Test
    public void test() {
        DirectedGraph<String, Integer> networkRoads = new DirectedGraphImpl<String, Integer>();
        Vertex<String> madrid = networkRoads.newVertex("Madrid");
        Vertex<String> villar = networkRoads.newVertex("Villar");
        Vertex<String> collado = networkRoads.newVertex("Collado");
        Vertex<String> montes = networkRoads.newVertex("Montes");
        Vertex<String> aldea = networkRoads.newVertex("Aldea");
        Edge<Integer, String> mv = networkRoads.newEdge(madrid, villar);
        mv.setLabel(75);
        Edge<Integer, String> mc = networkRoads.newEdge(madrid, collado);
        mc.setLabel(60);
        Edge<Integer, String> mn = networkRoads.newEdge(madrid, montes);
        mn.setLabel(20);
        Edge<Integer, String> nv = networkRoads.newEdge(montes, villar);
        nv.setLabel(2);
        Edge<Integer, String> nc = networkRoads.newEdge(montes, collado);
        nc.setLabel(30);
        Edge<Integer, String> va = networkRoads.newEdge(villar, aldea);
        va.setLabel(200);
        Edge<Integer, String> ca = networkRoads.newEdge(collado, aldea);
        ca.setLabel(30);
        MinimumPaths<String, Integer> ag = new MinimumPaths<String, Integer>();
        KeyValue<Vertex<String>, Number>[] distances = ag.calculate(networkRoads, madrid);

        // Madrid --> Collado --> Aldea = 50 + 30 = 80KM
        Assert.assertEquals("Aldea", distances[0].getKey().getValue());
        Assert.assertEquals(80, distances[0].getValue().doubleValue(), 0);

        // Madrid --> Montes = 20 km
        Assert.assertEquals("Montes", distances[1].getKey().getValue());
        Assert.assertEquals(20, distances[1].getValue().doubleValue(), 0);

        //        20Km        30Km
        // Madrid ---> Montes ---> Collado = 50Km
        Assert.assertEquals("Collado", distances[2].getKey().getValue());
        Assert.assertEquals(50, distances[2].getValue().doubleValue(), 0);

        // Madrid --> Montes --> Villar = 20 + 2 = 22 KM
        Assert.assertEquals("Villar", distances[3].getKey().getValue());
        Assert.assertEquals(22, distances[3].getValue().doubleValue(), 0);

        // Madrid --> Madrid = 0
        Assert.assertEquals("Madrid", distances[4].getKey().getValue());
        Assert.assertEquals(0, distances[4].getValue().doubleValue(), 0);

    }

}
