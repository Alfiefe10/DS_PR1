package edu.uoc.ds.exercises.module5.exercise3;


import edu.uoc.ds.adt.nonlinear.PriorityQueue;
import edu.uoc.ds.adt.sequential.LinkedList;
import edu.uoc.ds.adt.sequential.List;
import edu.uoc.ds.traversal.Iterator;

public class PrintingService {

    /**
     * Queue
     */
    private final PriorityQueue<PriorityDocument> queue;

    /**
     * Identifier for a new arriving document
     */
    private int ident;


    public PrintingService() {
        ident = 0;
        queue = new PriorityQueue<PriorityDocument>();
    }

    public PriorityQueue getQueue() {
        return (queue);
    }


    public int addDocument(Document document, int priority) {
        PriorityDocument docP = new PriorityDocument(document, priority, ident);
        queue.add(docP);
        return (ident++);
    }


    public void deleteDocument(int id) {
        List<PriorityDocument> auxList = new LinkedList<>();
        boolean found = false;
        while (!queue.isEmpty() && !found) {
            PriorityDocument docE = queue.poll();
            if (docE.getIdentifier() == id) found = true;
            else auxList.insertEnd(docE);
        }
        Iterator<PriorityDocument> docs = auxList.values();
        while (docs.hasNext())
            queue.add(docs.next());
    }


    public Document sendDocument() {
        Document ret = null;
        if (!queue.isEmpty()) {
            PriorityDocument doc = queue.poll();
            //print(doc.getDocument());
            ret = doc.getDocument();
        }
        return ret;
    }

    private void print(Document document) {
        System.out.println(document);
    }

    public int size() {
        return queue.size();
    }
}
