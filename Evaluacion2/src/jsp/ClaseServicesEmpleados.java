package jsp;

import java.util.List;

import jsp2.Departments;
import jsp2.Employees;
import jsp2.EmployeesDAO;

public class ClaseServicesEmpleados 
{
	/**
	 * Creo un objeto de la clase employeesDAO 
	 * para hacer las llamadas a la clase DAO
	 */
	

	EmployeesDAO empDAO;
	
	/**
	 * Hago el constructor de la Clase Services Empleados 	
	 */
	
	public ClaseServicesEmpleados()
	{
		empDAO= new EmployeesDAO();

	}

	/**
	 * Llamada al metodo para hacer el incremento Salario
	 * que devuelvo true o false dependiendo si esta correcto o no
	 *  @return
	 */
	
	public boolean incrementarSalario ()
	{
		
		/**
		 * Creo una variable boolean para que me devuelva el estado de 
		 * 
		 */
		boolean incSal= false;	
		incSal=empDAO.incrementarSalario();
		
		return incSal;
	}
	
	/**
	 * Llamada al metodo para obtener el maximo salario de todos los departamentos
	 * @return
	 */
	
	public List<Employees> obtenerMaximoSalario()
	{
		List<Employees> listE= null;
		
		listE= empDAO.obtenerMaximoSalario();
		
		return listE ;	
		}

	/**
	 * Llamada metodo para obtener todos los empleados por el departamento indicado
	 * @param dep
	 * @return
	 */
	public List<Employees> obtenerEmpleadosporDepartamento(Departments dep)
	{
		List<Employees> listD= null;
		
		listD= empDAO.obtenerEmpleadosporDepartamento(dep);
		
		return listD ;
	}
	
	/**
	 * Llamada al metodo para obtener  todos los empleados  de la bbdd
	 * @return
	 */
	
	public List<Employees> obtenerTodosEmpleados()
	{
		/**
		 * Creo una lista donde voy a guardar los datos recuperados 
		 * de los empleados
		 */
		
		List<Employees> listEm= null;
		
		/**
		 * Aqui es donde asigno el valor que me devuelve el metodo
		 * a la lista de empleados 
		 */
		
		listEm=empDAO.recuperarEmpleadosBBDD();
		
		/**
		 * Devuelvo la variable listEm con el resultado de la consulta
		 * de recuperarEmpleados
		 */
		
		return listEm;
	}
	
	
}
