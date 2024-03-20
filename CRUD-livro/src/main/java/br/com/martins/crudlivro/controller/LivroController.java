package br.com.martins.crudlivro.controller;

import br.com.martins.crudlivro.exception.LivroInvalidoException;
import br.com.martins.crudlivro.model.Livro;
import br.com.martins.crudlivro.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/livros")
public class LivroController {

    @Autowired
    private LivroService service;

    @PostMapping
    public Livro criarLivro(@RequestBody Livro livro) {
        Livro livro1 = service.criarLivro(livro);
        return livro1;
    }

    @GetMapping("/listar")
    public List<Livro> listarLivro(){
        return service.listaLivro();
    }

    @PutMapping("/{id}")
    public Livro autualizarLivro(@PathVariable Long id, @RequestBody Livro livro){
        return service.autualizarLivro(livro, id);
    }

    @DeleteMapping("/{id}")
    public String deletarLivro(@PathVariable Long id){
        service.deltarLivro(id);
        return "deletado com su su sucesso!";
    }

}
