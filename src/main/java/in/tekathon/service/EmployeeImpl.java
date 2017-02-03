/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.tekathon.service;

import in.tekathon.connection.HibernateUtil;
import in.tekathon.model.EmployeeRequest;
import in.tekathon.model.EmployeeResponse;
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

    Transaction transaction = null;

    @Override
    public List<EmployeeResponse> getAllEmployees() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
//            String sql = queryManager.getQuery("EmployeeController", "getAllEmployees");
            String findAll = "FROM EmployeeResponse";
            Query query = session.createQuery(findAll, EmployeeResponse.class);
            List<EmployeeResponse> employeeList = query.getResultList();
            for (int i = 0; i < employeeList.size(); i++) {
                EmployeeResponse employee = employeeList.get(i);
                System.out.println("Enter" + employee.getEmployeeId());
            }

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
    public EmployeeResponse getEmployeeById(int employeeId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            String findByEmployeeid = "SELECT e FROM EmployeeResponse e WHERE employeeId = :employeeId";
            Query query = session.createQuery(findByEmployeeid, EmployeeResponse.class);
            query.setParameter("employeeId", employeeId);
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
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
//            String insertEmployee = "CALL CREATEUSER(:firstName, :lastName, :street, :city, :state, :pincode, :country, :contactNo, :dateOfBirth, :designation, :dateOfJoining, :yearsOfExperience, :reportingManagerId)";
            Query query = session.getNamedQuery("createEmployeeProcedure");
            query.setParameter("employeeId", employee.getEmployeeId());
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
            query.setParameter("reportingManagerName", employee.getReportingManagerName());
            query.setParameter("companyName", employee.getCompanyName());
            query.setParameter("deviceId", employee.getDeviceId());
            int executeUpdate = query.executeUpdate();

            transaction.commit();
            return executeUpdate;
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
    public EmployeeResponse updateEmployee(int employeeId, EmployeeRequest employee) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {

            transaction = session.beginTransaction();

            EmployeeResponse employeeResponse = (EmployeeResponse) session.get(EmployeeResponse.class, employeeId);

            employeeResponse.setFirstName(employee.getFirstName() == null ? employeeResponse.getFirstName() : employee.getFirstName());
            employeeResponse.setLastName(employee.getLastName() == null ? employeeResponse.getLastName() : employee.getLastName());
            employeeResponse.setPassword(employee.getPassword() == null ? employeeResponse.getPassword() : employee.getPassword());
            employeeResponse.setStreet(employee.getStreet() == null ? employeeResponse.getStreet() : employee.getStreet());
            employeeResponse.setCity(employee.getCity() == null ? employeeResponse.getCity() : employee.getCity());
            employeeResponse.setState(employee.getState() == null ? employeeResponse.getState() : employee.getState());
            employeeResponse.setPincode(employee.getPincode() == null ? employeeResponse.getPincode() : employee.getPincode());
            employeeResponse.setCountry(employee.getCountry() == null ? employeeResponse.getCountry() : employee.getCountry());
            employeeResponse.setContactNo(employee.getContactNo() == null ? employeeResponse.getContactNo() : employee.getContactNo());
            employeeResponse.setDateOfBirth(employee.getDateOfBirth() == null ? employeeResponse.getDateOfBirth() : employee.getDateOfBirth());
            employeeResponse.setDesignation(employee.getDesignation() == null ? employeeResponse.getDesignation() : employee.getDesignation());
            employeeResponse.setDateOfJoining(employee.getDateOfJoining() == null ? employeeResponse.getDateOfJoining() : employee.getDateOfJoining());
            employeeResponse.setYearsOfExperience(employee.getYearsOfExperience() == 0 ? employeeResponse.getYearsOfExperience() : employee.getYearsOfExperience());
            employeeResponse.setReportingManagerId(employee.getReportingManagerId() == 0 ? employeeResponse.getReportingManagerId() : employee.getReportingManagerId());
            employeeResponse.setCompanyName(employee.getCompanyName() == null ? employeeResponse.getCompanyName() : employee.getCompanyName());
            employeeResponse.setDeviceId(employee.getDeviceId() == null ? employeeResponse.getDeviceId() : employee.getDeviceId());

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
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();

            EmployeeResponse employee = (EmployeeResponse) session.get(EmployeeResponse.class, employeeId);
            if (employee == null) {
                return 0;
            } else {
                session.delete(employee);
            }
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
    @Override
    public List<EmployeeResponse> getChildEmployeeById(int employeeId) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        try {
            transaction = session.beginTransaction();
            String findByEmployeeid = "SELECT e FROM EmployeeResponse e WHERE reportingManager_Id = :reportingManagerId";
            Query query = session.createQuery(findByEmployeeid, EmployeeResponse.class);
            query.setParameter("reportingManagerId", employeeId);

            List<EmployeeResponse> employeeList = query.list();
//            EmployeeResponse employee = (EmployeeResponse) query.uniqueResult();
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

}
