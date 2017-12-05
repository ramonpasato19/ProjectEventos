package ups.edu.ec.controlador;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.inject.Inject;

import ups.edu.ec.datos.ArtistaDAO;
import ups.edu.ec.modelo.Artista;



@ManagedBean
@SessionScoped
public class ArtistaControlador {
	
	@Inject
	private ArtistaDAO artdao;
	private Artista artista;
	private List<Artista>artistas;
	
	@PostConstruct
	public void init() {
		artista= new Artista();
		loadArtistas();
	}
	
	
	public ArtistaDAO getArtdao() {
		return artdao;
	}
	public void setArtdao(ArtistaDAO artdao) {
		this.artdao = artdao;
	}
	public Artista getArtista() {
		return artista;
	}
	public void setArtista(Artista artista) {
		this.artista = artista;
	}
	public List<Artista> getArtistas() {
		if(artistas==null)
			loadArtistas();
		return artistas;
	}
	public void setArtistas(List<Artista> artistas) {
		this.artistas = artistas;
	}
	
	public void leerArtista(int codigo) {
		artista=artdao.leer(codigo);
		System.out.println("cargando datos de artista"+ artista);
		
	}
	
	public void loadArtistas() {
		artistas = artdao.listadoArtistas();
	}
	
	public String loadDatosEditar(int id) {
		System.out.println("Cargando datos de artistas a editar" + id);
		artista = artdao.leer(id);
		return "crear-artista";
	}
	
	
	public String guardar() {
		System.out.println(artista);
		artdao.guardar(artista);
		loadArtistas();
		return "listado-artistas";
		
	}
	
	public String borrar(int id) {
		artdao.borrar(id);
		loadArtistas();
		return "listado-artistas";
	}
	


}
