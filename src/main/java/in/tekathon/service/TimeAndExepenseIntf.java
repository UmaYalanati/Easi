/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.tekathon.service;

/**
 *
 * @author administrator
 */
public interface TimeAndExepenseIntf {

    public int leaveApplication(String employeeId, String absenceCategory, String leaveReason, String startDate, String endDate, String comments);

}
