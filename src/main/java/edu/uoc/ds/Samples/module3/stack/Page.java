
package edu.uoc.ds.samples.module3.stack;

/**
 * Simplifying a page of a document,
 * represented by a string.
 */
public class Page {

    private String text;

    public Page() {
        this(null);
    }

	public Page(String text) {
		this.text = text;
	}

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public String toString() {
        return text;
    }

    public boolean equals(Object page) {
        Page p = (Page)page;
        return p.getText().equals(this.getText());
    }

}
