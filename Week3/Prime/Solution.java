public class Solution {

    /**
     * Check is Prime.
     *
     * @param n value
     */
    private static boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); ++i) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    /**
     * run process.
     */
    public static void main(String[] args) {
    }
}
 