package br.com.jpcadinelli.JavaFilmes.controller.dto;

public class FilmeResponseDTO {
    private Long id;
    private String titulo;
    private String diretor;
    private int anoLancamento;

    public FilmeResponseDTO(Long id, String titulo, String diretor, int anoLancamento) {
        this.id = id;
        this.titulo = titulo;
        this.diretor = diretor;
        this.anoLancamento = anoLancamento;
    }

    public Long getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDiretor() {
        return diretor;
    }

    public int getAnoLancamento() {
        return anoLancamento;
    }
}
