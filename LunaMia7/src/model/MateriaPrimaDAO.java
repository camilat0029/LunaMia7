
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MateriaPrimaDAO {
	
	public void adicionarInsumos(MateriaPrima materiaPrimaEstoque) {
		
		String sql = "INSERT INTO MateriaPrima (unidadeMedida,"
				+ " valor, marca, cor, qntDisponivel, nome, qntPorUnidade,usuario_email)"
				+ "VALUES (?,?,?,?,?,?,?,?)";
	
		
		Connection conexao = null;
		PreparedStatement pstm = null;
		ResultSet rs =null;
		
        try {
            conexao = BancoDeDados.conectar();
            pstm = conexao.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);

            pstm.setString(1, materiaPrimaEstoque.getUnidadeMedida().name().toLowerCase());
            pstm.setFloat(2, materiaPrimaEstoque.getValor());
            pstm.setString(3, materiaPrimaEstoque.getMarca());
            pstm.setString(4, materiaPrimaEstoque.getCor());
            pstm.setFloat(5, materiaPrimaEstoque.getQuantidadeDisponivel());
            pstm.setString(6, materiaPrimaEstoque.getNome());
            pstm.setFloat(7, materiaPrimaEstoque.getQtdPorUnidade());
            pstm.setString(8, materiaPrimaEstoque.getUsuario().getEmail());
            pstm.executeUpdate();
            
            rs = pstm.getGeneratedKeys();
            if(rs.next()) {
            	materiaPrimaEstoque.setIdMateriaPrima(rs.getInt(1));
            }
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
	
	public static List<MateriaPrima> listarMateriaPrima(String emailUsuario) {
    	
        String sql = "SELECT * FROM MateriaPrima WHERE usuario_email = ?";
        List<MateriaPrima> materiasPrimas = new ArrayList<>();
        Connection conexao = null;
        PreparedStatement pstm = null;
        ResultSet rset = null; // Objeto que guarda o resultado da consulta

        try {
            conexao = BancoDeDados.conectar();
            pstm = conexao.prepareStatement(sql);
            pstm.setString(1, emailUsuario);
            rset = pstm.executeQuery();

            while (rset.next()) {
                MateriaPrima materiaPrima = new MateriaPrima(null, null, null, 0, 0, 0, null);
                materiaPrima.setIdMateriaPrima(rset.getInt("id_estoque"));
                materiaPrima.setNome(rset.getString("nome"));
                materiaPrima.setMarca(rset.getString("marca"));
                materiaPrima.setCor(rset.getString("cor"));
                materiaPrima.setQtdPorUnidade(rset.getFloat("qntPorUnidade"));
                materiaPrima.setQuantidadeDisponivel(rset.getInt("qntDisponivel"));
                materiaPrima.setValor(rset.getFloat("valor"));
                materiaPrima.setUnidadeMedida(MateriaPrima.UnidadeMedida.valueOf(rset.getString("unidadeMedida").toUpperCase()));
    
                materiasPrimas.add(materiaPrima);
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        	BancoDeDados.desconectar(conexao);
            // Fechar recursos
        }
        return materiasPrimas;
    }
    
    public void atualizarMateriasPrimas(MateriaPrima materiaPrima) {
        String sql = "UPDATE MateriaPrima SET nome = ?, marca = ?, cor = ?, valor = ?,"
        		+ "qntPorUnidade = ?, qntDisponivel = ?, unidadeMedida =? WHERE id_estoque = ?";
        Connection conexao = null;
        PreparedStatement pstm = null;

        try {
            conexao = BancoDeDados.conectar();
            pstm = conexao.prepareStatement(sql);
            pstm.setString(1, materiaPrima.getNome());
            pstm.setString(2, materiaPrima.getMarca());
            pstm.setString(3, materiaPrima.getCor());
            pstm.setFloat(4,materiaPrima.getValor());
            pstm.setFloat(5, materiaPrima.getQtdPorUnidade());
            pstm.setInt(6, materiaPrima.getQuantidadeDisponivel());
            pstm.setString(7, materiaPrima.getUnidadeMedida().name().toLowerCase());
            pstm.setInt(8, materiaPrima.getIdMateriaPrima());
            pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        	BancoDeDados.desconectar(conexao);
        }
    }
    
    public void atualizarQuantMP(int idMateriaPrima, int quantidade) {
        String sql = "UPDATE MateriaPrima SET qntDisponivel = ? WHERE id_estoque = ?";
        Connection conexao = null;
        PreparedStatement pstm = null;

        try {
            conexao = BancoDeDados.conectar();
            pstm = conexao.prepareStatement(sql);
            pstm.setInt(1, quantidade);
            pstm.setInt(2, idMateriaPrima);
            pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        	BancoDeDados.desconectar(conexao);
        }
    }
    
    public void excluirMateriasPrimas(MateriaPrima materiasPrimas) {
        String sql = "DELETE FROM MateriaPrima WHERE nome = ?";
        Connection conexao = null;
        PreparedStatement pstm = null;

        try {
            conexao = BancoDeDados.conectar();
            pstm.setString(1, materiasPrimas.getNome());

            pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        	BancoDeDados.desconectar(conexao);
        }
    }
	
}