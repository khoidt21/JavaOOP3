package ul;

import java.util.InputMismatchException;
import java.util.Scanner;
import bussines.*;
public class Main {
		
		public static void main(String args[]) {
			
			Scanner sc = new Scanner(System.in);
			EmployeeMagement emp = new EmployeeMagement();
			int choice = 0;
			String s;
			
			do {
				System.out.println("University Staff Management 1.0");
				System.out.printf("\t1.Add staff\n");
				System.out.printf("\t2.Search staff by name\n");
				System.out.printf("\t3.Search staff by department/faculty\n");
				System.out.printf("\t4.Display all staff\n");
				System.out.printf("\t5.Exit\n");
				System.out.printf("Select function (1,2,3,4 or 5): ");
				
				try {
					sc = new Scanner(System.in);
					choice = sc.nextInt();
					sc.nextLine();
					
				}catch (InputMismatchException ex) {
					
					System.out.println("Nhap sai dinh dang. ");
				}
				switch (choice) {
				case 1: 
						emp.addEmployee();
						
					break;
				case 2:
					    System.out.println("Enter name to search: \n");
					    s = sc.nextLine();
					    emp.display(emp.searchbyName(s));
					    
					break;
				case 3:
					  System.out.println("Enter dept/fac to search: \n");
					  s = sc.nextLine();
					  emp.display(emp.searchbyDepFactury(s));
					  
					break;
				case 4:
					
						emp.display(emp.getDsCanbo());
						
				default:
					break;
				}
			}
			while(choice !=5);
		
			String a = "abc";
			String b = "abc";
			String c = new String("abc");
			System.out.println(a==b);//true
			System.out.println(a==c);//false
			
		}
	
}
