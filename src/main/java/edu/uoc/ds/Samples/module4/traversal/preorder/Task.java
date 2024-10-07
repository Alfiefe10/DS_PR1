package edu.uoc.ds.samples.module4.traversal.preorder;

public class Task {

	private final String name;
	private final double percentageResources;
	private double absoluteResources;
	
	
	public Task(String nombre, double recursosPorcentaje) {
		this.name =nombre;
		this.percentageResources =recursosPorcentaje;
		absoluteResources =-1;
	}
	
	
	public String getName() { return name; }
	public double getPercentageResources() { return percentageResources; }
	public double getAbsoluteResources() { return absoluteResources; }
	public void setAbsoluteResources(double absoluteResources) { this.absoluteResources = absoluteResources; }
	
	public String toString() {
		return "["+ name +",P:"+ percentageResources +
			(absoluteResources ==-1 ? "]"
					: ",A:"+ absoluteResources +"]");
	}
	
}
