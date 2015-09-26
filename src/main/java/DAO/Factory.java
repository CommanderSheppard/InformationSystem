package DAO;

import logic.ProductOnStorage;

/**
 * Created by Michael R. on 26.09.2015.
 * Feel free to contact me via misharj1993@gmail.com
 */

public class Factory {
    private static ContractorDAO contractorDAO = null;
    private static EmployeeDAO employeeDAO = null;
    private static ProductDAO productDAO = null;
    private static ProductOnStorage productOnStorage = null;
    private static Factory instance = null;

    public static synchronized Factory getInstance() {
        if (instance == null){
            instance = new Factory();
        }
        return instance;
    }


}
