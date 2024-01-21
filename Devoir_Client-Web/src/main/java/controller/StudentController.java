package controller;

import java.io.IOException;
import java.util.List;

import dao.IDAOLocal;
import dto.StudentDto;
import entites.Filiere;
import entites.Role;
import entites.Student;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "StudentController",urlPatterns = {"StudentController"})
public class StudentController extends HttpServlet{

	
	private static final long serialVersionUID = 1L;
	@EJB(beanName = "ss")
	private IDAOLocal<StudentDto> studentDao;
	@EJB(beanName = "fs")
	private IDAOLocal<Filiere> filiereDao;

	public StudentController() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<StudentDto> students = studentDao.findAll();
		req.setAttribute("students", students);
		req.setAttribute("student", new StudentDto("","","","",""));
		 req.setAttribute("type", "add");
		 req.setAttribute("filieres", filiereDao.findAll());
		 req.getRequestDispatcher("/student.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String method = req.getParameter("_method");
		System.out.println(method);
		if(method.equals("add")) {
		    String firstName = req.getParameter("firstName");
		    String lastName = req.getParameter("lastName");
		    String telephone = req.getParameter("telephone");
		    String email = req.getParameter("email");
		    String password = req.getParameter("password");
		    System.out.println(firstName+lastName+telephone+email+password);
		    Filiere filiere = filiereDao.findById(Long.parseLong(req.getParameter("filiereId")));
		    StudentDto studentDto = new StudentDto(password,email,firstName,lastName,telephone);
		    StudentDto savedStudent = studentDao.create(studentDto);
		    if(filiere != null) {
		    savedStudent.setFiliere(filiere);
		    studentDao.update(savedStudent);
		    }
		}else if(method.equals("delete")) {
			doDelete(req, resp);
		}else if(method.equals("findAll")){
			Long id=Long.parseLong(req.getParameter("studentToGet"));
			StudentDto student=studentDao.findById(id);
			req.setAttribute("student", student);
			req.setAttribute("type", "modifier");
		    List<StudentDto> students = studentDao.findAll();
		    req.setAttribute("students", students);
		    req.setAttribute("filieres", filiereDao.findAll());
		    req.getRequestDispatcher("/student.jsp").forward(req, resp);
		}else {
			doPut(req, resp);
		}
		doGet(req, resp);
	}
	
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Long id=Long.parseLong(req.getParameter("studentToDelete"));
		StudentDto student=studentDao.findById(id);
		if(!student.equals(null))
			studentDao.delete(student.getId());
	}
	
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Long id=Long.parseLong(req.getParameter("studentToUpdate"));
		String firstName = req.getParameter("firstName");
	    String lastName = req.getParameter("lastName");
	    String telephone = req.getParameter("telephone");
	    String email = req.getParameter("email");
	    String password = req.getParameter("password");
	    Filiere filiere = filiereDao.findById(Long.parseLong(req.getParameter("filiereId")));
	    StudentDto student=new StudentDto(email,password,firstName,lastName,telephone,filiere);
		student.setId(id);
		if(student != null)
			studentDao.update(student);
	}
}
