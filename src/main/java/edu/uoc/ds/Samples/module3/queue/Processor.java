package edu.uoc.ds.samples.module3.queue;

import edu.uoc.ds.adt.sequential.Queue;

/**
 * Simulates an operations processor that can perform an operation
 * every OPERATION_PROCESSING_TIME seconds.
 * This processor reads the operations to be performed from a queue. Every time
 * that performs an operation writes the result to the screen.
 */
public class Processor extends Thread {

    private static final int OPERATION_PROCESSING_TIME = 10;

    private final Queue<Operation> operations;

    public Processor(Queue<Operation> queue) {
        super();
        operations = queue;
    }

    public void run() {
        // The try/catch is needed by the sleep statement
        // (see documentation of the JDK itself)
        try {
        // main body of the processor: read operations
        // from the queue, and processes them, with the corresponding wait
        // (which simulates a fairly high processing time)
        while (true) {
            // This synchronization block is necessary to prevent the thread from
            // processor (this) and user (main) try to access at the same time
            // to queu.
            synchronized (operations) {
                // we will only process the next operation in the queue, if
                // it is available
                if (!operations.isEmpty()) {
                    Operation op = operations.poll();
                    System.out.println("processing: " + op);
                    System.out.println("result: " + op.calcular());
                    System.out.println("number of pending operations: " + operations.size());
                }
            }
            sleep(OPERATION_PROCESSING_TIME * 1000);
        }
    } catch(InterruptedException e) {
        System.out.println("Thread interrupted while it was waiting to process the next operation.");
    }
}

}
