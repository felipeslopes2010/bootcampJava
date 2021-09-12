package br.com.alura.livraria.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import br.com.alura.livraria.modelo.Autor;

public class LivrariaDao {

	private Connection conexao;

	public LivrariaDao(Connection conexao) {
		this.conexao = conexao;
	}

	public List<Autor> listar() {
		try {

			String sql = "select nome, email, dataNascimento from autor";

			PreparedStatement ps = conexao.prepareStatement(sql);

			ResultSet rs = ps.executeQuery();

			List<Autor> autores = new ArrayList();

			while (rs.next()) {
				Autor autor = new Autor();
				autor.setNome(rs.getString("nome"));
				autor.setEmail(rs.getString("email"));
				autor.setDataNascimento(rs.getObject("dataNascimento", LocalDate.class));

				autores.add(autor);
			}
			return autores;
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	public void cadastrar(Autor autor) {
		try {
			String sql = "insert into autor (nome, email, dataNascimento, curriculo) values (?, ?, ?, ?)";
			
			PreparedStatement ps = conexao.prepareStatement(sql);
			ps.setString(1, autor.getNome());
			ps.setString(2, autor.getEmail());
			ps.setDate(3, Date.valueOf(autor.getDataNascimento()));
			ps.setString(4, autor.getCurriculo());
			
			ps.execute();
			
		}catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
	
	

}
