package ups.edu.ec.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import ups.edu.ec.controlador.ParroquiaControlador;

@Entity
public class Evento implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;


	@Id
	@GeneratedValue
	@Column(name="even_codigo", length=10)
	private int codigo;
	
	
	@Temporal(value=TemporalType.DATE)
	@Column(name="eve_fecha")
	private Date fecha;
	
	
	@NotNull
	@Column(name="eve_descripcion", length=10)
	@Size(min=5,max=60)
	private String descripcion;
	
	
	@NotNull
	@Column(name="eve_representante", length=10)
	@Size(min=6,max=25)
	private String representante;
	
	//---------------------------------------------------------------------------------------
	@OneToMany(cascade= {CascadeType.ALL})  //relacion entre Evento y Concurso, cascade tipo de comportamiendo en actualizacion borrado , etc....guaqrde el padre y automaticamente los hijos
	@JoinColumn(name="evento", referencedColumnName="even_codigo") //como relacionan los campos
	private List<Concurso> concursos;  //el evento tiene una lista de concursos
	
	@OneToMany(cascade = {CascadeType.ALL} )
	@JoinColumn(name="evento", referencedColumnName="even_codigo")
	private List<Categoria> categorias;
	
	@OneToMany(cascade= {CascadeType.ALL})
	@JoinColumn(name="evento", referencedColumnName="even_codigo")
	private List<Gastronomia> gastronomias;
	
	//------------------------------------------------
	@ManyToOne(cascade= {CascadeType.ALL})
	@JoinColumn(name="canto")
	private Canton canton;
	
	@ManyToOne(cascade= {CascadeType.ALL})
	@JoinColumn(name="artista")
	private Artista artista;
	
//	@ManyToOne(cascade= {CascadeType.ALL})
//	@JoinColumn(name="artista")
//	private Canton canton;
	//---------------------------------------------------------------------------------------

	
	
	public int getCodigo() {
		return codigo;
	}


	public Artista getArtista() {
		return artista;
	}


	public void setArtista(Artista artista) {
		this.artista = artista;
	}


	public Canton getCanton() {
		return canton;
	}


	public void setCanton(Canton canton) {
		this.canton = canton;
	}


	public static long getSerialversionuid() {
		return serialVersionUID;
	}




	public List<Concurso> getConcursos() {
		return concursos;
	}


	public void setConcursos(List<Concurso> concursos) {
		this.concursos = concursos;
	}


	public List<Categoria> getCategorias() {
		return categorias;
	}


	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}


	public List<Gastronomia> getGastronomias() {
		return gastronomias;
	}


	public void setGastronomias(List<Gastronomia> gastronomias) {
		this.gastronomias = gastronomias;
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
				+ gastronomias + ", canton=" + canton + ", artista=" + artista + "]";
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
	
	
	
	
//	public void removeConcurso(Concurso concurso) {
//		if (concursos==null)
//			concursos= new ArrayList<>();
//		concursos.remove(concurso);
//	}
//	
	
	
	
	//----------------------------------------------------------------
	
	

}
