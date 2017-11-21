package ups.edu.ec.modelo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Evento {
	
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
				+ representante + "]";
	}
	
	
	

}
