package com.kodilla.hibernate.manytomany;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "EMPLOYEES")
@NamedQuery(name = "Employee.findByLastName",
        query = "SELECT e FROM Employee e WHERE e.lastName = :lastName")
public class Employee {

    private int id;
    private String firstName;
    private String lastName;
    private List<Company> companies = new ArrayList<>();

    public Employee() {
    }

    public Employee(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Id
    @GeneratedValue
    @Column(name = "EMPLOYEE_ID", unique = true)
    public int getId() {
        return id;
    }

    @NotNull
    @Column(name = "FIRST_NAME", nullable = false)  // Dodanie nullable = false
    public String getFirstName() {
        return firstName;
    }

    @NotNull
    @Column(name = "LAST_NAME", nullable = false)  // Dodanie nullable = false
    public String getLastName() {
        return lastName;
    }

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name = "JOIN_COMPANY_EMPLOYEE",
            joinColumns = @JoinColumn(name = "EMPLOYEE_ID"),
            inverseJoinColumns = @JoinColumn(name = "COMPANY_ID")
    )
    public List<Company> getCompanies() {
        return companies;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setCompanies(List<Company> companies) {
        this.companies = companies;
    }
}
