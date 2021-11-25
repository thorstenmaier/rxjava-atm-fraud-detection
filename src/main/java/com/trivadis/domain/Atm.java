package com.trivadis.domain;

public class Atm {
    private City city;


    public Atm(City city) {
        this.city = city;
    }

    public City getCity() {
        return city;
    }

    @Override
    public String toString() {
        return "Atm{" +
                "city=" + city +
                '}';
    }
}
