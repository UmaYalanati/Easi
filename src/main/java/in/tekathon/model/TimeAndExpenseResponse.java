/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.tekathon.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.io.Serializable;
import javax.persistence.Basic;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author administrator
 */
@Entity
@Table(name = "TIMEANDEXPENSE")
@XmlRootElement
@NamedNativeQueries({
    @NamedNativeQuery(name = "fillTimeSheetProcedure", query = "CALL TIMESHEET_INFO(:id, :latitude, :longitude, :comments, :attendanceMode, :absenceCategory, :leaveReason,:insertDate,:endDate, :statusFlag)", resultClass = TimeAndExpenseResponse.class)

})
@JsonIgnoreProperties({"employeeId", "projectId"})
public class TimeAndExpenseResponse implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TIMESHEETID")
    private Integer timesheetId;
    @Column(name = "EMPLOYEEID")
    private int employeeId;
    @NotNull
    @Column(name = "PROJECTID")
    private int projectId;
    @Column(name = "INSERTDATE")
    private String insertDate;
    @Column(name = "ENDDATE")
    private String endDate;
    @Column(name = "CHECKIN_TIME")
    private String checkinTime;
    @Column(name = "CHECKOUT_TIME")
    private String checkoutTime;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "CHECKIN_LATITUDE")
    private Double checkinLatitude;
    @Column(name = "CHECKIN_LONGITUDE")
    private Double checkinLongitude;
    @Column(name = "CHECKOUT_LATITUDE")
    private Double checkoutLatitude;
    @Column(name = "CHECKOUT_LONGITUDE")
    private Double checkoutLongitude;
    @Column(name = "ASSIGNEDTO")
    private String assignedTo;
    @Column(name = "COMMENTS")
    private String comments;
    @Column(name = "APPROVALTYPE")
    private String approvaltype;
    @Basic(optional = false)
    @Column(name = "ATTENDANCEMODE")
    private String attendanceMode;
    @Column(name = "STATUS")
    private String status;
    @Column(name = "WORKINGHOURS")
    private Integer workingHours;
    @Column(name = "NOOFDAYS")
    private Integer noOfDays;
    @Column(name = "ABSENCECATEGORY")
    private String absenceCategory;
    @Column(name = "LEAVEREASON")
    private String leaveReason;
    @Column(name = "LEAVECOMMENTS")
    private String leaveComments;

    public TimeAndExpenseResponse() {
    }

    public TimeAndExpenseResponse(Integer timesheetId) {
        this.timesheetId = timesheetId;
    }

    public TimeAndExpenseResponse(Integer timesheetId, int employeeId, int projectId) {
        this.timesheetId = timesheetId;
        this.employeeId = employeeId;
        this.projectId = projectId;

    }

    public Integer getTimesheetId() {
        return timesheetId;
    }

    public void setTimesheetId(Integer timesheetId) {
        this.timesheetId = timesheetId;
    }

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public int getProjectId() {
        return projectId;
    }

    public void setProjectId(int projectId) {
        this.projectId = projectId;
    }

    public String getInsertDate() {
        return insertDate;
    }

    public void setInsertDate(String insertDate) {
        this.insertDate = insertDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getCheckinTime() {
        return checkinTime;
    }

    public void setCheckinTime(String checkinTime) {
        this.checkinTime = checkinTime;
    }

    public String getCheckoutTime() {
        return checkoutTime;
    }

    public void setCheckoutTime(String checkoutTime) {
        this.checkoutTime = checkoutTime;
    }

    public Double getCheckinLatitude() {
        return checkinLatitude;
    }

    public void setCheckinLatitude(Double checkinLatitude) {
        this.checkinLatitude = checkinLatitude;
    }

    public Double getCheckinLongitude() {
        return checkinLongitude;
    }

    public void setCheckinLongitude(Double checkinLongitude) {
        this.checkinLongitude = checkinLongitude;
    }

    public Double getCheckoutLatitude() {
        return checkoutLatitude;
    }

    public void setCheckoutLatitude(Double checkoutLatitude) {
        this.checkoutLatitude = checkoutLatitude;
    }

    public Double getCheckoutLongitude() {
        return checkoutLongitude;
    }

    public void setCheckoutLongitude(Double checkoutLongitude) {
        this.checkoutLongitude = checkoutLongitude;
    }

    public String getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(String assignedTo) {
        this.assignedTo = assignedTo;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public String getApprovaltype() {
        return approvaltype;
    }

    public void setApprovaltype(String approvaltype) {
        this.approvaltype = approvaltype;
    }

    public String getAttendanceMode() {
        return attendanceMode;
    }

    public void setAttendanceMode(String attendanceMode) {
        this.attendanceMode = attendanceMode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getWorkingHours() {
        return workingHours;
    }

    public void setWorkingHours(Integer workingHours) {
        this.workingHours = workingHours;
    }

    public Integer getNoOfDays() {
        return noOfDays;
    }

    public void setNoOfDays(Integer noOfDays) {
        this.noOfDays = noOfDays;
    }

    public String getAbsenceCategory() {
        return absenceCategory;
    }

    public void setAbsenceCategory(String absenceCategory) {
        this.absenceCategory = absenceCategory;
    }

    public String getLeaveReason() {
        return leaveReason;
    }

    public void setLeaveReason(String leaveReason) {
        this.leaveReason = leaveReason;
    }

    public String getLeaveComments() {
        return leaveComments;
    }

    public void setLeaveComments(String leaveComments) {
        this.leaveComments = leaveComments;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (timesheetId != null ? timesheetId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TimeAndExpenseResponse)) {
            return false;
        }
        TimeAndExpenseResponse other = (TimeAndExpenseResponse) object;
        if ((this.timesheetId == null && other.timesheetId != null) || (this.timesheetId != null && !this.timesheetId.equals(other.timesheetId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Timeandexpense[ timesheetid=" + timesheetId + " ]";
    }

}
