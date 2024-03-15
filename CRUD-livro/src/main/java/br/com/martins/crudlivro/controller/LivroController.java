package br.com.martins.crudlivro.controller;

import br.com.martins.crudlivro.model.Livro;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/livros")
public class LivroController {


    @PostMapping
    public Livro criarLivro(@RequestBody Livro livro) {

        Livro livro1 = new Livro(livro.getTitulo(), livro.getAutor(), livro.getEditora(), livro.getDescricao(),
                livro.getGenero(), livro.getAnoLancamento());
        return livro1;
    }

    @PutMapping("/{id}")
    public void autualizarLivro(@PathVariable Long id, @RequestBody Livro livro){

    }

}
