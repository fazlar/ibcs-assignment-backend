package com.emp.Employee;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.springframework.web.bind.annotation.CrossOrigin;

@Entity
@Table(name = "employee")
@CrossOrigin
public class EmployeeEntity {

	@Id
	@GeneratedValue(strategy =GenerationType.AUTO )
	@Column(name="ID")
	private Long id;
	

	@Size(min = 4)
	@Column(name="CODE", unique = true)
	private String code;
	
	@NotNull
	@Size(max = 35)
	@Column(name="NAME")
	private String name;

	@Column(name="DOB")
	private Date dob;
	
	@Column(name="GENDER")
	private Long gender;
	
	@Column(name="MOBILE")
	private String mobile;	
	
	@Column(name="DEPT_ID")
	private String deptId;
	
	@Transient
	private String GenderName;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public Long getGender() {
		return gender;
	}

	public void setGender(Long gender) {
		this.gender = gender;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getDeptId() {
		return deptId;
	}

	public void setDeptId(String deptId) {
		this.deptId = deptId;
	}

	public String getGenderName() {
		return GenderName;
	}

	public void setGenderName(String genderName) {
		GenderName = genderName;
	}	
	
}
