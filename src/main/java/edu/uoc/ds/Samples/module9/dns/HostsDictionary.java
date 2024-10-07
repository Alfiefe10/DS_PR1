package edu.uoc.ds.samples.module9.dns;

import edu.uoc.ds.adt.helpers.KeyValue;
import edu.uoc.ds.adt.helpers.Position;
import edu.uoc.ds.adt.sequential.DictionaryLinkedListImpl;
import edu.uoc.ds.exceptions.InvalidPositionException;
import edu.uoc.ds.traversal.Traversal;

/**
 * Class that encapsulates the representation chosen to store the hosts of each of the entities
 * of TLDs.<br>
 * In this version, the implementation of dictionaries through chained lists has been used, redefining the
 * query method to be able to rearrange hosts to optimize queries for the most recently
 * consulted.
 *
 * @author David Fíguls
 * @author Jordi Alvarez
 * Universitat Oberta de Catalunya (UOC)
 * @version 2.0.0
 */
public class HostsDictionary extends DictionaryLinkedListImpl<Host, HostData> {

    /**
     * Method that consults the data of a host starting from its domain. You are defining the method
     * original ImplListDictionary to allow reordering of hosts to optimize
     * the queries of the most recently consulted. <br>
     * To optimize the queries, we simply place the queried host at the beginning.
     *
     * @param key the Domain of the host we want to query.
     * @return HostInformation host information.
     */
    public HostData get(Host key) {
        HostData element = null;
        // get the element (clone parent class implementation)
		TraversalWithPrevious<KeyValue<Host, HostData>> r = super.searchPosition(key);
        Position<KeyValue<Host, HostData>> actual = r.current();
        if (actual != null) {
            element = actual.getElem().getValue();
            // delete the element using the previous position.
            // We do it as long as it is not the first element!!!
            Position<KeyValue<Host, HostData>> previous = r.current();
            if (previous != null) {
                super.dictionary.delete(previous);
                // we add it back to the beginning of the list
				super.dictionary.insertBeginning(actual.getElem());
            }
        }
        return element;
    }


} 