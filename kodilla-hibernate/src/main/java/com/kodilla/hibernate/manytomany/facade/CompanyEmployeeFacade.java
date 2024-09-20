package com.kodilla.hibernate.manytomany.facade;

import com.kodilla.hibernate.manytomany.Company;
import com.kodilla.hibernate.manytomany.Employee;
import com.kodilla.hibernate.manytomany.dao.CompanyDao;
import com.kodilla.hibernate.manytomany.dao.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CompanyEmployeeFacade {

    @Autowired
    private CompanyDao companyDao;

    @Autowired
    private EmployeeDao employeeDao;

    public List<Company> findCompaniesByFragment(String nameFragment) throws SearchingException {
        String queryParam = "%" + nameFragment + "%";
        List<Company> companies = companyDao.findByNameFragment(queryParam);
        if (companies.isEmpty()) {
            throw new SearchingException(SearchingException.ERR_COMPANY_NOT_FOUND);
        }
        return companies;
    }

    public List<Employee> findEmployeesByFragment(String lastNameFragment) throws SearchingException {
        String queryParam = "%" + lastNameFragment + "%";
        List<Employee> employees = employeeDao.findByLastNameFragment(queryParam);
        if (employees.isEmpty()) {
            throw new SearchingException(SearchingException.ERR_EMPLOYEE_NOT_FOUND);
        }
        return employees;
    }
}