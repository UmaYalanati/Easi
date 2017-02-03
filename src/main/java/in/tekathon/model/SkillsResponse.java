/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.tekathon.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author administrator
 */
@Entity
@Table(name = "SKILLS")
public class SkillsResponse implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Column(name = "SKILLSID")
    @JsonIgnore
    private Integer skillsId;
    @Size(max = 1000)
    @Column(name = "DATABASE_SKILLS")
    private String databaseSkills;
    @Size(max = 1000)
    @Column(name = "OPERATING_SYSTEM")
    private String operatingSystem;
    @Size(max = 1000)
    @Column(name = "TOOLS_COMPETENCY")
    private String toolsCompetency;
    @Size(max = 1000)
    @Column(name = "SOURCECODE_MANAGEMENT")
    private String sourcecodeManagement;
    @Size(max = 1000)
    @Column(name = "SCRIPTING_TOOLS")
    private String scriptingTools;
    @Size(max = 1000)
    @Column(name = "SOA_SKILLS")
    private String soaSkills;
    @JoinColumn(name = "employeeId", referencedColumnName = "employeeId")
    @OneToOne(optional = false, fetch = FetchType.EAGER)
    @JsonBackReference
    private EmployeeResponse employeeId;

    public Integer getSkillsId() {
        return skillsId;
    }

    public void setSkillsId(Integer skillsId) {
        this.skillsId = skillsId;
    }

    public String getDatabaseSkills() {
        return databaseSkills;
    }

    public void setDatabaseSkills(String databaseSkills) {
        this.databaseSkills = databaseSkills;
    }

    public String getOperatingSystem() {
        return operatingSystem;
    }

    public void setOperatingSystem(String operatingSystem) {
        this.operatingSystem = operatingSystem;
    }

    public String getToolsCompetency() {
        return toolsCompetency;
    }

    public void setToolsCompetency(String toolsCompetency) {
        this.toolsCompetency = toolsCompetency;
    }

    public String getSourcecodeManagement() {
        return sourcecodeManagement;
    }

    public void setSourcecodeManagement(String sourcecodeManagement) {
        this.sourcecodeManagement = sourcecodeManagement;
    }

    public String getScriptingTools() {
        return scriptingTools;
    }

    public void setScriptingTools(String scriptingTools) {
        this.scriptingTools = scriptingTools;
    }

    public String getSoaSkills() {
        return soaSkills;
    }

    public void setSoaSkills(String soaSkills) {
        this.soaSkills = soaSkills;
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
        hash += (skillsId != null ? skillsId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof SkillsResponse)) {
            return false;
        }
        SkillsResponse other = (SkillsResponse) object;
        if ((this.skillsId == null && other.skillsId != null) || (this.skillsId != null && !this.skillsId.equals(other.skillsId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "in.tekathon.samplepages.model.service.Skills[ skillsid=" + skillsId + " ]";
    }

}
