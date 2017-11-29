package ups.edu.ec.datos;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import ec.edu.ups.appdis.crudpersona.modelo.Persona;
import ups.edu.ec.modelo.Artista;

@Stateless
public class ArtistaDAO {
	
	@Inject
	private EntityManager em;
	
	public void insertar (Artista a) {
		
		em.persist(a);
	}
	
	public void actualizar(Artista a) {
		
		em.merge(a);
	}
	
	public Artista leer(int id) {
		Artista a = em.find(Artista.class, id);
		
		return a;
	}
	
	public void borrar(int id) {
		
		Artista a =leer(id);
		
		em.remove(a);
		
	}
	
	public List<Artista> listadoArtistas(){
		Query query = em.createQuery("SELECT p FROM Persona p", Artista.class);
		List<Artista> listado=query.getResultList();
		return listado;
	}

}
