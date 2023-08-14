package ru.yandex.tasks;

import java.util.*;

public class Task5BFS {

    public static void bfs(int[][] tree, Queue<Integer> queue, List<Integer> result) {
        while (!queue.isEmpty()) {
            int root = queue.poll();
            if (root != -1) {
                int[] node = tree[root];
                result.add(root);
                queue.offer(node[0]);
                queue.offer(node[1]);
            }
        }
    }

    public static int[] getBFSOrder(int[][] tree, int root) {
        Queue<Integer> queue = new LinkedList<>();
        List<Integer> result = new ArrayList<>();

        queue.offer(root);
        bfs(tree, queue, result);

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

        int[] ans1 = {0, 1, 6, 2, 3, 8, 4};
        int[] ans2 = {3, 4};
        int[] ans3 = {2};
        int[] ans4 = {6, 8};

        assert (Arrays.equals(getBFSOrder(tree, 0), ans1));
        assert (Arrays.equals(getBFSOrder(tree, 3), ans2));
        assert (Arrays.equals(getBFSOrder(tree, 2), ans3));
        assert (Arrays.equals(getBFSOrder(tree, 6), ans4));
    }
}
