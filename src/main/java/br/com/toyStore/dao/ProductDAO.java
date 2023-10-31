package br.com.toyStore.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.toyStore.exception.DbException;
import br.com.toyStore.model.Category;
import br.com.toyStore.model.Product;
import br.com.toyStore.util.ConnectionFactory;

public class ProductDAO {
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	private Product product;

	public ProductDAO(Connection conn) {
		this.conn = conn;
	}

	public void insert(Product product) {
		try {
			if (product != null) {
				String SQL = "INSERT INTO TOY_STORE.PRODUCT (NAME_PRODUCT, PRICE_PRODUCT, DESCRIPTION_PRODUCT, IMAGE_NAME_PRODUCT, BRAND_PRODUCT, ID_CATEGORY) values "
						+ "(?, ?, ?, ?, ?, ?)";
				ps = conn.prepareStatement(SQL);
				ps.setString(1, product.getName());
				ps.setDouble(2, product.getPrice());
				ps.setString(3, product.getDescription());
				ps.setString(4, product.getImageName());
				ps.setString(5, product.getBrand());
				ps.setLong(6, product.getCategory().getId());
				ps.executeUpdate();
			}

		} catch (SQLException sqle) {
			throw new DbException("Erro ao inserir dados " + sqle);
		} finally {
			ConnectionFactory.closeStatement(ps);
		}
	}

	public void update(Product product) {
		try {
			if (product != null) {
				String SQL = "UPDATE TOY_STORE.PRODUCT set NAME_PRODUCT=?, PRICE_PRODUCT=?, DESCRIPTION_PRODUCT=?, IMAGE_NAME_PRODUCT=?, ID_CATEGORY=?, BRAND_PRODUCT=? WHERE ID_PRODUCT=?";
				ps = conn.prepareStatement(SQL);
				ps.setString(1, product.getName());
				ps.setDouble(2, product.getPrice());
				ps.setString(3, product.getDescription());
				ps.setString(4, product.getImageName());
				ps.setLong(5, product.getCategory().getId());
				ps.setString(6, product.getBrand());
				ps.setLong(7, product.getId());
				ps.executeUpdate();
			}

		} catch (SQLException sqle) {
			throw new DbException("Erro ao alterar dados " + sqle);
		} finally {
			ConnectionFactory.closeStatement(ps);
		}
	}

	public void delete(Integer idProduct) {
		try {
			String SQL = "DELETE FROM TOY_STORE.PRODUCT AS PROD WHERE PROD.ID_PRODUCT =?";
			ps = conn.prepareStatement(SQL);
			ps.setInt(1, idProduct);
			ps.executeUpdate();
		} catch (SQLException sqle) {
			throw new DbException("Erro ao excluir dados " + sqle);
		} finally {
			ConnectionFactory.closeStatement(ps);
		}
	}

	public Product findById(int idProduct) {

		try {
			String SQL = "SELECT * FROM TOY_STORE.PRODUCT AS PROD INNER JOIN TOY_STORE.CATEGORY AS CAT ON PROD.ID_CATEGORY = CAT.ID_CATEGORY WHERE PROD.ID_PRODUCT =?";
			ps = conn.prepareStatement(SQL);
			ps.setInt(1, idProduct);
			rs = ps.executeQuery();
			if (rs.next()) {
				long id = rs.getInt("id_product");
				String name = rs.getString("name_product");
				String description = rs.getString("description_product");
				double price = rs.getDouble("price_product");
				String image = rs.getString("image_name_product");
				String brand = rs.getString("brand_product");

				long idCategory = rs.getInt("id_category");
				String nameCategory = rs.getString("name_category");
				String imageCategory = rs.getString("image_name_category");
				
				product = new Product();
				product.setId(id);
				product.setName(name);
				product.setPrice(price);
				product.setDescription(description);
				product.setImageName(image);
				product.setBrand(brand);

				product.setCategory(new Category(idCategory, nameCategory, imageCategory));
			}
			return product;
		} catch (SQLException sqle) {
			throw new DbException(sqle.getMessage());
		} finally {
			ConnectionFactory.closeResultSet(rs);
			ConnectionFactory.closeStatement(ps);
		}
	}
	
