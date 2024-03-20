package br.com.martins.crudlivro.model;

import br.com.martins.crudlivro.exception.LivroInvalidoException;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
public class Livro {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String titulo;
    private String autor;
    private String editora;
    private String descricao;
    private String genero;
    private Integer anoLancamento;

    public Livro(String titulo, String autor, String editora, String descricao, String genero, Integer anoLancamento) {
        this.titulo = titulo;
        this.autor = autor;
        this.editora = editora;
        this.descricao = descricao;
        this.genero = genero;
        this.anoLancamento = anoLancamento;
    }
}
