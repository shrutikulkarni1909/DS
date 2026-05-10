import java.util.*;
public class tokenRing{
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter number of processes: ");
		int n=sc.nextInt();
		int token=0;
		while(true) {
		System.out.println("Token is with process: "+token);
		System.out.println("Does process "+token+" want to enter Critical Section? (1/0) ");
		int ch=sc.nextInt();
		if(ch==1) {
			System.out.println("Process "+token+" entering Critical Section");
			System.out.println("Process "+token+" leaving critical section");
		}
		token=(token+1)%n;
		
		System.out.println("Continue? (1/0)");
		int cont=sc.nextInt();
		if(cont==0) {
			break;
		}
	}
		sc.close();
}}