package br.com.toyStore.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.toyStore.exception.DbException;
import br.com.toyStore.model.Product;
import br.com.toyStore.model.User;
import br.com.toyStore.util.ConnectionFactory;

public class UserDAO {
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	private User user;

	public UserDAO(Connection conn) {
		this.conn = conn;
	}

	public void insert(User user) {
		try {
			if (user != null) {
				String SQL = "INSERT INTO TOY_STORE.USER (USERNAME_USER, PASSWORD_USER) values "
						+ "(?, ?)";
				ps = conn.prepareStatement(SQL);
				ps.setString(1, user.getUsername());
				ps.setString(2, user.getPassword());
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
				String SQL = "UPDATE alunos set nome=?, email=?, endereco=?, datanascimento=?, "
						+ "periodo=? WHERE ra=?";
				ps = conn.prepareStatement(SQL);
				//ps.setString(1, aluno.getNome());
				//ps.setString(2, aluno.getEmail());
				//ps.setString(3, aluno.getEndereco());
				//ps.setDate(4, new java.sql.Date(aluno.getDataNascimento().getTime()));
				//ps.setString(5, aluno.getPeriodo());
				//ps.setInt(6, aluno.getRa());
				ps.executeUpdate();
			}

		} catch (SQLException sqle) {
			throw new DbException("Erro ao alterar dados " + sqle);
		} finally {
			ConnectionFactory.closeStatement(ps);
		}
	}

	public void delete(Integer idUser) {
		try {
			String SQL = "DELETE FROM TOY_STORE.USER AS PROD WHERE ID_USEr=?";
			ps = conn.prepareStatement(SQL);
			ps.setInt(1, idUser);
			ps.executeUpdate();
		} catch (SQLException sqle) {
			throw new DbException("Erro ao excluir dados " + sqle);
		} finally {
			ConnectionFactory.closeStatement(ps);
		}
	}

	public User findByUsername(String username) {

		try {
			String SQL = "SELECT * FROM TOY_STORE.USER WHERE USERNAME_USER = ?";
			ps = conn.prepareStatement(SQL);
			ps.setString(1, username);
			rs = ps.executeQuery();
			if (rs.next()) {
				int id = rs.getInt("id_user");
				String usernameUser = rs.getString("username_user");
				String passwordUser = rs.getString("password_user");

				user = new User();
				user.setId(id);
				user.setUsername(usernameUser);
				user.setPassword(passwordUser);
			}
			return user;
		} catch (SQLException sqle) {
			throw new DbException(sqle.getMessage());
		} finally {
			ConnectionFactory.closeResultSet(rs);
			ConnectionFactory.closeStatement(ps);
		}
	}
	
	public User findById(int idUser) {

		try {
			String SQL = "SELECT * FROM TOY_STORE.USER WHERE ID_USER =?";
			ps = conn.prepareStatement(SQL);
			ps.setInt(1, idUser);
			rs = ps.executeQuery();
			if (rs.next()) {
				int id = rs.getInt("id_user");
				String username = rs.getString("username_user");
				String password = rs.getString("password_user");

				user.setId(id);
				user.setUsername(username);
				user.setPassword(password);
			}
			return user;
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
				
				//product = new Product();
				//product.setId(id);
				//product.setName(name);
				//product.setPrice(price);
				//product.setDescription(description);
				
				//list.add(product);
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
