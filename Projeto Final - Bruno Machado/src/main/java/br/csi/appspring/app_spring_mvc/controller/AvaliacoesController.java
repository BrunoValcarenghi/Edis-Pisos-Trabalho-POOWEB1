package br.csi.appspring.app_spring_mvc.controller;

import br.csi.appspring.app_spring_mvc.model.Avaliacao;
import br.csi.appspring.app_spring_mvc.service.AvaliacoesService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class AvaliacoesController {

    @Autowired
    private AvaliacoesService avaliacoesService;

    @GetMapping("/avaliacao")
    public String listarAvaliacoes(HttpSession session, Model model) {
        System.out.println("chamou as avaliacoes");

        if (session == null || session.getAttribute("user") == null) {
            return "redirect:/index.jsp";
        }

        ArrayList<Avaliacao> avaliacoes = avaliacoesService.getAvaliacoes();
        model.addAttribute("avaliacoes", avaliacoes);
        return "avaliacoes";
    }

    @PostMapping("/avaliacao")
    public String publicarAvaliacao(@RequestParam("texto") String texto,
                                    @RequestParam("usuario_id") String usuarioId,
                                    HttpSession session,
                                    Model model) {

        System.out.println("chamou o post: publicar avaliacao");

        if (session == null || session.getAttribute("user") == null) {
            return "redirect:/index.jsp";
        }

        System.out.println("texto: " + texto + "\nid: " + usuarioId);

        if (avaliacoesService.publicar(texto, usuarioId)) {
            ArrayList<Avaliacao> avaliacoes = avaliacoesService.getAvaliacoes();
            model.addAttribute("avaliacoes", avaliacoes);
        } else {
            System.out.println("erro ao publicar avaliacao");
            model.addAttribute("erro", "OCORREU UM ERRO INESPERADO");
        }

        return "avaliacoes";
    }
}