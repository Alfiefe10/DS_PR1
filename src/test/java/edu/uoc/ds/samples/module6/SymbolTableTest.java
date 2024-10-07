package edu.uoc.ds.samples.module6;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class SymbolTableTest {
    SymbolTable symbolTable;
    @Before
    public void setUp() {
        symbolTable = new SymbolTableImpl();
        symbolTable.register("P", SymbolProperties.Category.PROGRAM, SymbolProperties.Type.UNDEFINED, 10230);
        symbolTable.register("a", SymbolProperties.Category.VAR, SymbolProperties.Type.INT, 1024);
        symbolTable.register("b", SymbolProperties.Category.VAR, SymbolProperties.Type.INT, 1026);
        symbolTable.register("Q", SymbolProperties.Category.PROC, SymbolProperties.Type.UNDEFINED, 10500);

        Assert.assertEquals(SymbolProperties.Category.VAR, symbolTable.get("a").getCategory());
        Assert.assertEquals(1024, symbolTable.get("a").getSize());
        Assert.assertEquals(SymbolProperties.Type.INT, symbolTable.get("a").getType());
        Assert.assertEquals(0, symbolTable.get("a").getBlock());

        Assert.assertEquals(SymbolProperties.Category.VAR, symbolTable.get("b").getCategory());
        Assert.assertEquals(1026, symbolTable.get("b").getSize());
        Assert.assertEquals(SymbolProperties.Type.INT, symbolTable.get("b").getType());
        Assert.assertEquals(0, symbolTable.get("b").getBlock());

        symbolTable.getIn();
        symbolTable.register("c", SymbolProperties.Category.PARAM, SymbolProperties.Type.INT, 1028);
        symbolTable.register("a", SymbolProperties.Category.VAR, SymbolProperties.Type.REAL, 1030);
        symbolTable.register("d", SymbolProperties.Category.VAR, SymbolProperties.Type.REAL, 1032);
    }

    @Test
    public void test1() {
        Assert.assertEquals(SymbolProperties.Category.VAR, symbolTable.get("a").getCategory());
        Assert.assertEquals(1030, symbolTable.get("a").getSize());
        Assert.assertEquals(SymbolProperties.Type.REAL, symbolTable.get("a").getType());
        Assert.assertEquals(1, symbolTable.get("a").getBlock());

        Assert.assertEquals(SymbolProperties.Category.VAR, symbolTable.get("b").getCategory());
        Assert.assertEquals(1026, symbolTable.get("b").getSize());
        Assert.assertEquals(SymbolProperties.Type.INT, symbolTable.get("b").getType());
        Assert.assertEquals(0, symbolTable.get("b").getBlock());

        Assert.assertEquals(SymbolProperties.Category.PARAM, symbolTable.get("c").getCategory());
        Assert.assertEquals(1028, symbolTable.get("c").getSize());
        Assert.assertEquals(SymbolProperties.Type.INT, symbolTable.get("c").getType());
        Assert.assertEquals(1, symbolTable.get("c").getBlock());

        Assert.assertEquals(SymbolProperties.Category.VAR, symbolTable.get("d").getCategory());
        Assert.assertEquals(1032, symbolTable.get("d").getSize());
        Assert.assertEquals(SymbolProperties.Type.REAL, symbolTable.get("d").getType());
        Assert.assertEquals(1, symbolTable.get("d").getBlock());

        Assert.assertEquals(SymbolProperties.Category.PROGRAM, symbolTable.get("P").getCategory());
        Assert.assertEquals(10230, symbolTable.get("P").getSize());
        Assert.assertEquals(SymbolProperties.Type.UNDEFINED, symbolTable.get("P").getType());
        Assert.assertEquals(0, symbolTable.get("P").getBlock());

        Assert.assertEquals(SymbolProperties.Category.PROC, symbolTable.get("Q").getCategory());
        Assert.assertEquals(10500, symbolTable.get("Q").getSize());
        Assert.assertEquals(SymbolProperties.Type.UNDEFINED, symbolTable.get("Q").getType());
        Assert.assertEquals(0, symbolTable.get("Q").getBlock());
    }

    @Test
    public void test2() {
        test1();
        symbolTable.goOut();

        Assert.assertEquals(SymbolProperties.Category.VAR, symbolTable.get("a").getCategory());
        Assert.assertEquals(1024, symbolTable.get("a").getSize());
        Assert.assertEquals(SymbolProperties.Type.INT, symbolTable.get("a").getType());
        Assert.assertEquals(0, symbolTable.get("a").getBlock());

        Assert.assertEquals(SymbolProperties.Category.VAR, symbolTable.get("b").getCategory());
        Assert.assertEquals(1026, symbolTable.get("b").getSize());
        Assert.assertEquals(SymbolProperties.Type.INT, symbolTable.get("b").getType());
        Assert.assertEquals(0, symbolTable.get("b").getBlock());

        Assert.assertNull(symbolTable.get("c"));
        Assert.assertNull(symbolTable.get("d"));

        Assert.assertEquals(SymbolProperties.Category.PROGRAM, symbolTable.get("P").getCategory());
        Assert.assertEquals(10230, symbolTable.get("P").getSize());
        Assert.assertEquals(SymbolProperties.Type.UNDEFINED, symbolTable.get("P").getType());
        Assert.assertEquals(0, symbolTable.get("P").getBlock());

        Assert.assertEquals(SymbolProperties.Category.PROC, symbolTable.get("Q").getCategory());
        Assert.assertEquals(10500, symbolTable.get("Q").getSize());
        Assert.assertEquals(SymbolProperties.Type.UNDEFINED, symbolTable.get("Q").getType());
        Assert.assertEquals(0, symbolTable.get("Q").getBlock());
    }


}
