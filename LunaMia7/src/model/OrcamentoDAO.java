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

		String sql = "INSERT INTO Orcamento (tituloPedido, statusPedido, precoHora, percentualLucro, "
				+ " quantHrs, quantDiasPedido, Perfil_Usuario_email, Perfil_Usuario_nomeUsuario,"
				+ "Cliente_id_cliente, valorAdicional, valorGastos, valorSemLucro) VALUES (?,?,?,?,?,?,?,?,?,?,?,?)";
		Connection conexao = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;

		try {
			conexao = BancoDeDados.conectar();
			pstm = conexao.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
			pstm.setString(1, orcamento.getTituloPedido());
			pstm.setString(2, orcamento.getStatus().name().toLowerCase());
			pstm.setFloat(3, orcamento.getPrecoHora());
			pstm.setFloat(4, orcamento.getPercentualLucro());
			pstm.setFloat(5, orcamento.getQuantHorasPrevistas());
			pstm.setInt(6, orcamento.getMaxDias());
			pstm.setString(7, orcamento.getUsuarioPerfil().getEmail());
			pstm.setString(8, orcamento.getUsuarioPerfil().getNomeUsuario());
			pstm.setInt(9, orcamento.getCliente().getIdCliente());
			pstm.setFloat(10, orcamento.getValorAdicional());
			pstm.setFloat(11, orcamento.getValorGastos());
			pstm.setFloat(12, orcamento.getValorSemLucro());
			
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

	public List<Orcamento> listarOrcamentos(String emailUsuario) {

		String sql =
			    "SELECT o.*, c.*, " +
			    "u.email AS emailUsuario, " +
			    "u.nomeUsuario AS nomeUsuario, " +
			    "u.percentualLucro AS percLucroUsuario, " +
			    "u.precoHora AS precoHoraUsuario " +
			    "FROM Orcamento o " +
			    "INNER JOIN Cliente c ON o.Cliente_id_cliente = c.id_cliente " +
			    "INNER JOIN Perfil_Usuario u ON o.Perfil_Usuario_email = u.email " +
			    "AND o.Perfil_Usuario_nomeUsuario = u.nomeUsuario " +
			    "WHERE o.Perfil_Usuario_email = ?";

	    List<Orcamento> orcamentos = new ArrayList<>();

	    Connection conexao = null;
	    PreparedStatement pstm = null;
	    ResultSet rset = null;

	    try {

	        conexao = BancoDeDados.conectar();

	        pstm = conexao.prepareStatement(sql);
	        pstm.setString(1, emailUsuario);
	        rset = pstm.executeQuery();
	        

	        while (rset.next()) {

	            Orcamento orcamento = new Orcamento(null, 0, 0, 0, null, 0, 0, 0, 0);

	            orcamento.setIdOrcamento(rset.getInt("id_orcamento"));
	            orcamento.setTituloPedido(rset.getString("tituloPedido"));
	            orcamento.setStatus(Orcamento.Status.valueOf(rset.getString("statusPedido").toUpperCase()));
	            orcamento.setPrecoHora(rset.getFloat("precoHora"));
	            orcamento.setPercentualLucro(rset.getFloat("percentualLucro"));
	            orcamento.setQuantHorasPrevistas(rset.getFloat("quantHrs"));
	            orcamento.setMaxDias(rset.getInt("quantDiasPedido"));
	            orcamento.setValorAdicional(rset.getFloat("valorAdicional"));
	            orcamento.setValorGastos(rset.getFloat("valorGastos"));
	            orcamento.setValorSemLucro(rset.getFloat("valorSemLucro"));
	            
	            UsuarioPerfil usuario = new UsuarioPerfil(null, null, null, null, null, null, null, 0, 0, null);

	            usuario.setEmail(rset.getString("email"));
	            usuario.setNomeUsuario(rset.getString("nomeUsuario"));
	            usuario.setPercentualLucro(rset.getFloat("percLucroUsuario"));
	            usuario.setPrecoHora(rset.getFloat("precoHoraUsuario"));

	            orcamento.setUsuarioPerfil(usuario);
	            
	            Cliente cliente = new Cliente(null, null, null);
	            
	            cliente.setIdCliente(rset.getInt("id_cliente"));
	            cliente.setNome(rset.getString("nomeCliente"));
	            cliente.setTelefone(rset.getString("telefone"));
	            cliente.setEmail(rset.getString("email"));
	            orcamento.setCliente(cliente);
	            
	            orcamentos.add(orcamento);
	        }

	    } catch (SQLException e) {

	        e.printStackTrace();

	    } finally {

	        BancoDeDados.desconectar(conexao);
	    }

	    return orcamentos;
	}
	
	 public void atualizarOrcamento(Orcamento orcamento) {
	        String sql = "UPDATE Orcamento SET tituloPedido = ?, statusPedido = ?, precoHora = ?, percentualLucro = ? , quantHrs = ?,"
	        		+ " quantDiasPedido = ?, valorAdicional = ?, valorGastos = ?, valorSemLucro = ? WHERE id_orcamento = ?";
	        Connection conexao = null;
	        PreparedStatement pstm = null;

	        try {
	            conexao = BancoDeDados.conectar();
	            pstm = conexao.prepareStatement(sql);
				pstm.setString(1, orcamento.getTituloPedido());
				pstm.setString(2, orcamento.getStatus().name().toLowerCase());
				pstm.setFloat(3, orcamento.getPrecoHora());
				pstm.setFloat(4, orcamento.getPercentualLucro());
				pstm.setFloat(5, orcamento.getQuantHorasPrevistas());
				pstm.setInt(6, orcamento.getMaxDias());
				pstm.setFloat(7, orcamento.getValorAdicional());
				pstm.setFloat(8, orcamento.getValorGastos());
				pstm.setFloat(9, orcamento.getValorSemLucro());
				pstm.setInt(10, orcamento.getIdOrcamento());
	            
	            
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