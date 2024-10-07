package edu.uoc.ds.samples.module3.queue;

/** Operacion que se corresponde a la suma de dos n�meros enteros.
 * Por el momento es el �nico tipo de operaci�n implementada.
 */
public class Add extends Operation {
	
	long op1,op2;

	public Add(long op1, long op2) {
		super();
		this.op1=op1;
		this.op2=op2;
	}


	public String calcular() {
		long resultado=op1+op2;
		return Long.toString(resultado);
	}

	
	public String toString() {
		return op1+" + "+op2;
	}

}
