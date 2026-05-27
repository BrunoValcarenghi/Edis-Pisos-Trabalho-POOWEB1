package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Favorito;
import model.Produto;
import model.Usuario;
import service.FavoritoService;
import service.ProdutoService;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet("favoritos")
public class FavoritosServlet extends HttpServlet {

    private FavoritoService fav = new FavoritoService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("chamou o link para favorito");

        HttpSession session = req.getSession();
        if (session == null || session.getAttribute("user") == null) {
            System.out.println("nao tava logado, voltou para index");
            resp.sendRedirect("index.jsp");
            return;
        }

        Usuario user = (Usuario) session.getAttribute("user");
        ArrayList<Favorito> favoritos = fav.getFavoritos(user.getId());

        RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/pages/favoritos.jsp");
        req.setAttribute("favoritos", favoritos);
        rd.forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("chamou o post: adicionar favorito");

        HttpSession session = req.getSession();
        if (session == null || session.getAttribute("user") == null) {
            System.out.println("nao tava logado, voltou para index");
            resp.sendRedirect("index.jsp");
            return;
        }

        int produto_id = Integer.parseInt(req.getParameter("id"));
        Usuario user = (Usuario) session.getAttribute("user");
        int usuario_id = user.getId();


        System.out.println("produto: " + produto_id + "\nusuario: " + usuario_id );

        fav.adicionarFavorito(usuario_id, produto_id);

        RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/pages/favoritos.jsp");
        ArrayList<Favorito> favoritos = fav.getFavoritos(user.getId());
        req.setAttribute("favoritos", favoritos);
        rd.forward(req, resp);

    }
}
