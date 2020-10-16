package com.mindex.challenge.data;

public class Compensation {
    private String employeeId;
    private int salary;
    private String effectiveDate;

    public Compensation(){}

    public Compensation(String employeeId, int salary, String effectiveDate){
        this.employeeId = employeeId;
        this.salary = salary;
        this.effectiveDate = effectiveDate;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeId(){
        return employeeId;
    }

    public void setSalary(int salary){
        this.salary = salary;
    }

    public int getSalary(){
        return salary;
    }

    public String getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(String effectiveDate) {
        this.effectiveDate = effectiveDate;
    }
}
