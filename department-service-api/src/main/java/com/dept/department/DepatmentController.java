package com.dept.department;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;

import com.dept.util.Response;

@RestController
@RequestMapping("/api/department")
@CrossOrigin
public class DepatmentController {
	
	@Autowired
	private DepartmentService departmentService;
	
	@GetMapping("/find-dept-list")
	public Response findDepartmentList(){
		return departmentService.findDepartmentList();
	}

	@GetMapping("/find-dept-by-id")
	public Response findDeptById(@RequestParam Long deptId){
		return departmentService.findDeptById(deptId);
	}
	
	@PostMapping("/create-dept")
	public Response create(@RequestBody String reqObj){
		return departmentService.create(reqObj);
	}

	@PutMapping("/update-dept")
	public Response update(@RequestBody String reqObj){
		return departmentService.update(reqObj);
	}
	
	@DeleteMapping("/delete-dept")
	public Response delete(@RequestBody String id){
		return departmentService.delete(id);
	}

}
