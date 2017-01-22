/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package in.tekathon.service;

import in.tekathon.connection.HibernateUtil;
import in.tekathon.model.Employee;
import in.tekathon.query.QueryManager;
import java.util.List;
import javax.xml.bind.JAXBException;
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
    public List<Employee> getAllEmployees() {

        try {
            transaction = session.beginTransaction();
            String sql = queryManager.getQuery("EmployeeController", "getAllEmployees");
            Query query = session.createQuery(sql);
            List<Employee> employeeList = query.list();

            transaction.commit();
            return employeeList;
        } catch (HibernateException ex) {
            transaction.rollback();
            logger.error("Exception :" + ex);
        } catch (JAXBException ex) {
            logger.error("Exception :" + ex);
        } finally {
            session.close();
        }
        return null;
    }

    @Override
    public Employee getEmployeeById(int employeeId) {
        try {
            if (employeeId <= 0) {
                return new Employee();
            }
            transaction = session.beginTransaction();
            String sql = queryManager.getQuery("EmployeeController", "getEmployeeById");
            Query query = session.createQuery(sql);
            query.setParameter("employeeid", employeeId);
            System.out.println("" + employeeId);
            Employee employee = (Employee) query.uniqueResult();

            transaction.commit();
            return employee;
        } catch (HibernateException ex) {
            transaction.rollback();
            logger.error("Exception :" + ex);
        } catch (JAXBException ex) {
            logger.error("Exception :" + ex);
        } finally {
            session.close();
        }
        return null;
    }

    @Override
    public String insertEmployee(Employee employee) {
        try {
            transaction = session.beginTransaction();
            generateUserNameandEmailId(employee);
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
    }

    @Override
    public int updateEmployee(int id, Employee emp) {
        try {

            transaction = session.beginTransaction();
            String sql = queryManager.getQuery("EmployeeController", "updateEmployee");
            Query query = session.createQuery(sql);
            query.setParameter("employeeid", emp.getEmployeeId());
            query.setParameter("firstName", emp.getFirstName());
            query.setParameter("lastName", emp.getLastName());
            query.setParameter("userName", emp.getUserName());
            query.setParameter("password", emp.getPassword());
            query.setParameter("street", emp.getStreet());
            query.setParameter("city", emp.getCity());
            query.setParameter("state", emp.getState());
            query.setParameter("pinCode", emp.getPincode());
            query.setParameter("country", emp.getCountry());
            query.setParameter("emailId", emp.getEmailId());
            query.setParameter("contactNo", emp.getContactNo());
            query.setParameter("dateOfBirth", emp.getDateOfBirth());
            query.setParameter("designation", emp.getDesignation());
            query.setParameter("dateOfJoining", emp.getDateOfJoining());
            query.setParameter("yearsOfExperience", emp.getYearsOfExperience());
            query.setParameter("reportingManager_Id", emp.getReportingManagerId());
            int rowCount = query.executeUpdate();

            transaction.commit();
            return rowCount;
        } catch (HibernateException ex) {
            transaction.rollback();
            logger.error("Exception :" + ex);
        } catch (JAXBException ex) {
            logger.error("Exception :" + ex);
        } finally {
            session.close();
        }

//        String hql = "update Employee set name = :name, age=:age where id = :id";
//        Query query = session.createQuery(updateEmployee);
//        query.setInteger("id", id);
//        query.setString("name", emp.getName());
//        query.setInteger("age", emp.getAge());
//        int rowCount = query.executeUpdate();
//        
        return 0;
    }

    @Override
    public int deleteEmployee(int employeeId) {
        try {
            transaction = session.beginTransaction();
            /*String sql = queryManager.getQuery("EmployeeController", "deleteEmployeeById");
            Query query = session.createQuery(sql);
            query.setParameter("employeeid", 2062);
            int rowCount = query.executeUpdate();
            System.out.println("Rows affected: " + rowCount);*/

            Employee employee = (Employee) session.get(Employee.class, employeeId);
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
    private void generateUserNameandEmailId(Employee employee) {
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

}
