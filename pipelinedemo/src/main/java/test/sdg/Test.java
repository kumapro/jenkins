package test.sdg;

import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        Integer[] arr = new Integer[] { 5, 8, 4, 6, 2, 7, 1 };
        sortArray(arr);
        Arrays.stream(arr).forEach(System.out::println);
    }

    private static void sortArray(Integer[] arr) {
        for (int i = 0; i < arr.length; i++){
            for (int j = i +1; j < arr.length; j++){
                if(arr[i] > arr[j]){
                    int temp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = temp;
                }
            }
        }
    }
}
