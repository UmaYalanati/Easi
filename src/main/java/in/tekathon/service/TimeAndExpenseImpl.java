/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.tekathon.service;

import in.tekathon.connection.HibernateUtil;
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
public class TimeAndExpenseImpl implements TimeAndExepenseIntf {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    Session session = HibernateUtil.getSessionFactory().openSession();
    Transaction transaction = null;

    @Override
    public TimeAndExpenseResponse checkTimeSheet(int id, double latitude, double longitude, String comments, String attendanceMode, int flag) {
        try {
            transaction = session.beginTransaction();

            Query query = session.getNamedQuery("fillTimeSheetProcedure");

            query.setParameter("id", id);
            query.setParameter("latitude", latitude);
            query.setParameter("longitude", latitude);
            query.setParameter("comments", comments);
            query.setParameter("attendanceMode", attendanceMode);
            query.setParameter("absenceCategory", null);
            query.setParameter("leaveReason", null);
            query.setParameter("insertDate", null);
            query.setParameter("endDate", null);
            query.setParameter("statusFlag", flag);

            TimeAndExpenseResponse resultList = (TimeAndExpenseResponse) query.uniqueResult();
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

    /*    @Override
    public List<TimeAndExpenseResponse> checkoutTimeSheet(int timesheetId, double latitude, double longitude, String comments, String attendanceMode) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {

//            transaction = session.beginTransaction();
//
//            TimeAndExpenseResponse response = (TimeAndExpenseResponse) session.get(TimeAndExpenseResponse.class, timesheetId);
//
//            response.setCheckoutTime(comments);
//            response.setCheckoutLatitude(latitude);
//            response.setCheckoutLongitude(longitude);
//            response.setComments(comments);
//            response.setAttendanceMode(attendanceMode);
//            response.setWorkingHours(8);
//            transaction.commit();
            transaction = session.beginTransaction();

            Query query = session.getNamedQuery("fillTimeSheetProcedure");

            query.setParameter("id", timesheetId);
            query.setParameter("latitude", latitude);
            query.setParameter("longitude", latitude);
            query.setParameter("comments", comments);
            query.setParameter("attendanceMode", attendanceMode);
            query.setParameter("absenceCategory", null);
            query.setParameter("leaveReason", null);
            query.setParameter("insertDate", null);
            query.setParameter("endDate", null);
            query.setParameter("statusFlag", 1);

//            List resultList = createQuery.list();
            List<TimeAndExpenseResponse> resultList = query.list();
            transaction.commit();
            return resultList;
        } catch (HibernateException ex) {
            transaction.rollback();
            logger.error("Exception :" + ex);
        } catch (Exception ex) {
            logger.error("Exception :" + ex);
        } finally {
            session.close();
        }

        return null;
    }*/
    public List<TimeAndExpenseResponse> getTimesheetById(int employeeId, String fromDate, String toDate) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();

//            String findByEmployeeid = "SELECT t FROM TimeAndExpenseResponse t WHERE employeeId = :employeeId";
            String findByEmployeeid = "SELECT t FROM TimeAndExpenseResponse t WHERE employeeId = :employeeId and insertDate between :fromDate and :toDate";
            Query query = session.createQuery(findByEmployeeid, TimeAndExpenseResponse.class);
            query.setParameter("employeeId", employeeId);
            query.setParameter("fromDate", fromDate);
            query.setParameter("toDate", toDate);

            List<TimeAndExpenseResponse> response = query.list();
            transaction.commit();
            return response;
        } catch (HibernateException ex) {
            transaction.rollback();
            logger.error("Exception :" + ex);
        } catch (Exception ex) {
            logger.error("Exception :" + ex);
        } finally {
            session.close();
        }
        return null;
    }

}
