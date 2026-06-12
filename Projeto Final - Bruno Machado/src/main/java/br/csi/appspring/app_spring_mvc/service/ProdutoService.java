package br.csi.appspring.app_spring_mvc.service;

import br.csi.appspring.app_spring_mvc.dao.ProdutoDAO;
import br.csi.appspring.app_spring_mvc.model.Produto;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;

@Service
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
