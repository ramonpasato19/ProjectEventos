package ups.edu.ec.controlador;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.inject.Inject;

import ups.edu.ec.datos.PersonaDAO;
import ups.edu.ec.modelo.Persona;

@ManagedBean
public class PersonaControlador {
	
	@Inject
	private PersonaDAO perdao;
	private Persona persona;
	private List<Persona> personas;
	
	
	
	@PostConstruct
	public void init() {
		persona = new Persona();
		loadPersonas();
	}



	public PersonaDAO getPerdao() {
		return perdao;
	}



	public void setPerdao(PersonaDAO perdao) {
		this.perdao = perdao;
	}



	public Persona getPersona() {
		return persona;
	}



	public void setPersona(Persona persona) {
		this.persona = persona;
	}



	public List<Persona> getPersonas() {
		return personas;
	}



	public void setPersonas(List<Persona> personas) {
		this.personas = personas;
	}
	
	
	
	public void loadPersonas() {
		personas = perdao.listadoPersonas();
	}
	
	public String loadDatosEditar(int id) {
		System.out.println("Cargando datos de personas a editar" + id);
		persona = perdao.leer(id);
		return "crear-persona";
	}
	
	public String guardar() {
		System.out.println(persona);
		perdao.guardar(persona);
		loadPersonas();
		return "listado-personas";
	}
	
	public String borrar(int id) {
		perdao.borrar(id);
		loadPersonas();
		return "listado-personas";
	}

}
