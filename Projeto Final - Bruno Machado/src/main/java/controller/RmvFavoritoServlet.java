package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Favorito;
import model.Usuario;
import service.FavoritoService;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet("removerfavorito")
public class RmvFavoritoServlet extends HttpServlet {

    private FavoritoService fav = new FavoritoService();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        if (session == null || session.getAttribute("user") == null) {
            System.out.println("nao tava logado, voltou para index");
            resp.sendRedirect("index.jsp");
            return;
        }

        int usuario_id = Integer.parseInt(req.getParameter("usuario_id"));
        int produto_id = Integer.parseInt(req.getParameter("produto_id"));

        fav.removerFavorito(usuario_id, produto_id);

        Usuario user = (Usuario) session.getAttribute("user");
        ArrayList<Favorito> favoritos = fav.getFavoritos(user.getId());

        RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/pages/favoritos.jsp");
        req.setAttribute("favoritos", favoritos);
        rd.forward(req, resp);

    }
}
