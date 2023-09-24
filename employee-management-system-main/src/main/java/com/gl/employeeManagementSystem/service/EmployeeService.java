package com.gl.employeeManagementSystem.service;

import java.util.List;

import com.gl.employeeManagementSystem.entity.Employee;

public interface EmployeeService {

	public List<Employee> getEmployees();

	public Employee addNewEmployee(Employee employee);

	public Employee getEmployeeById(long id);

	public Employee updateEmployeeById(Employee employee, long id);

	public void deleteEmployeeById(long id);

}
