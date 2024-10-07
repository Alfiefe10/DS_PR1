package edu.uoc.ds.exercises.module9.exercise1;

import edu.uoc.ds.adt.helpers.Position;
import edu.uoc.ds.traversal.Iterator;
import edu.uoc.ds.traversal.Traversal;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Comparator;

public class PriorityQueueUpdatableTest implements  PositionalContainerObserver<PriorityQueueUpdatableTest.Event> {

    private final Comparator<PriorityQueueUpdatableTest.Event> CMP = (e1, e2)->Integer.compare(e2.rating, e1.rating);
    PriorityQueueUpdatable<Event> priorityQueueUpdatable;
    Event event1;
    Event event2;
    Event event3;
    Event event4;
    Event event5;

    Position<Event> pEvent1;
    Position<Event> pEvent2;
    Position<Event> pEvent3;
    Position<Event> pEvent4;
    Position<Event> pEvent5;

    @Before
    public void setUp() {
        priorityQueueUpdatable = new PriorityQueueUpdatable<PriorityQueueUpdatableTest.Event>(CMP);
        priorityQueueUpdatable.addObserver(this);

        event1 = new Event(5);
        event2 = new Event(1);
        event3 = new Event(4);
        event4 = new Event(2);
        event5 = new Event(3);
        priorityQueueUpdatable.add(event1);
        priorityQueueUpdatable.add(event2);
        priorityQueueUpdatable.add(event3);
        priorityQueueUpdatable.add(event4);
        priorityQueueUpdatable.add(event5);
    }

    @Test
    public void test1()  {
        Assert.assertEquals(5, priorityQueueUpdatable.size());
        Assert.assertEquals(5, priorityQueueUpdatable.peek().rating);
        Iterator<Event> it = priorityQueueUpdatable.values();
        Assert.assertEquals(5, it.next().rating);
        Assert.assertEquals(4, it.next().rating);
        Assert.assertEquals(3, it.next().rating);
        Assert.assertEquals(2, it.next().rating);
        Assert.assertEquals(1, it.next().rating);
        Assert.assertFalse(it.hasNext());
    }

    @Test
    public void test2() {
        pEvent3.getElem().rating = 200;
        priorityQueueUpdatable.updatePosition(pEvent3);
        Assert.assertEquals(200, priorityQueueUpdatable.peek().rating);

        pEvent4.getElem().rating = 500;
        priorityQueueUpdatable.updatePosition(pEvent4);
        Assert.assertEquals(500, priorityQueueUpdatable.peek().rating);

        pEvent1.getElem().rating = 0;
        priorityQueueUpdatable.updatePosition(pEvent1);
        Assert.assertEquals(500, priorityQueueUpdatable.peek().rating);

        Iterator<Event> it = priorityQueueUpdatable.values();
        Assert.assertEquals(500, it.next().rating);
        Assert.assertEquals(200, it.next().rating);
        Assert.assertEquals(5, it.next().rating);
        Assert.assertEquals(2, it.next().rating);
        Assert.assertEquals(0, it.next().rating);
        Assert.assertFalse(it.hasNext());


    }

    @Override
    public void notifyNewPosition(Position<Event> position) {
        switch (position.getElem().rating) {
            case 1: pEvent1 = position;
                    break;
            case 2: pEvent2 = position;
                    break;
            case 3: pEvent3 = position;
                    break;
            case 4: pEvent4 = position;
                    break;
            case 5: pEvent5 = position;
                    break;
        }
        position.getElem().setPosition(position);
    }

    @Override
    public void notifyDeletedPosition(Position<Event> position) {

    }


    protected class Event implements Comparator<Event> {
        int rating;
        Position<Event> position;

        protected Event(int rating) {
            this.rating = rating;
        }

        @Override
        public int compare(Event o1, Event o2) {
            return Integer.compare(o1.rating, o2.rating);
        }

        public Position<Event> getPosition(){
            return position;
        }

        public void setPosition(Position<Event> position) {
            this.position = position;
        }

        public String toString() {
            return ""+rating;
        }
    }
}
