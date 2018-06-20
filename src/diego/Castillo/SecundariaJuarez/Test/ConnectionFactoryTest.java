package diego.Castillo.SecundariaJuarez.Test;

import static org.junit.Assert.*;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

import diego.Castillo.SecundariaJuarez.db.ConnectionFactory;

public class ConnectionFactoryTest {

	@Test
	public void test() {
		
		ConnectionFactory objConnectionFactory = new ConnectionFactory();
		
		try {
			Connection objConeccionOK = objConnectionFactory.conectar();
			
			if(objConeccionOK != null) {
				System.out.println("Conexion exitosa :)");
		
		} else {
			System.out.println("TABLA");
		}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("Hubo un problema al cargar los datos de conexion");
			e.printStackTrace();
		}
		
		
		
	}

}
