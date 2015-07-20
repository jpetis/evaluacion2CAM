package jsp;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jsp2.Departments;
import jsp2.Employee;
import jsp2.EmployeeService;
import jsp2.Employees;
import jsp2.EmployeesDAO;

/**
 * Servlet implementation class listarEmpleados
 */

public class listarEmpleados extends HttpServlet 
{
	private static final long serialVersionUID = 1L;
       
    public listarEmpleados() 
    {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp)
    		throws ServletException, IOException 
    {
    	EmployeeService empService = new EmployeeService();
		
    	String departamento = (String)req.getParameter("departamento");
		
    	List<Employee> empleados = (ArrayList<Employee>) empService.getEmployeesByDepartmentName(departamento);
		
    	req.setAttribute("empleados", empleados);
    	System.out.println(empleados);
    	req.getRequestDispatcher("listarEmpleados.jsp").forward(req, resp);

    }
    	
}
