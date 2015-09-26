package DAO;

import logic.Employee;

import java.util.List;

/**
 * Created by Michael R. on 26.09.2015.
 * Feel free to contact me via misharj1993@gmail.com
 */

public interface EmployeeDAO {
    public void AddEmployee(Employee employee);

    public void updateEmployee(Employee employee);

    public Employee getEmployeeById(int id);

    public List getAllEmployees();

    public void deleteEmployee(Employee employee);
}
