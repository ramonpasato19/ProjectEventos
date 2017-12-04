package ups.edu.ec.datos;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;


import ups.edu.ec.modelo.Genero;



@Stateless
public class GeneroDAO {

	@Inject
	private EntityManager em;
	
	public void guardar(Genero gen) {
		Genero aux = leer(gen.getCodigo());
		if(aux!=null){
			actualizar(gen);
		}else {
			insertar(gen);
		}
		
	}
	
public void insertar(Genero gen) {
		
		em.persist(gen);
	}
	
	public void actualizar (Genero gen) {
		
		em.merge(gen);
	}
	
	public Genero leer(int id) {
		
		
		Genero gen = em.find(Genero.class, id);
		
		return gen;
	}
	
	public void borrar (int id) {
		
		Genero gen = leer(id);
		
		em.remove(gen);;
	}

	public List<Genero> listadoGeneros(){
		Query query = em.createQuery("SELECT gen FROM Genero gen", Genero.class);
		List<Genero> listado=query.getResultList();
		return listado;
	}
}

