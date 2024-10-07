package edu.uoc.ds.samples.module9.dns;

import edu.uoc.ds.adt.nonlinear.HashTable;

/**
 * Auxiliary class defined in order to make it clearer
 * the code, so that when defining variables and other
 * generic type we can directly use DictionaryTLDs instead
 * from HashTable<TLD, EntityDictionary>.
 */
class TLDsDictionary extends HashTable<TLD, EntityDictionary> {

	   public TLDsDictionary() {
	   	  super();
	   }

	   public TLDsDictionary(int mida) {
		   super(mida);
	   }

	   
}
