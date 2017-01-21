/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.tekathon.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author administrator
 */
@Entity
@Table(name = "EMPLOYEE")
@XmlRootElement
@NamedNativeQueries({
    @NamedNativeQuery(
            name = "insertEmployee", query = "call CREATEUSER(:firstName, :lastName, :street, :city, :state, :pincode, :country, :contactNo, :dateOfBirth, :designation, :dateOfJoining, :yearsOfExperience, :reportingManagerId)"
    )
})
public class EmployeeResponse implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EMPLOYEEID")
    private Integer employeeId;
    @Column(name = "FIRSTNAME")
    private String firstName;
    @Column(name = "LASTNAME")
    private String lastName;
    @Column(name = "USERNAME")
    private String userName;
    @Column(name = "PASSWORD")
    private String password;
    @Column(name = "STREET")
    private String street;
    @Column(name = "CITY")
    private String city;
    @Column(name = "STATE")
    private String state;
    @Column(name = "PINCODE")
    private String pincode;
    @Column(name = "COUNTRY")
    private String country;
    @Column(name = "EMAILID")
    private String emailId;
    @Column(name = "CONTACTNO")
    private String contactNo;
    @Column(name = "DATEOFBIRTH")
    private String dateOfBirth;
    @Column(name = "DESIGNATION")
    private String designation;
    @Column(name = "DATEOFJOINING")
    private String dateOfJoining;
    @Column(name = "YEARSOFEXPERIENCE")
    private Integer yearsOfExperience;
    @Column(name = "REPORTINGMANAGER_ID")
    private Integer reportingManagerId;
    @Column(name = "CASUAL_LEAVES")
    private float casualLeaves;
    @Column(name = "EARNED_LEAVES")
    private Integer earnedLeaves;
    @Column(name = "SICK_LEAVES")
    private Integer sickLeaves;
    @Column(name = "COMP_OFFS")
    private Integer compOffs;
    @Column(name = "SHARED_LEAVES")
    private Integer sharedLeaves;

    public EmployeeResponse() {
    }

    public EmployeeResponse(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
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

    public Integer getYearsOfExperience() {
        return yearsOfExperience;
    }

    public void setYearsOfExperience(Integer yearsOfExperience) {
        this.yearsOfExperience = yearsOfExperience;
    }

    public Integer getReportingManagerId() {
        return reportingManagerId;
    }

    public void setReportingManagerId(Integer reportingManagerId) {
        this.reportingManagerId = reportingManagerId;
    }

    public float getCasualLeaves() {
        return casualLeaves;
    }

    public void setCasualLeaves(float casualLeaves) {
        this.casualLeaves = casualLeaves;
    }

    public Integer getEarnedLeaves() {
        return earnedLeaves;
    }

    public void setEarnedLeaves(Integer earnedLeaves) {
        this.earnedLeaves = earnedLeaves;
    }

    public Integer getSickLeaves() {
        return sickLeaves;
    }

    public void setSickLeaves(Integer sickLeaves) {
        this.sickLeaves = sickLeaves;
    }

    public Integer getCompOffs() {
        return compOffs;
    }

    public void setCompOffs(Integer compOffs) {
        this.compOffs = compOffs;
    }

    public Integer getSharedLeaves() {
        return sharedLeaves;
    }

    public void setSharedLeaves(Integer sharedLeaves) {
        this.sharedLeaves = sharedLeaves;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (employeeId != null ? employeeId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof EmployeeResponse)) {
            return false;
        }
        EmployeeResponse other = (EmployeeResponse) object;
        if ((this.employeeId == null && other.employeeId != null) || (this.employeeId != null && !this.employeeId.equals(other.employeeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "in.tekathon.samplepages.model.Employee[ employeeid=" + employeeId + " ]";
    }

}
