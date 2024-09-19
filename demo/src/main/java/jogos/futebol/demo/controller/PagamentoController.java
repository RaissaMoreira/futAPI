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
import org.springframework.web.bind.annotation.RestController;
import jakarta.transaction.Transactional;
import jogos.futebol.demo.DTO.PagamentoDTO;
import jogos.futebol.demo.model.Jogador;
import jogos.futebol.demo.model.Pagamento;
import jogos.futebol.demo.repository.JogadorRepository;
import jogos.futebol.demo.repository.PagamentoRepository;

@RestController
@RequestMapping("/pagamento")
public class PagamentoController {
  @Autowired
  PagamentoRepository rep;
  @Autowired
  JogadorRepository repJogador;

  @PostMapping
  @Transactional
  public ResponseEntity<HttpStatus> createPagamento(@RequestBody PagamentoDTO pagamento) {
    try {

      if(pagamento.cod_jogador() > 0){
        Optional<Jogador> jogador = repJogador.findById(pagamento.cod_jogador());

        if (jogador.isPresent()) {
          rep.save(new Pagamento(pagamento.cod_pagamento(), pagamento.ano(), pagamento.mes(), pagamento.valor(), jogador.get()));
        }
      }
      
      return new ResponseEntity<>(HttpStatus.CREATED);

    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @GetMapping("/{id}")
  public ResponseEntity<Optional<Pagamento>> getPagamento(@PathVariable("id") long id) {
    try {
      Optional<Pagamento> pagamento = rep.findById(id);
      if(pagamento.isPresent()) 
        return new ResponseEntity<>(pagamento, HttpStatus.OK);

      return new ResponseEntity<>(pagamento, HttpStatus.NOT_FOUND);

    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @GetMapping("/")
  public ResponseEntity<List<Pagamento>> getAllPagamento() {
    try {
      List<Pagamento> pagamentos = rep.findAll();
      return new ResponseEntity<>(pagamentos, HttpStatus.OK);

    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @DeleteMapping("/{id}")
  public ResponseEntity<HttpStatus> deletePagamento(@PathVariable("id") long id) {
    try {
      if(rep.existsById(id)) {
        rep.deleteById(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
      }

      return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    } catch (Exception e) {
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }

  @PutMapping("/{id}")
  public ResponseEntity<Pagamento> editarPagamento(@PathVariable("id") long id, @RequestBody PagamentoDTO pagamento) {
    try {
      Optional<Pagamento> data = rep.findById(id);

      if (data.isPresent()) {
        Pagamento temp = data.get();

        if(pagamento.ano() > 0)
          temp.setAno(pagamento.ano());

        if(pagamento.mes() > 0)
          temp.setMes(pagamento.mes());

        if(pagamento.valor() > 0)
          temp.setValor(pagamento.valor());

        if(pagamento.cod_jogador() > 0){
          Optional<Jogador> jogador = repJogador.findById(pagamento.cod_jogador());

          if (jogador.isPresent()) {
            temp.setJogador(jogador.get());
          }
        }

        return new ResponseEntity<>(rep.save(temp), HttpStatus.OK);
      }

      return new ResponseEntity<>(HttpStatus.NOT_FOUND);

    } catch (Exception e) {
      System.out.println(e.getMessage());
      return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
  }
}
