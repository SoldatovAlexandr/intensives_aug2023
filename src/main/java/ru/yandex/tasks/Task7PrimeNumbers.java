package ru.yandex.tasks;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Task7PrimeNumbers {
    public static int[] findPrimes (int N) {
        boolean[] isPrimes = new boolean[N + 1];
        Arrays.fill(isPrimes, 2, N + 1, true);

        for (int i = 2; i < N + 1; i++) {
            if (isPrimes[i]) {
                for (int j = i * i; j < N + 1 && j > 0; j += i) {
                    isPrimes[j] = false;
                }
            }
        }

        List<Integer> result = new ArrayList<>();
        for (int i = 2; i < N + 1; i++) {
            if (isPrimes[i]) {
                result.add(i);
            }
        }
        return result.stream().mapToInt(Integer::intValue).toArray();
    }

    public static void selfCheck() {
        int[] output = {2, 3, 5};

        assert (Arrays.equals(output, findPrimes(5)));
    }
}
