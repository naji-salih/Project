package quiz;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Controller
 */
@WebServlet("/Controller")
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	ArrayList<DataFragen> fragen = new ArrayList<DataFragen>();
	
    /**
     * Default constructor. 
     */
    public Controller() {
        
    	fragen.add(new DataFragen("Wie alt ist naji", "16"));
    	fragen.add(new DataFragen("Wie alt ist tenzin", "22"));
    	fragen.add(new DataFragen("Wie alt ist kushal", "15"));
    	fragen.add(new DataFragen("Wie alt ist andrew", "16"));
    	
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	
		HttpSession session = request.getSession();
		
		String benutzer = request.getParameter("benutzer");
		session.setAttribute("benutzer", benutzer);
		
		int i = 0;
		int count = 0;
		
		if(request.getParameter("send") !=  null) {
			i++;
			if(fragen.get(i).getAntwort()==request.getParameter("awnser"))
			{
				++count;
			}
		}
		
		session.setAttribute("Frage", fragen.get(i).getFrage());
		
		RequestDispatcher rd = request.getRequestDispatcher("Fragen.jsp");
		rd.forward(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
