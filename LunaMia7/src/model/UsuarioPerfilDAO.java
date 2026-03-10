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
	
    public void adicionarDados(CadastroUsuario cadastroUsuario) {
        String sql = "INSERT INTO perfil_usuario (email, senha, nrTelefone, nomeUsuario, nome, precoHora, endereco, percentualLucro) "
        		+ "VALUES (?, ?, ?,?,?,?,?,?)";
        Connection conexao = null;
        PreparedStatement pstm = null;

        try {
            conexao = BancoDeDados.conectar();
            pstm = conexao.prepareStatement(sql);
    //        pstm.setString(1, cadastroUsuario.get());
     //       pstm.setString(2, cadastroUsuario.getEmail());
    //        pstm.setString(3, cadastroUsuario.getEndereco());
   //         pstm.setString(4, cadastroUsuario.getNomeUsuario());
   //         pstm.setString(5, cadastroUsuario.getSenha());
  //          pstm.setString(6, cadastroUsuario.getTelefone());
  //          pstm.setFloat(7, cadastroUsuario.getPrecoHora());
//            pstm.setFloat(8,cadastroUsuario.getPercentualLucro());         
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
                usuario.setEmail(rset.getString("email"));
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
