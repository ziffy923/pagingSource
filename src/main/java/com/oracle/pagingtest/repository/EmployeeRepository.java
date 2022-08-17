package com.oracle.pagingtest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.oracle.pagingtest.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{    
}
