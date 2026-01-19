public class CoffeeShop {
    public static void main(String[] args) {

        Customer first = new Customer("Joseph", 200);
        Customer second = new Customer("Peter", 0);
        Customer third = new Customer();

        second.addPoints(200);
        second.addPoints(20);

        first.redeemReward();
        second.redeemReward();
        third.redeemReward();

        System.out.println("\n=== LIST OF CUSTOMERS ===");
        first.displayCustomerInfo();
        second.displayCustomerInfo();
        third.displayCustomerInfo();
        Customer.displayTotalCustomers();

        System.out.println();
        Customer fourth = new Customer("Diane", 0);
        fourth.addPoints(50);

        System.out.println();
        fourth.displayCustomerInfo();
        Customer.displayTotalCustomers();

        System.out.println();
        System.out.println("Joseph is eligible for " + Customer.getAllowedRewardsRedemption(first) + " reward(s).");
        System.out.println("Peter is eligible for " + Customer.getAllowedRewardsRedemption(second) + " reward(s).");
        System.out.println("Unknown is eligible for " + Customer.getAllowedRewardsRedemption(third) + " reward(s).");
        System.out.println("Diane is eligible for " + Customer.getAllowedRewardsRedemption(fourth) + " reward(s).");
    }
}
