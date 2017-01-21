/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.tekathon.service;

import in.tekathon.connection.HibernateUtil;
import in.tekathon.query.QueryManager;
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
    QueryManager queryManager = new QueryManager();
    Session session = HibernateUtil.getSessionFactory().openSession();
    Transaction transaction = null;

    public int leaveApplication(String employeeId, String absenceCategory, String leaveReason, String startDate, String endDate, String comments) {
        try {
            transaction = session.beginTransaction();
            String sql = queryManager.getQuery("TimeAndExpenseController", "applyLeaves");
            Query query = session.createQuery(sql);
            query.setParameter("absenceCategory", absenceCategory);
            query.setParameter("startDate", leaveReason);
            query.setParameter("endDate", startDate);
            query.setParameter("leaveReason", endDate);
            query.setParameter("comments", comments);
            int rowCount = query.executeUpdate();
            transaction.commit();
            return rowCount;
        } catch (HibernateException ex) {

        } catch (Exception ex) {

        } finally {
            session.close();
        }
        return 0;
    }
}
