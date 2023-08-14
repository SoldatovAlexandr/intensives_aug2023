package ru.yandex.tasks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task10Permutations {

    private static void dfs(int[] numbers, boolean[] used, List<Integer> path, List<List<Integer>> answer) {
        if (path.size() == numbers.length) {
            answer.add(new ArrayList<>(path));
            return;
        }
        for (int i = 0; i < numbers.length; i++) {
            if (!used[i]) {
                used[i] = true;
                path.add(numbers[i]);
                dfs(numbers, used, path, answer);
                path.remove(path.size() - 1);
                used[i] = false;
            }
        }
    }

    public static int[][] permutations(int[] numbers) {
        List<List<Integer>> answer = new ArrayList<>();

        dfs(numbers, new boolean[numbers.length], new ArrayList<>(), answer);

        int[][] result = new int[answer.size()][];
        for (int i = 0; i < answer.size(); i++) {
            result[i] = answer.get(i).stream().mapToInt(Integer::intValue).toArray();
        }
        return result;
    }

    public static void selfCheck() {
        int[] input = {1, 2, 3};
        int[][] output = {
                {1, 2, 3},
                {1, 3, 2},
                {2, 1, 3},
                {2, 3, 1},
                {3, 1, 2},
                {3, 2, 1}
        };

        assert Arrays.deepEquals(output, permutations(input));
    }
}
