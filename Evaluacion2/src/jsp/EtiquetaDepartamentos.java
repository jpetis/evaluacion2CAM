package jsp;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.SimpleTagSupport;

import jsp2.Employee;
import jsp2.EmployeeService;

public class EtiquetaDepartamentos extends SimpleTagSupport {
	// private String depa;
	private int id;

	@Override
	public void doTag() throws JspException, IOException {

		EmployeeService empService = new EmployeeService();
		List<Employee> empleados = empService.getEmployeesByDepartmentName(id);

		for (Employee employee : empleados) {
			getJspContext().getOut().println(employee.getDepartmentId()+"&nbsp;"+"&nbsp;"+"&nbsp;");
			getJspContext().getOut().println(employee.getEmployeeId()+" ");
			getJspContext().getOut().println(employee.getFirstName()+" ");
			getJspContext().getOut().println(employee.getLastName()+" ");
			getJspContext().getOut().println(employee.getSalary()+ "<br>");

		}
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
