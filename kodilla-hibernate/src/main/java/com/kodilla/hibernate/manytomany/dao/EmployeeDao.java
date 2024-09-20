package com.kodilla.hibernate.manytomany.dao;

import com.kodilla.hibernate.manytomany.Employee;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeDao extends CrudRepository<Employee, Integer> {

    @Query("SELECT e FROM Employee e WHERE e.lastName LIKE :lastNameFragment")
    List<Employee> findByLastNameFragment(String lastNameFragment);
}