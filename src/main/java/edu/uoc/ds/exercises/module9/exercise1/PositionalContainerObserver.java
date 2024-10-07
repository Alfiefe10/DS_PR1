package edu.uoc.ds.exercises.module9.exercise1;

import edu.uoc.ds.adt.helpers.Position;

public interface PositionalContainerObserver<E> {
	
	void notifyNewPosition(Position<E> position);
	void notifyDeletedPosition(Position<E> position);

}
