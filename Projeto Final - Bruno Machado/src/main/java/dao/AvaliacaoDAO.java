package dao;

import model.Avaliacao;
import model.Produto;

import java.sql.*;
import java.util.ArrayList;

public class AvaliacaoDAO {

    private static Connection conexao;
    private static Statement stnt;

    public AvaliacaoDAO() throws SQLException {

        conexao = ConexaoDB.getConexao();
        stnt = conexao.createStatement();

    }

    public ArrayList<Avaliacao> getAvaliacoes()throws SQLException {

        ArrayList<Avaliacao> avaliacoes = new ArrayList<>();

        ResultSet rs = stnt.executeQuery("select * from usuario, avaliacao where usuario.id = avaliacao.usuario_id;");

        while(rs.next()){

            Avaliacao avaliacao = new Avaliacao();

            avaliacao.setId(rs.getInt("id"));
            avaliacao.setUsuario_id(rs.getInt("usuario_id"));
            avaliacao.setTexto(rs.getString("texto"));
            avaliacao.setNome(rs.getString("nome"));

            avaliacoes.add(avaliacao);

        }

        return avaliacoes;

    }

    public boolean inserir(String texto, String usuario_id) throws SQLException {

        String sql = "INSERT INTO avaliacao (texto, usuario_id) VALUES (?, ?)";

        System.out.println("[avaliacao dao] chegou aqui");

        Connection conn = ConexaoDB.getConexao();
        PreparedStatement stmt = conn.prepareStatement(sql);

        System.out.println("[avaliacao dao] chegou aqui tambem");

        stmt.setString(1, texto);
        stmt.setInt(2, Integer.parseInt(usuario_id));

        System.out.println("[avaliacao dao] " + sql);

        stmt.executeUpdate();

        System.out.println("[avaliacao dao] inseriu avaliacao");

        return true;

    }

}
