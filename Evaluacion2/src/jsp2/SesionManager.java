package jsp2;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

public class SesionManager 
{
/**
 * Clase de conexion a la base de datos
 */
	
	static {
		
		Configuration configuration = new Configuration().configure();
    	StandardServiceRegistryBuilder builder = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties());
    	sesion_factory = configuration.buildSessionFactory(builder.build());
		
	}
	
	private static SessionFactory sesion_factory;
	
	
	private SesionManager (){}
	
	public static SessionFactory getSessionFactory ()
	{
		return sesion_factory;
	}
	
	public static void cerrarSessionFactory(){
		sesion_factory.close();
	}
	
	public static Session obtenerSesionNueva ()
	{
		return sesion_factory.openSession();
	}
	
	
	public static void cerrarSession (Session sesion)
	{
		sesion.close();
	}
	
	

}
