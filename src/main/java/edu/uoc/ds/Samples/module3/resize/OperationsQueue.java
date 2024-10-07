package edu.uoc.ds.samples.module3.resize;

import edu.uoc.ds.adt.sequential.Queue;
import edu.uoc.ds.samples.module3.queue.Operation;

public class OperationsQueue extends edu.uoc.ds.samples.module3.queue.OperationsQueue {
	
	protected OperationsQueue() {
		super();
	}
	
	
	protected Queue<Operation> newQueue() {
		return new ResizableQueue<Operation>();
	}
	
	


}
