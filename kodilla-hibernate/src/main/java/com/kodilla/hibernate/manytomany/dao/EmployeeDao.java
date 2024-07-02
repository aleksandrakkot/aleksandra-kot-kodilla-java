package com.kodilla.hibernate.manytomany.dao;

import com.kodilla.hibernate.manytomany.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface EmployeeDao extends CrudRepository<Employee, Integer> {
    @Query(name = "Employee.findByLastName")
    List<Employee> findByLastName(String lastName);
}
