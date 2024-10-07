package edu.uoc.ds.samples.module4.traversal.preorder;

import edu.uoc.ds.adt.helpers.Position;
import edu.uoc.ds.adt.nonlinear.GeneralTreeDelImpl;
import edu.uoc.ds.samples.module4.traversal.TreeTraversals;
import edu.uoc.ds.traversal.Traversal;

public class TaskTree extends GeneralTreeDelImpl<Task> {

    public void distributeTasks() {
        TaskDistributor distribution = new TaskDistributor();
        distribution.preOrder(this);
    }

    protected class TaskDistributor extends TreeTraversals<Task> {

        protected void processPosition(Position<Task> position) {
            double absoluteResourcesParent = position.getElem().getAbsoluteResources();
            Traversal<Task> children = children(position);
            while (children.hasNext()) {
                Task childTask = children.next().getElem();
                childTask.setAbsoluteResources(absoluteResourcesParent * childTask.getPercentageResources() / 100);
            }
        }
    }
}
