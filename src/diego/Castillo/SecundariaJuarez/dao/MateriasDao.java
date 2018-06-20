/**
 * 
 */
package diego.Castillo.SecundariaJuarez.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import diego.Castillo.SecundariaJuarez.db.ConnectionFactory;
import diego.Castillo.SecundariaJuarez.model.Materias;

/**
 * @author cas_r Diego Castillo
 *
 */
public class MateriasDao {
	/**
	 * Metodo que permite consultar los productos de la base de datos
	 * @param idMateria
	 * @param nombre
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public ArrayList<Materias> mostrarMaterias(String idMateria, String nombre) throws ClassNotFoundException, SQLException{
		
		ConnectionFactory objConnectionFactory = new ConnectionFactory();
		Connection objConeccionOK = objConnectionFactory.conectar();
		
		ArrayList<Materias> listaMaterias = new ArrayList<Materias>();
		
		if(objConeccionOK != null) {
			
			String query = "select * from materias where id_materia like '"+idMateria+"%' and nombre like '"+nombre+"%';";
			
			ResultSet rs = objConnectionFactory.ejecutarConsulta(query);
			
			if(rs != null) {
				
				while(rs.next()) {
					
					Materias objMaterias = new Materias();
					
					objMaterias.setIdMateria(rs.getInt("id_materia"));
					objMaterias.setNombre(rs.getString("nombre"));
					
					listaMaterias.add(objMaterias);
					
				}
				
			}
			
		}
		return listaMaterias;
	}
	
	/**
	 * Metodo que permite agregar materias de la base de datos
	 * @param objMaterias
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public boolean agregarMateria(Materias objMaterias) throws ClassNotFoundException, SQLException {
		
		ConnectionFactory objConnectionFactory = new ConnectionFactory();
		Connection objConeccionOK = objConnectionFactory.conectar();
		
		boolean exitoso = false;
		
		if(objConeccionOK != null) {
			
			String query = "insert into materias (nombre) values ('"+objMaterias.getNombre()+"');";
			
			exitoso = objConnectionFactory.ejecutarSentencia(query);
			
		}
		
		return exitoso;
		
	}
	
	/**
	 * Metodo que permite actualizar materias de la base de datos
	 * @param objMaterias
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public boolean actualizarMateria(Materias objMaterias) throws SQLException, ClassNotFoundException {
		
		ConnectionFactory objConnectionFactory = new ConnectionFactory();
		Connection objConeccionOK = objConnectionFactory.conectar();
		
		boolean exitoso = false;
		
		if(objConeccionOK != null) {
			
			String query = "update materias set nombre = '"+objMaterias.getNombre()+"' where id_materia = "+objMaterias.getIdMateria()+";";
			
			exitoso = objConnectionFactory.ejecutarSentencia(query);
			
		}
		
		return exitoso;
		
	}
	
	/**
	 * Metodo que permite elliminar materias de la base de datos
	 * @param idMateria
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public boolean eliminarMateria(int idMateria) throws ClassNotFoundException, SQLException {
		
		ConnectionFactory objConnectionFactory = new ConnectionFactory();
		Connection objConeccionOK = objConnectionFactory.conectar();
		
		boolean exitoso = false;
		
		if(objConeccionOK != null) {
			
			String query = "delete from materias where id_materia = "+idMateria+";";
			
			exitoso = objConnectionFactory.ejecutarSentencia(query);
			
		}
		
		return exitoso;
		
	}
	
	public ArrayList<Materias> llenarCBX() throws ClassNotFoundException, SQLException{
		
		ConnectionFactory objConnectionFactory = new ConnectionFactory();
		Connection objConeccionOK = objConnectionFactory.conectar();
		
		ArrayList<Materias> listaMaterias = new ArrayList<Materias>();
		if(objConeccionOK != null) {
			
			String query = "select id_materia, nombre from materias;";
			
			ResultSet rs = objConnectionFactory.ejecutarConsulta(query);
			
			
			if(rs != null) {
				
				while(rs.next()) {
					
					Materias objMaterias = new Materias();
					
					objMaterias.setIdMateria(rs.getInt("id_materia"));
					objMaterias.setNombre(rs.getString("nombre"));
					
					listaMaterias.add(objMaterias);
					
				}
				
			}
			
		}
		
		return listaMaterias;
		
	}

}




