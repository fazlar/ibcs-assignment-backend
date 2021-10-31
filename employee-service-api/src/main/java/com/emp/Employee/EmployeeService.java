package com.emp.Employee;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emp.util.CommonFunctions;
import com.emp.util.Def;
import com.emp.util.Gender;
import com.emp.util.Response;

@Service
public class EmployeeService implements CommonFunctions {

	@Autowired
	private EmployeeRepository employeeRepository;

	public Response findEmployeeList() {

		Response response = new Response();
		response.setItems(employeeRepository.findAll());

		if (!CollectionUtils.isEmpty(response.getItems())) {
			List<EmployeeEntity> empList = getListFromObject(response.getItems(), EmployeeEntity.class);
			empList.stream().forEach(emp -> {
				emp.setGenderName(Gender.getGenderByNo(emp.getGender()));
			});
			response.setItems(empList);
			return getSuccessResponse("Data Found", response);
		} else {
			response.setSuccess(false);
			return getErrorResponse("Data not found", response);
		}
	}

	public Response findEmpById(Long deptId) {

		Response response = new Response();
		response.setObj(employeeRepository.findById(deptId).get());

		if (response.getObj() != null) {
			return getSuccessResponse("Data Found", response);
		} else {
			response.setSuccess(false);
			return getErrorResponse("Data not found", response);
		}
	}

	public Response create(String reqObj) {

		EmployeeEntity employeeObj = objectMapperReadValue(reqObj, EmployeeEntity.class);

		if (employeeObj != null && employeeObj.getCode().length() < 4) {
			return getErrorResponse("Code Should Be 4 Charecter");
		}

		EmployeeEntity EmployeeEntity = employeeRepository.findByCode(employeeObj.getCode());
		if (EmployeeEntity != null) {
			return getErrorResponse("Code Should Be Unique");
		}

		if (employeeObj != null && employeeObj.getName() == null) {
			return getErrorResponse("Name Should Not Be Null");
		}

		if (employeeObj != null && !StringUtils.isEmpty(employeeObj.getName()) && employeeObj.getName().length() > 35) {
			return getErrorResponse("Name Should Be less than 35 Charecter");
		}

		Response response = new Response();
		response.setObj(employeeRepository.save(employeeObj));

		if (response.getObj() != null) {
			return getSuccessResponse("Employee Save Successfully.", response);
		} else {
			response.setSuccess(false);
			return getErrorResponse("Employee Save failed.", response);
		}

	}

	public Response update(String reqObj) {

		EmployeeEntity employeeObj = objectMapperReadValue(reqObj, EmployeeEntity.class);

		if (employeeObj != null && employeeObj.getCode().length() < 4) {
			return getErrorResponse("Code Should Be 4 Charecter");
		}

		Long count = employeeRepository.checkUniqueCode(employeeObj.getId(), employeeObj.getCode());
		if (count > 0) {
			return getErrorResponse("Code Should Be Unique");
		}

		if (employeeObj != null && employeeObj.getName() == null) {
			return getErrorResponse("Name Should Not Be Null");
		}

		if (employeeObj != null && employeeObj.getName() != null && employeeObj.getName().length() > 35) {
			return getErrorResponse("Name Should Be less than 35 Charecter");
		}

		Response response = new Response();
		response.setObj(employeeRepository.save(employeeObj));
		return getSuccessResponse("Employee Upadte successfully.", response);
	}

	public Response delete(String reqObj) {
		JSONObject json = new JSONObject(reqObj);
		Long id = Def.getLong(json, "id");
		try {
			employeeRepository.deleteById(id);
		} catch (Exception e) {
			return getErrorResponse("Employee Delete failed.");
		}
		return getSuccessResponse("Employee Successfully Deleted.");
	}
	
	public Response findGenderList() {
		Response res = getSuccessResponse("Data Found!");
		res.setItems(Gender.getGenderList());
		return res;
	}

}
