package ups.edu.ec.modelo;

import java.io.Serializable;
import java.util.Date;



import javax.persistence.Column;
import javax.persistence.Entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;



@Entity
public class Evento implements Serializable{

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
	
	@NotNull
	@Column(name="eve_lugar", length=10)
	@Size(min=6,max=25)
	private String lugar;
	
	@NotNull
	@Column(name="eve_hora", length=10)
	@Size(min=6,max=25)
	private String hora;

	@NotNull
	@Column(name="eve_coordenadas", length=10)
	@Size(min=6,max=25)
	private String coordenadas;
	
	@NotNull
	@Column(name="eve_categoria", length=10)
	@Size(min=6,max=25)
	private String categoria;
	
	@NotNull
	@Column(name="eve_concurso", length=10)
	@Size(min=6,max=25)
	private String concurso;

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

	public String getLugar() {
		return lugar;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}

	public String getCoordenadas() {
		return coordenadas;
	}

	public void setCoordenadas(String coordenadas) {
		this.coordenadas = coordenadas;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String categoria) {
		this.categoria = categoria;
	}

	public String getConcurso() {
		return concurso;
	}

	public void setConcurso(String concurso) {
		this.concurso = concurso;
	}

	@Override
	public String toString() {
		return "Evento [codigo=" + codigo + ", fecha=" + fecha + ", descripcion=" + descripcion + ", representante="
				+ representante + ", lugar=" + lugar + ", hora=" + hora + ", coordenadas=" + coordenadas
				+ ", categoria=" + categoria + ", concurso=" + concurso + "]";
	}
	
	
	
	
	
}
