package br.com.jpcadinelli.JavaFilmes.repository;

import br.com.jpcadinelli.JavaFilmes.model.Filme;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class FilmeRepository {

    private final List<Filme> filmes = new ArrayList<>();
    private Long nextId = 1L;

    public List<Filme> findAll() {
        return filmes;
    }

    public Optional<Filme> findById(Long id) {
        return filmes.stream().filter(f -> f.getId().equals(id)).findFirst();
    }

    public Filme save(Filme filme) {
        if (filme.getId() == null) {
            filme.setId(nextId++);
            filmes.add(filme);
        } else {
            deleteById(filme.getId());
            filmes.add(filme);
        }
        return filme;
    }

    public void deleteById(Long id) {
        filmes.removeIf(f -> f.getId().equals(id));
    }
}

