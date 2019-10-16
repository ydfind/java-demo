package com.ydfind.flow;

import com.ydfind.model.Employee;

import java.util.ArrayList;
import java.util.List;

/**
 * 生成employee的测试list
 */
public class EmployeeHelper {

    public static List<Employee> getEmps() {

        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee(1, "Pan"));
        employeeList.add(new Employee(2, "David"));
        employeeList.add(new Employee(3, "Lisa"));
        employeeList.add(new Employee(4, "Ram"));
        employeeList.add(new Employee(5, "Anu"));

        return employeeList;
    }

}
