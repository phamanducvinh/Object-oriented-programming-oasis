public class InvalidFundingAmountException extends BankException {

    public InvalidFundingAmountException(double value) {
        super(String.format("Số tiền không hợp lệ: $%.2f", value));
    }
}
