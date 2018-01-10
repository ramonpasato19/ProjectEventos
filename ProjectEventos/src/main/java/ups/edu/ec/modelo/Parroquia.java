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
public class Parroquia implements Serializable{
	


	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	@Column(name="par_codigo",length=10)
	private int codigo;
	
	@NotNull
	private String nombre;
	
	@NotNull
	private int codigopostal;

	 @OneToMany(cascade= {CascadeType.ALL},fetch=FetchType.EAGER)
	@JoinColumn(name="parroquia",referencedColumnName="par_codigo")
	private List<Sector> sectores=new ArrayList<Sector>();
	
	 public List<Sector> getSectores() {
		return sectores;
	}

	public void setSectores(List<Sector> sectores) {
		this.sectores = sectores;
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

	public int getCodigopostal() {
		return codigopostal;
	}

	public void setCodigopostal(int codigopostal) {
		this.codigopostal = codigopostal;
	}
	
	@Override
	public String toString() {
		return "Parroquia [codigo=" + codigo + ", nombre=" + nombre + ", codigopostal=" + codigopostal + ", sectores="
				+ sectores + "]";
	}

	public void addSector(Sector sector) {
		if (sectores==null)
			sectores= new ArrayList<>();
		sectores.add(sector);
		
	}
	
	

}
