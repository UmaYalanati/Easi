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
public class URIConstants {

//    Employee Controller
    public static final String EMPLOYEECONTROLLER = "/employees";
    public static final String GET_EMP_BY_ID = "/{employeeId}";
    public static final String CREATE_EMP = "/create";
    public static final String UPDATE_EMP = "/update/{employeeId}";
    public static final String DELETE_EMP = "/delete/{employeeId}";
    public static final String GET_CHILDEMP_BY_ID = "/reportes/{employeeId}";

//    Login Controller
    public static final String LOGINCONTROLLER = "/teksystems";
    public static final String RESET_PASSWORD = "/resetPassword ";
    public static final String LOGIN = "/login";

//    Time And Expense Controller
    public static final String TIMEANDEXPENSECONTROLLER = "/timeandexpense";
    public static final String CHECKINOUTTIMESHEET = "/checkIn-OutTimeSheet";
    public static final String CHECKOUTTIMESHEET = "/checkoutTimeSheet";
    public static final String GETTIMESHEETREPORT = "/getTimesheetReport";
    public static final String GETTIMESHEETBYID = "/timesheetById";

    // Leave Controller
    public static final String APPLY_LEAVES = "/applyLeaves";
    public static final String MANAGERAPPROVAL = "/managerApproval";
    public static final String LEAVEDETAILSREPORT = "/leaveDetailsReport";
}
