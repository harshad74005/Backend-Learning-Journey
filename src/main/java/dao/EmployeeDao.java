package dao;

import java.util.List;

import entity.Employee;

public interface EmployeeDao {

	void addEmployee(Employee e);
	List<Employee> fetchallEmployee();
	Employee fetchbyId(int id);
	void updateEmployee(Employee e);
	void deleteEmployee(int id);
}
