import org.omg.CORBA.*;
import org.omg.CosNaming.*;
import org.omg.PortableServer.*;

public class CalculatorImpl extends CalculatorPOA{
	
	public double add(double a, double b) {
		return a+b;
	}
	
	public double sub(double a, double b) {
		return a-b;
	}
	
	public double mult(double a,double b) {
		return a*b;
	}
	
	public double div(double a,double b) {
		if(b==0) {
			throw new ArithmeticException("Division by 0 not possible");
		}
		return a/b;
	}
	

}
