
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.BancoDeDados;

public class ClienteDAO {

	public void adicionarDados(Cliente cliente) {

		String sql = "INSERT INTO Cliente (nomeCliente, telefone, email) VALUES (?,?,?)";
		Connection conexao = null;
		PreparedStatement pstm = null;
		ResultSet rs = null;

		try {
			conexao = BancoDeDados.conectar();
			pstm = conexao.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS);
			pstm.setString(1, cliente.getNome());
			pstm.setString(2, cliente.getTelefone());
			pstm.setString(3, cliente.getEmail());
			pstm.executeUpdate();
			
			rs = pstm.getGeneratedKeys();
			
			if(rs.next()) {
				cliente.setIdCliente(rs.getInt(1));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			try {
		        if (rs != null) rs.close();
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }

			if (pstm != null) {
				try {
					pstm.close();
				} catch (SQLException e) {
					e.printStackTrace();
				}
			}
			
			BancoDeDados.desconectar(conexao);
		}
	}
	public List<Cliente> listarClientes() {
        String sql = "SELECT * FROM Cliente";
        List<Cliente> clientes = new ArrayList<>();
        Connection conexao = null;
        PreparedStatement pstm = null;
        ResultSet rset = null; // Objeto que guarda o resultado da consulta

        try {
            conexao = BancoDeDados.conectar();
            pstm = conexao.prepareStatement(sql);
            rset = pstm.executeQuery();

            while (rset.next()) {
                Cliente cliente = new Cliente(null, null, null);
                cliente.setNome(rset.getString("nomeCliente"));
                cliente.setTelefone(rset.getString("telefone"));
                cliente.setEmail(rset.getString("email"));
                
                cliente.setIdCliente(rset.getInt("id_cliente"));
                
                clientes.add(cliente);
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        	BancoDeDados.desconectar(conexao);
            // Fechar recursos
        }
        return clientes;
    }
	
	// UPDATE - Atualizar um usuário existente
    public void atualizarCliente(Cliente cliente) {
        String sql = "UPDATE Cliente SET nomeCliente = ?, telefone = ?, email = ? WHERE id_cliente = ?";
        Connection conexao = null;
        PreparedStatement pstm = null;

        try {
            conexao = BancoDeDados.conectar();
            pstm = conexao.prepareStatement(sql);
            pstm.setString(1, cliente.getNome());
            pstm.setString(2, cliente.getTelefone());
            pstm.setString(3, cliente.getEmail());;
            pstm.setInt(4, cliente.getIdCliente());
            pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        	BancoDeDados.desconectar(conexao);
        }
    }
    
    public void excluirCliente(Cliente cliente) {
        String sql = "DELETE FROM Cliente WHERE id_cliente = ?";
        Connection conexao = null;
        PreparedStatement pstm = null;

        try {
            conexao = BancoDeDados.conectar();
            pstm = conexao.prepareStatement(sql);
            pstm.setInt(1, cliente.getIdCliente());
            pstm.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
        	BancoDeDados.desconectar(conexao);
        }
    }
}