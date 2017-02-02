package in.tekathon.model;

import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedNativeQueries;
import javax.persistence.NamedNativeQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "EMPLOYEE")
@XmlRootElement
@NamedNativeQueries({
    @NamedNativeQuery(name = "createEmployeeProcedure", query = "CALL CREATEUSER(:employeeId, :firstName, :lastName, :street, :city, :state, :pincode, :country, :contactNo, :dateOfBirth, :designation, :dateOfJoining, :yearsOfExperience, :reportingManagerId, :companyName, :deviceId)", resultClass = EmployeeResponse.class)
})
public class EmployeeResponse implements java.io.Serializable {

    @OneToMany(mappedBy = "employeeId")
    private Collection<ProjectDetailsResponse> projectDetailsCollection;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "employeeId")
    private Collection<TimeAndExpenseResponse> timeandexpenseCollection;

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "EMPLOYEEID")
    private Integer employeeId;
    @Size(max = 100)
    @Column(name = "FIRSTNAME")
    private String firstName;
    @Size(max = 100)
    @Column(name = "LASTNAME")
    private String lastName;
    @Size(max = 100)
    @Column(name = "USERNAME")
    private String userName;
    @Size(max = 100)
    @Column(name = "PASSWORD")
    private String password;
    @Size(max = 100)
    @Column(name = "STREET")
    private String street;
    @Size(max = 100)
    @Column(name = "CITY")
    private String city;
    @Size(max = 100)
    @Column(name = "STATE")
    private String state;
    @Size(max = 100)
    @Column(name = "PINCODE")
    private String pincode;
    @Size(max = 100)
    @Column(name = "COUNTRY")
    private String country;
    @Size(max = 100)
    @Column(name = "EMAILID")
    private String emailid;
    @Size(max = 12)
    @Column(name = "CONTACTNO")
    private String contactNo;
    @Size(max = 20)
    @Column(name = "DATEOFBIRTH")
    private String dateOfBirth;
    @Size(max = 100)
    @Column(name = "DESIGNATION")
    private String designation;
    @Size(max = 20)
    @Column(name = "DATEOFJOINING")
    private String dateOfJoining;
    @Column(name = "YEARSOFEXPERIENCE")
    private Integer yearsOfExperience;
    @Column(name = "REPORTINGMANAGER_ID")
    private Integer reportingManagerId;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "CASUAL_LEAVES")
    private Float casualLeaves;
    @Column(name = "EARNED_LEAVES")
    private Integer earnedLeaves;
    @Column(name = "SICK_LEAVES")
    private Integer sickLeaves;
    @Column(name = "COMP_OFFS")
    private Integer compOffs;
    @Column(name = "SHARED_LEAVES")
    private Integer sharedLeaves;
    @Size(max = 50)
    @Column(name = "CREATED_DATE")
    private String createdDate;
    @Size(max = 100)
    @Column(name = "companyName")
    private String companyName;
    @Size(max = 100)
    @Column(name = "deviceId")
    private String deviceId;

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

    public String getEmailid() {
        return emailid;
    }

    public void setEmailid(String emailid) {
        this.emailid = emailid;
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

    public Float getCasualLeaves() {
        return casualLeaves;
    }

    public void setCasualLeaves(Float casualLeaves) {
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

    @XmlTransient
    public Collection<ProjectDetailsResponse> getProjectDetailsCollection() {
        return projectDetailsCollection;
    }

    public void setProjectDetailsCollection(Collection<ProjectDetailsResponse> projectDetailsCollection) {
        this.projectDetailsCollection = projectDetailsCollection;
    }

    @XmlTransient
    public Collection<TimeAndExpenseResponse> getTimeandexpenseCollection() {
        return timeandexpenseCollection;
    }

    public void setTimeandexpenseCollection(Collection<TimeAndExpenseResponse> timeandexpenseCollection) {
        this.timeandexpenseCollection = timeandexpenseCollection;
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
        return "[ employeeid=" + employeeId + " ]";
    }

}
