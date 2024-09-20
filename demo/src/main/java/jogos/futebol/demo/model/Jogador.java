package jogos.futebol.demo.model;

import java.util.Date;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table
public class Jogador {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long cod_jogador;

  @Column(nullable = false, length = 60)
  private String nome;

  @Column(nullable = false, length = 60)
  private String email;

  @Column(nullable = false)
  private Date datanasc;

  @OneToMany(cascade = CascadeType.ALL, mappedBy = "jogador")
  private List<Pagamento> pagamento;

  public Jogador() {};

  public Jogador(long cod_jogador, String nome, String email, Date datanasc) {
    this.cod_jogador = cod_jogador;
    this.nome = nome;
    this.email = email;
    this.datanasc = datanasc;
  }
  
  public long getCod_jogador() {
    return cod_jogador;
  }
  public void setCod_jogador(long cod_jogador) {
    this.cod_jogador = cod_jogador;
  }
  public String getNome() {
    return nome;
  }
  public void setNome(String nome) {
    this.nome = nome;
  }
  public String getEmail() {
    return email;
  }
  public void setEmail(String email) {
    this.email = email;
  }
  public Date getDatanasc() {
    return datanasc;
  }
  public void setDatanasc(Date datanasc) {
    this.datanasc = datanasc;
  }
}
