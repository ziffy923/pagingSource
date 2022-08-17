package com.oracle.pagingtest.RestHolders;

import java.util.List;

import com.oracle.pagingtest.model.Employee;

public class EmployeePage {
    private Boolean hasMore;
    private List<Employee> items;
    public Boolean getHasMore() {
        return hasMore;
    }
    public void setHasMore(Boolean hasMore) {
        this.hasMore = hasMore;
    }
    public EmployeePage() {
    }
    public List<Employee> getItems() {
        return items;
    }
    public EmployeePage(Boolean hasMore, List<Employee> items) {
        this.hasMore = hasMore;
        this.items = items;
    }
    public void setItems(List<Employee> items) {
        this.items = items;
    }   
    
}