	public List<Product> findProductsByCategory(int idCategory) {
		try {
			String SQL = "SELECT * FROM TOY_STORE.PRODUCT AS PROD INNER JOIN TOY_STORE.CATEGORY AS CAT ON PROD.ID_CATEGORY = CAT.ID_CATEGORY WHERE PROD.ID_CATEGORY = ?";
			ps = conn.prepareStatement(SQL);
			ps.setInt(1, idCategory);
			rs = ps.executeQuery();
			List<Product> list = new ArrayList<Product>();
			while (rs.next()) {
				long id = rs.getInt("id_product");
				String name = rs.getString("name_product");
				String description = rs.getString("description_product");
				double price = rs.getDouble("price_product");
				String image = rs.getString("image_name_product");
				String brand = rs.getString("brand_product");
				
				product = new Product();
				product.setId(id);
				product.setName(name);
				product.setPrice(price);
				product.setDescription(description);
				product.setImageName(image);
				product.setBrand(brand);

				list.add(product);
			}
			return list;
		} catch (SQLException sqle) {
			throw new DbException(sqle.getMessage());
		} finally {
			ConnectionFactory.closeResultSet(rs);
			ConnectionFactory.closeStatement(ps);
		}
	}

	public List<Product> findAll() {
		try {
			String SQL = "SELECT * FROM TOY_STORE.PRODUCT AS PROD ORDER BY PROD.NAME_PRODUCT";
			ps = conn.prepareStatement(SQL);
			rs = ps.executeQuery();
			List<Product> list = new ArrayList<Product>();
			while (rs.next()) {
				long id = rs.getInt("id_product");
				String name = rs.getString("name_product");
				String description = rs.getString("description_product");
				double price = rs.getDouble("price_product");
				String image = rs.getString("image_name_product");
				String brand = rs.getString("brand_product");
				
				product = new Product();
				product.setId(id);
				product.setName(name);
				product.setPrice(price);
				product.setDescription(description);
				product.setImageName(image);
				product.setBrand(brand);
				
				list.add(product);
			}
			return list;
		} catch (SQLException sqle) {
			throw new DbException(sqle.getMessage());
		} finally {
			ConnectionFactory.closeResultSet(rs);
			ConnectionFactory.closeStatement(ps);
		}
	}
	
	public List<Product> findAllForAdmin() {
		try {
			String SQL = "SELECT * FROM TOY_STORE.PRODUCT AS PROD INNER JOIN TOY_STORE.CATEGORY AS CAT ON PROD.ID_CATEGORY = CAT.ID_CATEGORY ORDER BY PROD.NAME_PRODUCT";
			ps = conn.prepareStatement(SQL);
			rs = ps.executeQuery();
			List<Product> list = new ArrayList<Product>();
			while (rs.next()) {
				long id = rs.getInt("id_product");
				String name = rs.getString("name_product");
				String description = rs.getString("description_product");
				double price = rs.getDouble("price_product");
				String image = rs.getString("image_name_product");

				long idCategory = rs.getInt("id_category");
				String nameCategory = rs.getString("name_category");
				String imageCategory = rs.getString("image_name_category");
				
				String brand = rs.getString("brand_product");
				
				product = new Product();
				product.setId(id);
				product.setName(name);
				product.setPrice(price);
				product.setDescription(description);
				product.setImageName(image);
				product.setCategory(new Category(idCategory, nameCategory, imageCategory));
				product.setBrand(brand);
				
				list.add(product);
			}
			return list;
		} catch (SQLException sqle) {
			throw new DbException(sqle.getMessage());
		} finally {
			ConnectionFactory.closeResultSet(rs);
			ConnectionFactory.closeStatement(ps);
		}
	}
}
