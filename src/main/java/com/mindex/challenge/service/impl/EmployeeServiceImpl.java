package com.mindex.challenge.service.impl;

import com.mindex.challenge.dao.EmployeeRepository;
import com.mindex.challenge.data.Employee;
import com.mindex.challenge.data.ReportingStructure;
import com.mindex.challenge.service.EmployeeService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private static final Logger LOG = LoggerFactory.getLogger(EmployeeServiceImpl.class);

    @Autowired
    private EmployeeRepository employeeRepository;


    @Override
    public Employee create(Employee employee) {
        LOG.debug("Creating employee [{}]", employee);

        employee.setEmployeeId(UUID.randomUUID().toString());
        employeeRepository.insert(employee);

        return employee;
    }

    @Override
    public Employee read(String id) {
        LOG.debug("Creating employee with id [{}]", id);

        Employee employee = employeeRepository.findByEmployeeId(id);

        if (employee == null) {
            throw new RuntimeException("Invalid employeeId: " + id);
        }

        return employee;
    }

    @Override
    public Employee update(Employee employee) {
        LOG.debug("Updating employee [{}]", employee);

        return employeeRepository.save(employee);
    }
    @Override
    public ReportingStructure getReport(String id){
        Employee employee = employeeRepository.findByEmployeeId(id);
        if( employee != null){
            int count = findReporter(id);
            ReportingStructure reportingStructure = new ReportingStructure(id,count);
            return reportingStructure;
        }
        return null;
    }
    public int findReporter(String id){
        Queue<String> q = new LinkedList<>();
        q.add(id);
        int count = 0;
        Set<String> set = new HashSet<>();
        set.add(id);
        while(!q.isEmpty()){
            String cur = q.poll();
            Employee e = employeeRepository.findByEmployeeId(cur);
            if(e != null && e.getDirectReports() != null){
                for(Employee emp : e.getDirectReports()){
                    String emp_id = emp.getEmployeeId();
                    if(!set.contains(emp_id)){
                        set.add(emp_id);
                        q.add(emp_id);
                        count++;
                    }
                }
            }
        }
        return count;
    }

}
