/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.tekathon.service;

import in.tekathon.model.Employee;

/**
 *
 * @author administrator
 */
public class LoginImpl implements LoginIntf{

      EmployeeImpl employeeDao = new EmployeeImpl();
    @Override
    public void login(int employeeId, String userName, String password) {
        
        Employee employee = employeeDao.getEmployeeById(employeeId);
    }
    
     /*public String authenticateUser(int employeeId, String password) {
//        Employee employee = employeeDao.getEmployeeById(employeeId);
        if (employee != null && employee.getEmployeeId().equals(employeeId) && employee.getPassword().equals(password)) {
            return "{\"Status\": \"Success\"}";
        } else {
            return "{\"Status\": \"Failure\"}";
        }
    }*/
    
}
