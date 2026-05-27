package service;

import dao.ProdutoDAO;
import dao.UsuarioDAO;
import model.Produto;
import model.Usuario;

import java.sql.SQLException;
import java.util.ArrayList;

public class ProdutoService {

    ProdutoDAO pdao;

    {
        try {
            pdao = new ProdutoDAO();
        } catch (SQLException e) {
            System.out.println("erro instanciar pdao");
        }
    }


    public ArrayList<Produto> getProdutos(){

        try {
            ArrayList<Produto> produtos = pdao.getProdutos();
            return produtos;
        } catch (SQLException e) {
            System.out.println("erro getprodutos");
        }

        return null;

    }

}
