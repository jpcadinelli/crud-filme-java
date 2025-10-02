package br.com.jpcadinelli.JavaFilmes.controller;

import br.com.jpcadinelli.JavaFilmes.dto.FilmeRequestDTO;
import br.com.jpcadinelli.JavaFilmes.dto.FilmeResponseDTO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/filmes")
public class FilmeController {

    @Autowired
    private final FilmeModelInterface model;
    public FilmeController ( FilmeModelInterface model) {this.model = model;}

    @GetMapping
    public List<FilmeResponseDTO> listarTodos() {
        return model.listarTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<FilmeResponseDTO> buscarPorId(@PathVariable Long id) {
        return ResponseEntity.ok(model.buscarPorId(id));
    }

    @PostMapping
    public ResponseEntity<FilmeResponseDTO> criar(@Valid @RequestBody FilmeRequestDTO dto) {
        return ResponseEntity.ok(model.criar(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<FilmeResponseDTO> atualizar(@PathVariable Long id, @Valid @RequestBody FilmeRequestDTO dto) {
        return ResponseEntity.ok(model.atualizar(id, dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        model.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
