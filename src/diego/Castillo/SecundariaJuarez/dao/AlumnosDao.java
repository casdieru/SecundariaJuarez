/**
 * 
 */
package diego.Castillo.SecundariaJuarez.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import diego.Castillo.SecundariaJuarez.db.ConnectionFactory;
import diego.Castillo.SecundariaJuarez.model.Alumnos;
import diego.Castillo.SecundariaJuarez.model.Maestros;

/**
 * @author cas_r Diego Castillo
 *
 */
public class AlumnosDao {
	/**
	 * Metodo que permite consultar los productos de la base de datos
	 * @param idAlumno
	 * @param nombre
	 * @param aPaterno
	 * @param aMaterno
	 * @param idMateria
	 * @param idMaestro
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public ArrayList<Alumnos> mostrarAlumnos(String idAlumno, String nombre, String aPaterno, String aMaterno, String idMateria, String idMaestro) throws ClassNotFoundException, SQLException{
		
		ConnectionFactory objConnectionFactory = new ConnectionFactory();
		Connection objConeccionOK = objConnectionFactory.conectar();
		
		ArrayList<Alumnos> listaAlumnos = new ArrayList<Alumnos>();
		
		if(objConeccionOK != null) {
			
			String query = "select * from alumnos where id_alumno like '"+idAlumno+"%' and nombre like '"+nombre+"%' and a_paterno like '"+aPaterno+"%' and "
													+ "a_materno like '"+aMaterno+"%' and id_materia like '"+idMateria+"%' and id_maestro like '"+idMaestro+"%';";
			
			ResultSet rs = objConnectionFactory.ejecutarConsulta(query);
			
			if(rs != null) {
				
				while(rs.next()) {
					
					Alumnos objAlumnos = new Alumnos();
					
					objAlumnos.setIdAlumno(rs.getInt("id_alumno"));
					objAlumnos.setNombre(rs.getString("nombre"));
					objAlumnos.setaPaterno(rs.getString("a_paterno"));
					objAlumnos.setaMaterno(rs.getString("a_materno"));
					objAlumnos.setIdMateria(rs.getInt("id_materia"));
					objAlumnos.setIdMaestro(rs.getInt("id_maestro"));
					
					listaAlumnos.add(objAlumnos);
				}
				
			}
			
		}
		return listaAlumnos;
		
	}
	
	/**
	 * Metodo que permite agregar alumnos de la base de datos
	 * @param objAlumnos
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public boolean agregarAlumno(Alumnos objAlumnos) throws SQLException, ClassNotFoundException {
		
		ConnectionFactory objConnectionFactory = new ConnectionFactory();
		Connection objConeccionOK = objConnectionFactory.conectar();
		
		boolean exitoso = false;
		
		if(objConeccionOK != null) {
			
			String query = "insert into alumnos (nombre, a_paterno, a_materno, id_materia, id_maestro) values ('"+objAlumnos.getNombre()+"', '"+objAlumnos.getaPaterno()+"',"
																		+ " '"+objAlumnos.getaMaterno()+"', "+objAlumnos.getIdMateria()+", "
																				+ " "+objAlumnos.getIdMaestro()+");";
			
			exitoso = objConnectionFactory.ejecutarSentencia(query);
			
		}
		return exitoso;
	}
	
	/**
	 * Metodo que permite actualizar alumnos de la base de datos
	 * @param objAlumnos
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public boolean actualizarAlumno(Alumnos objAlumnos) throws ClassNotFoundException, SQLException {
		
		ConnectionFactory objConnectionFactory = new ConnectionFactory();
		Connection objConeccionOK = objConnectionFactory.conectar();
		
		boolean exitoso = false;
		
		if(objConeccionOK != null) {
			
			String query = "update alumnos set nombre = '"+objAlumnos.getNombre()+"', a_paterno = '"+objAlumnos.getaPaterno()+"', a_materno =  '"+objAlumnos.getaMaterno()+"',"
														+ " id_materia = "+objAlumnos.getIdMateria()+", id_maestro = "+objAlumnos.getIdMaestro()+""
																+ "	where id_alumno = "+objAlumnos.getIdAlumno()+";";
			
			exitoso = objConnectionFactory.ejecutarSentencia(query);
			
		}
		return exitoso;
	}
	
	/**
	 * Metodo que permite eliminar alumnos de la base de datos
	 * @param idAlumno
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public boolean eliminarAlumno(int idAlumno) throws ClassNotFoundException, SQLException {
		
		ConnectionFactory objConnectionFactory = new ConnectionFactory();
		Connection objConeccionOK = objConnectionFactory.conectar();
		
		boolean exitoso = false;
		
		if(objConeccionOK != null) {
			
			String query = "delete from alumnos where id_alumno = "+idAlumno+";";
			
			exitoso = objConnectionFactory.ejecutarSentencia(query);
			
		}
		return exitoso;
		
	}
	
}
