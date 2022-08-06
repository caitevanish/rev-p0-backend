package dev.evanishyn.entities;

public class Employee{

    private int emp_id;
    private String fName;
    private String lName;


    public Employee(int emp_id, String fName, String lName) {
        this.emp_id = emp_id;
        this.fName = fName;
        this.lName = lName;

    }

    public Employee() {

    }

    public int getEmp_id() {
        return emp_id;
    }

    public void setEmp_id(int emp_id) {
        this.emp_id = emp_id;
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
                "emp_id=" + emp_id +
                ", fName='" + fName + '\'' +
                ", lName='" + lName + '\'' +
                '}';
    }
}

