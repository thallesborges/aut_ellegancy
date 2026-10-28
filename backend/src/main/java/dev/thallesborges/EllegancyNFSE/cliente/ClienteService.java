package dev.thallesborges.EllegancyNFSE.cliente;

import dev.thallesborges.EllegancyNFSE.cliente.cep.CepInvalidoException;
import dev.thallesborges.EllegancyNFSE.cliente.cep.CepService;
import dev.thallesborges.EllegancyNFSE.cliente.cpf.CpfInvalidoException;
import dev.thallesborges.EllegancyNFSE.cliente.cpf.CpfValidator;
import dev.thallesborges.EllegancyNFSE.exception.ResourceExistenteException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ClienteService {
    private final ClienteRepository clienteRepository;
    private final CepService cepService;

    public ClienteResponse cadastrarCliente(CadastrarClienteRequest request) {
        if (clienteRepository.existsByCpf(request.cpf())) {
            throw new ResourceExistenteException("CPF já existente no sistema: " + request.cpf());
        }

        String cpf = request.cpf().replaceAll("\\D", "");
        if (cpf.length() != 11) {
            throw new CpfInvalidoException("CPF não contem exatamente 11 dígitos numéricos: " + cpf);
        } else if (!CpfValidator.isValido(cpf)) {
            throw new CpfInvalidoException("CPF inválido: " + cpf);
        }

        String cep = request.cep().replaceAll("\\D", "");
        if (cep.length() != 8) {
            throw new CepInvalidoException("CEP não contem exatamente 8 dígitos numéricos: " + cep);
        } else if (!cepService.validarCepExistente(cep)) {
            throw new CepInvalidoException("CEP inválido: " + cep);
        }

        ClienteEntity novoCliente = ClienteEntity.builder()
                .nome(request.nome())
                .cpf(cpf)
                .cep(cep)
                .numero_residencia(request.numero_residencia())
                .build();

        ClienteEntity cliente = clienteRepository.save(novoCliente);

        return new ClienteResponse(
                cliente.getId(),
                cliente.getNome(),
                cliente.getCpf(),
                cliente.getCep(),
                cliente.getNumero_residencia(),
                cliente.getAtivo(),
                cliente.getCriadoEm(),
                cliente.getAtualizadoEm()
        );
    }
}
