package ru.yandex.tasks;

public class Task11BiggestSubarraySum {

    public static Subarray find(int[] numbers) {

        Subarray result = new Subarray();

        int startCurrentMax = 0;
        int maximumSum = Integer.MIN_VALUE, currSumSubarray = 0;

        for (int i = 0; i < numbers.length; i++) {
            currSumSubarray += numbers[i];
            if (maximumSum < currSumSubarray) {
                maximumSum = currSumSubarray;
                result.left = startCurrentMax;
                result.right = i + 1;
            }
            if (currSumSubarray < 0) {
                startCurrentMax = i + 1;
                currSumSubarray = 0;
            }
        }
        return result;
    }

    public static void selfCheck() {
        int[] output = {1, 2, -5, 7, -1, 6};
        Subarray ans = find(output);

        assert ans != null;
        assert (ans.left == 3 && ans.right == 6);
    }
}
