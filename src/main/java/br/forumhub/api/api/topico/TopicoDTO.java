package br.forumhub.api.api.topico;

import jakarta.validation.constraints.NotBlank;

public record TopicoDTO(

        @NotBlank
        String titulo,

        @NotBlank
        String mensagem,

        @NotBlank
        String autor,

        @NotBlank
        String curso
) {
}
