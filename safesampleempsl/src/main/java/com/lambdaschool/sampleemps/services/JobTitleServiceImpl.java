package com.lambdaschool.sampleemps.services;

import com.lambdaschool.sampleemps.exceptions.ResourceNotFoundException;
import com.lambdaschool.sampleemps.models.JobTitle;
import com.lambdaschool.sampleemps.repositories.EmployeeRepository;
import com.lambdaschool.sampleemps.repositories.JobTitleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityExistsException;

@Transactional
@Service(value = "jobtitleSerivce") // needed to name this implementation as the service to use
public class JobTitleServiceImpl
    implements JobTitleService
{
    @Autowired
    private EmployeeRepository employeerepos;

    @Autowired
    private JobTitleRepository jtrepos;

    @Transactional
    @Override
    public JobTitle update(
        long id,
        JobTitle jt)
    {
        if (jt.getTitle() == null)
        {
            throw new ResourceNotFoundException("No Title found to update!");
        }

        if (jt.getEmpnames()
            .size() > 0)
        {
            throw new EntityExistsException("Employees are not updated through Job Titles");
        }

        jtrepos.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Job Title id " + id + " not found!"));

        jtrepos.updateJobTitle("SYSTEM",
            id,
            jt.getTitle());
        return jtrepos.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Job Title id " + id + " not found!"));
    }
}
