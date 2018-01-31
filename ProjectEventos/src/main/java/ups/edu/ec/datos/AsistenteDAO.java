package ups.edu.ec.datos;

import java.util.List;

import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

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
		//em.merge(asi);
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
	
	//********************************************
	
	public List<Asistente> getUsuariosLogin(String correo,String clave){
	Query q = em.createQuery("SELECT u FROM Asistente u WHERE asi_email = ?  AND asi_password = ?",Asistente.class);
	q.setParameter(1, correo);
	q.setParameter(2, clave);
	List<Asistente> personas = q.getResultList();
	return personas;
	
	}
	
	public List<Asistente> getUserLogin(String email,String passwrod){
		Query q = em.createQuery("SELECT u FROM Asistente u WHERE asi_email = ?  AND asi_password = ?",Asistente.class);
		q.setParameter(1, email);
		q.setParameter(2, passwrod);
		List<Asistente> personas = q.getResultList();
		return personas;
	}
	
	//este es el que esta funcionandop como login ok
	public List<Asistente> login(String email, String pass){
		String sql="SELECT a FROM Asistente a WHERE a.email='"+email+"' AND a.password='"+pass+"'";
		TypedQuery<Asistente> query =em.createQuery(sql,Asistente.class);
		List<Asistente> asistentes=query.getResultList();
		return asistentes;
	}
}
