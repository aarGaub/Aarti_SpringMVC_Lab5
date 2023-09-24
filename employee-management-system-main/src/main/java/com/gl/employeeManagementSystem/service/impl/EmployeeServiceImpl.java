package com.gl.employeeManagementSystem.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.gl.employeeManagementSystem.entity.Employee;
import com.gl.employeeManagementSystem.repository.EmployeeRepository;
import com.gl.employeeManagementSystem.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	private EmployeeRepository empRepository;

	@Override
	public List<Employee> getEmployees() {

		return empRepository.findAll();

	}

	@Override
	public Employee addNewEmployee(Employee employee) {

		return this.empRepository.save(employee);
	}

	@Override
	public Employee getEmployeeById(long id) {

		return this.empRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid Employee Id"));

	}

	@Override
	public Employee updateEmployeeById(Employee employee, long id) {

		Employee e = this.getEmployeeById(id);
		e.setFirstName(employee.getFirstName());
		e.setLastName(employee.getLastName());
		e.setEmail(employee.getEmail());
		this.empRepository.save(e);
		return e;
	}

	@Override
	public void deleteEmployeeById(long id) {

		this.empRepository.deleteById(id);
	}

}
