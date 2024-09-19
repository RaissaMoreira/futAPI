package jogos.futebol.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.transaction.Transactional;
import jogos.futebol.demo.model.Jogador;
import jogos.futebol.demo.repository.JogadorRepository;

@RestController
@RequestMapping("/jogador")
public class JogadorController {
  @Autowired
  JogadorRepository rep;

  @PostMapping
  @Transactional
  public ResponseEntity<Jogador> create(@RequestBody Jogador jogador) {
    try {
      Jogador a = rep.save(new Jogador(jogador.getCod_jogador(), jogador.getNome(), jogador.getEmail(), jogador.getDatanasc()));
      // Jogador a = rep.save(new Jogador(jogador.getCod_jogador(), jogador.getNome(), jogador.getEmail(), jogador.getDatanasc()));
      return new ResponseEntity<>(a, HttpStatus.CREATED);

    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
}
