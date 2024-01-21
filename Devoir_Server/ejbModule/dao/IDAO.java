package dao;

import java.util.List;

import jakarta.ejb.Remote;

@Remote
public interface IDAO <T>{
	
	T create(T o);
	T update(T o);
	void delete(Long id);
	T findById(Long id);
	List<T>findAll();
	void addRoleToUser(Long userId,Long roleId);
	List<T>findStudentByFilliere(Long idFlier);

}
