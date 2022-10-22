import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Bank {
    private List<Customer> customerList = new ArrayList<Customer>();

    /**
     * T.
     */
    public void readCustomerList(InputStream path) {
        Scanner scanner = new Scanner(path);
        Customer customer = new Customer();
        while (scanner.hasNextLine()) {
            String read = scanner.nextLine();
            if (Character.isDigit(read.charAt(0))) {
                int position1 = read.indexOf(' ');
                int position2 = read.lastIndexOf(' ');
                if (read.substring(position1 + 1, position2).equals(Account.CHECKING)) {
                    customer.addAccount(new CheckingAccount(
                            Long.parseLong(read.substring(0, position1)),
                            Double.parseDouble(read.substring(position2 + 1))));
                } else {
                    customer.addAccount(new SavingsAccount(
                            Long.parseLong(read.substring(0, position1)),
                            Double.parseDouble(read.substring(position2 + 1))));
                }
            } else {
                if (!customer.getFullName().isEmpty()) {
                    customerList.add(customer);
                }
                int position = read.lastIndexOf(' ');
                customer = new Customer(
                        Long.parseLong(read.substring(position + 1)),
                        read.substring(0, position));
            }
        }
        if (!customer.getFullName().isEmpty()) {
            customerList.add(customer);
        }
    }

    /**
     * T.
     */
    public String getCustomersInfoByIdOrder() {
        String result = "";
        Collections.sort(customerList, new Comparator<Customer>() {
            @Override
            public int compare(Customer x, Customer y) {
                return x.getIdNumber() < y.getIdNumber() ? -1 : 1;
            }
        });
        for (int i = 0; i < customerList.size(); ++i) {
            Customer customer = customerList.get(i);
            result += customer.getCustomerInfo();
            if (i != customerList.size() - 1) {
                result += '\n';
            }
        }
        return result;
    }

    /**
     * T.
     */
    public String getCustomersInfoByNameOrder() {
        String result = "";
        Collections.sort(customerList, new Comparator<Customer>() {
            @Override
            public int compare(Customer x, Customer y) {
                return x.getFullName().compareTo(y.getFullName());
            }
        });
        for (int i = 0; i < customerList.size(); ++i) {
            Customer customer = customerList.get(i);
            result += customer.getCustomerInfo();
            if (i != customerList.size() - 1) {
                result += '\n';
            }
        }
        return result;
    }

    public List<Customer> getCustomerList() {
        return customerList;
    }
}
