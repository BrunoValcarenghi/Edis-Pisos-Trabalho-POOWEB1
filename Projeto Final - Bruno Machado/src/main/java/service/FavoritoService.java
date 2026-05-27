package service;

import dao.AvaliacaoDAO;
import dao.FavoritoDAO;
import model.Avaliacao;
import model.Favorito;

import java.sql.SQLException;
import java.util.ArrayList;

public class FavoritoService {

    FavoritoDAO fdao;

    {
        try {
            fdao = new FavoritoDAO();
        } catch (SQLException e) {
            System.out.println("erro instanciar fdao");
        }
    }


    public ArrayList<Favorito> getFavoritos(int usuario_id){

        try {
            ArrayList<Favorito> favoritos = fdao.getFavoritos(usuario_id);
            return favoritos;
        } catch (SQLException e) {
            System.out.println("erro getavaliacoes");
        }

        return null;

    }

    public boolean adicionarFavorito(int usuario_id, int produto_id) {

        try {
            FavoritoDAO dao = new FavoritoDAO();
            return dao.adicionarFavorito(usuario_id, produto_id);
        } catch (Exception e) {
            System.out.println("erro adicionar favorito service");
        }
        return false;

    }

    public boolean removerFavorito(int usuario_id, int produto_id){

        try {
            FavoritoDAO dao = new FavoritoDAO();
            return dao.removerFavorito(usuario_id, produto_id);
        } catch (Exception e) {
            System.out.println("erro remover favorito service");
        }
        return false;

    }

}
