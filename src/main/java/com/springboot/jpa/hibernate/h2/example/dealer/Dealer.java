package com.springboot.jpa.hibernate.h2.example.dealer;

import com.springboot.jpa.hibernate.h2.example.dealerCar.CarDealer;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

//@Data
@Entity
//@Table(name = "dealer")
//@SecondaryTable(name = "dealer_car", pkJoinColumns = @PrimaryKeyJoinColumn(name = "dealerId", referencedColumnName = "id"))
public class Dealer {
    @Id
    @SequenceGenerator(name = "dealer_id_generator", sequenceName = "dealer_id_seq")
    @GeneratedValue(generator = "dealer_id_generator")
    private Integer id;
    private String name;
    @OneToMany(mappedBy = "dealer", cascade = CascadeType.ALL)
    private Set<CarDealer> carDealers = new HashSet<>();

    public Dealer() {
        super();
    }

    public Dealer(String name) {
        super();
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return String.format("Dealer [id=%s, name=%s]", id, name);
    }
}
