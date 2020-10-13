package com.lambdaschool.sampleemps.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.io.Serializable;

@Entity
/*
 * Table enforces a unique constraint of the combination of employeeid and jobtitleid.
 * These two together form the primary key.
 */
@Table(name = "employeetitles")
/*
 * When you have a compound primary key, you must implement Serializable for Hibernate
 * When you implement Serializable you must implement equals and hash code
 */
@IdClass(EmployeeTitlesId.class)
public class EmployeeTitles extends Auditable implements Serializable
{
    /*
     * 1/2 of the primary key (long) for employeetitles.
     * Also is a foreign key into the Employee table
     */
    @Id
    @ManyToOne
    /*
     * Many of these records can point to a single Employee. In other words, an employee can have multiple job titles
     */
    @JoinColumn(name = "employeeid")
    @JsonIgnoreProperties(value = "jobnames",
        allowSetters = true)
    private Employee emp;

    /*
     * 1/2 of the primary key (long) for employeetitles.
     * Also is a foreign key into the JobTitle table
     */
    @Id
    /*
     * Many of these records can point to a single JobTitle. In other words, multiple employees can have the same job title
     */
    @ManyToOne
    @JoinColumn(name = "jobtitleid")
    @JsonIgnoreProperties(value = "empnames",
        allowSetters = true)
    private JobTitle jobname;

    /*
     * Our extra field - why we are going all this hassle!
     */
    @Column(nullable = false)
    private String manager;

    /*
     * JPA requires the default constructor
     */
    public EmployeeTitles()
    {
    }

    /*
     * Allows us to easily create a record given all the data
     */
    public EmployeeTitles(
        Employee emp,
        JobTitle jobname,
        String manager)
    {
        this.emp = emp;
        this.jobname = jobname;
        this.manager = manager;
    }

    /*
     * Our standard getters and setters
     */
    public Employee getEmp()
    {
        return emp;
    }

    public void setEmp(Employee emp)
    {
        this.emp = emp;
    }

    public JobTitle getJobname()
    {
        return jobname;
    }

    public void setJobname(JobTitle jobname)
    {
        this.jobname = jobname;
    }

    public String getManager()
    {
        return manager;
    }

    public void setManager(String manager)
    {
        this.manager = manager;
    }

    /*
     * Since we have implemented Serializable - required for the compound primary key,
     * We have also Override equals and hashCode. This is done through the same menu system
     * as generating getters and setters. We pick equals() and hashCode() from that context menu
     * and generate them.
     */
    @Override
    public boolean equals(Object o)
    {
        // if the one we are comparing an object to itself, just return true
        if (this == o)
        {
            return true;
        }

        // make sure that we are comparing this object to one of the same class
        // if not return false
        if (!(o instanceof EmployeeTitles))
        {
            return false;
        }

        // check to see if the ids are equal.
        // if one of the objects happens to have a null for one of the fields
        // set the id to 0
        EmployeeTitles that = (EmployeeTitles) o;
        return ((emp == null) ? 0 : emp.getEmployeeid()) == ((that.emp == null) ? 0 : that.emp.getEmployeeid()) &&
            ((jobname == null) ? 0 : jobname.getJobtitleid()) == ((that.jobname == null) ? 0 : that.jobname.getJobtitleid());
    }

    @Override
    public int hashCode()
    {
        //        return Objects.hash(getEmp(),
        //                            getJobname(),
        //                            manager);
        return 34;
    }
}
