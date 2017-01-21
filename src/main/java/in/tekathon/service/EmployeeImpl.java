/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.tekathon.service;

import com.sun.istack.Nullable;
import in.tekathon.connection.HibernateUtil;
import in.tekathon.model.EmployeeRequest;
import in.tekathon.model.EmployeeResponse;
import in.tekathon.query.QueryManager;
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
public class EmployeeImpl implements EmployeeIntf {

    private final Logger logger = LoggerFactory.getLogger(getClass());
    QueryManager queryManager = new QueryManager();
    Session session = HibernateUtil.getSessionFactory().openSession();
    Transaction transaction = null;

    @Override
    public List<EmployeeResponse> getAllEmployees() {

        try {
            transaction = getSession().beginTransaction();
//            String sql = queryManager.getQuery("EmployeeController", "getAllEmployees");
            String findAll = "SELECT e FROM EmployeeResponse e";
            Query query = getSession().createQuery(findAll, EmployeeResponse.class);
            List<EmployeeResponse> employeeList = query.list();
            transaction.commit();
            return employeeList;
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

    @Override
    public EmployeeResponse getEmployeeById(int id) {
        try {
            transaction = getSession().beginTransaction();
            String findByEmployeeid = "SELECT e FROM EmployeeResponse e WHERE id = :id";
            Query query = getSession().createQuery(findByEmployeeid, EmployeeResponse.class);
            query.setParameter("id", id);
            EmployeeResponse employee = (EmployeeResponse) query.uniqueResult();
            transaction.commit();
            return employee;
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

    @Override
    public int insertEmployee(EmployeeRequest employee) {
        try {
            transaction = getSession().beginTransaction();
            String insertEmployee = "call CREATEUSER(:firstName, :lastName, :street, :city, :state, :pincode, :country, :contactNo, :dateOfBirth, :designation, :dateOfJoining, :yearsOfExperience, :reportingManagerId)";
            Query query = getSession().createQuery(insertEmployee, EmployeeResponse.class);
            query.setParameter("firstName", employee.getFirstName());
            query.setParameter("lastName", employee.getLastName());
            query.setParameter("street", employee.getStreet());
            query.setParameter("city", employee.getCity());
            query.setParameter("state", employee.getState());
            query.setParameter("pincode", employee.getPincode());
            query.setParameter("country", employee.getCountry());
            query.setParameter("contactNo", employee.getContactNo());
            query.setParameter("dateOfBirth", employee.getDateOfBirth());
            query.setParameter("designation", employee.getDesignation());
            query.setParameter("dateOfJoining", employee.getDateOfJoining());
            query.setParameter("yearsOfExperience", employee.getYearsOfExperience());
            query.setParameter("reportingManagerId", employee.getReportingManagerId());

            List<EmployeeResponse> result = query.list();;
            transaction.commit();
            return 1;
        } catch (HibernateException ex) {
            transaction.rollback();
            logger.error("Exception :" + ex);
        } catch (Exception ex) {
            logger.error("Exception :" + ex);
        } finally {
            session.close();
        }
        return 0;
    }

    @Override
    public EmployeeResponse updateEmployee(int id, EmployeeRequest employee) {
        try {

            transaction = getSession().beginTransaction();

            EmployeeResponse employeeResponse = (EmployeeResponse) getSession().get(EmployeeResponse.class, id);
            employeeResponse.setFirstName(employee.getFirstName());
            employeeResponse.setLastName(employee.getLastName());
            employeeResponse.setStreet(employee.getStreet());
            employeeResponse.setCity(employee.getCity());
            employeeResponse.setState(employee.getState());
            employeeResponse.setPincode(employee.getPincode());
            employeeResponse.setCountry(employee.getCountry());
            employeeResponse.setContactNo(employee.getContactNo());
            employeeResponse.setDateOfBirth(employee.getDateOfBirth());
            employeeResponse.setDesignation(employee.getDesignation());
            employeeResponse.setDateOfJoining(employee.getDateOfJoining());
            employeeResponse.setYearsOfExperience(employee.getYearsOfExperience());
            employeeResponse.setReportingManagerId(employee.getReportingManagerId());

            transaction.commit();
            return employeeResponse;
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

    @Override
    public int deleteEmployee(int employeeId) {
        try {
            transaction = getSession().beginTransaction();

            EmployeeResponse employee = (EmployeeResponse) getSession().get(EmployeeResponse.class, employeeId);
            session.delete(employee);
            transaction.commit();
            return 1;
        } catch (HibernateException ex) {
            transaction.rollback();
            logger.error("Exception :" + ex);
        } finally {
            session.close();
        }
        return 0;
    }

    /**
     * Generate automatic UserName from firstName and lastName
     *
     * @param employee
     */
    /*private void generateUserNameandEmailId(EmployeeRequest employee) {
        String fName = employee.getFirstName();
        String lName = employee.getLastName();
        String uName;
        if (lName.length() > 7) {
            uName = fName.charAt(0) + lName.substring(0, 7);
        } else {
            uName = fName.charAt(0) + lName.substring(0, lName.length());
        }

        employee.setUserName(uName.toLowerCase().trim());
        employee.setEmailId(uName.toLowerCase().trim() + "@teksystems.com");
    }
     */
 /*public void automaticAllowLeaves() {
        try {
            transaction = session.beginTransaction();

            //Add new Employee object
            LeaveApplication leaves = new LeaveApplication();
            leaves.set
            //Save the employee in database
            session.save(emp);

            //Commit the transaction
            session.getTransaction().commit();
            HibernateUtil.shutdown();
            session.save(employee);
            transaction.commit();
            return "Success";
        } catch (HibernateException ex) {
            transaction.rollback();
            logger.error("Exception :" + ex);
        } finally {
            session.close();
        }
        return null;

    }*/
    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }
}
