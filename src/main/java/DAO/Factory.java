package DAO;

import DAO.Impl.ContractorDAOImpl;
import DAO.Impl.EmployeeDAOImpl;
import DAO.Impl.ProductDAOImpl;
import DAO.Impl.ProductOnStorageDAOImpl;


/**
 * Created by Michael R. on 26.09.2015.
 * Feel free to contact me via misharj1993@gmail.com
 */

public class Factory {
    private static ContractorDAO contractorDAO = null;
    private static EmployeeDAO employeeDAO = null;
    private static ProductDAO productDAO = null;
    private static ProductOnStorageDAO productOnStorageDAO = null;
    private static Factory instance = null;

    public static synchronized Factory getInstance() {
        if (instance == null) {
            instance = new Factory();
        }
        return instance;
    }

    public ContractorDAO getContractorDAO() {
        if (contractorDAO == null) {
            contractorDAO = new ContractorDAOImpl();
        }
        return contractorDAO;
    }

    public EmployeeDAO getEmployeeDAO() {
        if (employeeDAO == null) {
            employeeDAO = new EmployeeDAOImpl();
        }
        return employeeDAO;
    }

    public ProductDAO getProductDAO() {
        if (productDAO == null) {
            productDAO = new ProductDAOImpl();
        }
        return productDAO;
    }

    public ProductOnStorageDAO getProductOnStorageDAO(){
        if(productOnStorageDAO == null){
            productOnStorageDAO = new ProductOnStorageDAOImpl();
        }
    return productOnStorageDAO;
    }

}
