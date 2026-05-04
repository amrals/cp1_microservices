package br.com.fiap.cp1_api2.repository;

import br.com.fiap.cp1_api2.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {
}
