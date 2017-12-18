package ups.edu.ec.datos;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import ups.edu.ec.modelo.Asistente;

@Stateless
public class AsistenteDAO {
	
	@Inject
	private EntityManager em;
	
	public void guardar(Asistente asi) {
		Asistente aux = leer(asi.getCodigo());
		if(aux!=null){
			actulizar(asi);
		}else {
			insertar(asi);
		}
		
	}
	
	public void insertar (Asistente asi) {
		
		em.persist(asi);
	}
	
	public void actulizar (Asistente asi) {
		
		em.merge(asi);
	}
	
	public Asistente leer(int id) {
		
		Asistente asi = em.find(Asistente.class, id);
		
		return asi;
	}
	
	public void borrar(int id) {
		
		Asistente asi = leer(id);
		
		em.remove(asi);
		
	}
	
	public List<Asistente> listadoAsistentes(){
		Query query = em.createQuery("SELECT asi FROM Asistente asi", Asistente.class);
		List<Asistente> listado=query.getResultList();
		return listado;
	}
	
	public List<Asistente> listadocorreo(){
		Query query = em.createQuery("SELECT asi.asi_email FROM Asistente asi", Asistente.class);
		List<Asistente> listado1=query.getResultList();
		return listado1;
	}
	



}
