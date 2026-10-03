package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

import entity.Employee;

public class EmployeeDaoImp implements EmployeeDao{

	EntityManagerFactory emf = Persistence.createEntityManagerFactory("Harshad");
	@Override
	public void addEmployee(Employee e) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		try {
			et.begin();
			em.persist(e);
			et.commit();
			System.out.println("Data inserted");
		}
		catch(Exception e1)
		{
			if(et.isActive())
			{
				et.rollback();
			}
			e1.printStackTrace();
		}
		finally {
			em.close();
		}
		
		
	}

	@Override
	public List<Employee> fetchallEmployee() {
		// TODO Auto-generated method stub
		EntityManager em = emf.createEntityManager();
		try {
		return em.createQuery("select e from Employee e",Employee.class).getResultList();
		}
		finally {
			em.close();
		}
	}

	@Override
	public Employee fetchbyId(int id) {
		EntityManager em = emf.createEntityManager();
		try
		{
			return em.find(Employee.class, id);
		}
		finally {
			em.close();
		}
	}

	@Override
	public void updateEmployee(Employee e) {
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		
		try {
			et.begin();
			em.merge(e);
			et.commit();
			System.out.println("Employye updated");
		}
		catch(Exception e1)
		{
			if(et.isActive())
			{
				et.rollback();
			}
			e1.printStackTrace();
		}
		finally {
			em.close();
		}
		
	}

	@Override
	public void deleteEmployee(int id) {
		// TODO Auto-generated method stub
		EntityManager em = emf.createEntityManager();
		EntityTransaction et = em.getTransaction();
		Employee e = em.find(Employee.class, id);
		if(e!=null)
		{
		try
		{
			et.begin();
			em.remove(e);
			et.commit();
			
		}
		catch(Exception e1)
		{
			if(et.isActive())
			{
				et.rollback();
			}
			e1.printStackTrace();
		}
		finally {
			em.close();
		}
		}
		else
		{
			System.out.println("id not found");
		}
		
	}

}
