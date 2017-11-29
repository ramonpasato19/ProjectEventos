package ups.edu.ec.controlador;



import java.util.List;

import javax.faces.bean.ManagedBean;

import ups.edu.ec.datos.AsistenteDAO;
import ups.edu.ec.modelo.Asistente;

@ManagedBean
public class AsistenteControlador {
	
private AsistenteDAO asdao;
	private Asistente asistente=null;
	private List<Asistente> asistentes;
	
	public AsistenteDAO getAsdao() {
		return asdao;
	}
	
	public void setAsdao(AsistenteDAO asdao) {
		this.asdao = asdao;
	}
	public Asistente getAsistente() {
		return asistente;
	}
	public void setAsistente(Asistente asistente) {
		this.asistente = asistente;
	}
	public List<Asistente> getAsistentes() {
		return asistentes;
	}
	public void setAsistentes(List<Asistente> asistentes) {
		this.asistentes = asistentes;
	}
	
	
	
	public void loadAsistentes() {
		asistentes = asdao.listadoAsistentes();
	}
	public String loadDatosEditar(int id){
		//System.out.println("Cargando datos de personas a editar" + id);
		System.out.println("Cargando datos de personas a editar" + id);
		asistente=asdao.leer(id);
		
		
		return "crear-asistente";
		
	}

	public String Guardar() {
		System.out.println(asistente);
		
		return null;
		
	}
}
