package controller;

import java.io.IOException;
import java.util.List;

import dao.IDAOLocal;
import entites.Filiere;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "FiliereController",urlPatterns = {"FiliereController"})
public class FiliereController extends HttpServlet {
	

	private static final long serialVersionUID = 1L;
	
	@EJB(beanName = "fs")
	private IDAOLocal<Filiere> filiereDao;

	
	
	public FiliereController() {
		super();
		// TODO Auto-generated constructor stub
	}



	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		List<Filiere> filieres = filiereDao.findAll();
		req.setAttribute("filieres", filieres);
		req.setAttribute("filiere", new Filiere("",""));
		 req.setAttribute("type", "add");
		 req.getRequestDispatcher("/filiere.jsp").forward(req, resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String method = req.getParameter("_method");
		if(method.equals("add")) {
		    String code = req.getParameter("code");
		    String name = req.getParameter("name");
		    filiereDao.create(new Filiere(code,name));
		}else if(method.equals("delete")) {
			doDelete(req, resp);
		}else if(method.equals("findAll")){
			Long id=Long.parseLong(req.getParameter("filiereToGet"));
			Filiere filiere=filiereDao.findById(id);
			req.setAttribute("filiere", filiere);
			req.setAttribute("type", "update");
		    List<Filiere> filieres = filiereDao.findAll();
		    req.setAttribute("filieres", filieres);
		    req.getRequestDispatcher("/filiere.jsp").forward(req, resp);
		}else {
			doPut(req, resp);
		}
		doGet(req, resp);
	}
	
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Long id=Long.parseLong(req.getParameter("filiereToDelete"));
		
		Filiere filiere=filiereDao.findById(id);
		System.out.println(filiere);
		if(filiere != null)
			filiereDao.delete(filiere.getId());
	}
	
@Override
protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	// TODO Auto-generated method stub
	Long id=Long.parseLong(req.getParameter("filiereToUpdate"));
	String code = req.getParameter("code");
    String name = req.getParameter("name");
	Filiere filiere=filiereDao.findById(id);
	filiere.setCode(code);
	filiere.setName(name);
	filiere.setId(id);
	if(filiere != null)
		filiereDao.update(filiere);
}
	
	
}	
