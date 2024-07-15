package br.forumhub.api.api.topico;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "topicos")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String titulo;

    @Column(unique = true)
    private String mensagem;

    @Column(name = "data_criacao")
    private LocalDateTime dataCriacao;

    private Boolean status;

    private String Autor;

    private String curso;

    public Topico(TopicoDTO dadosTopico) {
        this.titulo = dadosTopico.titulo();
        this.mensagem = dadosTopico.mensagem();
        this.dataCriacao = LocalDateTime.now();
        this.status = true;
        this.Autor = dadosTopico.autor();
        this.curso = dadosTopico.curso();
    }

    public void atualizarTopico(AtualizacaoTopicoDTO novosDados) {
        if (novosDados.titulo() != null) {
            this.titulo = novosDados.titulo();
        }

        if (novosDados.mensagem() != null) {
            this.mensagem = novosDados.mensagem();
        }
        if (novosDados.autor() != null) {
            this.Autor = novosDados.autor();
        }
        if (novosDados.curso() != null) {
            this.curso = novosDados.curso();
        }
    }
}
