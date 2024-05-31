package com.mirea.kt.ribo.homework_110;

public class Car {
    private String brand;
    private String number;
    private int year;

    public Car(String brand, String number, int year) {
        this.brand = brand;
        this.number = number;
        this.year = year;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
}
