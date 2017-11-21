package ups.edu.ec.datos;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;

import ups.edu.ec.modelo.Asistente;

@Stateless
public class AsistenteDAO {
	
	private EntityManager em;
	
	public void insertar (Asistente a) {
		
		em.persist(a);
	}
	
	public void actulizar (Asistente a) {
		
		em.merge(a);
	}
	
	public Asistente leer(int id) {
		
		Asistente a = em.find(Asistente.class, id);
		
		return a;
	}
	
	public void borrar(int id) {
		
		Asistente a = leer(id);
		
		em.remove(a);
	}

}
