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

	public List<Orcamento> listarOrcamentos() {
		String sql = "SELECT * FROM orcamento";
		List<Orcamento> orcamentos = new ArrayList<>();
		Connection conexao = null;
		PreparedStatement pstm = null;
		ResultSet rset = null; // Objeto que guarda o resultado da consulta

		try {
			conexao = BancoDeDados.conectar();
			pstm = conexao.prepareStatement(sql);
			rset = pstm.executeQuery();

			while (rset.next()) {

				Orcamento orcamento = new Orcamento(sql, sql, sql, 0, 0, null, null);
				orcamento.setTituloPedido(rset.getString("tituloPedido"));
				orcamento.setTituloPedido("tituloPedido");
				orcamento.setQuantHorasPrevistas(0);
				orcamento.setMaxDias(0);
				orcamento.setDescricaoPedido("descricao");
				orcamentos.add(orcamento);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
//			BancoDeDados.desconectar(conexao);
			// Fechar recursos
		}
		return orcamentos;
    }
}