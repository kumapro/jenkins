package test.giit;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Driver {
    public static void main(String... args) {

        Collection<Employee> employees = new LinkedList<>();

        employees.add(new Employee("Rahul", 57000, "Accounts"));
        employees.add(new Employee("Vivek", 101000, "Accounts"));
        employees.add(new Employee("Pramod", 64000, "HR"));
        employees.add(new Employee("Deepak", 110000, "Engineering"));
        employees.add(new Employee("Sachin", 170000, "Engineering"));
        employees.add(new Employee("Rahul", 57000, "Engineering"));

        compute(employees);
    }

    private static List<Department> compute(Collection<Employee> employees) {
        // TODO Auto-generated method stub
        Map<String, Employee> employeeMap = employees.stream().collect(Collectors.toMap(e -> e.getDeptName(), Function.identity(), (old, newOne) -> newOne));


//        Map<string, dept>
//        getEmp
//        get account
//        check slap
//        construct department
//        put department in List


return null;

    }

    private static void getSlab(Employee e) {
    }


}

class Department {

    String deptName;
    Map<String, List<Employee>> salarySlabs;

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public Map<String, List<Employee>> getSalarySlabs() {
        return salarySlabs;
    }

    public void setSalarySlabs(Map<String, List<Employee>> salarySlabs) {
        this.salarySlabs = salarySlabs;
    }
}

class Employee {

    String name;
    Integer salary;
    String deptName;

    public Employee(String name, Integer salary, String deptName) {
        this.name = name;
        this.salary = salary;
        this.deptName = deptName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }
}
