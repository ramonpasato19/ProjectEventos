package ups.edu.ec.datos;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import org.ietf.jgss.GSSContext;

import ups.edu.ec.modelo.Gastronomia;

@Stateless
public class GastronomiaDAO {
	
	@Inject
	private EntityManager em;
	
	public void insertar(Gastronomia g) {
		
		em.persist(g);
	}
	
	public void actualizar (Gastronomia g) {
		
		em.merge(g);
	}
	
	public Gastronomia leer(int id) {
		
		Gastronomia g = em.find(Gastronomia.class, id);
		
		return g;
	}
	
	public void borrar (int id) {
		
		Gastronomia g = leer(id);
		
		em.remove(g);
	}
	

}
