package dev.evanishyn.entities;

import dev.evanishyn.utilities.Status;
import dev.evanishyn.utilities.Category;

public class Expense {

    private int id;
    private int employeeId;  //admin1
    private double amount;
    private String description;
    private Category category;  //expense.getType().name()   (.name == toString() for enums)
    private Status status;

    public Expense(int id, int employeeId, double amount, String description, Category category, Status status) {
        this.id = id;
        this.employeeId = employeeId;
        this.amount = amount;
        this.description = description;
        this.category = category;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEmployee() {
        return employeeId;
    }

    public void setEmployee(Employee employee) {
        this.employeeId = employeeId;
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

    public Category getType() {
        return category;
    }

    public void setType(Category category) {
        this.category = category;
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
                ", employee=" + employeeId +
                ", amount=" + amount +
                ", description='" + description + '\'' +
                ", type=" + category +
                ", status=" + status +
                '}';
    }
}
