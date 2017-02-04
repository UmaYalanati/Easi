/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.tekathon.controller;

import in.tekathon.common.URIConstants;
import in.tekathon.model.LeaveApplicationResponse;
import in.tekathon.service.LeaveImpl;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author administrator
 */
@Path(URIConstants.EMPLOYEECONTROLLER)
public class LeaveApplicationController {

    private final Logger logger = LoggerFactory.getLogger(getClass());
    LeaveImpl applyLeaveDao = new LeaveImpl();

    @GET
    @Path(URIConstants.APPLY_LEAVES)
    @Produces({MediaType.APPLICATION_JSON})
    public Response leaveApplication(
            @QueryParam("id") int id,
            @QueryParam("reportingManagerId") int reportingManagerId,
            @QueryParam("attendanceMode") String attendanceMode,
            @QueryParam("absenceCategory") String absenceCategory,
            @QueryParam("leaveReason") String leaveReason,
            @QueryParam("startDate") String startDate,
            @QueryParam("endDate") String endDate,
            @QueryParam("leaveComments") String leaveComments) {

        LeaveApplicationResponse response = applyLeaveDao.leaveApplication(id, reportingManagerId, absenceCategory, attendanceMode, leaveReason, startDate, endDate, leaveComments);
        if (response == null) {
            return Response.status(Response.Status.NO_CONTENT).entity(response).build();
        }
        return Response.status(Response.Status.CREATED).entity(response).build();
    }

    @GET
    @Path(URIConstants.MANAGERAPPROVAL)
    @Produces({MediaType.APPLICATION_JSON})
    public Response managerApproval(
            @QueryParam("id") int id,
            @QueryParam("status") String status) {

        System.out.println("status" + status);

        LeaveApplicationResponse response = applyLeaveDao.managerApproval(id, status);
        if (response == null) {
            return Response.status(Response.Status.NO_CONTENT).entity(response).build();
        }
        return Response.status(Response.Status.CREATED).entity(response).build();
    }

    @GET
    @Path(URIConstants.LEAVEDETAILSREPORT)
    @Produces({MediaType.APPLICATION_JSON})
    public Response leaveDetailsReport(
            @QueryParam("employeeId") int employeeId,
            @QueryParam("startDate") String startDate,
            @QueryParam("endDate") String endDate
    ) {

        List<LeaveApplicationResponse> response = applyLeaveDao.leaveDetailsReport(employeeId, startDate, endDate);
        if (response == null) {
            return Response.status(Response.Status.NO_CONTENT).entity(response).build();
        }
        return Response.status(Response.Status.CREATED).entity(response).build();
    }

}
