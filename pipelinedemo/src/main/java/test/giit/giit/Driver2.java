package test.giit.giit;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;

//import lombok.Data;

public class Driver2 {

    public static void main(String... args) {

        Collection<Employee> employees = new LinkedList<>();

        employees.add(new Employee("Rahul", 57000, "Accounts"));
        employees.add(new Employee("Vivek", 101000, "Accounts"));
        employees.add(new Employee("Pramod", 64000, "HR"));
        employees.add(new Employee("Deepak", 110000, "Engineering"));
        employees.add(new Employee("Sachin", 170000, "Engineering"));
        employees.add(new Employee("Rahul", 57000, "Engineering"));
        employees.add(new Employee("Rahul", 59000, "Engineering"));

        List<Department> departments = compute(employees);
//        departments.forEach(d -> System.out.println(d.getDeptName() + " : " + d.getSalarySlabs()));
        departments.forEach(System.out::println);
        System.out.println("FI");
    }

    private static List<Department> compute(Collection<Employee> employees) {

        return employees.stream().collect(Collectors.groupingBy(Employee::getDeptName)).entrySet().stream()
                .map(entry -> {

                    String deptName = entry.getKey();
                    List<Employee> emps = entry.getValue();

                    Map<String, List<Employee>> ss = emps.stream()
                            .collect(Collectors.groupingBy(emp -> decideSlab(emp.getSalary())));

                    Department d = new Department();
                    d.setDeptName(deptName);
                    d.setSalarySlabs(ss);

                    return d;
                }).collect(Collectors.toList());

    }

    private static String decideSlab(Integer salary) {

        Function<Integer, String> fn_slab1 = sal -> sal > 50000 && sal < 100000 ? "Slab-1" : null;
        Function<Integer, String> fn_slab2 = sal -> sal > 100000 && sal < 150000 ? "Slab-2" : null;
        Function<Integer, String> fn_slab3 = sal -> sal > 150000 && sal < 200000 ? "Slab-3" : null;

        Function<Integer, String> fn_final = sal -> {

            String val1 = fn_slab1.apply(sal);
            String val2 = fn_slab2.apply(sal);
            String val3 = fn_slab3.apply(sal);

            return val1 != null ? val1 : val2 != null ? val2 : val3 != null ? val3 : "NA";
        };

        return fn_final.apply(salary);
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

    @Override
    public String toString() {
        return "Department{" +
                "deptName='" + deptName + '\'' +
                ", salarySlabs=" + salarySlabs +
                '}';
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

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", deptName='" + deptName + '\'' +
                '}';
    }
}

// Problem : Create a list of 'Department' objects each having their employees categorized according to salary slabs.

// KEY :

//	Slab-1 : 50,000 - 1,00,000
//	Slab-2 : 1,00,000 - 1,50,000
//	Slab-3 : 1,50,000 - 2,00,000
