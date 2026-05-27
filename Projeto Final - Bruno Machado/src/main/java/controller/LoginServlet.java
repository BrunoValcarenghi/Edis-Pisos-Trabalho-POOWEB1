package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Produto;
import model.Usuario;
import service.LoginService;
import service.ProdutoService;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet("login")
public class LoginServlet extends HttpServlet {

    private LoginService log = new LoginService();
    private ProdutoService prod = new ProdutoService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("chamou o post");

        String email = req.getParameter("email");
        String senha = req.getParameter("senha");

        System.out.println("email: " + email + " \nsenha: " + senha);

        Usuario uaut = log.autenticar(email, senha);
        ArrayList<Produto> produtos = prod.getProdutos();

        if (uaut != null){

            RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/pages/home.jsp");

            //req.setAttribute("user", uaut);
            HttpSession session = req.getSession();
            session.setAttribute("user", uaut);

            req.setAttribute("produtos", produtos);

            rd.forward(req, resp);

        }
        else{

            RequestDispatcher rd = req.getRequestDispatcher("index.jsp");
            System.out.println("erro");
            req.setAttribute("erro", "EMAIL OU SENHA INCORRETOS");

            rd.forward(req, resp);

        }

    }

/*
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("chamou o get");

        PrintWriter out = resp.getWriter();

        out.println("<html>");
        out.println("<body>");
        out.println("usuario clicou");
        out.println("</body>");
        out.println("</html>");

    }
*/

}
