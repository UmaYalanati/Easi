/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.tekathon.service;

import in.tekathon.connection.HibernateUtil;
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

    public LeaveApplicationResponse leaveApplication(int employeeId, String absenceCategory, String attendanceMode, String leaveReason, String startDate, String endDate, String leaveComments) {
        try {
            transaction = session.beginTransaction();
//            String sql = queryManager.getQuery("TimeAndExpenseController", "applyLeaves");
            int noOfDays = 0;
            Query query = session.getNamedQuery("leaveDetailsProcedure");
            query.setParameter("employeeId", employeeId);
            query.setParameter("absenceCategory", absenceCategory);
            query.setParameter("attendanceMode", attendanceMode);
            query.setParameter("leaveReason", leaveReason);
            query.setParameter("startDate", startDate);
            query.setParameter("endDate", endDate);
            query.setParameter("status", "PENDING");
            query.setParameter("noOfDays", noOfDays);
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

}
