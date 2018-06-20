/**
 * 
 */
package diego.Castillo.SecundariaJuarez.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * @author cas_r Diego Castillo
 *
 */
public class ConnectionFactory {
	
	private Connection objConnection;
	private Statement objStatement;
	
	public Connection conectar() throws ClassNotFoundException, SQLException {
		
		Class.forName("com.mysql.jdbc.Driver");
		
		String url = "jdbc:mysql://localhost:3306/SecundariaJuarez";
		String user = "root";
		String password = "123456";
		
		objConnection = DriverManager.getConnection(url, user, password);
		objStatement = objConnection.createStatement();
		
		return objConnection;
		
	}
	
	public boolean ejecutarSentencia(String query) throws SQLException {
		
		System.out.println(query);
		
		//Esta es la linea de codigo encargada de ejecutar el query
		objStatement.execute(query);
		
		return true;
		
	}
	
	public ResultSet ejecutarConsulta(String query) throws SQLException {
		
		System.out.println(query);
		
		ResultSet rs = objStatement.executeQuery(query);
		
		return rs;
		
	}

}



