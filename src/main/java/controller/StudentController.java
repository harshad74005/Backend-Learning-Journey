package controller;

import java.util.List;
import java.util.Scanner;

import dao.StudentDao;
import dao.StudentDaoImp;
import entith.Student;

public class StudentController {

	public static void main(String[] args) {
		StudentDao dao = new StudentDaoImp();
		Scanner sc = new Scanner(System.in);
		
		int choice;
		do
		{
			System.out.println("==============================");
			System.out.println("1 Add student");
			System.out.println("2 Fetch all Student");
			System.out.println("3 Fetch by id");
			System.out.println("4 update student");
			System.out.println("5 delete student");
			System.out.println("6 exist");
			choice = sc.nextInt();
			switch(choice)
			{
			case 1 :
				System.out.println("Enter id");
				int id = sc.nextInt();
				System.out.println("Enter name");
				String name = sc.next();
				System.out.println("Enter the marks");
				double marks = sc.nextDouble();
				Student s = new Student();
				s.setId(id);
				s.setName(name);
				s.setMarks(marks);
				dao.addStudent(s);
				break;
			case 2 :
			 dao.fetchallStudent().forEach(System.out::println);
			 break;
			case 3:
				System.out.println("Enter id ");
				int fid = sc.nextInt();
				System.out.println(dao.findbyId(fid));
				
				break;
			case 4:
				System.out.println("Enter id");
				int uid = sc.nextInt();
				Student existingId = dao.findbyId(uid);
				if(existingId != null)
				{
					System.out.println("Enter new name");
					String updatedName = sc.next();
					System.out.println("Enter new marks");
					double updatedMarks = sc.nextDouble();
					Student s1 = new Student();
					s1.setId(uid);
					s1.setName(updatedName);
					s1.setMarks(updatedMarks);
					dao.updateStudent(s1);
				}
				else
				{
					System.out.println("id not found");
				}
				break;
			case 5 :
				System.out.println("Enter id");
				int did = sc.nextInt();
				Student existedstudent = dao.findbyId(did);
				if(existedstudent != null)
				{
					dao.deleteStudent(did);
					System.out.println("Deleted");
				}
				else
				{
					System.out.println("id not found");
				}
				break;
			case 6:
			    System.out.println("🚀 Exiting application. Thank you!");
			    break;
			default:
				System.out.println("Invalid choice");
				
			}
		}while(choice != 6);
	}
}
