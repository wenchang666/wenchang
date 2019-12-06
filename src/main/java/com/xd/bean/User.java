package com.xd.bean;

/**
 * @author wc
 * @create 2019-12-03-9:53
 */
public class User {
    private  String name;
    private  Integer age;
    private Car car;

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", car=" + car +
                '}';
    }

    public User() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public User(String name, Integer age, Car car) {
        this.name = name;
        this.age = age;
        this.car = car;
    }
}
