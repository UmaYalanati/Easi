/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.tekathon.model;

import javax.persistence.Column;
import javax.persistence.Entity;
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
    //    @NamedNativeQuery(name = "loginProc", query = "CALL LOGINUSER(:employeeId)", resultClass = LoginResponse.class)
    @NamedNativeQuery(name = "loginProc", query = "SLECET EMPLOYEEID, FIRSTNAME, LASTNAME, EMAILID, COMPANYNAME where EMPLOYEID= :employeeId)", resultClass = LoginResponse.class)
})
public class LoginResponse {

    @Id
    @Column(name = "EMPLOYEEID")
    private int employeeId;
    @Column(name = "FIRSTNAME")
    private String firstName;
    @Column(name = "LASTNAME")
    private String lastName;
    @Column(name = "EMAILID")
    private String emailId;
    @Column(name = "COMAPNYNAME")
    private String companyName;

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

    public String getEmailId() {
        return emailId;
    }

    public void setEmailId(String emailId) {
        this.emailId = emailId;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

}
