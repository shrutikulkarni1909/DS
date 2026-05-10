import org.omg.CORBA.*;
import org.omg.CosNaming.*;
import org.omg.PortableServer.*;

public class StringServer {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		ORB orb=ORB.init(args,null);
		POA poa=POAHelper.narrow(orb.resolve_initial_references("RootPOA"));
		poa.the_POAManager().activate();
		StringReverseImpl obj=new StringReverseImpl();
		org.omg.CORBA.Object ref=poa.servant_to_reference(obj);
		NamingContextExt nc=NamingContextExtHelper.narrow(orb.resolve_initial_references("NameService"));
		nc.rebind(nc.to_name("reverse"),StringReverseHelper.narrow(ref));
		System.out.println("Server is running...");
		orb.run();
		

	}

}
