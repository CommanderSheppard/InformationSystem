package DAO.Impl;

import DAO.ContractorDAO;
import logic.Contractor;
import org.hibernate.Session;
import util.HibernateUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Michael R. on 26.09.2015.
 * Feel free to contact me via misharj1993@gmail.com
 */

public class ContractorDAOImpl implements ContractorDAO{
    public void AddContractor(Contractor contractor)  {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(contractor);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public void updateContractor(Contractor contractor)  {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(contractor);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public Contractor getContractorById(int id)  {
        Session session = null;
        Contractor contractor = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            contractor = (Contractor) session.load(Contractor.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return contractor;
    }

    public List getAllContractors()  {
        Session session = null;
        List<Contractor> contractors = new ArrayList<Contractor>();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            contractors = session.createCriteria(Contractor.class).list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return contractors;
    }

    public void deleteContractor(Contractor contractor)  {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(contractor);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }
}
