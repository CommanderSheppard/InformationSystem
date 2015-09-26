package logic;

/**
 * Created by Michael R. on 26.09.2015.
 * Feel free to contact me via misharj1993@gmail.com
 */

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Entity
@Table(name = "Employee")
public class Employee {

    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id")
    private int id;

    @Column(name = "salary")
    private double salary;

    @Column(name = "expenses")
    private double expenses;

    @Column(name = "costPrice")
    private double costPrice;

    @Column(name = "frightCosts")
    private double frightCosts;

    @Column(name = "salarySheet")
    private String salarySheet;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public double getExpenses() {
        return expenses;
    }

    public void setExpenses(double expenses) {
        this.expenses = expenses;
    }

    public double getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(double costPrice) {
        this.costPrice = costPrice;
    }

    public double getFrightCosts() {
        return frightCosts;
    }

    public void setFrightCosts(double frightCosts) {
        this.frightCosts = frightCosts;
    }

    public String getSalarySheet() {
        return salarySheet;
    }

    public void setSalarySheet(String salarySheet) {
        this.salarySheet = salarySheet;
    }
}
