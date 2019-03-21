package model;

import java.io.Serializable;

public abstract class Canbo implements Serializable, Comparable<Canbo> {
	
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
	
	@Override
	public int compareTo(Canbo o) {
		// TODO Auto-generated method stub
		if(this.getName().compareTo(o.getName()) == 0) {
		    return (int) (this.getSalary() - o.getSalary());
		}
		return this.getName().compareTo(o.getName());
		
	}
	
	
	
}
