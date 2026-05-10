import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;

public class Server{
	public static void main(String[] args) {
		try {
		CalcImpl obj=new CalcImpl();
		Registry registry=LocateRegistry.createRegistry(2000);
		registry.rebind("CalculatorService",obj);
		System.out.println("Server running...");
		
	}catch(Exception e) {
		e.printStackTrace();
	}
}}