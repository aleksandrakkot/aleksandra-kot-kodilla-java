package com.kodilla.hibernate.manytomany.dao;

import com.kodilla.hibernate.manytomany.Company;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyDao extends CrudRepository<Company, Integer> {

    @Query("SELECT c FROM Company c WHERE c.name LIKE :nameFragment")
    List<Company> findByNameFragment(String nameFragment);
}