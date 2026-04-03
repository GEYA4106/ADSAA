import java.util.*;
class JobSequencing {
public static void main(String[] args) {
Scanner sc = new Scanner(System.in);  
    System.out.print("Enter number of jobs: ");  
    int n = sc.nextInt();  
    int id[] = new int[n];  
    int deadline[] = new int[n];  
    int profit[] = new int[n];  
    for (int i = 0; i < n; i++) {  
        id[i] = i + 1;  
        System.out.print("Enter deadline and profit for Job " + id[i] + ": ");  
        deadline[i] = sc.nextInt();  
        profit[i] = sc.nextInt();  
    }    
    for (int i = 0; i < n - 1; i++) {  
        for (int j = 0; j < n - i - 1; j++) {  
            if (profit[j] < profit[j + 1]) {  
                int temp = profit[j];  
                profit[j] = profit[j + 1];  
                profit[j + 1] = temp;  

                temp = deadline[j];  
                deadline[j] = deadline[j + 1];  
                deadline[j + 1] = temp;  

                temp = id[j];  
                id[j] = id[j + 1];  
                id[j + 1] = temp;  
            }  
        }  
    }  
    int max = 0;  
    for (int i = 0; i < n; i++) {  
        if (deadline[i] > max)  
            max = deadline[i];  
    }  
    int slot[] = new int[max];  
    Arrays.fill(slot, -1);  
    int totalProfit = 0;  
    for (int i = 0; i < n; i++) {  
        for (int j = deadline[i] - 1; j >= 0; j--) {  
            if (slot[j] == -1) {  
                slot[j] = id[i];  
                totalProfit += profit[i];  
                break;  
            }  
        }  
    }  
    System.out.print("Selected Jobs: ");  
    for (int i = 0; i < max; i++) {  
        if (slot[i] != -1)  
            System.out.print("Job" + slot[i] + " ");  
    }  
    System.out.println("\nTotal Profit: " + totalProfit);  
    sc.close();  
}

}
