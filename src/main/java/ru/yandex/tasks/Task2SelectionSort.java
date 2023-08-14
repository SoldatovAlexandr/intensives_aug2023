package ru.yandex.tasks;

import java.util.ArrayList;
import java.util.Arrays;

public class Task2SelectionSort {
    public static ArrayList<Integer> sort(ArrayList<Integer> numbers) {
        for (int i = 0; i < numbers.size(); i++) {
            int indexOfMinElement = i;
            for (int j = i; j < numbers.size(); j++) {
                if (numbers.get(indexOfMinElement) > numbers.get(j)) {
                    indexOfMinElement = j;
                }
            }
            swap(numbers, indexOfMinElement, i);
        }
        return numbers;
    }

    private static void swap(ArrayList<Integer> numbers, int first, int second) {
        int temp = numbers.get(first);
        numbers.set(first, numbers.get(second));
        numbers.set(second, temp);
    }

    public static void selfCheck() {
        ArrayList<Integer> input = new ArrayList<>(Arrays.asList(3, 4, 5, 2, 1));
        ArrayList<Integer> output = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));

        assert output.equals(sort(input));
    }
}
