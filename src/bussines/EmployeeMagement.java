package bussines;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
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
		 readFileEmloyee();
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
			 //
			 savaFileEmployee(dsCanbo);
			 
		 }else {
			 
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
			 //
			 savaFileEmployee(dsCanbo);
			 
		 }
		 
		 
		 

	}
	
	public void display(ArrayList<Canbo> s) {
		
		Collections.sort(s);
		System.out.println("Name, Fac/Dept, Deg/Pos, Sal Ratio, Allowance, T.Hours/W.Days, Salary ");
//		sortOrderByName(s);
		for (int i = 0; i < s.size(); i++) {
			 System.out.println(s.get(i));
		}
	}
	
	public ArrayList<Canbo> searchbyName(String name) {
		
		
		ArrayList<Canbo> sName = new ArrayList<Canbo>();
		for (int i = 0; i <dsCanbo.size(); i++) {
			if(dsCanbo.get(i).getName().toUpperCase().contains(name.toUpperCase())) {
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
			    if(temp.getDepartment().toUpperCase().contains(depfac.toUpperCase())) {
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
	
	public void savaFileEmployee(ArrayList<Canbo> s) {
		
		 try {
	         
	         FileOutputStream out = new FileOutputStream("D:\\nhanvien2.txt");
	         ObjectOutputStream oout = new ObjectOutputStream(out);
	         
	         oout.writeObject(s);
	         oout.close();
	         
	      } catch (Exception ex) {
	         ex.printStackTrace();
	      }
	}
	
	public void readFileEmloyee() {
		 
		try {
			 ObjectInputStream ois = new ObjectInputStream(new FileInputStream("D:\\nhanvien2.txt"));
	       
			 dsCanbo = (ArrayList<Canbo>) ois.readObject();
			 
		 }
		 catch (Exception ex) {
			ex.printStackTrace();
		}
	}

	public void sortOrderByName(ArrayList<Canbo> s) {
		
		Canbo temp;
		
		for (int i = 0; i < dsCanbo.size(); i++) {
			 for(int j = i + 1; j < dsCanbo.size(); j++) {
				 
		          if(dsCanbo.get(i).getName().compareTo(dsCanbo.get(j).getName()) > 0) {
		        	   
		        	  temp = dsCanbo.get(i);
		        	  dsCanbo.set(i, dsCanbo.get(j));
		        	  dsCanbo.set(j, temp);     	  
		          }
		          
			 }
		}
		
		
	}
}
