import java.util.ArrayList;

public class Account {
    private double balance;
    private ArrayList<Transaction> transitionList = new ArrayList<Transaction>();

    /**
     * Validator operation.
     *
     * @param operation isString
     */
    private boolean validator(String operation) {
        return (operation.equals(getDeposit())
                || operation.equals(getWithdraw()));
    }

    /**
     * Deposit.
     *
     * @param amount add bal
     */
    private void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("So tien ban nap vao khong hop le!");
            return;
        }
        balance += amount;
    }

    /**
     * Withdraw.
     *
     * @param amount add bal
     */
    private void withdraw(double amount) {
        if (amount <= 0) {
            System.out.println("So tien ban rut ra khong hop le!");
            return;
        }

        if (amount > balance) {
            System.out.println("So tien ban rut vuot qua so du!");
            return;
        }

        balance -= amount;
    }

    private String getDeposit() {
        return Transaction.DEPOSIT;
    }

    private String getWithdraw() {
        return Transaction.WITHDRAW;
    }

    /**
     * Add Transaction.
     *
     * @param amount    double
     * @param operation String
     */
    public void addTransaction(double amount, String operation) {
        if (validator(operation)) {
            if (operation.equals(getDeposit())) {
                deposit(amount);
            } else if (operation.equals(getWithdraw())) {
                withdraw(amount);
            }
            Transaction transaction = new Transaction(operation, amount, balance);
            transitionList.add(transaction);
        } else {
            System.out.println("Yeu cau khong hop le!");
        }
    }

    /**
     * Printf Transaction.
     * all
     */
    public void printTransaction() {
        for (int i = 0; i < transitionList.size(); ++i) {
            Transaction transaction = transitionList.get(i);
            if (transaction.getOperation().equals(getDeposit())) {
                System.out.println("Giao dich " + (i + 1) + ": "
                        + "Nap tien $"
                        + String.format("%.2f",
                        Math.round(transaction.getAmount() * 100.0) / 100.0)
                        + ". So du luc nay: $"
                        + String.format("%.2f",
                        Math.round(transaction.getBalance() * 100.0) / 100.0)
                        + ".");
            } else {
                System.out.println("Giao dich " + (i + 1) + ": "
                        + "Rut tien $"
                        + String.format("%.2f",
                        Math.round(transaction.getAmount() * 100.00) / 100.00)
                        + ". So du luc nay: $"
                        + String.format("%.2f",
                        Math.round(transaction.getBalance() * 100.00) / 100.00)
                        + ".");
            }
        }
    }

    public static void main(String[] args) {
    }
}
