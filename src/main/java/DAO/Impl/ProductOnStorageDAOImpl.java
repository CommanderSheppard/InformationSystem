package DAO.Impl;

import DAO.ProductOnStorageDAO;
import logic.ProductOnStorage;
import util.HibernateUtil;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Michael R. on 26.09.2015.
 * Feel free to contact me via misharj1993@gmail.com
 */

public class ProductOnStorageDAOImpl implements ProductOnStorageDAO {
    public void AddProductToStorage(ProductOnStorage product) {
        EntityTransaction transaction;
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

    public void updateProductOnStorage(ProductOnStorage product) {
        EntityTransaction transaction;
        EntityManager manager = null;

        try {
            manager = HibernateUtil.getEM();
            transaction = manager.getTransaction();
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

    public ProductOnStorage getProductById(int id) {
        EntityManager manager = null;
        ProductOnStorage productOnStorage = null;
        try {
            manager = HibernateUtil.getEM();
            productOnStorage = manager.find(ProductOnStorage.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (manager != null && manager.isOpen()) {
                manager.close();
            }
        }
        return productOnStorage;
    }

    public List getAllProducts() {
        EntityManager manager = null;
        List<ProductOnStorage> productsOnStorage = new ArrayList<>();
        try {
            manager = HibernateUtil.getEM();
            productsOnStorage = manager.createQuery("select a from ProductOnStorage a", ProductOnStorage.class).getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (manager != null && manager.isOpen()) {
                manager.close();
            }
        }
        return productsOnStorage;
    }

    public void deleteProductFromStorage(ProductOnStorage product) {
        EntityTransaction transaction;
        EntityManager manager = null;
        try {
            manager = HibernateUtil.getEM();
            transaction = manager.getTransaction();
            transaction.begin();
            if (manager.contains(product)){
                manager.remove(product);
            }else{
                manager.remove(manager.merge(product));
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
