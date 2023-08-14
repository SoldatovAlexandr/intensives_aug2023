package ru.yandex.tasks;

import java.util.Arrays;

public class Task12Spiral {
    public static int[][] draw (int N) {
        int[][] matrix = new int[N][N];

        int count = 1;
        for (int i = 0; i < (N + 1) / 2; i++) {
            for (int pointer = i; pointer < N - i; pointer++) {
                matrix[i][pointer] = count++;
            }
            for (int pointer = i + 1; pointer < N - i; pointer++) {
                matrix[pointer][N - i - 1] = count++;
            }
            for (int pointer = N - i - 2; pointer >= i; pointer--) {
                matrix[N - i - 1][pointer] = count++;
            }
            for (int pointer = N - i - 2; pointer > i; pointer--) {
                matrix[pointer][i] = count++;
            }
        }
        return matrix;
    }

    public static void selfCheck() {
        int[][] output = {
                {1, 2, 3, 4, 5, 6, 7},
                {24, 25, 26, 27, 28, 29, 8},
                {23, 40, 41, 42, 43, 30, 9},
                {22, 39, 48, 49, 44, 31, 10},
                {21, 38, 47, 46, 45, 32, 11},
                {20, 37, 36, 35, 34, 33, 12},
                {19, 18, 17, 16, 15, 14, 13}
        };

        assert Arrays.deepEquals(output, draw(7));
    }
}
