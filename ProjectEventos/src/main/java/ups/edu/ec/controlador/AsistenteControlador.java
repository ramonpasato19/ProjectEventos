package ups.edu.ec.controlador;



import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

import ups.edu.ec.datos.AsistenteDAO;
import ups.edu.ec.modelo.Asistente;

@ManagedBean
@SessionScoped
public class AsistenteControlador {
	
	@Inject
	private AsistenteDAO asidao;
	private Asistente asistente;
	private List<Asistente> asistentes;
	private List<Asistente> correos;
	
	
	@PostConstruct
	public void init() {
		asistente =  new Asistente();
		loadAsistentes();
		
	}
	
	public AsistenteDAO getAsidao() {
		return asidao;
	}
	public void setAsidao(AsistenteDAO asidao) {
		this.asidao = asidao;
	}
	public Asistente getAsistente() {
		return asistente;
	}
	public void setAsistente(Asistente asistente) {
		this.asistente = asistente;
	}
	public List<Asistente> getAsistentes() {
		if(asistentes==null)
			loadAsistentes();
		return asistentes;
	}
	public void setAsistentes(List<Asistente> asistentes) {
		this.asistentes = asistentes;
	}
	
	public void leerAsistente(int codigo) {
		asistente=asidao.leer(codigo);
		System.out.println("cargando datos de asistente"+ asistente);
		
	}
	
	public void loadAsistentes() {
		asistentes = asidao.listadoAsistentes();
	}
	public String loadDatosEditar(int id){
		System.out.println("Cargando datos de asistentes a editar" + id);
		asistente = asidao.leer(id);
		return "crear-asistente";
		
	}

	public String guardar() {
		System.out.println(asistente);
		asidao.guardar(asistente);
		loadAsistentes();
		return "listado-asistentes";
		
	}
	
	
	public String borrar(int id) {
		
		asidao.borrar(id);
		loadAsistentes();
		return "listado-asistentes";
	}
}
