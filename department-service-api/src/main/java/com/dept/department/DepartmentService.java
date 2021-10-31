package com.dept.department;

import org.apache.commons.collections.CollectionUtils;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dept.util.CommonFunctions;
import com.dept.util.Def;
import com.dept.util.Response;

@Service
public class DepartmentService extends Def implements CommonFunctions {

	@Autowired
	private DepartmentRepository departmentRepository;

	public Response findDepartmentList() {
		Response response = new Response();
		response.setItems(departmentRepository.findAll());

		if (!CollectionUtils.isEmpty(response.getItems())) {
			return getSuccessResponse("Data Found", response);
		} else {
			response.setSuccess(false);
			return getErrorResponse("Data not found", response);
		}
	}

	public Response findDeptById(Long deptId) {
		Response response = new Response();
		response.setObj(departmentRepository.findById(deptId).get());

		if (response.getObj() != null) {
			return getSuccessResponse("Data Found", response);
		} else {
			response.setSuccess(false);
			return getErrorResponse("Data not found", response);
		}
	}

	public Response create(String reqObj) {

		DepartmentEntity departmentObj = objectMapperReadValue(reqObj, DepartmentEntity.class);

		Response response = new Response();
		response.setObj(departmentRepository.save(departmentObj));

		if (response.getObj() != null) {
			return getSuccessResponse("Department Save Successfully.", response);
		} else {
			response.setSuccess(false);
			return getErrorResponse("Department Save failed.", response);
		}
	}

	public Response update(String reqObj) {

		DepartmentEntity departmentObj = objectMapperReadValue(reqObj, DepartmentEntity.class);

		Response response = new Response();
		response.setObj(departmentRepository.save(departmentObj));

		if (response.getObj() != null) {
			return getSuccessResponse("Department update Successfully.", response);
		} else {
			response.setSuccess(false);
			return getErrorResponse("Department Update Failed.", response);
		}

	}

	public Response delete(String reqObj) {
		
		JSONObject json = new JSONObject(reqObj);
		Long id = Def.getLong(json, "id");
		try {
			departmentRepository.deleteById(id);
		} catch (Exception e) {
			return getErrorResponse("Department Delete failed.");
		}
		return getSuccessResponse("Department Successfully Deleted.");

	}

}
