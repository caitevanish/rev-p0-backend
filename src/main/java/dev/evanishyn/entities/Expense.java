package dev.evanishyn.entities;

import dev.evanishyn.utilities.Status;
import dev.evanishyn.utilities.Category;

public class Expense {

    public Expense setStatus;
    private int exp_id;
    private int emp_Id;  //admin1
    private double amount;
    private String description;
    private Category category;  //expense.getType().name()   (.name == toString() for enums)
    private Status status;

    public Expense(int exp_id, int emp_Id, double amount, String description, Category category, Status status) {
        this.exp_id = exp_id;
        this.emp_Id = emp_Id;
        this.amount = amount;
        this.description = description;
        this.category = category;
        this.status = status;
    }

    public Expense() {

    }

    public int getExp_id() {
        return exp_id;
    }

    public void setExp_id(int exp_id) {
        this.exp_id = exp_id;
    }

    public int getEmployeeID() {
        return emp_Id;
    }

    public void setEmployeeID(int emp_Id) {
        this.emp_Id = emp_Id;
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

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
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
                "id=" + exp_id +
                ", emp_id=" + emp_Id +
                ", amount=" + amount +
                ", description='" + description + '\'' +
                ", type=" + category +
                ", status=" + status +
                '}';
    }
}
