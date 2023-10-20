package br.com.toyStore.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import br.com.toyStore.dao.CategoryDAO;
import br.com.toyStore.dao.ProductDAO;
import br.com.toyStore.dao.UserDAO;
import br.com.toyStore.exception.DbException;
import br.com.toyStore.model.Category;
import br.com.toyStore.model.Product;
import br.com.toyStore.model.User;
import br.com.toyStore.util.ConnectionFactory;

@WebServlet(urlPatterns = { "/Servlet", "/home", "/catalog", "/categories", 
			"/selectProduct", "/selectCategory", "/insertProduct", "/login", "/admin"})
public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	ProductDAO productDao = new ProductDAO(ConnectionFactory.getConnection());
	CategoryDAO categoryDao = new CategoryDAO(ConnectionFactory.getConnection());
	UserDAO userDao = new UserDAO(ConnectionFactory.getConnection());
	Product product = new Product();
	
    public Servlet() throws Exception{
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getServletPath();

		if (action.equals("/home")) {
			findAllProducts(request, response);
		} 
		else if (action.equals("/categories")) {
			findAllCategories(request, response);
		}
		else if (action.equals("/selectCategory")) {
			findAllProductsByCategory(request, response);
		}
		else if (action.equals("/selectProduct")) {
			selectProduct(request, response);
		}
		else if (action.equals("/insertProduct")) {
			insertProduct(request, response);
		}
		else if (action.equals("/login")) {
			login(request, response);
		}
		else if (action.equals("/admin")) {
			admin(request, response);
		}
		
	}
	
	protected void admin(HttpServletRequest request, HttpServletResponse response) {
		
		try {
			HttpSession session = request.getSession();
			
			String user = (String) session.getAttribute("username");
			
			if (user != null) {
				List<Product> products = productDao.findAllForAdmin();
				request.setAttribute("products", products);
				RequestDispatcher rd = request.getRequestDispatcher("Admin.jsp");
				rd.forward(request, response);
			}
			else {
				response.sendRedirect("Login.jsp");
			}
			
		}
		catch (Exception e) {
			throw new DbException(e.getMessage());
		}
		
	}
	
	protected void login(HttpServletRequest request, HttpServletResponse response) {
		
		try {
			String username = request.getParameter("username");
			String password = request.getParameter("password");
			
			User loginUser = userDao.findByUsername(username);
			
			if (loginUser != null) {
				if (loginUser.getUsername().equals(username) && loginUser.getPassword().equals(password)) {
					HttpSession session = request.getSession();
					
					session.setAttribute("username", username);
					
					List<Product> products = productDao.findAllForAdmin();
					request.setAttribute("products", products);
					RequestDispatcher rd = request.getRequestDispatcher("Admin.jsp");
					rd.forward(request, response);
				}
				else {
					response.sendRedirect("Login.jsp");
				}
			}
			else {
				response.sendRedirect("Login.jsp");
			}
			
		}
		catch (Exception e) {
			throw new DbException(e.getMessage());
		}
		
	}
	
	protected void insertProduct(HttpServletRequest request, HttpServletResponse response) {
		try {
			product.setName(request.getParameter("name"));
			product.setPrice(Double.parseDouble(request.getParameter("price")));
			product.setDescription(request.getParameter("description"));
			
			Category cat = categoryDao.findByName(request.getParameter("category"));
			
			if (cat != null) {
				product.setCategory(cat);
				productDao.insert(product);
			}
			else {
				Category newCategory = new Category();
				newCategory.setName(request.getParameter("category"));
				categoryDao.insert(newCategory);
				product.setCategory(categoryDao.findByName(request.getParameter("category")));
				productDao.insert(product);
			}		
			response.sendRedirect("home");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	protected void findAllProducts(HttpServletRequest request, HttpServletResponse response) {

		try {
			List<Product> products = productDao.findAll();
			request.setAttribute("products", products);
			RequestDispatcher rd = request.getRequestDispatcher("catalog.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			throw new DbException(e.getMessage());
		}

	}
	
	protected void findAllProductsByCategory(HttpServletRequest request, HttpServletResponse response) {

		try {
			String idCategory = request.getParameter("idCategory");			
			List<Product> products = productDao.findProductsByCategory(Integer.parseInt(idCategory));
			request.setAttribute("products", products);
			RequestDispatcher rd = request.getRequestDispatcher("catalog.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			throw new DbException(e.getMessage());
		}

	}
	
	protected void findAllCategories(HttpServletRequest request, HttpServletResponse response) {

		try {
			List<Category> categories = categoryDao.findAll();
			request.setAttribute("categories", categories);
			RequestDispatcher rd = request.getRequestDispatcher("categories.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			throw new DbException(e.getMessage());
		}

	}
	
	private void selectProduct(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException  {
		String idProduct = request.getParameter("idProduct");
		product = productDao.findById(Integer.parseInt(idProduct));
		
		request.setAttribute("name_product", product.getName());
		request.setAttribute("price_product", product.getPrice());
		request.setAttribute("description_product", product.getDescription());
		
		RequestDispatcher rd = request.getRequestDispatcher("product.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
