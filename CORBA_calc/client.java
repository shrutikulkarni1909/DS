import org.omg.CORBA.*;
import org.omg.CosNaming.NamingContextExt;
import org.omg.CosNaming.NamingContextExtHelper;

import java.util.*;

public class client {

	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		ORB orb=ORB.init(args,null);
		NamingContextExt nc = NamingContextExtHelper.narrow(orb.resolve_initial_references("NameService"));
		Calculator obj= CalculatorHelper.narrow(nc.resolve_str("calculate"));
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
			result=obj.add(a, b);
			break;
		case 2:
			result=obj.sub(a, b);
			break;
		case 3:
			result=obj.mult(a, b);
			break;
		case 4:
			result=obj.div(a, b);
			break;

		}
      System.out.println("Result: "+result);
	}while(choice>=1 && choice<=4);
		

	}

}
