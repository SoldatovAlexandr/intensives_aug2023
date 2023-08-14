package ru.yandex.tasks;

import java.util.ArrayList;
import java.util.Arrays;

public class Task3InsertionSort {
    public static ArrayList<Integer> sort(ArrayList<Integer> numbers) {
        for (int i = 1, j; i < numbers.size(); i++) {
            int element = numbers.get(i);
            for (j = i; j > 0 && element < numbers.get(j - 1); j--) {
                numbers.set(j, numbers.get(j - 1));
            }
            numbers.set(j, element);
        }
        return numbers;
    }

    public static void selfCheck() {
        ArrayList<Integer> input = new ArrayList<>(Arrays.asList(3, 4, 5, 2, 1));
        ArrayList<Integer> output = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));

        assert output.equals(sort(input));
    }
}
