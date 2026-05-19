package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ConfirOrcamDAO {
	
	public void adicionarDados(ConfirOrcam confirOrcam) {

		String sql = "INSERT INTO Confirmacao_de_orcamento (formaPagam, dataPrevisaoEnt, dataConfirmacao, "
				+ " id_orcamento, valorVenda, lucroTotalObtido) VALUES (?,?,?,?,?,?)";
		Connection conexao = null;
		PreparedStatement pstm = null;

		try {
			conexao = BancoDeDados.conectar();
			pstm = conexao.prepareStatement(sql);
			pstm.setString(1, confirOrcam.getFormPagamento());
			pstm.setDate(2, java.sql.Date.valueOf(confirOrcam.getDataPrevistaEntrega()));
			pstm.setDate(3, java.sql.Date.valueOf(confirOrcam.getDataConfirmacao()));
			pstm.setInt(4, confirOrcam.getOrcamento().getIdOrcamento());
			pstm.setFloat(5, confirOrcam.getValorVenda());
			pstm.setFloat(6, confirOrcam.getLucro());
			
			pstm.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {

		    try {
		        if (pstm != null) pstm.close();
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
			BancoDeDados.desconectar(conexao);
		}
	}

	public List<ConfirOrcam> listarConfirOrcam() {
		String sql = "SELECT * FROM Confirmacao_de_orcamento";
		List<ConfirOrcam> confirOrcams = new ArrayList<>();
		Connection conexao = null;
		PreparedStatement pstm = null;
		ResultSet rset = null; // Objeto que guarda o resultado da consulta

		try {
			conexao = BancoDeDados.conectar();
			pstm = conexao.prepareStatement(sql);
			rset = pstm.executeQuery();

			while (rset.next()) {

				ConfirOrcam confirOrcam = new ConfirOrcam(null, null, null, 0, 0);
				confirOrcam.setFormPagamento(rset.getString("formaPagam"));
				
				Date dtPrev = rset.getDate("dataPrevisaoEnt");
	            if (dtPrev != null) {
	                confirOrcam.setDataPrevistaEntrega(dtPrev.toLocalDate());
	            }

	            Date dtConf = rset.getDate("dataConfirmacao");
	            if (dtConf != null) {
	                confirOrcam.setDataConfirmacao(dtConf.toLocalDate());
	            }
				confirOrcam.setValorVenda(rset.getFloat("valorVenda"));
				confirOrcam.setLucro(rset.getFloat("lucroTotalObtido"));
				
				confirOrcams.add(confirOrcam);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
		    try {
		        if (rset != null) rset.close();
		        if (pstm != null) pstm.close();
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }

		    BancoDeDados.desconectar(conexao);
		}
		return confirOrcams;
    }
	
	 public void atualizarConfirOrcam(ConfirOrcam confirOrcam) {
	        String sql = "UPDATE Confirmacao_de_orcamento SET formaPagam = ?, dataPrevisaoEnt = ?, dataConfirmacao = ?, valorVenda = ?,"
	        		+ " lucroTotalObtido = ? WHERE id_orcamento = ?";
	        Connection conexao = null;
	        PreparedStatement pstm = null;

	        try {
	            conexao = BancoDeDados.conectar();
	            pstm = conexao.prepareStatement(sql);
				pstm.setString(1, confirOrcam.getFormPagamento());
				
				if (confirOrcam.getDataPrevistaEntrega() != null) {
		            pstm.setDate(2, java.sql.Date.valueOf(confirOrcam.getDataPrevistaEntrega()));
		        } else {
		            pstm.setNull(2, java.sql.Types.DATE);
		        }
	
				if (confirOrcam.getDataConfirmacao() != null) {
		            pstm.setDate(3, java.sql.Date.valueOf(confirOrcam.getDataConfirmacao()));
		        } else {
		            pstm.setNull(3, java.sql.Types.DATE);
		        }

				pstm.setFloat(4, confirOrcam.getValorVenda());
				pstm.setFloat(5, confirOrcam.getLucro());
				pstm.setInt(6, confirOrcam.getOrcamento().getIdOrcamento());
	            
	            
	            pstm.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	        	
	        	 try {
	                 if (pstm != null) pstm.close();
	             } catch (SQLException e) {
	                 e.printStackTrace();
	             }
	        	 
	        	BancoDeDados.desconectar(conexao);
	        }
	    }
	    
	    public void excluirConfirOrcam(ConfirOrcam confirOrcam) {
	        String sql = "DELETE FROM Confirmacao_de_orcamento WHERE id_orcamento = ?";
	        Connection conexao = null;
	        PreparedStatement pstm = null;

	        try {
	            conexao = BancoDeDados.conectar();
	            pstm = conexao.prepareStatement(sql);
	            pstm.setInt(1, confirOrcam.getOrcamento().getIdOrcamento());
	            pstm.executeUpdate();
	        } catch (SQLException e) {
	            e.printStackTrace();
	        } finally {
	        	
	        	try {
	                 if (pstm != null) pstm.close();
	             } catch (SQLException e) {
	                 e.printStackTrace();
	             }
	        	BancoDeDados.desconectar(conexao);
	        }
	    }

}