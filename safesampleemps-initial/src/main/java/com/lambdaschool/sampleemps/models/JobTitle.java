package com.lambdaschool.sampleemps.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "jobtitles")
public class JobTitle extends Auditable
{
    @Id // The primary key
    @GeneratedValue(strategy = GenerationType.AUTO) // We will let the database decide how to generate it
    private long jobtitleid; // long so we can have many rows

    private String title;

    /*
     * jobname is the field from EmployeeTitles
     * CascadeType.ALL says that when we add, update, delete an Job Title record, have that affect jobname in EmployeeTitle.
     * Notice that in EmployeeTitle there is no cascade option. This way manipulating an JobTitle record only affects
     * the EmployeeTitle join table but does not affect the Employee table.
     */
    @OneToMany(mappedBy = "jobname",
            cascade = CascadeType.ALL)
    /*
     * When displaying EmployeeTitles from the JobTitle class, do not display the Job Title again.
     * However do allow for data to be added to the jobname field in EmployeeTitles
     */
    @JsonIgnoreProperties(value = "jobname",
            allowSetters = true)
    /*
     * We know all of this works with EmployeeTitles because that is the class of the field name that making the One To Many relationship!
     * This array contains the list of EmployeeTitles assigned to this Job Title
     */
    private Set<EmployeeTitles> empnames = new HashSet<>();

    public JobTitle()
    {
        // the default constructor is required by the JPA
    }

    public long getJobtitleid()
    {
        return jobtitleid;
    }

    public void setJobtitleid(long jobtitleid)
    {
        this.jobtitleid = jobtitleid;
    }

    public String getTitle()
    {
        return title;
    }

    public void setTitle(String title)
    {
        this.title = title;
    }

    public Set<EmployeeTitles> getEmpnames()
    {
        return empnames;
    }

    public void setEmpnames(Set<EmployeeTitles> empnames)
    {
        this.empnames = empnames;
    }
}