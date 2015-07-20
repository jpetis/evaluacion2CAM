package jsp2;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;

public class EmployeesDAO 
{
	Session sesion;
	
	/**
	 * Metodo por el cual recupero todos 
	 * los empleados de la base de datos
	 * 
	 */
	
	public List<Employees> recuperarEmpleadosBBDD()
	{
		List<Employees> listE = null;
		
		this.sesion = SesionManager.obtenerSesionNueva();
		
		listE=sesion.createSQLQuery("SELECT * FROM EMPLOYEES").addEntity(Employees.class).list(); 
		
		SesionManager.cerrarSession(sesion);
		
		return listE;
	}
/**
 * Metodo por el cual obtengo el maximo salario  del empleado
 * de cada departamento 
 *
 */
	public List<Employees> obtenerMaximoSalario()
	{
		List<Employees> listE2 = null;
		
		this.sesion = SesionManager.obtenerSesionNueva();
		
		listE2=sesion.createSQLQuery("SELECT * FROM EMPLOYEES WHERE (SALARY, DEPARTMENT_ID) IN (SELECT MAX(salary), department_id FROM EMPLOYEES GROUP BY DEPARTMENT_ID)").addEntity(Employees.class).list(); 
		
		SesionManager.cerrarSession(sesion);
		
		return listE2;
	}
	
	/**
	 * Metodo por el cual hago el incremento de salario al departamento
	 * de ventas
	 * 
	 */
	public boolean incrementarSalario()
	{
		boolean iS= false;
		
		List<Employees> listE3 = null;
		
		this.sesion = SesionManager.obtenerSesionNueva();
		
		listE3=sesion.createSQLQuery("SELECT * FROM EMPLOYEES WHERE DEPARTMENT_ID =(SELECT DEPARTMENT_ID FROM DEPARTMENTS WHERE DEPARTMENT_NAME like 'Sales')").addEntity(Employees.class).list(); 
		
		Iterator<Employees> itEmplo = listE3.iterator();
		
		Employees employees =null;
		
		BigDecimal numero_salary = new BigDecimal("0");
		
		BigDecimal incremento = new BigDecimal("1.2");
		

		while(itEmplo.hasNext())
		{
		
			employees=itEmplo.next();
			//numero_salary= employees.getSalary().divide(incremento,RoundingMode.HALF_UP);
			numero_salary= employees.getSalary().multiply(incremento);
			//.divide
			//multiply

			employees.setSalary(numero_salary);
			//Salvo la sesion y actualizo
			//session.saveOrUpdate(employees);
			System.out.println(employees);
			
		}
		
		SesionManager.cerrarSession(sesion);
		
		return iS=true;
		
	}
/**
 * Metodo con el cual estoy obteniendo los empleados de un departamento
 * cuando me pasan por el metodo el departamento que quiero 
 * 
 */
	public List<Employees> obtenerEmpleadosporDepartamento(Departments dep)
	{
		List<Departments> listE3 = null;
		
		List<Employees> listE4 = null;
		
		Employees e= null;
		
		Departments d=null;
		
		this.sesion = SesionManager.obtenerSesionNueva();
		
		listE3=sesion.createSQLQuery("SELECT * FROM DEPARTMENTS").addEntity(Departments.class).list(); 
		
		Iterator<Departments> itEMP = listE3.iterator();
		
		while (itEMP.hasNext()) 
		{
			d = itEMP.next();				
		
			//System.out.println("El nombre del Departamento es "+ d.getDepartmentName());
			if(d.getDepartmentId() == dep.getDepartmentId())
			listE4= new ArrayList<>(d.getEmployeeses());
		}

		
		SesionManager.cerrarSession(sesion);
		
		return listE4;
	}
	
	public List<Departments> obtenerDepartamentos()
	{
		List<Departments> listD = null;
		
		this.sesion = SesionManager.obtenerSesionNueva();
		
		listD=sesion.createSQLQuery("SELECT * FROM DEPARTMENTS").addEntity(Departments.class).list(); 
		
		SesionManager.cerrarSession(sesion);
		//System.out.println(listD);
		return listD;
	}
	

}
