package edu.uoc.ds.samples.module1.defensive;

/**
 * Defensive version of NatiImpl.
 */

public class DefensiveiNatImpl implements DefensiveNat {
	
	private int nat;

	public DefensiveiNatImpl() { nat=0; }

	public void pred() throws NatException {
		if (nat==0)
                throw new NatException("There is no predecessor of 0");
            nat--;
	}

	public void succ() { nat++;	}
	public void addAmount(DefensiveNat y) { nat+=y.get(); }
	
	/**
	 * @pre true
	 * @post nat==initial(nat)
	 * @return nat
	 */
	public int get() { return nat; }

	/** Returns a representation in text format of the
	 * natural.
	 * @pre true
	 * @post nat==initial(nat)
	 */
	public String toString() {
		return Integer.toString(get());
	}

}
