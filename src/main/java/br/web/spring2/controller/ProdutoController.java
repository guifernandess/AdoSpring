/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.web.spring2.controller;

import br.web.ado.spring2.dao.DaoProduto;
import br.web.ado.spring2.model.Produto;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 *
 * @author Guilherme
 */
@Controller
@RequestMapping("/mvc/produto")
public class ProdutoController {

    @GetMapping
    public ModelAndView listar() throws Exception {
        DaoProduto service = new DaoProduto();
        List<Produto> lista = service.obterList();
        return new ModelAndView("produto/lista")
                .addObject("produtos", lista);
    }

    @GetMapping
    public ModelAndView deletar(Long id) throws Exception {
        DaoProduto service = new DaoProduto();
        String msg = "";
        try {
            service.deletar(id);
            msg = "id: " + id + " deletado com sucesso.";
        } catch (Exception e) {
            throw e;
        }
        return new ModelAndView("produto/deletar")
                .addObject("produtos", msg);
    }

    @GetMapping("/{id}")
    public ModelAndView obter(@PathVariable("id") Long id) throws Exception {
        DaoProduto service = new DaoProduto();
        Produto produto = service.obter(id);
        return new ModelAndView("produto/detalhe")
                .addObject("produto", produto);
    }

    @GetMapping("/formulario")
    public ModelAndView abrirFormulario() {
        return new ModelAndView("produto/formulario")
                .addObject("produto", new Produto());
    }

    @PostMapping("/salvar")
    public ModelAndView salvar(@ModelAttribute("produto") Produto produto) {
        return new ModelAndView("produto/resultado")
                .addObject("produto", produto);
    }

    @PostMapping("/salvar2")
    public ModelAndView salvarComPostRedirectGet(
            @ModelAttribute("produto") Produto produto,
            RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute("produto", produto);
        redirectAttributes.addFlashAttribute("msg", "Produto adicionado com sucesso");
        return new ModelAndView("redirect:/mvc/produto/formulario");
    }

    @GetMapping("/resultado")
    public ModelAndView mostrarResultado() {
        return new ModelAndView("produto/resultado");
    }

}
