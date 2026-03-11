//Java program to iplement job sequencing with deadlines usinng greedy strategy
import java.util.*;
class Job{
	int id;
	int deadline;
	int profit;
	Job(int id,int deadline,int profit){
		this.id=id;
		this.deadline=deadline;
		this.profit=profit;
	}
}
public class JobSequencing{
	static void jobScheduling(Job jobs[],int n){
		Arrays.sort(jobs,(a,b)->b.profit-a.profit);
		int maxDeadline=0;
		for(int i=0;i<n;i++){
			if(jobs[i].deadline>maxDeadline)
				maxDeadline=jobs[i].deadline;
		}
		int slot[]=new int[maxDeadline];
		Arrays.fill(slot,-1);
		int totalProfit=0;
		for(int i=0;i<n;i++){
			for(int j=Math.min(maxDeadline,jobs[i].deadline)-1;j>=0;j--){
				if(slot[j]==-1){
					slot[j]=jobs[i].id;
					totalProfit+=jobs[i].profit;
					break;
				}
			}
		}
		System.out.println("Job sequence:");
		for(int i=0;i<maxDeadline;i++){
			if(slot[i]!=-1)
				System.out.print("J"+slot[i]+" ");
		}
		System.out.println("\nTotal Profit:"+totalProfit);
	}
	public static void main(String [] args){
		Job jobs[]={
			new Job(1,2,100),
			new Job(2,1,19),
			new Job(3,2,19),
			new Job(4,1,7),
			new Job(5,3,15),	
		};
		int n=jobs.length;
		jobScheduling(jobs,n);
	}
}

