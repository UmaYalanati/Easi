package in.tekathon.common;
// Generated Jan 22, 2017 3:39:42 PM by Hibernate Tools 4.3.1



/**
 * ProjectDetails generated by hbm2java
 */
public class ProjectDetails  implements java.io.Serializable {


     private int projectid;
     private Integer employeeid;
     private String projectname;
     private String role;
     private String projectlocation;
     private String projectmanagerid;
     private String deliverymanagerid;

    public ProjectDetails() {
    }

	
    public ProjectDetails(int projectid) {
        this.projectid = projectid;
    }
    public ProjectDetails(int projectid, Integer employeeid, String projectname, String role, String projectlocation, String projectmanagerid, String deliverymanagerid) {
       this.projectid = projectid;
       this.employeeid = employeeid;
       this.projectname = projectname;
       this.role = role;
       this.projectlocation = projectlocation;
       this.projectmanagerid = projectmanagerid;
       this.deliverymanagerid = deliverymanagerid;
    }
   
    public int getProjectid() {
        return this.projectid;
    }
    
    public void setProjectid(int projectid) {
        this.projectid = projectid;
    }
    public Integer getEmployeeid() {
        return this.employeeid;
    }
    
    public void setEmployeeid(Integer employeeid) {
        this.employeeid = employeeid;
    }
    public String getProjectname() {
        return this.projectname;
    }
    
    public void setProjectname(String projectname) {
        this.projectname = projectname;
    }
    public String getRole() {
        return this.role;
    }
    
    public void setRole(String role) {
        this.role = role;
    }
    public String getProjectlocation() {
        return this.projectlocation;
    }
    
    public void setProjectlocation(String projectlocation) {
        this.projectlocation = projectlocation;
    }
    public String getProjectmanagerid() {
        return this.projectmanagerid;
    }
    
    public void setProjectmanagerid(String projectmanagerid) {
        this.projectmanagerid = projectmanagerid;
    }
    public String getDeliverymanagerid() {
        return this.deliverymanagerid;
    }
    
    public void setDeliverymanagerid(String deliverymanagerid) {
        this.deliverymanagerid = deliverymanagerid;
    }




}

