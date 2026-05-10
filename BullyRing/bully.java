import java.util.*;
public class bully{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter no of processes");
		int n=sc.nextInt();
		int[] process=new int[n];
		boolean[] active=new boolean[n];
		
		System.out.println("Enter the process IDs: ");
		for(int i=0;i<n;i++) {
			process[i]=sc.nextInt();
			active[i]=true;
		}
		
		System.out.println("Enter the process id that failed: ");
		int failed=sc.nextInt();
		for(int i=0;i<n;i++) {
			if(process[i]==failed) {
				active[i]=false;
			}
		}
		
		System.out.println("Enter process ID that detected the failure: ");
		int initiator=sc.nextInt();
		int leader=initiator;
		
		for(int i=0;i<n;i++) {
			if(active[i] && process[i]>initiator) {
				System.out.println("Process "+process[i]+" responds");
				
				if(process[i]>leader) {
					leader=process[i];
				}
			}
		}
		System.out.println("Process "+leader+" is sending COORDINATOR messages");
		System.out.println("New Leader is: "+leader);
	}
}