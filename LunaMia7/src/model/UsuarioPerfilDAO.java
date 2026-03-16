
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.BancoDeDados;
import view.CadastroUsuario;
import model.UsuarioPerfil;


public class UsuarioPerfilDAO {
	
	//MUDEI AQUI
    public void adicionarDados(UsuarioPerfil usuarioPerfil) {
        String sql = "INSERT INTO perfil_usuario (email, senha, nrTelefone, nomeUsuario, nome, precoHora, endereco, percentualLucro) "
        		+ "VALUES (?,?,?,?,?,?,?,?)";
        Connection conexao = null;
        PreparedStatement pstm = null;

        try {
            conexao = BancoDeDados.conectar();
            pstm = conexao.prepareStatement(sql);
            //pstm.setString(1, usuarioPerfil.get());
            pstm.setString(1, usuarioPerfil.getEmail());
            pstm.setString(2, usuarioPerfil.getSenha());
            pstm.setString(3, usuarioPerfil.getTelefone());
            pstm.setString(4, usuarioPerfil.getNomeUsuario());
            pstm.setString(5, usuarioPerfil.getNome());
            pstm.setFloat(6, usuarioPerfil.getPrecoHora());
            pstm.setString(7, usuarioPerfil.getEndereco());
            pstm.setFloat(8, usuarioPerfil.getPercentualLucro());         
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
    
    public List<UsuarioPerfil> listarUsuarios() {
        String sql = "SELECT * FROM usuario_perfil";
        List<UsuarioPerfil> usuarios = new ArrayList<>();
        Connection conexao = null;
        PreparedStatement pstm = null;
        ResultSet rset = null; // Objeto que guarda o resultado da consulta

        try {
            conexao = BancoDeDados.conectar();
            pstm = conexao.prepareStatement(sql);
            rset = pstm.executeQuery();

            while (rset.next()) {
                UsuarioPerfil usuario = new UsuarioPerfil(sql, sql, sql, sql, sql, sql, 0, 0, null);
                usuario.setNome(rset.getString("nome"));
                usuario.setNomeUsuario(rset.getString("nomeUsuario"));
                usuario.setEmail(rset.getString("email"));
                usuario.setEndereco(rset.getString ("endereco"));
                usuario.setTelefone(rset.getString("senha"));
                usuario.setSenha(rset.getString("senha"));
                usuario.setPercentualLucro(rset.getFloat(0));
                usuario.setPrecoHora(rset.getFloat(0));
            //    usuario.setFotoPerfil(rset.getByte("null"));
                usuarios.add(usuario);
                
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
 //       	BancoDeDados.desconectar(conexao);
            // Fechar recursos
        }
        return usuarios;
    }

}