/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.tekathon.common;

/**
 *
 * @author administrator
 */
public class Queries {
    
    
//    EmployeeController
    
    public static final String FINDALL = "SELECT e FROM EmployeeResponse";
    public static final String FINDEMPLOYEEBYID = "SELECT e FROM EmployeeResponse e WHERE employeeid = :employeeid";
    public static final String CREATEEMPLOYEE = "call CREATEUSER(:firstName, :lastName, :street, :city, :state, :pincode, :country, :contactNo, :dateOfBirth, :designation, :dateOfJoining, :yearsOfExperience, :reportingManagerId)";
    public static final String UPDATEEMPLOYEEBYID = "UPDATE EmployeeResponse e set firstName=:firstName, lastName=:lastName, userName=:userName, password=:password, street=:street, city=:city, state=:state, pincode=:pincode, country=:country, emailId=:emailId, contactNo=:contactNo, dateOfBirth=:dateOfBirth, designation=:designation, dateOfJoining=:dateOfJoining, yearsOfExperience=:yearsOfExperience, reportingManagerId=:reportingManagerId WHERE id=:id";
}
