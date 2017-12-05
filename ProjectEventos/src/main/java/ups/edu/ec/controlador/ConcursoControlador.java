package ups.edu.ec.controlador;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

import ups.edu.ec.datos.ConcursoDAO;
import ups.edu.ec.modelo.Concurso;



@ManagedBean
@SessionScoped
public class ConcursoControlador {

	@Inject
	private ConcursoDAO condao;
	private Concurso concurso;
	private List<Concurso> concursos;
	
	
	@PostConstruct
	public void init() {
		
		concurso = new Concurso();
		loadConcursos();
	}


	public ConcursoDAO getCondao() {
		return condao;
	}


	public void setCondao(ConcursoDAO condao) {
		this.condao = condao;
	}


	public Concurso getConcurso() {
		return concurso;
	}


	public void setConcurso(Concurso concurso) {
		this.concurso = concurso;
	}


	public List<Concurso> getConcursos() {
		if(concursos==null)
			loadConcursos();
		return concursos;
	}


	public void setConcursos(List<Concurso> concursos) {
		this.concursos = concursos;
	}
	
	public void leerConcurso(int codigo) {
		concurso=condao.leer(codigo);
		System.out.println("cargando datos de concurso"+ concurso);
		
	}
	
	public void loadConcursos() {
		concursos =  condao.listadoConcursos();
	}
	
	
	public String loadDatosEditar(int id){
		System.out.println("Cargando datos de concurso a editar" + id);
		concurso = condao.leer(id);
		return "crear-concurso";
	}
	
	public String guardar() {
		System.out.println(concurso);
		condao.guardar(concurso);
		loadConcursos();		
		return "listado-concursos";
		
	}
	
	public String borrar(int id) {
		condao.borrar(id);
		loadConcursos();
		return "listado-concursos";
	}
}
