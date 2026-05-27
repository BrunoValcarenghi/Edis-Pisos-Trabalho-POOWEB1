package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import model.Usuario;
import service.CadastroService;
import service.LoginService;

import java.io.IOException;

@WebServlet("cadastro")
public class CadastroServlet extends HttpServlet {

    private CadastroService log = new CadastroService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("chamou o get: pagina cadastro");
        req.getRequestDispatcher("WEB-INF/pages/cadastro.jsp").forward(req, resp);
    }


    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("chamou o post: cadastrar");

        String nome = req.getParameter("nome");
        String email = req.getParameter("email");
        String senha = req.getParameter("senha");

        System.out.println("nome: " + nome + "\nemail: " + email + " \nsenha: " + senha);

        if (log.cadastrar(nome,email,senha)){

            RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
            rd.forward(req, resp);

        }
        else{

            RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/pages/cadastro.jsp");
            System.out.println("erro ao cadastrar cadastro servlet");
            req.setAttribute("erro", "OCORREU UM ERRO INESPERADO");

            rd.forward(req, resp);

        }

    }
}