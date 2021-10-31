package com.emp.Employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long>{

	public EmployeeEntity findByCode(String code);
	
	@Query(value = "select count(emp.id) from employee emp where emp.id <> ? and emp.code = ?;",nativeQuery=true)
	public Long checkUniqueCode(Long id, String code);
	
}
