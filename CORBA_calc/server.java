import org.omg.CORBA.*;
import org.omg.CosNaming.*;
import org.omg.PortableServer.*;
public class server {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		
		ORB orb=ORB.init(args,null);
		POA poa=POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
		poa.the_POAManager().activate();
		CalculatorImpl obj=new CalculatorImpl();
		org.omg.CORBA.Object ref=poa.servant_to_reference(obj);
		NamingContextExt nc = NamingContextExtHelper.narrow(orb.resolve_initial_references("NameService"));
		nc.rebind(nc.to_name("calculate"),CalculatorHelper.narrow(ref));
		System.out.println("Server is running");
		orb.run();
	
	}

}
