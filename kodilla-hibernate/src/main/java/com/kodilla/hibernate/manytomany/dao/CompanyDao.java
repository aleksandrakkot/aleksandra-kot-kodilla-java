package com.kodilla.hibernate.manytomany.dao;

import com.kodilla.hibernate.manytomany.Company;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CompanyDao extends CrudRepository<Company, Integer> {
    @Query(name = "Company.findByNamePrefix")
    List<Company> findByNamePrefix(String namePrefix);
}
