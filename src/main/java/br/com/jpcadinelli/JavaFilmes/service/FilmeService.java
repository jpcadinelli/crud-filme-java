package br.com.jpcadinelli.JavaFilmes.service;

import br.com.jpcadinelli.JavaFilmes.dto.FilmeRequestDTO;
import br.com.jpcadinelli.JavaFilmes.dto.FilmeResponseDTO;
import br.com.jpcadinelli.JavaFilmes.model.Filme;
import br.com.jpcadinelli.JavaFilmes.repository.FilmeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FilmeService {

    private final FilmeRepository repository;

    public FilmeService(FilmeRepository repository) {
        this.repository = repository;
    }

    public List<FilmeResponseDTO> listarTodos() {
        return repository.findAll().stream()
                .map(f -> new FilmeResponseDTO(f.getId(), f.getTitulo(), f.getDiretor(), f.getAnoLancamento()))
                .collect(Collectors.toList());
    }

    public FilmeResponseDTO buscarPorId(Long id) {
        Filme filme = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Filme não encontrado"));
        return new FilmeResponseDTO(filme.getId(), filme.getTitulo(), filme.getDiretor(), filme.getAnoLancamento());
    }

    public FilmeResponseDTO criar(FilmeRequestDTO dto) {
        Filme filme = new Filme(null, dto.getTitulo(), dto.getDiretor(), dto.getAnoLancamento());
        repository.save(filme);
        return new FilmeResponseDTO(filme.getId(), filme.getTitulo(), filme.getDiretor(), filme.getAnoLancamento());
    }

    public FilmeResponseDTO atualizar(Long id, FilmeRequestDTO dto) {
        Filme filme = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Filme não encontrado"));
        filme.setTitulo(dto.getTitulo());
        filme.setDiretor(dto.getDiretor());
        filme.setAnoLancamento(dto.getAnoLancamento());
        repository.save(filme);
        return new FilmeResponseDTO(filme.getId(), filme.getTitulo(), filme.getDiretor(), filme.getAnoLancamento());
    }

    public void deletar(Long id) {
        repository.deleteById(id);
    }
}
