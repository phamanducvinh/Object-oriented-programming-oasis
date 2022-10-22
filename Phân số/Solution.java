public class Solution {
    private int numerator;
    private int denominator;

    private boolean validatorMulti(Solution other) {
        return (other.numerator == 0);
    }


    Solution(int numerator, int denominator) {
        if (denominator != 0) {
            this.numerator = numerator;
            this.denominator = denominator;
        } else {
            this.denominator = 1;
        }
    }

    /**
     * Constructor .
     */

    public void setNumerator(int numerator) {
        this.numerator = numerator;
    }

    public int getNumerator() {
        return numerator;
    }

    /**
     * Set denominator.
     *
     * @param denominator Denominator
     */
    public void setDenominator(int denominator) {
        if (denominator != 0) {
            this.denominator = denominator;
        }
    }

    public int getDenominator() {
        return denominator;
    }

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
     * Get LCM(a,b).
     *
     * @param a first value
     * @param b second value
     */
    private int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }

    /**
     * Reduce Fraction.
     */
    public Solution reduce() {
        int getGcd = gcd(this.numerator, this.denominator);
        return new Solution(this.numerator / getGcd,
                this.denominator / getGcd);
    }

    /**
     * Add.
     *
     * @param other typeof Solution object
     */
    public Solution add(Solution other) {
        Solution a = new Solution(this.numerator, this.denominator);
        int newDe = lcm(a.denominator, other.denominator);
        int newNu = a.numerator * (newDe / a.denominator)
                + other.numerator * (newDe / other.denominator);
        return new Solution(newNu, newDe);
    }

    /**
     * Subtract.
     *
     * @param other typeof Solution object
     */
    public Solution subtract(Solution other) {
        Solution a = new Solution(this.numerator, this.denominator);
        int newDe = lcm(a.denominator, other.denominator);
        int newNu = a.numerator * (newDe / a.denominator)
                - other.numerator * (newDe / other.denominator);
        return new Solution(newNu, newDe);
    }

    /**
     * Multiply.
     *
     * @param other typeof Solution object
     */
    public Solution multiply(Solution other) {

        Solution a = new Solution(this.numerator, this.denominator);
        int newDe = a.denominator * other.denominator;
        int newNu = a.numerator * other.numerator;
        return new Solution(newNu, newDe);
    }

    /**
     * Divide.
     *
     * @param other typeof Solution object
     */

    public Solution divide(Solution other) {
        if (validatorMulti(other)) {
            return this;
        }
        Solution a = new Solution(this.numerator, this.denominator);
        int newNu = a.numerator * other.denominator;
        int newDe = a.denominator * other.numerator;
        return new Solution(newNu, newDe);
    }

    /**
     * Check (Solution) other = this.
     *
     * @param obj an object
     */
    public boolean equals(Object obj) {
        if (obj instanceof Solution) {
            Solution other = (Solution) obj;
            other = other.reduce();
            Solution a = new Solution(this.numerator, this.denominator);
            a = a.reduce();
            return (a.numerator == other.numerator && a.denominator == other.denominator);
        }
        return false;
    }

    /**
     * Run process.
     */
    public static void main(String[] args) {
    }
}
 