package model;

public class Nhanvien extends Canbo {

	private String department;
    private int dayOfWork;
    private EPosition position;
	
	@Override
	public double allowance() {
		// TODO Auto-generated method stub
		double alow = 0;
		
		if(position == EPosition.STAFF) {
			alow = 500;
		} else if(position == EPosition.VICE_HEAD) {
			alow = 1000;
		}else if(position == EPosition.HEAD) {
			alow = 2000;
		}
		return alow;
	}
    
	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public int getDayOfWork() {
		return dayOfWork;
	}

	public void setDayOfWork(int dayOfWork) {
		this.dayOfWork = dayOfWork;
	}

	public EPosition getPosition() {
		return position;
	}

	public void setPosition(EPosition position) {
		this.position = position;
	}

	@Override
	public double getSalary() {
		// TODO Auto-generated method stub
		double salary = 0;
		salary = getSalaryRatio() * 730 + allowance() + dayOfWork * 30;
		return salary;
	}
	@Override
	public String toString() {
		return getName() + "," + getDepartment() + "," + getPosition() + "," + 
				getSalaryRatio() + "," + allowance() + "," + getDayOfWork() + "," + getSalary(); 
	}
}
