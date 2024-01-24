package desafio.com.TabelaFIPE.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Veiculo(
        Integer TipoVeiculo,
        String Valor,
        String Marca,
        Integer AnoModelo,
        String Combustivel,
        String CodigoFipe) {
}
