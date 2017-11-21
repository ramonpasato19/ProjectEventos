package ups.edu.ec.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Canton {
	
	@Id
	private int codigo;
	
	
	@NotNull
	@Column(name="can_nombre", length=10)
	@Size(min=6,max=25)
	private String nombre;


	public int getCodigo() {
		return codigo;
	}


	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}


	public String getNombre() {
		return nombre;
	}


	public void setNombre(String nombre) {
		this.nombre = nombre;
	}


	@Override
	public String toString() {
		return "Canton [codigo=" + codigo + ", nombre=" + nombre + "]";
	}
	
	
	

}
