/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.tekathon.service;

import in.tekathon.model.LeaveApplicationResponse;
import java.util.List;

/**
 *
 * @author administrator
 */
interface LeaveIntf {

    public LeaveApplicationResponse leaveApplication(int employeeId, String attendanceMode, String absenceCategory, String leaveReason, String startDate, String endDate, String comments);

}
