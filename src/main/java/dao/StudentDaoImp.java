package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import entith.Student;

public class StudentDaoImp implements StudentDao{

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("Harshad");
	
	@Override
	public void addStudent(Student s) {
		// TODO Auto-generated method stub
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		try {
		et.begin();
		em.persist(s);
		et.commit();
		}
		catch(Exception e)
		{
			if(et.isActive())
			{
				 et.rollback();
			}
			e.printStackTrace();
		}
		finally {
			em.close();
		}
		
	}

	@Override
	public List<Student> fetchallStudent() {
		// TODO Auto-generated method stub
		EntityManager em = emf.createEntityManager();
		
		try
		{
		return em.createQuery("Select s from Student s",Student.class).getResultList();
		
		}
		finally {
			em.close();
		}
	}

	@Override
	public Student findbyId(int id) {
		// TODO Auto-generated method stub
		EntityManager em = emf.createEntityManager();
		try {
		return em.find(Student.class, id);
		}
		finally {
			em.close();
		}
	}

	@Override
	public void updateStudent(Student s) {
		// TODO Auto-generated method stub
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		try
		{
		et.begin();
		em.merge(s);
		et.commit();
		System.out.println("Data updated Successfully");
		}
		catch(Exception e)
		{
			if(et.isActive())
			{
				et.rollback();
			}
			e.printStackTrace();
		}
		finally {
			em.close();
		}
	}

	@Override
	public void deleteStudent(int id) {
		// TODO Auto-generated method stub
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		try
		{
		
		Student s= em.find(Student.class, id);
		if(s!=null)
		{
			
			et.begin();
			em.remove(s);
			et.commit();
			System.out.println("Data deleted");
		}
		
		else
		{
			System.out.println("Id not found");
		
		}
		}
		catch(Exception e)
		{
			if(et.isActive())
			{
				et.rollback();
			}
			e.printStackTrace();
		}
		finally {
			em.close();
		}
	}
 
}
