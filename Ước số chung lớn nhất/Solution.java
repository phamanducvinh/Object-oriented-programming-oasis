public class Solution {
    /**
     * Get GCD(a,b).
     *
     * @param a first value
     * @param b second value
     */
    private static int gcd(int a, int b) {
        if (a < 0) {
            a *= -1;
        }
        if (b < 0) {
            b *= -1;
        }

        if (a == 0) {
            return b;
        }

        if (b == 0) {
            return a;
        }

        return gcd(b, a % b);
    }

    /**
     * run process.
     */
    public static void main(String[] args) {
    }
}