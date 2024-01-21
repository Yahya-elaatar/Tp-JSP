package sessions;

import java.util.List;

import dao.IDAO;
import dao.IDAOLocal;
import entites.Filiere;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Stateless(name="fs")
public class FilierService implements IDAO<Filiere> ,IDAOLocal<Filiere> {
	
	
	@PersistenceContext(unitName = "Devoir_Server")
	private EntityManager entityManager;

	@Override
	public Filiere create(Filiere o) {
		entityManager.persist(o);
		return o;
	}

	@Override
	public Filiere update(Filiere o) {
		entityManager.merge(o);
		
		return o;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		Filiere filiere=entityManager.find(Filiere.class, id);
		entityManager.remove(filiere);
		
	}

	@Override
	public Filiere findById(Long id) {
		// TODO Auto-generated method stub
		Filiere filiere=entityManager.find(Filiere.class, id);
		return filiere;
	}

	@Override
	public List<Filiere> findAll() {
		Query query=entityManager.createQuery("SELECT f FROM Filiere f");
		return query.getResultList();
	
	}

	@Override
	public void addRoleToUser(Long userId, Long roleId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Filiere> findStudentByFilliere(Long idFlier) {
		// TODO Auto-generated method stub
		return null;
	}
	

}
