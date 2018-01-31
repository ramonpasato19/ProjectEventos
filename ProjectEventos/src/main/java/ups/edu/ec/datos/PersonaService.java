package ups.edu.ec.datos;

import java.util.List;
import javax.ejb.Local;
//import mx.com.gm.sga.domain.Persona;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.Query;

import ups.edu.ec.modelo.Persona;

@Stateless
public class PersonaService {
	
	@Inject
	EntityManager em;
	
	public List<Persona> findAllPersonas() {
        return em.createNamedQuery("Persona.findAll").getResultList();
    }

    public Persona findPersonaById(Persona persona) {
        return em.find(Persona.class, persona.getIdPersona());
    }

    public Persona findPersonaByEmail(Persona persona) {
        Query query = em.createQuery("from Persona p where p.email =: email");
        query.setParameter("email", persona.getEmail());
        return (Persona) query.getSingleResult();
    }

    public void insertPersona(Persona persona) {
        em.persist(persona);
    }

    public void updatePersona(Persona persona) {
        em.merge(persona);
    }

    public void deletePersona(Persona persona) {
        persona = em.getReference(Persona.class, persona.getIdPersona());
        em.remove(persona);
    }
   
}
