package ups.edu.ec.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
public class Sector implements Serializable{
	
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name="sec_codigo",length=10)
	private int codigo;
	
	@NotNull
	private String nombre;
	
	
	@NotNull
	private String direccion;

	@OneToMany(cascade= {CascadeType.ALL},fetch=FetchType.EAGER)
	@JoinColumn(name="sector",referencedColumnName="sec_codigo")
	private List<Parroquia> parroquias=new ArrayList<Parroquia>();
	

	
	public List<Parroquia> getParroquias() {
		return parroquias;
	}



	public void setParroquias(List<Parroquia> parroquias) {
		this.parroquias = parroquias;
	}



	public static long getSerialversionuid() {
		return serialVersionUID;
	}



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
		return "Sector [codigo=" + codigo + ", nombre=" + nombre + ", direccion=" + direccion + ", parroquias="
				+ parroquias + "]";
	}


	public void addParroquia(Parroquia parroquia) {
		if (parroquias==null)
			parroquias= new ArrayList<>();
		parroquias.add(parroquia);
		
	}



	
	
	
	

}