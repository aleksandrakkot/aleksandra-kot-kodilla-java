package com.kodilla.hibernate.manytomany.dao;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CompanyDaoTestSuite {

    @Autowired
    private CompanyDao companyDao;

    @Autowired
    private EmployeeDao employeeDao;

    @BeforeEach
    public void setup() {
        // Clean up the database before each test
        companyDao.deleteAll();
        employeeDao.deleteAll();
    }

    @Test
    void testSaveManyToMany() {
        //Given
        Employee johnSmith = new Employee("John", "Smith");
        Employee stephanieClarckson = new Employee("Stephanie", "Clarckson");
        Employee lindaKovalsky = new Employee("Linda", "Kovalsky");

        Company softwareMachine = new Company("Software Machine");
        Company dataMaesters = new Company("Data Maesters");
        Company greyMatter = new Company("Grey Matter");

        softwareMachine.getEmployees().add(johnSmith);
        dataMaesters.getEmployees().add(stephanieClarckson);
        dataMaesters.getEmployees().add(lindaKovalsky);
        greyMatter.getEmployees().add(johnSmith);
        greyMatter.getEmployees().add(lindaKovalsky);

        johnSmith.getCompanies().add(softwareMachine);
        johnSmith.getCompanies().add(greyMatter);
        stephanieClarckson.getCompanies().add(dataMaesters);
        lindaKovalsky.getCompanies().add(dataMaesters);
        lindaKovalsky.getCompanies().add(greyMatter);

        //When
        companyDao.save(softwareMachine);
        int softwareMachineId = softwareMachine.getId();
        companyDao.save(dataMaesters);
        int dataMaestersId = dataMaesters.getId();
        companyDao.save(greyMatter);
        int greyMatterId = greyMatter.getId();

        //Then
        assertNotEquals(0, softwareMachineId);
        assertNotEquals(0, dataMaestersId);
        assertNotEquals(0, greyMatterId);

        //CleanUp
        try {
            companyDao.deleteById(softwareMachineId);
           companyDao.deleteById(dataMaestersId);
           companyDao.deleteById(greyMatterId);
        } catch (Exception e) {
            //do nothing
        }
    }

    @Test
    public void testFindByNamePrefix() {
        // Given
        Company company1 = new Company("Kodilla");
        Company company2 = new Company("Kodoland");
        Company company3 = new Company("Akademia");
        companyDao.save(company1);
        companyDao.save(company2);
        companyDao.save(company3);

        // When
        List<Company> companies = companyDao.findByNamePrefix("Kod");

        // Then
        assertEquals(2, companies.size());
    }

    @Test
    public void testFindByLastName() {
        // Given
        Employee employee1 = new Employee("John", "Doe");
        Employee employee2 = new Employee("Jane", "Doe");
        employeeDao.save(employee1);
        employeeDao.save(employee2);

        // When
        List<Employee> employees = employeeDao.findByLastName("Doe");

        // Then
        assertEquals(2, employees.size());
    }
}