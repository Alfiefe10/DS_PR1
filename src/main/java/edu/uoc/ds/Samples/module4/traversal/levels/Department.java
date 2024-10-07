package edu.uoc.ds.samples.module4.traversal.levels;

import edu.uoc.ds.adt.helpers.Position;
import edu.uoc.ds.adt.sequential.List;
import edu.uoc.ds.samples.module4.GeneralTreeArrayExtensibleImpl;
import edu.uoc.ds.samples.module4.traversal.TreeTraversals;
import edu.uoc.ds.traversal.Iterator;

public class Department extends GeneralTreeArrayExtensibleImpl<Employee> {

    public void distributeParkingAreas(List<String> parkings) {
        ParkingAreaDistribution distribution = new ParkingAreaDistribution(parkings);
        distribution.levels(this);
    }


    protected class ParkingAreaDistribution extends TreeTraversals<Employee> {

        private final List<String> parkings;
        Iterator<String> it;

        public ParkingAreaDistribution(List<String> parkings) {
            this.parkings = parkings;
        }

        protected void initTraversal() {
            it = parkings.values();
        }

        protected void processPosition(Position<Employee> position) {
            String noParking = "NO";
            if (it.hasNext())
                noParking = it.next();
            position.getElem().setParkingArea(noParking);
        }

        public Iterator<String> values() {
            initTraversal();
            return it;
        }
    }

}
