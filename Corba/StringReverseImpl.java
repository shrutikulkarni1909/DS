public class StringReverseImpl extends StringReversePOA{
	
	public String reverseString(String str) {
		String rev="";
		for(int i=str.length()-1;i>=0;i--) {
			rev=rev+str.charAt(i);
		}
		return rev;
	}

	
}
