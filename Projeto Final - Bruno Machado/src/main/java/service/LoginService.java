package service;

import dao.UsuarioDAO;
import model.Usuario;

public class LoginService {

   /* public boolean autenticar(String email, String senha){

            if (email.equals("teste@teste") && senha.equals("1234")){

                return true;

            }

        return false;

    }*/

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


}
