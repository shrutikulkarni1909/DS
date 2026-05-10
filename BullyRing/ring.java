import java.util.*;

class ring {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter number of processes");
        int n=sc.nextInt();
        int[] process=new int[n];
        boolean[] active=new boolean[n];
         System.out.println("Enter process IDs: ");
         for(int i=0;i<n;i++) {
        	 process[i]=sc.nextInt();
        	 active[i]=true;
         }
         
         System.out.println("Enter process ID that failed");
         int failed=sc.nextInt();
         for(int i=0;i<n;i++) {
            if(process[i]==failed) {
        	  active[i]=false;
            }  
         }
         
         System.out.println("Enter initiator index: ");
         int initiator=sc.nextInt();
         System.out.println("Election message: ");
         int i=initiator;
         int max=-1;
         do {
        	 if(active[i]) {
        		 System.out.print(process[i]+" -> ");
        		 if(process[i]>max) {
        			 max=process[i];
        		 }
        	 }
        	 i=(i+1)%n;
         }while(i!=initiator);
         System.out.println("Back to initiator");
         System.out.println("Process "+max+" sending coordinator messages");
         System.out.println("New leader: "+max);
    }
}