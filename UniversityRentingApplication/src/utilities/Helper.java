package utilities;

public class Helper {
	public static boolean isFloat(String number)
	{
		boolean isFloat = true;
		try{
	        Float.parseFloat(number);
	    }catch(NumberFormatException e){
	        isFloat = false;
	    }
		return isFloat;
	}
	
	public static boolean isInteger(String number)
	{
		boolean isInteger = true;
		try{
	        Integer.parseInt(number);
	    }catch(NumberFormatException e){
	        isInteger = false;
	    }
		return isInteger;
	}
	
	
	public static boolean isLong(String number)
	{
		boolean isLong = true;
		try{
	        Long.parseLong(number);
	    }catch(NumberFormatException e){
	        isLong = false;
	    }
		
		return isLong;
	}
	public static String sanitize(String s) {
		if(s != null) {
			return s.replace("&", "&amp;").replace("<", "&lt;")
	                .replace(">", "&gt;").replace("\"", "&quot;");
		}
        return s;
    }
	
}
