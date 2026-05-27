package dao;

import model.Avaliacao;
import model.Favorito;

import java.sql.*;
import java.util.ArrayList;

public class FavoritoDAO {

    private static Connection conexao;
    private static Statement stnt;

    public FavoritoDAO() throws SQLException {

        conexao = ConexaoDB.getConexao();
        stnt = conexao.createStatement();

    }

    public boolean EFavorito(int usuario_id, int produto_id) throws SQLException {
        String sql = "SELECT COUNT(*) FROM favorito WHERE usuario_id = ? AND produto_id = ?";

        try (Connection conn = ConexaoDB.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, usuario_id);
            stmt.setInt(2, produto_id);

            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1) > 0;
                }
            }
        }
        return false;
    }

    public boolean adicionarFavorito(int usuario_id, int produto_id) throws SQLException {
        if (EFavorito(usuario_id, produto_id)) {
            System.out.println("[FavoritoDAO] Produto já está nos favoritos deste usuário.");
            return false;
        }

        String sql = "INSERT INTO favorito (usuario_id, produto_id) VALUES (?, ?)";
        try (Connection conn = ConexaoDB.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, usuario_id);
            stmt.setInt(2, produto_id);
            stmt.executeUpdate();
            System.out.println("[FavoritoDAO] Adicionado aos favoritos");
            return true;
        }
    }

    public ArrayList<Favorito> getFavoritos(int usuario_id)throws SQLException {

        ArrayList<Favorito> favoritos = new ArrayList<>();

        ResultSet rs = stnt.executeQuery("select * from favorito, usuario, produto where usuario.id = " + usuario_id + " and produto.id = favorito.produto_id and favorito.usuario_id = 1");

        while(rs.next()){

            Favorito favorito = new Favorito();

            favorito.setId(rs.getInt("id"));
            favorito.setUsuario_id(rs.getInt("usuario_id"));
            favorito.setProduto_id(rs.getInt("produto_id"));
            favorito.setMarca(rs.getString("marca"));
            favorito.setModelo(rs.getString("modelo"));

            favoritos.add(favorito);

        }

        return favoritos;

    }

    public boolean removerFavorito(int usuario_id, int produto_id) throws SQLException {

        String sql = "DELETE FROM favorito WHERE usuario_id = ? AND produto_id = ?";
        try (Connection conn = ConexaoDB.getConexao();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setInt(1, usuario_id);
            stmt.setInt(2, produto_id);
            System.out.println(sql);
            stmt.executeUpdate();
            System.out.println("[FavoritoDAO] removido dos favoritos");
            return true;
        }
    }


}