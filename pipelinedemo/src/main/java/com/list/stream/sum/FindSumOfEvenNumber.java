package com.list.stream.sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;

public class FindSumOfEvenNumber {
    public static void main(String[] args) {
        List<Integer> integers = new ArrayList<>(Arrays.asList(1,2,3,3,4,4,4,4,4,-4,-2,-3,2,6));
        int sum = integers.stream().filter(e -> (e > 0 && e % 2 == 0)).distinct().mapToInt(f -> f).sum();
        System.out.println(sum);

        IntSummaryStatistics statistics = integers.stream().filter(e -> (e > 0 && e % 2 == 0)).distinct().mapToInt(f -> f).summaryStatistics();
        System.out.println(statistics.getMax());
        System.out.println(statistics.getMin());
        System.out.println(statistics.getAverage());
        System.out.println(statistics.getCount());
        System.out.println(statistics.getSum());

    }

}
