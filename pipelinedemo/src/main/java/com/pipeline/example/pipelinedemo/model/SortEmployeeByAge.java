package com.pipeline.example.pipelinedemo.model;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class SortEmployeeByAge {
    public static void main(String[] args) {

        //Addition of Double produces the double result
        Double d = new Double(0.06);

        Double d1 = -0.0201;
        Double d2 = d + d1;
        System.out.println(d2);
        double valueRounded = Math.round(d2 * 10000D) / 10000D;
        System.out.println(valueRounded);

        /*Float f = new Float(0.06);
        Float f1 = 0.02f;
        Float f2 = f + f1;
        System.out.println(f2);*/

//        Employee e1 = new Employee(1, "Name 1", 50);
//        Employee e2 = new Employee(2, "Name 2", 20);
//        Employee e3 = new Employee(3, "Name 3", 10);
//        Employee e4 = new Employee(4, "Name 4", 40);
//
//        List<Employee> list = new ArrayList<>();
//        list.add(e1);
//        list.add(e2);
//        list.add(e3);
//        list.add(e4);
//        list.forEach(e -> System.out.println(e));
//        list.sort((emp1, emp2) -> emp1.getAge() - emp2.getAge());
//        System.out.println("after sorting........");
//        list.forEach(e -> System.out.println(e));

       testStringFormat();

    }

    private static void testStringFormat() {
        StringBuffer sb = new StringBuffer(new SimpleDateFormat("ddMMyyy HH:mm").format(new Date()));
        sb.append(" (JA Conf)");
        sb.append("-" + 1213131);
        sb.append("-" + 1);
        String[] split = sb.toString().trim().split("-");
        System.out.println(split.length);

//        String str = " b ";
//        String[] strs = str.trim().split(" ");
//        Arrays.stream(strs).forEach(e -> System.out.println(e));
//        System.out.println(strs.length);
//        System.out.println( "Test".equals(null));
    }
}
