
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.BancoDeDados;
import view.CadastroUsuario;
import model.UsuarioPerfil;

public class UsuarioPerfilDAO {

	// MUDEI AQUI
	public void adicionarDados(UsuarioPerfil usuarioPerfil) {
		String sql = "INSERT INTO Perfil_Usuario (email, fotoPerfil, senha, nrTelefone, nomeUsuario, nome, precoHora, endereco, percentualLucro) "
				+ "VALUES (?,?,?,?,?,?,?,?,?)";
		Connection conexao = null;
		PreparedStatement pstm = null;

		try {
			conexao = BancoDeDados.conectar();
			pstm = conexao.prepareStatement(sql);
			// pstm.setString(1, usuarioPerfil.get());
			pstm.setString(1, usuarioPerfil.getEmail());
			pstm.setString(2, usuarioPerfil.getFotoPerfil());
			pstm.setString(3, usuarioPerfil.getSenha());
			pstm.setString(4, usuarioPerfil.getTelefone());
			pstm.setString(5, usuarioPerfil.getNomeUsuario());
			pstm.setString(6, usuarioPerfil.getNome());
			pstm.setFloat(7, usuarioPerfil.getPrecoHora());
			pstm.setString(8, usuarioPerfil.getEndereco());
			pstm.setFloat(9, usuarioPerfil.getPercentualLucro());
			pstm.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// BancoDeDados.desconectar(conexao);
			if (pstm != null) {
				try {
					pstm.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
		}
	}

	public List<UsuarioPerfil> listarUsuarios() {
		String sql = "SELECT * FROM Perfil_Usuario";
		List<UsuarioPerfil> usuarios = new ArrayList<>();
		Connection conexao = null;
		PreparedStatement pstm = null;
		ResultSet rset = null; // Objeto que guarda o resultado da consulta

		try {
			conexao = BancoDeDados.conectar();
			pstm = conexao.prepareStatement(sql);
			rset = pstm.executeQuery();

			while (rset.next()) {
				UsuarioPerfil usuario = new UsuarioPerfil(sql, sql, sql, sql, sql, sql, 0, 0, sql);
				usuario.setNome(rset.getString("nome"));
				usuario.setNomeUsuario(rset.getString("nomeUsuario"));
				usuario.setEmail(rset.getString("email"));
				usuario.setEndereco(rset.getString("endereco"));
				usuario.setTelefone(rset.getString("senha"));
				usuario.setSenha(rset.getString("senha"));
				usuario.setPercentualLucro(rset.getFloat("percentualLucro"));
				usuario.setPrecoHora(rset.getFloat("precoHora"));
				usuario.setFotoPerfil(rset.getString("fotoPerfil"));
				usuarios.add(usuario);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			// BancoDeDados.desconectar(conexao);
			// Fechar recursos
		}
		return usuarios;
	}

	// UPDATE - Atualizar um usuário existente
	public void atualizarUsuario(UsuarioPerfil usuarioPerfil) {
		String sql = "UPDATE Perfil_Usuario SET fotoPerfil = ?, senha = ?, nrTelefone = ?, nome = ?, "
				+ "precoHora = ?, endereco = ?, percentualLucro = ? WHERE nomeUsuario = ? AND email = ?";
		Connection conexao = null;
		PreparedStatement pstm = null;

		try {
			conexao = BancoDeDados.conectar();
			pstm = conexao.prepareStatement(sql);
			pstm.setString(1, usuarioPerfil.getFotoPerfil());
			pstm.setString(2, usuarioPerfil.getSenha());
			pstm.setString(3, usuarioPerfil.getTelefone());
			pstm.setString(4, usuarioPerfil.getNome());
			pstm.setFloat(5, usuarioPerfil.getPrecoHora());
			pstm.setString(6, usuarioPerfil.getEndereco());
			pstm.setFloat(7, usuarioPerfil.getPercentualLucro());
			pstm.setString(8, usuarioPerfil.getNomeUsuario());
			pstm.setString(9, usuarioPerfil.getEmail());
			pstm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			BancoDeDados.desconectar(conexao);
		}
	}

	// DELETE - Excluir um usuário pelo ID
	public void excluirUsuario(String nomeUsuario, String email) {
		String sql = "DELETE FROM usuarios WHERE nomeUsuario = ? AND email = ?";
		Connection conexao = null;
		PreparedStatement pstm = null;

		try {
			conexao = BancoDeDados.conectar();
			pstm = conexao.prepareStatement(sql);
			pstm.setString(1, nomeUsuario);
			pstm.setString(2, email);
			pstm.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			BancoDeDados.desconectar(conexao);
		}
	}

	// MUDANÇA
	// LISTA OS ESTADOS
	public List<String> listarEstados() {
		List<String> lista = new ArrayList<>();
		String sql = "SELECT nome FROM estados ORDER BY nome";

		try (Connection conn = BancoDeDados.conectarEstados();
				PreparedStatement stmt = conn.prepareStatement(sql);
				ResultSet rset = stmt.executeQuery()) {

			while (rset.next()) {
				lista.add(rset.getString("nome"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}

	public List<String> listarCidades(String estado) {

		List<String> lista = new ArrayList<>();
		String sql = "SELECT nome FROM cidades WHERE estados = ?";
		


		try (Connection conn = BancoDeDados.conectarCidades();
				PreparedStatement stmt = conn.prepareStatement(sql);
				ResultSet rset = stmt.executeQuery()) {
			
			stmt.setString(1, estado);

			while (rset.next()) {
				lista.add(rset.getString("nome"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return lista;
	}

}
