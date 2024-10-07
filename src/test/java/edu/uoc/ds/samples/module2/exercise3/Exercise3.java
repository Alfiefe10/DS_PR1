package edu.uoc.ds.samples.module2.exercise3;

import edu.uoc.ds.exercises.module5.exercise3.Document;
import edu.uoc.ds.exercises.module5.exercise3.PrintingService;
import edu.uoc.ds.exercises.module5.exercise3.PriorityDocument;
import org.junit.Assert;
import org.junit.Test;

public class Exercise3 {

    @Test
    public void test() {
        Document doc1 = new Document("Doc1");
        Document doc2 = new Document("Doc2");
        Document doc3 = new Document("Doc3");
        Document doc4 = new Document("Doc4");
        Document doc5 = new Document("Doc5");
        Document doc6 = new Document("Doc6");
        PrintingService printingService = new PrintingService();

        int id1 = printingService.addDocument(doc1, 25);
        int id2 = printingService.addDocument(doc2, 12);
        int id3 = printingService.addDocument(doc3, 13);
        int id4 = printingService.addDocument(doc4, 7);
        int id5 = printingService.addDocument(doc5, 17);
        int id6 = printingService.addDocument(doc6, 44);
        // 6 docs added
        Assert.assertEquals(6, printingService.size());

        printingService.deleteDocument(id4);
        printingService.deleteDocument(id5);
        // 2 docs deleted

        Assert.assertEquals(4, printingService.size());

        // Print 3 documents
        doc2 = printingService.sendDocument();
        Assert.assertEquals("Doc2", doc2.getTitle());

        doc3 = printingService.sendDocument();
        Assert.assertEquals("Doc3", doc3.getTitle());

        doc1 = printingService.sendDocument();
        Assert.assertEquals("Doc1", doc1.getTitle());

        Assert.assertEquals(1, printingService.size());

        PriorityDocument p = (PriorityDocument) printingService.getQueue().peek();
        Assert.assertEquals("Doc6", p.getDocument().getTitle());
    }
}
