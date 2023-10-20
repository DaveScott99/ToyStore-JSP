package br.com.toyStore.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import br.com.toyStore.exception.DbException;
import br.com.toyStore.model.Category;
import br.com.toyStore.util.ConnectionFactory;

public class CategoryDAO {
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	private Category category;

	public CategoryDAO(Connection conn) {
		this.conn = conn;
	}

	public void insert(Category category) {
		try {
			if (category != null) {
				String SQL = "INSERT INTO TOY_STORE.CATEGORY (NAME_CATEGORY) values (?)";
				ps = conn.prepareStatement(SQL);
				ps.setString(1, category.getName());
				ps.executeUpdate();
			}

		} catch (SQLException sqle) {
			throw new DbException("Erro ao inserir dados " + sqle);
		} finally {
			ConnectionFactory.closeStatement(ps);
		}
	}

	public void update(Category category) {
		try {
			if (category != null) {
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

	public void delete(Integer idCategory) {
		try {
			String SQL = "DELETE FROM TOY_STORE.PRODUCT AS PROD WHERE PROD.ID_PRODUCT =?";
			ps = conn.prepareStatement(SQL);
			ps.setInt(1, idCategory);
			ps.executeUpdate();
		} catch (SQLException sqle) {
			throw new DbException("Erro ao excluir dados " + sqle);
		} finally {
			ConnectionFactory.closeStatement(ps);
		}
	}

	public Category findByName(String idCategory) {

		try {
			String SQL = "SELECT * FROM TOY_STORE.CATEGORY AS CAT WHERE CAT.NAME_CATEGORY =?";
			ps = conn.prepareStatement(SQL);
			ps.setString(1, idCategory);
			rs = ps.executeQuery();
			if (rs.next()) {
				long id = rs.getInt("id_category");
				String name = rs.getString("name_category");

				category = new Category();
				category.setId(id);
				category.setName(name);
			
			}
			return category;
		} catch (SQLException sqle) {
			throw new DbException(sqle.getMessage());
		} finally {
			ConnectionFactory.closeResultSet(rs);
			ConnectionFactory.closeStatement(ps);
		}
	}
	
	public Category findById(int idCategory) {

		try {
			String SQL = "SELECT * FROM TOY_STORE.CATEGORY AS CAT WHERE CAT.ID_CATEGORY =?";
			ps = conn.prepareStatement(SQL);
			ps.setInt(1, idCategory);
			rs = ps.executeQuery();
			if (rs.next()) {
				long id = rs.getInt("id_category");
				String name = rs.getString("name_category");

				category = new Category();
				category.setId(id);
				category.setName(name);
			
			}
			return category;
		} catch (SQLException sqle) {
			throw new DbException(sqle.getMessage());
		} finally {
			ConnectionFactory.closeResultSet(rs);
			ConnectionFactory.closeStatement(ps);
		}
	}
	
	public List<Category> findAll() {
		try {
			String SQL = "SELECT * FROM TOY_STORE.CATEGORY AS CAT ORDER BY CAT.NAME_CATEGORY";
			ps = conn.prepareStatement(SQL);
			rs = ps.executeQuery();
			List<Category> list = new ArrayList<Category>();
			while (rs.next()) {
				long id = rs.getInt("id_category");
				String name = rs.getString("name_category");
			
				category = new Category();
				category.setId(id);
				category.setName(name);

				list.add(category);
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
