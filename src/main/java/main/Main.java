package main;

import DAO.Factory;
import logic.Contractor;
import util.HibernateUtil;

import javax.persistence.EntityManager;
import java.util.List;

/**
 * Created by Michael R. on 26.09.2015.
 * Feel free to contact me via misharj1993@gmail.com
 */

public class Main {

    public static void main(String[] args) {
        Contractor smbdy = new Contractor();
        smbdy.setContractor("sdfsdfd123123");
        smbdy.setOverheads(452d);

        Factory.getInstance().getContractorDAO().AddContractor(smbdy);

        List<Contractor> contractors = Factory.getInstance().getContractorDAO().getAllContractors();
        for (int i = 0; i <contractors.size() ; i++) {
            System.out.println(contractors.get(i).getContractor());
        }
    }


}
