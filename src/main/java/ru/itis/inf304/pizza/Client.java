package ru.itis.inf304.pizza;

public class Client extends Person {

    protected Discount discount;
    public Client(String name, Gender gender, Discount discount){
        this.gender = gender;
        this.name = name;
        this.discount = discount;
    }
}
