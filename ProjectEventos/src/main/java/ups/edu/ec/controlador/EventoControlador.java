package ups.edu.ec.controlador;

import java.util.List;

import javax.faces.bean.ManagedBean;


import ups.edu.ec.datos.EventoDAO;
import ups.edu.ec.modelo.Evento;


@ManagedBean
public class EventoControlador {

	private EventoDAO evedao;
	private Evento evento;
	private List<Evento> eventos;
	
	
	public EventoDAO getEvedao() {
		return evedao;
	}
	public void setEvedao(EventoDAO evedao) {
		this.evedao = evedao;
	}
	public Evento getEvento() {
		return evento;
	}
	public void setEvento(Evento evento) {
		this.evento = evento;
	}
	public List<Evento> getEventos() {
		return eventos;
	}
	public void setEventos(List<Evento> eventos) {
		this.eventos = eventos;
	}
	
	public void loadEventos() {
		
		eventos = evedao.listadoEventos();
	}
	
	public String loadDatosEditar(int id){
		System.out.println("Cargando datos de personas a editar" + id);
		evento = evedao.leer(id);
		return "crear-evento";
	}
	
	public String guardar() {
		System.out.println(evento);
		evedao.guardar(evento);
		loadEventos();		
		return "listado-eventos";
		
	}
	
	public String borrar(int id) {
		evedao.borrar(id);
		loadEventos();
		return "listado-eventos";
	}
	
}
