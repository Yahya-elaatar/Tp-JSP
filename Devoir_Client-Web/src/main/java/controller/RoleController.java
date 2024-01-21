package controller;

import java.io.IOException;
import java.util.List;

import dao.IDAOLocal;
import entites.Filiere;
import entites.Role;
import jakarta.ejb.EJB;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet(name = "RoleController",urlPatterns = {"RoleController"})
public class RoleController extends HttpServlet {

	
	private static final long serialVersionUID = 1L;
	@EJB(beanName = "rs")
	private IDAOLocal<Role> roleDao; 
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		
		List<Role> roles = roleDao.findAll();
		req.setAttribute("roles", roles);
		req.setAttribute("role", new Role(""));
		 req.setAttribute("type", "add");
		 req.getRequestDispatcher("/role.jsp").forward(req, resp);
	}
	
	
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String method = req.getParameter("_method");
		if(method.equals("add")) {
		    String name = req.getParameter("name");
		    roleDao.create(new Role(name));
		}else if(method.equals("delete")) {
			doDelete(req, resp);
		}else if(method.equals("findAll")){
			Long id=Long.parseLong(req.getParameter("roleToGet"));
			Role role=roleDao.findById(id);
			req.setAttribute("role", role);
			req.setAttribute("type", "update");
		    List<Role> roles = roleDao.findAll();
		    req.setAttribute("roles", roles);
		    req.getRequestDispatcher("/role.jsp").forward(req, resp);
		}else {
			doPut(req, resp);
		}
		doGet(req, resp);
		
	}
	
	
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
	Long id=Long.parseLong(req.getParameter("roleToDelete"));
		
		Role role=roleDao.findById(id);
		System.out.println(role);
		if(role != null)
			roleDao.delete(role.getId());
	}

	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Long id=Long.parseLong(req.getParameter("roleToUpdate"));
	    String name = req.getParameter("name");
		Role role=roleDao.findById(id);
		role.setName(name);
		role.setId(id);
		if(role != null)
			roleDao.update(role);
	}
}
