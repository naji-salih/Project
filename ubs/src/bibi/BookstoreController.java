package bibi;

import javax.servlet.http.HttpServletRequest;

public class BookstoreController {
	
protected static String check(String arg, HttpServletRequest request) {
		
		String foo = request.getParameter(arg);
		if(foo != null) {
			return foo;
		} else {
			return "";
		}
		
	}
}
