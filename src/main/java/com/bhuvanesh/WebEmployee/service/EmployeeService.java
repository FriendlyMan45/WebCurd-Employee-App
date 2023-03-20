package com.bhuvanesh.WebEmployee.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import com.bhuvanesh.WebEmployee.entity.Employee;
import com.bhuvanesh.WebEmployee.repository.EmployeeRepository;


@Service
public class EmployeeService {

	@Autowired
	private EmployeeRepository repository;
	
	
	public String getEmployee() {
		return "from employee";
	}
	public ModelAndView mav() {
		ModelAndView mav=new ModelAndView("List-Employees");
		List<Employee> list=repository.findAll();
		return mav.addObject("employees", list);
	}
	
	public ModelAndView addEmployeeForm() {
		ModelAndView mav=new ModelAndView("Add-Employee-Form");
		Employee newEmpolyee=new Employee();
		return mav.addObject("employee", newEmpolyee);
	}
	
	public Employee toSave(Employee employee) {	
	   return repository.save(employee);
	}
	
	public ModelAndView toUpdate(Long id) {
		ModelAndView mav=new ModelAndView("Add-Employee-Form");
		Employee existing=repository.findById(id).get();
		return mav.addObject("employee", existing);
	}
	
	
	public String toDelete(Long id) {
		repository.deleteById(id);
		return "";
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
