package DAO.Impl;

import DAO.ProductOnStorageDAO;
import logic.ProductOnStorage;
import org.hibernate.Session;
import util.HibernateUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Michael R. on 26.09.2015.
 * Feel free to contact me via misharj1993@gmail.com
 */

public class ProductOnStorageDAOImpl implements ProductOnStorageDAO {
    public void AddProductToStorage(ProductOnStorage product) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.save(product);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public void updateProductOnStorage(ProductOnStorage product) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.update(product);
            session.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
    }

    public ProductOnStorage getProductById(int id) {
        Session session = null;
        ProductOnStorage product = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            product = (ProductOnStorage) session.load(ProductOnStorage.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return product;
    }

    public List getAllProducts() {
        Session session = null;
        List<ProductOnStorage> products = new ArrayList<ProductOnStorage>();
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            products = session.createCriteria(ProductOnStorage.class).list();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (session != null && session.isOpen()) {
                session.close();
            }
        }
        return products;
    }

    public void deleteProductFromStorage(ProductOnStorage product) {
        Session session = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            session.beginTransaction();
            session.delete(product);
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
