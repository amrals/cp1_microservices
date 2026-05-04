package br.com.fiap.cp1_api2.model;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
@Table(name = "tb_funcionarios")
public class Funcionario {
    @Id
    @Column(name = "id_funcionario")
    private Long idFuncionario;

    @Column(name = "nm_funcionario")
    private String nmFuncionario;
    @Column(name = "funcao")
    private String funcao;
    @Column(name = "dt_admissao")
    private LocalDateTime dtAdmissao;
    @Nullable
    @Column(name = "dt_demissao")
    private LocalDateTime dtDemissao;

    public Funcionario(){}
}
