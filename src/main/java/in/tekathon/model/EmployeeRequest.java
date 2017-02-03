/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.tekathon.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author administrator
 */
@XmlRootElement
public class EmployeeRequest {

    private static final long serialVersionUID = 1L;

    private int employeeId;
    private String firstName;
    private String lastName;
    private String userName;
    private String password;
    private String street;
    private String city;
    private String state;
    private String pincode;
    private String country;
    private String emailId;
    private String contactNo;
    private String dateOfBirth;
    private String designation;
    private String dateOfJoining;
    private int yearsOfExperience;
    private int reportingManagerId;
    private Float casualLeaves;
    private int earnedLeaves;
    private int sickLeaves;
    private int compOffs;
    private int sharedLeaves;
    private String createdDate;
    private String companyName;
    private String deviceId;
    private String reportingManagerName;

    public int getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getPincode() {
        return pincode;
    }

    public void setPincode(String pincode) {
        this.pincode = pincode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getDateOfJoining() {
        return dateOfJoining;
    }

    public void setDateOfJoining(String dateOfJoining) {
        this.dateOfJoining = dateOfJoining;
    }

    public int getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(int yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    public int getReportingManagerId() {
        return reportingManagerId;
    }

    public void setReportingManagerId(int reportingManagerId) {
        this.reportingManagerId = reportingManagerId;
    }

    public Float getCasualLeaves() {
        return casualLeaves;
    }

    public void setCasualLeaves(Float casualLeaves) {
        this.casualLeaves = casualLeaves;
    }

    public int getEarnedLeaves() {
        return earnedLeaves;
    }

    public void setEarnedLeaves(int earnedLeaves) {
        this.earnedLeaves = earnedLeaves;
    }

    public int getSickLeaves() {
        return sickLeaves;
    }

    public void setSickLeaves(int sickLeaves) {
        this.sickLeaves = sickLeaves;
    }

    public int getCompOffs() {
        return compOffs;
    }

    public void setCompOffs(int compOffs) {
        this.compOffs = compOffs;
    }

    public int getSharedLeaves() {
        return sharedLeaves;
    }

    public void setSharedLeaves(int sharedLeaves) {
        this.sharedLeaves = sharedLeaves;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(String deviceId) {
        this.deviceId = deviceId;
    }

    public String getReportingManagerName() {
        return reportingManagerName;
    }

    public void setReportingManagerName(String reportingManagerName) {
        this.reportingManagerName = reportingManagerName;
    }

}
