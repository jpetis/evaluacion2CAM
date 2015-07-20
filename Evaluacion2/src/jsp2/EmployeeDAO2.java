package jsp2;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import static jsp2.Querys.*;
import jsp2.Employee;
import jsp2.Recuperable;

public class EmployeeDAO2 implements Recuperable 
{

	Pool gbbdd = null;

	public EmployeeDAO2() {
		gbbdd = Pool.getInstance();
	}

	public Employee obtenerEmpleado(int id) {
		Connection conn = null;
		Employee e = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			conn = gbbdd.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery(GETEMPLOYEEBYID+ id);
			if (rs.next()) {
				e = new Employee(rs.getInt("employee_id"),rs.getInt("department_id"), rs.getString("first_name"),
						rs.getString("last_name"), rs.getInt("salary"));
			}
		} catch (Exception ex) {

		} finally {
			gbbdd.liberarRecursos(conn, st);
		}
		return e;
	}
	
	public List<Employee> obtenerEmpleadosByDepartment(int id) {
		ArrayList<Employee> empleados = new ArrayList<Employee>();
		Connection conn = null;
		Employee e = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			conn = gbbdd.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery(GETEMPLOYEESBYDEPTID
					+ id);
			while (rs.next()) {
				e = new Employee(rs.getInt("employee_id"),rs.getInt("department_id"), rs.getString("first_name"),
						rs.getString("last_name"), rs.getInt("salary"));
				empleados.add(e);
			}
		} catch (Exception ex) {

		} finally {
			gbbdd.liberarRecursos(conn, st);
		}
		return empleados;
	}
	public List<Employee> obtenerEmpleadosByDepartment(String nombre) {
		ArrayList<Employee> empleados = new ArrayList<Employee>();
		Connection conn = null;
		Employee e = null;
		Statement st = null;
		ResultSet rs = null;
		try {
			conn = gbbdd.getConnection();
			st = conn.createStatement();
			rs = st.executeQuery(construirGetEmployeeByDepartmentName(nombre));
			while (rs.next()) {
				e = new Employee(rs.getInt("employee_id"),rs.getInt("department_id"), rs.getString("first_name"),
						rs.getString("last_name"), rs.getInt("salary"));
				empleados.add(e);
			}
		} catch (Exception ex) {
			ex.printStackTrace();

		} finally {
			gbbdd.liberarRecursos(conn, st);
		}
		return empleados;
	}
	
}
