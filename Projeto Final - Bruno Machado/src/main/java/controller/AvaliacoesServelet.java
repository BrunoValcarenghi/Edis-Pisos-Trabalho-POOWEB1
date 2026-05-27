package controller;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import model.Avaliacao;
import service.AvaliacoesService;
import service.CadastroService;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet("avaliacao")
public class AvaliacoesServelet extends HttpServlet {

    private AvaliacoesService avaliacao = new AvaliacoesService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("chamou as avaliacoes");

        HttpSession session = req.getSession();
        if (session == null || session.getAttribute("user") == null) {
            System.out.println("nao tava logado, voltou para index");
            resp.sendRedirect("index.jsp");
            return;
        }

        ArrayList<Avaliacao> avaliacoes = avaliacao.getAvaliacoes();

        RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/pages/avaliacoes.jsp");
        req.setAttribute("avaliacoes", avaliacoes);
        rd.forward(req, resp);

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("chamou o post: publicar avaliacao");

        HttpSession session = req.getSession();
        if (session == null || session.getAttribute("user") == null) {
            System.out.println("nao tava logado, voltou para index");
            resp.sendRedirect("index.jsp");
            return;
        }

        String texto = req.getParameter("texto");
        String usuario_id = req.getParameter("usuario_id");

        System.out.println("texto: " + texto + "\nid: " + usuario_id);

        if (avaliacao.publicar(texto, usuario_id)){

            ArrayList<Avaliacao> avaliacoes = avaliacao.getAvaliacoes();

            RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/pages/avaliacoes.jsp");
            req.setAttribute("avaliacoes", avaliacoes);
            rd.forward(req, resp);

        }
        else{

            RequestDispatcher rd = req.getRequestDispatcher("WEB-INF/pages/avaliacoes.jsp");
            System.out.println("erro ao publicar avaliacao");
            req.setAttribute("erro", "OCORREU UM ERRO INESPERADO");

            rd.forward(req, resp);

        }

    }
}