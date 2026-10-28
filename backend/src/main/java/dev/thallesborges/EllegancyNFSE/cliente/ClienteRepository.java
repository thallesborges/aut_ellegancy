package dev.thallesborges.EllegancyNFSE.cliente;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<ClienteEntity, Long> {
    boolean existsByCpf(String cpf);
}
