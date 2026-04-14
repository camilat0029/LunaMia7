
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProdutoEstoqueDAO {
	
	public void adicionarInsumos(ProdutoEstoque insumosDeEstoque) {
		
		String sql = "INSERT INTO produtoestoque (unidadeMedida,"
				+ " valor, marca, cor, qntDisponivel, nome, qntPorUnidade)"
				+ "VALUES (?,?,?,?,?,?,?,?)";
		
		Connection conexao = null;
		PreparedStatement pstm = null;
		
        try {
            conexao = BancoDeDados.conectar();
            pstm = conexao.prepareStatement(sql);

            pstm.setFloat(1, insumosDeEstoque.getUnidadePorUnidade());
            pstm.setFloat(2, insumosDeEstoque.getValor());
            pstm.setString(3, insumosDeEstoque.getMarca());
            pstm.setString(4, insumosDeEstoque.getCor());
            pstm.setFloat(5, insumosDeEstoque.getQuantidadeDisponivel());
            pstm.setString(6, insumosDeEstoque.getNome());
            
            pstm.executeUpdate();
            
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
 //       	BancoDeDados.desconectar(conexao);
            if (pstm != null) {
                try {
                    pstm.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
    public List<ProdutoEstoque> listarInsumos() {
        String sql = "SELECT * FROM produtoEstoque";
        List<ProdutoEstoque> insumos = new ArrayList<>();
        Connection conexao = null;
        PreparedStatement pstm = null;
        ResultSet rset = null; // Objeto que guarda o resultado da consulta

        try {
            conexao = BancoDeDados.conectar();
            pstm = conexao.prepareStatement(sql);
            rset = pstm.executeQuery();

            while (rset.next()) {
                ProdutoEstoque insumo = new ProdutoEstoque(sql, sql, sql, 0, 0, 0);
                insumo.setNome(rset.getString("nome"));
                insumo.setMarca(rset.getString("marca"));
                insumo.setCor(rset.getString("cor"));
                insumo.setUnidadePorUnidade(rset.getFloat(0));
                insumo.setQuantidadeDisponivel(rset.getInt(0));
                insumo.setValor(rset.getFloat(0));

                insumos.add(insumo);
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
 //       	BancoDeDados.desconectar(conexao);
            // Fechar recursos
        }
        return insumos;
    }
    
    public void atualizarInsumos(ProdutoEstoque insumosDeEstoque) {
        String sql = "UPDATE produtoEstoque SET nome = ?, marca = ?, cor = ?, valor = ?"
        		+ "unidadePorUnidade = ?, quantidadeDisponivel = ? WHERE nome = ?";
        Connection conexao = null;
        PreparedStatement pstm = null;

        try {
            conexao = BancoDeDados.conectar();
            pstm = conexao.prepareStatement(sql);
            pstm.setString(1, insumosDeEstoque.getNome());
            pstm.setString(2, insumosDeEstoque.getMarca());
            pstm.setString(3, insumosDeEstoque.getCor());
            pstm.setFloat(4,insumosDeEstoque.getValor());
            pstm.setFloat(5, insumosDeEstoque.getUnidadePorUnidade());
            pstm.setInt(6, insumosDeEstoque.getQuantidadeDisponivel());
            pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        	//BancoDeDados.desconectar(conexao);
        }
    }
    
    public void excluirInsumos(ProdutoEstoque insumosDeEstoque) {
        String sql = "DELETE FROM produtoEstoque WHERE nome = ?";
        Connection conexao = null;
        PreparedStatement pstm = null;

        try {
            conexao = BancoDeDados.conectar();
            pstm.setString(1, insumosDeEstoque.getNome());

            pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        	//BancoDeDados.desconectar(conexao);
        }
    }
	
}