package ups.edu.ec.controlador;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import ups.edu.ec.datos.CantonDAO;
import ups.edu.ec.modelo.Canton;

@ManagedBean
public class CantonControlador {

	@Inject
	private CantonDAO candao;
	private Canton canton;
	private List<Canton>cantones;
	
	@PostConstruct
	private void init() {
		canton = new Canton();
		loadCantones();

	}
	public CantonDAO getCandao() {
		return candao;
	}
	public void setCandao(CantonDAO candao) {
		this.candao = candao;
	}
	public Canton getCanton() {
		return canton;
	}
	public void setCanton(Canton canton) {
		this.canton = canton;
	}
	public List<Canton> getCantones() {
		return cantones;
	}
	public void setCantones(List<Canton> cantones) {
		this.cantones = cantones;
	}
	
	public void loadCantones() {
		cantones = candao.listadoCantones();
	}
	
	public String loadDatosEditar(int id) {
		System.out.println("Cargando datos de personas a editar" + id);
		canton = candao.leer(id);
		return "crear-canton";
	}
	
	public String guardar() {
		System.out.println(canton);
		candao.guardar(canton);
		loadCantones();
		return "listado-cantones";
	}
	
	public String borrar(int id) {
		candao.borarr(id);
		loadCantones();
		return "listado-cantones";
	}
	
}
