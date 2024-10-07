package edu.uoc.ds.samples.module1.defensive;

public interface DefensiveNat {
	
	/** This method increases the value of the natural.
	 * @pre true
	 * @post consultar() == $old(consultar())+1
	 */
	void succ();

	/** This method decreases the value of the natural.
	 * @pre get()>0
	 * @post get() == $old(get())-1
	 */
	void pred() throws NatException;
	
	/** This method adds a natural to the object.
	 * @pre true
	 * @post get() == $old(get())+y.get()
	 * @param y The natural to add.
	 */
	void addAmount(DefensiveNat y);
	
	/** Method that returns the value of the
	 * natural as an integer.
	 * @return the value of the object.
	 */
	int get();
}
