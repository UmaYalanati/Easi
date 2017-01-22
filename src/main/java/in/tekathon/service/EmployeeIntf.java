/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.tekathon.service;

import in.tekathon.model.Employee;
import java.util.List;

/**
 *
 * @author administrator
 */
public interface EmployeeIntf {

    public List<Employee> getAllEmployees();

    public Employee getEmployeeById(int employeeId);

    public String insertEmployee(Employee e);

    public int updateEmployee(int id, Employee e);

    public int deleteEmployee(int employeeId);
}
