package ups.edu.ec.controlador;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import ups.edu.ec.datos.CantonDAO;
import ups.edu.ec.modelo.Canton;
import ups.edu.ec.modelo.Parroquia;
import ups.edu.ec.modelo.Sector;

@ManagedBean
//@SessionScoped
@ViewScoped
public class CantonControlador {

	@Inject
	private CantonDAO candao;
	private Canton canton;
	private List<Canton>cantones;
	
	@PostConstruct
	private void init() {
		canton = new Canton();
		//---------------------------------------
		canton.addParroquia(new Parroquia());
		canton.addSector(new Sector());
		//---------------------------------------
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
		if(cantones==null)
			loadCantones();
		return cantones;
	}
	public void setCantones(List<Canton> cantones) {
		this.cantones = cantones;
	}
	
	
	public void leerCanton(int codigo) {
		canton=candao.leer(codigo);
		System.out.println("cargando datos de canton"+ canton);
		
	}
	public void loadCantones() {
		cantones = candao.listadoCantones();
	}
	
	public String loadDatosEditar(int id) {
		System.out.println("Cargando datos de caton a editar" + id);
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
		candao.borrar(id);
		loadCantones();
		return "listado-cantones";
	}
	
	//---------------------------------------
	public String addParroquia() {
			
			canton.addParroquia(new Parroquia());
			return null;
		}
		
		public String addSector() {
			canton.addSector(new Sector());
			return null;
		}
	//---------------------------------------
}
