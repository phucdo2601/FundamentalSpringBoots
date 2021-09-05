package com.phucdn.learnRestAPICrudBasic1.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.phucdn.learnRestAPICrudBasic1.entity.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, String> {

}
