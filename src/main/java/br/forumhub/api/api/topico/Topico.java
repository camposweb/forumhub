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
}
