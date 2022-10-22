public class Transaction {
    public static final int TYPE_DEPOSIT_CHECKING = 0;
    public static final int TYPE_WITHDRAW_CHECKING = 1;
    public static final int TYPE_DEPOSIT_SAVINGS = 2;
    public static final int TYPE_WITHDRAW_SAVINGS = 3;
    private int type;
    private double amount;
    private double initialBalance;
    private double finalBalance;

    /**
     * T.
     */
    public Transaction(int type, double amount, double initialBalance, double finalBalance) {
        this.type = type;
        this.amount = amount;
        this.initialBalance = initialBalance;
        this.finalBalance = finalBalance;
    }

    /**
     * T.
     */
    private String getTransactionTypeString(int type) {
        String result = "";
        if (type == 0) {
            result = "Nạp tiền vãng lai";
        }

        if (type == 1) {
            result = "Rút tiền vãng lai";
        }

        if (type == 2) {
            result = "Nạp tiền tiết kiệm";
        }

        if (type == 3) {
            result = "Rút tiền tiết kiệm";
        }

        return result;
    }

    /**
     * T.
     */
    public String getTransactionSummary() {
        String result = String.format("- Kiểu giao dịch: %s. Số dư ban đầu: $%.2f. "
                        + "Số tiền: $%.2f. Số dư cuối: $%.2f.",
                getTransactionTypeString(type), initialBalance, amount, finalBalance);
        return result;
    }
}
