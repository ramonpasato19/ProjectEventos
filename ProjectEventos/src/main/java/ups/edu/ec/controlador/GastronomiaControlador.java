package ups.edu.ec.controlador;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import ups.edu.ec.datos.GastronomiaDAO;
import ups.edu.ec.modelo.Gastronomia;


@ManagedBean
public class GastronomiaControlador {

	@Inject
	private GastronomiaDAO gasdao;
	private Gastronomia gastronomia;
	private List<Gastronomia> gastronomias;
	
	@PostConstruct
	public void init() {
		gastronomia =  new Gastronomia();
		loadGastronomias();
	}
	public GastronomiaDAO getGasdao() {
		return gasdao;
	}
	public void setGasdao(GastronomiaDAO gasdao) {
		this.gasdao = gasdao;
	}
	public Gastronomia getGastronomia() {
		return gastronomia;
	}
	public void setGastronomia(Gastronomia gastronomia) {
		this.gastronomia = gastronomia;
	}
	public List<Gastronomia> getGastronomias() {
		return gastronomias;
	}
	public void setGastronomias(List<Gastronomia> gastronomias) {
		this.gastronomias = gastronomias;
	}
	
	public void  loadGastronomias() {
		gastronomias = gasdao.listadoGastronomias();
	}
	
	public String loadDatosEditar(int id) {
		System.out.println("Cargando datos de personas a editar" + id);
		gastronomia = gasdao.leer(id);
		return "crear-gastronomia";
	}
	
	public String guardar() {
		System.out.println(gastronomia);
		gasdao.guardar(gastronomia);
		loadGastronomias();
		return "listado-gastronomias";
	}
	
	
	
	public String borrar(int id) {
		//System.out.println("Cargando datos de personas a editar" + id);
		gasdao.borrar(id);
		loadGastronomias();
		return "listado-gastronomias";
	}
}
