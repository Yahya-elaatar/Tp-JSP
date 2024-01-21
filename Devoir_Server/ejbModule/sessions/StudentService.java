package sessions;

import java.util.ArrayList;
import java.util.List;

import dao.IDAO;
import dao.IDAOLocal;
import dto.StudentDto;
import entites.Student;
import jakarta.ejb.Stateless;
import jakarta.ejb.TransactionAttribute;
import jakarta.ejb.TransactionAttributeType;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Stateless(name = "ss")
@TransactionAttribute(TransactionAttributeType.REQUIRED)
public class StudentService implements IDAO<StudentDto>,IDAOLocal<StudentDto> {
	
	@PersistenceContext(unitName = "Devoir_Server")
	private EntityManager entityManager;

	@Override
	public StudentDto create(StudentDto o) {
		Student student=new Student(o.getPassword(), o.getLogin(), o.getFirstName(), o.getLastName(),o.getTelephone(),o.getFiliere());
		entityManager.persist(student);
		o.setId(student.getId());
		return o;
	}

	@Override
	public StudentDto update(StudentDto o) {
		Student student=new Student(o.getId(),o.getPassword(), o.getLogin(), o.getFirstName(), o.getLastName(),o.getTelephone(),o.getFiliere());
		entityManager.merge(student);
		return o;
	}

	@Override
	public void delete(Long id) {
		// TODO Auto-generated method stub
		
		Student student=entityManager.find(Student.class, id);
		student.getRoles().size();
		entityManager.remove(student);
		
	}

	@Override
	public StudentDto findById(Long id) {
		Student student=entityManager.find(Student.class, id);
		System.out.println(student);
		System.err.println(student.getRoles().size());
		
		return mapToStudentResponse(student);
	}

	@Override
	public List<StudentDto> findAll() {
		List<StudentDto> studentResponses=new ArrayList<>();
		Query query=entityManager.createQuery("SELECT s FROM Student s",Student.class);
		query.getResultList().stream().forEach(student -> {
			studentResponses.add(mapToStudentResponse((Student) student));
		});
		
		System.out.println(studentResponses);
		return studentResponses;
	}

	@Override
	public void addRoleToUser(Long userId, Long roleId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<StudentDto> findStudentByFilliere(Long idFlier) {
		List<StudentDto> studentResponses=new ArrayList<>();
		
		Query query=entityManager.createQuery("SELECT s FROM Student s where s.filiere.id=:id");
		query.setParameter("id", idFlier);
		
		query.getResultList().stream().forEach(student -> {
			studentResponses.add(mapToStudentResponse((Student) student));
		});
		
		
		return studentResponses;
	}
	
	
	
	//Helper Functions
	
	private StudentDto mapToStudentResponse(Student student) {
		StudentDto studentDto = new StudentDto(student.getId(),student.getPassword(),student.getLogin(),student.getFirstName(),student.getLastName(),student.getTelephone(),student.getFiliere());
		student.getRoles().forEach(role -> {
			
			studentDto.getRoles().add(role);
		});
		return studentDto;
	}
	
	
	
	

}
