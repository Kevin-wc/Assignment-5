public class Subarray {
    public static int[] subarray(int[] A, int K) {
        int start = 0;
        int current = 0;

        for (int end = 0; end < A.length; end++) {
            current += A[end];

            while (current > K && start <= end) {
                current -= A[start];
                start++;
            }

            if (current == K) {
                return new int[]{start, end};
            }
        }

        return new int[]{-1, -1};
    }
}
