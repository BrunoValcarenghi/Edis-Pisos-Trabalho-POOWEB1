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

@WebServlet("catalogo")
public class CatalogoServlet extends HttpServlet {

    private ProdutoService prod = new ProdutoService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("chamou o link para catalogo");

        HttpSession session = req.getSession();
        if (session == null || session.getAttribute("user") == null) {
            System.out.println("nao tava logado, voltou para index");
            resp.sendRedirect("index.jsp");
            return;
        }

        ArrayList<Produto> produtos = prod.getProdutos();

        if (produtos != null){

            RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/pages/home.jsp");
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

}
