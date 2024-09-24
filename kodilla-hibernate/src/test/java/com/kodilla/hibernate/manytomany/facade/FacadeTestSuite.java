package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import jakarta.transaction.Transactional;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
public class FacadeTestSuite {

    @Autowired
    private CompanyDao companyDao;

    @Autowired
    private EmployeeDao employeeDao;

    @Autowired
    private CompanyEmployeeFacade facade;

    @Test
    void testRetrievingEmployee() throws SearchingException {
        // Given
        Employee janNowak = new Employee("Jan", "Nowak");
        Employee stephanieNowak = new Employee("Stephanie", "Nowak");
        Employee lindaBiden = new Employee("Linda", "Biden");
        Employee peterBiden = new Employee("Peter", "Biden");
        Employee johnPierce = new Employee("John", "Pierce");

        employeeDao.save(janNowak);
        employeeDao.save(stephanieNowak);
        employeeDao.save(lindaBiden);
        employeeDao.save(peterBiden);
        employeeDao.save(johnPierce);

        // When
        List<Employee> employeeList = facade.findEmployeesByFragment("Now");

        // Then
        try {
            assertEquals(2, employeeList.size());
        } finally {
            // CleanUp
            employeeDao.deleteAll(employeeList);
        }
    }

    @Test
    void testRetrievingCompany() throws SearchingException {
        // Given
        Company smallCompany = new Company("SmallCompany");
        Company smallerCompany = new Company("SmallerCompany");
        Company fantasticCompany = new Company("FantasticCompany");

        companyDao.save(smallCompany);
        companyDao.save(smallerCompany);
        companyDao.save(fantasticCompany);

        // When
        List<Company> companyList = facade.findCompaniesByFragment("Small");

        // Then
        try {
            assertEquals(2, companyList.size());
        } finally {
            // CleanUp
            companyDao.deleteAll(companyList);
        }
    }
}