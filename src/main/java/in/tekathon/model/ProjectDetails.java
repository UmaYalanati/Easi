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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
public class ProjectDetails implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "PROJECTID")
    private Integer projectid;
    @Size(max = 100)
    @Column(name = "PROJECTNAME")
    private String projectname;
    @Size(max = 100)
    @Column(name = "ROLE")
    private String role;
    @Size(max = 100)
    @Column(name = "PROJECTLOCATION")
    private String projectlocation;
    @Size(max = 10)
    @Column(name = "PROJECTMANAGERID")
    private String projectmanagerid;
    @Size(max = 10)
    @Column(name = "DELIVERYMANAGERID")
    private String deliverymanagerid;
    @JoinColumn(name = "EMPLOYEEID", referencedColumnName = "EMPLOYEEID")
    @ManyToOne
    private EmployeeRequest employeeid;

    public ProjectDetails() {
    }

    public ProjectDetails(Integer projectid) {
        this.projectid = projectid;
    }

    public Integer getProjectid() {
        return projectid;
    }

    public void setProjectid(Integer projectid) {
        this.projectid = projectid;
    }

    public String getProjectname() {
        return projectname;
    }

    public void setProjectname(String projectname) {
        this.projectname = projectname;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getProjectlocation() {
        return projectlocation;
    }

    public void setProjectlocation(String projectlocation) {
        this.projectlocation = projectlocation;
    }

    public String getProjectmanagerid() {
        return projectmanagerid;
    }

    public void setProjectmanagerid(String projectmanagerid) {
        this.projectmanagerid = projectmanagerid;
    }

    public String getDeliverymanagerid() {
        return deliverymanagerid;
    }

    public void setDeliverymanagerid(String deliverymanagerid) {
        this.deliverymanagerid = deliverymanagerid;
    }

    public EmployeeRequest getEmployeeid() {
        return employeeid;
    }

    public void setEmployeeid(EmployeeRequest employeeid) {
        this.employeeid = employeeid;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (projectid != null ? projectid.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ProjectDetails)) {
            return false;
        }
        ProjectDetails other = (ProjectDetails) object;
        if ((this.projectid == null && other.projectid != null) || (this.projectid != null && !this.projectid.equals(other.projectid))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.teksystems.model.ProjectDetails[ projectid=" + projectid + " ]";
    }
    
}
