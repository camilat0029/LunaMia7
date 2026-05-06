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
				+ " quantHrs, quantDiasPedido) VALUES (?,?,?,?,?)";
		Connection conexao = null;
		PreparedStatement pstm = null;

		try {
			conexao = BancoDeDados.conectar();
			pstm = conexao.prepareStatement(sql);
			pstm.setString(1, orcamento.getTituloPedido());
			pstm.setString(2, orcamento.getStatus().name());
			pstm.setFloat(3, orcamento.getPrecoHora());
			pstm.setFloat(4, orcamento.getQuantHorasPrevistas());
			pstm.setFloat(5, orcamento.getMaxDias());

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

			BancoDeDados.desconectar(conexao);
			if (pstm != null) {
				try {
					pstm.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
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

				Orcamento orcamento = new Orcamento(sql, sql, 0, 0, 0, null, null, null);
				orcamento.setTituloPedido(rset.getString("tituloPedido"));
				orcamento.setStatus(Orcamento.Status.valueOf(rset.getString("statusPedido")));
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
	
	//ARRUMAR
	 public void atualizarOrcamentoe(Orcamento orcamento) {
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
				//pstm.setString(6, orcamento.get);
	            
	            
	            pstm.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	        	BancoDeDados.desconectar(conexao);
	        }
	    }
	    
	    public void excluirOrcamento(Orcamento orcamento) {
	        String sql = "DELETE FROM Orcamento WHERE tituloPedido = ?";
	        Connection conexao = null;
	        PreparedStatement pstm = null;

	        try {
	            conexao = BancoDeDados.conectar();
	            pstm = conexao.prepareStatement(sql);
	            pstm.setString(1, orcamento.getTituloPedido());
	            pstm.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	        	BancoDeDados.desconectar(conexao);
	        }
	    }
	
}