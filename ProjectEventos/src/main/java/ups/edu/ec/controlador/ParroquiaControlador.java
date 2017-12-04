package ups.edu.ec.controlador;



import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import ups.edu.ec.datos.ParroquiaDAO;
import ups.edu.ec.modelo.Parroquia;

@ManagedBean
public class ParroquiaControlador {
	
	@Inject
	private ParroquiaDAO pardao;
	private Parroquia parroquia;
	private List<Parroquia> parroquias;
	
	
	@PostConstruct
	public void init() {
	parroquia = new Parroquia();
	loadParroquias();
	}


	public ParroquiaDAO getPardao() {
		return pardao;
	}


	public void setPardao(ParroquiaDAO pardao) {
		this.pardao = pardao;
	}


	public Parroquia getParroquia() {
		return parroquia;
	}


	public void setParroquia(Parroquia parroquia) {
		this.parroquia = parroquia;
	}


	public List<Parroquia> getParroquias() {
		return parroquias;
	}


	public void setParroquias(List<Parroquia> parroquias) {
		this.parroquias = parroquias;
	}
	
	public void loadParroquias() {
		
		parroquias = pardao.listadoParroquias();	
	}
	public String loadDatosEditar(int id) {
		System.out.println("Cargando datos de personas a editar" + id);
		parroquia = pardao.leer(id);
		return "crear-parroquia";
	}
	
	public String guardar() {
		System.out.println(parroquia);
		pardao.guardar(parroquia);
		loadParroquias();
		return "listado-parroquias";
	}
	

	public String borrar(int id) {
		pardao.eliminar(id);
		loadParroquias();
		return "listado-parroquias";
	}
}
