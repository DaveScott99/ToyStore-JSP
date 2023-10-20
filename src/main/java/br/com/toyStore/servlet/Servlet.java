package br.com.toyStore.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.toyStore.dao.CategoryDAO;
import br.com.toyStore.dao.ProductDAO;
import br.com.toyStore.exception.DbException;
import br.com.toyStore.model.Category;
import br.com.toyStore.model.Product;
import br.com.toyStore.util.ConnectionFactory;

@WebServlet(urlPatterns = { "/Servlet", "/home", "/catalog", "/categories", "/selectProduct", "/selectCategory"})
public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	ProductDAO productDao = new ProductDAO(ConnectionFactory.getConnection());
	CategoryDAO categoryDao = new CategoryDAO(ConnectionFactory.getConnection());
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
