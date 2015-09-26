package DAO;


import logic.Contractor;

import java.util.List;

/**
 * Created by Michael R. on 26.09.2015.
 * Feel free to contact me via misharj1993@gmail.com
 */

public interface ContractorDAO {
    public void AddContractor(Contractor contractor);

    public void updateContractor(Contractor contractor);

    public Contractor getContractorById(int id);

    public List getAllContractors();

    public void deleteContractor(Contractor contractor);
}
