package br.com.jpcadinelli.JavaFilmes.controller;

import br.com.jpcadinelli.JavaFilmes.controller.dto.FilmeRequestDTO;
import br.com.jpcadinelli.JavaFilmes.controller.dto.FilmeResponseDTO;

import java.util.List;

public interface FilmeModelInterface {
    List<FilmeResponseDTO> listarTodos(String titulo, String diretor, Integer anoLancamento);
    FilmeResponseDTO buscarPorId(Long id);
    FilmeResponseDTO criar(FilmeRequestDTO dto);
    FilmeResponseDTO atualizar(Long id, FilmeRequestDTO dto);
    void deletar(Long id);
}
