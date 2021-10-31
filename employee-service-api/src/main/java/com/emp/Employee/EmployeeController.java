package com.emp.Employee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.emp.util.Response;

@RestController
@RequestMapping("/api/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeService;

	@GetMapping("/find-emp-list")
	public Response findEmployeetList() {
		return employeeService.findEmployeeList();
	}

	@GetMapping("/find-emp-by-id")
	public Response findEmpById(@RequestParam Long empId) {
		return employeeService.findEmpById(empId);
	}

	@PostMapping("/create-emp")
	public Response create(@RequestBody String reqObj) {
		return employeeService.create(reqObj);
	}

	@PutMapping("/update-emp")
	public Response update(@RequestBody String reqObj) {
		return employeeService.update(reqObj);
	}

	@DeleteMapping("/delete-emp")
	public Response delete(@RequestBody String reqObj) {
		return employeeService.delete(reqObj);
	}

	@GetMapping("/find-gender-list")
	public Response findGenderList() {
		return employeeService.findGenderList();
	}

	
}
