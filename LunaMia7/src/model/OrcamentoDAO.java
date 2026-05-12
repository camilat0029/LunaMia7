package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.BancoDeDados;
import model.OrcamentoDAO;
import view.CriarOrcamento;

public class OrcamentoDAO {

	public void adicionarDados(Orcamento orcamento) {

		String sql = "INSERT INTO Orcamento (tituloPedido, statusPedido, precoHora, "
				+ " quantHrs, quantDiasPedido, Perfil_Usuario_email, Perfil_Usuario_nomeUsuario,"
				+ "Cliente_id_cliente) VALUES (?,?,?,?,?,?,?,?)";
		Connection conexao = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;

		try {
			conexao = BancoDeDados.conectar();
			pstm = conexao.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
			pstm.setString(1, orcamento.getTituloPedido());
			pstm.setString(2, orcamento.getStatus().name().toLowerCase());
			pstm.setFloat(3, orcamento.getPrecoHora());
			pstm.setFloat(4, orcamento.getQuantHorasPrevistas());
			pstm.setInt(5, orcamento.getMaxDias());
			pstm.setString(6, orcamento.getUsuarioPerfil().getEmail());
			pstm.setString(7, orcamento.getUsuarioPerfil().getNomeUsuario());
			pstm.setInt(8, orcamento.getCliente().getIdCliente());
			
			pstm.executeUpdate();
			
			rs = pstm.getGeneratedKeys();
			
			if(rs.next()) {
				orcamento.setIdOrcamento(rs.getInt(1));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			
			try {
		        if (rs != null) rs.close();
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }

		    try {
		        if (pstm != null) pstm.close();
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
			BancoDeDados.desconectar(conexao);
		}
	}

	public List<Orcamento> listarOrcamentos() {
		String sql = "SELECT * FROM Orcamento";
		List<Orcamento> orcamentos = new ArrayList<>();
		Connection conexao = null;
		PreparedStatement pstm = null;
		ResultSet rset = null; // Objeto que guarda o resultado da consulta

		try {
			conexao = BancoDeDados.conectar();
			pstm = conexao.prepareStatement(sql);
			rset = pstm.executeQuery();

			while (rset.next()) {

				Orcamento orcamento = new Orcamento(null, null, 0, 0, 0, null, null, null);
				orcamento.setIdOrcamento(rset.getInt("id_orcamento"));
				orcamento.setTituloPedido(rset.getString("tituloPedido"));
				orcamento.setStatus(Orcamento.Status.valueOf(rset.getString("statusPedido").toUpperCase()));
				orcamento.setPrecoHora(rset.getFloat("precoHora"));
				orcamento.setQuantHorasPrevistas(rset.getFloat("quantHrs"));
				orcamento.setMaxDias(rset.getInt("quantDiasPedido"));
				
				orcamentos.add(orcamento);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			BancoDeDados.desconectar(conexao);
			// Fechar recursos
		}
		return orcamentos;
    }
	
	 public void atualizarOrcamento(Orcamento orcamento) {
	        String sql = "UPDATE Orcamento SET tituloPedido = ?, statusPedido = ?, precoHora = ?, quantHrs = ?,"
	        		+ " quantDiasPedido = ? WHERE id_orcamento = ?";
	        Connection conexao = null;
	        PreparedStatement pstm = null;

	        try {
	            conexao = BancoDeDados.conectar();
	            pstm = conexao.prepareStatement(sql);
				pstm.setString(1, orcamento.getTituloPedido());
				pstm.setString(2, orcamento.getStatus().name().toLowerCase());
				pstm.setFloat(3, orcamento.getPrecoHora());
				pstm.setFloat(4, orcamento.getQuantHorasPrevistas());
				pstm.setInt(5, orcamento.getMaxDias());
				pstm.setInt(6, orcamento.getIdOrcamento());
	            
	            
	            pstm.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	        	BancoDeDados.desconectar(conexao);
	        }
	    }
	    
	    public void excluirOrcamento(Orcamento orcamento) {
	        String sql = "DELETE FROM Orcamento WHERE id_orcamento = ?";
	        Connection conexao = null;
	        PreparedStatement pstm = null;

	        try {
	            conexao = BancoDeDados.conectar();
	            pstm = conexao.prepareStatement(sql);
	            pstm.setInt(1, orcamento.getIdOrcamento());
	            pstm.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	        	BancoDeDados.desconectar(conexao);
	        }
	    }
	
}