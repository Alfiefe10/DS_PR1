
package edu.uoc.ds.samples.module3.stack;

import edu.uoc.ds.adt.sequential.Stack;
import edu.uoc.ds.adt.sequential.StackArrayImpl;

/**
 * Representation of a document as a array of pages.
 */
public class Document {

    private final Page[] pages;
    private int numPages;

    public static final boolean REVERSE = true;


    Document(int numPages) {
        pages = new Page[numPages];
        this.numPages = 0;
    }


    public void add(Page pagina) {
        pages[numPages] = pagina;
        numPages++;
    }

    public int getNumPages() {
        return numPages;
    }

    public Page getPage(int p) {
        return pages[p];
    }

    public boolean isFull() {
        return numPages == pages.length;
    }


    protected Document rotate() {
        Document reverseDoc = new Document(pages.length);
        Stack<Page> stack = new StackArrayImpl<Page>(pages.length);
        for (int i = 0; i < numPages; i++)
            stack.push(pages[i]);
        while (!stack.isEmpty())
            reverseDoc.add(stack.pop());
        return reverseDoc;
    }


    public String print(boolean rotate) {
        Document docAux =
                rotate ? rotate() : this;
        return toString();
    }


    public String toString() {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < numPages; i++)
            sb.append(pages[i].toString());
        return sb.toString();
    }

}
