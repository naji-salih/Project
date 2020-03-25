package employees;

import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class EmployeeServlet
 */
@WebServlet("/EmployeeList.html")
public class EmployeeServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	EmployeeService employeeService = new EmployeeService();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmployeeServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		String action = request.getParameter("searchAction");
        if (action!=null){
            switch (action) {           
            case "searchById":
                searchEmployeeById(request, response);
                break;           
            case "searchByName":
                searchEmployeeByName(request, response);
                break;
            }
        }else{
            List<Employee> result = employeeService.getAllEmployees();
            forwardListEmployees(request, response, result);
        }
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private void searchEmployeeById(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		long idEmployee = Integer.valueOf(req.getParameter("idEmployee"));
		Employee employee = null;
		try {
			employee = employeeService.getEmployee(idEmployee);
		} catch (Exception ex) {
			Logger.getLogger(EmployeeServlet.class.getName()).log(Level.SEVERE, null, ex);
		}
		req.setAttribute("employee", employee);
		req.setAttribute("action", "edit");
		String nextJSP = "/WebApp/list-employees.jsp";
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
		dispatcher.forward(req, resp);
	}

	private void searchEmployeeByName(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		String employeeName = req.getParameter("employeeName");
		List<Employee> result = employeeService.searchEmployeesByName(employeeName);
		forwardListEmployees(req, resp, result);
	}

	private void forwardListEmployees(HttpServletRequest req, HttpServletResponse resp, List<Employee> employeeList)
			throws ServletException, IOException {
		String nextJSP = "/WebApp/list-employees.jsp";
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(nextJSP);
		req.setAttribute("employeeList", employeeList);
		dispatcher.forward(req, resp);
	}

}
