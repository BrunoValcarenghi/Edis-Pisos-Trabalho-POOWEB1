package dao;

import model.Produto;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class ProdutoDAO {

    private static Connection conexao;
    private static Statement stnt;

    public ProdutoDAO() throws SQLException {

        conexao = ConexaoDB.getConexao();
        stnt = conexao.createStatement();

    }

    public ArrayList<Produto> getProdutos()throws SQLException {

        ArrayList<Produto> produtos = new ArrayList<>();

        ResultSet rs = stnt.executeQuery("select * from produto");

        while(rs.next()){

            Produto produto = new Produto();

            produto.setId(rs.getInt("id"));
            produto.setMarca(rs.getString("marca"));
            produto.setModelo(rs.getString("modelo"));

            produtos.add(produto);

        }

        return produtos;

    }

}
