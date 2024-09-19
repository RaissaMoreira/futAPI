package jogos.futebol.demo.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table
public class Pagamento {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long cod_pagamento;

  @Column(nullable = false)
  private short ano;

  @Column(nullable = false)
  private short mes;

  @Column(nullable = false)
  private float valor;

  @ManyToOne
  private Jogador jogador;

  public Pagamento() {}

  public Pagamento(long cod_pagamento, short ano, short mes, float valor, Jogador jogador) {
    this.cod_pagamento = cod_pagamento;
    this.ano = ano;
    this.mes = mes;
    this.valor = valor;
    this.jogador = jogador;
  }

  public long getCod_pagamento() {
    return cod_pagamento;
  }

  public void setCod_pagamento(long cod_pagamento) {
    this.cod_pagamento = cod_pagamento;
  }

  public short getAno() {
    return ano;
  }

  public void setAno(short ano) {
    this.ano = ano;
  }

  public short getMes() {
    return mes;
  }

  public void setMes(short mes) {
    this.mes = mes;
  }

  public float getValor() {
    return valor;
  }

  public void setValor(float valor) {
    this.valor = valor;
  }

  public Jogador getJogador() {
    return jogador;
  }

  public void setJogador(Jogador jogador) {
    this.jogador = jogador;
  };
}
