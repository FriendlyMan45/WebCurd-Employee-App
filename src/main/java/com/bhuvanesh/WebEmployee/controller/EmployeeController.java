package com.bhuvanesh.WebEmployee.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import com.bhuvanesh.WebEmployee.entity.Employee;
import com.bhuvanesh.WebEmployee.service.EmployeeService;

@RestController
public class EmployeeController {
	
	@Autowired
	private EmployeeService service;
	
	@GetMapping("/get")
	public String toget() {
		return "String";
	}
	
	@GetMapping({"/getEmployee","/","/List"})
	public ModelAndView getEmployee() {
		return service.mav();
	}
	
	@GetMapping("/addEmployeeForm")
	public ModelAndView addEmployee() {
		return service.addEmployeeForm();
	}
	
	@PostMapping("/saveEmployee")
	public RedirectView saveEmployee(Employee employee) {
	    service.toSave(employee);
	    RedirectView rv=new RedirectView();
	    rv.setUrl("/List");
	    return rv;
	}
	
	
	@GetMapping("/showUpdateForm")
	public ModelAndView UpdateEmployee(@RequestParam Long employeeId) {
		return service.toUpdate(employeeId);
	}
	
	@GetMapping("/deleteEmployee")
	public RedirectView deleteEmployee(@RequestParam Long employeeId) {
		 service.toDelete(employeeId);
		RedirectView rv=new RedirectView();
		 rv.setUrl("/List");
		 return rv;
	}
 
}
