package br.com.jpcadinelli.JavaFilmes.controller;

import br.com.jpcadinelli.JavaFilmes.dto.FilmeRequestDTO;
import br.com.jpcadinelli.JavaFilmes.dto.FilmeResponseDTO;

import java.util.List;

public interface FilmeModelInterface {
    List<FilmeResponseDTO> listarTodos();
    FilmeResponseDTO buscarPorId(Long id);
    FilmeResponseDTO criar(FilmeRequestDTO dto);
    FilmeResponseDTO atualizar(Long id, FilmeRequestDTO dto);
    void deletar(Long id);
}
