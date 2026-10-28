package dev.thallesborges.EllegancyNFSE.cliente.cep;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

@Service
public class CepService {
    private final RestClient restClient;

    public CepService() {
        this.restClient = RestClient.create("https://viacep.com.br/ws");
    }

    public boolean validarCepExistente(String cep) {
            ViaCepResponse response = restClient.get()
                    .uri("/{cep}/json", cep)
                    .retrieve()
                    .body(ViaCepResponse.class);

            return response != null && !Boolean.TRUE.equals(response.erro());
    }
}
