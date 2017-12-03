package ups.edu.ec.datos;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import ups.edu.ec.modelo.Canton;

@Stateless
public class CantonDAO {
	
	@Inject
	private EntityManager em;
	
	public void insertar(Canton c) {
		
		em.persist(c);
	}
	
	public void actualizar(Canton c) {
		
		em.merge(c);
		
	}
	
	public Canton leer(int id) {
		
		Canton c = em.find(Canton.class, id);
		
		return c;
		
	}
	
	public void borarr(int id) {
		
		Canton c = leer(id);
		
		em.remove(c);
		
	}
	
	public List<Artista> listadoCantones(){
		Query query = em.createQuery("SELECT can FROM Canton can", Canton.class);
		List<Artista> listado=query.getResultList();
		return listado;
		
		
	}

}
