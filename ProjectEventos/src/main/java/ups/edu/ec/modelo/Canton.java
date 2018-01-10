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
public class Canton implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue
	@Column(name="can_codigo", length=10)
	private int codigo;
	
	
	@NotNull
	@Column(name="can_nombre", length=10)
	@Size(min=6,max=25)
	private String nombre;
	//--------------------------------------------------------------

//	@OneToMany(cascade= {CascadeType.ALL},fetch=FetchType.EAGER)
	@OneToMany(cascade= {CascadeType.ALL})
	@JoinColumn(name="canton",referencedColumnName="can_codigo")
	private List<Parroquia> parroquias;
	
	
	//--------------------------------------------------------------
	
	
	//--------------------------------------------------------------
	
	
	
	public int getCodigo() {
		return codigo;
	}


	public List<Parroquia> getParroquias() {
		return parroquias;
	}


	public void setParroquias(List<Parroquia> parroquias) {
		this.parroquias = parroquias;
	}


	/*public List<Sector> getSectores() {
		return sectores;
	}


	public void setSectores(List<Sector> sectores) {
		this.sectores = sectores;
	}*/


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
		return "Canton [codigo=" + codigo + ", nombre=" + nombre + ", parroquias=" + parroquias + "]";
	}


	//--------------------------------------------------------------
	public void  addParroquia(Parroquia parroquia) {
		if (parroquias==null)
			parroquias=new ArrayList<>();
		parroquias.add(parroquia);
	}
	
	/*public void addSector(Sector sector) {
		if (sectores==null)
			sectores=new ArrayList<>();
		sectores.add(sector);
			
		
	}*/
	
	//--------------------------------------------------------------

}
