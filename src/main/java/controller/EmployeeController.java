package controller;

import java.util.Scanner;

import dao.EmployeeDao;
import dao.EmployeeDaoImp;
import entity.Employee;

public class EmployeeController {

	public static void main(String[] args) {
		EmployeeDao dao = new EmployeeDaoImp();
		Scanner sc = new Scanner(System.in);
		int choice;
		do
		{
			System.out.println("=======================================");
			System.out.println("1 AddEmployee : ");
			System.out.println("2 Fetch All Employee : ");
			System.out.println("3 Fetch by id : ");
			System.out.println("4 update Employee : ");
			System.out.println("5 delete employee : ");
			System.out.println("6 exist");
			choice = sc.nextInt();
			switch(choice)
			{
			case 1:
				System.out.println("Enter id : ");
				int id = sc.nextInt();
				System.out.println("Enter Name : ");
				String name = sc.next();
				System.out.println("Enter department : ");
				String department = sc.next();
				System.out.println("Enter salary : ");
				double salary = sc.nextDouble();
				
				Employee e = new Employee(id,name,department,salary);
				dao.addEmployee(e);
				break;
			case 2 :
				dao.fetchallEmployee().forEach(System.out::println);
				break;
			case 3 :
				System.out.println("Enter id");
				int fid = sc.nextInt();
				Employee e2 = dao.fetchbyId(fid);
				System.out.println(e2.toString());
				break;
			case 4 :
				System.out.println("Enter id ");
				int uid = sc.nextInt();
				Employee e1 = dao.fetchbyId(uid);
				if(e1 !=null)
				{
					System.out.println("Enter the name : ");
					String uname = sc.next();
					System.out.println("Enter the department");
					String udepartment = sc.next();
					System.out.println("Enter the salary ");
					double usalary = sc.nextDouble();
					Employee employee = new Employee(uid,uname,udepartment,usalary);
					dao.updateEmployee(employee);
				}
				else
				{
					System.out.println("Id not found");
				}
				break;
			case 5:
				System.out.println("Enter id ");
				int did = sc.nextInt();
				Employee e3 = dao.fetchbyId(did);
				if(e3!=null)
				{
					dao.deleteEmployee(did);
				}
				else
				{
					System.out.println("id not found");
				}
				break;
			default :
				System.out.println("invalid choice");
				
		}
		}while(choice!=6);
	}
}
