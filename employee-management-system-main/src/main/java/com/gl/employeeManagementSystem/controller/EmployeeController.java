package com.gl.employeeManagementSystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.gl.employeeManagementSystem.entity.Employee;
import com.gl.employeeManagementSystem.service.EmployeeService;

@Controller
public class EmployeeController {

	@Autowired
	private EmployeeService empService;

	@GetMapping("/employees")
	public String getEmployees(Model model) {
		model.addAttribute("employees", empService.getEmployees());
		return "employees";
	}

	@GetMapping("/employees/new")
	public String createEmployeeForm(Model model) {
		Employee employee = new Employee();
		model.addAttribute("employee", employee);
		return "create_employee";
	}

	@PostMapping("/employees")
	public String saveEmployee(@ModelAttribute("employee") Employee employee) {
		empService.addNewEmployee(employee);
		return "redirect:/employees";
	}

	@GetMapping("/employees/edit/{id}")
	public String updateEmployeeForm(@PathVariable Long id, Model model) {
		model.addAttribute("employee", empService.getEmployeeById(id));
		return "edit_employee";
	}

	@PostMapping("/employees/{id}")
	public String updateEmployee(@PathVariable Long id, @ModelAttribute("employee") Employee e) {
		empService.updateEmployeeById(e, id);
		return "redirect:/employees";
	}

	@GetMapping("/employees/{id}")
	public String deleteEmployeeById(@PathVariable Long id) {
		empService.deleteEmployeeById(id);
		return "redirect:/employees";
	}

}
