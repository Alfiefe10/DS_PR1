package edu.uoc.ds.samples.module9.dns;

/**
 * Class that implements the top 10 list.
 *
 * @author David Fíguls
 * Universitat Oberta de Catalunya (UOC)
 */
class TopTen {
    HostData[] t;
    int n;

    /**
     * Top ten builder for 10 domains.
     */
    public TopTen() {
        t = new HostData[10];
        n = 0;
    }

    /**
     * Method that searches for a host (by comparing the domain) within the top 10.
     *
     * @param h host information (contains domain, ip and number of visits).
     * @return int position within the top 10 of the host h.
     */
    private int get(HostData h) {
        int pos = 0;
        while (pos < n && t[pos] != h) pos++;
        if (pos == n || t[pos] != h) pos = -1;
        return pos;
    }

    /**
     * Method that reorders the host that occupies the pos position according to the number of visits.
     *
     * @param pos position of the host to reorder.
     */
    private void reSort(int pos) {
        while (pos - 1 >= 0 && t[pos - 1].getVisits() < t[pos].getVisits()) {
            HostData tmp = t[pos];
            t[pos] = t[pos - 1];
            t[pos - 1] = tmp;
            pos--;
        }
    }

    /**
     * Method that updates the list of the top 10 taking into account that
     * host h has received a new query.<br>
     * If the host exists in the top 10, its position is updated.<br>
     * otherwise, if the list of the top 10 is not full, it is added directly and,
     * otherwise, it is added if it has more visits than the least visited of the top 10.
     *
     * @param h host information (contains domain, ip and number of visits).
     */
    public void update(HostData h) {
        int pos = get(h);
        if (pos >= 0) { // si existe
            reSort(pos);
        } else {
            if (n < 10) t[n++] = h;
            else {
                if (t[9].getVisits() < h.getVisits()) {
                    t[9] = h;
                    reSort(9);
                }
            }
        }
    }

    /**
     * Method that returns the n most visited host.
     *
     * @param n number of hosts within the top ten.
     * @return ContHost information of the most visited host number n.
     */
    public HostData get(int n) {
        return t[n];
    }

}
 