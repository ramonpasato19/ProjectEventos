package ups.edu.ec.datos;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import ups.edu.ec.modelo.Asistente;

@Stateless
public class AsistenteDAO {
	
	@Inject
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
	
	
	public List<Asistente> listadoAsistentes(){
		Query query = em.createQuery("SELECT asi FROM Asistente asi", Asistente.class);
		List<Asistente> listado=query.getResultList();
		return listado;
	}



}
