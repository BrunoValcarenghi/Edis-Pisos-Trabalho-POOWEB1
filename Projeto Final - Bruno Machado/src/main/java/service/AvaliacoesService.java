package service;

import dao.AvaliacaoDAO;
import dao.ProdutoDAO;
import dao.UsuarioDAO;
import model.Avaliacao;
import model.Produto;

import java.sql.SQLException;
import java.util.ArrayList;

public class AvaliacoesService {

    AvaliacaoDAO adao;

    {
        try {
            adao = new AvaliacaoDAO();
        } catch (SQLException e) {
            System.out.println("erro instanciar pdao");
        }
    }


    public ArrayList<Avaliacao> getAvaliacoes(){

        try {
            ArrayList<Avaliacao> avaliacoes = adao.getAvaliacoes();
            return avaliacoes;
        } catch (SQLException e) {
            System.out.println("erro getavaliacoes");
        }

        return null;

    }

    public Boolean publicar(String texto, String usuario_id) {

        try {
            AvaliacaoDAO dao = new AvaliacaoDAO();
            return dao.inserir(texto, usuario_id);
        } catch (Exception e) {
            System.out.println("erro cadastrar publicar avaliacao service");
        }
        return false;

    }

}
