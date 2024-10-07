package edu.uoc.ds.samples.module3.reference;

import org.junit.Assert;
import org.junit.Test;

public class PersonTest {

    @Test
    public void test() {
        Person grandPaPedro = new Person("Pedro");
        Person grandMaPaquita = new Person("Paquita");
        Person mammy = new Person("Carmen", grandPaPedro, grandMaPaquita);
        Person unclePedro = new Person("Pedro", grandPaPedro, grandMaPaquita);
        Person daddy = new Person("Jorge");
        Person juan = new Person("Juan", daddy, mammy);

        Assert.assertEquals(daddy, juan.getFather());
        Assert.assertEquals(mammy, juan.getMother());

        Assert.assertEquals(grandPaPedro, unclePedro.getFather());
        Assert.assertEquals(grandMaPaquita, unclePedro.getMother());

        Assert.assertEquals(grandPaPedro, mammy.getFather());
        Assert.assertEquals(grandMaPaquita, mammy.getMother());
    }
}
