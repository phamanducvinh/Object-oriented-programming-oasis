public class Solution {
    private static final long MAXV = Long.MAX_VALUE;
    private static long[] fi;

    /**
     * Get fibonacci n-th.
     *
     * @param n th
     */
    public static long fibonacci(long n) {

        if (n == 0) {
            return 0;
        }

        if (n == 1) {
            return 1;
        }

        if (n < 0) {
            return -1;
        }

        if (n > 92) {
            return MAXV;
        }

        fi = new long[(int) (n + 1)];
        fi[0] = 0;
        fi[1] = 1;

        for (int i = 2; i <= n; ++i) {
            fi[i] = fi[i - 1] + fi[i - 2];
        }

        return fi[(int) n];
    }

    public static void main(String[] args) {
    }
}
 