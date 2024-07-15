package br.forumhub.api.api.topico;

import java.time.LocalDateTime;

public record DetalhamentoTopicoDTO(

        Long id,

        String titulo,

        String mensagem,

        LocalDateTime dataCriacao,

        Boolean status,

        String autor,

        String curso
) {
    public DetalhamentoTopicoDTO(Topico topico) {
        this(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensagem(),
                topico.getDataCriacao(),
                topico.getStatus(),
                topico.getAutor(),
                topico.getCurso()
        );
    }
}
