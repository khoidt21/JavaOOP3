package model;

public abstract class Canbo {
	
	private String name;
	private double salaryRatio;
	
	public abstract double allowance();
	public abstract double getSalary();
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSalaryRatio() {
		return salaryRatio;
	}
	public void setSalaryRatio(double salaryRatio) {
		this.salaryRatio = salaryRatio;
	}
	
	
}
