package com.lambdaschool.sampleemps.services;

import com.lambdaschool.sampleemps.exceptions.ResourceNotFoundException;
import com.lambdaschool.sampleemps.models.Email;
import com.lambdaschool.sampleemps.models.Employee;
import com.lambdaschool.sampleemps.models.EmployeeTitles;
import com.lambdaschool.sampleemps.models.JobTitle;
import com.lambdaschool.sampleemps.repositories.EmployeeRepository;
import com.lambdaschool.sampleemps.repositories.JobTitleRepository;
import com.lambdaschool.sampleemps.views.EmpNameCountJobs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service(value = "employeeSerivce") // needed to name this implementation as the service to use
public class EmployeeServiceImpl
    implements EmployeeService // notice the Impl for implementing a service
{
    @Autowired
    private EmployeeRepository employeerepos;

    @Autowired
    private JobTitleRepository jtrepos;

    @Override
    public List<Employee> findAllEmployees()
    {
        List<Employee> list = new ArrayList<>();
        /*
         * findAll returns an iterator set.
         * iterate over the iterator set and add each element to an array list.
         */
        employeerepos.findAll()
            .iterator()
            .forEachRemaining(list::add);
        return list;
    }

    @Override
    public Employee findEmployeeById(long employeeid)
    {
        return employeerepos.findById(employeeid)
            .orElseThrow(() -> new ResourceNotFoundException("Employee " + employeeid + " Not Found"));
    }

    @Override
    public List<Employee> findEmployeeNameContaining(String subname)
    {
        return employeerepos.findByNameContainingIgnoreCase(subname);
    }

    @Override
    public List<Employee> findEmployeeEmailContaining(String subemail)
    {
        return employeerepos.findByEmails_EmailContainingIgnoreCase(subemail);
    }

    @Transactional
    @Override
    public Employee save(Employee employee)
    {
        Employee newEmployee = new Employee();

        if (employee.getEmployeeid() != 0)
        {
            employeerepos.findById(employee.getEmployeeid())
                .orElseThrow(() -> new ResourceNotFoundException("Employee " + employee.getEmployeeid() + " Not Found"));

            newEmployee.setEmployeeid(employee.getEmployeeid());
        }

        newEmployee.setName(employee.getName());
        newEmployee.setSalary(employee.getSalary());

        // changing this code to adjust to the new model
        newEmployee.getJobnames()
            .clear();
        for (EmployeeTitles jt : employee.getJobnames())
        {
            JobTitle newJT = jtrepos.findById(jt.getJobname()
                .getJobtitleid())
                .orElseThrow(() -> new ResourceNotFoundException("JobTitle " + jt.getJobname()
                    .getJobtitleid() + " Not Found"));

            // yes I just hard coded a manager!
            newEmployee.getJobnames()
                .add(new EmployeeTitles(newEmployee,
                    newJT,
                    "Stumps"));
        }
        // changing the above code to adjust to the new model

        newEmployee.getEmails()
            .clear();
        for (Email e : employee.getEmails())
        {
            Email newEmail = new Email();
            newEmail.setEmail(e.getEmail());
            newEmail.setEmployee(newEmployee);

            newEmployee.getEmails()
                .add(newEmail);
        }
        return employeerepos.save(newEmployee);
    }

    @Override
    public List<EmpNameCountJobs> getEmpNameCountJobs()
    {
        return employeerepos.getCountEmpJobs();
    }

    @Transactional
    @Override
    public Employee update(
        Employee employee,
        long employeeid)
    {
        Employee currentEmployee = employeerepos.findById(employeeid)
            .orElseThrow(() -> new ResourceNotFoundException("Employee " + employeeid + " Not Found"));

        if (employee.getName() != null)
        {
            currentEmployee.setName(employee.getName());
        }

        if (employee.hasvalueforsalary)
        {
            currentEmployee.setSalary(employee.getSalary());
        }

        // changing this code to adjust to the new model
        currentEmployee.getJobnames()
            .clear();
        for (EmployeeTitles jt : employee.getJobnames())
        {
            JobTitle newJT = jtrepos.findById(jt.getJobname()
                .getJobtitleid())
                .orElseThrow(() -> new ResourceNotFoundException("JobTitle " + jt.getJobname()
                    .getJobtitleid() + " Not Found"));

            // yes I just hard coded a manager!
            currentEmployee.getJobnames()
                .add(new EmployeeTitles(currentEmployee,
                    newJT,
                    "Stumps"));
        }
        // changing the above code to adjust to the new model

        if (employee.getEmails()
            .size() > 0)
        {
            currentEmployee.getEmails()
                .clear();
            for (Email e : employee.getEmails())
            {
                Email newEmail = new Email();
                newEmail.setEmail(e.getEmail());
                newEmail.setEmployee(currentEmployee);

                currentEmployee.getEmails()
                    .add(newEmail);
            }
        }

        return employeerepos.save(currentEmployee);
    }

    @Transactional
    @Override
    public void delete(long employeeid)
    {
        if (employeerepos.findById(employeeid)
            .isPresent())
        {
            employeerepos.deleteById(employeeid);
        } else
        {
            throw new ResourceNotFoundException("Employee " + employeeid + " Not Found");
        }
    }
}
