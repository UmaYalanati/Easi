/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.tekathon.service;

import in.tekathon.model.EmployeeResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author administrator
 */
public class LoginImpl implements LoginIntf {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    EmployeeImpl employeeDao = new EmployeeImpl();

    @Override
    public EmployeeResponse login(int userName, String password) {

        EmployeeResponse employee = employeeDao.getEmployeeById(userName);

        if (employee != null) {
            if (validateEmployee(userName, password, employee)) {
                return employee;
            }
        }
        return null;
    }

    public boolean validateEmployee(int userName, String password, EmployeeResponse employee) {
        if (employee.getEmployeeId().equals(userName)) {
            if (employee.getPassword().equals(password)) {
                return true;
            }
        }
        return false;
    }
}
