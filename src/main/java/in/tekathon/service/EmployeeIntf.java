/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.tekathon.service;

import in.tekathon.model.EmployeeRequest;
import in.tekathon.model.EmployeeResponse;
import java.util.List;

/**
 *
 * @author administrator
 */
public interface EmployeeIntf {

    public List<EmployeeResponse> getAllEmployees();

    public EmployeeResponse getEmployeeById(int employeeId);

    public int insertEmployee(EmployeeRequest e);

    public EmployeeResponse updateEmployee(int id, EmployeeRequest e);

    public int deleteEmployee(int employeeId);
}
