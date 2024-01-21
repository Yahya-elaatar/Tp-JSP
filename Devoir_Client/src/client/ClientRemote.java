package client;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import dao.IDAO;
import dto.StudentDto;
import entites.Filiere;
import entites.Role;
import entites.Student;
import entites.User;
import jakarta.ejb.EJBException;


public class ClientRemote {

	static Properties jndiProps = new Properties();
	static Context ctx;
	static IDAO<Filiere> filierDao;
	static IDAO<Role> roleDao;
	static IDAO<StudentDto> studentDao;

 
	public static void main(String[] args) {
		
		try {
			initJndi();
			initFilierDao();
			initRoleDao();
			initStudentDao();
			
			System.out.println("======Filiere======");
			createfilier();
			System.out.println("======Find All======");
			findAllFilieres();
			System.out.println("======Update======");
			Filiere filiere=filierDao.create(new Filiere("#666", "Islamic"));
			filiere.setName("IIFA");
			updateFiliere(filiere);
			deleteFiliere(filiere.getId());
			System.out.println("======Delete======");
			deleteFiliere(2L);
			System.out.println("======Find All======");
			findAllFilieres();
			System.out.println("======Find By Id======");
			System.out.println(findFilierById(1L));
			
			
			System.out.println();
			System.out.println("======Role======");
			createRole();
			System.out.println("======Find All======");
			findAllRoles();
			System.out.println("======Update======");
			Role role=roleDao.create(new Role("Student"));
			role.setName("Studentoo");
			updateRole(role);
			System.out.println("======Delete======");
			deleteRole(2L);
			System.out.println("======Find All======");
			findAllRoles();
			
			
			
			
			
			
			System.out.println();
			System.out.println("======Student======");
			createStudents();
			System.out.println("======Find All======");
			findAllStudents();
			System.out.println("======update======");
			
			StudentDto student= studentDao.create(new StudentDto("password3","login3","Otmane3","Elkastali3","0666931745"));
			System.out.println(student);
			student.setLastName("dd");
			updateStudent(student);
			System.out.println("======delete======");
			deleteStudent(2L);
		
			System.out.println("======Add Role To User ======");
			addRoleToUser(1L, 1L);
			System.out.println("======find By Id======");
			findStudentById(1L);
			
			System.out.println("======find By Filier======");
			findStudentByFilier(5L);
			
			
			
			
			
			
			
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
		
		
	}
	
	
	public static void initJndi() throws Exception {
		jndiProps.put(Context.INITIAL_CONTEXT_FACTORY, "org.wildfly.naming.client.WildFlyInitialContextFactory");
		jndiProps.put(Context.PROVIDER_URL, "http-remoting://localhost:8080");
		try {
			ctx = new InitialContext(jndiProps);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void initFilierDao() throws NamingException {
		filierDao=(IDAO<Filiere>) ctx.lookup("ejb:/Devoir_Server/fs!dao.IDAO");
		
	}
	public static void createfilier() {
		
		filierDao.create(new Filiere("#111", "filier 1"));
		filierDao.create(new Filiere("#222", "filier 2"));
		filierDao.create(new Filiere("#333", "filier 3"));
		
	}
	
	public static void findAllFilieres() {
		filierDao.findAll().forEach(System.out::println);
	}
	
	
	
	public static void deleteFiliere(Long id) {
		filierDao.delete(id);
	}
	
	public static Filiere findFilierById(Long id) {
		Filiere filiere = filierDao.findById(id);
		return filiere;
		
	}
	
	public static Filiere updateFiliere(Filiere filierToUpdate) {
		
		Filiere updatedFilier=filierDao.update(filierToUpdate);
		System.out.println(updatedFilier);
		
		return updatedFilier;
	}
	
	
	
	public static void initRoleDao() throws NamingException {
		
		roleDao=(IDAO<Role>) ctx.lookup("ejb:/Devoir_Server/rs!dao.IDAO");
		
	}
	
	
	public static void createRole() {
		
		roleDao.create(new Role("ADMIN"));
		roleDao.create(new Role("USER"));
		
	}
	
	public static void findAllRoles() {
		roleDao.findAll().forEach(System.out::println);
	}
	
	public static Role findRoleById(Long id) {
		Role role = roleDao.findById(id);
		System.out.println(role);
		return role;
		
	}
	
	public static Role updateRole(Role roleToUpdate) {
		Role updatedRole=roleDao.update(roleToUpdate);
		System.out.println(updatedRole);	
		return updatedRole;
	}
	
	public static void deleteRole(Long id) {
		roleDao.delete(id);
	}
	
	public static void initStudentDao() throws NamingException {
		
		studentDao=(IDAO<StudentDto>) ctx.lookup("ejb:/Devoir_Server/ss!dao.IDAO");
	}
	
	
	public static void createStudents() {
		
		
		StudentDto newStudent1 = new StudentDto("password1","login1","Otmane","Elkastali","0666931745");
		newStudent1.setFiliere(new Filiere("#444","Informatique"));
		studentDao.create(newStudent1);
		StudentDto newStudent2 = new StudentDto("password2","login2","Otmane2","Elkastali2","0666931745");
		newStudent2.setFiliere(new Filiere("#555","Reseau"));
		studentDao.create(newStudent2);
		
	}
	
	public static void findAllStudents() {
		studentDao.findAll().forEach(System.out::println);
	}
	
	public static StudentDto findStudentById(Long id) {
		
		StudentDto student=studentDao.findById(id);
		System.out.println(student);
		return student;
	}
	
	
	public static StudentDto updateStudent(StudentDto studentToUpdate) {
		
		StudentDto updatedStudent=studentDao.update(studentToUpdate);
		
		return updatedStudent;
	}
	
	public static void deleteStudent(Long id) {
		studentDao.delete(id);
	}
	
	
	public static void addRoleToUser(Long idUser,Long idRole) {
		roleDao.addRoleToUser(idUser, idRole);
	}
	
	
	public static void findStudentByFilier(Long id) {
		studentDao.findStudentByFilliere(id).forEach(System.out::println);
	}
	
}
