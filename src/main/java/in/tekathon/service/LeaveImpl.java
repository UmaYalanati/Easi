/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.tekathon.service;

import in.tekathon.connection.HibernateUtil;
import in.tekathon.model.EmployeeResponse;
import in.tekathon.model.LeaveApplicationResponse;
import in.tekathon.model.TimeAndExpenseResponse;
import java.util.List;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author administrator
 */
public class LeaveImpl implements LeaveIntf {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    Session session = HibernateUtil.getSessionFactory().openSession();
    Transaction transaction = null;
    EmployeeImpl employeeDao = new EmployeeImpl();

    public LeaveApplicationResponse leaveApplication(int id, String absenceCategory, String attendanceMode, String leaveReason, String startDate, String endDate, String leaveComments) {
        try {
            transaction = session.beginTransaction();
//            String sql = queryManager.getQuery("TimeAndExpenseController", "applyLeaves");
            int noOfDays = 0;
            Query query = session.getNamedQuery("leaveDetailsProcedure");
            query.setParameter("id", id);
            query.setParameter("absenceCategory", absenceCategory);
            query.setParameter("attendanceMode", attendanceMode);
            query.setParameter("leaveReason", leaveReason);
            query.setParameter("startDate", startDate);
            query.setParameter("endDate", endDate);
            query.setParameter("status", "PENDING");
            query.setParameter("comments", leaveComments);
            query.setParameter("statusFlag", 1);

            LeaveApplicationResponse resultList = (LeaveApplicationResponse) query.uniqueResult();

            transaction.commit();
            return resultList;
        } catch (HibernateException ex) {
            logger.error("Exception : " + ex);
        } catch (Exception ex) {
            logger.error("Exception : " + ex);
        } finally {
            session.close();
        }
        return null;
    }

    public LeaveApplicationResponse managerApproval(int id, String startDate, String endDate, String status) {
        try {
            int noOfDays = 0;
            transaction = session.beginTransaction();

            Query query = session.getNamedQuery("leaveDetailsProcedure");
            query.setParameter("id", id);
            query.setParameter("absenceCategory", null);
            query.setParameter("attendanceMode", null);
            query.setParameter("leaveReason", null);
            query.setParameter("startDate", startDate);
            query.setParameter("endDate", endDate);
            query.setParameter("status", status.toUpperCase());
            query.setParameter("comments", null);
            query.setParameter("statusFlag", 1);
            
            LeaveApplicationResponse response = (LeaveApplicationResponse) query.uniqueResult();

            if (response != null) {
                int employeeId = response.getEmployeeId();
                String absenceCategory = response.getAbsenceCategory().toUpperCase();
                EmployeeResponse employees = employeeDao.getEmployeeById(employeeId);

                switch (absenceCategory) {

                    case "NORMAL":
                        employees.setCasualLeaves(employees.getCasualLeaves() - noOfDays);
                        break;
                    case "SICK":
                        employees.setSickLeaves(employees.getSickLeaves() - noOfDays);
                        break;
                    case "COMP_OFF":
                        employees.setCompOffs(employees.getCompOffs() - noOfDays);
                        break;
                    case "OPTIONAL":
//                        employees(employees.getCompOffs()- noOfDays);
                        break;
                    default:
                        break;

                }

            }
            transaction.commit();
            return response;

        } finally {
            session.close();
        }

    }

}
