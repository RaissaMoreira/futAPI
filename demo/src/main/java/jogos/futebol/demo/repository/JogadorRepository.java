package jogos.futebol.demo.repository;
import jogos.futebol.demo.model.Jogador;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface JogadorRepository extends JpaRepository<Jogador, Long> {
    List<Jogador> findByNomeContaining(String nome);
}
