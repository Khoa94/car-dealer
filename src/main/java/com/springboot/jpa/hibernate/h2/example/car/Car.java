package com.springboot.jpa.hibernate.h2.example.car;


import com.springboot.jpa.hibernate.h2.example.dealerCar.CarDealer;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//@Data
@Entity
//@Table(name = "car")
//@SecondaryTable(name = "dealer_car", pkJoinColumns = @PrimaryKeyJoinColumn(name = "carId", referencedColumnName = "id"))
public class Car {
    @Id
    @SequenceGenerator(name = "car_id_generator", sequenceName = "car_id_seq")
    @GeneratedValue(generator = "car_id_generator")
    private Integer id;
    private String make;
    private String name;
    private String color;
    @OneToMany(mappedBy = "dealer", cascade = CascadeType.ALL)
    private Set<CarDealer> carDealers;

    public Car() {super();}

    public Car(String make, String name, String color){
        super();
        this.make = make;
        this.name = name;
        this.color = color;
        carDealers = new HashSet<>();
    }

//    public Car(Integer id, CarDealer... carDealers) {
//        this.id = id;
//        for (CarDealer carDealer : carDealers)
//            carDealer.setCar(this);
//        this.carDealers = Stream.of(carDealers).collect(Collectors.toSet());
//    }

    public void addCarDealer(CarDealer carDealer){
        carDealer.setCar(this);
        this.carDealers.add(carDealer);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    @Override
    public String toString() {
        return String.format("car [id=%s, make=%s, name=%s, color=%s]", id, make, name, color);
    }
}
