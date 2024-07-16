package br.forumhub.api.api.usuario;

import br.forumhub.api.api.infra.security.TokenJwtDTO;
import br.forumhub.api.api.infra.security.TokenService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/login")
public class AutenticacaoController {

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @PostMapping
    public ResponseEntity<TokenJwtDTO> efetuarLogin(@RequestBody @Valid AutenticacaoDTO dadosAutenticacao) {
        var authToken = new UsernamePasswordAuthenticationToken(dadosAutenticacao.email(), dadosAutenticacao.senha());
        var auth = authenticationManager.authenticate(authToken);

        var tokenJWT = tokenService.gerarToken((Usuario) auth.getPrincipal());

        return ResponseEntity.ok(new TokenJwtDTO(tokenJWT));
    }
}
