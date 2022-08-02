package dev.evanishyn.entities;

import dev.evanishyn.utilities.Status;
import dev.evanishyn.utilities.Type;

public class Expense {

    private int id;
    private Employee employee;  //admin1
    private double amount;
    private String description;
    private Type type;  //expense.getType().name()   (.name == toString() for enums)
    private Status status;

    public Expense(int id, Employee employee, double amount, String description, Type type, Status status) {
        this.id = id;
        this.employee = employee;
        this.amount = amount;
        this.description = description;
        this.type = type;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Expense{" +
                "id=" + id +
                ", employee=" + employee +
                ", amount=" + amount +
                ", description='" + description + '\'' +
                ", type=" + type +
                ", status=" + status +
                '}';
    }
}
