/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.tekathon.service;

import in.tekathon.model.EmployeeResponse;


/**
 *
 * @author administrator
 */
public interface LoginIntf {

    public EmployeeResponse login(int userName, String password);

}
