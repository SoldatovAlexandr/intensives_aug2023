package ru.yandex.tasks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task4DFS {

    public static void dfs(int[][] tree, int root, List<Integer> result) {
        if (root == -1) {
            return;
        }
        int[] node = tree[root];
        dfs(tree, node[0], result);
        dfs(tree, node[1], result);
        result.add(root);
    }

    public static int[] getDFSOrder(int[][] tree, int root) {
        List<Integer> result = new ArrayList<>();
        dfs(tree, root, result);
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void selfCheck() {
        int[][] tree =
                {
                        {1, 6},
                        {2, 3},
                        {-1, -1},
                        {4, -1},
                        {-1, -1},
                        {-1, -1},
                        {-1, 8},
                        {-1, -1},
                        {-1, -1}
                };

        int[] ans1 = {2, 4, 3, 1, 8, 6, 0};
        int[] ans2 = {4, 3};
        int[] ans3 = {2};
        int[] ans4 = {8, 6};

        assert (Arrays.equals(getDFSOrder(tree, 0), ans1));
        assert (Arrays.equals(getDFSOrder(tree, 3), ans2));
        assert (Arrays.equals(getDFSOrder(tree, 2), ans3));
        assert (Arrays.equals(getDFSOrder(tree, 6), ans4));
    }
}
