public class CheckingAccount extends Account {
    public CheckingAccount(long accountNumber, double balance) {
        super(accountNumber, balance);
    }

    /**
     * T.
     */
    public void withdraw(double value) {
        try {
            doWithdrawing(value);
            Transaction transaction = new
                    Transaction(1, value, balance + value, balance);
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
            Transaction transaction = new
                    Transaction(0, value, balance - value, balance);
            addTransaction(transaction);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
