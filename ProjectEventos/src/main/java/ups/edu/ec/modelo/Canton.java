package ups.edu.ec.modelo;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Canton implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Id
	private int codigo;
	
	
	@NotNull
	@Column(name="can_nombre", length=10)
	@Size(min=6,max=25)
	private String nombre;
	
	//--------------------------------------------------------------

	@OneToMany(cascade= {CascadeType.ALL},fetch=FetchType.EAGER)
	@JoinColumn(name="canton",referencedColumnName="can_codigo")
	private List<Parroquia> parroquias;
	
	@OneToMany(cascade= {CascadeType.ALL})
	@JoinColumn(name="sector", referencedColumnName="can_codigo")
	private List<Sector>sectores;
	
	//--------------------------------------------------------------
	


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
		return "Canton [codigo=" + codigo + ", nombre=" + nombre + ", parroquias=" + parroquias + ", sectores="
				+ sectores + "]";
	}


	//--------------------------------------------------------------
	public void  addParroquia(Parroquia parroquia) {
		if (parroquias==null)
			parroquias=new ArrayList<>();
		parroquias.add(parroquia);
	}
	
	public void addSector(Sector sector) {
		if (sectores==null)
			sectores=new ArrayList<>();
		sectores.add(sector);
			
		
	}
	
	//--------------------------------------------------------------
	

}
