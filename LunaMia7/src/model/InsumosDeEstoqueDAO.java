
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsumosDeEstoqueDAO {
	
	public void adicionarInsumos(InsumosDeEstoque insumosDeEstoque) {
		
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
}
