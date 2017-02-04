/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.tekathon.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;

@Entity
@Table(name = "LEAVE_DETAILS")
@NamedNativeQueries({
    @NamedNativeQuery(name = "leaveDetailsProcedure", query = "CALL LEAVE_INFO(:id,:reportingManagerId,:absenceCategory, :attendanceMode, :leaveReason, :startDate, :endDate, :status, :comments, :statusFlag)", resultClass = LeaveApplicationResponse.class)
})
public class LeaveApplicationResponse implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "LEAVEID")
    private Integer leaveId;
    @Column(name = "EMPLOYEEID")
    private int employeeId;
    @Column(name = "ABSENCECATEGORY")
    private String absenceCategory;
    @Column(name = "ATTENDANCEMODE")
    private String attendanceMode;
    @Column(name = "LEAVEREASON")
    private String leaveReason;
    @Column(name = "STARTDATE")
    private String startDate;
    @Column(name = "ENDDATE")
    private String endDate;
    @Column(name = "STATUS")
    private String status;
    @Column(name = "NOOFDAYS")
    private int noOfDays;
    @Column(name = "COMMENTS")
    private String leaveComments;
    @Column(name = "REPORTINGMANAGERID")
    private String reportingManagerId;

    public LeaveApplicationResponse() {
    }

    public LeaveApplicationResponse(Integer leaveId) {
        this.leaveId = leaveId;
    }

    public Integer getLeaveId() {
        return leaveId;
    }

    public void setLeaveId(Integer leaveId) {
        this.leaveId = leaveId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getAbsenceCategory() {
        return absenceCategory;
    }

    public void setAbsenceCategory(String absenceCategory) {
        this.absenceCategory = absenceCategory;
    }

    public String getAttendanceMode() {
        return attendanceMode;
    }

    public void setAttendanceMode(String attendanceMode) {
        this.attendanceMode = attendanceMode;
    }

    public String getLeaveReason() {
        return leaveReason;
    }

    public void setLeaveReason(String leaveReason) {
        this.leaveReason = leaveReason;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getNoOfDays() {
        return noOfDays;
    }

    public void setNoOfDays(int noOfDays) {
        this.noOfDays = noOfDays;
    }

    public String getLeaveComments() {
        return leaveComments;
    }

    public void setLeaveComments(String leaveComments) {
        this.leaveComments = leaveComments;
    }

    public String getReportingManagerId() {
        return reportingManagerId;
    }

    public void setReportingManagerId(String reportingManagerId) {
        this.reportingManagerId = reportingManagerId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (leaveId != null ? leaveId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof LeaveApplicationResponse)) {
            return false;
        }
        LeaveApplicationResponse other = (LeaveApplicationResponse) object;
        if ((this.leaveId == null && other.leaveId != null) || (this.leaveId != null && !this.leaveId.equals(other.leaveId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "[ leaveid=" + leaveId + " ]";
    }

}
