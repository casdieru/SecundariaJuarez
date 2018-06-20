/**
 * 
 */
package diego.Castillo.SecundariaJuarez.model;

/**
 * @author cas_r Diego Castillo
 *
 */
public class Alumnos {
	
	private int idAlumno;
	private String nombre;
	private String aPaterno;
	private String aMaterno;
	private int idMateria;
	private int idMaestro;
	
	public Alumnos() {
		
	}

	/**
	 * @param idAlumno
	 * @param aPaterno
	 * @param aMaterno
	 * @param idMateria
	 * @param idMaestro
	 */
	public Alumnos(int idAlumno, String nombre, String aPaterno, String aMaterno, int idMateria, int idMaestro) {
		this.idAlumno = idAlumno;
		this.nombre = nombre;
		this.aPaterno = aPaterno;
		this.aMaterno = aMaterno;
		this.idMateria = idMateria;
		this.idMaestro = idMaestro;
	}

	/**
	 * @return the idAlumno
	 */
	public int getIdAlumno() {
		return idAlumno;
	}

	/**
	 * @param idAlumno the idAlumno to set
	 */
	public void setIdAlumno(int idAlumno) {
		this.idAlumno = idAlumno;
	}

	/**
	 * @return the aPaterno
	 */
	public String getaPaterno() {
		return aPaterno;
	}

	/**
	 * @param aPaterno the aPaterno to set
	 */
	public void setaPaterno(String aPaterno) {
		this.aPaterno = aPaterno;
	}

	/**
	 * @return the aMaterno
	 */
	public String getaMaterno() {
		return aMaterno;
	}

	/**
	 * @param aMaterno the aMaterno to set
	 */
	public void setaMaterno(String aMaterno) {
		this.aMaterno = aMaterno;
	}

	/**
	 * @return the idMateria
	 */
	public int getIdMateria() {
		return idMateria;
	}

	/**
	 * @param idMateria the idMateria to set
	 */
	public void setIdMateria(int idMateria) {
		this.idMateria = idMateria;
	}

	/**
	 * @return the idMaestro
	 */
	public int getIdMaestro() {
		return idMaestro;
	}

	/**
	 * @param idMaestro the idMaestro to set
	 */
	public void setIdMaestro(int idMaestro) {
		this.idMaestro = idMaestro;
	}

	/**
	 * @return the nombre
	 */
	public String getNombre() {
		return nombre;
	}

	/**
	 * @param nombre the nombre to set
	 */
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	

}
