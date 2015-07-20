package jsp2;

import java.util.List;

import jsp2.Employee;

public class EmployeeService
{

	EmployeeDAO2 dao = null;
	public EmployeeService() {
		dao = new EmployeeDAO2();
	}
	
	public Employee obtenerEmpleado(int empId){		
		return dao.obtenerEmpleado(empId);
	}
	public List<Employee> getEmployeesByDepartmentName(String name) {
		return dao.obtenerEmpleadosByDepartment(name);
	}
	public List<Employee> getEmployeesByDepartmentName(int id) {
		return dao.obtenerEmpleadosByDepartment(id);
	}
	
}
