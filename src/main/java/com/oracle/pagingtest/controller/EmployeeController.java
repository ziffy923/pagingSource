package com.oracle.pagingtest.controller;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.oracle.pagingtest.RestHolders.EmployeePage;
import com.oracle.pagingtest.model.Employee;
import com.oracle.pagingtest.repository.EmployeeRepository;

@RestController
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping
    public String getdata(){
        return "Hello";
    }

    @GetMapping("model/{id}")
    public Employee getEmployeeRecord(@PathVariable Long id){
        return employeeRepository.findById(id).get();
    }

    @DeleteMapping("model/{id}")
    public void deleteEmployeeRecord(@PathVariable long id){
        employeeRepository.deleteById(id);
    }

    @PostMapping("distance/{distance}")
    public Long getTransactionValue(@PathVariable long distance){
        return distance*30;
    }

    @GetMapping("page/{pageid}")
    public EmployeePage getPaginatedResult(@PathVariable int pageid){
        Pageable paging = PageRequest.of(pageid, 50);
        Page<Employee> result = employeeRepository.findAll(paging);
        
        EmployeePage employeePage = new EmployeePage();
        System.out.println(result.getSize());;
        employeePage.setHasMore(result.getNumberOfElements()> 0 ? true : false);
        employeePage.setItems(result.toList());

        return employeePage;
    }


    @PostMapping("test")
    public String doSomething() throws Exception{
        Path filePath = Paths.get("src/main/resources/static/sample.json");
        List<String> data = Files.readAllLines(filePath);

        StringBuilder builder = new StringBuilder();
        for(int i=0;i<data.size();i++){
            builder.append(data.get(i));
        }
        // System.out.println(builder.toString());
        JSONObject jsonObject = new JSONObject(builder.toString());
        System.out.println(jsonObject.toString());
        return "hello";
    }

    @PostMapping("postall")
    public Boolean postAll() throws Exception{

        Path filepath = Paths.get("src/main/resources/static/empdata.json");
        List<String> data = Files.readAllLines(filepath);

        StringBuilder builder = new StringBuilder();
        for(int i =0;i<data.size();i++){
            builder.append(data.get(i));
            
        }
        System.out.println(builder.toString());
        JSONObject jsonObject = new JSONObject(builder.toString());

        JSONArray  arr = jsonObject.getJSONArray("employees");

        for(int i=0;i<arr.length();i++){
            JSONObject temp = arr.getJSONObject(i);
            Employee tempEmployee = new Employee();
            tempEmployee.setDepartmentId(temp.getLong("DepartmentId"));
            tempEmployee.setEmployeeId(temp.getLong("EmployeeId") + 1500);
            tempEmployee.setFirstName(temp.getString("FirstName"));
            tempEmployee.setLastName(temp.getString("LastName"));
            tempEmployee.setRevenue(temp.getLong("Revenue"));
            tempEmployee.setTargetComplete(temp.getLong("TargetComplete"));
            tempEmployee.setTargetIncomplete(temp.getLong("TargetIncomplete"));
            employeeRepository.save(tempEmployee);
        }
        
        return true;
    } 
}