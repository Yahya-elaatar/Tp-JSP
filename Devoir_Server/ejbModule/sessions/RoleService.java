package sessions;

import java.util.List;

import dao.IDAO;
import dao.IDAOLocal;
import entites.Role;
import entites.User;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Stateless(name = "rs")
public class RoleService implements IDAO<Role> ,IDAOLocal<Role>{
	
	@PersistenceContext(unitName = "Devoir_Server")
	private EntityManager entityManager;

	@Override
	public Role create(Role o) {
		// TODO Auto-generated method stub
		entityManager.persist(o);
		return o;
	}

	@Override
	public Role update(Role o) {
		// TODO Auto-generated method stub
		entityManager.merge(o);
		return o;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		Role role=entityManager.find(Role.class, id);
		entityManager.remove(role);
		
	}

	@Override
	public Role findById(Long id) {
		// TODO Auto-generated method stub
		Role role=entityManager.find(Role.class, id);
		return role;
	}

	@Override
	public List<Role> findAll() {
		Query query=entityManager.createQuery("SELECT r FROM Role r");
		return query.getResultList();
	}
	@Override
	public void addRoleToUser(Long userId,Long rolId) {
		
		Role role=entityManager.find(Role.class, rolId);
		
		User user=entityManager.find(User.class, userId);
		System.out.println(user);
		
		user.getRoles().add(role);
		
		entityManager.merge(user);
	}

	@Override
	public List<Role> findStudentByFilliere(Long idFlier) {
		// TODO Auto-generated method stub
		return null;
	}

}
