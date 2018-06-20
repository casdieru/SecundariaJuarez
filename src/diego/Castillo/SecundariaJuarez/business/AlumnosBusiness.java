/**
 * 
 */
package diego.Castillo.SecundariaJuarez.business;

import java.sql.SQLException;
import java.util.ArrayList;

import diego.Castillo.SecundariaJuarez.dao.AlumnosDao;
import diego.Castillo.SecundariaJuarez.model.Alumnos;

/**
 * @author cas_r Diego Castillo
 *
 */
public class AlumnosBusiness {
	
	/**
	 * Es un metodo que permite aplicar logica de negocios a la consulta de los alumnos
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
		
		AlumnosDao objAlumnosDao = new AlumnosDao();
		
		ArrayList<Alumnos> listaAlumnos = objAlumnosDao.mostrarAlumnos(idAlumno, nombre, aPaterno, aMaterno, idMateria, idMaestro);
		
		return listaAlumnos;
		
	}
	
	/**
	 * Es un metodo que se encarga de aplicar la logica de negocios para agregar alumnos
	 * @param objAlumnos
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public boolean agregarAlumno(Alumnos objAlumnos) throws ClassNotFoundException, SQLException {
		
		AlumnosDao objAlumnosDao = new AlumnosDao();
		
		boolean exitoso = objAlumnosDao.agregarAlumno(objAlumnos);
		
		return exitoso;
		
	}
	
	/**
	 * Metodo que permite realizar la logica de negocios para actualizar alumnos
	 * @param objAlumnos
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public boolean actualizarAlumno(Alumnos objAlumnos) throws ClassNotFoundException, SQLException {
		
		AlumnosDao objAlumnosDao = new AlumnosDao();
		
		boolean exitoso = objAlumnosDao.actualizarAlumno(objAlumnos);
		
		return exitoso;
		
	}
	
	/**
	 * Metodo que permite realizar la logica de negocios para eliminar alumnos
	 * @param idAlumno
	 * @return
	 * @throws ClassNotFoundException
	 * @throws SQLException
	 */
	public boolean eliminarAlumno(int idAlumno) throws ClassNotFoundException, SQLException {
		
		AlumnosDao objAlumnosDao = new AlumnosDao();
		
		boolean exitoso = objAlumnosDao.eliminarAlumno(idAlumno);
		
		return exitoso;
		
	}

}
