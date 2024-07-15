package br.forumhub.api.api.topico;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository topicoRepository;

    @PostMapping
    @Transactional
    public ResponseEntity cadastrarTopico(@RequestBody @Valid TopicoDTO dadosTopico, UriComponentsBuilder uriBuilder) {
        var topico = new Topico(dadosTopico);
        topicoRepository.save(topico);

        var uri = uriBuilder.path("/topicos/{id}").buildAndExpand(topico.getId()).toUri();

        return ResponseEntity.created(uri).body(new DetalhamentoTopicoDTO(topico));
    }

    @GetMapping
    public ResponseEntity<Page<ListaTopicosDTO>> listarTopicos(@PageableDefault(size = 10, sort = {"dataCriacao"}) Pageable paginacao) {
        var page = topicoRepository.findByStatusTrue(paginacao).map(ListaTopicosDTO::new);

        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    @Transactional
    public ResponseEntity<ListaTopicosDTO> detalhamentoTopico(@PathVariable Long id) {
        var topico = topicoRepository.getReferenceById(id);

        return ResponseEntity.ok(new ListaTopicosDTO(topico));
    }

    @PutMapping
    @Transactional
    public ResponseEntity<DetalhamentoTopicoDTO> atualizarTopico(@RequestBody @Valid AtualizacaoTopicoDTO dados) {
        var topico = topicoRepository.getReferenceById(dados.id());

        topico.atualizarTopico(dados);

        return ResponseEntity.ok(new DetalhamentoTopicoDTO(topico));
    }
}
