package network.webtech.labspringmvc.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

import network.webtech.labspringmvc.models.Produto;
import network.webtech.labspringmvc.services.ProdutoService;

@RestController
@RequestMapping("/api/produtos")
public class Produtos {

    @Autowired
    private ProdutoService produtoService;

    @GetMapping
    public List<Produto> listarProdutos() {
        return produtoService.listarProdutos();
    }

    @GetMapping("/{id}")
    public Optional<Produto> buscarPorId(@PathVariable String id) {
        return produtoService.buscarPorId(id);
    }

    @PostMapping
    public Produto adicionarProduto(@RequestBody Produto produto) {
        return produtoService.adicionarProduto(produto);
    }

    @DeleteMapping("/{id}")
    public String deletarProduto(@PathVariable String id) {
        boolean result = produtoService.deletarProduto(id);
        if (result) {
            return "Produto deletado";
        } else {
            return "Produto nao encontrado";
        }
    }

    @PutMapping("/{id}")
    public Produto atualizarProduto( @PathVariable String id, @RequestBody Produto produto) {
        return produtoService.atualizarProduto(id, produto);
    }

}