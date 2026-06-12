package br.csi.appspring.app_spring_mvc.controller;

import br.csi.appspring.app_spring_mvc.model.Produto;
import br.csi.appspring.app_spring_mvc.model.Usuario;
import br.csi.appspring.app_spring_mvc.service.UsuarioService;
import br.csi.appspring.app_spring_mvc.service.ProdutoService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;

@Controller
public class UsuarioController {

    @Autowired
    private UsuarioService usuarioService;

    @Autowired
    private ProdutoService produtoService;

    @GetMapping("/")
    public String encaminharParaLogin() {
        System.out.println("Renderizando index.jsp");
        return "index";
    }

    @PostMapping("/login")
    public String login(@RequestParam("email") String email,
                        @RequestParam("senha") String senha,
                        HttpSession session,
                        Model model) {

        System.out.println("Tentativa de login - Email: " + email);

        Usuario uaut = usuarioService.autenticar(email, senha);
        ArrayList<Produto> produtos = produtoService.getProdutos();

        if (uaut != null) {
            session.setAttribute("user", uaut);
            model.addAttribute("produtos", produtos);
            return "home";
        } else {
            System.out.println("Erro: Email ou senha incorretos");
            model.addAttribute("erro", "EMAIL OU SENHA INCORRETOS");
            return "index";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        System.out.println("Chamou o logout: invalidando sessão");
        if (session != null) {
            session.invalidate();
        }
        return "redirect:/";
    }

    @GetMapping("/cadastro")
    public String paginaCadastro() {
        System.out.println("Chamou o get: abrindo página de cadastro");
        return "cadastro";
    }

    @PostMapping("/cadastro")
    public String cadastrar(@RequestParam("nome") String nome,
                            @RequestParam("email") String email,
                            @RequestParam("senha") String senha,
                            Model model) {

        System.out.println("Tentativa de cadastro - Nome: " + nome + " | Email: " + email);

        if (usuarioService.cadastrar(nome, email, senha)) {
            return "index";
        } else {
            System.out.println("Erro ao cadastrar usuário");
            model.addAttribute("erro", "OCORREU UM ERRO INESPERADO");
            return "cadastro";
        }
    }
}