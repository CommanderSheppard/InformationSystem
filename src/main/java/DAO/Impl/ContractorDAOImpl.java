package DAO.Impl;

import DAO.ContractorDAO;
import logic.Contractor;
import util.HibernateUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Michael R. on 26.09.2015.
 * Feel free to contact me via misharj1993@gmail.com
 */

public class ContractorDAOImpl implements ContractorDAO {
    public void AddContractor(Contractor contractor) {
        EntityTransaction transaction = null;
        EntityManager manager = null;
        try {
            manager = HibernateUtil.getEM();
            transaction = manager.getTransaction();
            transaction.begin();
            manager.persist(contractor);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (manager != null && manager.isOpen()) {
                manager.close();
            }
        }
    }

    public void updateContractor(Contractor contractor) {
        EntityTransaction transaction = null;
        EntityManager manager = null;

        try {
            manager = HibernateUtil.getEM();
            transaction.begin();
            manager.merge(contractor);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (manager != null && manager.isOpen()) {
                manager.close();
            }
        }
    }

    public Contractor getContractorById(int id) {
        EntityManager manager = null;
        Contractor contractor = null;
        try {
            manager = HibernateUtil.getEM();
            contractor = (Contractor) manager.find(Contractor.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (manager != null && manager.isOpen()) {
                manager.close();
            }
        }
        return contractor;
    }

    public List getAllContractors() {
        EntityManager manager = null;
        List<Contractor> contractors = new ArrayList<Contractor>();
        try {
            manager = HibernateUtil.getEM();
            contractors = manager.createQuery("select a from Contractor a", Contractor.class).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (manager != null && manager.isOpen()) {
                manager.close();
            }
        }
        return contractors;
    }

    public void deleteContractor(Contractor contractor) {
        EntityTransaction transaction = null;
        EntityManager manager = null;
        try {
            manager = HibernateUtil.getEM();
            transaction.begin();
            manager.remove(contractor);
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
