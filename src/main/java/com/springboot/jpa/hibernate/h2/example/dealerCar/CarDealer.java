package com.springboot.jpa.hibernate.h2.example.dealerCar;

import com.springboot.jpa.hibernate.h2.example.car.Car;
import com.springboot.jpa.hibernate.h2.example.dealer.Dealer;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Objects;

@Getter
@Setter
@NoArgsConstructor

@Entity
public class CarDealer implements Serializable {
    @Id
    @ManyToOne
    @JoinColumn
    private Car car;

    @Id
    @ManyToOne
    @JoinColumn
    private Dealer dealer;

    private Integer availableCount;
    private Integer requestCount;

    public CarDealer(Dealer dealer){
        this.dealer = dealer;
        this.availableCount = 0;
        this.requestCount = 0;
    }

    public CarDealer(Dealer dealer, Integer availableCount, Integer requestCount){
        this.dealer = dealer;
        this.availableCount = availableCount;
        this.requestCount = requestCount;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public Dealer getDealer() {
        return dealer;
    }

    public void setDealer(Dealer dealer) {
        this.dealer = dealer;
    }

    public Integer getAvailableCount() {
        return availableCount;
    }

    public void setAvailableCount(Integer availableCount) {
        this.availableCount = availableCount;
    }

    public Integer getRequestCount() {
        return requestCount;
    }

    public void setRequestCount(Integer requestCount) {
        this.requestCount = requestCount;
    }

    @Override
    public boolean equals(Object o){
        if (this == o) return  true;
        if (!(o instanceof CarDealer)) return false;
        CarDealer that = (CarDealer) o;
        return Objects.equals(car.getId(), that.car.getId()) &&
                Objects.equals(dealer.getId(), that.dealer.getId());
    }

    @Override
    public int hashCode(){
        return Objects.hash(car.getId(), dealer.getId());
    }
}
