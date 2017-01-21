/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.tekathon.controller;

import in.tekathon.common.URIConstants;
import in.tekathon.model.EmployeeRequest;
import in.tekathon.model.EmployeeResponse;
import in.tekathon.service.EmployeeImpl;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author administrator
 */
@Path("/employees")
public class EmployeeController {

    private final Logger logger = LoggerFactory.getLogger(getClass());
    EmployeeImpl employeeDao = new EmployeeImpl();

    @GET
    @Produces("application/json")
    @Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
    public List<EmployeeResponse> getAllEmployees() {

        List<EmployeeResponse> employees = employeeDao.getAllEmployees();
        
        return employees;
    }

    @GET
    @Path(URIConstants.GET_EMP_BY_ID)
    @Produces(MediaType.APPLICATION_JSON)
    public Response getEmployeeById(@PathParam("id") int id) {
        EmployeeResponse employees = employeeDao.getEmployeeById(id);
        if(employees == null)
        {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
        return Response.ok(employees).build();
    }

    @POST
    @Path(URIConstants.CREATE_EMP)
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createEmployee(EmployeeRequest employee) {
        System.out.println("Inside employee");
        int result = employeeDao.insertEmployee(employee);
        if (result == 0) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        return Response.ok("{\"Status\": \"Success\"}").build();
    }

    @POST
    @Path(URIConstants.UPDATE_EMP)
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateEmployee(@PathParam("id") int id, EmployeeRequest employee) {

        EmployeeResponse response = employeeDao.updateEmployee(id, employee);
        if (response == null) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        return Response.ok(response).build();
    }

    @GET
    @Path(URIConstants.DELETE_EMP)
    @Produces(MediaType.APPLICATION_JSON)
    public Response deleteEmployee(@PathParam("id") int id) {

        int count = employeeDao.deleteEmployee(id);
        if (count == 0) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        return Response.ok("{\"Status\": \"Success\"}").build();
    }

}
