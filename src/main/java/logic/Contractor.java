package logic;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

/**
 * Created by Michael R. on 26.09.2015.
 * Feel free to contact me via misharj1993@gmail.com
 */

@Entity
@Table(name = "Contractor")
public class Contractor {
    @Id
    @GeneratedValue(generator = "increment")
    @GenericGenerator(name = "increment", strategy = "increment")
    @Column(name = "id")
    private int id;
    @Column(name = "contractor")
    private String contractor; //should be other type?
    @Column(name = "overheads")
    private double overheads;   //should be what?

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getContractor() {
        return contractor;
    }

    public void setContractor(String contractor) {
        this.contractor = contractor;
    }

    public double getOverheads() {
        return overheads;
    }

    public void setOverheads(double overheads) {
        this.overheads = overheads;
    }
}
