/**
 * 
 */
package diego.Castillo.SecundariaJuarez.business;

import java.sql.SQLException;
import java.util.ArrayList;

import diego.Castillo.SecundariaJuarez.dao.MaestrosDao;
import diego.Castillo.SecundariaJuarez.model.Maestros;

/**
 * @author cas_r Diego Castillo
 *
 */
public class MaestrosBusiness {
	
	/**
	 * Es un metodo que permite aplicar logica de negocios a la consulta de los maestros
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
	
	MaestrosDao objMaestrosDao = new MaestrosDao();
	
	ArrayList<Maestros> listaMaestros = objMaestrosDao.mostrarMaestros(idMaestro, nombre, aPaterno, aMaterno, idMateria);
	
	return listaMaestros;
	
	}
	
	/**
	 * Es un metodo que se encarga de aplicar la logica de negocios para agregar maestros
	 * @param objMaestros
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public boolean agregarMaestro(Maestros objMaestros) throws ClassNotFoundException, SQLException {
		
		MaestrosDao objMaestrosDao = new MaestrosDao();
		
		boolean exitoso = objMaestrosDao.agregarMaestro(objMaestros);
		
		return exitoso;
		
	}
	
	/**
	 * Metodo que permite realizar la logica de negocios para actualizar maestros
	 * @param objMaestros
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public boolean actualizarMaestro(Maestros objMaestros) throws ClassNotFoundException, SQLException {
		
		MaestrosDao objMaestrosDao = new MaestrosDao();
	
		boolean exitoso = objMaestrosDao.actualizarMaestro(objMaestros);
		
		return exitoso;
		
	}
	
	/**
	 * Metodo que permite realizar la logica de negocios para eliminar maestros
	 * @param idMaestro
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public boolean eliminarMaestro(int idMaestro) throws ClassNotFoundException, SQLException {
		
		MaestrosDao objMaestrosDao = new MaestrosDao();
		
		boolean exitoso = objMaestrosDao.eliminarMaestro(idMaestro);
		
		return exitoso;
		
	}
	
	/**
	 * Metodo que permite realizar la logica de negocios para concatenar id y nombre completo del profesor
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public ArrayList<String> llenarCBXMaestros() throws ClassNotFoundException, SQLException{
		
		MaestrosDao objMaestrosDao = new MaestrosDao();
		
		ArrayList<Maestros> listaMaestros = objMaestrosDao.llenarCBXMaestros();
		ArrayList<String> listaMaestrosCbx = new ArrayList<String>();
		
		for (Maestros maestros : listaMaestros) {
			
			String idMaestro = String.valueOf(maestros.getIdMaestro());
			String nombre = maestros.getNombre();
			String aPaterno = maestros.getaPaterno();
			String aMaterno = maestros.getaMaterno();
			
			
			listaMaestrosCbx.add(idMaestro + ": " + nombre + " " + aPaterno + " " + aMaterno);
			
		}
		return listaMaestrosCbx;
	}
	

}
















