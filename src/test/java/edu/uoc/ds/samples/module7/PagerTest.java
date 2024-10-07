package edu.uoc.ds.samples.module7;

import edu.uoc.ds.exercises.module5.exercise3.Document;
import edu.uoc.ds.traversal.Iterator;
import edu.uoc.ds.util.DateUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class PagerTest {
    Pager<String, Movie> pager;

    @Before
    public void setUp() {
        pager = new PagerImpl();

        pager.put("7Samurai", new Movie("7Samurai", "The sevent Samurai", "Akira's Kurosawa", "Drama", "Japanese", DateUtils.createLocalDate("12-01-1954")));
        pager.put("CityGod", new Movie("CityGod", "City of God", "Fernando Meirelles", "Drama", "Portuguese", DateUtils.createLocalDate("02-03-2002")));
        pager.put("GodFather", new Movie("GodFather", "The GodFather", "Francis for Coppola", "Crime", "English", DateUtils.createLocalDate("17-09-1972")));
        pager.put("ThinRedLine", new Movie("ThinRedLine", "The Thin Red Line", "Terrence Malick", "War", "English", DateUtils.createLocalDate("27-04-1998")));
        pager.put("Scarface", new Movie("Scarface", "The Scarface", "Brian De Palma", "Crime", "English", DateUtils.createLocalDate("11-01-1983")));
        pager.put("Carlitos", new Movie("Carlitos", "The Carlito's way", "Brian De Palma", "Crime", "English", DateUtils.createLocalDate("21-12-1993")));
        pager.put("Apocalypse", new Movie("Apocalypse", "Apocalypse Now", "Francis Ford Coppola", "War", "English", DateUtils.createLocalDate("16-07-1979")));
        pager.put("RedEye", new Movie("RedEye", "Red Eye", "Wes Craven", "Thriller", "English", DateUtils.createLocalDate("15-07-2005")));
        pager.put("SinCity", new Movie("SinCity", "Sin City", "Robert Rodriguez", "Action", "English", DateUtils.createLocalDate("19-08-2005")));
    }

    @Test
    public void test() {
        Iterator<Movie> it = pager.pager("Apocalypse", "GodFather");
/*        while (it.hasNext()) {
            System.out.println(it.next());
        }
*/
        if (it.hasNext()) {
            Assert.assertEquals("Apocalypse", it.next().id());
        }

        if (it.hasNext()) {
            Assert.assertEquals("Carlitos", it.next().id());
        }

        if (it.hasNext()) {
            Assert.assertEquals("CityGod", it.next().id());
        }

        if (it.hasNext()) {
            Assert.assertEquals("GodFather", it.next().id());
        }
        Assert.assertFalse(it.hasNext());


    }
}
