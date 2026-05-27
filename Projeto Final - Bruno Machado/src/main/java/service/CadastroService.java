package service;

import dao.UsuarioDAO;
import model.Usuario;

public class CadastroService {

    public Boolean cadastrar(String nome, String email, String senha) {

        try {
            UsuarioDAO dao = new UsuarioDAO();
            return dao.inserir(nome, email, senha);
        } catch (Exception e) {
            System.out.println("erro cadastrar cadastro service");
        }
        return false;

    }


}
