import java.util.ArrayList;
import java.util.List;

public abstract class Account {
    public static final String CHECKING = "CHECKING";
    public static final String SAVINGS = "SAVINGS";
    protected long accountNumber;
    protected double balance;
    protected List<Transaction> transactionList = new ArrayList<Transaction>();

    public Account() {
    }

    public Account(long accountNumber, double balance) {
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    /**
     * T.
     */
    public void doWithdrawing(double value) throws
            InvalidFundingAmountException,
            InsufficientFundsException {
        if (value < 0) {
            throw new InvalidFundingAmountException(value);
        }
        if (value > balance) {
            throw new InsufficientFundsException(value);
        }
        balance -= value;
    }

    /**
     * T.
     */
    public void doDepositing(double value) throws InvalidFundingAmountException {
        if (value < 0) {
            throw new InvalidFundingAmountException(value);
        }
        balance += value;
    }

    public abstract void withdraw(double value);

    public abstract void deposit(double value);

    public long getAccountNumber() {
        return accountNumber;
    }

    public double getBalance() {
        return balance;
    }

    /**
     * T.
     */
    public String getTransactionHistory() {
        String result = "Lịch sử giao dịch của tài khoản "
                + accountNumber
                + ":\n";
        for (Transaction transaction : transactionList) {
            result += transaction.getTransactionSummary() + '\n';
        }
        return result;
    }

    public void addTransaction(Transaction tran) {
        transactionList.add(tran);
    }

    /**
     * T.
     */
    public boolean equals(Object ob) {
        if (ob instanceof Account) {
            Account other = (Account) ob;
            return (accountNumber == other.getAccountNumber());
        }
        return false;
    }
}
