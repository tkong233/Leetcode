package Interviews.Databricks;
import java.util.*;

public class CustomerRevenue {
    Map<Integer, Customer> idToCustomer;
    List<Customer> customers;
    class Customer implements Comparable<Customer> {
        int id;
        int revenue;

        public Customer(int id, int revenue) {
            this.id = id;
            this.revenue = revenue;
        }

        @Override
        public int compareTo(Customer other) {
            if (this.revenue == other.revenue) {
                return 0;
            }
            return this.revenue < other.revenue ? -1 : 1;
        }
    }

    public CustomerRevenue() {
        idToCustomer = new HashMap<>();
        customers = new ArrayList<>();
    }

    public void insert(int id, int revenue) {
        Customer customer = new Customer(id, revenue);

    }

    // 1 4 6 9
    // 8
    // return index of largest element <= target,
    // add(index + 1, customer)
    public void insertReferral(int id, int referralId) {

    }

    public List<Integer> getKCustomerRevenueBelowThreashold(int threashold, int k) {
        return null;
    }

    // return index of customer
    private int getLargestSmallerElementId(int target) {
        return -1;
    }

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(0, 1);
        list.add(1, 2);
        list.add(0, 0);
        System.out.println(list);
    }
}

























