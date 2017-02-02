/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.tekathon.test;

import in.tekathon.connection.HibernateUtil;
import in.tekathon.model.EmployeeResponse;
import in.tekathon.model.TimeAndExpenseResponse;
import java.util.List;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

/**
 *
 * @author administrator
 */
public class TimeExpenseTest {

    static Session session = HibernateUtil.getSessionFactory().openSession();
    static Transaction transaction = null;

    public static void main(String[] args) {
        transaction = session.beginTransaction();

        String insertQuery = "CALL TIMESHEET_INSERT(:employeeId, :latitude, :longitude, :comments, :approvalType, :attendanceMode, :status)";

        Query createQuery = session.getNamedQuery("fillTimeSheetProcedure");
        createQuery.setParameter("employeeId", 16);
        createQuery.setParameter("latitude", 9.22333);
        createQuery.setParameter("longitude", 2.23322);
        createQuery.setParameter("comments", "Hello");
        createQuery.setParameter("approvalType", "Hello");
        createQuery.setParameter("attendanceMode", "hello");
        createQuery.setParameter("status", "hello");
        List<TimeAndExpenseResponse> resultList = createQuery.getResultList();
        
    }

}
