package com.lambdaschool.sampleemps.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;

@Entity
@Table(name = "emails")
public class Email extends Auditable
{
    @Id // The primary key
    @GeneratedValue(strategy = GenerationType.AUTO) // We will let the database decide how to generate it
    private long emailid; // long so we can have many rows

    @javax.validation.constraints.Email(message = "email must be in the form of username@domain.toplevel")
    private String email;

    @ManyToOne
    @JoinColumn(name = "employeeid",
        nullable = false)
    // we want to ignore, not display, the emails collection from Employee
    @JsonIgnoreProperties(value = "emails",
        allowSetters = true)
    private Employee employee;

    public Email()
    {
        // the default constructor is required by the JPA
    }

    public Email(
        String email,
        Employee employee)
    {
        this.email = email;
        this.employee = employee;
    }

    public long getEmailid()
    {
        return emailid;
    }

    public void setEmailid(long emailid)
    {
        this.emailid = emailid;
    }

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public Employee getEmployee()
    {
        return employee;
    }

    public void setEmployee(Employee employee)
    {
        this.employee = employee;
    }
}
