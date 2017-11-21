package ups.edu.ec.datos;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import ups.edu.ec.modelo.Parroquia;

@Stateless
public class ParroquiaDAO {
	
	@Inject
	private EntityManager em;
	
	public void insertar (Parroquia p) {
		
		em.persist(p);
	}
	
	public void actualisar (Parroquia p) {
		
		em.merge(p);
	}
	
	public Parroquia leer(int id) {
		
		Parroquia p = em.find(Parroquia.class, id);
		
		return p;
	}

	
	public void eliminar(int id) {
		Parroquia p = leer(id);
	
		em.remove(p);
	}


}
