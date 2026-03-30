import java.util.*;
class Job {
    int id, deadline, profit;
    Job(int id, int deadline, int profit) {
        this.id = id;
        this.deadline = deadline;
        this.profit = profit;
    }
}
public class JobSequencing {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of jobs:");
        int n = sc.nextInt();
        Job[] jobs = new Job[n];
        System.out.println("Enter deadline and profit for each job:");
        for (int i = 0; i < n; i++) {
            int d = sc.nextInt();
            int p = sc.nextInt();
            jobs[i] = new Job(i + 1, d, p);
        }
        Arrays.sort(jobs, (a, b) -> b.profit - a.profit);
        int maxDeadline = 0;
        for (Job j : jobs) {
            maxDeadline = Math.max(maxDeadline, j.deadline);
        }
        int[] slot = new int[maxDeadline + 1];
        Arrays.fill(slot, -1);
        int totalProfit = 0;
        for (Job j : jobs) {
            for (int k = j.deadline; k > 0; k--) {
                if (slot[k] == -1) {
                    slot[k] = j.id;
                    totalProfit += j.profit;
                    break;
                }
            }
        }
        System.out.println("Selected Jobs:");
        for (int i = 1; i <= maxDeadline; i++) {
            if (slot[i] != -1) {
                System.out.print("J" + slot[i] + " ");
            }
        }
        System.out.println("\nTotal Profit: " + totalProfit);
    }
}
