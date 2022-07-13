package io.amigos.titan.service;

import io.amigos.titan.exception.ResourceNotFoundException;
import io.amigos.titan.model.Employee;
import io.amigos.titan.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees() {

        List<Employee> employees = new ArrayList<Employee>();
        employeeRepository.findAll().forEach(employees::add);

        return employees;
    }

    public Employee getEmployeeById(long id) {

        Optional<Employee> employee = employeeRepository.findById(id);
        if (employee.isEmpty()) {
            throw new ResourceNotFoundException("Employee NOT FOUND with the given id: " +id );
        }

        return employeeRepository.findById(id).get();
    }

    public Employee createEmployee(Employee employee) {
        System.out.println("Employee object: " +employee);
            return employeeRepository
                    .save(new Employee(employee.getName(), employee.getSalary(), employee.getDoj(), employee.isActive()));
    }

    public Employee updateEmployee(long id, Employee newEmployee) {
        Optional<Employee> employeeData = employeeRepository.findById(id);
        if (employeeData.isPresent()) {
            Employee employee = employeeData.get();
            employee.setName(newEmployee.getName());
            employee.setSalary(newEmployee.getSalary());
            employee.setDoj(newEmployee.getDoj());
            employee.setActive(newEmployee.isActive());
            return employeeRepository.save(employee);
        } else {
            throw new ResourceNotFoundException(" Requested Employee Data with the ID: " +id + " NOT FOUND");
        }
    }
    public void deleteEmployee(long id) {
            employeeRepository.deleteById(id);
    }

    public void deleteAllEmployees() {
            employeeRepository.deleteAll();
    }

    public List<Employee> getAllActiveEmployees(boolean isActive) {
           return employeeRepository.findByActiveExists(isActive);
    }
}
