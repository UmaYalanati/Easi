/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.tekathon.controller;

import in.tekathon.common.URIConstants;
import in.tekathon.service.TimeAndExpenseImpl;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author administrator
 */
@Path("/timeandexpense")
public class TimeAndExpenseController {

    TimeAndExpenseImpl application = new TimeAndExpenseImpl();

    @GET
    @Path(URIConstants.APPLY_LEAVES)
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public void leaveApplication(@PathParam("employeeId") String employeeId,
            @QueryParam("absenceCategory") String absenceCategory,
            @QueryParam("leaveReason") String leaveReason,
            @QueryParam("startDate") String startDate,
            @QueryParam("endDate") String endDate,
            @QueryParam("comments") String comments) {

        int leaveApplication = application.leaveApplication(employeeId, absenceCategory, leaveReason, startDate, endDate, comments);

    }

}
