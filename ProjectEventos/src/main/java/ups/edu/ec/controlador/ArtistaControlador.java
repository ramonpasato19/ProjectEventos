package ups.edu.ec.controlador;
import java.util.List;

import javax.faces.bean.ManagedBean;

import org.jboss.arquillian.core.api.annotation.Inject;

import ups.edu.ec.datos.ArtistaDAO;
import ups.edu.ec.modelo.Artista;



@ManagedBean
public class ArtistaControlador {
	
	@Inject
	private ArtistaDAO adao;
	private Artista artista=null;
	private List<Artista>artistas;
	
	
	public ArtistaDAO getAdao() {
		return adao;
	}
	public void setAdao(ArtistaDAO adao) {
		this.adao = adao;
	}
	public Artista getArtista() {
		return artista;
	}
	public void setArtista(Artista artista) {
		this.artista = artista;
	}
	public List<Artista> getArtistas() {
		return artistas;
	}
	public void setArtistas(List<Artista> artistas) {
		this.artistas = artistas;
	}
	
	//##################################

	/*public void loadPersonas() {
		artistas = adao.listadoPersonas();
	}
	
	public String loadDatosEditar(int id) {
		System.out.println("Cargando datos de personas a editar" + id);
		persona = pdao.leer(id);
		return "crear-persona";
	}*/
	
	
	public String Guardar() {
		System.out.println(artista);
		
		return null;
		
	}

}
