package ups.edu.ec.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Parroquia {
	
	
	@Id
	private int codigo;
	
	@NotNull
	@Column(name="par_nombre")
	@Size(min=4,max=20)
	private String nombre;
	
	@NotNull
	@Column(name="par_codigo_postal", length=10)
	@Size(max=6)
	private int codigopostal;

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

	public int getCodigopostal() {
		return codigopostal;
	}

	public void setCodigopostal(int codigopostal) {
		this.codigopostal = codigopostal;
	}

	@Override
	public String toString() {
		return "Parroquia [codigo=" + codigo + ", nombre=" + nombre + ", codigopostal=" + codigopostal + "]";
	}
	
	
	

}
