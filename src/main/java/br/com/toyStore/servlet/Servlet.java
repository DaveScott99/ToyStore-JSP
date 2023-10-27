package br.com.toyStore.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import br.com.toyStore.dao.CategoryDAO;
import br.com.toyStore.dao.ProductDAO;
import br.com.toyStore.dao.UserDAO;
import br.com.toyStore.exception.DbException;
import br.com.toyStore.model.Category;
import br.com.toyStore.model.Product;
import br.com.toyStore.model.User;
import br.com.toyStore.util.ConnectionFactory;

@WebServlet(urlPatterns = { "/Servlet", "/home", "/catalog", "/categories", 
			"/selectProduct", "/selectCategory", "/insertProduct", "/insertCategory", "/login", "/admin",
			"/updateProduct", "/selectProductUpdate", "/deleteProduct", "/newProduct"})
@MultipartConfig(
		  fileSizeThreshold = 1024 * 1024 * 1, // 1 MB
		  maxFileSize = 1024 * 1024 * 10,      // 10 MB
		  maxRequestSize = 1024 * 1024 * 100   // 100 MB
		)
public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	ProductDAO productDao = new ProductDAO(ConnectionFactory.getConnection());
	CategoryDAO categoryDao = new CategoryDAO(ConnectionFactory.getConnection());
	UserDAO userDao = new UserDAO(ConnectionFactory.getConnection());
	Product product = new Product();
	Category category = new Category();
	
	final String IMAGES_PATH = "D:\\ARQUIVOS\\DevCompleto\\JAVA-WEB\\toy-store\\src\\main\\webapp\\assets\\"; 
	
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
		else if (action.equals("/selectProductUpdate")) {
			selectProductForUpdate(request, response);
		}
		else if (action.equals("/updateProduct")) {
			updateProduct(request, response);
		}
		else if (action.equals("/deleteProduct")) {
			deleteProduct(request, response);
		}
		else if (action.equals("/insertCategory")) {
			insertCategory(request, response);
		}
		else if (action.equals("/newProduct")) {
			newProduct(request, response);
		}
		
	}
	
	protected void newProduct(HttpServletRequest request, HttpServletResponse response) {
		try {
			List<Category> categories = categoryDao.findAll();
			request.setAttribute("categories", categories);
			RequestDispatcher rd = request.getRequestDispatcher("newProduct.jsp");
			rd.forward(request, response);
		} catch (Exception e) {
			throw new DbException(e.getMessage());
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
					RequestDispatcher rd = request.getRequestDispatcher("admin");
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
	
	protected void updateProduct(HttpServletRequest request, HttpServletResponse response) {
		try {
			product.setId(Long.parseLong(request.getParameter("code")));
			product.setName(request.getParameter("name"));
			product.setPrice(Double.parseDouble(request.getParameter("price")));
			product.setDescription(request.getParameter("description"));
			product.setImageName(request.getParameter("image-name"));
			
			Category cat = categoryDao.findByName(request.getParameter("category"));
			product.setCategory(cat);
			
		    Part filePart = request.getPart("image");
	    	String fileName = filePart.getSubmittedFileName();

		    if (filePart.getSize() == 0) {
		    	 productDao.update(product);
		    }
		    else {
		    	 InputStream fileContent = filePart.getInputStream();
		    	 String uploadPath = IMAGES_PATH + fileName;
		    	 Path path = Paths.get(uploadPath);
		    	 Files .copy(fileContent, path, StandardCopyOption.REPLACE_EXISTING);
		    	 product.setImageName(fileName);
				 productDao.update(product);
		    }
			
			response.sendRedirect("admin");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	protected void insertProduct(HttpServletRequest request, HttpServletResponse response) {
		try {
			product.setName(request.getParameter("name"));
			product.setPrice(Double.parseDouble(request.getParameter("price")));
			product.setDescription(request.getParameter("description"));
						
		    Part filePart = request.getPart("image");
		    String fileName = filePart.getSubmittedFileName();
            InputStream fileContent = filePart.getInputStream();

            String uploadPath = IMAGES_PATH + fileName;

            Path path = Paths.get(uploadPath);
            Files.copy(fileContent, path, StandardCopyOption.REPLACE_EXISTING);
	        
	        product.setImageName(fileName);
	        
			Category cat = categoryDao.findByName(request.getParameter("category"));
			product.setCategory(cat);
			
			productDao.insert(product);
			
			try {
				Thread.sleep(2000);
			}
			catch(InterruptedException e) {
				e.printStackTrace();
			}
			
			response.sendRedirect("admin");
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	protected void insertCategory(HttpServletRequest request, HttpServletResponse response) {
		try {
			category.setName(request.getParameter("name"));
						
		    Part filePart = request.getPart("image");
		    String fileName = filePart.getSubmittedFileName();
            InputStream fileContent = filePart.getInputStream();

            String uploadPath = IMAGES_PATH + fileName;

            Path path = Paths.get(uploadPath);
            Files.copy(fileContent, path, StandardCopyOption.REPLACE_EXISTING);
	        
	        category.setImageName(fileName);
	        
	        categoryDao.insert(category);
			
			try {
				Thread.sleep(2000);
			}
			catch(InterruptedException e) {
				e.printStackTrace();
			}
			
			response.sendRedirect("admin");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	protected void findAllProducts(HttpServletRequest request, HttpServletResponse response) {

		try {
			List<Product> products = productDao.findAll();
			request.setAttribute("products", products);
			RequestDispatcher rd = request.getRequestDispatcher("home.jsp");
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
		
		request.setAttribute("id_product", product.getId());
		request.setAttribute("name_product", product.getName());
		request.setAttribute("price_product", product.getPrice());
		request.setAttribute("name_category", product.getCategory().getName());
		request.setAttribute("description_product", product.getDescription());
		request.setAttribute("image_name", product.getImageName());
		
		RequestDispatcher rd = request.getRequestDispatcher("product.jsp");
		rd.forward(request, response);
	}
	
	private void selectProductForUpdate(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException  {
		
		String idProduct = request.getParameter("idProduct");
		product = productDao.findById(Integer.parseInt(idProduct));
		
		request.setAttribute("id_product", product.getId());
		request.setAttribute("name_product", product.getName());
		request.setAttribute("price_product", product.getPrice());
		request.setAttribute("description_product", product.getDescription());
		request.setAttribute("image_product", product.getImageName());
		request.setAttribute("name_category", product.getCategory().getName());
		
		List<Category> categories = categoryDao.findAll();
		request.setAttribute("categories", categories);
		
		RequestDispatcher rd = request.getRequestDispatcher("UpdateProduct.jsp");
		rd.forward(request, response);
	}
	
	private void deleteProduct(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String idProduct = request.getParameter("idProduct");
		productDao.delete(Integer.parseInt(idProduct));
		response.sendRedirect("admin");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
