/**
 * 
 */
package diego.Castillo.SecundariaJuarez.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import diego.Castillo.SecundariaJuarez.db.ConnectionFactory;
import diego.Castillo.SecundariaJuarez.model.Maestros;

/**
 * @author cas_r Diego Castillo
 *
 */
public class MaestrosDao {
	/**
	 * Metodo que permite consultar los productos de la base de datos
	 * @param idMaestro
	 * @param nombre
	 * @param aPaterno
	 * @param aMaterno
	 * @param idMateria
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public ArrayList<Maestros> mostrarMaestros(String idMaestro, String nombre, String aPaterno, String aMaterno, String idMateria) throws ClassNotFoundException, SQLException{
		
		ConnectionFactory objConnectionFactory = new ConnectionFactory();
		Connection objConeccionOK = objConnectionFactory.conectar();
		
		ArrayList<Maestros> listaMaestros = new ArrayList<Maestros>();
		
		if(objConeccionOK != null) {
			
			String query = "select * from maestros where id_maestro like '"+idMaestro+"%' and nombre like '"+nombre+"%' and a_paterno like '"+aPaterno+"%' "
							+ "and a_materno like '"+aMaterno+"%' and id_materia like '"+idMateria+"%'";
			
			/**String query = "select maestros.id_maestro, maestros.nombre, maestros.a_paterno, maestros.a_materno, \r\n" + 
					"concat(materias.id_materia, ': ', materias.nombre) materia from  maestros join materias using (id_materia) "
					+ "where id_maestro like '"+idMaestro+"%' and nombre like '"+nombre+"%' and a_paterno like '"+aPaterno+"%'"
							+ " and a_materno like '"+aMaterno+"%' and id_materia like '"+idMateria+"%';";*/
			
			/**String query = "select id_maestro, nombre, concat(a_paterno, ' ', a_materno), id_materia where id_maestro like '"+idMaestro+"%' "
					+ "and nombre like '"+nombre+"%' and a_paterno like '"+aPaterno+"%' and a_materno like '"+aMaterno+"%'"
							+ "and id_materia like '"+idMateria+"%';";*/
			
			ResultSet rs = objConnectionFactory.ejecutarConsulta(query);
			
			if(rs != null) {
				
				while(rs.next()) {
					
					Maestros objMaestros = new Maestros();
					
					objMaestros.setIdMaestro(rs.getInt("id_maestro"));
					objMaestros.setNombre(rs.getString("nombre"));
					objMaestros.setaPaterno(rs.getString("a_paterno"));
					objMaestros.setaMaterno(rs.getString("a_materno"));
					objMaestros.setIdMateria(rs.getInt("id_materia"));
					
					listaMaestros.add(objMaestros);
					
				}
				
			}
			
		}
		return listaMaestros;
		
	}
	
	/**
	 * Metodo que permite agregar maestros de la base de datos
	 * @param objMaestros
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public boolean agregarMaestro(Maestros objMaestros) throws ClassNotFoundException, SQLException {
		
		ConnectionFactory objConnectionFactory = new ConnectionFactory();
		Connection objConeccionOK = objConnectionFactory.conectar();
		
		boolean exitoso = false;
		
		if(objConeccionOK != null) {
			
			String query = "insert into maestros (nombre, a_paterno, a_materno, id_materia) values ('"+objMaestros.getNombre()+"', '"+objMaestros.getaPaterno()+"', "
																					+ "'"+objMaestros.getaMaterno()+"', "+objMaestros.getIdMateria()+" );";
			
			exitoso = objConnectionFactory.ejecutarSentencia(query);
			
		}
		return exitoso;
	}
	
	/**
	 * Metodo que permite actualizar maestros de la base de datos
	 * @param objMaestros
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public boolean actualizarMaestro(Maestros objMaestros) throws SQLException, ClassNotFoundException {
		
		ConnectionFactory objConnectionFactory = new ConnectionFactory();
		Connection objConeccionOK = objConnectionFactory.conectar();
		
		boolean exitoso = false;
		
		if(objConeccionOK != null) {
			
			String query = "update maestros set nombre = '"+objMaestros.getNombre()+"', a_paterno = '"+objMaestros.getaPaterno()+"',"
											+ " a_materno = '"+objMaestros.getaMaterno()+"', id_materia = "+objMaestros.getIdMateria()+" "
													+ " where id_maestro = "+objMaestros.getIdMaestro()+";";
			
			exitoso = objConnectionFactory.ejecutarSentencia(query);
			
		}
		return exitoso;
	}
	
	/**
	 * Metodo que permite eliminar maestros de la base de datos
	 * @param idMaestro
	 * @return
	 * @throws SQLException
	 * @throws ClassNotFoundException
	 */
	public boolean eliminarMaestro(int idMaestro) throws SQLException, ClassNotFoundException {
		
		ConnectionFactory objConnectionFactory = new ConnectionFactory();
		Connection objConeccionOK = objConnectionFactory.conectar();
		
		boolean exitoso = false;
		
		if(objConeccionOK != null) {
			
			String query = "delete from maestros where id_maestro = "+idMaestro+";";
			
			exitoso = objConnectionFactory.ejecutarSentencia(query);
			
		}
		return exitoso;
	}
	
	public ArrayList<Maestros> llenarCBXMaestros(/*int idMateria*/) throws ClassNotFoundException, SQLException{
		
		ConnectionFactory objConnectionFactory = new ConnectionFactory();
		Connection objConeccionOK = objConnectionFactory.conectar();
		
		ArrayList<Maestros> listaMaestros  = new ArrayList<Maestros>();
		
		if(objConeccionOK != null) {
			
			String query = "select id_maestro, nombre, a_paterno, a_materno from maestros;";
			
			// el query esta incompleto ----- String query = "select a.id_Maestro, a.nombre, a.a_paterno, a.a_materno from maestros a join relacion b on a.id_Maestro = b.id_Maestro where b.id_Materia = "+idMateria+";" ;
			
			ResultSet rs = objConnectionFactory.ejecutarConsulta(query);
			
			if(rs != null) {
				
				while(rs.next()) {
					
					Maestros objMaestros = new Maestros();
					
					objMaestros.setIdMaestro(rs.getInt("id_maestro"));
					objMaestros.setNombre(rs.getString("nombre"));
					objMaestros.setaPaterno(rs.getString("a_paterno"));
					objMaestros.setaMaterno(rs.getString("a_materno"));
					
					
					listaMaestros.add(objMaestros);
					
				}
				
			}
			
		}
		return listaMaestros;
	}
	
}







