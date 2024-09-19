package jogos.futebol.demo.repository;
import jogos.futebol.demo.model.Jogador;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JogadorRepository extends JpaRepository<Jogador, Long> {
  
}
