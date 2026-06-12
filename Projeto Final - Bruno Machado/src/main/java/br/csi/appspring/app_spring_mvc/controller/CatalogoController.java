package br.csi.appspring.app_spring_mvc.controller;

import br.csi.appspring.app_spring_mvc.model.Produto;
import br.csi.appspring.app_spring_mvc.service.ProdutoService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

@Controller
public class CatalogoController {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping("/catalogo")
    public String listarCatalogo(HttpSession session, Model model) {
        System.out.println("chamou o link para catalogo");

        if (session == null || session.getAttribute("user") == null) {
            System.out.println("nao tava logado, voltou para index");
            return "redirect:/index.jsp";
        }

        ArrayList<Produto> produtos = produtoService.getProdutos();

        if (produtos != null) {
            model.addAttribute("produtos", produtos);
            return "home";
        } else {
            System.out.println("erro");
            model.addAttribute("erro", "EMAIL OU SENHA INCORRETOS");
            return "index";
        }
    }
}