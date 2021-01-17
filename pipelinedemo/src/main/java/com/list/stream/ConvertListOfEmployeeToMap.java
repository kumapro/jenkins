package com.list.stream;

import com.list.stream.model.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ConvertListOfEmployeeToMap {
    public static void main(String[] args) {
        List<Employee> employees = getEmployeeList();
        Map<Long, Employee> employeeMap = convertEmployeeListToMap(employees);
        employeeMap.entrySet().stream().forEach(e ->System.out.println("key: " + e.getKey() + ", Value: " + e.getValue()) );
    }

    private static Map<Long, Employee> convertEmployeeListToMap(List<Employee> employees) {
//        Map<Long, Employee> employeeMap = employees.stream().collect(Collectors.toMap(Employee::getId, Function.identity()));
        // above line will not work if there will be duplicate key present. In that case we need to write as below:
        Map<Long, Employee> employeeMap = employees.stream().collect(Collectors.toMap(Employee::getId, Function.identity(), (oldVal, newVal) -> newVal));
        return employeeMap;
    }

    private static List<Employee> getEmployeeList() {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee(1l, "one"));
        employees.add(new Employee(2l, "two"));
        employees.add(new Employee(3l, "three"));
        employees.add(new Employee(4l, "four"));
        employees.add(new Employee(5l, "five"));
        employees.add(new Employee(5l, "six"));
        return employees;
    }
}
