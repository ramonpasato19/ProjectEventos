package ups.edu.ec.datos;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;

import ups.edu.ec.modelo.Sector;

@Stateless
public class SectorDAO {
	
	@Inject
	private EntityManager em;
	
	public void insertar(Sector s) {
		
		em.persist(s);
		
	}
	
	public void actualizar(Sector s) {
		
		em.merge(s);
	}
	
	public Sector leer(int id) {
		Sector s = em.find(Sector.class, id);
		
		return s;
	}
	
	public void borrar (int id) {
		
		Sector s = leer(id);
		
		em.remove(s);
	}
	
	public List<Sector> listadoSectores(){
		Query query = em.createQuery("SELECT sec FROM Sector sec", Sector.class);
		List<Sector> listado=query.getResultList();
		return listado;
	}

}
