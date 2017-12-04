package ups.edu.ec.datos;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import ups.edu.ec.modelo.Concurso;
import ups.edu.ec.modelo.Evento;


@Stateless
public class ConcursoDAO {

	@Inject
	private EntityManager em;
	
	
	public void guardar(Concurso con) {
		Concurso aux = leer(con.getCodigo());
		if(aux!=null){
			actualizar(con);
		}else {
			insertar(con);
		}
		
	}
	
public void insertar(Concurso con) {
		
		em.persist(con);
	}
	
	public void actualizar (Concurso con) {
		
		em.merge(con);
	}
	
	public Concurso leer(int id) {
		
		Concurso con = em.find(Concurso.class, id);
		
		return con;
	}
	
	public void borrar (int id) {
		
		Concurso con = leer(id);
		
		em.remove(con);
	}
	
	
	public List<Concurso> listadoConcursos(){
		Query query = em.createQuery("SELECT con FROM Concurso con", Concurso.class);
		List<Concurso> listado=query.getResultList();
		return listado;
	}
	
}
