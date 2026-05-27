package dao;

import model.Usuario;

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

        /*
        String sql = "insert into usuario(nome, email, senha)" + " values(" + "'" + nome + "'" + "," + "'" + email + "'" + "," + "'" + senha + "');";

        System.out.println(sql);
        stnt.executeQuery(sql);

        System.out.println("inseriu usuario");
        */

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

    /*
    public boolean inserir(Usuario u) throws SQLException {

        String sql =    "insert into usuario(nome, email, senha)" +
                " values(" + "'" + u.getNome() + "'" + "," + "'" + u.getEmail() + "'" + "," + "'" + u.getSenha() + "');";

        System.out.println(sql);
        stnt.executeQuery(sql);

        System.out.println("inseriu usuario");

        return true;

    }

    public void excluir(Usuario u) throws SQLException {

        String sql = "delete from usuario where id = " + "'" + u.getId() + "'" ;
        stnt.executeQuery(sql);

    }

    public void excluir(int id) throws SQLException {

        String sql = "delete from usuario where id = " + "'" + id + "'" ;
        stnt.executeQuery(sql);

    }

    public boolean atualizar(Usuario u) throws SQLException {

        String sql = "update usuario set nome = '"+ u.getNome() +"', email = '"+ u.getEmail() +"', senha = '"+ u.getSenha() +"' where id = + '" + u.getId() + "';";
        stnt.executeQuery(sql);

        return false;

    }


    */


}
