package jogos.futebol.demo.controller;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
  public ResponseEntity<HttpStatus> createJogador(@RequestBody Jogador jogador) {
    try {
      rep.save(new Jogador(jogador.getCod_jogador(), jogador.getNome(), jogador.getEmail(), jogador.getDatanasc()));
      return new ResponseEntity<>(HttpStatus.CREATED);

    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @GetMapping("/{id}")
  public ResponseEntity<Optional<Jogador>> getJogador(@PathVariable("id") long id) {
    try {
      Optional<Jogador> jogador = rep.findById(id);
      if(jogador.isPresent()) 
        return new ResponseEntity<>(jogador, HttpStatus.OK);

      return new ResponseEntity<>(jogador, HttpStatus.NOT_FOUND);

    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @GetMapping("/buscar")
  public ResponseEntity<List<Jogador>> getJogadorByName(@RequestParam(name="nome") String nome) {
    try {
      List<Jogador> jogadores = rep.findByNomeContaining(nome);
      return new ResponseEntity<>(jogadores, HttpStatus.OK);

    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @GetMapping("/")
  public ResponseEntity<List<Jogador>> getAllJogador() {
    try {
      List<Jogador> jogadores = rep.findAll();
      return new ResponseEntity<>(jogadores, HttpStatus.OK);

    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<HttpStatus> deleteJogador(@PathVariable("id") long id) {
    try {
      if(rep.existsById(id)) {
        rep.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
      }

      return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    } catch (Exception e) {
      System.out.println(e.getMessage());
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @PutMapping("/{id}")
  public ResponseEntity<Jogador> editarJogador(@PathVariable("id") long id, @RequestBody Jogador jogador) {
    try {
      Optional<Jogador> data = rep.findById(id);

      if (data.isPresent()) {
        Jogador temp = data.get();

        if(jogador.getNome() != null)
          temp.setNome(jogador.getNome());

        if(jogador.getEmail() != null)
          temp.setEmail(jogador.getEmail());
        
        if(jogador.getDatanasc() != null)
          temp.setDatanasc(jogador.getDatanasc());

        return new ResponseEntity<>(rep.save(temp), HttpStatus.OK);
      }

      return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    } catch (Exception e) {
      System.out.println(e.getMessage());
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
}
