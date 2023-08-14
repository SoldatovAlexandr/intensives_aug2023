package ru.yandex.tasks;

public class Task8BinarySearch {
    public static int find(int number, int[] sortedList) {
        int left = 0, right = sortedList.length - 1;
        while (left <= right) {
            int middle = (left + right) / 2;
            if (sortedList[middle] == number) {
                return middle;
            } else if (sortedList[middle] > number) {
                right = middle - 1;
            } else {
                left = middle + 1;
            }
        }
        return -1;
    }

    public static void selfCheck() {
        int[] input = {1, 3, 5, 7, 9};

        for (int i = 0; i < input.length; i++) {
            assert (find(input[i], input) == i);
        }
    }
}
