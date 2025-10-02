package br.com.jpcadinelli.JavaFilmes.service;

import br.com.jpcadinelli.JavaFilmes.controller.FilmeModelInterface;
import br.com.jpcadinelli.JavaFilmes.controller.dto.FilmeRequestDTO;
import br.com.jpcadinelli.JavaFilmes.controller.dto.FilmeResponseDTO;
import br.com.jpcadinelli.JavaFilmes.model.Filme;
import br.com.jpcadinelli.JavaFilmes.repository.FilmeRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Primary
public class FilmeService implements FilmeModelInterface {

    private final FilmeRepository repository;

    public FilmeService(FilmeRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<FilmeResponseDTO> listarTodos(String titulo, String diretor, Integer anoLancamento) {
        return repository.findAll().stream()
                .filter(f -> titulo == null || f.getTitulo().toLowerCase().contains(titulo.toLowerCase()))
                .filter(f -> diretor == null || f.getDiretor().toLowerCase().contains(diretor.toLowerCase()))
                .filter(f -> anoLancamento == null || f.getAnoLancamento() == anoLancamento)
                .map(f -> new FilmeResponseDTO(f.getId(), f.getTitulo(), f.getDiretor(), f.getAnoLancamento()))
                .collect(Collectors.toList());
    }


    @Override public FilmeResponseDTO buscarPorId(Long id) {
        Filme filme = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Filme não encontrado"));
        return new FilmeResponseDTO(filme.getId(), filme.getTitulo(), filme.getDiretor(), filme.getAnoLancamento());
    }

    @Override public FilmeResponseDTO criar(FilmeRequestDTO dto) {
        Filme filme = new Filme(null, dto.getTitulo(), dto.getDiretor(), dto.getAnoLancamento());
        repository.save(filme);
        return new FilmeResponseDTO(filme.getId(), filme.getTitulo(), filme.getDiretor(), filme.getAnoLancamento());
    }

    @Override public FilmeResponseDTO atualizar(Long id, FilmeRequestDTO dto) {
        Filme filme = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Filme não encontrado"));
        filme.setTitulo(dto.getTitulo());
        filme.setDiretor(dto.getDiretor());
        filme.setAnoLancamento(dto.getAnoLancamento());
        repository.save(filme);
        return new FilmeResponseDTO(filme.getId(), filme.getTitulo(), filme.getDiretor(), filme.getAnoLancamento());
    }

    @Override public void deletar(Long id) {
        repository.deleteById(id);
    }
}
