public class SavingsAccount extends Account {
    public SavingsAccount(long accountNumber, double balance) {
        super(accountNumber, balance);
    }

    /**
     * T.
     */
    public void withdraw(double value) {
        if (value > 1000 || balance < 5000) {
            return;
        }
        try {
            doWithdrawing(value);
            Transaction transaction = new Transaction(
                    3,
                    value,
                    balance + value,
                    balance);
            addTransaction(transaction);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * T.
     */
    public void deposit(double value) {
        try {
            doDepositing(value);
            Transaction transaction = new Transaction(
                    2,
                    value,
                    balance - value,
                    balance
            );
            addTransaction(transaction);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
