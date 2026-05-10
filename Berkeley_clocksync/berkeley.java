import java.util.*;
public class berkeley {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter no. of nodes: ");
		int n=sc.nextInt();
		int[] time=new int[n];
		int sum=0;

		for(int i=0;i<n;i++) {
		    System.out.println("Enter clock time for node "+i);
		    time[i]=sc.nextInt();
		    sum+=time[i];
		}
	    int avg=sum/n;
	
		System.out.println("Average clock time: "+avg);
		System.out.println("Adjustments required: ");
		for(int i=0;i<n;i++) {
			int diff=avg-time[i];
			System.out.println("Node: "+i+" Adjustment required: "+diff);
			time[i]+=diff;
		}
		System.out.println("Synchronized clock times");
		for(int i=0;i<n;i++) {
			System.out.println("Node: "+i+" Clock Time: "+time[i]);
		}
	}

}
