package com.oracle.pagingtest.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class Employee {
    @Id
    private long EmployeeId;
    private String FirstName;
    private String LastName;
    private Long Revenue;
    private Long TargetComplete;
    private Long TargetIncomplete;
    private Long DepartmentId;
    public long getEmployeeId() {
        return EmployeeId;
    }
    public void setEmployeeId(long employeeId) {
        EmployeeId = employeeId;
    }
    public String getFirstName() {
        return FirstName;
    }
    public void setFirstName(String firstName) {
        FirstName = firstName;
    }
    public String getLastName() {
        return LastName;
    }
    public void setLastName(String lastName) {
        LastName = lastName;
    }
    public Long getRevenue() {
        return Revenue;
    }
    public void setRevenue(Long revenue) {
        Revenue = revenue;
    }
    public Long getTargetComplete() {
        return TargetComplete;
    }
    public void setTargetComplete(Long targetComplete) {
        TargetComplete = targetComplete;
    }
    public Long getTargetIncomplete() {
        return TargetIncomplete;
    }
    public void setTargetIncomplete(Long targetIncomplete) {
        TargetIncomplete = targetIncomplete;
    }
    public Long getDepartmentId() {
        return DepartmentId;
    }
    public void setDepartmentId(Long departmentId) {
        DepartmentId = departmentId;
    }
    
}
