package br.com.fiap.cp1_api2.repository;

import br.com.fiap.cp1_api2.model.Aparelho;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AparelhoRepository extends JpaRepository<Aparelho, Long> {
}
