/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.tekathon.controller;

import in.tekathon.common.URIConstants;
import in.tekathon.model.EmployeeResponse;
import in.tekathon.service.LoginImpl;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author administrator
 */
@Path("/teksystems")
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
    public Response loginUser(@QueryParam("userName") int userName,
            @QueryParam("password") String password) {

        EmployeeResponse login = loginDao.login(userName, password);
        if (login == null) {
            return Response.status(Response.Status.NOT_FOUND).entity("{\"STATUS\": \"Invalud user\"}").build();
        }
        return Response.status(Response.Status.OK).entity(login).build();
    }

}
