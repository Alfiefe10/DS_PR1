package edu.uoc.ds.samples.module3.queue;

import edu.uoc.ds.adt.sequential.Queue;
import edu.uoc.ds.adt.sequential.QueueArrayImpl;


/**
 * @author Jordi Àlvarez Canal
 * @author Esteve Mariné Gallisà.
 * Universitat Oberta de Catalunya (UOC)
 * @version 2.0.0
 * @since 1.5
 */
public class OperationsQueue {

    Queue<Operation> operations;

    protected OperationsQueue() {
        operations = newQueue();
        createProcessor();
    }


    protected Queue<Operation> newQueue() {
        return new QueueArrayImpl<>();
    }

    public void addOperation(Operation operation) {
        this.operations.add(operation);
    }

    protected void createProcessor() {
        Thread processor = new Processor(operations);
        // this causes when the main program ends,
        // the processor also terminates (even if there are any left
        // operations to perform)
        processor.setDaemon(true);
        processor.start();
    }


    public int numOperations() {
        return this.operations.size();
    }
}
