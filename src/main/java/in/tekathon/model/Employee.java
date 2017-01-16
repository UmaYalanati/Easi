/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.tekathon.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author administrator
 */
@Entity
@Table(name = "EMPLOYEE")
@XmlRootElement
/*@NamedQueries({
    @NamedQuery(name = "Employee.findAll", query = "SELECT e FROM Employee e")
    , @NamedQuery(name = "Employee.findByEmployeeId", query = "SELECT e FROM Employee e WHERE e.employeeid = :employeeid")
    , @NamedQuery(name = "Employee.findByFirstname", query = "SELECT e FROM Employee e WHERE e.firstname = :firstname")
    , @NamedQuery(name = "Employee.findByLastname", query = "SELECT e FROM Employee e WHERE e.lastname = :lastname")
    , @NamedQuery(name = "Employee.findByUsername", query = "SELECT e FROM Employee e WHERE e.username = :username")
    , @NamedQuery(name = "Employee.findByPassword", query = "SELECT e FROM Employee e WHERE e.password = :password")
    , @NamedQuery(name = "Employee.findByStreet", query = "SELECT e FROM Employee e WHERE e.street = :street")
    , @NamedQuery(name = "Employee.findByCity", query = "SELECT e FROM Employee e WHERE e.city = :city")
    , @NamedQuery(name = "Employee.findByState", query = "SELECT e FROM Employee e WHERE e.state = :state")
    , @NamedQuery(name = "Employee.findByPincode", query = "SELECT e FROM Employee e WHERE e.pincode = :pincode")
    , @NamedQuery(name = "Employee.findByCountry", query = "SELECT e FROM Employee e WHERE e.country = :country")
    , @NamedQuery(name = "Employee.findByEmailid", query = "SELECT e FROM Employee e WHERE e.emailid = :emailid")
    , @NamedQuery(name = "Employee.findByContactno", query = "SELECT e FROM Employee e WHERE e.contactno = :contactno")
    , @NamedQuery(name = "Employee.findByDateofbirth", query = "SELECT e FROM Employee e WHERE e.dateofbirth = :dateofbirth")
    , @NamedQuery(name = "Employee.findByDesignation", query = "SELECT e FROM Employee e WHERE e.designation = :designation")
    , @NamedQuery(name = "Employee.findByDateofjoining", query = "SELECT e FROM Employee e WHERE e.dateofjoining = :dateofjoining")
    , @NamedQuery(name = "Employee.findByYearsofexperience", query = "SELECT e FROM Employee e WHERE e.yearsofexperience = :yearsofexperience")
    , @NamedQuery(name = "Employee.findByReportingmanagerId", query = "SELECT e FROM Employee e WHERE e.reportingmanagerId = :reportingmanagerId")})*/
public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @NotNull
    @Column(name = "EMPLOYEEID")
    private Integer employeeId;
    @Size(max = 50)
    @Column(name = "FIRSTNAME")
    private String firstName;
    @Size(max = 50)
    @Column(name = "LASTNAME")
    private String lastName;
    @Size(max = 50)
    @Column(name = "USERNAME")
    private String userName;
    @Size(max = 50)
    @Column(name = "PASSWORD")
    private String password;
    @Size(max = 100)
    @Column(name = "STREET")
    private String street;
    @Size(max = 50)
    @Column(name = "CITY")
    private String city;
    @Size(max = 50)
    @Column(name = "STATE")
    private String state;
    @Size(max = 10)
    @Column(name = "PINCODE")
    private String pincode;
    @Size(max = 50)
    @Column(name = "COUNTRY")
    private String country;
    @Size(max = 100)
    @Column(name = "EMAILID")
    private String emailId;
    @Size(max = 12)
    @Column(name = "CONTACTNO")
    private String contactNo;
    @Size(max = 20)
    @Column(name = "DATEOFBIRTH")
    private String dateOfBirth;
    @Size(max = 50)
    @Column(name = "DESIGNATION")
    private String designation;
    @Size(max = 20)
    @Column(name = "DATEOFJOINING")
    private String dateOfJoining;
    @Column(name = "YEARSOFEXPERIENCE")
    private Integer yearsOfExperience;
    @Column(name = "REPORTINGMANAGER_ID")
    private Integer reportingManagerId;
    @OneToMany(mappedBy = "employeeId")
    private Collection<ProjectDetails> projectDetailsCollection;

    public Employee() {
    }

    public Employee(Integer employeeId) {
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

    @XmlTransient
    public Collection<ProjectDetails> getProjectDetailsCollection() {
        return projectDetailsCollection;
    }

    public void setProjectDetailsCollection(Collection<ProjectDetails> projectDetailsCollection) {
        this.projectDetailsCollection = projectDetailsCollection;
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
        if (!(object instanceof Employee)) {
            return false;
        }
        Employee other = (Employee) object;
        if ((this.employeeId == null && other.employeeId != null) || (this.employeeId != null && !this.employeeId.equals(other.employeeId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.teksystems.model.Employee[ employeeid=" + employeeId + " ]";
    }

}
