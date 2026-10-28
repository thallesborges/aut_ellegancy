package dev.thallesborges.EllegancyNFSE.cliente;

import dev.thallesborges.EllegancyNFSE.auditoria.AuditoriaEntity;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity
@Table(name = "cliente")
public class ClienteEntity extends AuditoriaEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false, unique = true)
    private String cpf;

    @Column(nullable = false)
    private String cep;

    @Column(nullable = false)
    private String numero_residencia;

    @Builder.Default
    @Column(nullable = false)
    private Boolean ativo = true;
}
