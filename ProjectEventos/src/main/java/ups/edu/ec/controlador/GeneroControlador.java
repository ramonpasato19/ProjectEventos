package ups.edu.ec.controlador;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

import ups.edu.ec.datos.GeneroDAO;
import ups.edu.ec.modelo.Genero;



@ManagedBean
@SessionScoped
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
		if(generos==null)
			loadGeneros();
		return generos;
	}

	public void setGeneros(List<Genero> generos) {
		this.generos = generos;
	}
	
	public void leerGenero(int codigo) {
		genero=gendao.leer(codigo);
		System.out.println("cargando datos de genero"+ genero);
		
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
		return "index";
		
	}
	
	public String borrar(int id) {
		gendao.borrar(id);
		loadGeneros();
		return "listado-generos";
	}
}

