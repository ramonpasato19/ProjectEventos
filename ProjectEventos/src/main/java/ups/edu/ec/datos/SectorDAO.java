package ups.edu.ec.datos;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import ups.edu.ec.modelo.Sector;

@Stateless
public class SectorDAO {
	
	@Inject
	private EntityManager em;
	
	public void guardar(Sector sec) {
		Sector aux = leer(sec.getCodigo());
		if(aux!=null){
			actualizar(sec);
		}else {
			insertar(sec);
		}
		
	}
	public void insertar(Sector sec) {
		
		em.persist(sec);
		
	}
	
	public void actualizar(Sector sec) {
		
		em.merge(sec);
	}
	
	public Sector leer(int id) {
		Sector sec = em.find(Sector.class, id);
		
		return sec;
	}
	
	public void borrar (int id) {
		
		Sector sec = leer(id);
		
		em.remove(sec);
	}

	public List<Sector> listadoSectores(){
		Query query = em.createQuery("SELECT sec FROM Sector sec", Sector.class);
		List<Sector> listado=query.getResultList();
		return listado;
	}

}
