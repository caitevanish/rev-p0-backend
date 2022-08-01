package dev.evanishyn.entities;

public class Employee{

    private int id;
    private String fName;
    private String lName;


    public Employee(int id, String fName, String lName, String email, String password, String phoneNumber, int accountBalance) {
        this.id = id;
        this.fName = fName;
        this.lName = lName;

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getfName() {
        return fName;
    }

    public void setfName(String fName) {
        this.fName = fName;
    }

    public String getlName() {
        return lName;
    }

    public void setlName(String lName) {
        this.lName = lName;
    }



    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", fName='" + fName + '\'' +
                ", lName='" + lName + '\'' +
                '}';
    }
}

