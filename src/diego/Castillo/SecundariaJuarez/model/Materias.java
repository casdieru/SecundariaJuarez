/**
 * 
 */
package diego.Castillo.SecundariaJuarez.model;

/**
 * @author cas_r Diego Castillo
 *
 */
public class Materias {
	
	private int idMateria;
	private String nombre;
	
	public Materias() {
		
	}

	/**
	 * @param idMateria
	 * @param nombre
	 */
	public Materias(int idMateria, String nombre) {
		this.idMateria = idMateria;
		this.nombre = nombre;
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
