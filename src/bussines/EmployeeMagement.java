package bussines;

import java.util.ArrayList;
import java.util.Scanner;

import model.Canbo;
import model.EDegree;
import model.EPosition;
import model.Giangvien;
import model.Nhanvien;

public class EmployeeMagement {
	
	ArrayList<Canbo> dsCanbo;
	
	public EmployeeMagement() {
		 dsCanbo = new ArrayList<Canbo>();
	}
	
	public ArrayList<Canbo> getDsCanbo() {
		 return dsCanbo;
	}
	
	public void addEmployee() {

		
		 Scanner scanner = new Scanner(System.in);
		 System.out.println("Do you want to create a Staff or a Teacher (enter S for Staff,otherwise for Teacher)?");
		 String choice = scanner.nextLine();
		 
		 if(choice.equals("s")) {
			 
			 Nhanvien emp = new Nhanvien();
			 System.out.println("Name: ");
			 String name = scanner.nextLine();
			 emp.setName(name);
			 System.out.println("Salary ratio: ");
			 double salaryRatio = scanner.nextDouble();
			 emp.setSalaryRatio(salaryRatio);
			 System.out.println("Department: ");
			 
			 scanner.nextLine();
			 String department = scanner.nextLine();
			 emp.setDepartment(department);
			 
			 System.out.println("Position (1=HEAD; 2=VICE HEAD; 3=STAFF) : ");
			 int position = scanner.nextInt();
			 if(position == 1) {
				 emp.setPosition(EPosition.HEAD);
			 }else if(position == 2) {
				 emp.setPosition(EPosition.VICE_HEAD);
			 }else if(position == 3) {
				 emp.setPosition(EPosition.STAFF);
			 }
			 System.out.println("Number of working days: ");
			 int numberDay = scanner.nextInt();
			 emp.setDayOfWork(numberDay);
			 dsCanbo.add(emp);
			 
		 }else if(choice.equals("t")) {
			 
			 Giangvien emp = new Giangvien();
			 System.out.println("Name: ");
			 String name = scanner.nextLine();
			 emp.setName(name);
			 System.out.println("Salary ratio: ");
			 double salaryRatio = scanner.nextDouble();
			 emp.setSalaryRatio(salaryRatio);
			 scanner.nextLine();
			 System.out.println("Faculty: ");
			 String faculty = scanner.nextLine();
			 emp.setFaculty(faculty);
			 System.out.println("Position (1=BACHELOR; 2=MASTER; 3=DOCTOR) : ");
			 int position = scanner.nextInt();
			 if(position == 1) {
				 emp.setDegree(EDegree.BACHELOR);
			 }else if(position == 2) {
				 emp.setDegree(EDegree.MASTER);
			 }else if(position == 3) {
				 emp.setDegree(EDegree.DOCTOR);
			 }
			 System.out.println("Number of teaching hours: ");
			 int hour = scanner.nextInt();
			 emp.setTeachInHour(hour);
			 
			 dsCanbo.add(emp);		 
		 }
		 
		 
		 

	}
	
	public void display(ArrayList<Canbo> s) {
		
		
		System.out.println("Name, Fac/Dept, Deg/Pos, Sal Ratio, Allowance, T.Hours/W.Days, Salary ");
		for (int i = 0; i < s.size(); i++) {
			 System.out.println(s.get(i));
		}
	}
	
	public ArrayList<Canbo> searchbyName(String name) {
		
		ArrayList<Canbo> sName = new ArrayList<Canbo>();
		for (int i = 0; i <dsCanbo.size(); i++) {
			if(dsCanbo.get(i).getName().contains(name)) {
			    sName.add(dsCanbo.get(i));
			    
			}
		}
		return sName;
	}
	
	public ArrayList<Canbo> searchbyDepFactury(String depfac){
		
		ArrayList<Canbo> sDept = new ArrayList<Canbo>();
		for (int i = 0; i <dsCanbo.size(); i++) {
			if(dsCanbo.get(i) instanceof Nhanvien) {
			    Nhanvien temp = (Nhanvien) dsCanbo.get(i);
			    if(temp.getDepartment().contains(depfac)) {
			    	sDept.add(dsCanbo.get(i));
			    }
			}
			if(dsCanbo.get(i) instanceof Giangvien) {
			    Giangvien temp = (Giangvien) dsCanbo.get(i);
			    if(temp.getFaculty().contains(depfac)) {
			    	sDept.add(dsCanbo.get(i));
			    }
			}
		}
		return sDept;
	}
	
}
