package ups.edu.ec.datos;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import ups.edu.ec.modelo.Artista;

@Stateless
public class ArtistaDAO {
	
	@Inject
	private EntityManager em;
	
	public void guardar(Artista art) {
		Artista aux = leer(art.getCodigo());
		if(aux!=null){
			actualizar(art);
		}else {
			insertar(art);
		}
		
	}
	
	public void insertar (Artista art) {
		
		em.persist(art);
	}

	public void actualizar(Artista art) {
		
		em.merge(art);
	}
	
	public Artista leer(int id) {
		Artista art = em.find(Artista.class, id);
		
		return art;
	}
	
	public void borrar(int id) {
		
		Artista art =leer(id);
		
		em.remove(art);
		
	}
	
	
	public List<Artista> listadoArtistas(){
		Query query = em.createQuery("SELECT art FROM Artista art", Artista.class);
		List<Artista> listado=query.getResultList();
		return listado;
	}

}
