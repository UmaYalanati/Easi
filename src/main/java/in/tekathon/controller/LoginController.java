/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.tekathon.controller;

import in.tekathon.common.URIConstants;
import in.tekathon.service.EmployeeImpl;
import in.tekathon.service.LoginImpl;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author administrator
 */
public class LoginController {
    
    private final Logger logger = LoggerFactory.getLogger(getClass());
    LoginImpl loginDao = new LoginImpl();
    
    @GET
    @Path(URIConstants.RESET_PASSWORD)
    @Produces("application/json")
    public String resetpassword() {
        return "{\"RedirectLink\": \"https://password.allegisgroup.com/\"}";
    }
    
    @GET
    @Path(URIConstants.LOGIN)
    @Produces("application/json")
    public String loginUser(@PathParam("employeeId") int employeeId,
            @PathParam("userName") String userName,
            @PathParam("password") String password) {
        
        loginDao.login(employeeId, userName, password);
        return "{\"RedirectLink\": \"https://password.allegisgroup.com/\"}";
    }
    
}
