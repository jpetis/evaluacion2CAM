package jsp;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jsp2.Departments;
import jsp2.Employees;
import jsp2.EmployeesDAO;

public class listadoDepartamentos extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public listadoDepartamentos() {

	}

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		/**
		 * Creo una variable de empleado DAP
		 */

		EmployeesDAO emp = new EmployeesDAO();

		/**
		 * Aqui creo una lista de departamentos que guarde todos los
		 * departamentos obtenidos de la variable emp DAO con el metodo que he
		 * creado en EMPLEADODAO obtenerDepartamentos
		 */
		List<Departments> lista = emp.obtenerDepartamentos();

		/**
		 * Ahora voy a mostrar las el contenido de la lista por lineas
		 */

//		Iterator<Departments> it = lista.iterator();
		PrintWriter pw = resp.getWriter();
		Departments dep = null;

//		while (it.hasNext()) {
//
//			dep = it.next();
//
//			// System.out.println(it.next());
//			pw.println(dep.getDepartmentName());
//			pw.flush();
//		}
		/**
		 * insertar en la req la lista de departamentos
		 */
		req.setAttribute("departaments_id", lista);
		req.getRequestDispatcher("selecDepartamento.jsp").forward(req, resp);
	}

}
