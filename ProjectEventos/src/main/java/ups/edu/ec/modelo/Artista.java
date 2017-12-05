package ups.edu.ec.modelo;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Entity
public class Artista {
	
	
	@Id
	@Column(name="art_codigo", length=10)
	private int codigo;
	
	@NotNull
	private String nombre;
	
	@OneToMany(cascade= {CascadeType.ALL},fetch=FetchType.EAGER)
	@JoinColumn(name="artista",referencedColumnName="art_codigo")
	private List<Genero> generos;
	

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

	
	
	public List<Genero> getGeneros() {
		return generos;
	}

	public void setGeneros(List<Genero> generos) {
		this.generos = generos;
	}

	@Override
	public String toString() {
		return "Artista [codigo=" + codigo + ", nombre=" + nombre + "]";
	}
	
	
	
	public void addGenero(Genero genero) {
		if (generos==null)
			generos= new ArrayList<>();
		generos.add(genero);
		
		
	}
	
	
	
	

}
