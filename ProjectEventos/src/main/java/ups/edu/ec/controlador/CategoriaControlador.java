package ups.edu.ec.controlador;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import ups.edu.ec.datos.CategoriaDAO;
import ups.edu.ec.modelo.Categoria;


@ManagedBean
public class CategoriaControlador {

	@Inject
	private CategoriaDAO catdao;
	private Categoria categoria;
	private List<Categoria> categorias;
	
	@PostConstruct
	public void init() {
	categoria = new Categoria();
	loadCategorias();
	}
	
	
	public CategoriaDAO getCatdao() {
		return catdao;
	}
	public void setCatdao(CategoriaDAO catdao) {
		this.catdao = catdao;
	}
	public Categoria getCategoria() {
		return categoria;
	}
	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	public List<Categoria> getCategorias() {
		return categorias;
	}
	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
	}
	
	
	public void loadCategorias() {
		categorias = catdao.listadoCategorias();
		
	}
	
	public String loadDatosEditar(int id) {
		System.out.println("Cargando datos de personas a editar" + id);
		categoria =  catdao.leer(id);
		return "crear-categoria";
	}
	
	public String guardar() {
		System.out.println(categoria);
		catdao.guardar(categoria);
		loadCategorias();
		return "listado-categorias";
	}
	
}
