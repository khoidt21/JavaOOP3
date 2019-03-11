package model;

public class Giangvien extends Canbo {

	private String faculty;
	private EDegree degree;
	private int teachInHour;
	
	
	public String getFaculty() {
		return faculty;
	}


	public void setFaculty(String faculty) {
		this.faculty = faculty;
	}


	public EDegree getDegree() {
		return degree;
	}


	public void setDegree(EDegree degree) {
		this.degree = degree;
	}


	public int getTeachInHour() {
		return teachInHour;
	}


	public void setTeachInHour(int teachInHour) {
		this.teachInHour = teachInHour;
	}


	@Override
	public double allowance() {
		// TODO Auto-generated method stub
		double alow = 0;
		if(degree == EDegree.BACHELOR) {
			alow = 300;
		}else if(degree == EDegree.MASTER) {
			alow = 500;
		}else if(degree == EDegree.DOCTOR) {
			alow = 1000;
		}
		return alow;
	}


	@Override
	public double getSalary() {
		// TODO Auto-generated method stub
		double salary = 0;
		salary = getSalaryRatio() * 730 + allowance() + teachInHour * 45;
		return salary;
	}
	@Override
	public String toString() {
		return getName() + ", " + getFaculty() + ", " + getDegree() + ", " 
				+ getSalaryRatio() + ", " + allowance() 
					+ ", " + getTeachInHour() + ", " + getSalary(); 
	}
	
}
