package edu.uoc.ds.samples.module4.traversal.inorder;

import edu.uoc.ds.adt.helpers.Position;
import edu.uoc.ds.adt.nonlinear.BinaryTreeLinkedImpl;
import edu.uoc.ds.samples.module4.traversal.BinaryTreeTraversal;

import java.util.Date;


public class TasksTree extends BinaryTreeLinkedImpl<Task> {

    public void planningTasks(Date start) {
        TaskScheduler scheduler = new TaskScheduler(start);
        scheduler.inOrder(this);
    }


    /**
     * This class has an attribute
     * special that refers to the previous position visited. This technique
     * It allows us to have a very simple position to deal with. Note but that
     * imposes a restriction as well: an instance of Task Scheduler only
     * will allow us to take one tour at a time!!!
     *
     * @author Jordi Alvarez
     * @author Esteve Marine
     *
     * Universitat Oberta de Catalunya (UOC)
     */
    protected class TaskScheduler extends BinaryTreeTraversal<Task> {

        Date start;
        Task previous;

        TaskScheduler(Date start) {
            this.start = start;
        }

        protected void initTraversal() {
            previous = null;
        }

        protected void processPosition(Position<Task> position) {
            Task task = position.getElem();
            if (previous != null) {
                long beginning = previous.getStart().getTime() + previous.getMinDuration() * 60000;
                task.setStart(new Date(beginning));
            } else {
                task.setStart(start);
            }

            previous = task;
        }
    }


}
