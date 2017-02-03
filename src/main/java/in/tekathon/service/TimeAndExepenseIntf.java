/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.tekathon.service;

import in.tekathon.model.TimeAndExpenseResponse;
import java.util.List;

/**
 *
 * @author administrator
 */
public interface TimeAndExepenseIntf {

    public List<TimeAndExpenseResponse> leaveApplication(int employeeId, String attendanceMode, String absenceCategory, String leaveReason, String startDate, String endDate, String comments);

    public TimeAndExpenseResponse checkTimeSheet(int employeeId, double latitude, double longitude, String comments, String attendanceMode, int flag);

//    public List<TimeAndExpenseResponse> checkoutTimeSheet(int timesheetId, double latitude, double longitude, String comments, String attendanceMode);

    public List<TimeAndExpenseResponse> getTimesheetById(int employeeId, String fromDate, String toDate);

    public List<TimeAndExpenseResponse> managerApproval(int employeeId, String startDate, String endDate, String status);
}
