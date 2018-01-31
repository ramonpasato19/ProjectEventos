package ups.edu.ec.controlador;



import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import ups.edu.ec.datos.ParroquiaDAO;
import ups.edu.ec.modelo.Parroquia;
import ups.edu.ec.modelo.Sector;

@ManagedBean
@ViewScoped
public class ParroquiaControlador {
	
	@Inject
	private ParroquiaDAO pardao;
	private Parroquia parroquia;
	private List<Parroquia>parroquias;
	
	private int id;
	
	
	@PostConstruct
	public void init() {
	parroquia = new Parroquia();
	loadParroquias();
	
	}


	


	public int getId() {
		return id;
	}





	public void setId(int id) {
		this.id = id;
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
		if(parroquias==null)
			loadParroquias();
		return parroquias;
	}


	public void setParroquias(List<Parroquia> parroquias) {
		this.parroquias = parroquias;
	}
	
	public void leerParroquia(int codigo) {
		parroquia=pardao.leer(codigo);
		System.out.println("cargando datos de parroquia"+ parroquia);
		
	}
	public void loadParroquias() {
		
		parroquias = pardao.listadoParroquias();	
	}
	public String loadDatosEditar(int id) {
		System.out.println("Cargando datos de parroquias a editar" + id);
		parroquia = pardao.leer(id);
		return "crear-parroquia";
	}
	
	public String guardar() {
		System.out.println(parroquia);
		//pardao.guardar(parroquia);
		pardao.insertar(parroquia);
		loadParroquias();
		return "listado-parroquias";
	}
	

	public String borrar(int id) {
		pardao.borrar(id);
		loadParroquias();
		return "listado-parroquias";
	}
	
	
	//public String addSector() {
	//parroquia.addSector(new Sector());
	//return null;
	//}
	
}
