package br.forumhub.api.api.topico;

import jakarta.validation.constraints.NotNull;

public record AtualizacaoTopicoDTO (
        @NotNull
        Long id,

        String titulo,

        String mensagem,

        String autor,

        String curso
) {
}
