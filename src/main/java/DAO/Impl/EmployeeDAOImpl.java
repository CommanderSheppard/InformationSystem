package DAO.Impl;

import DAO.EmployeeDAO;
import logic.Employee;
import util.HibernateUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Michael R. on 26.09.2015.
 * Feel free to contact me via misharj1993@gmail.com
 */

public class EmployeeDAOImpl implements EmployeeDAO {
    public void AddEmployee(Employee employee) {
        EntityTransaction transaction;
        EntityManager manager = null;
        try {
            manager = HibernateUtil.getEM();
            transaction = manager.getTransaction();
            transaction.begin();
            manager.persist(employee);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (manager != null && manager.isOpen()) {
                manager.close();
            }
        }
    }

    public void updateEmployee(Employee employee) {
        EntityTransaction transaction;
        EntityManager manager = null;

        try {
            manager = HibernateUtil.getEM();
            transaction = manager.getTransaction();
            transaction.begin();
            manager.merge(employee);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (manager != null && manager.isOpen()) {
                manager.close();
            }
        }
    }

    public Employee getEmployeeById(int id) {
        EntityManager manager = null;
        Employee employee = null;
        try {
            manager = HibernateUtil.getEM();
            employee = manager.find(Employee.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (manager != null && manager.isOpen()) {
                manager.close();
            }
        }
        return employee;
    }

    public List getAllEmployees() {
        EntityManager manager = null;
        List<Employee> employees = new ArrayList<>();
        try {
            manager = HibernateUtil.getEM();
            employees = manager.createQuery("select a from Employee a", Employee.class).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (manager != null && manager.isOpen()) {
                manager.close();
            }
        }
        return employees;
    }

    public void deleteEmployee(Employee employee) {
        EntityTransaction transaction;
        EntityManager manager = null;
        try {
            manager = HibernateUtil.getEM();
            transaction = manager.getTransaction();
            transaction.begin();
            if (manager.contains(employee)){
                manager.remove(employee);
            }else{
                manager.remove(manager.merge(employee));
            }
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (manager != null && manager.isOpen()) {
                manager.close();
            }
        }
    }
}
