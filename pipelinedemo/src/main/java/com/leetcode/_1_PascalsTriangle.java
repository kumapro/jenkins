package com.leetcode;

import java.util.ArrayList;
import java.util.List;

public class _1_PascalsTriangle {
    public static void main(String[] args) {
        List<List<Integer>> triangle = printPascalsTriangle(5);
        triangle.forEach(e -> System.out.println(e));
    }

    private static List<List<Integer>> printPascalsTriangle(int rowNum) {
        List<List<Integer>> triangle = new ArrayList<>();
        List<Integer> row = new ArrayList<>();
        row.add(1);
        triangle.add(row);

        for(int i = 1; i < rowNum; i++){
            List<Integer> prevRow = triangle.get(i-1);
            row = new ArrayList<>();
            row.add(1);
            for (int j=0; j < prevRow.size() -1; j++){
                row.add(prevRow.get(j) + prevRow.get(j +1));
            }
            row.add(1);
            triangle.add(row);
        }
        return triangle;
    }
}


/*

     1
   1   1
 1   2   1
1  3   3   1

 */