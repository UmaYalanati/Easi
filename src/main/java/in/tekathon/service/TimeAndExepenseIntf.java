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

    public TimeAndExpenseResponse checkTimeSheet(int employeeId, double latitude, double longitude, String comments, String attendanceMode, int flag);

    public List<TimeAndExpenseResponse> getTimesheetById(int employeeId, String fromDate, String toDate);

    public TimeAndExpenseResponse managerApproval(int id, String status);

}
