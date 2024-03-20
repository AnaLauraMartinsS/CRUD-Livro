package br.com.martins.crudlivro.repository;

import br.com.martins.crudlivro.model.Livro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LivroRepository extends JpaRepository<Livro, Long> {

}
