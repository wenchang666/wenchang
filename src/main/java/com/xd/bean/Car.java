package com.xd.bean;

/**
 * @author wc
 * @create 2019-12-03-9:54
 */
public class Car {
    private String carname;
    private  String color;

    @Override
    public String toString() {
        return "Car{" +
                "carname='" + carname + '\'' +
                ", color='" + color + '\'' +
                '}';
    }

    public String getCarname() {
        return carname;
    }

    public void setCarname(String carname) {
        this.carname = carname;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
