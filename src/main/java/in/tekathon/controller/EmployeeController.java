/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.tekathon.controller;

import in.tekathon.common.URIConstants;
import in.tekathon.model.Employee;
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
    public List<Employee> getAllEmployees() {

        List<Employee> employees = employeeDao.getAllEmployees();
        return employees;
    }

    @GET
    @Path(URIConstants.GET_EMP_BY_ID)
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Employee getEmployeeById(@PathParam("employeeId") int id) {
        System.out.println("id :"+id);
        Employee employees = employeeDao.getEmployeeById(id);
        return employees;
    }

    @POST
    @Path(URIConstants.CREATE_EMP)
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response createEmployee(Employee employee) {

        String result = employeeDao.insertEmployee(employee);
        if (result == null) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        return Response.ok("{\"Status\": \"Success\"}").build();
    }

    @POST
    @Path(URIConstants.UPDATE_EMP)
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response updateEmployee(@PathParam("employeeId") int id, Employee employee) {

        int count = employeeDao.updateEmployee(id, employee);
        if (count == 0) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        return Response.ok("{\"Status\": \"Success\"}").build();
    }

    @GET
    @Path(URIConstants.DELETE_EMP)
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response deleteEmployee(@PathParam("employeeId") int id) {

        int count = employeeDao.deleteEmployee(id);
        if (count == 0) {
            return Response.status(Response.Status.BAD_REQUEST).build();
        }
        return Response.ok("{\"Status\": \"Success\"}").build();
    }

}
