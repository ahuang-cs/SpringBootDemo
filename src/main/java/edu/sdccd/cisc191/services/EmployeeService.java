package edu.sdccd.cisc191.services;

import edu.sdccd.cisc191.model.Employee;
import edu.sdccd.cisc191.repositories.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired private EmployeeRepository empRepo;

    public List<Employee> getAllEmployee()
    {
        return empRepo.findAll();
    }

    public void save(Employee employee)
    {
        empRepo.save(employee);
    }

    public Employee getById(Long id)
    {
        Optional<Employee> optional = empRepo.findById(id);
        Employee employee = null;
        if (optional.isPresent())
            employee = optional.get();
        else
            throw new RuntimeException(
                    "Employee not found for id : " + id);
        return employee;
    }

    public void deleteViaId(long id)
    {
        empRepo.deleteById(id);
    }
}