package ups.edu.ec.controlador;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import ups.edu.ec.datos.GeneroDAO;
import ups.edu.ec.modelo.Genero;



@ManagedBean
public class GeneroControlador {

	
	@Inject
	private GeneroDAO gendao;
	private Genero genero;
	private List<Genero> generos;
	
	@PostConstruct
	public void init() {
	genero = new Genero();
	loadGeneros();
	}

	public GeneroDAO getGendao() {
		return gendao;
	}

	public void setGendao(GeneroDAO gendao) {
		this.gendao = gendao;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}

	public List<Genero> getGeneros() {
		return generos;
	}

	public void setGeneros(List<Genero> generos) {
		this.generos = generos;
	}
	
	
	public void loadGeneros() {

		generos = gendao.listadoGeneros();
	}
	
	
	public String loadDatosEditar(int id){
		System.out.println("Cargando datos de generos a editar" + id);
		genero = gendao.leer(id);
		return "crear-genero";
	}
	
	public String guardar() {
		System.out.println(genero);
		gendao.guardar(genero);
		loadGeneros();		
		return "listado-generos";
		
	}
	
	public String borrar(int id) {
		gendao.borrar(id);
		loadGeneros();
		return "listado-generos";
	}
}

