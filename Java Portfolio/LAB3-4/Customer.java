public class Customer {
    private String accountName;
    private int totalPoints;
    private static int registeredUsers = 0;

    public Customer() {
        this.accountName = "Unknown";
        this.totalPoints = 0;
        registeredUsers++;
    }

    public Customer(String accountName, int totalPoints) {
        this.accountName = accountName;
        this.totalPoints = totalPoints;
        registeredUsers++;
    }

    public void addPoints(int earnedPoints) {
        this.totalPoints += earnedPoints;
        System.out.println(this.accountName + " earned " + earnedPoints + " points. Current total: " + this.totalPoints);
    }

    public void redeemReward() {
        if (this.totalPoints >= 100) {
            this.totalPoints -= 100;
            System.out.println("\nReward claimed by " + this.accountName + "!");
            System.out.println("Points left: " + this.totalPoints);
        } else {
            System.out.println("\n" + this.accountName + " does not have enough points for a reward.");
        }
    }

    public void displayCustomerInfo() {
        System.out.println("Name: " + this.accountName);
        System.out.println("Points: " + this.totalPoints);
        System.out.println("--------------------");
    }

    public static void displayTotalCustomers() {
        System.out.println("Total Customers: " + registeredUsers);
        System.out.println("--------------------");
    }

    public static int getAllowedRewardsRedemption(Customer customer) {
        return customer.totalPoints / 100;
    }
}
