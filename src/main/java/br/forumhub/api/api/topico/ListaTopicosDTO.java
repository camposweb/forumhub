package br.forumhub.api.api.topico;

import java.time.LocalDateTime;

public record ListaTopicosDTO(

        String titulo,

        String mensagem,

        LocalDateTime dataCriacao,

        Boolean status,

        String autor,

        String curso
) {

    public ListaTopicosDTO(Topico topico) {
        this(
                topico.getTitulo(),
                topico.getMensagem(),
                topico.getDataCriacao(),
                topico.getStatus(),
                topico.getAutor(),
                topico.getCurso()
        );
    }
}
