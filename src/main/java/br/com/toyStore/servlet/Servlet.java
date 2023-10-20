package br.com.toyStore.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.com.toyStore.dao.ProductDAO;
import br.com.toyStore.exception.DbException;
import br.com.toyStore.model.Product;
import br.com.toyStore.util.ConnectionFactory;

@WebServlet(urlPatterns = { "/Servlet", "/catalog"})
public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	ProductDAO productDao = new ProductDAO(ConnectionFactory.getConnection());
	Product product = new Product();
	
    public Servlet() throws Exception{
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String action = request.getServletPath();

		if (action.equals("/catalog")) {
			findAllProducts(request, response);
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

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
