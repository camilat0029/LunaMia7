package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import main.BancoDeDados;
import main.Usuario;

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
			// pstm.setString(2, orcamento.getStatus());
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

	public List<Orcamento> listarUsuarios() {
        String sql = "SELECT * FROM usuarios";
        List<Orcamento> orcamento = new ArrayList<>();
        Connection conexao = null;
        PreparedStatement pstm = null;
        ResultSet rset = null; // Objeto que guarda o resultado da consulta


		try {
			  conexao = BancoDeDados.conectar();
	            pstm = conexao.prepareStatement(sql);
	            rset = pstm.executeQuery();

			while (rset.next()) {

				Orcamento orcamentos = new Orcamento(sql, sql, sql, 0, 0, null, null);
				orcamentos.setTituloPedido(rset.getString("tituloPedido"));
				orcamentos.setTituloPedido("tituloPedido");
				orcamentos.setQuantHorasPrevistas(0);
				orcamentos.setMaxDias(0);
				orcamentos.setDescricaoPedido("descricao");

				orcamento.add(orcamentos);
			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		} finally {
//			BancoDeDados.desconectar(conexao);
//			// Fechar recursos
//		}
//		return orcamentos;
	}
}