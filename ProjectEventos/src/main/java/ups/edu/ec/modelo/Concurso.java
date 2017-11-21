package ups.edu.ec.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Concurso {
	
	@Id
	private int codigo;
	
	@NotNull
	@Column(name="con_nombre", length=10)
	@Size(min=6,max=25)
	private String nombre;
	
	
	@NotNull
	@Column(name="con_descripcion", length=10)
	@Size(min=25,max=60)
	private String descripcion;


	@Override
	public String toString() {
		return "Concurso [codigo=" + codigo + ", nombre=" + nombre + ", descripcion=" + descripcion + "]";
	}
	
	
	
	

}
