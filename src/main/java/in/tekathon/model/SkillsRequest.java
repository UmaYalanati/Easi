/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.tekathon.model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 *
 * @author administrator
 */
public class SkillsRequest {

    @JsonProperty("employeeId")
    private String employeeId;
    @JsonProperty("databaseSkills")
    private String databaseSkills;
    @JsonProperty("operatingSystem")
    private String operatingSystem;
    @JsonProperty("sourceCodeManagement")
    private String sourceCodeManagement;
    @JsonProperty("scriptingTools")
    private String scriptingTools;
    @JsonProperty("soaSkills")
    private String soaSkills;
    @JsonProperty("toolsCompetency")
    private String toolsCompetency;

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
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

    public String getSourceCodeManagement() {
        return sourceCodeManagement;
    }

    public void setSourceCodeManagement(String sourceCodeManagement) {
        this.sourceCodeManagement = sourceCodeManagement;
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

    public String getToolsCompetency() {
        return toolsCompetency;
    }

    public void setToolsCompetency(String toolsCompetency) {
        this.toolsCompetency = toolsCompetency;
    }

}
