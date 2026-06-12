package br.csi.appspring.app_spring_mvc.controller;

import br.csi.appspring.app_spring_mvc.model.Favorito;
import br.csi.appspring.app_spring_mvc.model.Usuario;
import br.csi.appspring.app_spring_mvc.service.FavoritoService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class FavoritosController {

    @Autowired
    private FavoritoService favoritoService;

    @GetMapping("/favoritos")
    public String listarFavoritos(HttpSession session, Model model) {
        if (session == null || session.getAttribute("user") == null) {
            return "redirect:/index.jsp";
        }

        Usuario user = (Usuario) session.getAttribute("user");
        ArrayList<Favorito> favoritos = favoritoService.getFavoritos(user.getId());

        model.addAttribute("favoritos", favoritos);
        return "favoritos";
    }

    @PostMapping("/favoritos")
    public String adicionarFavorito(@RequestParam("id") int produtoId, HttpSession session, Model model) {
        if (session == null || session.getAttribute("user") == null) {
            return "redirect:/index.jsp";
        }

        Usuario user = (Usuario) session.getAttribute("user");
        favoritoService.adicionarFavorito(user.getId(), produtoId);

        ArrayList<Favorito> favoritos = favoritoService.getFavoritos(user.getId());
        model.addAttribute("favoritos", favoritos);
        return "favoritos";
    }

    @PostMapping("/removerfavorito")
    public String removerFavorito(@RequestParam("usuario_id") int usuarioId,
                                  @RequestParam("produto_id") int produtoId,
                                  HttpSession session,
                                  Model model) {

        if (session == null || session.getAttribute("user") == null) {
            return "redirect:/index.jsp";
        }

        favoritoService.removerFavorito(usuarioId, produtoId);

        Usuario user = (Usuario) session.getAttribute("user");
        ArrayList<Favorito> favoritos = favoritoService.getFavoritos(user.getId());

        model.addAttribute("favoritos", favoritos);
        return "favoritos";
    }
}