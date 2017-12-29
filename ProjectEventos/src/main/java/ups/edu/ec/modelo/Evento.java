package ups.edu.ec.modelo;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Evento implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Id
	private int codigo;
	
	
	@Temporal(value=TemporalType.DATE)
	@Column(name="eve_fecha")
	private Date fecha;
	
	
	@NotNull
	@Column(name="eve_descripcion", length=10)
	@Size(min=25,max=60)
	private String descripcion;
	
	
	@NotNull
	@Column(name="eve_representante", length=10)
	@Size(min=6,max=25)
	private String representante;
	
	
//---------------------------------------------------------------------------------------
	@OneToMany(cascade= {CascadeType.ALL}, fetch = FetchType.EAGER)  //relacion entre Evento y Concurso, cascade tipo de comportamiendo en actualizacion borrado , etc....guaqrde el padre y automaticamente los hijos
	@JoinColumn(name="evento", referencedColumnName="even_codigo") //como relacionan los campos
	private List<Concurso> concursos;  //el evento tiene una lista de concursos
	
	@OneToMany(cascade = {CascadeType.ALL}, fetch = FetchType.LAZY)
	@JoinColumn(name="evento", referencedColumnName="even_codigo")
	private List<Categoria> categorias;
	
	@OneToMany(cascade= {CascadeType.ALL}, fetch= FetchType.LAZY)
	@JoinColumn(name="evento", referencedColumnName="even_codigo")
	private List<Gastronomia> gastronomias;
	
	@OneToMany(cascade= {CascadeType.ALL}, fetch=FetchType.LAZY)
	@JoinColumn(name="evento", referencedColumnName="even_codigo")
	private List<Asistente> asistentes;

//---------------------------------------------------------------------------------------



	public int getCodigo() {
		return codigo;
	}


	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}


	public Date getFecha() {
		return fecha;
	}


	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}


	public String getDescripcion() {
		return descripcion;
	}


	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}


	public String getRepresentante() {
		return representante;
	}


	public void setRepresentante(String representante) {
		this.representante = representante;
	}


	@Override
	public String toString() {
		return "Evento [codigo=" + codigo + ", fecha=" + fecha + ", descripcion=" + descripcion + ", representante="
				+ representante + ", concursos=" + concursos + ", categorias=" + categorias + ", gastronomias="
				+ gastronomias + ", asistentes=" + asistentes + "]";
	}
	
	
	//----------------------------------------------------------------
	public void addConcurso(Concurso concurso) {
		if (concursos==null)
			concursos= new ArrayList<>();
		concursos.add(concurso);
	}
	
	public void addCategoria(Categoria categoria) {
		if(categorias==null)
			categorias= new ArrayList<>();
		categorias.add(categoria);
	}
	
	public void addGastronomia(Gastronomia gastronomia) {
		if (gastronomias==null)
			gastronomias= new ArrayList<>();
		gastronomias.add(gastronomia);
	}
	
	public void addAsistente(Asistente asistente) {
		if (asistentes==null)
			asistentes=new ArrayList<>();
		asistentes.add(asistente);
	}
	
	
	public void removeConcurso(Concurso concurso) {
		if (concursos==null)
			concursos= new ArrayList<>();
		concursos.remove(concurso);
	}
	
	//----------------------------------------------------------------
	

}
