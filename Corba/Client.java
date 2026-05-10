import org.omg.CORBA.*;
import org.omg.CosNaming.*;
import java.util.*;

public class Client {

	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		ORB orb=ORB.init(args,null);
		NamingContextExt nc=NamingContextExtHelper.narrow(orb.resolve_initial_references("NameService"));
		StringReverse obj=StringReverseHelper.narrow(nc.resolve_str("reverse"));
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a string");
		String str=sc.nextLine();
		String result=obj.reverseString(str);
		System.out.println("Reversed String: "+result);

	}

}
