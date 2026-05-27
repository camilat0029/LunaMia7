package model;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class OrcamentoProdutoDAO {
	
	public void adicionarDados(OrcamentoProduto orcamProduto) {

		String sql = "INSERT INTO OrcamentoProduto (id_orcamento, id_estoque, quantidade) VALUES (?,?,?)";
		Connection conexao = null;
		PreparedStatement pstm = null;

		try {
			conexao = BancoDeDados.conectar();
			pstm = conexao.prepareStatement(sql);
			pstm.setInt(1, orcamProduto.getOrcamento().getIdOrcamento());
			pstm.setInt(2, orcamProduto.getMateriaPrima().getIdMateriaPrima());
			pstm.setInt(3, orcamProduto.getQuantidade());
			
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

	public List<OrcamentoProduto> listarOrcamProd() {
		String sql = "SELECT * FROM OrcamentoProduto";
		List<OrcamentoProduto> orcamProdutos = new ArrayList<>();
		Connection conexao = null;
		PreparedStatement pstm = null;
		ResultSet rset = null; // Objeto que guarda o resultado da consulta

		try {
			conexao = BancoDeDados.conectar();
			pstm = conexao.prepareStatement(sql);
			rset = pstm.executeQuery();

			while (rset.next()) {

				OrcamentoProduto orcamProd = new OrcamentoProduto();
				Orcamento orcamento = new Orcamento(null, 0, 0, 0, null);
				orcamento.setIdOrcamento(rset.getInt("id_orcamento"));
				MateriaPrima materiaPrima = new MateriaPrima(null, null, null, 0, 0, 0, null);
				materiaPrima.setIdMateriaPrima((rset.getInt("id_estoque")));
				
				orcamProd.setOrcamento(orcamento);
				orcamProd.setMateriaPrima(materiaPrima);
				
				orcamProd.setQuantidade(rset.getInt("quantidade"));
				
				orcamProdutos.add(orcamProd);
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
		return orcamProdutos;
    }
	
	 public void atualizarOrcamentoproduto(OrcamentoProduto orcamentoProduto) {
	        String sql = "UPDATE OrcamentoProduto SET quantidade = ? WHERE id_orcamento = ? AND id_estoque = ?";
	        Connection conexao = null;
	        PreparedStatement pstm = null;

	        try {
	            conexao = BancoDeDados.conectar();
	            pstm = conexao.prepareStatement(sql);
				pstm.setInt(1, orcamentoProduto.getQuantidade());
				pstm.setInt(2, orcamentoProduto.getOrcamento().getIdOrcamento());
				pstm.setInt(3, orcamentoProduto.getMateriaPrima().getIdMateriaPrima());
			
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
	    
	    public void excluirOrcamentoProduto(OrcamentoProduto orcamentoProduto) {
	        String sql = "DELETE FROM OrcamentoProduto WHERE id_orcamento = ? AND id_estoque = ?";
	        Connection conexao = null;
	        PreparedStatement pstm = null;

	        try {
	            conexao = BancoDeDados.conectar();
	            pstm = conexao.prepareStatement(sql);
	            pstm.setInt(1, orcamentoProduto.getOrcamento().getIdOrcamento());
	            pstm.setInt(2, orcamentoProduto.getMateriaPrima().getIdMateriaPrima());
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
	    
	    public List<MateriaPrima> buscarPeloIdOrcamento(int idOrcamento){
	    	 String sql = "SELECT mp.id_estoque, mp.nome, mp.valor, op.quantidade FROM OrcamentoProduto op INNER JOIN "
	    	 		+ "MateriaPrima mp ON mp.id_estoque = op.id_estoque WHERE op.id_orcamento = ?";
	    	 
	    	 List<MateriaPrima> listaMP = new ArrayList<>(); 
	    	 
	    	 Connection conexao = null;
	    	 PreparedStatement pstm = null;
	    	 ResultSet rset = null;
	    	 
	    	 try {
	    	        conexao = BancoDeDados.conectar();
	    	        pstm = conexao.prepareStatement(sql);
	    	        pstm.setInt(1, idOrcamento);

	    	        rset = pstm.executeQuery();
	    	        
	    	        while(rset.next()) {
	    	        	
	    	        	MateriaPrima materiaPrima = new MateriaPrima(null, null, null, 0, 0, 0, null);
	    	        	
	    	        	materiaPrima.setIdMateriaPrima(rset.getInt("id_estoque"));
	    	        	materiaPrima.setNome(rset.getString("nome"));
	    	        	materiaPrima.setValor(rset.getFloat("valor"));
	    	        	materiaPrima.setQuantidadeDisponivel(rset.getInt("quantidade"));
	    	        	
	    	        	listaMP.add(materiaPrima);
	    	        }
	    	 } catch(SQLException e){
	    		 e.printStackTrace();
	    	 }finally {

	    	        try {

	    	            if(rset != null)
	    	                rset.close();

	    	            if(pstm != null)
	    	                pstm.close();

	    	        } catch(SQLException e) {
	    	            e.printStackTrace();
	    	        }

	    	        BancoDeDados.desconectar(conexao);
	    	 }

	    	 return listaMP;
	    }
} 
