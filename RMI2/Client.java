import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Client{
	public static void main(String[] args) {
		try {
			Registry registry=LocateRegistry.getRegistry("localhost",2000);
			Calculator stub=(Calculator) registry.lookup("CalculatorService");
			
			Scanner sc=new Scanner(System.in);
			int choice;
			do {
			System.out.println("1.Addition");
			System.out.println("2.Subtraction");
			System.out.println("3.Multiplication");
			System.out.println("4.Division");
			System.out.println("5.Exit");
			System.out.println("Enter your choice");
		    choice=sc.nextInt();
		    
		    if(choice==5) {
		    	System.out.println("Exiting...");
		    	break;
		    }
			System.out.println("Enter two numbers: ");
			double a=sc.nextDouble();
			double b=sc.nextDouble();
			double result=0;
			switch(choice) {
			case 1:
				result=stub.add(a, b);
				break;
			case 2:
				result=stub.sub(a, b);
				break;
			case 3:
				result=stub.multiply(a, b);
				break;
			case 4:
				result=stub.div(a, b);
				break;
	
			}
          System.out.println("Result: "+result);
		}while(choice>=1 && choice<=4);
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
}