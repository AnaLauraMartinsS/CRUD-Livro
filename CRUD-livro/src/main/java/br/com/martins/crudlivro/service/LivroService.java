package br.com.martins.crudlivro.service;

import br.com.martins.crudlivro.exception.LivroInvalidoException;
import br.com.martins.crudlivro.model.Livro;
import br.com.martins.crudlivro.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.List;
import java.util.Optional;

@Service
@Validated
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    public Livro criarLivro(Livro livro) {
        Livro livro1 = new Livro(livro.getTitulo(), livro.getAutor(), livro.getEditora(), livro.getDescricao(), livro.getGenero(), livro.getAnoLancamento());
        if(livro.getTitulo() == null || livro.getAutor() == null || livro.getEditora() == null || livro.getDescricao() == null || livro.getGenero() == null || livro.getAnoLancamento() == null){
            throw new LivroInvalidoException("O livro não pode ser criado!");
        }

        if(livro.getTitulo().equals("") || livro.getAutor().equals("") || livro.getEditora().equals("") || livro.getDescricao().equals("") || livro.getGenero().equals("") || livro.getAnoLancamento().equals(0)){
            throw new LivroInvalidoException("O livro não pode ser criado!");
        }
        this.livroRepository.save(livro1);
        return livro1;
    }

    public List<Livro> listaLivro() {
        return livroRepository.findAll();
    }

    public Livro autualizarLivro(Livro livroAtualizado, Long id) throws LivroInvalidoException {
        Optional<Livro> livroModificado = livroRepository.findById(id);
        if(!livroModificado.isPresent()) throw new LivroInvalidoException("Livro não encontrado");
        Livro livro = livroModificado.get();

        if(livroAtualizado.getAutor() != null) livro.setAutor(livroAtualizado.getAutor());
        if(livroAtualizado.getTitulo() != null) livro.setTitulo(livroAtualizado.getTitulo());
        if(livroAtualizado.getGenero() != null) livro.setGenero(livroAtualizado.getGenero());
        if(livroAtualizado.getDescricao() != null) livro.setDescricao(livroAtualizado.getDescricao());
        if(livroAtualizado.getEditora() != null) livro.setEditora(livroAtualizado.getEditora());
        if(livroAtualizado.getAnoLancamento() != null) livro.setAnoLancamento(livroAtualizado.getAnoLancamento());
        livroRepository.save(livro);

        return livro;
    }

    public void deltarLivro(Long id){
        Optional<Livro> livroDeletado = livroRepository.findById(id);
        if(!livroDeletado.isPresent()) throw new LivroInvalidoException("Livro não encontrado");
        livroRepository.deleteById(id);
    }

}

