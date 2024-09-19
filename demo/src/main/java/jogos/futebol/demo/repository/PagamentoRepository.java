package jogos.futebol.demo.repository;
import jogos.futebol.demo.model.Pagamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PagamentoRepository extends JpaRepository<Pagamento, Long> {
  
}
