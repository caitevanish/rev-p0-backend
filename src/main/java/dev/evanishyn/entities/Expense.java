package dev.evanishyn.entities;

public class Expense {

    private int id;
    private Employee employee;  //admin1
    private double amount;
    private String description;
    private Type type;  //expense.getType().name()   (.name == toString() for enums)
    private Status status;


}
