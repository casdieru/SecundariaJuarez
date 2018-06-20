/**
 * 
 */
package diego.Castillo.SecundariaJuarez.business;

import java.sql.SQLException;
import java.util.ArrayList;

import diego.Castillo.SecundariaJuarez.dao.MateriasDao;
import diego.Castillo.SecundariaJuarez.model.Materias;


/**
 * @author cas_r Diego Castillo
 *
 */
public class MateriasBusiness {
	
	/**
	 * Es un metodo que permite aplicar logica de negocios a la consulta de las Materias
	 * @param idMateria
	 * @param nombre
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public ArrayList<Materias> mostrarMaterias(String idMateria, String nombre) throws ClassNotFoundException, SQLException{
		
		MateriasDao objMateriasDao = new MateriasDao();
		
		ArrayList<Materias> listaMaterias = objMateriasDao.mostrarMaterias(idMateria, nombre);
		
		return listaMaterias;
		
	}
	
	/**
	 * Es un metodo que se encarga de aplicar la logica de negocios para agregar materias
	 * @param objMaterias
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public boolean agregarMateria(Materias objMaterias) throws ClassNotFoundException, SQLException {
		
		MateriasDao objMateriasDao = new MateriasDao();
		
		boolean exitoso = objMateriasDao.agregarMateria(objMaterias);
		
		return exitoso;
		
	}
	
	/**
	 * Metodo que permite realizar la logica de negocios para actualizar materias
	 * @param objMaterias
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public boolean actualizarMateria(Materias objMaterias) throws ClassNotFoundException, SQLException {
		
		MateriasDao objMateriasDao = new MateriasDao();
		
		boolean exitoso = objMateriasDao.actualizarMateria(objMaterias);
		
		return exitoso;
		
	}
	
	/**
	 * Metodo que permite realizar la logica de negocios para eliminar materias
	 * @param idMateria
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public boolean eliminarMateria(int idMateria) throws ClassNotFoundException, SQLException {
		
		MateriasDao objMateriasDao = new MateriasDao();
		
		boolean exitoso = objMateriasDao.eliminarMateria(idMateria);
		
		return exitoso;
	}
	
	/**
	 * Metodo que permite realizar la logica de negocios para concatenar id y nombre de materia
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public ArrayList<String> llenarCBX() throws ClassNotFoundException, SQLException{
		
		MateriasDao objMateriasDao = new MateriasDao();
		
		ArrayList<Materias> listaMaterias = objMateriasDao.llenarCBX();
		ArrayList<String> listaMateriasCbx = new ArrayList<String>(); 
		
		for (Materias materias : listaMaterias) {
			
			String idMateria = String.valueOf(materias.getIdMateria());
			String nombre = materias.getNombre();
			
			listaMateriasCbx.add(idMateria + ": " + nombre);
			
		}
		return listaMateriasCbx;
		
	}

}
