package DAO.Impl;

import DAO.ProductDAO;
import logic.Product;
import util.HibernateUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Michael R. on 26.09.2015.
 * Feel free to contact me via misharj1993@gmail.com
 */

public class ProductDAOImpl implements ProductDAO {
    public void AddProduct(Product product) {
        EntityTransaction transaction = null;
        EntityManager manager = null;
        try {
            manager = HibernateUtil.getEM();
            transaction = manager.getTransaction();
            transaction.begin();
            manager.persist(product);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (manager != null && manager.isOpen()) {
                manager.close();
            }
        }
    }

    public void updateProduct(Product product) {
        EntityTransaction transaction = null;
        EntityManager manager = null;

        try {
            manager = HibernateUtil.getEM();
            transaction.begin();
            manager.merge(product);
            transaction.commit();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (manager != null && manager.isOpen()) {
                manager.close();
            }
        }
    }

    public Product getProductById(int id) {
        EntityManager manager = null;
        Product product = null;
        try {
            manager = HibernateUtil.getEM();
            product = (Product) manager.find(Product.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (manager != null && manager.isOpen()) {
                manager.close();
            }
        }
        return product;
    }

    public List getAllProducts() {
        EntityManager manager = null;
        List<Product> products = new ArrayList<Product>();
        try {
            manager = HibernateUtil.getEM();
            products = manager.createQuery("select a from Product a", Product.class).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (manager != null && manager.isOpen()) {
                manager.close();
            }
        }
        return products;
    }

    public void deleteProduct(Product product) {
        EntityTransaction transaction = null;
        EntityManager manager = null;
        try {
            manager = HibernateUtil.getEM();
            transaction.begin();
            manager.remove(product);
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
