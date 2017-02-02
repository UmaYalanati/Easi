/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.tekathon.model;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author administrator
 */
@Entity
@Table(name = "PROJECT_DETAILS")
@XmlRootElement
public class ProjectDetailsResponse implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "projectId")
    private Collection<TimeAndExpenseResponse> timeandexpenseCollection;
    
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "PROJECTID")
    private Integer projectId;
    @Size(max = 100)
    @Column(name = "PROJECTNAME")
    private String projectName;
    @Size(max = 100)
    @Column(name = "ROLE")
    private String role;
    @Size(max = 100)
    @Column(name = "PROJECTLOCATION")
    private String projectLocation;
    @Size(max = 10)
    @Column(name = "PROJECTMANAGERID")
    private String projectManagerId;
    @Size(max = 10)
    @Column(name = "DELIVERYMANAGERID")
    private String deliveryManagerId;
    @JoinColumn(name = "EMPLOYEEID", referencedColumnName = "EMPLOYEEID")
    @ManyToOne
    private EmployeeResponse employeeId;

    public ProjectDetailsResponse() {
    }

    public ProjectDetailsResponse(Integer projectId) {
        this.projectId = projectId;
    }

    public Integer getProjectId() {
        return projectId;
    }

    public void setProjectId(Integer projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getProjectLocation() {
        return projectLocation;
    }

    public void setProjectLocation(String projectLocation) {
        this.projectLocation = projectLocation;
    }

    public String getProjectManagerId() {
        return projectManagerId;
    }

    public void setProjectManagerId(String projectManagerId) {
        this.projectManagerId = projectManagerId;
    }

    public String getDeliveryManagerId() {
        return deliveryManagerId;
    }

    public void setDeliveryManagerId(String deliveryManagerId) {
        this.deliveryManagerId = deliveryManagerId;
    }

    public EmployeeResponse getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(EmployeeResponse employeeId) {
        this.employeeId = employeeId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (projectId != null ? projectId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProjectDetailsResponse)) {
            return false;
        }
        ProjectDetailsResponse other = (ProjectDetailsResponse) object;
        if ((this.projectId == null && other.projectId != null) || (this.projectId != null && !this.projectId.equals(other.projectId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "[ projectid=" + projectId + " ]";
    }

}
