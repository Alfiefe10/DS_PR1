package edu.uoc.ds.samples.module4;

import org.junit.Assert;
import org.junit.Test;

public class LocationsTest {

    @Test
    public void test() {
        LocationsTree tree = new LocationsTree("Catalunya SUB VallésOriental SUB Montmeló FSUB Barcelonés SUB Barcelona SUB NouBarris Carmel Gràcia Sarrià FSUB L'Hospitalet FSUB Bages");
        Assert.assertEquals("{Catalunya {VallésOriental {Montmeló },Barcelonés {Barcelona {NouBarris ,Carmel ,Gràcia ,Sarrià },L'Hospitalet },Bages }}", tree.toString());
    }

}
