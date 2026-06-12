package br.csi.appspring.app_spring_mvc.dao;

import br.csi.appspring.app_spring_mvc.model.Usuario;

import java.sql.*;
import java.util.ArrayList;

public class UsuarioDAO {

    private static Connection conexao;
    private static Statement stnt;

    public UsuarioDAO() throws SQLException {

        conexao = ConexaoDB.getConexao();
        stnt = conexao.createStatement();

    }

    public Usuario autenticar(String email, String senha) throws SQLException {

        String sql = "select * from usuario where email = '" + email + "' and senha = '" + senha + "'";
        System.out.println(sql);
        ResultSet rs = stnt.executeQuery(sql);

        while (rs.next()){

            Usuario u = new Usuario();
            u.setId(rs.getInt("id"));
            u.setNome(rs.getString("nome"));
            u.setEmail(rs.getString("email"));

            return u;

        }

        return null;

    }

    public boolean inserir(String nome, String email, String senha) throws SQLException {

        String sql = "INSERT INTO usuario (nome, email, senha) VALUES (?, ?, ?)";

        Connection conn = ConexaoDB.getConexao();
        PreparedStatement stmt = conn.prepareStatement(sql);

        stmt.setString(1, nome);
        stmt.setString(2, email);
        stmt.setString(3, senha);

        System.out.println(sql);

        stmt.executeUpdate();

        System.out.println("inseriu usuario");

        return true;

    }

    public ArrayList<Usuario> getUsuario()throws SQLException {

        ArrayList<Usuario> usuarios = new ArrayList<>();

        ResultSet rs = stnt.executeQuery("select * from usuario");

        while(rs.next()){

            Usuario usuario = new Usuario();

            usuario.setId(rs.getInt("id"));
            usuario.setNome(rs.getString("nome"));
            usuario.setEmail(rs.getString("email"));
            usuario.setSenha(rs.getString("senha"));

            usuarios.add(usuario);

        }

        return usuarios;

    }

}
