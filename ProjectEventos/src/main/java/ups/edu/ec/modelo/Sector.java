package ups.edu.ec.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
public class Sector {
	
	@Id
	@GeneratedValue
	private int codigo;
	
	@NotNull
	@Column(name="sec_nombre", length=10)
	@Size(min=6,max=25)
	private String nombre;
	
	
	
	@NotNull
	@Column(name="sec_direccion", length=10)
	@Size(min=25,max=60)
	private String direccion;



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



	public String getDireccion() {
		return direccion;
	}



	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}



	@Override
	public String toString() {
		return "Sector [codigo=" + codigo + ", nombre=" + nombre + ", direccion=" + direccion + "]";
	}
	
	
	
	

}
