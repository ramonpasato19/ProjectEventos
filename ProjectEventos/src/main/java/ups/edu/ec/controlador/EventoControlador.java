package ups.edu.ec.controlador;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import javax.inject.Inject;

import org.apache.commons.collections.functors.IdentityPredicate;

import ups.edu.ec.datos.ArtistaDAO;
import ups.edu.ec.datos.CantonDAO;
import ups.edu.ec.datos.EventoDAO;
import ups.edu.ec.modelo.Artista;
import ups.edu.ec.modelo.Asistente;
import ups.edu.ec.modelo.Canton;
import ups.edu.ec.modelo.Categoria;
import ups.edu.ec.modelo.Concurso;
import ups.edu.ec.modelo.Evento;
import ups.edu.ec.modelo.Gastronomia;
import ups.edu.ec.modelo.Parroquia;


@ManagedBean
//@SessionScoped
@ViewScoped
public class EventoControlador {
        @Inject
	private EventoDAO evedao;
        
        @Inject
    private CantonDAO candao;
        
        @Inject  
    private ArtistaDAO artdao;
    
    
	private Evento evento;
	private List<Evento> eventos;
	//------------------------------------------------
	private List<Canton> cantones;
	
	private List<Artista> artistas;
	

	
	private int idCantonSelecionado;
	
	private int idArtistaSeleccionado;
	

	
	//------------------------------------------------
	@PostConstruct
	public void init() {
		evento = new Evento();
		
		
		
		//------------------------------------------------
		//------------------------------------------------
		cantones=new ArrayList<Canton>();
		artistas=new ArrayList<Artista>();
		//------------------------------------------------
		evento.addConcurso(new Concurso());
		evento.addCategoria(new Categoria());
		evento.addGastronomia(new Gastronomia());
		//evento.addAsistente(new Asistente());
		//------------------------------------------------
	}
	
	
	







	public ArtistaDAO getArtdao() {
		return artdao;
	}










	public void setArtdao(ArtistaDAO artdao) {
		this.artdao = artdao;
	}










	public List<Artista> getArtistas() {
		return artistas=artdao.listadoArtistas();
	}





	public void setArtistas(List<Artista> artistas) {
		this.artistas = artistas;
	}





	public int getIdArtistaSeleccionado() {
		return idArtistaSeleccionado;
	}





	public void setIdArtistaSeleccionado(int idArtistaSeleccionado) {
		this.idArtistaSeleccionado = idArtistaSeleccionado;
	}





	public int getIdCantonSelecionado() {
		return idCantonSelecionado;
	}


	public void setIdCantonSelecionado(int idCantonSelecionado) {
		this.idCantonSelecionado = idCantonSelecionado;
	}


	public List<Canton> getCantones() {
		return cantones=candao.listadoCantones();
	}


	public void setCantones(List<Canton> cantones) {
		this.cantones = cantones;
	}


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
		if(eventos==null)
			loadEventos();
		return eventos;
	}
	public void setEventos(List<Evento> eventos) {
		this.eventos = eventos;
	}
	
	public void leerEvento(int codigo) {
		evento=evedao.leer(codigo);
		System.out.println("cargando datos de evento"+ evento);
		
	}
	
	public void loadEventos() {
		
		eventos = evedao.listadoEventos();
	}
	
	public String loadDatosEditar(int id){
		System.out.println("Cargando datos de evento a editar" + id);
		evento = evedao.leer(id);
		return "crear-evento";
	}
	
	
	
	//-----------
	


	
	//-----------
	
	public String guardar() {
		Canton c=null;
		Artista a=null;
		for(Canton canton:cantones) {
			if(canton.getCodigo()==idCantonSelecionado) {
			c=canton;
			break;
			}
		}
		for(Artista artista:artistas) {
			if(artista.getCodigo()==idArtistaSeleccionado) {
				a=artista;
			break;
			}
		}
		evento.setArtista(a);
		//evento.setCanton(c);
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
	
	
	//--------------------------------------------------------------------------------
public String addConcurso() {
		
		evento.addConcurso(new Concurso());
		return null;
	}
	

	public String addCategoria() {
		evento.addCategoria(new Categoria());
		return null;
	}
	
	
	public String addGastronomia() {
		evento.addGastronomia(new Gastronomia());
		return null;
	}
	
	/* public String addAsistente() {
		evento.addAsistente(new Asistente());
		return null; 
		
	}*/
	
//	public String addCanton() {
//		evento.addCanton(new Canton());
//		return null; 
//	}
	
	//--------------------------------------------------------------------------------
}
