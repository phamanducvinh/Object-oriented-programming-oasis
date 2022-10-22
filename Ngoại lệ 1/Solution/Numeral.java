public class Numeral extends Expression {
    private final double value;

    public Numeral(double value) {
        this.value = value;
    }

    public Numeral() {
        value = 0;
    }

    /**
     * To string.
     */
    @Override
    public String toString() {
        if (value == Math.round(value)) {
            return String.valueOf(Math.round(value));
        }
        return String.valueOf(value);
    }

    @Override
    public double evaluate() {
        return value;
    }
}
