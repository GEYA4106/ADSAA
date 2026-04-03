import java.util.Scanner;
public class KnapsackBT{
    static int maxProfit = 0;
    static int n, W;
    static int[] weight;
    static int[] profit;
    static void knapsack(int i, int currentWeight, int currentProfit) {
        if (currentWeight <= W && currentProfit > maxProfit) {
            maxProfit = currentProfit;
        }
        if (i == n) {
            return;
        }
        if (currentWeight + weight[i] <= W) {
            knapsack(i + 1,
                     currentWeight + weight[i],
                     currentProfit + profit[i]);
        }
        knapsack(i + 1, currentWeight, currentProfit);
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of items: ");
        n = sc.nextInt();
        weight = new int[n];
        profit = new int[n];
        System.out.println("Enter weights:");
        for (int i = 0; i < n; i++) {
            weight[i] = sc.nextInt();
        }
        System.out.println("Enter profits:");
        for (int i = 0; i < n; i++) {
            profit[i] = sc.nextInt();
        }
        System.out.print("Enter capacity of knapsack: ");
        W = sc.nextInt();
        knapsack(0, 0, 0);
        System.out.println("Maximum Profit = " + maxProfit);
        sc.close();
    }
}