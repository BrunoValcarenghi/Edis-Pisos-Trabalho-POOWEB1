package br.csi.appspring.app_spring_mvc.service;

import br.csi.appspring.app_spring_mvc.dao.UsuarioDAO;
import br.csi.appspring.app_spring_mvc.model.Usuario;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {

    public Usuario autenticar(String email, String senha) {

        try {
            UsuarioDAO dao = new UsuarioDAO();
            Usuario u = dao.autenticar(email, senha);
            return u;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;

    }

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
