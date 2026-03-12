package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class OrcamentoDAO {

	public void adicionarDados(Orcamento orcamento) {
		String sql = "INSERT INTO orcamento (tituloPedido, statusPedido, precoHora, "
				+ " quantHrs, quantDiasPedido, descricao) VALUES (?,?,?,?,?,?)";
		Connection conexao = null;
		PreparedStatement pstm = null;

		try {
			conexao = BancoDeDados.conectar();
			pstm = conexao.prepareStatement(sql);
			pstm.setString(1, orcamento.getTituloPedido());
		//	pstm.setString(2, orcamento.getStatus());
			pstm.setString(6, orcamento.getDescricaoPedido());
			pstm.setFloat(4, orcamento.getQuantHorasPrevistas());
			pstm.setFloat(5, orcamento.getMaxDias());

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
}