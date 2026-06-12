package br.csi.appspring.app_spring_mvc.service;

import br.csi.appspring.app_spring_mvc.dao.AvaliacaoDAO;
import br.csi.appspring.app_spring_mvc.model.Avaliacao;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;

@Service
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
