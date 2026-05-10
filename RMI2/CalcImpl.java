import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class CalcImpl extends UnicastRemoteObject implements Calculator{
	protected CalcImpl() throws RemoteException{
		super();
	}
	
	public double add(double a, double b)throws RemoteException{
		return a+b;
	}
	
	public double sub(double a, double b)throws RemoteException{
		return a-b;
	}
	
	public double multiply(double a, double b)throws RemoteException{
		return a*b;
	}
	
	public double div(double a, double b)throws RemoteException{
		if(b==0) {
			throw new ArithmeticException("Division by o not possible");
		}
		return a/b;
	}
}