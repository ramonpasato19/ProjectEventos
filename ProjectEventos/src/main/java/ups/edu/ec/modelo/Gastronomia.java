package ups.edu.ec.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
public class Gastronomia {
	
	@Id
	private int codigo;
	
	
	@NotNull
	@Column(name="gas_descripcion", length=10)
	@Size(min=25,max=60)
	private String descripcion;


	public int getCodigo() {
		return codigo;
	}


	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	@Override
	public String toString() {
		return "Gastronomia [codigo=" + codigo + ", descripcion=" + descripcion + "]";
	}
	

	
	
}
