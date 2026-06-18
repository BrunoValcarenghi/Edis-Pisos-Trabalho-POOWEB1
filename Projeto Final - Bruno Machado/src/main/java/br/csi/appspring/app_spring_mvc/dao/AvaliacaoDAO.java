package br.csi.appspring.app_spring_mvc.dao;

import br.csi.appspring.app_spring_mvc.model.Avaliacao;

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

        ResultSet rs = stnt.executeQuery("select a.id, a.usuario_id, a.texto, u.nome from avaliacao a inner join usuario u on u.id = a.usuario_id;");

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

    public boolean editar(int id, String texto, int usuario_id) throws SQLException {

        String sql = "UPDATE avaliacao SET texto = ? WHERE id = ? AND usuario_id = ?";

        try (Connection conn = ConexaoDB.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, texto);
            stmt.setInt(2, id);
            stmt.setInt(3, usuario_id);

            return stmt.executeUpdate() > 0;
        }

    }

    public boolean excluir(int id, int usuario_id) throws SQLException {

        String sql = "DELETE FROM avaliacao WHERE id = ? AND usuario_id = ?";

        try (Connection conn = ConexaoDB.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, id);
            stmt.setInt(2, usuario_id);

            return stmt.executeUpdate() > 0;
        }

    }

}
