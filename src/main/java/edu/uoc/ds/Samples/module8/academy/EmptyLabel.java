package edu.uoc.ds.samples.module8.academy;

class EmptyLabel {

    private static final EmptyLabel singleton = new EmptyLabel();

    public EmptyLabel getEmptyLabel() {
        return singleton;
    }

}


