import java.util.ArrayList;
import java.util.List;

public class Customer {
    private long idNumber;
    private String fullName = "";
    private List<Account> accountList = new ArrayList<Account>();

    public Customer() {
    }

    Customer(long idNumber, String fullName) {
        this.idNumber = idNumber;
        this.fullName = fullName;
    }

    public long getIdNumber() {
        return idNumber;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setIdNumber(long idNumber) {
        this.idNumber = idNumber;
    }

    public List<Account> getAccountList() {
        return accountList;
    }

    /**
     * T.
     */
    public String getCustomerInfo() {
        String result = "Số CMND: "
                + Long.toString(idNumber)
                + ". Họ tên: "
                + fullName + ".";
        return result;
    }

    public void addAccount(Account acc) {
        this.accountList.add(acc);
    }

    public void removeAccount(Account acc) {
        this.accountList.remove(acc);
    }
}
