/**
 * 
 */
package diego.Castillo.SecundariaJuarez.model;

/**
 * @author cas_r Diego Castillo
 *
 */
public class Maestros {
	
	private int idMaestro;
	private String nombre;
	private String aPaterno;
	private String aMaterno;
	private int idMateria;
	
	public Maestros() {
		
	}

	/**
	 * @param idMaestro
	 * @param aPaterno
	 * @param aMaterno
	 * @param idMateria
	 */
	public Maestros(int idMaestro, String nombre, String aPaterno, String aMaterno, int idMateria) {
		this.idMaestro = idMaestro;
		this.nombre = nombre;
		this.aPaterno = aPaterno;
		this.aMaterno = aMaterno;
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
