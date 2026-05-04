package br.com.fiap.cp1_api2.model;

import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "tb_aparelhos")
public class Aparelho {
    @Id
    @Column(name = "id_aparelho")
    private Long idAparelho;

    @Column(name = "nm_aparelho")
    private String nmAparelho;
    @Column(name = "vl_aparelho")
    private double vlAparelho;
    @Column(name = "marca")
    private String marca;

    @Nullable
    @Column(name = "cor")
    private String cor;

    public Aparelho(){}
}
