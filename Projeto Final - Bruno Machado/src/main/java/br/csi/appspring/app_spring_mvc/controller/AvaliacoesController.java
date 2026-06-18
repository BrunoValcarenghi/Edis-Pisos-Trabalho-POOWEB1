package br.csi.appspring.app_spring_mvc.controller;

import br.csi.appspring.app_spring_mvc.model.Avaliacao;
import br.csi.appspring.app_spring_mvc.model.Usuario;
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
                                    HttpSession session,
                                    Model model) {

        System.out.println("chamou o post: publicar avaliacao");

        if (session == null || session.getAttribute("user") == null) {
            return "redirect:/index.jsp";
        }

        Usuario user = (Usuario) session.getAttribute("user");
        String usuarioId = String.valueOf(user.getId());

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

    @PostMapping("/editaravaliacao")
    public String editarAvaliacao(@RequestParam("id") int id,
                                  @RequestParam("texto") String texto,
                                  HttpSession session,
                                  Model model) {

        if (session == null || session.getAttribute("user") == null) {
            return "redirect:/index.jsp";
        }

        Usuario user = (Usuario) session.getAttribute("user");

        if (!avaliacoesService.editar(id, texto, user.getId())) {
            model.addAttribute("erro", "Nao foi possivel editar esta avaliacao.");
        }

        ArrayList<Avaliacao> avaliacoes = avaliacoesService.getAvaliacoes();
        model.addAttribute("avaliacoes", avaliacoes);
        return "avaliacoes";
    }

    @PostMapping("/excluiravaliacao")
    public String excluirAvaliacao(@RequestParam("id") int id,
                                   HttpSession session,
                                   Model model) {

        if (session == null || session.getAttribute("user") == null) {
            return "redirect:/index.jsp";
        }

        Usuario user = (Usuario) session.getAttribute("user");

        if (!avaliacoesService.excluir(id, user.getId())) {
            model.addAttribute("erro", "Nao foi possivel excluir esta avaliacao.");
        }

        ArrayList<Avaliacao> avaliacoes = avaliacoesService.getAvaliacoes();
        model.addAttribute("avaliacoes", avaliacoes);
        return "avaliacoes";
    }
}
