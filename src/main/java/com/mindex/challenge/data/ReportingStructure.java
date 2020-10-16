package com.mindex.challenge.data;

public class ReportingStructure {
    private String employeeId;
    private int numberOfReports;

    public ReportingStructure(){}

    public ReportingStructure(String employeeId, int numberOfReports){
        this.employeeId = employeeId;
        this.numberOfReports = numberOfReports;
    }
    public void setEmployeeId(String employeeId){
        this.employeeId = employeeId;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setNumberOfReports(int numberOfReports) {
        this.numberOfReports = numberOfReports;
    }

    public int getNumberOfReports() {
        return numberOfReports;
    }
}
