package edu.uoc.ds.adt;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import edu.uoc.ds.adt.sequential.SetLinkedListImpl;
import edu.uoc.ds.adt.sequential.Stack;
import edu.uoc.ds.traversal.Iterator;

public class PR1WordSearchArrayTest {

    PR1WordSearchArray wordSearch;
    SetLinkedListImpl<String> words;

    @Before
    public void setUp() {
        String in = """
                CSTACKOPTERK
                RSLLMHAOLAQC
                GRAPHIPRFBXA
                GHBINARYTREE
                PRIOSITYQUEU
                LINKEDLISTQZ
                ALBMTUHUGSUT
                MBULISTINGER
                AUPIDCEKTSUO
                XSITWAYANEEI
                HASHTABLERNN
                HGHIUECYCLEE
                """;
        wordSearch = new PR1WordSearchArray(in.replace("\n", ""), 12, 12);  // 12 filas, 12 columnas

        words = new SetLinkedListImpl<>();
        words.add("LIST");
        words.add("HASHTABLE");
        words.add("STACK");
        words.add("BINARYTREE");
        words.add("SET");
        words.add("QUEUE");
        words.add("LINKEDLIST");
        words.add("GRAPH");
    }

    @Test
    public void wordSearchTest() {
        Stack<PR1WordSearchArray.Result> results = wordSearch.search(words);
        Assert.assertNotNull(results);

        Iterator<PR1WordSearchArray.Result> it = results.values();
        Assert.assertTrue(it.hasNext());

        PR1WordSearchArray.Result r = it.next();
        Assert.assertEquals("GRAPH", r.word);
        Assert.assertEquals(2, r.row);
        Assert.assertEquals(0, r.col);
        Assert.assertEquals(PR1WordSearchArray.Direction.HORIZONTAL, r.direction);

        r = it.next();
        Assert.assertEquals("LINKEDLIST", r.word);
        Assert.assertEquals(5, r.row);
        Assert.assertEquals(0, r.col);
        Assert.assertEquals(PR1WordSearchArray.Direction.HORIZONTAL, r.direction);

        r = it.next();
        Assert.assertEquals("QUEUE", r.word);
        Assert.assertEquals(5, r.row);
        Assert.assertEquals(10, r.col);
        Assert.assertEquals(PR1WordSearchArray.Direction.VERTICAL, r.direction);

        r = it.next();
        Assert.assertEquals("SET", r.word);
        Assert.assertEquals(4, r.row);
        Assert.assertEquals(4, r.col);
        Assert.assertEquals(PR1WordSearchArray.Direction.VERTICAL, r.direction);

        r = it.next();
        Assert.assertEquals("BINARYTREE", r.word);
        Assert.assertEquals(3, r.row);
        Assert.assertEquals(2, r.col);
        Assert.assertEquals(PR1WordSearchArray.Direction.HORIZONTAL, r.direction);

        r = it.next();
        Assert.assertEquals("STACK", r.word);
        Assert.assertEquals(0, r.row);
        Assert.assertEquals(1, r.col);
        Assert.assertEquals(PR1WordSearchArray.Direction.HORIZONTAL, r.direction);

        r = it.next();
        Assert.assertEquals("HASHTABLE", r.word);
        Assert.assertEquals(10, r.row);
        Assert.assertEquals(0, r.col);
        Assert.assertEquals(PR1WordSearchArray.Direction.HORIZONTAL, r.direction);

        r = it.next();
        Assert.assertEquals("LIST", r.word);
        Assert.assertEquals(5, r.row);
        Assert.assertEquals(6, r.col);
        Assert.assertEquals(PR1WordSearchArray.Direction.HORIZONTAL, r.direction);

        Assert.assertFalse(it.hasNext());
    }
}
