/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.tekathon.controller;

import in.tekathon.common.URIConstants;
import in.tekathon.model.TimeAndExpenseResponse;
import in.tekathon.service.TimeAndExpenseImpl;
import java.util.List;
import javax.validation.constraints.Pattern;
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
@Path(URIConstants.TIMEANDEXPENSECONTROLLER)
public class TimeAndExpenseController {

    private final Logger logger = LoggerFactory.getLogger(getClass());
    TimeAndExpenseImpl report = new TimeAndExpenseImpl();

    @GET
    @Path(URIConstants.CHECKINOUTTIMESHEET)
    @Produces({MediaType.APPLICATION_JSON})
    public Response checkTimeSheet(
            @QueryParam("id") int id,
            @QueryParam("latitude") double latitude,
            @QueryParam("longitude") double longitude,
            @QueryParam("comments") String comments,
            @QueryParam("attendanceMode") String attendanceMode,
            @QueryParam("flag") @Pattern(regexp = "^.{1,2}$") int flag) {

        TimeAndExpenseResponse response = report.checkTimeSheet(id, latitude, longitude, comments, attendanceMode, flag);
        if (response == null) {
            return Response.status(Response.Status.NO_CONTENT).entity(response).build();
        }
        return Response.status(Response.Status.CREATED).entity(response).build();
    }

//    @GET
//    @Path(URIConstants.CHECKOUTTIMESHEET)
//    @Produces({MediaType.APPLICATION_JSON})
//    public Response checkoutTimeSheet(
//            @QueryParam("timesheetId") int timesheetId,
//            @QueryParam("latitude") double latitude,
//            @QueryParam("longitude") double longitude,
//            @QueryParam("comments") String comments,
//            @QueryParam("attendanceMode") String attendanceMode) {
//
//        List<TimeAndExpenseResponse> response = report.checkoutTimeSheet(timesheetId, latitude, longitude, comments, attendanceMode);
//
//        if (response == null) {
//            return Response.status(Response.Status.NO_CONTENT).entity(response).build();
//        }
//        return Response.status(Response.Status.CREATED).entity(response).build();
//    }
    @GET
    @Path(URIConstants.GETTIMESHEETBYID)
    @Produces({MediaType.APPLICATION_JSON})
    public Response getTimesheetById(
            @QueryParam("employeeId") int employeeId,
            @QueryParam("fromDate") String fromDate,
            @QueryParam("toDate") String toDate
    ) {
        List<TimeAndExpenseResponse> response = report.getTimesheetById(employeeId, fromDate, toDate);

        if (response == null) {
            return Response.status(Response.Status.NO_CONTENT).entity(response).build();
        }
        return Response.status(Response.Status.CREATED).entity(response).build();
    }

    @GET
    @Path(URIConstants.APPLY_LEAVES)
    @Produces({MediaType.APPLICATION_JSON})
    public Response leaveApplication(
            @QueryParam("employeeId") int employeeId,
            @QueryParam("attendanceMode") String attendanceMode,
            @QueryParam("absenceCategory") String absenceCategory,
            @QueryParam("leaveReason") String leaveReason,
            @QueryParam("startDate") String startDate,
            @QueryParam("endDate") String endDate,
            @QueryParam("leaveComments") String leaveComments) {

        List<TimeAndExpenseResponse> response = report.leaveApplication(employeeId, attendanceMode, absenceCategory, leaveReason, startDate, endDate, leaveComments);
        if (response == null) {
            return Response.status(Response.Status.NO_CONTENT).entity(response).build();
        }
        return Response.status(Response.Status.CREATED).entity(response).build();
    }

    @GET
    @Path(URIConstants.MANAGERAPPROVAL)
    @Produces({MediaType.APPLICATION_JSON})
    public Response managerApproval(
            @QueryParam("employeeId") int employeeId,
            @QueryParam("startDate") String startDate,
            @QueryParam("endDate") String endDate,
            @QueryParam("status") String status) {

        List<TimeAndExpenseResponse> response = report.managerApproval(employeeId, startDate, endDate, status);
        if (response == null) {
            return Response.status(Response.Status.NO_CONTENT).entity(response).build();
        }
        return Response.status(Response.Status.CREATED).entity(response).build();
    }

}
